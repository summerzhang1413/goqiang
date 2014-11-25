<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.findform.goodsname.value=="" & document.findform.datefinal.value=="" & document.findform.city.value==""){
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
                    <form name="findform" action="<c:url value="/info/findOpenWin"/> " method="post">
                        <tr>
                            <td>商品名称：<input type="text" name="goodsname"></td>
                            <td>
                            <select name="city">
                                <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                    <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                                </c:forEach>
                            </select>
                            </td>
                            <td>公布日期：<input type="text" name="datefinal">参考格式：2012-12-12</td>
                            <td><input type="button" value="   查询   " onclick="check()"></td>
                            <td><a href="<c:url value="/info/showInsertOpenWin"/>">  添   加  </a></td>
                        </tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                        <tr><td></td></tr>
                    </form>
                </table>
                <br>
                <table width="80%" align="center">
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
                            <td><c:out value="${allOpenWin.datefinal}"/></td>
                            <td><c:out value="${allOpenWin.figure}"/></td>
                            <td><c:out value="${allOpenWin.goodsname}"/></td>
                            <td><c:out value="${allOpenWin.personnumber}"/></td>
                            <td><c:out value="${allOpenWin.price}"/></td>
                            <td><c:out value="${allOpenWin.goodsnumber}"/></td>
                            <td><c:out value="${allOpenWin.userswin}"/></td>
                            <td><c:out value="${allOpenWin.city}"/></td>
                            <td><a href="<c:url value="/info/deleteOpenWinById?id=${allOpenWin.id}"/>">删除</a></td>
                            <td><a href="<c:url value="/info/showUpdateOpenWin?id=${allOpenWin.id}"/>">修改</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
