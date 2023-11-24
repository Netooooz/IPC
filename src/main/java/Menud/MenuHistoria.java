/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menud;

import com.mycompany.pokemon.ModoHistoria.Modohistoria;
import com.mycompany.pokemon.util.util;

/**
 *
 * @author Dexter
 */
public class MenuHistoria {

    private util util;
    private String Nombre;
    private int Numero;

   
    

    public MenuHistoria() {
        util = new util();
        util.Menuhisotriaa();
        Nombre = util.solicitarString("ingrese su nombre");
        util.colorAzul("1. Groudon");
        util.colorAzul("2. Garchomp");
        util.colorAzul("3. Reshiram");
        util.colorAzul("4. Ho-ho");
        util.colorAzul("5. Gyarados");
        util.colorAzul("6. Kyogre");
        util.colorAzul("7. Pikachu");
        util.colorAzul("8. Jolteon");
        Numero = util.solicitarNumero("Elija su pokemon", 0, 8);

        Modohistoria md = new Modohistoria(Nombre, Numero);
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

}
