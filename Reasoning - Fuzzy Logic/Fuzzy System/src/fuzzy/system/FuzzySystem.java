/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzy.system;

/**
 *
 * @author hanun_000
 */
public class FuzzySystem {

    /**
     * @param args the command line arguments
     */
    private static int ems;
    private static int prv;
    
    private static double result;
    private static double result2;
    private static double result3;
    private static double result4;
    private static String par;
    private static String par2;
    private static String par3;
    private static String par4;    
    
    private static double[] ne = new double[10];
    private static double[] r =  new double[10];
    private static double[] h =  new double[10];
    private static double[] t =  new double[10];
    private static String[] s =  new String[10];    
    private static double maxA, maxB;
    
    private static double yS,hoaxParameter, noParameter;
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        ems = 97;
        prv = 74;
        berita(97,74);
        berita(50,95);
        berita(36,85);
        berita(80,68);
        berita(77,70);
        berita(68,75);
        berita(82,90);
        berita(80,68);
        berita(60,95);
        berita(11,99);
        
        System.out.println("----------BERITA GA HOAX------------");
        
        berita(63,43);
        berita(71,25);
        berita(55,62);
        berita(57,45);
        berita(40,65);
        berita(60,70);
        //berita(40,85);
        berita(40,85);
        berita(60,72);
        berita(27,79);
        
