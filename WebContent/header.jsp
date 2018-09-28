<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css">
<title>ヘッダー</title>
<script>
function goHomeAction(){
	document.getElementById("form").action="HomeAction";
}

function goLoginAction(){
	document.getElementById("form").action="GoLoginAction";
}
function goMyPageAction(){
	document.getElementById("form").action="MyPageAction";
}
function goCartAction(){
	document.getElementById("form").action="CartAction";
}
function goProductListAction(){
	document.getElementById("categoryId").value=null;
	document.getElementById("keywords").value="";
	document.getElementById("form").action="SearchItemAction";
}
function goLogoutAction(){
	document.getElementById("form").action="LogoutAction";
}
function goSearchItemAction(){
	document.getElementById("form").action="SearchItemAction";
}

$(function() {
	$('form').attr('autocomplete', 'new-password');
	});

</script>
</head>
<body>
<div id="headerreturnbutton"><img src="./icon/sironuki.png"></div>
<header id="header_delete">
<div id="header_bg"></div>





<div id="returnBox">
<img id="headerbutton" src="./png/close.png">
</div>

<div id="mds1">
<p>menu</p>
</div>

<s:form id="form" name="form">

<div class="menuBox">

<s:submit value="ホーム画面へ" class="men" onclick="goHomeAction();"/>

<s:if test="#session.logined==1">
<s:submit value="ログアウト"  class="men" onclick="goLogoutAction();"/>
</s:if>
<s:else>
<s:submit value="ログイン"  class="men" onclick="goLoginAction();"/>
</s:else>

<s:submit value="カート" class="men" onclick="goCartAction();"/>

<s:submit value="商品一覧" class="men" onclick="goProductListAction();"/>

<s:if test="#session.logined==1">
<s:submit value="マイページ" class="men" onclick="goMyPageAction();"/>
</s:if>
<s:else>
<div class="whitemen"></div>
</s:else>
</div>
<div id="mds1">
<p>search</p>
</div>
<div class="searchbox">
<s:if test='#session.containsKey("mCategoryDtoList")'>
<s:select name="categoryId" list="#session.mCategoryDtoList" listValue="categoryName" listKey="categoryId" class="se1" id="categoryId"/>
</s:if>

<s:textfield name="keywords" id="keywords" class="se2" placeholder="検索ワード" />

<s:submit value="商品検索" class="se3" onclick="goSearchItemAction();"/>
</div>
</s:form>

</header>

<script type="text/javascript" src="./js/header.js"></script>
</body>
</html>