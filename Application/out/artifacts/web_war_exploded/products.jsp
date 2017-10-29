<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.project.metier.IClientMetier" %>
<%@ page import="java.rmi.Naming" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.model.Product" %>
<%@ page import="java.rmi.NotBoundException" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Here you can buy & sell your products">
    <meta name="author" content="Ayoub Ed-dafali">
    <title>Products Store</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="assets/css/cover.css" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/mycss.css">
    <style>
        .navbar > .container, .navbar > .container-fluid{
            justify-content:space-around;
        }
    </style>
</head>

<body>
<%@include file="client_products_navbar.jsp" %>

<main role="main">
    <div class="container">
            <%
                ArrayList<Product> products = new ArrayList<Product>();
                String username = (String)session.getAttribute("username");
                String type = (String) session.getAttribute("type");
                try {
                    IClientMetier client = (IClientMetier) Naming.lookup("rmi://localhost/client");
                    products = client.getProducts(username, type);
                }catch (NotBoundException e){
                    System.out.println("Error getting client remote ");
                }
                StringBuilder p = new StringBuilder("<div class='row'>\n") ;
                for (Product product: products){
                    p.append("<div class='col-md-4 column productbox'>\n");
                    p.append("<img src='assets/img/image.png' class='img-responsive'>\n");
                            p.append("<div class='producttitle'>" + product.getName()  +"</div>\n");
                            p.append("<div class='producttitle'>" + product.getSeller()  +"</div>\n");
                            if (type.equalsIgnoreCase("client")) {
                                p.append("<div class='productprice'><form action='/purchase' method='post'><div class='pull-right'><button type='submit' class='btn btn-success btn-sm'>" +
                                        "Buy It</a></div><div class='pricetext'>" + product.getPrice() + "DH</div> <input name='product_id' type='hidden' value=" + product.getId() + "> </form></div>" +
                                        "</div>\n");
                            }else {
                                p.append("<div class='productprice'><div class='pricetext'>" + product.getPrice() + "DH</div></div>" +
                                        "</div>\n");
                            }
                        }
                    p.append("</div>");
                    out.print(p);
            %>
        </div>

</main>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="assets/js/jquery-3.2.1.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/myscript.js" > </script>
</body>
</html>
