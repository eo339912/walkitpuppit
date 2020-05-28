<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<footer id="ft_Wrap">
	<div class="ft_top_wrap">
		<div class="w-inner">
			<div class="ft_top_bx">
				<span class="tit">NOTICE</span>
				<div class="con ft_slide">
				
					<div class="c1"><a href="#">푸드팩토리 2019년 01월 홈페이지 오픈 안내1</a></div>
					<div class="c1"><a href="#">푸드팩토리 2019년 01월 홈페이지 오픈 안내2</a></div>
					<div class="c1"><a href="#">푸드팩토리 2019년 01월 홈페이지 오픈 안내3</a></div>
					<div class="c1"><a href="#">푸드팩토리 2019년 01월 홈페이지 오픈 안내4</a></div>
					<div class="c1"><a href="#">푸드팩토리 2019년 01월 홈페이지 오픈 안내5</a></div>
				
				</div>
				<a class="link" href="javascript:GoPage('cs01')"><img src="${pageContext.request.contextPath}/images/common/icon_arw_1.png " /></a>
			</div>
			<div class="ft_top_bx">
				<span class="tit">NEWS</span>
				<div class="con ft_slide">
					
					<div class="c1"><a href="#">[아리랑TV] 푸드팩토리 공정과정 소개에 대한 안내1</a></div>
					<div class="c1"><a href="#">[아리랑TV] 푸드팩토리 공정과정 소개에 대한 안내2</a></div>
					<div class="c1"><a href="#">[아리랑TV] 푸드팩토리 공정과정 소개에 대한 안내3</a></div>
					<div class="c1"><a href="#">[아리랑TV] 푸드팩토리 공정과정 소개에 대한 안내4</a></div>
					<div class="c1"><a href="#">[아리랑TV] 푸드팩토리 공정과정 소개에 대한 안내5</a></div>
					
				</div>
				<a class="link" href="javascript:GoPage('cs02')"><img src="${pageContext.request.contextPath}/images/common/icon_arw_1.png " /></a>
			</div>
		</div>
	</div>

	<div class="Clear"></div>
	<div class="w-inner ft_in_bx">
		<div class="ft_mid_wrap">
			<a href="javascript:GoPage('intro01')">회사소개</a><span></span><a href="javascript:GoPage('mem01')">개인정보처리방침</a><span></span><a href="javascript:GoPage('mem02')">이메일무단수집거부</a><span></span><a href="javascript:GoPage('cs04')">주문ERP</a>
		</div>
		<div class="ft_bt_wrap ">
			농업회사법인 주식회사 푸드팩토리<span>·</span>대표이사 김경민<br class="mo"><span class="pc">·</span>사업자번호 510-81-33410<span>·</span>경상북도 김천시 아포읍 덕계길 137<br class="mo"><span class="pc">·</span>TEL 054-434-3060<span>·</span>FAX 054-437-3060<br>
			<b class="copy">COPYRIGHT ⓒ 2019 FOODFACTORY. ALL RIGHTS RESERVED.</b>
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