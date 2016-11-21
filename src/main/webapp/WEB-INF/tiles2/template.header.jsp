<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
<!--
function changeLang(combo) {
	var l = document.location;
	var params;
	
	// GET 파라미터에서 lang 값 갱신
	params = Ext.Object.fromQueryString(document.location.search);
	params['lang'] = combo.value;
	
	l.href = l.pathname + '?' + Ext.Object.toQueryString(params);
}
//-->
</script>

<select id="locale" name="locale" onchange="changeLang(this);">
	<c:forEach var="combo" items="${locales}">
		<option value="${combo.value}"
			<c:if test="${combo.value == locale.language}">selected="selected"</c:if>
		>${combo.display}</option>
	</c:forEach>
</select>

<a href="${contextPath}"><spring:message code="link.home" /></a>

<hr />