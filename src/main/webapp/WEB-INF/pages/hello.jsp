<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
        <script language="JavaScript">
            function Check(){
                if(document.managerlogin.mName.value==""){
                    alert("请填写管理员名！！！");
                    managerlogin.mName.focus();
                    return false;
                }
                if(document.managerlogin.mPwd.value==""){
                    alert("请填写密码！！！");
                    managerlogin.mPwd.focus();
                    return false;
                }
                document.managerlogin.submit();
            }
        </script>
    </head>
    <body >
    <%@ include file="admintop.jsp" %>
    <br><br>

    <c:choose>
        <c:when test="${sessionManager==null||sessionManager.mId==null}">
            <table id="back">
                <form  name="managerlogin" action="<c:url value="/managerpage/login"/>" method="post">
                    <tr height=80><td height="53"></td></tr>
                    <tr>
                        <td width="30%" height="55" align="right">用户名:</td>
                        <td colspan="2" width="70%">
                            <input type="text" name="mName" size="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="30%" height="57" align="right">密码:</td>
                        <td colspan="2" width="70%">
                            <input type="password" name="mPwd" size="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td align="right">
                            <input type="button" size="20" value="   登录   " onClick="Check()">
                        </td>
                        <td align="left">
                            &nbsp;&nbsp;
                            <input type="reset" size="20" value="   重置   ">
                        </td>
                    </tr>
                </form>
            </table>
        </c:when>
        <c:otherwise>
            <table align="center" width="100%" height="100%">
                <tr align="center">
                    <td>
                        ${sessionManager.mName} 您好，您已登录……<a href="<c:url value="/managerpage/logout"/>">注销</a>
                    </td>
                </tr>
            </table>
        </c:otherwise>
    </c:choose>
<br><br>
    <c:if test="${not empty login_error}">
        <table align="center" width="100%" height="100%">
            <tr align="center">
                <td>
                    <strong>登录出错:</strong>${login_error}
                </td>
            </tr>
            <c:remove var="login_error" />
        </table>
    </c:if>

    </body>
</html>