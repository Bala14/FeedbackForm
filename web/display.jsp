<%-- 
    Document   : display
    Created on : Jan 20, 2017, 6:37:48 AM
    Author     : MK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table>
            <tr>
                <th>Name</th>
                <th>Password</th>
                <th>Account No</th>
                <th>Branch</th>
            </tr>
            <%
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb?zeroDateTimeBehavior=convertToNull", "root", "bala");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from feedback");
                while(rs.next()){
                    String name=rs.getString("username");
                    String password=rs.getString("password");
                    String account=rs.getString("accountno");
                    String branch=rs.getString("branch");
            %>
            <tr>
                <td><%=name%></td>
                <td><%=password%></td>
                <td><%=account%></td>
                <td><%=branch%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
