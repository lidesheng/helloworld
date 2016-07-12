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
    <form:form commandName="question" action="question" method="post">
        <table>
            <tr>
                <td>performance:</td>
                <td>
                    <form:select path="performance">
                        <%--<form:option value="10"/>
                        <form:option value="9"/>
                        <form:option value="8"/>
                        <form:option value="7"/>
                        <form:option value="6"/>
                        <form:option value="5"/>
                        <form:option value="4"/>
                        <form:option value="3"/>
                        <form:option value="2"/>
                        <form:option value="1"/>--%>
                        <form:options items="${valueList}" itemValue="value" itemLabel="name"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>atmosphere:</td>
                <td>
                    <form:select path="atmosphere">
                        <form:option value="10"/>
                        <form:option value="9"/>
                        <form:option value="8"/>
                        <form:option value="7"/>
                        <form:option value="6"/>
                        <form:option value="5"/>
                        <form:option value="4"/>
                        <form:option value="3"/>
                        <form:option value="2"/>
                        <form:option value="1"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>superStar:</td>
                <td>
                    <form:select path="superStar">
                        <form:option value="Li, Desheng"/>
                        <form:option value="2"/>
                        <form:option value="3"/>
                        <form:option value="4"/>
                        <form:option value="5"/>
                        <form:option value="6"/>
                        <form:option value="7"/>
                        <form:option value="8"/>
                        <form:option value="9"/>
                        <form:option value="10"/>
                    </form:select>
                </td>
            </tr>
        </table>
        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
