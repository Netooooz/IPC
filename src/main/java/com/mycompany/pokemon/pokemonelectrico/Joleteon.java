/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.pokemonelectrico;

/**
 *
 * @author Dexter
 */
public class Joleteon extends pokemonElectrico {
    protected static final String NOMBRE ="Joleteon";
     protected static final int PUNTOS_VIDA=195;
    protected static final int DAÑO=65;
    protected static final int DEFENSA=60;

    public Joleteon() {
        Nombre=NOMBRE;
    PuntosVida=PUNTOS_VIDA;
    Daño=DAÑO;
    Defensa=DEFENSA;
    }
    //metodo para realizarle un daño del 10% del enemigo
    @Override
     public double habilidadEspecial(double defensaEnemigo){
    return defensaEnemigo*0.10;
    }
    
}
