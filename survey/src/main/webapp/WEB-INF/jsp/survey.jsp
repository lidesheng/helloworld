<%--
  Created by IntelliJ IDEA.
  User: lee
  Date: 2016/6/30
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>question</title>
</head>
<body>
    <form:form commandName="survey" action="survey" method="post">
        <table>
            <tr>
                <td>surveyName:</td>
                <td>
                    <form:input path="name"/>
                </td>
            </tr>
        </table>
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
