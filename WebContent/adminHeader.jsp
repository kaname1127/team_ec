<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<script src="js/admin.js"></script>
<title>ヘッダー</title>
</head>
<body>
	<header>
		<div id="header">
			<div id="header-title">
				<a href="GoAdminAction" id="logo"><img id="logo"
					src="./png/blacklogo.png"></a><br>
				<h2>Admin</h2>
				<h4>- Limited Authority -</h4>
			</div>

			<div id="header_menu">

				<div class="menu_box">
					<a href="AdminProductSelectAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/product.png">商品一覧</font></a>
				</div>

				<div class="menu_box">
					<a href="CreateProductAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/createproduct.png">商品登録</font></a>
				</div>

				<div class="menu_box">
					<a href="UserListAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/user.png">ユーザー一覧</font></a>
				</div>

				<div class="menu_box">
					<a href="UserRegistAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/registuser.png">ユーザー登録</font></a>
				</div>

				<div class="others">
					<h3>Others</h3>
				</div>

				<div class="menu_box">
					<a href="AdminPurchaseHistoryAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/purchasehistory.png">購入履歴一覧</font></a>
				</div>

				<div class="menu_box">
					<a href="AdminAllSelectAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/db.png">全データ確認</font></a>
				</div>

				<div class="menu_box">
					<a href="LogoutAction"><font color="#f7f9ff"><img
							class="menu_icon" src="./images/icons/logout.png">ログアウト</font></a>
				</div>
			</div>
		</div>
	</header>
</body>
</html>