<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>GoQiang后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
    <script language="JavaScript">
        function CheckInsert(){
            if(document.insertForm.chineseName.value==""){
                alert("请填写中文名！！！");
                insertForm.chineseName.focus();
                return false;
            }
            if(document.insertForm.englishName.value==""){
                alert("请填写拼音！！！");
                insertForm.englishName.focus();
                return false;
            }
            document.insertForm.submit();
        }
        function CheckUpdate(){
            if(document.updateForm.chineseName.value==""){
                alert("请填写中文名！！！");
                updateForm.chineseName.focus();
                return false;
            }
            if(document.updateForm.englishName.value==""){
                alert("请填写拼音！！！");
                updateForm.englishName.focus();
                return false;
            }
            document.updateForm.submit();
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
                <table width="40%" align="center">
                    <form name="insertForm" action="<c:url value="/images/doCity"/> " method="post" >
                        <tr>
                            <td>
                                中文名：<input type="text" name="chineseName">
                                拼音：<input type="text" name="englishName">
                                <input type="button" value="   添加   " onclick="CheckInsert()">
                                <input type="hidden" name="hid" value="insert">
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form name="deleteForm" action="<c:url value="/images/doCity"/> " method="post" >
                        <tr>
                            <td>
                                <select name="cityname">
                                    <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                        <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                                    </c:forEach>
                                </select>
                                <input type="submit" value="   删除   ">
                                <input type="hidden" name="hid" value="delete">
                            </td>
                        </tr>
                        <br><br>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form name="updateForm" action="<c:url value="/images/doCity"/> " method="post" >
                        <tr>
                            <td>
                                <select name="cityname">
                                    <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                        <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                                    </c:forEach>
                                </select>
                                中文名：<input type="text" name="chineseName">
                                拼音：<input type="text" name="englishName">
                                <input type="button" value="   修改   " onclick="CheckUpdate()">
                                <input type="hidden" name="hid" value="update" >
                            </td>
                        </tr>
                        <br><br>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
            </center>
        </c:when>
    </c:choose>
</body>
</html>
