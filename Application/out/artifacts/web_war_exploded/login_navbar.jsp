<header class="masthead clearfix">
    <div class="inner">
        <h3 class="masthead-brand">Products Store</h3>
        <nav class="nav nav-masthead">
            <% if ( session.getAttribute("type").equals("grossiste") ){ %>
            <a  class="nav-link active" href="grossisteMenu.jsp">Dashboard</a>
            <% } else{  %>
            <a  class="nav-link active" href="clientMenu.jsp">Dashboard</a>
            <% } %>
            <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                <% out.print(session.getAttribute("username"));  %>
            </a>
                <div class="dropdown-menu" aria-labelledby="dropdown01">
                    <a class="dropdown-item" href="/logout">LOGOUT</a>
                </div>

        </nav>
    </div>
</header>