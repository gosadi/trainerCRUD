<%-- 
    Document   : trainerList
    Created on : Feb 3, 2021, 8:04:36 PM
    Author     : alkinoos
--%>


<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/main.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trainer</title>
    </head>
    <body>
        <div>
            <div class="tableDiv">
                <h3>Trainers</h3>
                <p id="minimatoui">${message}</p>
                <table class="styled-table">
                    <thead>
                        <tr>
                            <th>Code</th>
                            <th>First name</th>
                            <th>Last name</th>
                            <th>Subject</th>
                            <th>Age</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <c:forEach items="${listOfTrainers}" var = "trainer">
                        <tr>
                            <td>${trainer.tcode}</td>
                            <td>${trainer.tfirstname}</td>
                            <td>${trainer.tlastname}</td>
                            <td>${trainer.tsubject}</td>
                            <td>${trainer.tage}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/trainer/update/${trainer.tcode}" id="updateKoumpi" ><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-fill" viewBox="0 0 16 16">
  <path d="M12.854.146a.5.5 0 0 0-.707 0L10.5 1.793 14.207 5.5l1.647-1.646a.5.5 0 0 0 0-.708l-3-3zm.646 6.061L9.793 2.5 3.293 9H3.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.207l6.5-6.5zm-7.468 7.468A.5.5 0 0 1 6 13.5V13h-.5a.5.5 0 0 1-.5-.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.5-.5V10h-.5a.499.499 0 0 1-.175-.032l-.179.178a.5.5 0 0 0-.11.168l-2 5a.5.5 0 0 0 .65.65l5-2a.5.5 0 0 0 .168-.11l.178-.178z"/>
</svg></a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/trainer/delete?id=${trainer.tcode}" id="deleteKoumpi"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
  <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
</svg></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                
            </div>
            <a class="button1" href="${pageContext.request.contextPath}/trainer/create">Add trainer</a>
        </div>
    </body>
</html>
