<%-- 
    Document   : register
    Created on : 17-Nov-2018, 12:57:54
    Author     : mjs-laptop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="LoginRegister" method="post">
            <table style = "border: solid black 1px; background-color: skyblue; margin-left: 20px; margin-left: 20px;">
                <tr>
                    <td><h3 style="color: red;">Registration Page</h3></td>
                    <td></td>
                </tr>
                <tr><td>Username:  </td><td><input type="text" name="username"></td></tr>
                <tr><td>Name:   </td><td><input type="text" name="name"></td></tr>

                <tr><td>Password:  </td><td><input type="password" name="password1"></td></tr>
                <tr><td>Re-Type Password:  </td><td><input type="password" name="password2"></td></tr>

                <tr><td><input type="submit" name="submit" value="register"></td></tr>

            </table> 
        </form> 
    </body>
</html>
