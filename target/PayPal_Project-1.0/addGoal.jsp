<%-- 
    Document   : addGoal
    Created on : Dec 3, 2019, 7:14:24 AM
    Author     : kpfho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Goal</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%
            int id = Integer.decode(request.getParameter("pcid"));
            pageContext.setAttribute("pcid", id);
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
            <h1>Add Goal</h1>
            Name: <input type="text" id="goalName"/>
            <button onclick="create()">Add</button>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
                const create = function () {
                    let name = $('#goalName').val();
                    let id = Math.floor(Math.random() * 100001);
                    let tmp = {
                                    goalName: name,
                                    goalID: id
                                }
                    $.ajax("resources/goals/" + id, {
                        method: 'GET',
                        success: () => {
                            $.ajax("resources/goals", {
                                method: 'POST',
                                data: JSON.stringify(tmp),
                                contentType: "application/json",
                                success: (data) => {
                                    let tmp2 = {
                                            profileCategoryGoalID: id,
                                            goalID: id,
                                            profileCategoryID: ${pcid}
                                        }
                                    $.ajax("resources/profilecategorygoals", {
                                        method: 'POST',
                                        data: JSON.stringify(tmp2),
                                        contentType: "application/json",
                                        success: (data) => {
                                            console.log('GOAL MADE');
                                        }

                                    })
                                }
                            })
                        }
                    })
                }
        </script>
    </body>
</html>
