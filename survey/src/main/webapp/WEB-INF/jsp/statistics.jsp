<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2016/6/30
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>statistics</title>
</head>
<body>
    <table border="1">
        <tr>
            <td>performance:</td>
            <td>${statistics.performance }</td>
        </tr>
        <tr>
            <td>atmosphere:</td>
            <td>${statistics.atmosphere }</td>
        </tr>
        <tr>
            <td>superStar:</td>
            <td>${statistics.superStar }</td>
        </tr>
    </table>


</body>
</html>
