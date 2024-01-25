import java.util.Scanner;

public class MainReloj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Reloj reloj = new Reloj();
        System.out.println("¿Prefieres mostrar la hora en formato de 12 horas? (true/false)");
        boolean formato24Horas = !scanner.nextBoolean();
        reloj.setMode24Hours(formato24Horas);
        System.out.println("Ingresa la hora, los minutos y los segundos (en ese orden):");
        int hora = scanner.nextInt();
        int minutos = scanner.nextInt();
        int segundos = scanner.nextInt();
        reloj.setHours(hora, minutos, segundos);
        System.out.println("La hora es:");
        reloj.showHour();
    }
}