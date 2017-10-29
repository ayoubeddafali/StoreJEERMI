<div class="container" style="margin-bottom: 20px;" >
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Store Products</a>
            <% if ( session.getAttribute("type").equals("grossiste") ){ %>
            <a style="color: #b21f2d;"  class="nav-link active" href="grossisteMenu.jsp">Dashboard</a>
            <% } else{  %>
            <a style="color: #b21f2d;"  class="nav-link active" href="clientMenu.jsp">Dashboard</a>
            <% } %>
        </div>
        <div id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">

                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <% out.print(session.getAttribute("username"));  %>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/logout">LOGOUT</a></li>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
</div>