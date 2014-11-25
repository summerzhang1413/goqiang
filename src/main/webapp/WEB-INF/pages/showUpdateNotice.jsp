<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>GoQiang后台管理系统</title>
        <script language="JavaScript">
            function check(){
                if(document.findform.title.value=="" || document.findform.content.value==""
                        || document.findform.datepublish.value==""){
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
                    <form name="findform" action="<c:url value="/info/updateNotice"/> " method="post">
                    <tr>
                        <td>编号</td>
                        <td>标题</td>
                        <td>内容</td>
                        <td>时间</td>
                    </tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <tr><td></td></tr>
                    <c:forEach var="allNotice" items="${allNotice}" varStatus="status">
                        <tr>
                            <td><c:out value="${allNotice.id}"/></td>
                            <td><input type="text" name="title" value="<c:out value="${allNotice.title}"/>"></td>
                            <td><textarea rows="20" cols="60" name="content" ><c:out value="${allNotice.content}"/></textarea></td>
                            <td><input type="text" name="datepublish" value="<c:out value="${allNotice.datepublish}"/>"></td>
                            <td><input type="button" value="   确认修改   " onclick="check()"></td>
                            <input type="hidden" name="id" value="${allNotice.id}" >
                        </tr>
                    </c:forEach>
                    </form>
                </table>
            </center>
        </c:when>
    </c:choose>
    </body>
</html>
