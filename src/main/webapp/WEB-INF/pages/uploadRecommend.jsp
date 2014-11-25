<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>GoQiang后台管理系统</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/manageLogin.css"/>" />
    <script language="JavaScript">
        function Check(){
            if(document.recommendform.goodsname.value==""){
                alert("请填写商品名称！！！");
                recommendform.goodsname.focus();
                return false;
            }
            if(document.recommendform.price.value==""){
                alert("请填写商品价格！！！");
                recommendform.price.focus();
                return false;
            }
            if(document.recommendform.number.value==""){
                alert("请填写商品数量！！！");
                recommendform.number.focus();
                return false;
            }
            if(document.recommendform.detail.value==""){
                alert("请填写商品详情！！！");
                recommendform.detail.focus();
                return false;
            }
            if(document.recommendform.datefinal.value==""){
                alert("请填写截止时间！！！");
                recommendform.datefinal.focus();
                return false;
            }
            if(!document.recommendform.datefinal.value.match("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                alert("截止时间格式不正确！！！");
                recommendform.datefinal.focus();
                return false;
            }
            document.recommendform.submit();
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
                        + ":" +request.getServerPort()+request.getContextPath()+"/";
                String h1[] = {"h1_1", "h1_2", "h1_3"};
                String h2[] = {"h2_1", "h2_2", "h2_3"};
                String h3[] = {"h3_1", "h3_2", "h3_3"};
                String h4[] = {"h4_1", "h4_2", "h4_3"};
                String h5[] = {"h5_1", "h5_2", "h5_3"};
                String h6[] = {"h6_1", "h6_2", "h6_3"};
                String h7[] = {"h7_1", "h7_2", "h7_3"};
                String h8[] = {"h8_1", "h8_2", "h8_3"};
                String path1[] = new String[3];
                String path2[] = new String[3];
                String path3[] = new String[3];
                String path4[] = new String[3];
                String path5[] = new String[3];
                String path6[] = new String[3];
                String path7[] = new String[3];
                String path8[] = new String[3];
                for (int i=0; i<3; i++){
                    path1[i] = basePath + "resources/recommend/" + h1[i] + ".jpg";
                    path2[i] = basePath + "resources/recommend/" + h2[i] + ".jpg";
                    path3[i] = basePath + "resources/recommend/" + h3[i] + ".jpg";
                    path4[i] = basePath + "resources/recommend/" + h4[i] + ".jpg";
                    path5[i] = basePath + "resources/recommend/" + h5[i] + ".jpg";
                    path6[i] = basePath + "resources/recommend/" + h6[i] + ".jpg";
                    path7[i] = basePath + "resources/recommend/" + h7[i] + ".jpg";
                    path8[i] = basePath + "resources/recommend/" + h8[i] + ".jpg";
                }

            %>
            <center>
                <table width="40%" align="center">
                    <form name="recommendform" action="<c:url value="/images/doRecommendUpload"/> " method="post" enctype="multipart/form-data">
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
                                商品编号：<select name="imagename">
                                <option value="recommend_h1_1">1</option>
                                <option value="recommend_h2_1">2</option>
                                <option value="recommend_h3_1">3</option>
                                <option value="recommend_h4_1">4</option>
                                <option value="recommend_h5_1">5</option>
                                <option value="recommend_h6_1">6</option>
                                <option value="recommend_h7_1">7</option>
                                <option value="recommend_h8_1">8</option>
                            </select>
                                城市：<select name="city">
                                <option value="all">全国</option>
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
                            <td><img src="<%= path1[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path1[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path1[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品1"/></td>
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
                            <td><img src="<%= path2[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path2[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path2[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品2"/></td>
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
                            <td><img src="<%= path3[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path3[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path3[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品3"/></td>
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
                            <td><img src="<%= path4[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path4[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path4[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品4"/></td>
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
                            <td><img src="<%= path5[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path5[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path5[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品5"/></td>
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
                            <td><img src="<%= path6[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path6[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path6[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品6"/></td>
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
                            <td><img src="<%= path7[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path7[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path7[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品7"/></td>
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
                            <td><img src="<%= path8[0] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path8[1] %>"></td>
                        </tr>
                        <tr>
                            <td><img src="<%= path8[2] %>"></td>
                        </tr>
                        <tr>
                            <td>商品编号：<c:out value="推荐商品8"/></td>
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
