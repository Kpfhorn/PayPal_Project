<%-- 
    Document   : createPathway
    Created on : Dec 2, 2019, 1:05:07 PM
    Author     : kpfho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Pathway</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>

    </head>
    <body>
        <div class="sidenav">
            <h2>Lunge Marketplace</h2>
            <a href="profile.jsp" id="user">Profile</a>
            <a href="storefront.jsp">Store</a>
            <a href="LogoutServlet">Logout</a>
        </div>
        <div class="main">
            <h1>Create New Pathway</h1>
            Pathway Name<input id="pw_name" type="text"/><br/>
            Pathway Type<input id="pw_type" type="text"/><br/>
            Pathway Price<input id="pw_price" type="text"/><br/>
            <div id="profiles"></div>
            <button onclick="addProfile()">Add Profile</button>
            <button onclick="create()">Create Pathway</button>
        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
                let profileCounter = 0;
                let categoryCounter = 0;
                let profilecategories = [];
                let profiles = [];
                const addProfile = function () {
                    profileCounter += 1;
                    $('#profiles').append(
                            "<div id=\"profile" + profileCounter + "\">\n" +
                            "Profile Name: <input type=\"text\" id=\"pn" + profileCounter + "\"/><br/>" +
                            "Profile Description: <input type=\"text\" id=\"pd" + profileCounter + "\"/><br/>" +
                            "<div id=\"categories_pf" + profileCounter + "\" class='category'></div>" +
                            "<button onclick='addCategory(" + profileCounter + ")'>Add Category</button>" +
                            "</div>"
                            );
                };
                const addCategory = function (id) {
                    categoryCounter += 1;
                    cnt = categoryCounter;
                    tmp = {
                        profile_id: id,
                        category_id: cnt
                    };
                    profilecategories.push(tmp);
                    $('#categories_pf' + id).append(
                            "<div id='category" + cnt + "' class='categories'>\n" +
                            "Category Name: <input type='text' id='ctn" + cnt + "'/><br/>" +
                            "Category Description: <input type='text' id='ctd" + cnt + "'/><br/>" +
                            "</div>"
                            );
                };

                const createCategories = function (localID) {
                    console.log("called");
                    let profileID = 0;
                    console.log(profiles);
                    for (p in profiles) {
                        if (profiles[p].localID === localID) {
                            profileID = profiles[p].profileID;
                        }
                    }
                    console.log(profileID);
                    if (profileID !== 0) {
                        for (i in profilecategories) {
                            c = profilecategories[i]
                            if (c.profile_id === localID) {
                                let id = c.category_id;
                                let name = $('#ctn' + id).val();
                                let desc = $('#ctd' + id).val();
                                $.ajax("CategoryServlet", {
                                    method: 'GET',
                                    data: {
                                        name: name,
                                        desc: desc,
                                        cid: id,
                                        pid: profileID
                                    },
                                    success: (data) => {
                                        console.log(data);
                                        window.location.href = "profile.jsp";
                                    },
                                    error: (jxqhr, status, thrown) => {
                                        console.log(status);
                                        console.log(thrown);
                                    }
                                })
                            }
                        }
                    }
                }

                const create = function () {
                    let name = $('#pw_name').val();
                    let type = $('#pw_type').val();
                    let price = $('#pw_price').val();
                    $.ajax("PathwayServlet", {
                        method: 'GET',
                        data: {
                            name: name,
                            type: type,
                            price: price
                        },
                        success: (data) => {
                            let regimeID = data;
                            if (profileCounter > 0) {
                                for (i = profileCounter; i > 0; i--) {
                                    let iter = i;
                                    let p_name = $('#pn' + i).val();
                                    let p_desc = $('#pd' + i).val();
                                    $.ajax("ProfileServlet", {
                                        method: 'GET',
                                        data: {
                                            rid: regimeID,
                                            pid: i,
                                            name: p_name,
                                            description: p_desc
                                        },
                                        success: (data) => {
                                            console.log(data);
                                            let tmp = {
                                                localID: iter,
                                                profileID: data
                                            }
                                            profiles.push(tmp);
                                            createCategories(iter);
                                        },
                                        error: (jxqhr, status, thrown) => {
                                            console.log(status);
                                            console.log(thrown);
                                        }
                                    })
                                }
                            }
//                            window.location.href = "profile.jsp";
                        },
                        error: (jxqhr, status, thrown) => {
                            console.log(status);
                            console.log(thrown);
                        }
                    })
                }
        </script>
    </body>
</html>
