<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://antop.tistory.com/paging-util" %>

<script type="text/javascript" src="${contextPath}/js/i18n/detail/list.js"></script>

<div>
	<a href="${contextPath}/i18n"><spring:message code="link.back" /></a>
	
	<c:url var="registerUrl" value="/i18n/detail/form">
		<c:param name="code" value="${param.code}" />
	</c:url>
	
	<a href="${registerUrl}"><spring:message code="link.register" /></a>
</div>

<table>
	<thead>
		<tr>
			<th><spring:message code="i18n.title.code" /></th>
			<th><spring:message code="i18n.title.language" /></th>
			<th><spring:message code="i18n.title.message" /></th>
			<th><spring:message code="i18n.title.edit" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i18nDtl" items="${list}">
			<tr>
				<td>${i18nDtl.code}</td>
				<td>${i18nDtl.language}</td>
				<td>${i18nDtl.message}</td>
				<td>
					<c:url var="formUrl" value="/i18n/detail/form">
						<c:param name="code" value="${i18nDtl.code}" />
						<c:param name="language" value="${i18nDtl.language}" />
						<c:param name="page" value="${param.page}" />
					</c:url>
					<a href="${formUrl}"><spring:message code="common.modify" /></a>
					<a href="javascript:void(0)" onclick="doRemove('${i18nDtl.code}', '${i18nDtl.language}')"><spring:message code="common.remove" /></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>