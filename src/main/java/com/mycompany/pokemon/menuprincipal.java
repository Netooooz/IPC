/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

import Menud.MenuHistoria;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class menuprincipal {
    util util = new util();
    public menuprincipal() {
        util.colorAzul("Bienvenido al juego de pokemon");
        util.colorVerde("1 Modo historia");
        util.colorVerde("2 Reportes");
        int numero= util.solicitarNumero("elija una opcion", 1, 2);
        if (numero==1) {
            MenuHistoria menuHistoria= new MenuHistoria();
        }else{
            System.err.println("aqui deberian estar los reportes :(");
        }
    }
    
    
}
