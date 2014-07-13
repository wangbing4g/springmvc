<%@tag pageEncoding="UTF-8" import="org.springframework.data.domain.Page"%>
<%@ attribute name="name" type="java.lang.String" required="true"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="false"%>

<%if(page == null) {page = (Page)request.getAttribute("page");}%>

<%if (page.getSort()!=null&&page.getSort().getOrderFor(name) != null && page.getSort().getOrderFor(name).isAscending()) {%>
<a href="?page=1&sort=${name}&order=DESC&${searchParams}"><jsp:doBody/>▼</a>
<%}else {%>
<a href="?page=1&sort=${name}&order=ASC&${searchParams}"><jsp:doBody/>▲</a>
<%}%>