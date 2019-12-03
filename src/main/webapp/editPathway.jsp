<%-- 
    Document   : editPathway
    Created on : Dec 2, 2019, 10:45:26 PM
    Author     : kpfho
--%>

<%@page import="java.util.Collection"%>
<%@page import="com.mycompany.paypal_project.db.Regime"%>
<%@page import="com.mycompany.paypal_project.db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Pathway</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%
            int id = Integer.decode(request.getParameter("id"));
            pageContext.setAttribute("id", id);
        %>
    </head>
    <body>
        <div class="sidenav">
            <h2>Lunge Marketplace</h2>
            <a href="profile.jsp" id="user">Profile</a>
            <a href="storefront.jsp">Store</a>
            <a href="LogoutServlet">Logout</a>
        </div>
        <div class="main">
            <h1>Edit Pathway</h1>
            Name: <input name="name" id="pw_name" type="text"/><br/>
            Type: <input name="type" id="pw_type" type="text"/><br/>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            let regime = {};
            $.ajax("resources/regime/${id}",{
                method: 'GET',
                success: (data) =>{
                    regime = data;
                    console.log(regime);
                    $('#pw_name').val(regime.regimeName);
                    $('#pw_type').val(regime.regimeTYPE);
                },
                error: (jxqhr, status, thrown) => {
                            console.log(status);
                            console.log(thrown);
                        }
            })
        </script>
    </body>
</html>
