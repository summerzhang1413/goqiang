<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
    </head>
    <body>
    <%@ include file="admintop.jsp" %>
    <br><br>

    <center>
        <table width="40%" align="center">
            <tr>
                <td><a href="<c:url value="/info/showGoodsSubmit"/>">用户提交的商品信息</a></td>
                <td><a href="<c:url value="/info/showUser"/>">用户个人信息</a></td>
                <td><a href="<c:url value="/info/showUsersWin"/>">中奖记录</a></td>
            </tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr><td></td></tr>
            <tr>
                <td><a href="<c:url value="/info/showOpenWin"/>">中奖信息公布</a></td>
                <td><a href="<c:url value="/info/showSuggestion"/>">意见反馈</a></td>
                <td><a href="<c:url value="/info/showNotice"/>">土匪公告</a></td>
            </tr>
        </table>
    </center>
    </body>
</html>
