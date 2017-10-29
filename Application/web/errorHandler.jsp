<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"
         isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"
          content="text/html; charset=ISO-8859-1">
    <title>Our bad!</title>
</head>
<body>
<table style="width:100%;">
    <tr>
        <td style="width:75%;height:80%; background-color: red; color:  white;">
            <h1>An Error has occurred!</h1><br>
           ${ pageContext.exception.message }
        </td>
    </tr>
</table>
</body>
</html>