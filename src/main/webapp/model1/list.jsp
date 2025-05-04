<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="hello.hellobasic.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member List - Model1</title>
</head>
<body>
<h1>Member List (Model1)</h1>
<%
    List<Member> memberList = (List<Member>) application.getAttribute("memberList");
    if (memberList == null) {
        memberList = List.of();
    }
%>
<ul>
    <%
        for (Member m : memberList) {
    %>
    <li><%= m.getUsername() %> / <%= m.getPassword() %></li>
    <%
        }
    %>
</ul>
<a href="/model1/registerForm.jsp">Go to Register Form</a>
</body>
</html>