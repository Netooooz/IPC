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
public class Ho_ho extends PokemonFuego {

    protected static final String NOMBRE = "Ho_ho";
    protected static final int PUNTOS_VIDA = 318;
    protected static final int DAÑO = 120;
    protected static final int DEFENSA = 100;

    public Ho_ho() {
        Nombre = NOMBRE;
        PuntosVida = PUNTOS_VIDA;
        Daño = DAÑO;
        Defensa = DEFENSA;
    }

    @Override
    public double Habilidad(double defensaEnemigo) {

        return defensaEnemigo*0.10;
    }
}
