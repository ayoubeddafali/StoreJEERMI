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

            <%@include  file="login_navbar.jsp"%>

                <div class="row" style="align-items: center; justify-content: center;">
                    <div class="col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <span class="glyphicon glyphicon-bookmark"></span> Quick Shortcuts</h3>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-6 col-md-6">
                                        <a href="/products" class="btn btn-danger btn-lg" role="button"><span class="glyphicon glyphicon-list-alt"></span> <br/>All products</a>
                                    </div>
                                    <div class="col-xs-6 col-md-6">
                                        <a href="/purchases" class="btn btn-success btn-lg" role="button"><span class="glyphicon glyphicon-bookmark"></span> <br/>My Purchases</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            <footer class="mastfoot">
                <div class="inner">
                    <p>By <a href="#">@Ayoub</a>, and  <a href="#">@Hakim</a>.</p>
                </div>
            </footer>

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
<script src="assets/js/myscript.js" > </script>
</body>
</html>
