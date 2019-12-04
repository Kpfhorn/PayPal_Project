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
            Goal: <input type="text" id="goalName"/><br/>
            <div id="activities">
                Activity: <input type="text" id="activityName1"/><br/>
            </div>
            <button onclick="addActivity()">Add Activity</button><br/>
            Outcome: <input type="text" id="outcomeName"/>
            <button onclick="create()">Add</button>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
                let activityCounter = 1;
                const addActivity = function () {
                    activityCounter += 1;
                    $("#activities").append("Activity: <input type='text' id='activityName" + activityCounter + "'/><br/>");
                }
                const create = function () {
                    let goalName = $("#goalName").val();
                    $.ajax("GoalServlet", {
                        method: 'GET',
                        data: {
                            name: goalName,
                            pcid: ${pcid}
                        },
                        success: (data) => {
                            let arr = data.split("\n");
                            let pcgID = arr[0];
                            let rmID = arr[1];
                            console.log(arr);
                            let outcome = $('#outcomeName').val();
                            $.ajax("OutcomeServlet", {
                                method: 'GET',
                                data: {
                                    name: outcome,
                                    pcgid: pcgID
                                },
                                success: (data) => {
                                    console.log("outcomeData" + data);
                                }
                            })
                            let activities = []
                            for (i = 1; i <= activityCounter; i++) {
                                let dt = {
                                    name: $("#activityName" + i).val(),
                                    rmID: rmID
                                }
                                $.ajax("ActivityServlet", {
                                    method: 'GET',
                                    data: dt,
                                    success: (data) => {
                                        console.log(data);
                                    }
                                })


                            }
                            history.back();
                        }
                    })

                }
        </script>
    </body>
</html>
