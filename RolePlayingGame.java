import java.util.Random;
import java.util.Scanner;

public class RolePlayingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a la Arena, introduce el nombre de tu gladiador:");
        Hero player = new Hero(scanner.next(), 50, 50);
        int rondasSobrevividas = 0;

        while (player.getHealth() > 0) {
            System.out.println("\n-------- Ronda " + (rondasSobrevividas + 1) + " --------");
            int numEnemigos = new Random().nextInt(1, 4);

            Hero[] enemigos = new Hero[numEnemigos];
            for (int i = 0; i < numEnemigos; i++) {
                enemigos[i] = new Hero("Enemigo " + (i + 1), 5, 3);
                System.out.println("Aparece " + enemigos[i].getName() + "!");
            }

            while (player.getHealth() > 0 && hayEnemigosVivos(enemigos)) {
                jugadorTurno(player, enemigos);
                enemigosTurno(player, enemigos);
            }

            rondasSobrevividas++;

            if (new Random().nextDouble() < 0.001) {
                System.out.println("Encuentras una poción y recuperas vida.");
                player.drinkPotion();
            }

            if (new Random().nextDouble() < 0.1) {
                System.out.println("Descansas y recuperas vida.");
                player.rest();
            }
        }

        System.out.println("\n¡Game Over! Sobreviviste " + rondasSobrevividas + " hordas.");
    }

    private static boolean hayEnemigosVivos(Hero[] enemigos) {
        for (Hero enemigo : enemigos) {
            if (enemigo.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    private static void jugadorTurno(Hero jugador, Hero[] enemigos) {
        for (Hero enemigo : enemigos) {
            if (enemigo.getHealth() > 0) {
                System.out.println("\n" + jugador.getName() + " ataca a " + enemigo.getName() + "!");
                jugador.attack(enemigo);

                if (enemigo.getHealth() <= 0) {
                    System.out.println(enemigo.getName() + " ha sido derrotado.");
                } else {
                    System.out.println(enemigo.getName() + " contraataca!");
                    enemigo.attack(jugador);
                }
            }
        }
    }

    private static void enemigosTurno(Hero jugador, Hero[] enemigos) {
        for (Hero enemigo : enemigos) {
            if (enemigo.getHealth() > 0) {
                if (new Random().nextDouble() < 0.1) {
                    System.out.println(enemigo.getName() + " huye de la pelea.");
                } else {
                    System.out.println(enemigo.getName() + " ataca a " + jugador.getName() + "!");
                    enemigo.attack(jugador);
                }
            }
        }
    }
}