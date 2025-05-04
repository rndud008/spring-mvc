<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="hello.hellobasic.model.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member List - Model2</title>
</head>
<body>
<h1>Member List (Model2)</h1>
<%
    List<Member> memberList = (List<Member>) application.getAttribute("members");
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
<a href="/model2/registerForm">Go to Register Form</a>
</body>
</html>