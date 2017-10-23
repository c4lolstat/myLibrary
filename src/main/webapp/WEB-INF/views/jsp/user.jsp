<%--
Created by IntelliJ IDEA.
User: Farkas
Date: 2017.10.19.
Time: 21:08
To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
    <head>
        <spring:url value="/resources/core/css/hello.css" var="coreCss" />
        <spring:url value="/resources/core/js/library.js" var="coreJs" />
        <link href="${coreCss}" rel="stylesheet" />
        <script src="${coreJs}" ></script>
        <title>My Library</title>
    </head>
    <body>
    <c:set var="userName" value="${userName}"/>
    <div class="div-table">
        <c:forEach items="${books}" var="book" varStatus="status">
            <div class="row  ${book.lended ? 'lended' : ''}">
                <div class="col">
                    ${status.count}
                </div>
                <div class="col">
                    ${book.title}
                </div>
                <div class="col">
                    ${book.author}
                </div>
                <c:if test = "${book.lendedTo == userName}">
                    <div class="col">
                        ${book.lendingToDate}
                    </div>
                    <div class="col">
                        <input type="button" value="Extend" onclick="extend(${book.id})" name="extend" />
                    </div>
                </c:if>
            </div>
        </c:forEach>
    </div>
    </body>
</html>
