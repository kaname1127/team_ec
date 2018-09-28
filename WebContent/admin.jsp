<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="js/admin.js"></script>
<title>管理者画面</title>
</head>

<body class="is-hide">

	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div class="contents">
			<div class="main-box">
				<h1>
					<img src="images/icons/home.png"> Dashboard
				</h1>
				<h4>
					Since you have a special authority,<br> you can edit some of
					the information.
				</h4>
			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>

</body>
</html>
