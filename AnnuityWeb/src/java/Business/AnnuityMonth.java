/**
 *  
 * @author KBowen
 */
package Business;

public class AnnuityMonth //SHOULD BE FINE AS IS
{
    private int month;
    private double begbal, deposit1, deposit2, intearn, endbal;
    
    public AnnuityMonth()
    {
        this.month = 0;
        this.begbal = 0;
        this.deposit1 = 0;
        this.deposit2 = 0;
        this.intearn = 0;
        this.endbal = 0;
    }
    
    public AnnuityMonth(int m, double bb, double dep1, double dep2, double ie, double eb)
    {
        this.month = m;
        this.begbal = bb;
        this.deposit1 = dep1;
        this.deposit2 = dep2;
        this.intearn = ie;
        this.endbal = eb;
    }

    public int getMonth() 
    {
        return month;
    }

    public void setMonth(int month) 
    {
        this.month = month;
    }

    public double getBegbal() 
    {
        return begbal;
    }

    public void setBegbal(double begbal) 
    {
        this.begbal = begbal;
    }

    public double getDeposit1() 
    {
        return deposit1;
    }

    public void setDeposit1(double deposit1) 
    {
        this.deposit1 = deposit1;
    }
    
     public double getDeposit2() 
    {
        return deposit2;
    }

    public void setDeposit2(double deposit2) 
    {
        this.deposit2 = deposit2;
    }

    public double getIntearn() 
    {
        return intearn;
    }

    public void setIntearn(double intearn) 
    {
        this.intearn = intearn;
    }

    public double getEndbal() 
    {
        return endbal;
    }

    public void setEndbal(double endbal) 
    {
        this.endbal = endbal;
    }
    
}//end AnnuityMonth class
