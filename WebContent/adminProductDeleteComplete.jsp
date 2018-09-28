<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<meta http-equiv="refresh" content="3;URL='GoAdminAction'" />
<title>商品削除完了</title>
</head>

<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h2>商品削除完了</h2>
			<div class="success">
				<h3>商品を削除しました。</h3>
			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>