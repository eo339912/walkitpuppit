<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
							<div class="t1">워킷퍼피와 함께<br>즐겁게 산책해요!</div>
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
				<!-- <div class="con">-- </div> -->
			</div>
			<div class="sec01_con_wrap inner">
					<script type="text/javascript">
					function changeImg(img){
					var mapimg = document.getElementById('map');
					mapimg.src = img;
					}
					</script>
				  <img id="map" src="${pageContext.request.contextPath}/images/main/map_00.png" border="0" usemap="#Map" />
				  <map name="Map">
				    <area shape="poly" href="#" coords="280,43,301,19,322,10,339,16,371,11,405,14,420,29,423,51,441,73,434,83,437,98,433,128,451,141,457,155,457,166,462,186,459,208,443,233,431,232,419,223,407,212,395,212,391,220,381,216,368,198,341,188,322,186,310,190,321,160,321,125,317,108,311,69,297,53,285,46"
				    		onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_08_on.png')"
				    		onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				    ><!-- 동구 -->
				    <area shape="poly" href="#" coords="173,176,178,150,206,130,210,94,195,70,201,50,219,74,227,73,235,58,266,60,281,44,305,70,306,94,311,114,315,130,314,148,306,166,309,174,299,193,283,196,257,188,251,176,233,172,217,168,210,181,192,180" target="_self" 
				    onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_07_on.png')" 
				    onmouseout="${pageContext.request.contextPath}/images/main/map_00.png')"
				    ><!-- 북구 -->
				    <area shape="poly" href="#" coords="185,215,183,189,211,186,222,170,239,180,253,188,257,209,239,225,219,226" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_06_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 서구 -->
				    <area shape="poly" href="#" coords="263,223,285,226,302,213,300,196,277,196,259,199" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_05_on.png')"
				      onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				      ><!-- 중구 -->
				    <area shape="poly" href="#" coords="274,286,287,272,290,222,249,219,241,255,248,271,271,288" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_04_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 남구 -->
				    <area shape="poly" href="#" coords="137,254,139,220,175,218,195,217,211,230,229,230,248,222,248,238,239,254,242,266,267,290,255,309,253,328,232,340,224,321,211,320,187,299,181,288,161,273,150,280,145,276" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_03_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 달서구 -->
				    <area shape="poly" href="#" coords="382,312,398,302,411,286,413,269,403,254,410,247,423,245,415,227,412,215,400,221,389,227,375,214,367,203,355,200,354,202,341,190,319,197,302,215,294,236,286,264,276,285" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_02_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 수성구 -->
				    <area shape="poly" href="#" coords="39,228,55,189,63,178,67,150,81,131,110,114,139,112,141,136,141,158,143,177,159,179,173,192,182,209,155,214,131,219,130,248,100,232,49,236,41,230" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_01_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 달성군1 -->
				    <area shape="poly" href="#" coords="13,432,52,437,79,439,94,431,97,404,71,385,47,361,53,337,75,319,81,291,137,288,154,276,178,283,198,315,235,336,258,331,260,307,277,290,320,299,375,315,383,339,387,360,387,389,383,405,358,423,319,435,297,431,297,402,298,383,275,387,254,393,229,393,211,415,199,419,209,435,209,457,195,469,175,484,181,500,173,516,153,531,111,526,91,547,68,555,42,560,26,557,50,544,67,537,70,523,52,513,34,489,6,457,3,439" target="_self"
				     onmouseover="changeImg('${pageContext.request.contextPath}/images/main/map_01_on.png')" 
				     onmouseout="changeImg('${pageContext.request.contextPath}/images/main/map_00.png')"
				     ><!-- 달성군2-->
				  </map>
			</div>
		</div><!-- main_sec_wrap -->
	</div>
	<!-- section1 -->
	
	<!-- section2 -->
	<div class="section" id="section2">
		<div class="main_sec_wrap dot">
			<div class="main_tit_wrap">
				<div class="tit"><b>MARKET</b><br class="mo"><span class="pc"> : </span>워킷퍼핏 마켓</div>
				<div class="con">워킷퍼핏 마켓에서 애견 상품을 구경하세요.<br>워킷퍼핏에서 인증하는 안전한 판매자들로 믿을 수 있어요.</div>
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
