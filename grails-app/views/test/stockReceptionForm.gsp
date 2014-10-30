<%--
  Created by IntelliJ IDEA.
  User: raoul
  Date: 31/10/14
  Time: 00:38
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<h2>Stock Reception Form</h2>
<ul>
    <g:each in="${stockReceptionForm.properties}" var="property">
        <g:if test="${property.value}">
            <li>${property.key}: ${property.value}</li>
        </g:if>
    </g:each>
</ul>

</body>
</html>