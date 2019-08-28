/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulated.annealing;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author hanun_000
 */
public class SimulatedAnnealing {


    /**
     * @param args the command line arguments
     */
    static double cs = 100000;
    static double ns;
    static double temp;
    static double bestSF;
    static double deltE;
    static double T;
    
    
    public static void main(String[] args) {       
        //System.out.println(randomNumber());
        bestSF = cs;
        for(int i = 0; i<1000; i++){
            double x1 = randomNumber();
            System.out.println("x1 value = "+ x1);
            double x2 = randomNumber();
            System.out.println("x2 value = "+x2);        
            System.out.println("result is "+codeA(x1, x2));
            ns = codeA(x1, x2);
            System.out.println("current state is " + cs);
            System.out.println("new state is " + ns);
            
            deltE = ns - cs;
            System.out.printf("delta E is %.3f", deltE);
            System.out.println("");
            System.out.println("current best so far is " +bestSF);
            
            if(deltE<0){
                //System.out.println("\n current best so far is " +bestSF);
                bestSF = ns;
                cs = ns;
                System.out.println("After--current best so far is " +bestSF +"\n");
            }else{
                if(deltE<-60000){
                    T=10;
                }else if (deltE>= 25 && deltE<50){
                    T=0.1;
                }else if(deltE >=50 && deltE<100){
                    T=5;
                }else if(deltE >= 100 && deltE<500){
                    T=10;
                }else if(deltE>=500 && deltE<1000){
                    T=20;
                }else if(deltE>=1000 && deltE<5000){
                    T=50;
                }else if(deltE >=5000 && deltE<10000){
                    T = 100;
                }else if(deltE>=10000 && deltE<20000){
                    T=200;
                }else if(deltE >=20000 && deltE<40000){
                    T = 250;
                }else if(deltE>=40000 && deltE<600000){
                    T = 300;
                }else if(deltE>=60000){
                    T= 400;
                }else{
                    T = 0.1;
                }
                
                double p = Math.exp(-deltE/T);
                p = Math.round(p*1000.0)/1000.0;                
                double s = randomProbability();
                if(s<=p){
                    cs = ns;
                }else{
                    System.out.println("\n");
                }
            }
        }
        bestSF = Math.round(bestSF*1000.0)/1000.0;
        System.out.println("Best So Far Is...");
        System.out.println(bestSF);
                
    }

public static double codeA(double x, double y){
    double b = x*x; //x^2
    double k = y*y; //y^2
    double c = x*y; //x1x2
    double n = x*x*x*x; //x^4
    double d = 4-2.1*b+ n/3;  
    double e = -4+(4*k); //-4+4x2^2
    return d*b +c + (e*k);
    
}

public static double randomNumber(){
    double start = -10;
    double end = 10;
    double random = new Random().nextDouble();
    temp = start + (random *(end - start));
    temp = Math.round(temp*1000.0)/1000.0;
    //System.out.println(bs);
    return temp;
}

public static double randomProbability(){
    double z = 0;
    double o = 1;
    double random = new Random(). nextDouble();
    temp = z + (random *(o-z));
    temp = Math.round(temp*1000.0)/1000.0;
    return temp;
}
}
