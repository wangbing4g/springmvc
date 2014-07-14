<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<form id="inputForm" action="${ctx}/user/${action}" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${user.id}"/>
		<fieldset>
			<legend><small>管理用户</small></legend>
			<div class="control-group">
				<label for="user_name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="user_name" name="userName"  value="${user.userName}" class="input-large required" minlength="3"/>
				</div>
			</div>	
			<div class="control-group">
				<label for="user_email" class="control-label">邮箱:</label>
				<div class="controls">
					<input type="text" id="user_email" name="email"  value="${user.email}" class="input-large email required" minlength="3"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#user_name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</body>
</html>
