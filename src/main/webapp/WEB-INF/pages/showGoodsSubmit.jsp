<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.findform.goodsname.value=="" & document.findform.datesubmit.value=="" & document.findform.figure.value==""){
                    alert("请填写检索条件！！！");
                    findform.goodsname.focus();
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
                    <form name="findform" action="<c:url value="/info/findGoodsSubmit"/> " method="post">
                        <tr>
                            <td>商品名称：<input type="text" name="goodsname"></td>
                            <td>提交日期：<input type="text" name="datesubmit">参考格式：2012-12-12</td>
                            <td>提交号码：<input type="text" name="figure"></td>
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
                        <td>商品名称</td>
                        <td>价值</td>
                        <td>数量</td>
                        <td>截止日期</td>
                        <td>提交日期</td>
                        <td>用户名</td>
                        <td>提交号码</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allGoodsSubmit" items="${allGoodsSubmit}" varStatus="status">
                        <tr>
                            <td><c:out value="${allGoodsSubmit.id}"/></td>
                            <td><c:out value="${allGoodsSubmit.name}"/></td>
                            <td><c:out value="${allGoodsSubmit.value}"/></td>
                            <td><c:out value="${allGoodsSubmit.number}"/></td>
                            <td><c:out value="${allGoodsSubmit.datefinal}"/></td>
                            <td><c:out value="${allGoodsSubmit.datesubmit}"/></td>
                            <td><c:out value="${allGoodsSubmit.username}"/></td>
                            <td><c:out value="${allGoodsSubmit.figure}"/></td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
        </c:when>
    </c:choose>

    </body>
</html>
