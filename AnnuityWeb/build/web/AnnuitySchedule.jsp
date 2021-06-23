<%-- 
    Document   : AnnuitySchedule
    Created on : Feb 25, 2021, 3:11:20 PM
    Author     : KBowe
--%>

<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Schedule</title>
    </head>
    <body>
        <h1>Annuity Schedule</h1>
        A B.o.t.M deposit of <fmt:formatNumber value="${annuity.deposit1}" type ="currency"/> 
        w/ a E.o.t.M deposit of <fmt:formatNumber value="${annuity.deposit2}" type ="currency"/> 
        @ <fmt:formatNumber type="percent" minFractionDigits="3" value ="${annuity.rate}" /> for ${annuity.term} months = <fmt:formatNumber value="${annuity.finalValue}" type ="currency" />
        
        <br>
        <table border ="1">
            <tr>
                <th>Month </th>
                <th>Beginning <br> Balance </th>
                <th>B.o.t.M <br> Deposit </th>
                <th>Interest <br> Earned </th>
                <th>E.o.t.M <br> Deposit </th>
                <th>Ending <br> Balance </th>
            </tr>
        
            <c:forEach var="am" items="${annuity.months}">
            <tr>
                <td align="center">${am.month} </td>
                <td align="center"> <fmt:formatNumber value="${am.begbal}" type ="currency"/> </td>
                <td align="center"> <fmt:formatNumber value="${am.deposit1}" type ="currency"/> </td>
                <td align="center"> <fmt:formatNumber value="${am.intearn}" type ="currency"/> </td>
                <td align="center"> <fmt:formatNumber value="${am.deposit2}" type ="currency"/> </td>
                <td align="center"> <fmt:formatNumber value="${am.endbal}" type ="currency"/> </td>   
            </tr>
            </c:forEach>
            
        <br>
        
        <form action ="NewAnnuity" method ="post"> 
              <input type="submit" value ="New Annuity" />
        </form>
        
        <%
            request.getSession().removeAttribute("annuity");
        %>
    </body>
</html>