        System.out.println("---------21 - 30 ------------");
        berita(68,63);
        berita(68,70);
        berita(64,66);
        berita(57,77);
        berita(77,55);
        berita(98,64);
        berita(91,59);
        berita(50,95);
        berita(95,55);
        berita(27,79);
    }
    
    public static void fuzzyEmo(double ems){
        double bLow = 0;
        double cLow = 35;
        double dLow = 40;
        double aMed = cLow;
        double bMed = dLow;
        double cMed = 50;
        double dMed = 70;
        double aHigh = cMed;
        double bHigh = dMed;
        double cHigh = 75;
        double dHigh = 90;
        double aVHigh = cHigh;
        double bVHigh = dHigh;
        double cVHigh = 100;
        
        
        if(ems < 0 && ems >100){            
            System.out.println("0");
        }else if(ems >= bLow && ems <= cLow){
            par = "Low";
            result = 1;
        }else if(ems >=bMed && ems <= cMed){
            par = "Medium";
            result = 1;
        }else if(ems >=bHigh && ems <=cHigh){
            par = "High";
            result= 1;
        }else if(ems >=bVHigh && ems <=cVHigh){
            par = "Very High";
            result = 1;
        }
        
        else if(ems > cLow && ems <dLow){
            par = "Low";
            result = (dLow-ems)/(dLow-cLow);
            par2 = "Medium";
            result2 = (ems-aMed)/(bMed-aMed);
        }else if(ems > cMed && ems <dMed){
            par = "Medium";
            result = (dMed-ems)/(dMed-cMed);
            par2 = "High";
            result2 = (ems-aHigh)/(bHigh-aHigh);
        }else if(ems >cHigh && ems <dHigh){
            par = "High";
            result = (dHigh - ems)/(dHigh-cHigh);
            par2 = "Very High";
            result2 = (ems-aVHigh)/(bVHigh-aVHigh);
        }
    }
    
    public static void fuzzyPro(double prv){
        double bMin = 0;
        double cMin = 35;
        double dMin = 40;
        double aNor = cMin;
        double bNor = dMin;
        double cNor = 70;
        double dNor = 75;
        double aMax = cNor;
        double bMax = dNor;
        double cMax = 85;
        double dMax = 90;
        double aAdv = cMax;
        double bAdv = dMax;
        
        
        if(prv<0 && prv>100){
            System.out.println("0");
        }else if(prv>=bMin && prv<=cMin){
            par3 = "Minimum";
            result3 = 1;
        }else if(prv>=bNor && prv<=cNor){
            par3 = "Normal";
            result3 = 1;
        }else if(prv>=bMax && prv<=cMax){
            par3 = "Maximum";
            result3 = 1;
        }else if(prv>=bAdv && prv<=100){
            par3 = "Advance";
            result3 = 1;
        }
        
        else if(prv>cMin && prv <dMin){
            par3 = "Minimum";
            result3 = decrease(prv,cMin,dMin);
            par4 = "Normal";
            result4= increase(prv, aNor, bNor);
        }else if(prv>cNor && prv<dNor){
            par3 = "Normal";
            result3 = decrease(prv, cNor, dNor);
            par4 = "Maximum";
            result4 = increase(prv,aMax, bMax);
        }else if(prv>cMax && prv<dMax){
            par3 = "Maximum";
            result3 = decrease(prv,cMax,dMax);
            par4 = "Advance";
            result4 = increase(prv,aAdv,bAdv);
            
        }
    }
    
    public static double increase(double x, double a, double b){
        return (x-a)/(b-a);
    }
    
    public static double decrease(double x, double b, double c){
        return (c-x)/(c-b);
    }
    
    public static void inference(){        
        if (par == "Low"){
            if(par2 == null){
                if (par3 == "Minimum" & par4 == null){
                    ne[1] = Math.min(result, result3);   
                    s[1] = "No";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                  
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";   
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                    
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                 
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";               
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }    
            }   
            else if(par2 == "Medium"){                
                if (par3 == "Minimum" & par4 == null){
                    ne[1] = Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";                  
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }      
            }     
             
        }else if(par == "Medium"){
            if(par2==null){
                if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                   
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";    
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                  
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";             
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";               
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }    
            }else if(par2 == "High"){         
                if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";                   
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Maximum" && par4 == "Advance"){                    
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }      
            }
            
        }else if(par == "High"){
            if(par2 == null){
                if (par3 == "Minimum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                    
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                    
                }else if (par3 == "Normal" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";     
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                    
                }else if (par3 == "Maximum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                    
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                 
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";     
                }    
            }else if(par2 == "Very High"){
                if (par3 == "Minimum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Normal" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";                   
                }else if (par3 == "Maximum" ){                  
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }
            }    
        }else if(par == "Very High"){
            if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                   
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                    
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                    
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                 
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }
            }
    }   
       
    
    public static void inference2(){        
        if (par == "Low"){
            if(par2 == null){
                if (par3 == "Minimum" & par4 == null){
                    ne[1] = Math.min(result, result3);   
                    s[1] = "Yes";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                  
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                   
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                   
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                 
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";    
                }    
            }   
            else if(par2 == "Medium"){                
                if (par3 == "Minimum" & par4 == null){
                    ne[1] = Math.min(result, result3);   
                    s[1] = "Yes"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";                   
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }      
            }     
             
        }else if(par == "Medium"){
            if(par2==null){
                if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                    
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                   
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";    
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                   
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                  
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";               
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";    
                }    
            }else if(par2 == "High"){         
                if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "Yes";
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";                   
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No";
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }      
            }
            
        }else if(par == "High"){
            if(par2 == null){
                if (par3 == "Minimum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";                  
                }else if (par3 == "Normal" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                
                }else if (par3 == "Maximum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                 
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";               
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";  
                }    
            }else if(par2 == "Very High"){
                if (par3 == "Minimum" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "Yes";
                    System.out.println(s[2] +" " + ne[2]);
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "Yes"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "Yes";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";
                }else if (par3 == "Normal" ){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No";  
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";                  
                }else if (par3 == "Maximum" ){                  
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No"; 
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[3] = Math.min(result, result4);
                    s[3] = "No"; 
                    ne[2] = Math.min(result2, result3);
                    s[2] = "No";
                    ne[4] = Math.min(result2, result4);
                    s[4] = "No";
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result2, result3);   
                    s[2] = "No";
                }
            }    
        }else if(par == "Very High"){
            if (par3 == "Minimum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";                   
                }else if (par3 == "Minimum" && par4 == "Normal"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "Yes";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                  
                }else if (par3 == "Normal" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";    
                }else if (par3 == "Normal" && par4 == "Maximum"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "No";                  
                }else if (par3 == "Maximum" & par4 == null){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";                    
                }else if (par3 == "Maximum" && par4 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";
                    ne[2] = Math.min(result, result4);
                    s[2] = "Yes";               
                }else if (par3 == "Advance"){
                    ne[1]= Math.min(result, result3);   
                    s[1] = "No";   
                }
            }
    }
        
        
    public static void cariT(){
        int a = 1;
        int x = 1;
        int n = 0;
        int m = 0;
        
        for(int i = 1; i<5; i++){
            r[i] = 0;
            t[i] = 0;
            h[i] = 0;
        }
        
        
        
        while(a!=5){
            if (s[a]== "No"){                
                n++;
                r[n] = ne[a];               
                x=n;                
            }
            a++;
        }
        maxA = 0;
        if(x>2){
            double max1 = Math.max(r[1], r[2]);
            maxA = Math.max(max1, r[3]);
            if(r[4]>0){
                maxA = Math.max(maxA, r[4]);                
            }
        }else if (x ==2){
            maxA = Math.max(r[1], r[2]);
        }else{
            maxA = r[1];
        }
        //System.out.println("No " + maxA );   
        
        //TINGGI
        a = 1;
        x = 1;
        m = 0;
        for(int i = 1; i<5; i++){
            t[i] = 0;
        }
        while(a!=5){
            
            if (s[a]== "Yes"){               
                m++;                
                t[m] = ne[a];           
                x=m;
            }
            a++;
        }
        maxB = 0;
        if(x>2){            
            double max1 = Math.max(t[1], t[2]);
            maxB = Math.max(max1, t[3]);
            if(t[4]>0){
                maxB = Math.max(maxB, t[4]);                
            }
        }else if (x ==2){
            maxB = Math.max(t[1], t[2]);
        }else{
            maxB = t[1];
        }
        //System.out.println("Yes " + maxB);   
    }
    public static void deFuzzy(){        
        
        yS =(((10+20+30+40+45+48+50)*maxA) + ((75+78+80+90+100)*maxB))/((maxB*5)+(maxA*7));     
        //System.out.println("The Result is "+yS);
        
    }
    
    public static void deFuzzy2(){        
            yS =(((10+20+30+31+32+33+34+35)*maxA) + ((60+61+62+63+64+65+70+80+90+100)*maxB))/((maxB*8)+(maxA*10)); 
            //System.out.println("The Result is "+yS);
    }
    
    public static void reset(){
        for(int i =1; i<5; i++){
            s[i] = "";
        }
        par = null;
        par2 = null;
        par3 = null;
        par4 = null;
        
    }
    public static void berita(int ems, int prv){
        System.out.println("BERITA ("+ems+", "+prv+") =");
        fuzzyEmo(ems);
        fuzzyPro(prv);
        inference();
        cariT();
        deFuzzy();
        hoaxParameter = yS;
        for(int i =1; i<5; i++){
            s[i] = "";
        }
        inference2();
        cariT();
        deFuzzy2();
        noParameter = yS;
        if(hoaxParameter>noParameter){
            System.out.println("BERITA HOAX\n");
        }else{
            System.out.println("BERITA TIDAK HOAX\n");
        }
        reset();   
        
    } 
        
}
