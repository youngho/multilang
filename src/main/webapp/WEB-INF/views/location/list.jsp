<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="p" uri="http://antop.tistory.com/paging-util" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table>
	<thead>
		<tr>
			<th><spring:message code="location.title.location.id" /></th>
			<th><spring:message code="location.title.street.address" /></th>
			<th><spring:message code="location.title.postal.code" /></th>
			<th><spring:message code="location.title.city" /></th>
			<th><spring:message code="location.title.state.province" /></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="l" items="${list}">
		<tr>
			<td>${l.id}</td>
			<td>${l.streetAddress}</td>
			<td>${l.postalCode}</td>
			<td>${l.city}</td>
			<td>${l.stateProvince}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<hr />
	
<p:paging page="${param.page}" size="10" total="${total}" />