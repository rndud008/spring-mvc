<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="hello.hellobasic.model.Member" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Member List - FrontController</title>
</head>
<body>
<h1>Member List (FrontController)</h1>
<%
    List<Member> memberList = (List<Member>) request.getAttribute("members");
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
<a href="/front-controller/members/new-form">Go to Register Form</a>
</body>
</html>