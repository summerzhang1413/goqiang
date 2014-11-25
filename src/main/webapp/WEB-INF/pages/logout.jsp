<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
    </head>
    <body>
        <%@include file="admintop.jsp"%>
        <br><br>
        <c:if test="${logout_error != null}">
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        <strong>注销出错:</strong>${logout_error}
                    </td>
                </tr>
                <c:remove var="logout_error" />
            </table>
        </c:if>
        <c:if test="${login_error == null}">
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        <strong>注销成功 ！</strong>
                    </td>
                </tr>
            </table>
        </c:if>
    </body>
</html>
