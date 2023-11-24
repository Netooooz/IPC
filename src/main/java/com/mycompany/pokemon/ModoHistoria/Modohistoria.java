/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.ModoHistoria;

import Menud.Cacino;
import Menud.Hospital;
import Menud.Inventario;
import Menud.MenuCacino;
import Menud.tienda;
import com.mycompany.pokemon.Personajes.Jugador;
import com.mycompany.pokemon.PokemoN;
import com.mycompany.pokemon.PokemonAgua.Gyarados;
import com.mycompany.pokemon.PokemonAgua.Kyogre;
import com.mycompany.pokemon.PokemonTierra.Groudon;
import com.mycompany.pokemon.PokemonTierra.garchomp;
import com.mycompany.pokemon.mapas.Casillas.Agua;
import com.mycompany.pokemon.mapas.Casillas.Arbol;
import com.mycompany.pokemon.mapas.Casillas.CasillaCasino;
import com.mycompany.pokemon.mapas.Casillas.CasillaHospita;
import com.mycompany.pokemon.mapas.Casillas.CasillaInventario;
import com.mycompany.pokemon.mapas.Casillas.CasillaPuerta;
import com.mycompany.pokemon.mapas.Casillas.CasillaTienda;
import com.mycompany.pokemon.mapas.Casillas.Casillas;
import com.mycompany.pokemon.mapas.Casillas.Pasto;
import com.mycompany.pokemon.mapas.Casillas.hierbaAlta;
import com.mycompany.pokemon.mapas.CrearMapaPrincipal;
import com.mycompany.pokemon.mapas.construirMapa;
import com.mycompany.pokemon.pokemonFuego.Ho_ho;
import com.mycompany.pokemon.pokemonFuego.Reshiram;
import com.mycompany.pokemon.pokemonelectrico.Joleteon;
import com.mycompany.pokemon.pokemonelectrico.pikachu;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class Modohistoria {

    protected String Nombre;
    protected int Seleccion;
    private util herramienta;
    CrearMapaPrincipal mapa;
    String pasto = new String("\uD83C\uDF41");
    String jugadorlogo = new String("\uD83C\uDFC3");
    String HierbaAlta = new String("\uD83C\uDF3F");
    String arbol = new String("\uD83C\uDF33");
    PokemoN[] pokemonjugador = new PokemoN[5];
    private int posX;
    private int posY;
    construirMapa construirmapa;
    Jugador Jugador = new Jugador(Nombre, pokemonjugador, jugadorlogo);
    
    public Modohistoria(){
    }
    public Modohistoria(String Nombre, int Seleccion) {
        this.Nombre = Nombre;
        this.Seleccion = Seleccion;
        herramienta = new util();
        herramienta.colorCyan("\n\nBienvenido "+Nombre+ " al mapa principal\n\n");
        mapa = new CrearMapaPrincipal();
        switch (Seleccion) {
            case 1:
                Groudon groudon1= new Groudon();
                pokemonjugador[0]=groudon1;
                break;
            case 2:
                garchomp garchomp1= new garchomp();
                pokemonjugador[0]=garchomp1;
                break;
            case 3:
                Reshiram reshiram = new Reshiram();
                pokemonjugador[0]=reshiram;
                break;
            case 4:
                Ho_ho ho_ho = new Ho_ho();
                pokemonjugador[0]=ho_ho;
                break;
            case 5: 
                Gyarados gyarados = new Gyarados();
                pokemonjugador[0]= gyarados;
                break;
            case 6:
                Kyogre kyogre = new Kyogre();
                pokemonjugador[0]= kyogre;
                break;
            case 7:
                pikachu pikachu1 = new pikachu();
                pokemonjugador[0]=pikachu1;
                break;
            case 8: 
                Joleteon joleteon = new Joleteon();
                pokemonjugador[0]=joleteon;
                
        }
        System.out.println("El pokemon que eligio es "+pokemonjugador[0].getNombre());

        Pocionjugador();
        movimientos();
    }

    public void Pocionjugador() {
        do {
            posX = herramienta.numeroAlatorio(0, mapa.getAncho());
            posY = herramienta.numeroAlatorio(0, mapa.getLargo());
        } while ((mapa.getCasillas(posX, posY) instanceof Agua) || (mapa.getCasillas(posX, posY) instanceof Arbol)
                || (mapa.getCasillas(posX, posY) instanceof CasillaCasino) || (mapa.getCasillas(posX, posY) instanceof CasillaHospita)
                || (mapa.getCasillas(posX, posY) instanceof CasillaInventario) || (mapa.getCasillas(posX, posY) instanceof CasillaPuerta)
                || (mapa.getCasillas(posX, posY) instanceof CasillaTienda));

        mapa.setCasillas(jugadorlogo, posX, posY);
        mapa.mostrarTablero();
        herramienta.colorCyan("La posicion del jugador es ");
        herramienta.colorCyan("fila: " + posX);
        herramienta.colorCyan("columna: " + posY);
    }

    public void movimientos() {
        int numero;
        int temporalX = posX;
        int temporalY = posY;

        boolean salir = false;
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
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Arbol) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        temporalX = temporalX + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Pasto) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof hierbaAlta) {

                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                }
                if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaCasino) {
                    MenuCacino menuCacino= new MenuCacino();
                   
                    salir = true;
                }
                if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaHospita) {
                    Hospital cacino = new Hospital();
                    cacino.mostrar();
                    salir = true;
                }
                if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaInventario) {
                        Inventario cacino = new Inventario();
                        cacino.mostrar();
                        salir = true;
                    }
                if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaTienda) {
                        tienda cacino = new tienda();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaPuerta) {
                        MapaJuego cacino = new MapaJuego(pokemonjugador[0],Nombre);
                        
                        salir = true;
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
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Arbol) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        temporalX = temporalX - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Pasto) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof hierbaAlta) {
                        regresarlogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaCasino) {
                        MenuCacino menuCacino= new MenuCacino();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaHospita) {
                        Hospital cacino = new Hospital();
                        cacino.mostrar();
                        salir = true;
                    }if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaInventario) {
                        Inventario cacino = new Inventario();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaTienda) {
                        tienda cacino = new tienda();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaPuerta) {
                        MapaJuego cacino = new MapaJuego(pokemonjugador[0],Nombre);
                        
                        salir = true;
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
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Arbol) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        temporalY = temporalY + 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Pasto) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof hierbaAlta) {
                        regresarlogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaCasino) {
                         MenuCacino menuCacino= new MenuCacino();
                   
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaHospita) {
                        Hospital cacino = new Hospital();
                        cacino.mostrar();
                        salir = true;
                    }if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaInventario) {
                        Inventario cacino = new Inventario();
                        cacino.mostrar();
                        salir = true;
                    }if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaTienda) {
                        tienda cacino = new tienda();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaPuerta) {
                        MapaJuego cacino = new MapaJuego(pokemonjugador[0],Nombre);
                        
                        salir = true;
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
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Arbol) {
                        herramienta.colorRojo("No puedes avanzar en una casilla de tipo arbol");
                        temporalY = temporalY - 1;
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof Pasto) {
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        regresarlogo();
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof hierbaAlta) {
                        regresarlogo();
                        mapa.setCasillas(jugadorlogo, temporalX, temporalY);
                        mapa.mostrarTablero();
                        herramienta.colorCyan("La posicion del jugador es ");
                        herramienta.colorCyan("fila: " + temporalX);
                        herramienta.colorCyan("columna: " + temporalY);
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaCasino) {
                       MenuCacino menuCacino= new MenuCacino();
                   
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaHospita) {
                        Hospital cacino = new Hospital();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaInventario) {
                        Inventario cacino = new Inventario();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaTienda) {
                        tienda cacino = new tienda();
                        cacino.mostrar();
                        salir = true;
                    }
                    if (mapa.getCasillas(temporalX, temporalY) instanceof CasillaPuerta) {
                        MapaJuego cacino = new MapaJuego(pokemonjugador[0], Nombre);
                        
                        salir = true;
                    }
                    posX = temporalX;
                    posY = temporalY;
                    break;
                }
                case 5:
                    salir = true;
                    break;
            }
        } while (salir == false);
    }
    public void regresarlogo() {
        int x = posX;
        int y = posY;
        if (mapa.getCasillas(x, y) instanceof Pasto) {
            mapa.setCasillas(pasto, posX, posY);
        }
        if (mapa.getCasillas(x, y) instanceof hierbaAlta) {
            mapa.setCasillas(HierbaAlta, posX, posY);
        }
        if (mapa.getCasillas(x, y) instanceof Arbol) {
            mapa.setCasillas(arbol, posX, posY);
        }
    }
    public PokemoN getPokemonjugador(int indice) {
        return pokemonjugador[indice];
    }
    public void setPokemonjugador(PokemoN[] pokemonjugador) {
        this.pokemonjugador = pokemonjugador;
    }
}
