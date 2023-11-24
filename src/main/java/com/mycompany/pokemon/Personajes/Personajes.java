/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.Personajes;

import com.mycompany.pokemon.PokemoN;

/**
 *
 * @author Dexter
 */
public class Personajes {
    protected String Nombre;
    protected PokemoN [] pokemon;
    protected String logo;

    public Personajes(String Nombre, PokemoN[] pokemon, String logo ) {
        this.Nombre = Nombre;
        this.pokemon = pokemon;
        this.logo=logo;
    }
    
}
