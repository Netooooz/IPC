/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.pokemonFuego;

import com.mycompany.pokemon.pokemonFuego.PokemonFuego;

/**
 *
 * @author Dexter
 */
public class Reshiram extends PokemonFuego {

    protected static final String NOMBRE = "Reshiram";
    protected static final int Puntos_Vida = 300;
    protected static final int DAÑO = 120;
    protected static final int DEFENSA = 100;

    public Reshiram() {
        Nombre = NOMBRE;
        PuntosVida = Puntos_Vida;
        Daño = DAÑO;
        Defensa = DEFENSA;
    }

    public double Habilidad(double dañoAdicional) {
        
        return dañoAdicional=dañoAdicional+(dañoAdicional*0.10);
    }
}
