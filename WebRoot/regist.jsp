<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="/public/head.jspf"%>
<style type="text/css">
#dd div {
	padding: 5px;
}
</style>
<script type="text/javascript">
window.onload = function() {
	var input1 = document.getElementsByName("login")[0];
	var username = document.getElementById("login");
	input1.onfocus = function(){//用户名获取焦点
		username.innerHTML = "<font color ='#7B7B7B'>账号不能为空</font>";
		};
	input1.onblur = function(){//用户名失去焦
	var str1 = /^[A-Za-z][A-Za-z0-9_-]*/g;
	if(!str1.test(input1.value)){
		username.innerHTML = "<font color ='red'>账号必须是大小写字母开头，其他位必须是大小写字符、数字、下划线</font>";
		if(input1.value.length > 6){
		username.innerHTML = "<font color ='red'>账号必须小于6位数,请重新输入</font>";
			}
		}else{
		username.innerHTML = "<font color ='green'>输入正确</font>";	
		}	
	};
	
	var input2 = document.getElementsByName("pass")[0];
	var password = document.getElementById("pass");
	input2.onfocus = function(){//密码获取焦点
		password.innerHTML = "<font color ='#7B7B7B'>密码不能为空</font>";
		};
	input2.onblur = function(){//密码失去焦点
		if(input2.value.length > 6){
		password.innerHTML = "<font color ='red'>密码必须小于6位数,请重新输入</font>";
			}
		if(input2.value.length >0&&input2.value.length <6){
		password.innerHTML = "<font color ='green'>输入正确</font>";		
			}
		if(input2.value.length == ""||input2.value.length == null){
			password.innerHTML = "<font color ='#7B7B7B'>密码不能为空</font>";
		}
	};
	
	var input5 = document.getElementsByName("repassword")[0];
	var repassword = document.getElementById("repassword");
	input5.onfocus = function(){//重复密码获取焦点
		repassword.innerHTML = "<font color ='#7B7B7B'>密码不能为空";
		};
	input5.onblur = function(){//重复密码失去焦点
		if(input5.value!=input2.value){
		repassword.innerHTML = "<font color ='red'>两次密码输入不一致,请重新输入</font>";
			}else{
		repassword.innerHTML = "<font color ='green'>输入正确</font>";
			}
	};

	
	var input3 = document.getElementsByName("phone")[0];
	var phone = document.getElementById("phone");
	input3.onfocus = function(){//手机号码获取焦点
		phone.innerHTML = "<font color ='#7B7B7B'>手机号码不能为空</font>";
		};
	input3.onblur = function(){//手机失去焦点
		if(input3.value.length !=11){
		phone.innerHTML = "<font color ='red'>您输入的手机号码不正确,请重新输入</font>";
			}else{
		phone.innerHTML = "<font color ='green'>输入正确</font>";
			}
	};
	
	var input4 = document.getElementsByName("email")[0];
	var email = document.getElementById("email");
	input4.onfocus = function(){//邮箱获取焦点
		email.innerHTML = "<font color ='#7B7B7B'>邮箱不能为空</font>";
		};
	input4.onblur = function(){//邮箱失去焦点
	 var str = /^[A-Za-z0-9][A-Za-z0-9_-]*@[a-z0-9]+\.(com|cn|org|net)$/g;
		if(!str.test(input4.value)){
		email.innerHTML = "<font color ='red'>邮箱格式不正确,请重新输入</font>";
			}else{
		email.innerHTML = "<font color ='green'>输入正确</font>";		
			}
	};
};

</script>

</head>
<body>
	<div class="wrapper">
		<%@include file="template/head.jsp"%>
		<div class="section_container">
			<!-- 购物车 -->
			<div id="dd" class="action_buttonbar">
				<form method="post" action="${shop}/Regist">
					<div>
						<label for="login">账号&nbsp;:&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="text" name="login" />
						<span id="login"></span>
					</div>
					<div>
						<label for="pass">密码&nbsp;:&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="password" name="pass" />
						<span id="pass"></span>
						<label for="repassword">重复密码&nbsp;:&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="password" name="repassword" />
						<span id="repassword"></span>
					</div>
					<div>
						<label for="sex">性别&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label>&nbsp;&nbsp;&nbsp; 
						<input type="radio" name="sex" value="男" />&nbsp;男 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="radio" name="sex" value="女" />&nbsp;女
					</div>
					<div>
						<label for="phone">手机电话&nbsp;:&nbsp;</label> 
						<input type="text" name="phone" />
							<span id="phone"></span>
					</div>
					<div>
						<label for="email">邮箱&nbsp;:&nbsp;</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input type="text" name="email" />
							<span id="email"></span>&nbsp;&nbsp;&nbsp;&nbsp;
					    <label for="money">余额&nbsp;:&nbsp;</label>&nbsp;&nbsp;&nbsp; 
						<input type="text" name="money" />
					</div>

					<!--  <div>
						${sessionScope.error}  
					</div>
					-->
					<div>
						<input type="submit" value="注册" style="width: 60px; height: 30px" />
						<input type="button" value="返回首页"
							onclick="window.open('${shop}/index.jsp','_self')"
							style="width: 60px; height: 30px" />
					</div>
				</form>
				<div style="clear: both"></div>
			</div>
		</div>
		<%@include file="template/footer.jsp"%>
	</div>
</body>
</html>
