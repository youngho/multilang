<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="urlBack" value="/i18n">
	<c:if test="${!empty param.page}">
	<c:param name="page" value="${param.page}" />
	</c:if>
</c:url>

<a href="${urlBack}"><spring:message code="link.back" /></a>

<form action="${contextPath}/i18n/save" method="post">
	<input type="hidden" name="oldCode" value="${i18n.code}" />
	<spring:message code="i18n.title.code" />:
	<input type="text" name="code" value="${i18n.code}" />
	<br />
	<spring:message code="i18n.title.desc" />:
	<input type="text" name="desc" value="${i18n.desc}" />
	<br />
	<spring:message code="i18n.title.message" />:
	<input type="text" name="message" value="${i18n.message}" />
	<br />
	<button type="submit"><spring:message code="button.save" /></button>
	<button type="reset"><spring:message code="button.reset" /></button>
</form>