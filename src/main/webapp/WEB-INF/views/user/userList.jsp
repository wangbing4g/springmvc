<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<h1>用户管理</h1>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	
	<div class="row">
		<div class="offset4">
			<form class="form-search" action="#">
			 	<label>登录名：</label> <input type="text" name="userName"   class="input-small"  value="${userSearchDto.userName}"> 
			    <label>邮件名：</label> <input type="text" name="email" class="input-small" value="${userSearchDto.email}">
			    <button type="submit" class="btn" id="search_btn">Search</button>
		    </form>
	    </div>
	</div>	
	
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th><tags:sortable name="userName">任务</tags:sortable></th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${page.content}" var="user">
			<tr>
				<td><a href="${ctx}/user/update/${user.id}">${user.userName}</a></td>
				<td><a href="${ctx}/user/update/${user.id}">${user.password}</a></td>
				<td>
					<div class="controls">
					  <a href="${ctx}/user/delete/${user.id}"><i class="icon-edit"></i></a>
					  <a href="${ctx}/user/delete/${user.id}"><i class="icon-remove"></i></a>
					</div>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<tags:pagination page="${page}" paginationSize="10"/>

</body>
</html>
