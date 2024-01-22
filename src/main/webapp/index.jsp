<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="se">
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<%--<form action="/invoice" method="POST">--%>
<%--    <label>Title</label>--%>
<%--    <input type="text" name="title"/>--%>

<%--    <br>--%>

<%--    <label>Content</label>--%>
<%--    <textarea name="content"></textarea>--%>

<%--    <button>Submit</button>--%>
<%--</form>--%>
<a href="/newInvoice.jsp">Add a new invoice</a>
<form method="POST" action="/auth/logout">
    <button>Logout</button>
</form>
</body>
</html>