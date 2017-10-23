<%--
  Created by IntelliJ IDEA.
  User: Farkas
  Date: 2017.10.22.
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
  <spring:url value="/resources/core/css/hello.css" var="coreCss" />
  <spring:url value="/resources/core/js/library.js" var="coreJs" />
  <link href="${coreCss}" rel="stylesheet" />
  <script src="${coreJs}" ></script>
    <title></title>
</head>
<body>
<form:form name="change" method="post" action="" modelAttribute="changeForm" >
    <form:errors path="" cssClass="formError" id="generalError" />
    <div class="row">
        <div class="col">
            <form:input class="text-input" type="text" placeholder="ISBN" value="${book.isbn}" path="isbn" />
        </div>
        <div class="col">
            <form:input class="text-input" type="text" placeholder="Title" value="${book.title}" path="title" />
        </div>
        <div class="col">
            <form:input class="text-input" type="text" placeholder="Author" value="${book.author}" path="author" />
        </div>
        <div class="col">
            <form:input class="text-input" type="text" placeholder="Deleted" value="${book.deleted}" path="deleted" />
        </div>

        <div class="col">
            <input type="submit" value="Change" name="change" />
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:errors path="isbn" cssClass="formError" />
            <form:errors path="title" cssClass="formError" />
            <form:errors path="author" cssClass="formError" />
            <form:errors path="deleted" cssClass="formError" />
        </div>
    </div>
</form:form>

</body>
</html>
