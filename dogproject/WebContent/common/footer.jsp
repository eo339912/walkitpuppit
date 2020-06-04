<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<footer id="ft_Wrap">
	<div class="ft_top_wrap">
		<div class="w-inner">
			<div class="ft_top_bx">
				<span class="tit">NOTICE</span>
				<div class="con ft_slide">
					<c:forEach items="${footerBoard}" var="vo">
					<div class="c1"><a href="BoardViewForm.do?seq=${vo.seq}">${vo.title}</a></div>
					</c:forEach>
				</div>
				<a class="link" href="BoardList.do"><img src="./images/common/icon_arw_1.png " /></a>
			</div>
			<div class="ft_top_bx">
				<span class="tit">REVIEW</span>
				<div class="con ft_slide">
					<c:forEach items="${footerReview}" var="vo">
					<div class="c1"><a href="ReviewViewForm.do?seq=${vo.seq}">${vo.title}</a></div>
					</c:forEach>
				</div>
				<a class="link" href="ReviewList.do"><img src="./images/common/icon_arw_1.png " /></a>
			</div>
		</div>
	</div>

	<div class="Clear"></div>
	<div class="w-inner ft_in_bx">
		<div class="ft_bt_wrap ">
			워키토키<span>·</span>아롸/혜온/지온<br class="mo"><span class="pc">·</span>대구 중구 국채보상로 537<br>
			<b class="copy">COPYRIGHT ⓒ 2020 WorkitTokitWalkitPuppy. ALL RIGHTS RESERVED.</b>
		</div>
	</div>
</footer>

<script type="text/javascript">
	$('.ft_slide').slick({
		dots: false,
		arrows:false,
		infinite: true,
		speed:500,
		fade: true,
		cssEase: 'linear',
		autoplay: true,
		autoplaySpeed: 2000
	});
</script>

</body>
</html>