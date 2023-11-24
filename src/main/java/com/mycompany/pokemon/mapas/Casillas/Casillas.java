/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.mapas.Casillas;

/**
 *
 * @author Dexter
 */
public class Casillas {
    private int id;
    private String logo;

    public Casillas(int id, String logo) {
        this.id=id;
        this.logo=logo;
    
    }
    public String ImprimirLogo(){
    return this.logo;
    }

    public int getId() {
        return id;
    }

    public String getLogo() {
        
        return logo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
    
}
