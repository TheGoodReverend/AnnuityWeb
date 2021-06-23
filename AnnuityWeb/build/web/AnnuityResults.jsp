<%-- 
    Document   : AnnuityResults
    Created on : Feb 25, 2021, 3:03:07 PM
    Author     : KBowe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="annuity" scope="session" class="Business.Annuity" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Annuity Results</title>
    </head>
    <body>
        <h1>Annuity Results</h1>
        
        <p> An Annuity a B.o.t.M. deposit of: <jsp:getProperty name="annuity" property="deposit1F" /> 
        <br> 
            and E.o.t.M deposit of: <jsp:getProperty name="annuity" property="deposit2F" />  
        <br>    
            Earning <jsp:getProperty name="annuity" property="rateF"/> % year
        <br>    
            will have a value of <jsp:getProperty name="annuity" property="finalValueF" />
        <br>
        at the end of: <jsp:getProperty name="annuity" property="term" /> Months.
        <br>
        </p>
        
        <form action="AnnuitySchedule.jsp" method="post">
            <input type ="submit" value= "Full Schedule" />
        </form>
        
        <form action ="NewAnnuity" method ="post"> 
              <input type="submit" value ="New Annuity" />
        </form>
        
    </body>
</html>
