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
 * @author H_Browder
 */
public class Stats {
    
    static int i = 0; 
    static int t = 0;
    static ArrayList<String> countryA = new ArrayList<>();
    static ArrayList<String> confirmedA = new ArrayList<>();
    static ArrayList<String> recoveredA = new ArrayList<>();
    static ArrayList<String> deathsA = new ArrayList<>();
    
    static String country;
    static String confirmed;
    static  String recovered;
    static  String death;
    static String allConfirmed;
    static String allRecovered;
    static String allDeaths;
   
           
    
     //Method uses Jsoup to scrape Coronavirus Wiki For all world Stats
    public static void getWorldStats(){
        
        countryA.clear();
        confirmedA.clear();
        recoveredA.clear();
        deathsA.clear();
        i = 0; 
        t = 0;
        
        //Connect To wiki Site and select stats table
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Template:2019%E2%80%9320_coronavirus_pandemic_data#covid19-container").maxBodySize(0).userAgent("morzilla/77.0").get();
            Elements temp = doc.select("tbody tr  ");
            
         
            for(Element name:temp){
              
                //Add Country and Territories Stats to Arraylist
                if(t < 233){   
                    
                    countryA.add(name.select("th:nth-of-type(2)").text());
                    confirmedA.add(name.select("td:nth-of-type(1)").text());
                    recoveredA.add(name.select("td:nth-of-type(2)").text());
                    deathsA.add(name.select("td:nth-of-type(3)").text());

                    t++;



                }
            }
            //Prints Info
            for(String s : countryA){
                
                System.out.print(i + ":");
                System.out.print(s + "  ");
                System.out.print(confirmedA.get(i)+ "  ");
                System.out.print(recoveredA.get(i)+ "  ");
                System.out.println(deathsA.get(i)+ "  ");
                i++;
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(jsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    //Method uses Jsoup to scrape Coronavirus Wiki For selected world Stats
     public static void getWorldStats(String c){
        
        countryA.clear();
        confirmedA.clear();
        recoveredA.clear();
        deathsA.clear();
        i = 0; 
        t = 0;
        boolean isUppercase = Character.isUpperCase(c.charAt(0));
        
        if(isUppercase == false){
        
        c = c.substring(0, 1).toUpperCase() + c.substring(1);
            
        }
        
       boolean found = false;
        //Connect To wiki Site and select stats table
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Template:2019%E2%80%9320_coronavirus_pandemic_data#covid19-container").maxBodySize(0).userAgent("morzilla/77.0").get();
            Elements temp = doc.select("tbody tr  ");
            
         
            for(Element name:temp){
              
                //Add Country and Territories Stats to Arraylist
                if(t < 233){   
                    
                    countryA.add(name.select("th:nth-of-type(2)").text());
                    confirmedA.add(name.select("td:nth-of-type(1)").text());
                    recoveredA.add(name.select("td:nth-of-type(2)").text());
                    deathsA.add(name.select("td:nth-of-type(3)").text());

                    t++;



                }
            }
            //Prints Info
            for(String s : countryA){
                //Checks if country name matches request 
                if(s.contains(c) && found == false ){
                    System.out.println("You Searched For " + c);
                    System.out.println("--------------------------");
                    System.out.print(i + ":");
                    System.out.print(s + "  ");
                    System.out.print(confirmedA.get(i)+ "  ");
                    System.out.print(recoveredA.get(i)+ "  ");
                    System.out.println(deathsA.get(i)+ "  ");




                    confirmed = confirmedA.get(i);
                    recovered = recoveredA.get(i);
                    death = deathsA.get(i);
                    //Checks if wiki contains subsctipt text and removes them
                    if(s.contains("[")){

                        System.out.println(country);
                        country = s.substring((s.lastIndexOf("[")));
                        country = s.replace(country, "");
                    }
                    else{
                    
                     country = s;
                        
                    }

                    found = true;
                }
                i++;
            }
            
        } 
        catch (IOException ex) {
            Logger.getLogger(jsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
 public static void getAllStats(){
        
        countryA.clear();
        confirmedA.clear();
        recoveredA.clear();
        deathsA.clear();
        i = 0; 
        t = 0;
        
        //Connect To wiki Site and select stats table
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Template:2019%E2%80%9320_coronavirus_pandemic_data#covid19-container").maxBodySize(0).userAgent("morzilla/77.0").get();
            Elements temp = doc.select("tbody tr  ");
            
         
            for(Element name:temp){
              
                //Add Country and Territories Stats to Arraylist
                if(t < 4){   
                    
                    confirmedA.add(name.select("th:nth-of-type(2)").text());
                    recoveredA.add(name.select("th:nth-of-type(3)").text());
                    deathsA.add(name.select("th:nth-of-type(4)").text());
                    

                    t++;



                }
            }
            //Prints Info
            
                
            
                allConfirmed = confirmedA.get(1);
                allRecovered = recoveredA.get(1);
                allDeaths = deathsA.get(1);
                
                System.out.print(allConfirmed + "  " + allRecovered + "  " + allDeaths);
            
            
        } 
        catch (IOException ex) {
            Logger.getLogger(jsoup.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
        
        
    
    
    public static void main(String[] args){
    
        
        getAllStats();
    
    }
    
}

    
    

