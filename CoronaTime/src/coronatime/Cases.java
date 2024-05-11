/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronatime;


       
/**
 *
 * @author H_Browder
 */
public class Cases {
    
    
     public String country;

     public String confirmed;
     public String recovered;
     public String death;

     
     public Cases() {

         country = "";
         confirmed = "";
         recovered = "";
         death = "";


    }
     
     
     public Cases(String coun, String c, String r, String d){
     
         country = coun;
         confirmed = c;
         recovered = r;
         death = d;
     
     }
     
     
    public void setCountry() {
        this.country = country;
    }

    public void setConfirmed() {
        this.confirmed = confirmed;
    }

    public void setRecovered() {
        this.recovered = recovered;
    }

    public void setDeath() {
        this.death = death;
    }
    public String getCountry() {
        return country;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public String getRecovered() {
        return recovered;
    }

    public String getDeath() {
        return death;
    }
    
}

