/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menud;

import java.util.Scanner;

/**
 *
 * @author Dexter
 */
public class MenuCacino {

    public MenuCacino() {
        Scanner scanner = new Scanner(System.in);
        int nivel;

        System.out.println("Selecciona un nivel:");
        System.out.println("1. Principiante");
        System.out.println("2. Medio");
        System.out.println("3. Profesional");
        System.out.print("Ingresa el número del nivel: ");
        nivel = scanner.nextInt();

        if (nivel >= 1 && nivel <= 3) {
            Cacino juego = new Cacino(nivel);
            juego.jugar();
        } else {
            System.out.println("Nivel no válido. El juego ha terminado.");
        }

        scanner.close();
    }
    
}
