<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<meta http-equiv="refresh" content="3;URL='GoAdminAction'" />
<title>登録完了（管理者）</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h1>ユーザー登録完了</h1>
			<div class="success">
				<h3>ユーザー登録が完了しました。</h3>
			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>