<%-- 
    Document   : storefront
    Created on : Nov 21, 2019, 12:48:01 PM
    Author     : kpfho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Storefront</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div class="sidenav">
            <h2>Lunge Marketplace</h2>
            <a href="login.html" id="user">Login</a>
            <a href="storefront.jsp">Store</a>
        </div>
        <div class="main">

        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            let checklogin = () => {
                const uid = "<% out.print(session.getAttribute("user"));%>"
                if (uid !== null) {
                    $("#user").text("Profile");
                    $("#user").attr("href", "profile.jsp")
                }
            }
            checklogin();
        </script>
    </body>
</html>
