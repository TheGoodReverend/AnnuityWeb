/**
 *
 * @author KBowen
 */
package Servlets;

import Business.Annuity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AnnuityCalcServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        String msg = "", URL = "/AnnuityResults.jsp";
        double deposit1, deposit2, rate;
        int term;
        
        Annuity a = new Annuity();
        
//        try //OG DEP
//        {
//            deposit1 = Double.parseDouble(request.getParameter("amt1"));
//            if(deposit1 <= 0) 
//            {
//                msg += " Deposit (1) must be positive. <br>";
//            }
//            else
//            {
//                a.setDeposit(deposit1);
//            }
//        }
//        catch(Exception e)
//        {
//            msg += " Error on Deposit (1): " + e.getMessage() + " <br>";
//        } //end deposit1
        

        try //add in ability for one of the deps to be zero
        {
            
                deposit1 = Double.parseDouble(request.getParameter("amt1"));
                deposit2 = Double.parseDouble(request.getParameter("amt2"));
                
            if(deposit1 %1 ==0 && deposit2 %1 ==0)
            {
                if(deposit1 < 0)
                {
                    msg += " You cannot have a negative deposit. <br>";
                }
            
                else if(deposit2 < 0)
                {
                    msg += " You cannot have a negative deposit. <br>";
                }
                else if(deposit1 <= 0 && deposit2 <=0) //Error handling
                {
                    msg += " One of your deposits must be positive. <br>";
                }
                else
                {
                    a.setDeposit1(deposit1);
                    a.setDeposit2(deposit2);
                }
            }
            else
            {
                msg += " Whole numbers only dude, lets just keep the math simple here. Ok?  <br>";
            }
        }
        catch(Exception e)
        {
            msg += " Error on a Deposit: " + e.getMessage() + " <br>";
        } //end deposit1 and 2
        
        
        
        try
        {
            rate = Double.parseDouble(request.getParameter("irt"));
            if(rate <= 0)
            {
                msg += " Rate must be positive. <br>";
            }
            else if(rate >= 5)
            {
                msg += " Rate must be below wac-a-doodle amounts. <br>";
            }
            else
            {
                a.setRate(rate);
            }
        }
        catch(Exception e)
        {
            msg += " Error on Rate: " + e.getMessage() + " <br>";
        } //end rate
        
        try
        {
            term = Integer.parseInt(request.getParameter("term"));
            if(term <= 0)
            {
                msg += " Term must be positive. <br>";
            }
            else if(term >= 100)
            {
                msg += " Term must be below wac-a-doodle amounts. <br>";
            }
            else
            {
                a.setTerm(term);
            }
        }
        catch(Exception e)
        {
            msg += " Error on Term: " + e.getMessage() + " <br>";
        } //end term
        
        
        if(!msg.isEmpty()) //if error message is not empty return to previous page and throw error
        {
            URL = "/AnnuityInput.jsp";
            request.setAttribute("msg" , msg);
        }
        
        //saves session
        HttpSession sess = request.getSession();
        
        sess.setAttribute("annuity", a); //otherwise create annuity
        
        
        //send information through
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);
        
    }
    
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

} //end AnnuityCalcServlet
