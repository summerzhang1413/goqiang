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
                        <td>标题</td>
                        <td>内容</td>
                        <td>时间</td>
                        <td><a href="<c:url value="/info/showInsertNotice"/>">添 加</a></td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allNotice" items="${allNotice}" varStatus="status">
                        <tr>
                            <td><c:out value="${allNotice.id}"/></td>
                            <td><c:out value="${allNotice.title}"/></td>
                            <td><c:out value="${allNotice.content}"/></td>
                            <td><c:out value="${allNotice.datepublish}"/></td>
                            <td><a href="<c:url value="/info/showUpdateNotice?id=${allNotice.id}"/>">修 改</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
