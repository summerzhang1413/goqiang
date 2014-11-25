<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.updatemanager.mName.value==""){
                    alert("请填写管理员名！！！");
                    updatemanager.mName.focus();
                    return false;
                }
                if(document.updatemanager.mPwd.value==""){
                    alert("请填写密码！！！")
                    updatemanager.mPwd.focus();
                    return false;
                }
                document.updatemanager.submit();
            }
        </script>
    </head>
    <body>
        <%@include file="admintop.jsp"%>
        <br>
        <form name="updatemanager" action="<c:url value="/managerpage/update"/> " method="post">
            <div style="text-align:center;">
                <table style="margin:auto; width:40%;" >
                    <tr >
                        <td align="left">管理员ID：</td>
                        <td align="left">
                            <input type="hidden" name="mId" value="${manager.mId}">
                            <input type="text" name="mName" value="${manager.mName}">
                        </td>
                    </tr>
                    <tr >
                        <td align="left">管理员级别：</td>
                        <c:if test="${manager.mLevel == 0}">
                            <td align="left"><input type="radio" name="mLevel" value="1" >普通管理员</td>
                            <td align="left"><input type="radio" name="mLevel" value="0" checked>超级管理员</td>
                        </c:if>
                        <c:if test="${manager.mLevel == 1}">
                            <td align="left"><input type="radio" name="mLevel" value="1" checked>普通管理员</td>
                            <td align="left"><input type="radio" name="mLevel" value="0">超级管理员</td>
                        </c:if>
                    </tr>
                    <tr >
                        <td align="left">管理员密码：</td>
                        <td align="left"><input type="password" name="mPwd"></td>
                    </tr>
                    <tr align="center" >
                        <td align="left"><input type="button" value="提交" onclick="check()"></td>
                        <td align="left"><input type="reset" value="重置"></td>
                    </tr>
                </table>
            </div>
        </form>
    </body>
</html>
