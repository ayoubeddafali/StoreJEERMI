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

            <main id="main" role="main" class="inner cover">
                <h1 class="cover-heading">Buy & Sell Your Products.</h1>
                <p class="lead">Here you can sell your products and buy it from others. It's like Amazon for your products.</p>
            </main>
            <main id="login" role="main" class="inner cover get_out">
                <form class="form-signin" action="/login" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Username:</label>
                        <span class="col-sm-5">
                            <input type="text" name="username" class="form-control" id="email2" placeholder="Enter username">
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <span class="col-sm-5">
                            <input type="password" class="form-control"  name="password"  id="pwd2" placeholder="Enter password">
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Type:</label>
                        <span  class="col-sm-offset-2 col-sm-5">
                            <select name="type" class="form-control" id="user_type2">
                                <option value="client">Client</option>
                                <option value="grossiste">Grossiste</option>
                            </select>
                        </span>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-5">
                            <div class="checkbox">
                                <label><input type="checkbox"> Remember me</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-offset-2 col-sm-5">
                            <button type="submit" class="btn btn-success btn-block">Login</button>
                        </span>
                    </div>
                </form>
            </main>

            <main id="signup" role="main" class="inner cover get_out"  >
                <form class="form-signin" action="/register" method="post">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Username:</label>
                        <span class="col-sm-5">
                            <input type="text" name="username" class="form-control" id="email" placeholder="Enter username">
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="pwd">Password:</label>
                        <span class="col-sm-5">
                            <input type="password" name="password"  class="form-control" id="pwd" placeholder="Enter password">
                        </span>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Type:</label>
                        <span class="col-sm-offset-2 col-sm-5">
                            <select name="type" class="form-control" id="user_type">
                                <option value="client">Client</option>
                                <option value="grossiste">Grossiste</option>
                            </select>
                        </span>
                    </div>
                    <div class="form-group">
                        <span class="col-sm-offset-2 col-sm-5">
                            <button type="submit" class="btn btn-success btn-block">Register</button>
                        </span>
                    </div>
                </form>
            </main>

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
