<%-- 
    Document   : buyPathway
    Created on : Dec 4, 2019, 12:42:58 AM
    Author     : kpfho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="style.css"/>
        <%
            int id = Integer.decode(request.getParameter("id"));
            pageContext.setAttribute("id", id);
        %>
        <title>Pathway Details</title>
    </head>
    <body>
        <div class="sidenav">
            <h2>Lunge Marketplace</h2>
            <a href="profile.jsp" id="user">Profile</a>
            <a href="storefront.jsp">Store</a>
            <a href="LogoutServlet">Logout</a>
        </div>
        <div class="main">
            <h1>Pathway Details</h1>
            Name: <label id="pw_name"></label><br/>
            Type: <label id="pw_type"></label><br/>
            Price: <label id="pw_price"></label><br/>
            <div id="pp_button"></div>
        </div>
        <script src="https://www.paypal.com/sdk/js?client-id=AeRFYy_Tr4PKELb7yQdyMG3CGoGdfUupP1dhhP2iYTeg5ipf9_5HbIQFe0-Cr0YaTD4Uoe-oCRRh811H"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            let regime = {};
            $.ajax("resources/regime/${id}", {
                method: 'GET',
                success: (dt) => {
                    $("#pw_name").html(dt.regimeName);
                    $('#pw_type').html(dt.regimeTYPE);
                    $('#pw_price').html("$" + dt.price);
                    paypal.Buttons({
                        createOrder: (data, actions) => {
                            return actions.order.create({
                                purchase_units: [{
                                        amount: {
                                            value: dt.price.toString()
                                        }
                                    }]
                            })
                        },
                        onApprove: (data, actions) => {
                            return actions.order.capture().then((details) => {
                                alert('Transaction completed by ' + details.payer.name.given_name);
                                return $.ajax('PurchaseServlet', {
                                    method: 'post',
                                    data: {
                                        orderID: data.orderID,
                                        regimeID: ${id}
                                    },
                                    success: ()=>{
                                        window.location.href = "storefront.jsp";
                                    }
                                })
                            })
                        }
                    }
                    ).render('#pp_button')
                }
            })

        </script>
    </body>
</html>
