<%@page pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ include file="/common/common.jsp"%>
<html>
  <head>
    <meta charset="utf-8">
    <%
	   String path = request.getContextPath();
	   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>"/>
    <title>博客网</title>
  </head>
	<body>
	</body>
</html>