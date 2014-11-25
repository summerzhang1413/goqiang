<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.updateform.datefinal.value=="" || document.updateform.figure.value==""
                        || document.updateform.personnumber.value=="" || document.updateform.goodsname.value==""
                        || document.updateform.goodsnumber.value=="" || document.updateform.price.value==""
                        || document.updateform.userswin.value=="" || document.updateform.city.value==""){
                    alert("请填写完整信息！！！");
                    updateform.name.focus();
                    return false;
                }
                document.updateform.submit();
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
                    <form name="updateform" action="<c:url value="/info/updateOpenWin"/> " method="post">
                    <tr>
                        <td>编号</td>
                        <td>公布日期</td>
                        <td>开奖号</td>
                        <td>商品名称</td>
                        <td>参与人数</td>
                        <td>价值</td>
                        <td>数量</td>
                        <td>中奖人</td>
                        <td>地区</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allOpenWin" items="${allOpenWin}" varStatus="status">
                        <tr>
                            <td><c:out value="${allOpenWin.id}"/></td>
                            <td><input type="text" name="datefinal" value="<c:out value="${allOpenWin.datefinal}"/>"></td>
                            <td><input type="text" name="figure" value="<c:out value="${allOpenWin.figure}"/>"></td>
                            <td><input type="text" name="goodsname" value="<c:out value="${allOpenWin.goodsname}"/>"></td>
                            <td><input type="text" name="personnumber" value="<c:out value="${allOpenWin.personnumber}"/>"></td>
                            <td><input type="text" name="price" value="<c:out value="${allOpenWin.price}"/>"></td>
                            <td><input type="text" name="goodsnumber" value="<c:out value="${allOpenWin.goodsnumber}"/>"></td>
                            <td><input type="text" name="userswin" value="<c:out value="${allOpenWin.userswin}"/>"></td>
                            <td><input type="text" name="city" value="<c:out value="${allOpenWin.city}"/>"></td>
                            <td><input type="button" value="   确认修改   " onclick="check()"></td>
                            <input type="hidden" name="id" value="${allOpenWin.id}" >
                        </tr>
                    </c:forEach>
                    </form>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
