<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="leftbar" class="span2">
	<div class="submenu">
		<a id="user-tab" href="${ctx}/user/">用户管理</a>
		<a id="dept-tab" href="${ctx}/dept/">部门管理</a>
		<a id="role-tab" href="${ctx}/role/">角色管理</a>
	</div>
</div>