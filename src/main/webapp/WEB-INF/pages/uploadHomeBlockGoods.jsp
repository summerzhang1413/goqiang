<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>GoQiang后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
    <script language="JavaScript">
        function Check(){
            if(document.homeblockgoodsform.goodsname.value==""){
                alert("请填写商品名称！！！");
                homeblockgoodsform.goodsname.focus();
                return false;
            }
            if(document.homeblockgoodsform.price.value==""){
                alert("请填写商品价格！！！");
                homeblockgoodsform.price.focus();
                return false;
            }
            if(document.homeblockgoodsform.number.value==""){
                alert("请填写商品数量！！！");
                homeblockgoodsform.number.focus();
                return false;
            }
            if(document.homeblockgoodsform.detail.value==""){
                alert("请填写商品详情！！！");
                homeblockgoodsform.detail.focus();
                return false;
            }
            if(document.homeblockgoodsform.datefinal.value==""){
                alert("请填写截止时间！！！");
                homeblockgoodsform.datefinal.focus();
                return false;
            }
            if(!document.homeblockgoodsform.datefinal.value.match("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                alert("截止时间格式不正确！！！");
                homeblockgoodsform.datefinal.focus();
                return false;
            }
            document.homeblockgoodsform.submit();
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
            <%
                String basePath = request.getScheme()+"://"+request.getServerName()
                        + ":" +request.getServerPort()+request.getContextPath()+"/resources/";
                String h1[] = {"/h1_1.jpg", "/h1_2.jpg", "/h1_3.jpg"};
                String h2[] = {"/h2_1.jpg", "/h2_2.jpg", "/h2_3.jpg"};
                String h3[] = {"/h3_1.jpg", "/h3_2.jpg", "/h3_3.jpg"};
                String h4[] = {"/h4_1.jpg", "/h4_2.jpg", "/h4_3.jpg"};
                String h5[] = {"/h5_1.jpg", "/h5_2.jpg", "/h5_3.jpg"};
                String h6[] = {"/h6_1.jpg", "/h6_2.jpg", "/h6_3.jpg"};
                String h7[] = {"/h7_1.jpg", "/h7_2.jpg", "/h7_3.jpg"};
                String h8[] = {"/h8_1.jpg", "/h8_2.jpg", "/h8_3.jpg"};

            %>
            <center>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/showBlockGoods"/> " method="post" >
                        <tr>
                            <td>
                                <select name="cityname">
                                    <c:forEach var="allCity" items="${allCity}" varStatus="status">
                                        <option value="<c:out value="${allCity.cityenglish}"/>"><c:out value="${allCity.citychinese}"/></option>
                                    </c:forEach>
                                </select>
                                <select name="blockname">
                                    <option value="homeblock1">类别1</option>
                                    <option value="homeblock2">类别2</option>
                                    <option value="homeblock3">类别3</option>
                                    <option value="homeblock4">类别4</option>
                                    <option value="homeblock5">类别5</option>
                                    <option value="homeblock6">类别6</option>
                                    <option value="homeblock7">类别7</option>
                                    <option value="homeblock8">类别8</option>
                                </select>
                                <input type="submit" value="   查看   ">
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <tr>
                        <td>当前城市：<c:out value="${city}"/>当前类别：<c:out value="${block}"/></td>
                    </tr>
                    <tr>
                        <td>
                            <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=5>
                        </td>
                    </tr>
                </table>
                <table width="40%" align="center">
                    <form name="homeblockgoodsform" action="<c:url value="/images/doBlockGoodsUpload"/> " method="post" enctype="multipart/form-data">
                        <tr>
                            <td>修改商品图片1：<input type="file" name="file1"/></td>
                        </tr>
                        <tr>
                            <td>修改商品图片2：<input type="file" name="file2"/></td>
                        </tr>
                        <tr>
                            <td>修改商品图片3：<input type="file" name="file3"/></td>
                        </tr>
                        <tr>
                            <td>说明 ：图片名称必须依次为：</td>
                        </tr>
                        <tr>
                            <td>商品1：h1_1.jpg, h1_2.jpg, h1_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品2：h2_1.jpg, h2_2.jpg, h2_3.jpg，建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品3：h3_1.jpg, h3_2.jpg, h3_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品4：h4_1.jpg, h4_2.jpg, h4_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品5：h5_1.jpg, h5_2.jpg, h5_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品6：h6_1.jpg, h6_2.jpg, h6_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品7：h7_1.jpg, h7_2.jpg, h7_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>商品8：h8_1.jpg, h8_2.jpg, h8_3.jpg, 建议尺寸：485x200</td>
                        </tr>
                        <tr>
                            <td>
                                商品类别：<select name="blockname_update">
                                <option value="<c:out value="${block}"/>"><c:out value="${block}"/></option>
                            </select>
                                商品编号：<select name="imagename_update">
                                <option value="_h1_1">1</option>
                                <option value="_h2_1">2</option>
                                <option value="_h3_1">3</option>
                                <option value="_h4_1">4</option>
                                <option value="_h5_1">5</option>
                                <option value="_h6_1">6</option>
                                <option value="_h7_1">7</option>
                                <option value="_h8_1">8</option>
                            </select>
                                城市：<select name="city_update">
                                <option value="<c:out value="${city}"/>"><c:out value="${city}"/></option>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td>名称：<input type="text" name="goodsname"></td>
                        </tr>
                        <tr>
                            <td>价格：<input type="text" name="price"></td>
                        </tr>
                        <tr>
                            <td>数量：<input type="text" name="number"></td>
                        </tr>
                        <tr>
                            <td>详情：<input type="text" name="detail"></td>
                        </tr>
                        <tr>
                            <td>截止日期：<input type="text" name="datefinal">参考格式：2012-12-12 12:00:00</td>
                        </tr>
                        <tr>
                            <td><input type="button" value="提交" onClick="Check()"></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="100%" color=#987cb9 SIZE=5>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/> " method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h1[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h1[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h1[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品1"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[0].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[0].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[0].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[0].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[0].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[0].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/> " method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h2[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h2[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h2[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品2"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[1].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[1].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[1].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[1].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[1].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[1].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value=""/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h3[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h3[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h3[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品3"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[2].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[2].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[2].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[2].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[2].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[2].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h4[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h4[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h4[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品4"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[3].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[3].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[3].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[3].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[3].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[3].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h5[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h5[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h5[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品5"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[4].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[4].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[4].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[4].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[4].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[4].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h6[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h6[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h6[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品6"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[5].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[5].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[5].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[5].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[5].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[5].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h7[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h7[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h7[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品7"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[6].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[6].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[6].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[6].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[6].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[6].city}"/></td>
                        </tr>
                        <tr>
                            <td>
                                <HR style="border:1 dashed #987cb9" width="80%" color=#987cb9 SIZE=1>
                            </td>
                        </tr>
                    </form>
                </table>
                <table width="40%" align="center">
                    <form action="<c:url value="/images/doRecommendUpload"/>" method="post"  enctype="multipart/form-data">
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h8[0]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h8[1]%>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%=basePath%>${city}<%="/"%>${block}<%=h8[2]%>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="分类商品8"/></td>
                        </tr>
                        <tr>
                            <td>名称：<c:out value="${allGoodsInfo[7].goodsname}"/></td>
                        </tr>
                        <tr>
                            <td>价格：<c:out value="${allGoodsInfo[7].price}"/></td>
                        </tr>
                        <tr>
                            <td>数量：<c:out value="${allGoodsInfo[7].number}"/></td>
                        </tr>
                        <tr>
                            <td>详情：<c:out value="${allGoodsInfo[7].detail}"/></td>
                        </tr>
                        <tr>
                            <td>截止日期：<c:out value="${allGoodsInfo[7].datefinal}"/></td>
                        </tr>
                        <tr>
                            <td>城市：<c:out value="${allGoodsInfo[7].city}"/></td>
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
