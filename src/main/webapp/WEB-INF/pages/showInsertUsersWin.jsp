<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.insertform.goodsname.value=="" || document.insertform.goodsvalue.value==""
                        || document.insertform.convertdatefinal.value=="" || document.insertform.username.value==""
                        || document.insertform.usertel.value=="" || document.insertform.figure.value==""){
                    alert("请填写完整信息！！！");
                    insertform.name.focus();
                    return false;
                }
                document.insertform.submit();
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
                <table width="60%" align="center">
                    <form name="insertform" action="<c:url value="/info/insertUsersWin"/> " method="post">
                    <tr>
                        <td>商品名称:</td>
                        <td><input type="text" name="goodsname"></td>
                    </tr>
                    <tr>
                        <td>商品详情(价值、地址、联系方式):</td>
                        <td><input type="text" name="goodsvalue"></td>
                    </tr>
                    <tr>
                        <td>截止日期(兑奖要求):</td>
                        <td><input type="text" name="convertdatefinal"></td>
                    </tr>
                    <tr>
                        <td>用户名:</td>
                        <td><input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>联系电话:</td>
                        <td><input type="text" name="usertel"></td>
                    </tr>
                    <tr>
                        <td>中奖号码:</td>
                        <td><input type="text" name="figure"></td>
                    </tr>
                    <tr>
                        <td align="left"><input type="button" value="   提交   " onclick="check()"></td>
                        <td align="left"><input type="reset" value="   重置   "></td>
                    </tr>
                    </form>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
