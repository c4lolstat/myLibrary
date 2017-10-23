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
    <div class="div-table">
        <c:forEach items="${books}" var="book" varStatus="status">
            <div class="row ${book.deleted ? 'deleted' : ''} ${book.lended ? 'lended' : ''}">
                <div class="col">
                    <input type="button"
                           name="delete"
                           value="X"
                           ${book.lended || book.deleted ? 'disabled' : ''}
                           onclick="sendDelete(${book.id})"
                    />
                </div>
                <div class="col">
                    <a href="/librarian/modify?id=${book.id}">Modify</a>
                </div>
                <div class="col">
                    ${book.isbn}
                </div>
                <div class="col">
                    ${book.title}
                </div>
                <div class="col">
                    ${book.author}
                </div>
                <c:if test = "${book.lended}">
                    <div class="col">
                        ${book.lendedTo}
                    </div>
                    <div class="col">
                            ${book.lendingFromDate}
                    </div>
                    <div class="col">
                        ${book.lendingToDate}
                    </div>
                    <div class="col">
                        <input type="button" name="back" value="Took Back" onclick="bringBack(${book.id})" />
                    </div>
                </c:if>
                <c:if test = "${!book.deleted && !book.lended}">
                    <div class="col">
                        <input class="text-input" type="text" placeholder="User" id="lendedTo${status.count}" />
                    </div>
                    <div class="col">
                        <input type="button" onclick="lending(${book.id},${status.count})" value="Lending" />
                    </div>
                </c:if>
            </div>
        </c:forEach>
        <form:form name="add" method="post" action="librarian" modelAttribute="addForm" >
            <div class="row">
                <div class="col">
                    <form:input class="text-input" type="text" placeholder="ISBN" path="isbn" />
                </div>
                <div class="col">
                    <form:input class="text-input" type="text" placeholder="Title" path="title" />
                </div>
                <div class="col">
                    <form:input class="text-input" type="text" placeholder="Author" path="author" />
                </div>
                <div class="col">
                    <input type="submit" value="Add New" name="add" />
                </div>
            </div>
        </form:form>

    </div>
    </body>
</html>
