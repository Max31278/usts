/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ustslab;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author MaxK
 */
public class Main {
    public void Graph(List<Double> xn, List<Double> yn) {
        double[] x = new double[xn.size()];
        double[] y = new double[yn.size()];
        for (int i = 0; i < x.length; i++) {
            x[i] = xn.get(i);
            y[i] = yn.get(i);
            System.out.print("x = " + x[i]);
            System.out.printf("%s %.3f %s"," y = ",+y[i],"\n");
        }
        System.out.println(Arrays.toString(y));
        new Draw(x,y);
    }
}
 

class Draw extends javax.swing.JFrame {
 
    private double[] x;
    private double[] y;
    private int[] yTrue; 
    private int[] xTrue;
    private Dimension size = new Dimension(500,300); //рабочая область
    private Dimension startPointXoY = new Dimension(40,250); //начало координат
    private int scale = 30; //масштаб
 
    public Draw(double[] x,double[] y) {
        this.x = x;
        this.y = y;
        yTrue = new int[x.length];
        xTrue = new int[y.length];
        reBuildArreys();
        initInterface();
    }
 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,size.width,size.height);
 
        g.setColor(Color.WHITE);
 
        for (int i = 1; i <= x.length; i++) {
            g.drawString(String.valueOf(i),startPointXoY.width + (startPointXoY.width - 10) * i,startPointXoY.height + (startPointXoY.width - 25));
            g.drawString(String.valueOf(i),25,startPointXoY.height - (startPointXoY.width - 10) * i);
        }
 
        g.drawLine(startPointXoY.width,startPointXoY.width,startPointXoY.width,startPointXoY.height);
        g.drawLine(startPointXoY.width,startPointXoY.height,400,startPointXoY.height);
        
        g.drawPolyline(xTrue,yTrue,x.length);
        
    }
 
    private void initInterface() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(size);
        setResizable(false);
        setTitle("График функции");
        setVisible(true);
    }
 
    private void reBuildArreys() {
        for (int i = 0; i < x.length; i++) {
            x[i] *= scale;
            x[i] += startPointXoY.width;
            y[i] *= scale;
            yTrue[i] = startPointXoY.height - ((int) y[i]);
            xTrue[i] = (int) x[i];
        }
    }
}
