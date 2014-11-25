<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.insertform.title.value=="" || document.insertform.content.value==""
                        || document.insertform.datepublish.value==""){
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
                    <form name="insertform" action="<c:url value="/info/insertNotice"/> " method="post">
                    <tr>
                        <td>标题:</td>
                        <td><input type="text" name="title"></td>
                    </tr>
                    <tr>
                        <td>内容:</td>
                        <td><textarea rows="20" cols="60" name="content"></textarea></td>
                    </tr>
                    <tr>
                        <td>日期(参考格式：2014-10-10):</td>
                        <td><input type="text" name="datepublish"></td>
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
