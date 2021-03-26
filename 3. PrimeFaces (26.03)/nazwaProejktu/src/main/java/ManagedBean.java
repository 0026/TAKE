/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Tomasz
 */
@Named(value = "managedBean")
@RequestScoped
public class ManagedBean {
    
    private Integer a;
    private Integer b;
    private Integer c;
    private ArrayList<Student> list = new ArrayList<>();
    private LineChartModel lineModel;
    /**
     * Creates a new instance of ManagedBean
     */
    public ManagedBean() {
        for(int i =0;i<10;i++){
            list.add(new Student( "Jan", "Kowalski",i+0.5));
            list.add(new Student( "Adam", "Nowacki",i*0.5));
        }
        ////
        lineModel = new LineChartModel();
        LineChartSeries s = new LineChartSeries();
        LineChartSeries c = new LineChartSeries();
        s.setLabel("sin");
        c.setLabel("cos");
        for(int i =0; i<=360;i=i+10){
            s.set(i,Math.sin(Math.toRadians(i)));
            c.set(i,Math.cos(Math.toRadians(i)));
        }
        lineModel.addSeries(s);
        lineModel.addSeries(c);
        lineModel.setLegendPosition("e");
        lineModel.setZoom(true);
        
    }

        public LineChartModel getLineModel() {
        return lineModel;
    }
    
    public void calculate(){
        if(a!=null && b!=null) {
            c=a+b;
            
            String msg = a.toString()+"+"+b.toString()+"="+c.toString();
            FacesContext.getCurrentInstance().
            addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", msg));
        }
    }
    
    public Date getCurrentDate(){
        return new Date();
    }
    
    /**
     * @return the a
     */
    public Integer getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Integer a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Integer getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Integer b) {
        this.b = b;
    }

    /**
     * @return the c
     */
    public Integer getC() {
        return c;
    }

    /**
     * @param c the c to set
     */
    public void setC(Integer c) {
        this.c = c;
    }

    /**
     * @return the list
     */
    public ArrayList<Student> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<Student> list) {
        this.list = list;
    }
    
}
