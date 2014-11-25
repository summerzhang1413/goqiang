<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.findform.goodsname.value=="" || document.findform.goodsvalue.value==""
                        || document.findform.convertdatefinal.value=="" || document.findform.username.value==""
                        || document.findform.usertel.value=="" || document.findform.figure.value==""){
                    alert("请填写完整信息！！！");
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
                    <form name="findform" action="<c:url value="/info/updateUsersWin"/> " method="post">
                    <tr>
                        <td>编号</td>
                        <td>商品名称</td>
                        <td>商品详情</td>
                        <td>截止日期</td>
                        <td>用户名</td>
                        <td>联系电话</td>
                        <td>中奖号码</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allUsersWin" items="${allUsersWin}" varStatus="status">
                        <tr>
                            <td><c:out value="${allUsersWin.id}"/></td>
                            <td><input type="text" name="goodsname" value="<c:out value="${allUsersWin.goodsname}"/>"></td>
                            <td><input type="text" name="goodsvalue" value="<c:out value="${allUsersWin.goodsvalue}"/>"></td>
                            <td><input type="text" name="convertdatefinal" value="<c:out value="${allUsersWin.convertdatefinal}"/>"></td>
                            <td><input type="text" name="username" value="<c:out value="${allUsersWin.username}"/>"></td>
                            <td><input type="text" name="usertel" value="<c:out value="${allUsersWin.usertel}"/>"></td>
                            <td><input type="text" name="figure" value="<c:out value="${allUsersWin.figure}"/>"></td>
                            <td><input type="button" value="   确认修改   " onclick="check()"></td>
                            <input type="hidden" name="id" value="${allUsersWin.id}" >
                        </tr>
                    </c:forEach>
                    </form>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
