/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuBatalla;

import Menud.MenuHistoria;
import com.mycompany.pokemon.ModoHistoria.MapaJuego;
import com.mycompany.pokemon.ModoHistoria.Modohistoria;
import com.mycompany.pokemon.PokemoN;
import com.mycompany.pokemon.PokemonAgua.Gyarados;
import com.mycompany.pokemon.PokemonAgua.Kyogre;
import com.mycompany.pokemon.PokemonTierra.Groudon;
import com.mycompany.pokemon.PokemonTierra.garchomp;
import com.mycompany.pokemon.pokemonFuego.Ho_ho;
import com.mycompany.pokemon.pokemonFuego.Reshiram;
import com.mycompany.pokemon.pokemonelectrico.Joleteon;
import com.mycompany.pokemon.pokemonelectrico.pikachu;
import com.mycompany.pokemon.util.util;
import java.util.Scanner;

/**
 *
 * @author Dexter
 */
public class Batalla {
    Scanner scanner = new Scanner(System.in);
    int random;
    util herramienta;
    String Nombre;
    PokemoN[] arregloJugador = new PokemoN[5];
    PokemoN salvaje;
    PokemoN atacado;
    PokemoN atacante;
    boolean turnoJugador;

   
    public Batalla(PokemoN pokemoNs, String Nombre) {
        arregloJugador[0] = pokemoNs;
        this.Nombre = Nombre;
        herramienta = new util();
        GenerarPokemon();
        mostrar();
        pelear();
    }

    public void mostrar() {
        System.out.println("Bienvenido a la batalla");

        System.out.println("este es su pokemon " + arregloJugador[0].getNombre());
        herramienta.colorAmarrillo("el pokemon conta el que peleara es "+salvaje.getNombre());
        
    }

    public void GenerarPokemon() {
        random = herramienta.numeroAlatorio(1, 8);
        switch (random) {
            case 1:
                Groudon groudon1 = new Groudon();
                salvaje = groudon1;
                break;
            case 2:
                garchomp garchomp1 = new garchomp();
                salvaje = garchomp1;
                break;
            case 3:
                Reshiram reshiram = new Reshiram();
                salvaje = reshiram;
                break;
            case 4:
                Ho_ho ho_ho = new Ho_ho();
                salvaje = ho_ho;
                break;
            case 5:
                Gyarados gyarados = new Gyarados();
                salvaje = gyarados;
                break;
            case 6:
                Kyogre kyogre = new Kyogre();
                salvaje = kyogre;
                break;
            case 7:
                pikachu pikachu1 = new pikachu();
                salvaje = pikachu1;
                break;
            case 8:
                Joleteon joleteon = new Joleteon();
                salvaje = joleteon;

        }
    }
    

    public void pelear() {
        // aleatorio quien empieza
        definirQuienEmpieza();

        while (!haMuertoAlguno()) {
            imprimirQuienAtaca();
            // repetir hasta que uno muera
            // si es jugador, elije arma y gokpea
            // si es enemigo, golpea
            
            double dañoo= definirAccion(atacante);
            
            scanner.nextLine();
            
            double dañoRecibido = atacado.recibirDaño(dañoo);
            System.out.println("Se ha hecho " + dañoRecibido + " puntos de daño");
            scanner.nextLine();
            imprimirPuntosVida();
            cambiarAtacante();
        }

        imprimirGanador();

    }

    private void definirQuienEmpieza() {
        int random=herramienta.numeroAlatorio(0, 1);
        if (random == 0) {
            atacante = arregloJugador[0];
            atacado = salvaje;
            turnoJugador = true;
        } else {
            atacante = salvaje;
            atacado = arregloJugador[0];
            turnoJugador = false;
        }
    }

    private void cambiarAtacante() {
        if (turnoJugador) {
            atacante = salvaje;
            atacado = arregloJugador[0];
        } else {
            atacante = arregloJugador[0];
            atacado = salvaje;
        }
        turnoJugador = !turnoJugador;
    }

    private boolean haMuertoAlguno() {
        return !arregloJugador[0].estaVivo() || !salvaje.estaVivo();
    }
    
  
    public double definirAccion(PokemoN atacantee){
        double daño=0;
        System.out.println("Elija una accion:");
            System.out.println("1. atacar ");
            System.out.println("2. habilidad especial");
            int opcion=herramienta.solicitarNumero("elija", 1, 2);
            if (opcion==1){
                System.out.println("ha elejido atacar");
            daño=atacantee.atacar(atacante, atacado);
            }else{
                System.out.println("ha elejido usar habilidad especial");
            daño=atacantee.hablidadEspecial(salvaje.getDaño());
            }
        
        
        return daño;
    }
    

    private void imprimirPuntosVida() {
        System.out.println("Puntos de vida del judador:");
        System.out.println(arregloJugador[0].obtenerPuntosVida());
        System.out.println("Puntos de vida del enemigo:");
        System.out.println(salvaje.obtenerPuntosVida());
        System.out.println("Presione enter para continuar....");
        scanner.nextLine();
    }

    private void imprimirGanador() {
        if (arregloJugador[0].estaVivo()) {
            System.out.println("El ganador es el jugador."+"con su pokemon "+arregloJugador[0].getNombre() +" Presione enter para continuar....");
        } else {
            System.out.println("El ganador es el pokemon salvaje."+ salvaje.getNombre() +" Presione enter para regresar....");
        }
        MapaJuego mapa=new MapaJuego(arregloJugador[0], Nombre);
        scanner.nextLine();
    }

    private void imprimirQuienAtaca() {
        if (turnoJugador) {
            System.out.println("Ataca el jugador. Presione enter para continuar....");
        } else {
            System.out.println("Ataca el enemigo. Presione enter para continuar....");
        }
        scanner.nextLine();
    }
    

}
