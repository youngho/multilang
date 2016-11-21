<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
var locale = {};
<c:forEach var="i18nDetail" items="${list}">
locale['${i18nDetail.code}'] = '${i18nDetail.message}';
</c:forEach>