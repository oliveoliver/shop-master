<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/public/head.jspf"%>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
<body>
	<div class="wrapper">
		<%@include file="template/head.jsp" %>
		<div class="section_container">
			<div id="dd" class="action_buttonbar" style="text-align:center;">
			  注册成功！<br/>
			  <input type="button" value="返回首页" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" />
			   <div style="clear:both"></div>
			</div>
		</div>
		<%@include file="template/footer.jsp" %>
	</div>
</body>
</html>
