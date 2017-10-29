
<% if ( session.getAttribute("username") != null  ) {
    String type = (String)session.getAttribute("type");
    if (type.equalsIgnoreCase("client")) {
%>
<header class="masthead clearfix">
    <div class="inner">
        <h3 class="masthead-brand">Products Store</h3>
        <nav class="nav nav-masthead">
            <a  class="nav-link active" href="clientMenu.jsp">Dashboard</a>
            <a  class="nav-link" href="/logout">Log out</a>
        </nav>
    </div>
</header>
<% } else if (type.equalsIgnoreCase("grossiste")) {  %>
<header class="masthead clearfix">
    <div class="inner">
        <h3 class="masthead-brand">Products Store</h3>
        <nav class="nav nav-masthead">
            <a  class="nav-link active" href="grossisteMenu.jsp">Dashboard</a>
            <a  class="nav-link" href="/logout">Log out</a>
        </nav>
    </div>
</header>


<% }} %>

<% if ( session.getAttribute("username") == null ) { %>
<header class="masthead clearfix">
    <div class="inner">
        <h3 class="masthead-brand">Products Store</h3>
        <nav class="nav nav-masthead">
            <a id="home_nav"  class="nav-link active" href="/">Home</a>
            <a id="login_nav" class="nav-link" href="#">LOGIN</a>
            <a id="signup_nav" class="nav-link" href="#">SIGN UP</a>
        </nav>
    </div>
</header>

<% } %>