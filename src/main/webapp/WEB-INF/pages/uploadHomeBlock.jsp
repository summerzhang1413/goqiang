<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>GoQiang后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
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
            <%
            String basePath = request.getScheme()+"://"+request.getServerName()
                    + ":" +request.getServerPort()+request.getContextPath()+"/resources/";
            String h[] = {"/homeblock/h1.jpg", "/homeblock/h2.jpg", "/homeblock/h3.jpg", "/homeblock/h4.jpg", "/homeblock/h5.jpg", "/homeblock/h6.jpg", "/homeblock/h7.jpg", "/homeblock/h8.jpg"};

            %>
            <center>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/showHomeBlock"/> " method="post" >
                        <tr>
                            <td>
                                <select name="cityname">
                                    <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                        <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                                    </c:forEach>
                                </select>
                                <select name="blockname">
                                    <option value="homeblock">分类方块</option>
                                </select>
                                <input type="submit" value="   查看   ">
                                当前城市：<c:out value="${city}"/>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/> " method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[0]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h1.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/> " method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[1]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h2.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[2]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h3.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[3]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h4.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[4]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h5.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[5]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h6.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[6]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h7.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doHomeBlockUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%= basePath %> <c:out value="${city}"/> <%=h[7]%>"></td>
                        </tr>
                        <tr>
                            <td>修改图片：<input type="file" name="file"/></td>
                        </tr>
                        <tr>
                            <td>(说明 ：图片名称必须为：h8.jpg，建议尺寸：300x300)</td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="   提交   "></td>
                            <td><input type="hidden" name="cityHidden" value="<c:out value="${city}"/>"></td>
                        </tr>
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
