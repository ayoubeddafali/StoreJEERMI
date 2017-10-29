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
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <%@include  file="navbar.jsp"%>

            <main role="main" class="inner cover">
                <form class="form-signin" action="/addProduct" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-8" >Product Name:</label>
                        <span class="col-sm-5">
                            <input type="text" name="name" class="form-control"  placeholder="Enter product name">
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-8" >Product Price (DH) :</label>
                        <span class="col-sm-5">
                            <input type="text" name="price" class="form-control"  placeholder="3000">
                        </span>
                    </div>

                    <div class="form-group">
                        <span class="col-sm-offset-2 col-sm-5">
                            <button type="submit" class="btn btn-primary btn-block">Add Product</button>
                        </span>
                    </div>
                </form>
            </main>




        </div>

    </div>

</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="assets/js/jquery-3.2.1.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>
