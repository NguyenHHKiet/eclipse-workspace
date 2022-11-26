<%-- 
    Document   : InstructorValidation
    Created on : Dec 8, 2012, 5:31:49 PM
    Author     : Peter Sun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import = "accounts.InstructorAccount" %>
<jsp:useBean id="instructor" class="accounts.InstructorAccount" scope="session" >
</jsp:useBean>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Instructor Validation Page</title>
    </head>
    <body>

        <% String userName = request.getParameter("username");
            String password = request.getParameter("password");

            if (userName.equals("") || password.equals("")) {
                out.print("Username and password required");
            } else {
                instructor.setLogInInfo(userName, password);

                if (instructor.isInDatabase()) {
                    out.println("<table border=\"0\" style=\"background-color:\" width=\"100%\" cellpadding=\"3\" cellspacing=\"3\">");
                    out.println("<tr>");
                    out.println("<td>Welcome " + instructor.getFirstName() + " " + instructor.getLastName() + "</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td><a href=\"InstructorCoursePage.jsp\">Assign Hw</a></td>");
                    out.println("</tr>");
                    out.println("<tr>");
                    out.println("<td><a href=\"InstructorGradePage.jsp\">Assign Grade</a></td>");
                    out.println("</tr>");
                    out.println("</table>");
                            
                } else {
                    out.print("Please contact your instructor to ensure you are in the system");
                    out.println("<p><form method=\"get\" action=" + "InstructorLoginPage.jsp>");
                    out.println("<p><input type=\"submit\" value=\"Go Back\" >");
                    out.println("</form>");
                }

            }
        %>


    </body>
</html>
