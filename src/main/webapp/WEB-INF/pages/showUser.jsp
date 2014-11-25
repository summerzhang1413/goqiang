<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.findform.name.value=="" & document.findform.tel.value=="" & document.findform.date_register.value==""){
                    alert("请填写检索条件！！！");
                    findform.name.focus();
                    return false;
                }
                document.findform.submit();
            }
        </script>
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
                <table width="80%" align="center">
                    <form name="findform" action="<c:url value="/info/findUser"/> " method="post">
                        <tr>
                            <td>用户名称：<input type="text" name="name"></td>
                            <td>电话号码：<input type="text" name="tel"></td>
                            <td>注册日期：<input type="text" name="date_register">参考格式：2012-12-12</td>
                            <td><input type="button" value="   查询   " onclick="check()"></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                    </form>
                </table>
                <br>
                <table width="60%" align="center">
                    <tr>
                        <td>编号</td>
                        <td>用户名</td>
                        <td>电话号码</td>
                        <td>积分</td>
                        <td>注册日期</td>
                        <td>地址</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allUser" items="${allUser}" varStatus="status">
                        <tr>
                            <td><c:out value="${allUser.id}"/></td>
                            <td><c:out value="${allUser.name}"/></td>
                            <td><c:out value="${allUser.tel}"/></td>
                            <td><c:out value="${allUser.grade}"/></td>
                            <td><c:out value="${allUser.dateRegister}"/></td>
                            <td><c:out value="${allUser.address}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
