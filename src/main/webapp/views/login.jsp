<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="com.f1management.model.Member" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Login - F1 Management</title>
        <base href="${pageContext.request.contextPath}/">
        <link rel="stylesheet" href="css/styleLogin.css">
    </head>
    <body class="page-center">
        <div class="card login-card">
            <h1 class="card-title">Login</h1>
            
            <% 
                String error = (String) request.getAttribute("loginError");
                if (error != null) { 
            %>
                <script>
                    alert("<%= error %>");
                </script>
            <% } %>

            <form method="post" action="${pageContext.request.contextPath}/dologin">
                <div class="form-row">
                    <label for="username">username</label>
                    <input type="text" id="username" name="username" required >
                </div>
                
                <div class="form-row">
                    <label for="password">password</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <button type="submit" name="action" value="login" class="btn-login">login</button>

                <button type="submit" name="action" value="viewRanking" class="btn-viewRanking">view ranking</button>
            </form>
        </div>
    </body>
</html>