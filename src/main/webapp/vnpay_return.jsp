<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Kết quả thanh toán VNPay</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Kết quả thanh toán</h1>
    <c:choose>
        <c:when test="${isSuccess}">
            <p style="color: green; font-weight: bold;">Thanh toán thành công qua VNPay!</p>
            <p>Mã giao dịch VNPay: ${transId}</p>
        </c:when>
        <c:otherwise>
            <p style="color: red; font-weight: bold;">Thanh toán thất bại hoặc chữ ký không hợp lệ.</p>
        </c:otherwise>
    </c:choose>
    <p><a href="index.jsp">Quay lại trang chủ</a></p>
</body>
</html>