<%-- 
    Document   : trainerForm
    Created on : Feb 3, 2021, 8:42:14 PM
    Author     : alkinoos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create Page</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
    </head>
    <body>
        <c:if test="${trainerToEdit==null}">
            <c:url value="/trainer/create" var="link"/>
            <c:set value="Create your trainer" var="UpdateOrCreate"></c:set>   
        </c:if>
        <c:if test="${trainerToEdit!=null}">
            <c:url value="/trainer/update" var="link"/>
            <c:set value="Update your trainer" var="UpdateOrCreate"></c:set>
        </c:if>
        <div class="login-page">

            <h1>${UpdateOrCreate}</h1>
            <div class="form">
                <p id="minimatoui">${message}</p>
                <form class="login-form" action="${link}" method="POST">
                    <input id="tcode" type="number" name="tcode" value="${trainerToEdit.tcode}" hidden/>
                    <input  id="tfirstname" type="text" name="tfirstname" value="${trainerToEdit.tfirstname}" placeholder="Nikos"/>
                    <input  id="tlastname" type="text" name="tlastname" value="${trainerToEdit.tlastname}" placeholder="Matsamplokos"/>
                    <!--<input  id="tsubject" type="text" name="tsubject" value="${trainerToEdit.tsubject}" placeholder="C#"/>-->
                    <select  name="tsubject">
                        <c:forEach items="${listOfSubjects}" var="tsubject">
                            <option  name="tsubject" id="tsubject" value="${tsubject}">${tsubject}</option>
                        </c:forEach>
                    </select>
                    <input  id="tage" type="number" name="tage" value="${trainerToEdit.tage}" placeholder="Age" min="0"/>
                    <input class="button" id="buttonSubmit" type="submit" value="Submit"/>
                </form>
            </div>
        </div>

    </body>
</html>
