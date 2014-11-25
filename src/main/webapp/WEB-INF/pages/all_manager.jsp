<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function deleteAlert(){
                if(window.confirm("确认删除？")){
                    document.deleteManager.submit();
                }else{

                }
            }
        </script>
    </head>
    <body>
    <center>
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
            <c:when test="${(sessionManager != null) && (sessionManager.mLevel == 0)}">
                <table align="center" width="80%" cellspacing="1" border="2">
                    <tr bgcolor="white" align="center">
                        <td>管理员ID</td>
                        <td>管理员级别</td>
                        <td>操作</td>
                    </tr>
                    <c:forEach var="allmanager" items="${allmanager}" varStatus="status">
                        <tr bgcolor="white" align="center">
                            <td>
                                <c:out value="${allmanager.mName}"/>
                            </td>
                            <td>
                                <c:if test="${allmanager.mLevel == 0}">
                                    <c:out value="超级管理员"/>
                                </c:if>
                                <c:if test="${allmanager.mLevel == 1}">
                                    <c:out value="普通管理员"/>
                                </c:if>
                            </td>
                            <td>
                                <a href="<c:url value="/managerpage/delete?name=${allmanager.mName}"/>">删除</a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="<c:url value="/managerpage/updatepage?name=${allmanager.mName}"/>">修改</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table >
                <br>
                <table align="center" border="0" width="80%">
                    <tr  align="center">
                        <td align="left"><a href="<c:url value="/managerpage/insertpage"/>">添加管理员</a></td>
                    </tr>
                </table>
            </c:when>
            <c:otherwise>
                <table align="center" width="100%" height="100%">
                    <tr align="center">
                        <td>
                            <strong>操作错误:</strong>权限不够！
                        </td>
                    </tr>
                </table>
            </c:otherwise>
        </c:choose>
    </center>
    </body>
</html>
