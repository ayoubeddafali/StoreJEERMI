<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.project.model.Product" %>
<%@ page import="com.project.metier.IGrossisteMetier" %>
<%@ page import="java.rmi.Naming" %>
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
            String username = (String)session.getAttribute("username");
            ArrayList<Product>  buyed_products = new ArrayList<Product>();
            int total = 0 ;
            try {
                IGrossisteMetier grossiste = (IGrossisteMetier) Naming.lookup("rmi://localhost/grossiste");
                buyed_products = grossiste.getBuyedProducts(username);
                total = grossiste.getSumBuyedProducts(username);
            }catch (NotBoundException e){
                e.printStackTrace();
            }
            StringBuilder result = new StringBuilder("<table class=\"table table-striped\">\n");
            result.append(
                    "            <thead>\n" +
                            "            <tr>\n" +
                            "                <th>Product Name</th>\n"  +
                            "                <th>Prodct Price</th>\n" +
                            "                <th>Buyer</th>\n" +
                            "            </tr>\n" +
                            "            </thead>\n" +
                            "            <tbody>\n") ;
            for (Product p : buyed_products){
                result.append(
                        "            <tr>\n" +
                        "                <td>"  + p.getName()  + " </td>\n" +
                        "                <td>" + p.getPrice()+  " </td>\n"  +
                        "                <td>"  + p.getBuyer() + " </td>\n" +
                        "            </tr>\n" +
                        "            </thead>\n" +
                        "            <tbody>\n") ;
            }
            result.append("   </tbody>\n" + "        </table>");
            result.append("<h3 align='center'> Total Benefit = " +  total   +  " DH </h3");
            out.print(result);
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
