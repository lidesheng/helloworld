<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2016/6/30
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>question</title>
</head>
<body>
    <table>
        <tr>
            <td><a href="surveyAdd">add</a></td>
        </tr>
        <c:forEach items="${surveys}" var="survey">
            <tr>
                <td>${survey.name}</td>
                <td><a href="statistics/${survey.id}">statistics</a></td>
                <td><a href="survey/${survey.id}">survey</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
