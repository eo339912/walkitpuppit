<script language="javascript">
function GoPage(code) {
	if ( !code )						{	window.location = "/";	}
	
	else if ( code == "main" )			{	window.location = "/index.php";		} //메인
	
	else if ( code == "intro01" )		{	window.location = "/doc/intro01.php"; } //회사소개
	else if ( code == "intro02" )		{	window.location = "/doc/intro02.php"; }
	else if ( code == "intro03" )		{	window.location = "/doc/intro03.php"; }
	else if ( code == "intro04" )		{	window.location = "/doc/intro04.php"; }
	else if ( code == "intro05" )		{	window.location = "/doc/intro05.php"; }
	else if ( code == "intro06" )		{	window.location = "/doc/intro06.php"; }
	else if ( code == "intro07" )		{	window.location = "/doc/intro07.php"; }

	else if ( code == "process01" )		{	window.location = "/doc/process01.php"; } //제조공정
	else if ( code == "process02" )		{	window.location = "/doc/process02.php"; }

	else if ( code == "product01" )		{	window.location = "/doc/product01.php"; } //제품소개
	else if ( code == "product02" )		{	window.location = "/doc/product02.php"; }
	else if ( code == "product03" )		{	window.location = "/doc/product03.php"; }

	else if ( code == "cs01" )		{	window.location = "/pg/bbs/board.php?bo_table=comm01"; } //회사소개
	else if ( code == "cs02" )		{	window.location = "/pg/bbs/board.php?bo_table=comm02"; }
	else if ( code == "cs03" )		{	window.location = "/pg/bbs/write.php?bo_table=comm03"; }
	else if ( code == "cs04"  )		{	window.open('url', '_blank'); }

	else if ( code == "mem01" )		{	window.location = "/doc/mem01.php"; } //개인정보처리방침
	else if ( code == "mem02" )		{	window.location = "/doc/mem02.php"; }
}
</script>
