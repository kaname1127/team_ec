<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/productDetails.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/inputForm.css">
<link rel="stylesheet" href="./css/confirm.css">
<link rel="stylesheet" href="./css/complete.css">
<link rel="stylesheet" href="./css/table.css">
<meta http-equiv="refresh" content="3;URL='ProductDetailsAction'" />
<title>投稿完了</title>
</head>
<body>

<jsp:include page="header.jsp" />

<div id="contents">
	<div id="complete-box">
		<p>レビューが投稿されました！</p>
		<p>３秒後に商品詳細画面へ戻ります</p>
	</div>
</div>

<s:include value="footer.jsp" />

</body>
</html>