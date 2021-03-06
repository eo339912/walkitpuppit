<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>

<script>
	function idDupCheck(){
		//1. xhr 객체 생성
		  var xhttp = new XMLHttpRequest();
		//2. 콜백함수지정
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 ) {	//응답완료
		    	if( this.status == 200){	//정상실행
		     		 document.getElementById("idck").innerHTML =
		     									 this.responseText;
		    	}else{
		    		document.getElementById("idck").innerHTML = 
		    											this.status + this.statusText
		    	}	    		
		    }else {
		    	//로딩중
		    	 document.getElementById("idck").innerHTML = "로딩중";
		    }
		  };
		  //3. 서버연결
		  var param = "id=" +document.fwrite.id.value;		  
		  xhttp.open("POST", "idDupCheck.do?", true); //.디폴트가 트루 대부분이 비동기임 동기식의 경우 꼭 순착적 결과까지 확인하고 넘어감  (비동기여부체크)f & t
		  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		  //4.서버 전송
		  xhttp.send(param); //get방식이면 위에 do 옆에 +param . post방식이면 ()안에 넣기
		console.log("ajax 요청시작");
	}
	
	function checkPW(){
		//1. xhr 객체 생성
		  var xhttp = new XMLHttpRequest();
		//2. 콜백함수지정
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 ) {	//응답완료
		    	if( this.status == 200){	//정상실행
		     		 document.getElementById("pwck").innerHTML = this.responseText;
		    	}else{
		    		document.getElementById("pwck").innerHTML = this.status + this.statusText
		    	}	    		
		    }else {
		    	//로딩중
		    	 document.getElementById("pwck").innerHTML = "로딩중";
		    }
		  };
		  //3. 서버연결
		  var param = "pwd=" +document.fwrite.pwd.value;		  
		  xhttp.open("POST", "pwCheck.do?", true); //.디폴트가 트루 대부분이 비동기임 동기식의 경우 꼭 순착적 결과까지 확인하고 넘어감  (비동기여부체크)f & t
		  xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		  //4.서버 전송
		  xhttp.send(param); //get방식이면 위에 do 옆에 +param . post방식이면 ()안에 넣기
	}
	
</script>
<script> var tit01="회원가입수정"</script>

<div id="sub_vis_wrap" class="sub05 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner inner_580">
	<div class="inner inner_580" style="margin-bottom:10em"><!-- skin : basic_voc -->
		<section id="bo_w">
	    <!-- 게시물 작성/수정 시작 { -->
		  	<form action="MypageUpdate.do" method="post" name="fwrite" id="fwrite" enctype="multipart/form-data">
			    <div class="bo_w_info write_div3 half1">
			        <span>아이디</span>
			        <input type="text" name="id" value="${loginId}"  onchange="idDupCheck()" id="id" required="" class="frm_input required" placeholder="아이디">
			        <p id="idck" class="right wp100 pt7 oh"></p>
				</div>
				<div class="bo_w_info write_div3 half1">
			        <span>비밀번호</span>
			        <input type="password" name="pwd" value="${member.pwd}" id="pwd" onchange="checkPW()" required=""  class="frm_input required" placeholder="비밀번호">
			        <p id="pwck" class="right wp100 pt7 oh"></p>
				</div>
				    		
				<div class="bo_w_info write_div3 half1">
			            <span>회원이름</span> 
			            <input type="text" name="name" value="${member.name}" id="name" class="frm_input required" required="" placeholder="회원이름">
			    </div>
		
				
				<div class="clear"></div>
				<div class="wr_box_wrap">
					<span class="wr_t">프로필 사진</span>
					<div class="wr_c">
		    		    <div class="bo_w_flie write_div">
			  				<div class="file_wr write_div">
								<label for="bf_file_1" class="lb_icon"><i class="fa fa-download" aria-hidden="true"></i></label>
								<input type="file" name="filename" id="bf_file_1" class="frm_file"  value="${member.thumd}">
			 				 </div>
						</div>
		    	  	</div>
				</div>
				<div class="clear"></div>
				
		
			    <div class="btn_confirm write_div">
				        <input type="submit" value="보내기" id="btn_submit" accesskey="s" class="btn_submit btn fr">
			    </div>
		    </form>
	
		</section>
	<!-- } 게시물 작성/수정 끝 -->
	</div><!--inner -->
</div>


<%@include file="/common/footer.jsp" %>