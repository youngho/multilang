<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://antop.tistory.com/paging-util" %>

<script type="text/javascript" src="${contextPath}/js/i18n/list.js"></script>

<div>
	<a href="${contextPath}"><spring:message code="link.back" /></a>
	<a href="${contextPath}/i18n/form"><spring:message code="link.register" /></a>
</div>

<table>
	<thead>
		<tr>
			<th><spring:message code="i18n.title.code" /></th>
			<th><spring:message code="i18n.title.desc" /></th>
			<th><spring:message code="i18n.title.message" /></th>
			<th><spring:message code="i18n.title.edit" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="i18n" items="${list}">
		
			<c:url var="detailUrl" value="/i18n/detail/list" >
				<c:param name="code" value="${i18n.code}" />
			</c:url>

			<tr>
				<td><a href="${detailUrl}">${i18n.code}</a></td>
				<td>${i18n.desc}</td>
				<td>${i18n.message}</td>
				<td>
					<c:url var="formUrl" value="/i18n/form">
						<c:param name="code" value="${i18n.code}" />
						<c:param name="page" value="${param.page}" />
					</c:url>
					<a href="${formUrl}"><spring:message code="common.modify" /></a>
					
					<c:url var="removeUrl" value="/i18n/remove">
						<c:param name="code" value="${i18n.code}" />
					</c:url>
					<a href="javascript:void(0)" onclick="doRemove('${i18n.code}')"><spring:message code="common.remove" /></a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<hr />

<p:paging page="${param.page}" size="10" total="${total}" />