<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Welcome to Products Store</title>
</head>
<body>
<table style="width:100%;">
    <tr>

        <td style="width:75%;height:80%;">
            <h1>Something has gone wrong with the system.
                The incident has been logged for research purposes.
                Please try again.</h1>
            <p>${pageContext.exception.message}</p>
        </td>
    </tr>
</table>
</body>
</html>