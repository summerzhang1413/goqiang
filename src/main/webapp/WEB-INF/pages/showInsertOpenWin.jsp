<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(!((document.insertform.datefinal.value.match("\\d{4}-\\d{2}-\\d{2}")) && (document.insertform.datefinal.value.length==10))){
                    alert("发布日期格式不正确！！！");
                    insertform.datefinal.focus();
                    return false;
                }
                if(document.insertform.datefinal.value=="" || document.insertform.figure.value==""
                        || document.insertform.personnumber.value=="" || document.insertform.goodsname.value==""
                        || document.insertform.goodsnumber.value=="" || document.insertform.price.value==""
                        || document.insertform.userswin.value=="" || document.insertform.city.value==""){
                    alert("请填写完整信息！！！");
                    insertform.datefinal.focus();
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
                    <form name="insertform" action="<c:url value="/info/insertOpenWin"/> " method="post">
                    <tr>
                        <td>发布日期:</td>
                        <td><input type="text" name="datefinal">参考格式：2012-12-12</td>
                    </tr>
                    <tr>
                        <td>开奖号码:</td>
                        <td><input type="text" name="figure"></td>
                    </tr>
                    <tr>
                        <td>商品名称:</td>
                        <td><input type="text" name="goodsname"></td>
                    </tr>
                    <tr>
                        <td>参与人数:</td>
                        <td><input type="text" name="personnumber"></td>
                    </tr>
                    <tr>
                        <td>价值:</td>
                        <td><input type="text" name="price"></td>
                    </tr>
                    <tr>
                        <td>数量:</td>
                        <td><input type="text" name="goodsnumber"></td>
                    </tr>
                    <tr>
                        <td>中奖人(请使用"|"隔开):</td>
                        <td><input type="text" name="userswin"></td>
                    </tr>
                    <tr>
                        <td>地区:</td>
                        <td>
                        <select name="city">
                            <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                            </c:forEach>
                        </select>
                        </td>
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
