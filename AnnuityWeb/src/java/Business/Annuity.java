/**
 *
 * @author PDaniel
 * @Edit by KBowen
 */

package Business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Annuity 
{
   //takes
   private double deposit1, deposit2, rate;
   private int term;
   
   //gives
   private double[] bbal, iearn, ebal;
   private boolean built;
   
   NumberFormat curr = NumberFormat.getCurrencyInstance();
   NumberFormat pct = NumberFormat.getPercentInstance();
   
   
   public Annuity() //empty const
   {
       this.deposit1 = 0;
       this.deposit2 = 0;
       this.rate = 0;
       this.term = 0;
       this.built = false;
   }
   
   public Annuity(double deposit1, double deposit2, double rate, int term) 
   {
       this.deposit1 = deposit1;
       this.deposit2 = deposit2;
       this.rate = rate;
       this.term = term;
       buildAnnuity();
   }

   public double getDeposit1() 
   {
       return this.deposit1;
   }
   
   public void setDeposit1(double deposit1)
   {
       this.deposit1 = deposit1;
   }
   
   public double getDeposit2() 
   {
       return this.deposit2;
   }
   
   public void setDeposit2(double deposit2)
   {
       this.deposit2 = deposit2;
   }

   public double getRate() 
   {
       return this.rate;
   }
   
   public void setRate(double rate)
   {
       this.rate = rate;
   }

   public int getTerm() 
   {
       return this.term;
   }
   
   public void setTerm(int term)
   {
       this.term = term;
   }
   
   public double getFinalValue() 
   {
       if (!built) {
           buildAnnuity();
       }
       return ebal[term-1];
   }
   
   public String getFinalValueF()
   {
       return curr.format(getFinalValue());
   }
   
   public String getDeposit1F()
   {
       return curr.format(getDeposit1());
   }
   
   public String getDeposit2F()
   {
       return curr.format(getDeposit2());
   }
   
   public double getRateF()
   {
       return rate *100;
   }
   
   
   //add lowecase gets
   
   public double BegBal(int m) 
   {
       if (!built) {
           buildAnnuity();
       }
       return this.bbal[m-1];
   }
   
   public double IntEarn(int m) 
   {
       if (!built) 
       {
           buildAnnuity();
       }
       return this.iearn[m-1];
   }
   
   public double EndBal(int m) 
   {
       if (!built) 
       {
           buildAnnuity();
       }
       return this.ebal[m-1];
   }
   
    private void buildAnnuity() //no idea if this works
    {
        bbal = new double[term];
        iearn = new double[term];
        ebal = new double[term];

        bbal[0] = 0;
        for (int i=0; i < this.term; i++) 
        {
            if (i > 0) 
            {
                bbal[i] = ebal[i-1];
            }
            if(i<1)
            {
                iearn[i] = (bbal[i] + this.deposit1) * (this.rate / 12.0);
                ebal[i] = (bbal[i] + this.deposit1 + this.deposit2 + iearn[i]);
            }
            if(i>=1)
            {
                iearn[i] = (bbal[i] + this.deposit1 + this.deposit2) * (this.rate / 12.0);
                ebal[i] = (bbal[i] + this.deposit1 + this.deposit2 + iearn[i]);
            }
        }
        built = true;
        return ;
   }//end new buildAnnuity
    
    
    
    
    
    
    
   
   public ArrayList <AnnuityMonth> getMonths() //probably good as is
   {
       ArrayList<AnnuityMonth> mos = new ArrayList<>();
       if(!this.built)
       {
           buildAnnuity();
       }//end failsafe
       
       try
       {
           for(int i = 0; i < this.term; i++)
           {
               AnnuityMonth am = new AnnuityMonth( (i+1), 
                                                this.bbal[i], 
                                                this.deposit1,
                                                this.deposit2,
                                                this.iearn[i], 
                                                this.ebal[i]);
               mos.add(am);
           }
       }
       catch (Exception e)
       {
           mos = null;
       }
       return mos;
   }
   
   
} //end annuity class
