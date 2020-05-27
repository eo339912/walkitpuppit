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
							<div class="t1">������<br>� ģ���� <br class="mo">������?</div>
						</div>
					</div>
				</div>
				<div class="vis_img img2">
					<div class="main_vis_txt_wrap">
						<div class="txt_wrap">
							<div class="t0"><img src="${pageContext.request.contextPath}/images/main/main_vis_icon.png" /></div>
							<div class="t1">������ ��å�� ��Ʈ��<br>ģ����� �Բ� �����ؿ�!</div>
						</div>
					</div>
				</div>
				<div class="vis_img img3">
					<div class="main_vis_txt_wrap">
						<div class="txt_wrap">
							<div class="t0"><img src="${pageContext.request.contextPath}/images/main/main_vis_icon.png" /></div>
							<div class="t1">��Ŷ���ǿ� �Բ�<br>��̰� ��å�ؿ�!</div>
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
				<div class="tit"><b>WALK</b><br class="mo"><span class="pc"> : </span>��å��</div>
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
						<div class="t1">���ſ� ����<br>��� ��� ��</div>
						<div class="t2">ū��</div>
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
				<div class="tit"><b>MARKET</b><br class="mo"><span class="pc"> : </span>��Ŷ���� ����</div>
				<div class="con">��Ŷ���� ���Ͽ��� �ְ� ��ǰ�� �����ϼ���.<br>��Ŷ���Ϳ��� �����ϴ� ������ �Ǹ��ڵ�� ���� �� �־��.</div>
			</div>
			<div class="sec02_con_wrap  w-inner">
				
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">���� ���ǽ�ǰ ������ "Ǫ�����丮"�� ���ο� ����</div>
							<div class="c">�����Ʈ�� �⿬�� Ǫ�����丮�� ������ Ȯ���غ�����. Ǫ�����丮�� </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">���� ���ǽ�ǰ ������ "Ǫ�����丮"�� ���ο� ����</div>
							<div class="c">�����Ʈ�� �⿬�� Ǫ�����丮�� ������ Ȯ���غ�����. Ǫ�����丮�� </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">���� ���ǽ�ǰ ������ "Ǫ�����丮"�� ���ο� ����</div>
							<div class="c">�����Ʈ�� �⿬�� Ǫ�����丮�� ������ Ȯ���غ�����. Ǫ�����丮�� </div>
							<a href="#" class="link_st_1">More > </a>
						</div>
					</a>
				</div>
				<div class="con_bx">
					<a href="#">
						<div class="img"><img src="${pageContext.request.contextPath}/images/main/sec02_img_01.png" /></div>
						<div class="txt">
							<div class="t">���� ���ǽ�ǰ ������ "Ǫ�����丮"�� ���ο� ����</div>
							<div class="c">�����Ʈ�� �⿬�� Ǫ�����丮�� ������ Ȯ���غ�����. Ǫ�����丮�� </div>
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
