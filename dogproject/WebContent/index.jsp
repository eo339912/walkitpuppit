<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>
<div id="foodfactory">

	<!-- section0 -->
	<div class="section " id="section0">
		
		<div id="moveSectionDown" class="scroll"><img src="${pageContext.request.contextPath}/images/main/main_vis_mouse.png" alt="scroll" oncontextmenu="return false;"></div>
		<div class="main_vis_wrap dot_wh">
			<div class="main_vis_img_wrap">
				<div class="vis_img img1">
					<div class="main_vis_txt_wrap">
						<div class="txt_wrap">
							<div class="t0"><img src="${pageContext.request.contextPath}/images/main/main_vis_icon.png" /></div>
							<div class="t1">오늘은<br>어떤 친구를 <br class="mo">만날까?</div>
						</div>
					</div>
				</div>
				<div class="vis_img img2">
					<div class="main_vis_txt_wrap">
						<div class="txt_wrap">
							<div class="t0"><img src="${pageContext.request.contextPath}/images/main/main_vis_icon.png" /></div>
							<div class="t1">안전한 산책로 루트를<br>친구들과 함께 공유해요!</div>
						</div>
					</div>
				</div>
				<div class="vis_img img3">
					<div class="main_vis_txt_wrap">
						<div class="txt_wrap">
							<div class="t0"><img src="${pageContext.request.contextPath}/images/main/main_vis_icon.png" /></div>
							<div class="t1">월킷퍼피와 함께<br>즐겁게 산책해요!</div>
						</div>
					</div>
				</div>
			</div>
		</div><!-- main_vis_wrap -->
	</div>
	<!-- section0 -->

	<!-- section1 -->
	<div class="section" id="section1">
		<div class="main_sec_wrap">
			<div class="main_tit_wrap">
				<div class="tit"><b>WALK</b><br class="mo"><span class="pc"> : </span>산책로</div>
				<div class="con">-- </div>
			</div>
			<div class="sec01_con_wrap inner">
				<div class="con_bx bx1" onclick="javascript:GoPage('product01')">
					 <script type="text/javascript" src="${pageContext.request.contextPath}/main/d3.js"></script>
   					 <script type="text/javascript" src="${pageContext.request.contextPath}/main/korea.js"></script>
					<div id="container"></div>
				</div>
				<!-- <div class="con_bx bx3" onclick="javascript:GoPage('product03')">
					<div class="txt_wrap">
						<div class="t1">한컵에 영양<br>듬뿍 담았 大</div>
						<div class="t2">큰컵</div>
					</div>
					<div class="img"></div>
				</div> -->
			</div>
		</div><!-- main_sec_wrap -->
	</div>
	<!-- section1 -->
	
	<!-- section2 -->
	<div class="section" id="section2">
		<div class="main_sec_wrap dot">
			<div class="main_tit_wrap">
				<div class="tit"><b>MARKET</b><br class="mo"><span class="pc"> : </span>월킷퍼핏 마켓</div>
				<div class="con">월킷퍼핏 마켓에서 애견 상품을 구경하세요.<br>월킷퍼핏에서 인증하는 안전한 판매자들로 믿을 수 있어요.</div>
			</div>
			<div class="sec02_con_wrap  w-inner">
				
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">과일 편의식품 생산기업 "푸드팩토리"의 새로운 도전</div>
							<div class="c">비즈스마트에 출연한 푸드팩토리의 영상을 확인해보세요. 푸드팩토리는 </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">과일 편의식품 생산기업 "푸드팩토리"의 새로운 도전</div>
							<div class="c">비즈스마트에 출연한 푸드팩토리의 영상을 확인해보세요. 푸드팩토리는 </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">과일 편의식품 생산기업 "푸드팩토리"의 새로운 도전</div>
							<div class="c">비즈스마트에 출연한 푸드팩토리의 영상을 확인해보세요. 푸드팩토리는 </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">과일 편의식품 생산기업 "푸드팩토리"의 새로운 도전</div>
							<div class="c">비즈스마트에 출연한 푸드팩토리의 영상을 확인해보세요. 푸드팩토리는 </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
			</div>
		</div><!-- main_sec_wrap -->
	</div>
	<!-- section2 -->

	<!-- section4 -->
	<div class="section fp-auto-height" id="section4">
		<%@include file="/common/footer.jsp" %>
	</div>
	<!-- section4 -->
</div>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/fullpages/fullpage.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/fullpages/fullpage.css" />

<script type="text/javascript">
    var myFullpage = new fullpage('#foodfactory', {

		//anchors: ['firstPage', 'secondPage', '3rdPage', '4rdPage', '5rdPage'],
		//sectionsColor: ['#C63D0F', '#1BBC9B', '#7E8F7C', '#1BBC9B', '#7E8F7C'],
		navigation:true,
		navigationTooltips: ['HOME', 'SPOT', 'MARKET'],
		showActiveTooltip: true,
		css3: true
    });

	$('.main_vis_img_wrap').slick({
		dots: true,
		arrows:false,
		infinite: true,
		speed:500,
		fade: true,
		cssEase: 'linear',
		autoplay: true,
		autoplaySpeed: 3000
	});

	$('.sec02_con_wrap').slick({
		dots: true,
		infinite: true,
		speed: 300,
		slidesToShow: 4,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 3000,
		responsive: [
			{
			breakpoint:1100,
				settings: { slidesToShow: 3, slidesToScroll: 1
				}
			},
			{
			breakpoint:850,
				settings: { slidesToShow: 2, slidesToScroll: 1
				}
			},
			{
			breakpoint:550,
				settings: { slidesToShow: 1, slidesToScroll: 1
				}
			}
		]
	});
	
	$('#hd_wrap').css('background','rgba(0,0,0,0.15)');
	
	
		
</script>
