<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="web.title" /></title>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/style.css"> 
<script type="text/javascript" src="${contextPath}/js/ext-core.js"></script>
<script type="text/javascript" src="${contextPath}/js/context.js"></script>
<script type="text/javascript" src="${contextPath}/js/locale.js"></script>
</head>
<body>

<div id="template-header">
	<tiles:insertAttribute name="header" />
</div>
<div id="template=content">
	<tiles:insertAttribute name="content" />
</div>

</body>
</html>