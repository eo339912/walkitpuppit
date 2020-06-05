<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/header.jsp"%>


<script> var tit01="받은쪽지함"</script>


<div class="sub_tit_wrap" style="margin: 1em auto;">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em"><!-- skin : basic_voc -->
		<section id="bo_w">
			<input type="hidden" name="seq" value="${param.seq}" id="seq" class="frm_input required" >
		  	<div class="bo_w_info write_div3">
				<span>작성자</span>			 
		  		<p class="add">${message.userid}</p>
			</div>
				
			<div class="bo_w_info write_div3">
				<span>받는사람</span>
			    <p class="add">${message.m_id}</p>
			</div>
				
			<div class="bo_w_tit write_div bo_w_info write_div2">
				<span>제목</span>
				<p class="add">${message.title}</p>
			</div>
				
				
			<div class="write_div  bo_w_info write_div2">
				<span>내용</span>
			    <p class="add">${message.contents}</p>
			</div>
			    
		</section>
		<!-- } 게시물 작성/수정 끝 -->
		</div>
</div>

