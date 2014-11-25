<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/admintop1.css"/>"/>

<div id="nav">
    <div id="topic"></div>
    <div>
        <ul>
            <li><a href = " <c:url value="/welcome"/> ">登陆</a> </li>
            <li><a href = " <c:url value="/managerpage/allmanager"/>" >管理员管理</a></li>
            <li><a href = " <c:url value="/images/homeviewpager"/> ">首页滑动</a></li>
            <li><a href = " <c:url value="/images/homeblock"/> ">首页分类</a></li>
            <li><a href = "<c:url value="/images/blockgoods"/>" >分类内容</a></li>
            <li><a href = "<c:url value="/images/recommend"/>" >推荐商品</a></li>
            <li><a href = "<c:url value="/images/city"/>" >城市管理</a></li>
            <li><a href = "<c:url value="/info/showQueryInfoPage"/>" >信息公布</a></li>
            <li><a href = "<c:url value="/managerpage/logout"/>">注销</a></li>
        </ul>
    </div>
</div>
<div id="navbar"></div>