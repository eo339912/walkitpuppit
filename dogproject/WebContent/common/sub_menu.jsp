<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<div class="sub_menu_wrap sub_menu_pc">
	<div class="sub_menu_tit">
		<script>document.write(tit01);</script>
		<div class="btn"><span></span></div>
	</div>

	<ul class="sub_menu_box sub01 ">
         <li class="gnb_dp2"><a href="javascript:GoPage('intro01')">�߱�</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro03')">�޼���</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro04')">������</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro05')">����</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro06')">�޼���</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro07')">�ϱ�</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro07')">����</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('intro07')">����</a></li>
	</ul>

	<ul class="sub_menu_box sub02 ">
         <li class="gnb_dp2"><a href="javascript:GoPage('process01')">�߰�ŷ�</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('process01')">���ᳪ��</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('process01')">�ı�Խ���</a></li>
	</ul>

	<ul class="sub_menu_box sub03 ">
         <li class="gnb_dp2"><a href="javascript:GoPage('product01')">����������</a></li>
         <li class="gnb_dp2"><a href="javascript:GoPage('product01')">�� �����丮</a></li>
	</ul>

	<ul class="sub_menu_box sub04 ">
         <li class="gnb_dp2"><a href="javascript:GoPage('product01')">��������</a></li>
	</ul>
	
	<ul class="sub_menu_box sub05 ">
        <li class="gnb_dp2"><a href="MemberInsert.do">ȸ������</a></li>
        <li class="gnb_dp2"><a href="MemberLogin.do">�α���</a></li>
	</ul>

</div>


<script>
	$(document).ready(function(){
		$('.sub_menu_tit').click(function(){
			$('.sub01 .sub_menu_box.sub01, .sub02 .sub_menu_box.sub02, .sub03 .sub_menu_box.sub03, .sub04 .sub_menu_box.sub04, .sub05 .sub_menu_box.sub05, .sub06 .sub_menu_box.sub06, .sub07 .sub_menu_box.sub07, .sub08 .sub_menu_box.sub08').slideToggle(200);
			if($(this).hasClass('on')){
				$(this).removeClass('on');
			}else{
				$(this).addClass('on');
			}	
		});
	});
</script>