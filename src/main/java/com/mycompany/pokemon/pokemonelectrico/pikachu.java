/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.pokemonelectrico;

/**
 *
 * @author Dexter
 */
public class pikachu extends pokemonElectrico {

    protected static final String NOMBRE = "Pikachu";
    protected static final int PUNTOS_VIDA = 135;
    protected static final int DAÑO = 80;
    protected static final int DEFENSA = 50;

    public pikachu() {
        Nombre = NOMBRE;
        PuntosVida = PUNTOS_VIDA;
        Daño = DAÑO;
        Defensa = DEFENSA;
    }

    //carga sus siguientes dos ataques un 10%
    @Override
    public double habilidadEspecial(double Supercarga) {
        return Supercarga * 0.10;
    }
}
