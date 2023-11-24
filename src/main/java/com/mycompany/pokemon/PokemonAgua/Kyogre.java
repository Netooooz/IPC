/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.PokemonAgua;

/**
 *
 * @author Dexter
 */
public class Kyogre extends pokemonAgua {
    protected static final String NOMBRE="Kyogre";
    protected static final int PUNTOS_VIDA=300;
    protected static final int DAÑO=150;
    protected static final int DEFENSA=90;
    public Kyogre(){
    Nombre= NOMBRE;
    PuntosVida=PUNTOS_VIDA;
    Daño=DAÑO;
    Defensa=DEFENSA;
    }
    
    public double habilidadEspecial(double defensaEnemigo){
        
    return defensaEnemigo*0.5;
    }
    
}
