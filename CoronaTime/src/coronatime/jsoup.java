/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coronatime;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author C_Garcia
 */
public class jsoup {
    
    //Method uses Jsoup to scrape Coronavirus Wiki For all world Stats
    public static void getWorldStats(){
        
        int i = 0; 
        int t = 0;
        ArrayList<String> countryA = new ArrayList<>();
        ArrayList<String> confirmedA = new ArrayList<>();
        ArrayList<String> recoverdA = new ArrayList<>();
        ArrayList<String> deathsA = new ArrayList<>();
        
        //Connect To wiki Site and select stats table
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Template:2019%E2%80%9320_coronavirus_pandemic_data#covid19-container").maxBodySize(0).userAgent("morzilla/77.0").get();
            Elements temp = doc.select("tbody tr  ");
            
         
            for(Element name:temp){
              
                //Add Country and Territories Stats to Arraylist
                if(t < 233){   
                    
                    countryA.add(name.select("th:nth-of-type(2)").text());
                    confirmedA.add(name.select("td:nth-of-type(1)").text());
                    recoverdA.add(name.select("td:nth-of-type(2)").text());
                    deathsA.add(name.select("td:nth-of-type(3)").text());

                    t++;



                }
            }
            //Prints Info
            for(String s : countryA){
                
                System.out.print(i + ":");
                System.out.print(s + "  ");
                System.out.print(confirmedA.get(i)+ "  ");
                System.out.print(recoverdA.get(i)+ "  ");
                System.out.println(deathsA.get(i)+ "  ");
                i++;
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(jsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
     public static void getWorldStats(String c){
        
        int i = 0; 
        int t = 0;
        ArrayList<String> countryA = new ArrayList<>();
        ArrayList<String> confirmedA = new ArrayList<>();
        ArrayList<String> recoverdA = new ArrayList<>();
        ArrayList<String> deathsA = new ArrayList<>();
        
        //Connect To wiki Site and select stats table
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Template:2019%E2%80%9320_coronavirus_pandemic_data#covid19-container").maxBodySize(0).userAgent("morzilla/77.0").get();
            Elements temp = doc.select("tbody tr  ");
            
         
            for(Element name:temp){
              
                //Add Country and Territories Stats to Arraylist
                if(t < 233){   
                    
                    countryA.add(name.select("th:nth-of-type(2)").text());
                    confirmedA.add(name.select("td:nth-of-type(1)").text());
                    recoverdA.add(name.select("td:nth-of-type(2)").text());
                    deathsA.add(name.select("td:nth-of-type(3)").text());

                    t++;



                }
            }
            //Prints Info
            for(String s : countryA){
                
                System.out.print(i + ":");
                System.out.print(s + "  ");
                System.out.print(confirmedA.get(i)+ "  ");
                System.out.print(recoverdA.get(i)+ "  ");
                System.out.println(deathsA.get(i)+ "  ");
                i++;
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(jsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
        
    
    
    public static void main(String[] args){
    
        
     getWorldStats();
    
    }
    
}
