/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon.util;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dexter
 */
public class util {
    
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String PURPLE = "\u001B[35m";
    private final String CYAN = "\u001B[36m";
    private final String RESET = "\u001B[0m";
    private final String WHITE = "\u001B[37m";

    private Scanner ingresar = new Scanner(System.in);
    private Random random = new Random();

    public String solicitarString(String mensaje) {
        String respuesta = "";
        boolean hayErrorStringIngresado = false;

        do {
            System.out.println("\n" + mensaje);
            respuesta = ingresar.nextLine();
            // scanner.nextLine();//probar
            respuesta = respuesta.trim();
            if (respuesta.length() > 0) {
                hayErrorStringIngresado = false;
            } else {
                hayErrorStringIngresado = true;
                colorRojo("Ingrese un caracter como minimo");
            }

        } while (hayErrorStringIngresado);

        return respuesta;
    }

    ////// analiza si el numero ingresado por el usuario esta en el rango solicitado
    public int solicitarNumero(String mensaje, int limiteInferior, int limiteSuperior) {
        int numeroIngresado = 0;
        boolean hayErrorNumeroIngresado = false;
        do {
            try {

                System.out.print("\n" + mensaje);
                colorRojo("[" + limiteInferior+","+limiteSuperior+"]");
                numeroIngresado = ingresar.nextInt();
                if ((numeroIngresado >= limiteInferior) && (numeroIngresado <= limiteSuperior)) {
                    hayErrorNumeroIngresado = false;
                } else {
                    hayErrorNumeroIngresado = true;
                    colorRojo("Debe ingresar un número entre [" + limiteInferior + " . . " + limiteSuperior + "]");
                }
            } catch (Exception e) {
                hayErrorNumeroIngresado = true;
                colorRojo("Debe ingresar un número entre [" + limiteInferior + " . . " + limiteSuperior + "]");
                System.out.println("Ingrese un numero entero.");

            }
            ingresar.nextLine();
        } while (hayErrorNumeroIngresado);

        return numeroIngresado;
    }

    ///// algunos diseños:
    public void tituloTienda() {
        estapcio();
        colorAzul("****************************************");
        colorAzul("*************** TIENDA *****************");
        colorAzul("****************************************");
    }

    public void tituloInvetnario() {
        estapcio();
        colorVerde("**************************************");
        colorVerde("************ INVENTARIO **************");
        colorVerde("**************************************");
    }

    public void tituloJugadoresInvatario() {
        estapcio();
        colorVerde("**************************************");
        colorVerde("************** cacino ****************");
        colorVerde("**************************************");

    }

    public void Menuhisotriaa() {
        estapcio();

        colorAmarrillo("*********************************");
        colorAmarrillo("********* Menu Hisoria **********");
        colorAmarrillo("*********************************");
    }

    public void inicioJuego() {
        estapcio();
        colorPurpura("***********************************");
        colorPurpura("*********  JUEGO POKEMON  *********");
        colorPurpura("***********************************");
    }

    public void listaMapa(){
        estapcio();
        colorAmarrillo("***********************************");
        colorAmarrillo("******* INVENTARIO DE MAPA ********");
        colorAmarrillo("***********************************");

    }
    public void listaObjetos (){
        estapcio();
        colorAmarrillo("***********************************");
        colorAmarrillo("****** INVENTARIO DE OBJETOS ******");
        colorAmarrillo("***********************************");

    }

    /******* Generar numeros Random */
    public int numeroAlatorio(int min, int max) {
        return random.nextInt(max - min) + min;
    }

    ///// colorear Salidas *****

    public void colorRojo(String textoPintar) {
        System.out.println(RED + textoPintar + RESET);
    }

    public void colorVerde(String textoPintar) {
        System.out.println(GREEN + textoPintar + RESET);
    }

    public void colorAmarrillo(String textoPintar) {
        System.out.println(YELLOW + textoPintar + RESET);
    }

    public void colorAzul(String textoPintar) {
        System.out.println(BLUE + textoPintar + RESET);
    }

    public void colorPurpura(String textoPintar) {
        System.out.println(PURPLE + textoPintar + RESET);
    }

    public void colorCyan(String textoPintar) {
        System.out.println(CYAN + textoPintar + RESET);
    }

    public void colorBlanco(String textoPintar) {
        System.out.println(WHITE + textoPintar + RESET);
    }

    public void estapcio() {
        System.out.println("\n\n\n");
    }
    
}
