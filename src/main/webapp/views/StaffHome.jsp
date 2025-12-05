<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "UTF-8">
        <title>Staff Home</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/styleStaffHome.css">
    </head>
    <body>
        <div class="container">
            <h2>Staff Home</h2>
            
            <a class="btn-manage" href="views/Manage.jsp">Manage</a>
            <a href="${pageContext.request.contextPath}/doupdate" class="btn-update">Update Result</a>
            <a class="btn-view" href="views/ViewRanking.jsp">View ranking</a>
        </div>
    <body>
</html>