<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="urlBack" value="/i18n/detail">
	<c:param name="code" value="${param.code}" />
	<c:if test="${!empty param.page}">
	<c:param name="page" value="${param.page}" />
	</c:if>
</c:url>

<a href="${urlBack}"><spring:message code="link.back" /></a>

<form action="${contextPath}/i18n/detail/save" method="post">
	<input type="hidden" name="code" value="${i18nDetail.code}" />
	<c:if test="${i18nDetail.language != null}">
	<input type="hidden" name="language" value="${i18nDetail.language}" />
	</c:if>
	
	<table>
		<tr>
			<th><spring:message code="i18n.title.code" /></th>
			<td>${i18nDetail.code}</td>
		</tr>
		<tr>
			<th><spring:message code="i18n.title.language" /></th>
			<td>
				<c:choose>
					<c:when test="${param.language != null}">
						${i18nDetail.languageName}
					</c:when>
					<c:otherwise>
						<select name="language">
							<c:forEach var="i18n" items="${i18nList}">
								<option value="${i18n.language}">${i18n.languageName}</option>
							</c:forEach>
						</select>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th><spring:message code="i18n.title.message" /></th>
			<td><input type="text" name="message" value="${i18nDetail.message}" /></td>
		</tr>
	</table>
	
	<button type="submit"><spring:message code="button.save" /></button>
	<button type="reset"><spring:message code="button.reset" /></button>
</form>