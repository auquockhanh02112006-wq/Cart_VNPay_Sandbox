package murach.cart;

import murach.business.Cart;
import murach.business.Product;
import murach.data.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/index.jsp";

        // get or create cart from session
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // get action
        String action = request.getParameter("action");
        if (action == null) {
            action = "index";
        }

        if (action.equals("add")) {
            String productCode = request.getParameter("productCode");
            Product product = ProductDB.getProduct(productCode);
            if (product != null) {
                cart.addItem(product);
            }
            url = "/cart.jsp";

        } else if (action.equals("update")) {
            String productCode = request.getParameter("productCode");
            String quantityStr = request.getParameter("quantity");
            try {
                int qty = Integer.parseInt(quantityStr);
                if (qty <= 0) {
                    cart.removeItem(productCode);
                } else {
                    cart.updateItem(productCode, qty);
                }
            } catch (NumberFormatException e) {
                // ignore invalid input
            }
            url = "/cart.jsp";

        } else if (action.equals("remove")) {
            String productCode = request.getParameter("productCode");
            cart.removeItem(productCode);
            url = "/cart.jsp";

        } else if (action.equals("viewCart")) {
            url = "/cart.jsp";

        } else if (action.equals("checkout")) {
            url = "/cart.jsp";   // placeholder: forward to checkout page

        } else if (action.equals("index")) {
            url = "/index.jsp";
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}