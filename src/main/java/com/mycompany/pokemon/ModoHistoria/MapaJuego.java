/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.ModoHistoria;

import MenuBatalla.Batalla;
import com.mycompany.pokemon.Personajes.Jugador;
import com.mycompany.pokemon.PokemoN;
import com.mycompany.pokemon.mapas.Casillas.Agua;
import com.mycompany.pokemon.mapas.Casillas.Arbol;
import com.mycompany.pokemon.mapas.Casillas.Pasto;
import com.mycompany.pokemon.mapas.Casillas.hierbaAlta;
import com.mycompany.pokemon.mapas.construirMapa;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class MapaJuego {

    private util herramienta;
    construirMapa mapa;
    String pasto = new String("\uD83C\uDF41");
    String jugadorlogo = new String("\uD83C\uDFC3");
    String HierbaAlta = new String("\uD83C\uDF3F");
    String arboll = new String("\uD83C\uDF33");
    String logopokemon = new String("\uD83D\uDC2F");
    String logomaestro = new String("\uD83C\uDFC7");
    private int posX;
    private int posY;
    private int cantPokemon = 0;
    private int cantMaestro = 0;
    private int posPX;
    private int posPY;
    private int posEX;
    private int posEY;
    private boolean salir = false;
    PokemoN pokemonJ;
    String Nombree;

    public MapaJuego(PokemoN j1, String Nombre) {
        pokemonJ=j1;
        Nombree=Nombree;
        herramienta = new util();
        mapa = new construirMapa(9, 9, 25, 12, 20, 24);
        herramienta.inicioJuego();
        Pocionjugador();
        movimientos();

    }

    public void Pocionjugador() {
        int contadorPokemon = 0;
        int contadorMaestro = 0;
        //genera al jugador
        do {
            posX = herramienta.numeroAlatorio(0, mapa.getAncho());
            posY = herramienta.numeroAlatorio(0, mapa.getLargo());
        } while ((mapa.getCasillas(posX, posY) instanceof Agua) || (mapa.getCasillas(posX, posY) instanceof Arbol));
        mapa.setCasillas(jugadorlogo, posX, posY);
        //generar pokemons
        cantPokemon = herramienta.numeroAlatorio(1, 5);
        do {
            do {
                posPX = herramienta.numeroAlatorio(0, mapa.getAncho());
                posPY = herramienta.numeroAlatorio(0, mapa.getLargo());
            } while (!(mapa.getCasillas(posPX, posPY) instanceof hierbaAlta) || (mapa.getCasillas(posPX, posPY).getLogo().equals(jugadorlogo)));
            mapa.setCasillas(logopokemon, posPX, posPY);
            contadorPokemon++;
        } while (contadorPokemon != cantPokemon);
        //generar maestro pokemon 
        cantMaestro = herramienta.numeroAlatorio(1, 5);
        do {
            do {
                posEX = herramienta.numeroAlatorio(0, mapa.getAncho());
                posEY = herramienta.numeroAlatorio(0, mapa.getLargo());
            } while (!(mapa.getCasillas(posEX, posEY) instanceof Pasto) || (mapa.getCasillas(posEX, posEY).getLogo().equals(jugadorlogo)));
            mapa.setCasillas(logomaestro, posEX, posEY);
            contadorMaestro++;
        } while (contadorMaestro != cantMaestro);
        mapa.mostrarTablero();
        herramienta.colorCyan("La posicion del jugador es ");
        herramienta.colorCyan("fila: " + posX);
        herramienta.colorCyan("columna: " + posY);
    }

    public void movimientos() {
        int numero;
        int temporalX = posX;
        int temporalY = posY;

        do {
            
            herramienta.colorVerde("hacia donde se desea mover:");
            herramienta.colorVerde("1. arriba");
            herramienta.colorVerde("2. abajo");
            herramienta.colorVerde("3. izquierda");
            herramienta.colorVerde("4. derecha");
            herramienta.colorVerde("5. salir");
            numero = herramienta.solicitarNumero("Ingrese una de las 5 opciones ", 1, 5);
            switch (numero) {
                case 1: {
                    temporalX = temporalX - 1;
                    if (temporalY < 0) {
                        herramienta.colorRojo("no puedes exeder los limites");
                        temporalX = temporalX + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Agua) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de agua");
                        temporalX = temporalX + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(arboll)) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        int pregunta = herramienta.solicitarNumero("deseas talar el arbol ¿si/no?", 1, 2);
                        if (pregunta == 1) {
                            mapa.setCasillas(pasto, temporalX, temporalY);
                            herramienta.colorAmarrillo("el arbol fue removido");
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            regresarLogo();
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        } else {
                            herramienta.colorRojo("usted no puede avanzar");
                            temporalX = temporalX + 1;
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        }
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(pasto)) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarLogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(HierbaAlta)) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarLogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                }
                posX = temporalX;
                posY = temporalY;
                break;
                case 2: {
                    temporalX = temporalX + 1;
                    if (temporalX >= mapa.getLargo()) {
                        herramienta.colorRojo("no puedes exeder los limites");
                        temporalY = temporalY - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Agua) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de agua");
                        temporalX = temporalX - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(arboll)) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        int pregunta = herramienta.solicitarNumero("deseas talar el arbol ¿si/no?", 1, 2);
                        if (pregunta == 1) {
                            mapa.setCasillas(pasto, temporalX, temporalY);
                            herramienta.colorAmarrillo("el arbol fue removido");
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            regresarLogo();
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        } else {
                            herramienta.colorRojo("usted no puede avanzar");
                            temporalX = temporalX - 1;
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        }
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(pasto)) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarLogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(HierbaAlta)) {
                        regresarLogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    posX = temporalX;
                    posY = temporalY;
                    break;
                }
                case 3: {
                    temporalY = temporalY - 1;
                    if (temporalY < 0) {
                        herramienta.colorRojo("no puedes exeder los limites");
                        temporalY = temporalY + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Agua) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de agua");
                        temporalY = temporalY + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(arboll)) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        int pregunta = herramienta.solicitarNumero("deseas talar el arbol ¿si/no?", 1, 2);
                        if (pregunta == 1) {
                            mapa.setCasillas(pasto, temporalX, temporalY);
                            herramienta.colorAmarrillo("el arbol fue removido");
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            regresarLogo();
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);

                        } else {
                            herramienta.colorRojo("usted no puede avanzar");
                            temporalY = temporalY + 1;
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        }
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(pasto)) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarLogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(HierbaAlta)) {
                        regresarLogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    posX = temporalX;
                    posY = temporalY;
                    break;
                }
                case 4: {
                    temporalY = temporalY + 1;
                    if (temporalY >= mapa.getLargo()) {
                        herramienta.colorRojo("no puedes exeder los limites");
                        temporalY = temporalY - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Agua) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de agua");
                        temporalY = temporalY - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(arboll)) {

                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        int pregunta = herramienta.solicitarNumero("deseas talar el arbol ¿si/no?", 1, 2);
                        if (pregunta == 1) {
                            mapa.setCasillas(pasto, temporalX, temporalY);
                            herramienta.colorAmarrillo("el arbol fue removido");
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            regresarLogo();
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);

                        } else {
                            herramienta.colorRojo("usted no puede avanzar");
                            temporalY = temporalY - 1;
                            mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                            mapa.mostrarTablero();
                            herramienta.colorCyan("La posicion del jugador es ");
                            herramienta.colorCyan("fila: " + temporalX);
                            herramienta.colorCyan("columna: " + temporalY);
                        }
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(pasto)) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarLogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY).getLogo().equals(HierbaAlta)) {
                        regresarLogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    posX = temporalX;
                    posY = temporalY;
                    break;
                }
                case 5:
                    Modohistoria modohistoria=new Modohistoria();
                    salir = true;
                    break;
            }
            iniciarpeleaPokemon();
        } while (salir == false);
    }

    public void regresarLogo() {
        int x = posX;
        int y = posY;
        if (mapa.getCasillas(x, y) instanceof Pasto) {
            mapa.setCasillas(pasto, posX, posY);
        }
        if (mapa.getCasillas(x, y) instanceof hierbaAlta) {
            mapa.setCasillas(HierbaAlta, posX, posY);
        }
        if (mapa.getCasillas(x, y) instanceof Arbol) {
            mapa.setCasillas(pasto, posX, posY);
        }
    }

    public void iniciarpeleaPokemon() {
        int x = posX;
        int x1 = posX + 1;
        int x2 = posX - 1;
        int y = posY;
        int y1 = posY + 1;
        int y2 = posY - 1;
        if (x1 < mapa.getLargo()) {
            if (mapa.getCasillas(x1, y).getLogo().equals(logopokemon)) {
               
                Batalla batallaj = new Batalla(pokemonJ, Nombree);
                salir = true;
            }
        }
        if (x2 > 0) {
            if (mapa.getCasillas(x2, y).getLogo().equals(logopokemon)) {
                Batalla batallaP = new Batalla(pokemonJ,Nombree);
                
                salir = true;
            }
        }
        if (y1 < mapa.getAncho()) {
            if (mapa.getCasillas(x, y1).getLogo().equals(logopokemon)) {
                Batalla batallaP = new Batalla(pokemonJ,Nombree);
              
                salir = true;
            }
        }

        if (y1 > 0) {
            if (mapa.getCasillas(x, y2).getLogo().equals(logopokemon)) {
                Batalla batallaP = new Batalla(pokemonJ,Nombree);
              
                salir = true;
            }
        }

    }
}
