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
			<div id="dd" class="action_buttonbar">
			  <div>
						<label for="login">账号:&nbsp;</label> 
						<%=session.getAttribute("login")%>
					</div>
					
					<div>
						<label for="pass">密码:&nbsp;</label> 
						<%=session.getAttribute("pass")%>
					</div>
					<div>
						<label for="sex">性别:&nbsp;</label> 
						<%=session.getAttribute("sex")%>
					</div>
					<div>
						<label for="phone">电话:&nbsp;</label> 
						<%=session.getAttribute("phone")%>
					</div>
					<div>
						<label for="email">邮箱:&nbsp;</label> 
						<%=session.getAttribute("email")%>
						<label for="money">余额:&nbsp;</label> 
						<%=session.getAttribute("money")%>
					</div>
			  
			  <input type="button" value="返回首页" onclick="window.open('${shop}/index.jsp','_self')" style="width:60px;height:30px" />
			   <div style="clear:both"></div>
			</div>
		</div>
		<%@include file="template/footer.jsp" %>
	</div>
</body>
</html>
