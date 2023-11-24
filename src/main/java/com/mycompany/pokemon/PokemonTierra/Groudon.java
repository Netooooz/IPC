/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.PokemonTierra;

/**
 *
 * @author Dexter
 */
public class Groudon extends pokemonTierra {

    protected static final String NOMBRE = "Groudon";
    protected static final int PUNTOS_VIDA = 300;
    protected static final int DAÑO = 180;
    protected static final int DEFENSA = 160;

    public Groudon() {
        Nombre = NOMBRE;
        PuntosVida = PUNTOS_VIDA;
        Daño = DAÑO;
        Defensa = DEFENSA;
    }

    public double HabilidadEspecial(double dañoEnemigo) {

        return dañoEnemigo = dañoEnemigo - (dañoEnemigo * 0.5);
    }

}
