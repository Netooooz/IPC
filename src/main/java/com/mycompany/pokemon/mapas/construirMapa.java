/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.mapas;

import com.mycompany.pokemon.mapas.Casillas.hierbaAlta;
import com.mycompany.pokemon.mapas.Casillas.Pasto;
import com.mycompany.pokemon.mapas.Casillas.Arbol;
import com.mycompany.pokemon.mapas.Casillas.Casillas;
import com.mycompany.pokemon.mapas.Casillas.Agua;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public  class construirMapa {

    String agua = new String("\uD83D\uDCA7");
    protected boolean estaTalado=false;
    //datos de mapa
    protected int largo;
    protected int ancho;
    protected Casillas[][] casillas;

    //datos casillas 
    protected int CantArbol;
    private Arbol[] casillaarbol;
    //protected casilla agua
    protected int CantAgua;
    private Agua[] casillaAguas;
    //datos casilla hierba alta;
    private int CantHierba;
    private hierbaAlta[] casillaHierAltas;
    // datos casilla pasto
    private int CantPasto;
    private Pasto[] casillaPastos;
    private util herramienta;

  
    

    public construirMapa(int largo, int ancho, int cantArbol, int cantAgua, int canthierba, int cantPasto) {
        this.largo = largo;
        this.ancho = ancho;
        this.CantAgua = cantAgua;
        this.CantHierba = canthierba;
        this.CantPasto = cantPasto;
        this.CantArbol = cantArbol;
        herramienta = new util();
        crearArray();
        crearCasillas();
        almacenarCasilla();

    }

    public void crearArray() {
        casillas = new Casillas[largo][largo];
        casillaAguas = new Agua[CantAgua];
        casillaarbol = new Arbol[CantArbol];
        casillaHierAltas = new hierbaAlta[CantHierba];
        casillaPastos = new Pasto[CantPasto];
    }

    public void almacenarCasilla() {
        almacenarAgua();
        almacenarArbol();
        almacenarhierba();
        AlmacenarPasto();

    }

    public void almacenarArbol() {
        int contador = 0;
        do {
            int PosX = herramienta.numeroAlatorio(0, largo);
            int PosY = herramienta.numeroAlatorio(0, ancho);
            if (casillas[PosX][PosY] == null) {
                casillas[PosX][PosY] = casillaarbol[contador];
                contador++;
            }

        } while (contador != casillaarbol.length);
    }

    public void almacenarAgua() {
        int contador=0;
        int posX;
        int posY;
        
        do {
            do {
                posX = herramienta.numeroAlatorio(0, largo);
                posY = herramienta.numeroAlatorio(0, ancho);
            } while (posX != 0 && posY != 0 && posX != 8 && posY != 8);

            if (casillas[posX][posY] == null) {
                casillas[posX][posY] = casillaAguas[contador];
                contador++;

            }
        } while (contador != casillaAguas.length);
    }

   
    public void almacenarhierba() {
        int contador = 0;
        do {
            int posX = herramienta.numeroAlatorio(0, largo);
            int posY = herramienta.numeroAlatorio(0, ancho);
            if (casillas[posX][posY] == null) {
                casillas[posX][posY] = casillaHierAltas[contador];
                contador++;
            }
        } while (contador != casillaHierAltas.length);

    }

    public void AlmacenarPasto() {
        int contador = 0;
        do {
            int posX = herramienta.numeroAlatorio(0, largo);
            int posy = herramienta.numeroAlatorio(0, ancho);
            if (casillas[posX][posy] == null) {
                casillas[posX][posy] = casillaPastos[contador];
                contador++;
            }
        } while (contador != casillaPastos.length);
    }

    public void crearCasillas() {
        crearArbol();
        crearAgua();
        crearhierba();
        crearpasto();

    }

    //crear casillas 
    public void crearArbol() {
        String arbol = new String("\uD83C\uDF33");
        for (int i = 0; i < CantArbol; i++) {
            casillaarbol[i] = new Arbol(1, arbol);

        }
    }

    public void crearAgua() {
        String agua = new String("\uD83D\uDCA7");
        for (int i = 0; i < CantAgua; i++) {
            casillaAguas[i] = new Agua(2, agua);
        }
    }

    public void crearpasto() {
        String pasto = new String("\uD83C\uDF41");
        for (int i = 0; i < CantPasto; i++) {
            casillaPastos[i] = new Pasto(3, pasto);
        }
    }

    public void crearhierba() {
        String HierbaAlta = new String("\uD83C\uDF3F");
        for (int i = 0; i < CantHierba; i++) {
            casillaHierAltas[i] = new hierbaAlta(4, HierbaAlta);

        }
    }

    public void mostrarTablero() {
        // no mostrar cuando el caracter es 'a'
        // mostrar X cuando no le atinamos
        // mostrar M cuando marcamos una mina correcta
        for (int i = 0; i < largo; i++) {
            for (int columna = 0; columna < ancho; columna++) {
                if (casillas[i][columna] == null) {
                    System.err.println("n");
                }
                System.out.print(casillas[i][columna].getLogo() + " ");

            }
            System.out.println();
        }
        

       
    }
      public String TalarArbol(int posx, int posy, String logo, int oro) {
          if (oro<5) {
              herramienta.colorRojo("no cuenta con el oro suficiente para realizar la tala");
          }else{
           casillas[posx][posy].setLogo(logo);
           estaTalado=true;
          }
       
        return logo;

    }
       public boolean ConfirmarTala(){
    
        return estaTalado;
    }

   

    public Casillas getCasillas(int x, int y) {
        return casillas[x][y];
    }

    public void setCasillas(String casillas, int x, int y) {

        this.casillas[x][y].setLogo(casillas);
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    

}
