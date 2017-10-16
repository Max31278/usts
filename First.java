/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ustslab;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MaxK
 */
public class First {
    private int m,t;
    private List<Double> y = new ArrayList<Double>(); 
    private List<Double> x = new ArrayList<Double>();
    private double h = 0.005;
    private double n;
    private double f=0;
    public First(int m, int t){
        this.m = m;
        this.t = t;
        raschet();
    }
    
    private void raschet(){
        n=10/h;
        
        int i=0;
        y.add(0.0);
        x.add(0.0);
        double ti=0;
        int a = y.size();
        while(y.get(y.size()-1)<=(m*0.95)){
            i++;
            f= (m/t)-(y.get(y.size()-1)/t);
            y.add(y.get(y.size()-1)+h*f);
            x.add(i*h);
            ti = i*10/n;
        }
        System.out.println(ti);
        Main gr = new Main();
        gr.Graph(x, y);
        
    }
    
    
   
    
}
