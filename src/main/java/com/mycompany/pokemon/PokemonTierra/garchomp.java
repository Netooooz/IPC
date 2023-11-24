/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.PokemonTierra;

import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class garchomp extends pokemonTierra {
    protected static final String NOMBRE= "Garchomp";
    protected static final int PUNTOS_VIDA = 324;
    protected static final int DAÑO = 108;
    protected static final int DEFENSA = 115;
    protected util Util;

    public garchomp() {
        Nombre=NOMBRE;
        PuntosVida = PUNTOS_VIDA;
        Daño = DAÑO;
        Defensa = DEFENSA;
    }

    public int HabilidadEspecial() {
        int habilidad = Defensa * 10;
        return Defensa=Defensa+habilidad;
    }
}
