/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import com.mycompany.pokemon.PokemonAgua.pokemonAgua;
import com.mycompany.pokemon.PokemonTierra.pokemonTierra;
import com.mycompany.pokemon.pokemonFuego.PokemonFuego;
import com.mycompany.pokemon.pokemonelectrico.pokemonElectrico;
import com.mycompany.pokemon.util.util;
import java.util.Random;

/**
 *
 * @author Dexter
 */
public class PokemoN {
    protected  String Nombre;
    protected int PuntosVida;
    protected int Daño;
    protected int Defensa;
    protected int Nivel;
    util herramienta = new util();
    public double atacar(PokemoN atacante, PokemoN atacado) {
        double ataque=0;
        if (atacante instanceof pokemonTierra && atacado instanceof pokemonTierra) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonTierra && atacado instanceof PokemonFuego) {
             Random random = new Random();
        ataque=Daño*1.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonTierra && atacado instanceof pokemonAgua) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonTierra && atacado instanceof pokemonElectrico) {
             Random random = new Random();
        ataque=Daño*1.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof PokemonFuego && atacado instanceof pokemonTierra) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof PokemonFuego && atacado instanceof PokemonFuego) {
             Random random = new Random();
        ataque=Daño*0.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof PokemonFuego && atacado instanceof pokemonAgua) {
             Random random = new Random();
        ataque=Daño*0.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof PokemonFuego && atacado instanceof pokemonElectrico) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        }if (atacante instanceof pokemonAgua && atacado instanceof pokemonTierra) {
             Random random = new Random();
        ataque=Daño*1.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonAgua && atacado instanceof PokemonFuego) {
             Random random = new Random();
        ataque=Daño*1.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonAgua && atacado instanceof pokemonAgua) {
             Random random = new Random();
        ataque=Daño*0.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonAgua && atacado instanceof pokemonElectrico) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        }
        if (atacante instanceof pokemonElectrico && atacado instanceof pokemonTierra) {
             Random random = new Random();
        ataque=Daño*0.4 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonElectrico && atacado instanceof PokemonFuego) {
             Random random = new Random();
        ataque=Daño * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonElectrico && atacado instanceof pokemonAgua) {
             Random random = new Random();
        ataque=Daño*1.6 * random.nextDouble()* 0.5 + 0.25;
        } 
        if (atacante instanceof pokemonElectrico && atacado instanceof pokemonElectrico) {
             Random random = new Random();
        ataque=Daño*0.6 * random.nextDouble()* 0.5 + 0.25;
        }
        
       
        
        return ataque;
    }

    public double defender() {
        Random random = new  Random();
        double defensaa=Defensa* random.nextDouble()* 0.25 + 0.25;
        return defensaa;
    }
    public double recibirDaño(double daño) {
        // defenderse
        // hacer resta de daño menos defensa
        // disminuir los puntos de vida en base al resultado de la resta
        
        double defensa = defender();
        double dañoFinal = daño - defensa;
        if (dañoFinal < 0) {
            dañoFinal = 0;
        }
        
        PuntosVida -= dañoFinal;
        if (PuntosVida < 0) {
            PuntosVida = 0;
        }
        
        return dañoFinal;
    }
    

    public int obtenerPuntosVida() {
        return PuntosVida;
    }

    public void setPuntosVida(int PuntosVida) {
        this.PuntosVida = PuntosVida;
    }

    public int getDaño() {
        return Daño;
    }

    public void setDaño(int Daño) {
        this.Daño = Daño;
    }

    public int getDefensa() {
        return Defensa;
    }

    public void setDefensa(int Defensa) {
        this.Defensa = Defensa;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public boolean estaVivo(){
    return PuntosVida>0;
    }
      public double hablidadEspecial(double defensa){
    return defensa;
    }

}
