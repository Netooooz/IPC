/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.mapas.Casillas;

import com.mycompany.pokemon.mapas.Casillas.Casillas;

/**
 *
 * @author Dexter
 */
public class hierbaAlta extends Casillas {
    
    public hierbaAlta(int id, String logo) {
        super(id, logo);
    }
    @Override
    public String ImprimirLogo(){
    return "H";
    }
    
    
    
}
