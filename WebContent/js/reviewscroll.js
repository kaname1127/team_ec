$(function() {
	$('a[href^="all"]').click(function() {
		$("#hiddenAllReviewList").removeAttr("id");
		var speed = 100;
		var target = $('#allReviewList');
		var position = target.offset().top;
		$("html, body").animate({
			scrollTop : position
		}, speed, "swing");
		return false;
	});
});
