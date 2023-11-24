/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.PokemonAgua;

/**
 *
 * @author Dexter
 */
public class Gyarados extends pokemonAgua {
    protected static final String  NOMBRE = "Gyarados";
    protected static final int PUNTOS_VIDA=285;
    protected static final int DAÑO=155;
    protected static final int DEFENSA=109;

    public Gyarados() {
        Nombre=NOMBRE;
        PuntosVida=PUNTOS_VIDA;
        Daño=DAÑO;
        Defensa=DEFENSA;
    }
    
    
    public double hablidadEspecial(double defensa){
    return defensa=defensa+(defensa*0.10);
    }
}
