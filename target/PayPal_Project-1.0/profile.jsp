<%-- 
    Document   : profile
    Created on : Nov 21, 2019, 2:58:58 PM
    Author     : kpfho
--%>

<%@page import="com.mycompany.paypal_project.db.Regime"%>
<%@page import="java.util.Collection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.mycompany.paypal_project.db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%
            User user = (User) session.getAttribute("user");
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
            <h1 id="name">Profile</h1>
            Name: <% out.print(user.getName());%>
            <h2>Your Pathways</h2>
            <button onclick="create()" hidden="true" id="create_pw">Create New Pathway</button>
            <div id="pathways">
            </div>

        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

        <script>
                        let checklogin = () => {
                            $.ajax("CheckLogin", {
                                method: 'GET',
                                success: (data) => {
                                    console.log(data);
                                    if (data.login === "True") {
                                        $("#user").text("Profile");
                                        $("#user").attr("href", "profile.jsp")
                                    }
                                },
                                error: (jxqhr, status, thrown) => {
                                    console.log(status);
                                    console.log(thrown);
                                    window.location.href = "storefront.jsp";
                                }
                            })
                        };
                        checklogin();
                        let isSeller = <% out.print(user.getIsSeller());%>;
                        if (isSeller) {
                            $("#create_pw").show();
                        }
                        let create = function () {
                            window.location.href = "createPathway.jsp"
                        }
                        let view = function (id) {
                            window.location.href = "viewPathway.jsp?id=" + id;
                        }
                        let del = function (id) {
                            $.ajax("resources/regime/" + id, {
                                method: 'DELETE',
                                success: () => {
                                    window.location.href = "profile.jsp";
                                }
                            })
                        }
                        $.ajax("resources/user/${user.userID}/pw", {
                            method: 'GET',
                            success: (data) => {
                                for (i in data) {
                                    let pw = data[i];
                                    $('#pathways').append(
                                            "Name: " + pw.regimeName + "<br/>" +
                                            "Type: " + pw.regimeTYPE + "<br/>" +
                                            "<button onclick='view(" + pw.regimeID + ")'>View</button>" +
                                            "<button onclick='del(" + pw.regimeID + ")'>Delete</button><br/>"
                                            )
                                }
                            }
                        })
        </script>

    </body>
</html>
