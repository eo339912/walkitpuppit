<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@include file="/common/header.jsp"%>
<jsp:include page="/common/top.jsp"/>


<script> var tit01="��������"</script>

<div id="sub_vis_wrap" class="sub04 page01">
	<%@include file="/common/sub_vis.jsp"%>
	<jsp:include page="/common/sub_menu.jsp"/>
</div>
<div class="sub_tit_wrap">
	<span><script>document.write(tit01);</script></span>
</div>

<div id="sub_content_wrap"  class="sub0401 inner">
	<div class="inner" style="margin-bottom:10em">
		<!-- �Խ��� ��� ���� { -->
		<div id="bo_list" style="width:100%" class="sub_board">
		  <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
		    <div class="tbl_head01 tbl_wrap">
		        <table>
			        <caption>�Խ��� ���</caption>
			        <thead>
			        <tr>
			            <th scope="col" width="15%">��ȣ</th>
			            <th scope="col">����</th>
			            <th scope="col" width="15%">�۾���</th>
			            <th scope="col" width="15%">��¥  <i class="fa fa-sort" aria-hidden="true"></i></th>
			        </tr>
			        </thead>
			        <tbody>
			            <tr class="">
			            	<td class="td_num2">1</td>
				            <td class="td_subject" style="padding-left:0px">
			                	<div class="bo_tit"><a href="#">2</a></div>
							</td>
			            	<td class="td_name sv_use"><span class="sv_member">3</span></td>
			                <td class="td_datetime">4</td>
			      	 	 </tr>
			        </tbody>
		        </table>
		    </div>
		    </form>
		     
		       <!-- �Խ��� �˻� ���� { -->
		    <fieldset id="bo_sch">
		        <legend>�Խù� �˻�</legend>		
		        <form name="fsearch" method="get">
		        <input type="text" name="stx" value="" required="" id="stx" class="sch_input" size="25" maxlength="20" placeholder="�˻�� �Է����ּ���">
		        <button type="submit" value="�˻�" class="sch_btn"><i class="fa fa-search" aria-hidden="true"></i><span>�˻�</span></button>
		        </form>
		    </fieldset>
		    <!-- } �Խ��� �˻� �� -->   
		</div>
				
		<!-- } �Խ��� ��� �� -->
		</div>
</div>



<%@include file="/common/footer.jsp" %>