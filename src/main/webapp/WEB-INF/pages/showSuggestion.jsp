<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
    </head>
    <body>
    <%@ include file="admintop.jsp" %>
    <br><br>
    <c:choose>
        <c:when test="${sessionManager == null}">
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        <strong>操作错误:</strong>请先登录！
                    </td>
                </tr>
            </table>
        </c:when>
        <c:when test="${(sessionManager != null) }">
            <center>
                <table width="60%" align="center">
                    <tr>
                        <td>编号</td>
                        <td>内容</td>
                        <td>提交用户</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allSuggestion" items="${allSuggestion}" varStatus="status">
                        <tr>
                            <td><c:out value="${allSuggestion.id}"/></td>
                            <td><c:out value="${allSuggestion.content}"/></td>
                            <td><c:out value="${allSuggestion.username}"/></td>
                            <td><a href="<c:url value="/info/deleteSuggestion?id=${allSuggestion.id}"/>">删  除</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
