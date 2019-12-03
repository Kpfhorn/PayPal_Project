<%-- 
    Document   : viewPathway
    Created on : Dec 3, 2019, 1:36:19 AM
    Author     : kpfho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Pathway</title>
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
            <h1>View Pathway</h1>
            Name: <label id="pw_name"></label><br/>
            Type: <label id="pw_type"></label><br/>
            <div id="profiles"></div>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            let profilecategories = [];

            const addGoal = function (pcid) {
                window.location.href = "addGoal.jsp?pcid=" + pcid;
            };
            $.ajax("resources/regime/${id}", {
                method: 'GET',
                success: (data) => {
                    $('#pw_name').html(data.regimeName);
                    $('#pw_type').html(data.regimeTYPE);
                    $.ajax("resources/regime/${id}/profiles", {
                        method: 'GET',
                        success: (data) => {
                            for (p in data) {
                                console.log(p);
                                let pid = data[p].profileID;
                                $('#profiles').append(
                                        "<div id='profile" + data[p].profileID + "'>" +
                                        "Profile Name: " + data[p].profileName + "<br/>" +
                                        "Profile Description: " + data[p].description + "<br/>" +
                                        "<div id='pf" + data[p].profileID + "_categories' class='categories'>" +
                                        "Categories <br/>" +
                                        "</div>" +
                                        "</div>"
                                        );
                                $.ajax("resources/profiles/" + data[p].profileID + "/profilecategories", {
                                    method: 'GET',
                                    success: (data) => {
                                        profilecategories = data;
                                        for (i in data) {
                                            let pc = data[i];
                                            let c = pc.categoryID;
                                            $('#pf' + pid + '_categories').append(
                                                    "Category Name: " + c.categoryName + "<br/>" +
                                                    "Category Description: " + c.description + "<br/>"
                                                    + "<button onclick='addGoal(" + pc.profileCategoryID + ")'>Add Goal</button><br/>"
                                                    );
                                        }

                                    }
                                });
                            }
                        }
                    });
                }
            });
        </script>
    </body>
</html>
