/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.mapas;

import com.mycompany.pokemon.mapas.Casillas.Pasto;
import com.mycompany.pokemon.mapas.Casillas.CasillaTienda;
import com.mycompany.pokemon.mapas.Casillas.CasillaPuerta;
import com.mycompany.pokemon.mapas.Casillas.CasillaInventario;
import com.mycompany.pokemon.mapas.Casillas.CasillaHospita;
import com.mycompany.pokemon.mapas.Casillas.CasillaCasino;
import com.mycompany.pokemon.mapas.Casillas.Arbol;
import com.mycompany.pokemon.mapas.Casillas.Casillas;
import com.mycompany.pokemon.mapas.Casillas.Agua;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class CrearMapaPrincipal {

    String inventario = new String("\uD83C\uDFE0");
    String hospital = new String("\uD83C\uDFE5");
    String casino = new String("\uD83C\uDFB0");
    String generar_mapas = new String("\uD83D\uDEAA");
    String tienda = new String("\uD83C\uDFEA");
    String arbol = new String("\uD83C\uDF33");
    String agua = new String("\uD83D\uDCA7");
    String pasto = new String("\uD83C\uDF41");
    //datos de mapa
    protected int largo = 9;
    protected int ancho = 9;
    protected Casillas[][] casillasPrincipal = new Casillas[largo][largo];

    private util herramienta;

    public CrearMapaPrincipal() {
        LlenarMapa();
    }

    public void LlenarMapa() {
        CasillaCasino cacinoo = new CasillaCasino(5, casino);
        CasillaHospita hospitaal = new CasillaHospita(6, hospital);
        CasillaPuerta puerta = new CasillaPuerta(7, generar_mapas);
        CasillaTienda Tienda = new CasillaTienda(8, tienda);
        CasillaInventario Inventario = new CasillaInventario(9, inventario);
        casillasPrincipal[0][4] = cacinoo;
        casillasPrincipal[4][0] = Inventario;
        casillasPrincipal[8][4] = Tienda;
        casillasPrincipal[8][8] = puerta;
        casillasPrincipal[4][8] = hospitaal;
        //recorrer las filas o rengolnes de la columna cero 
        for (int i = 0; i < ancho; i++) {
            Arbol arbool = new Arbol(1, arbol);
            if (casillasPrincipal[i][0] == null) {

                casillasPrincipal[i][0] = arbool;
            }

        }
        // recorre las filas de la columna 1
        for (int i = 4; i < 6; i++) {
            Pasto pastoo = new Pasto(3, pasto);
            if (casillasPrincipal[i][1] == null) {

                casillasPrincipal[i][1] = pastoo;
            }
        }
        for (int i = 0; i < ancho; i++) {
            Arbol arbool = new Arbol(1, arbol);
            if (casillasPrincipal[i][1] == null) {

                casillasPrincipal[i][1] = arbool;
            }
        }
        //recorre las filas de la columna 2
        for (int i = 2; i < 7; i++) {
            Pasto pastoo = new Pasto(3, pasto);
            if (casillasPrincipal[i][2] == null) {

                casillasPrincipal[i][2] = pastoo;
            }
        }
        for (int i = 0; i < ancho; i++) {
            Arbol arbool = new Arbol(1, arbol);
            if (casillasPrincipal[i][2] == null) {

                casillasPrincipal[i][2] = arbool;
            }
        }
        //recorre las filas de la columna 3
        for (int i = 3; i < 6; i++) {
            Agua aguaa = new Agua(2, agua);
            casillasPrincipal[i][3] = aguaa;
        }
        for (int i = 1; i < 8; i++) {
            Pasto Passto = new Pasto(3, pasto);
            if (casillasPrincipal[i][3] == null) {
                casillasPrincipal[i][3] = Passto;
            }
        }
        for (int i = 0; i < ancho; i++) {
            Arbol arbool = new Arbol(1, arbol);
            if (casillasPrincipal[i][3] == null) {

                casillasPrincipal[i][3] = arbool;
            }
        }
        //recorre las filas de la columna 4
        Arbol arbool = new Arbol(1, arbol);
        casillasPrincipal[6][4] = arbool;
        for (int i = 3; i < 6; i++) {
            Agua aguaa = new Agua(3, agua);
            casillasPrincipal[i][4] = aguaa;
        }
        for (int i = 0; i < ancho; i++) {
            Pasto Passto = new Pasto(3, pasto);
            if (casillasPrincipal[i][4] == null) {

                casillasPrincipal[i][4] = Passto;
            }
        }
        //recorre las filas de la columna 5
        for (int i = 0; i < 4; i++) {
            Arbol arboool = new Arbol(1, arbol);
            
            if (casillasPrincipal[i][5] == null) {
                casillasPrincipal[i][5] = arboool;
            }
            if (casillasPrincipal[i][5]==casillasPrincipal[2][5]) {
                casillasPrincipal[i][5]=null;
            }
        }
        for (int i = 4; i < 6; i++) {
            Agua aguaa = new Agua(2, agua);
            casillasPrincipal[i][5] = aguaa;
        }for (int i = 2; i < ancho; i++) {
            Pasto Passto = new Pasto(3, pasto);
            if (casillasPrincipal[i][5] == null) {
                casillasPrincipal[i][5] = Passto;
            }
        }
        //recorre la columna 6
        for (int i = 2; i < 8; i++) {
            Pasto Passto = new Pasto(3, pasto);
            if (casillasPrincipal[i][6] == null) {
                casillasPrincipal[i][6] = Passto;
            }
            if (casillasPrincipal[i][6]==casillasPrincipal[5][6]) {
                casillasPrincipal[i][6]=null;
            }
        }
        for (int i = 0; i < ancho; i++) {
            Arbol arboool = new Arbol(1, arbol);
            
            if (casillasPrincipal[i][6] == null) {
                casillasPrincipal[i][6] = arboool;
            }
          
        }
        // recorre las filas de la columna 7
        for (int i = 3; i < 8; i++) {
            Pasto Passto = new Pasto(3, pasto);
            if (casillasPrincipal[i][7] == null) {
                casillasPrincipal[i][7] = Passto;
            }            
        }
        for (int i = 0; i < ancho; i++) {
            Arbol arboool = new Arbol(1, arbol);           
            if (casillasPrincipal[i][7] == null) {
                casillasPrincipal[i][7] = arboool;
            }         
        }
        // recorre las filas de la columna 8
        Pasto paasto = new Pasto(2, pasto);
        casillasPrincipal[7][8]=paasto;
         for (int i = 0; i < ancho; i++) {
            Arbol arboool = new Arbol(1, arbol);           
            if (casillasPrincipal[i][8] == null) {
                casillasPrincipal[i][8] = arboool;
            }         
        }
    }

    public void mostrarTablero() {
        // no mostrar cuando el caracter es 'a'
        // mostrar X cuando no le atinamos
        // mostrar M cuando marcamos una mina correcta
        for (int i = 0; i < largo; i++) {
            for (int columna = 0; columna < ancho; columna++) {
                if (casillasPrincipal[i][columna] == null) {
                    System.err.print("n");
                } else {
                    System.out.print(casillasPrincipal[i][columna].getLogo() + " ");
                }

            }
            System.out.println();
        }
    }

    public int getLargo() {
        return largo;
    }

    public int getAncho() {
        return ancho;
    }
     public Casillas getCasillas(int x, int y) {
        return casillasPrincipal[x][y];
    }

    public void setCasillas(String casillas, int x, int y) {

        this.casillasPrincipal[x][y].setLogo(casillas);
    }

       
}
