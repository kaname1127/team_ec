//fadeIn
$(document).ready(function() {
	$('main-box').fadeIn(2000);
});

$('head').append('<style type="text/css">.is-hide{display:none;}</style>');

$(window).on("load", function() {
	$('body').fadeIn(800).removeClass("is-hide");
});

$(window).on("pageshow", function() {
	if (event.persisted) {
		window.location.reload();
	}
});

$(function() {
	$('a.fadelink').on("click", function() {
		var url = $(this).attr('href');
		if (url != '') {
			$('body').fadeOut(800);
			setTimeout(function() {
				location.href = url;
			}, 800);
		}
		return false;
	});
});

//onclick実行用
function goProductUpdateAction() {
	document.getElementById("form").action = "ProductUpdateAction";
}

function goCreateProductAction() {
	document.getElementById("form").action = "CreateProductAction";
}

function goUserUpdateAction() {
	document.getElementById("form").action = "UserUpdateAction";
}

function goUserRegistAction() {
	document.getElementById("form").action = "UserRegistAction";
}

function goAdminProductSelectAction() {
	document.getElementById("form").action = "AdminProductSelectAction";
}
function goCreateProductAction() {
	document.getElementById("form").action = "CreateProductAction";
}
function goUserListAction() {
	document.getElementById("form").action = "UserListAction";
}
function goUserRegistAction() {
	document.getElementById("form").action = "UserRegistAction";
}
function goAdminPurchaseHistoryAction() {
	document.getElementById("form").action = "AdminPurchaseHistoryAction";
}
function goAdminAllSelectAction() {
	document.getElementById("form").action = "AdminAllSelectAction";
}
function goLoginAction() {
	document.getElementById("form").action = "GoLoginAction";
}
function goLogoutAction() {
	document.getElementById("form").action = "LogoutAction";
}