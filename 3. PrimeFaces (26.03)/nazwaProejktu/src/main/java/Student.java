/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomasz
 */
public class Student {
    
    private String imie;
    private String nazwisko;
    private Double srednia;
    
    public Student(String i,String n, Double s){
        imie = i;
        nazwisko=n;
        srednia = s;
    }
    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the srednia
     */
    public Double getSrednia() {
        return srednia;
    }

    /**
     * @param srednia the srednia to set
     */
    public void setSrednia(Double srednia) {
        this.srednia = srednia;
    }
}
