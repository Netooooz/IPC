/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menud;

/**
 *
 * @author Dexter
 */
import com.mycompany.pokemon.util.util;
import java.util.Random;
import java.util.Scanner;

public class Cacino {
    private static final int ORO_INICIAL = 0;
    private static final int PASOS_PRINCIPIANTE = 100;
    private static final int PASOS_MEDIO = 50;
    private static final int PASOS_PROFESIONAL = 30;

    private static final int TAMANO_TABLERO_PRINCIPIANTE = 10;
    private static final int TAMANO_TABLERO_MEDIO = 8;
    private static final int TAMANO_TABLERO_PROFESIONAL = 6;

    private static final int ORO_MANZANA_PRINCIPIANTE = 25;
    private static final int ORO_MANZANA_MEDIO = 50;
    private static final int ORO_MANZANA_PROFESIONAL = 75;

    private static final  String JUGADOR = new String("\uD83C\uDFC3");
    private static final String CASILLA_LIBRE =  new String("\uD83D\uDD05");
    private static final String CASILLA_OCUPADA = new String("\uD83D\uDD12");
    private static final String MANZANA = new String("\uD83C\uDF4E");

    private int pasosDisponibles;
    private int oro;
    private String[][] tablero;
    private int jugadorX, jugadorY;
    private int manzanaX, manzanaY;
    private Random random = new Random();
    util util;

    public Cacino(int nivel) {
        util= new util();
        switch (nivel) {
            case 1:
                pasosDisponibles = PASOS_PRINCIPIANTE;
                tablero = new String[TAMANO_TABLERO_PRINCIPIANTE][TAMANO_TABLERO_PRINCIPIANTE];
                oro = ORO_INICIAL;
                break;
            case 2:
                pasosDisponibles = PASOS_MEDIO;
                tablero = new String[TAMANO_TABLERO_MEDIO][TAMANO_TABLERO_MEDIO];
                oro = ORO_INICIAL;
                break;
            case 3:
                pasosDisponibles = PASOS_PROFESIONAL;
                tablero = new String[TAMANO_TABLERO_PROFESIONAL][TAMANO_TABLERO_PROFESIONAL];
                oro = ORO_INICIAL;
                break;
            default:
                System.out.println("Nivel no válido.");
                return;
        }

        inicializarTablero();
        ubicarJugador();
        ubicarManzana();
    }

    private void inicializarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = CASILLA_LIBRE;
            }
        }
    }

    private void ubicarJugador() {
        jugadorX = random.nextInt(tablero.length);
        jugadorY = random.nextInt(tablero[0].length);
        tablero[jugadorX][jugadorY] = JUGADOR;
    }

    private void ubicarManzana() {
        do {
            manzanaX = random.nextInt(tablero.length);
            manzanaY = random.nextInt(tablero[0].length);
        } while (tablero[manzanaX][manzanaY] != CASILLA_LIBRE);

        tablero[manzanaX][manzanaY] = MANZANA;
    }

    private void imprimirTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean moverJugador(int direccion) {
        int nuevoX = jugadorX;
        int nuevoY = jugadorY;
    
        if (direccion == 1 && jugadorX > 0) {
            nuevoX--;
        } else if (direccion == 2 && jugadorX < tablero.length - 1) {
            nuevoX++;
        } else if (direccion == 3 && jugadorY > 0) {
            nuevoY--;
        } else if (direccion == 4 && jugadorY < tablero[0].length - 1) {
            nuevoY++;
        } else {
            System.out.println("Movimiento no válido.");
            return false;
        }

        if (tablero[nuevoX][nuevoY] == CASILLA_OCUPADA) {
            System.out.println("Has chocado con una casilla ocupada. Pierdes un paso.");
            pasosDisponibles--;
        } else {
            tablero[jugadorX][jugadorY] = CASILLA_OCUPADA;
            jugadorX = nuevoX;
            jugadorY = nuevoY;

            if (tablero[jugadorX][jugadorY] == MANZANA) {
                System.out.println("¡Has atrapado una manzana!");
                oro += obtenerOroPorNivel();
                pasosDisponibles += obtenerPasosExtraPorNivel();
                ubicarManzana();
            }

            pasosDisponibles--;

            if (pasosDisponibles <= 0) {
                System.out.println("¡Te has quedado sin pasos! El juego ha terminado.");
                return false;
            }
        }

        return true;
    }

    private int obtenerOroPorNivel() {
        switch (pasosDisponibles) {
            case PASOS_PRINCIPIANTE:
                return ORO_MANZANA_PRINCIPIANTE;
            case PASOS_MEDIO:
                return ORO_MANZANA_MEDIO;
            case PASOS_PROFESIONAL:
                return ORO_MANZANA_PROFESIONAL;
            default:
                return 0;
        }
    }

    private int obtenerPasosExtraPorNivel() {
        switch (pasosDisponibles) {
            case PASOS_PRINCIPIANTE:
                return 3;
            case PASOS_MEDIO:
                return 5;
            case PASOS_PROFESIONAL:
                return 10;
            default:
                return 0;
        }
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        int direccion;

        System.out.println("¡Bienvenido a Catch the Apple!");

        while (true) {
            System.out.println("Nivel " + pasosDisponibles + ":");
            imprimirTablero();
            System.out.println("Oro: " + oro);
            System.out.println("Pasos disponibles: " + pasosDisponibles);

            
            direccion = util.solicitarNumero("Elige una dirección (1 arriba/2 abajo/3 izquierda/4 derecha)", 1, 4);

            if (direccion == 'Q' || direccion == 'q') {
                System.out.println("¡Gracias por jugar!");
                break;
            }

            if (!moverJugador(direccion)) {
                break;
            }
        }

       
    }

   
}
