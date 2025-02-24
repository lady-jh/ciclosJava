import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int mon20 = 0, mon50 = 0, mon100 = 0, mon200 = 0, mon500 = 0;
        int suma = mon20 * 20 + mon50 * 50 + mon100 * 100 + mon200 * 200 + mon500 * 500;

    do{
            System.out.println("1.Agregar una moneda");
            System.out.println("2.Contar monedas por denominación");
            System.out.println("3.Calcular el total del dinero");
            System.out.println("4.Vaciar la alcancia");
            System.out.println("Digite la opción:");
        Scanner teclado = new Scanner(System.in);
        int opcionmenu = teclado.nextInt();

            switch (opcionmenu) {
                case 1 -> {
                    System.out.println("Puede agregar modenas de las siguientes denominaciones:");
                    System.out.println("1. 20$");
                    System.out.println("2. 50$");
                    System.out.println("3. 100$");
                    System.out.println("4. 200$");
                    System.out.println("5. 500$");
                    System.out.println("Digite la opción:");

                    Scanner tecladomoneda = new Scanner(System.in);
                    int opcionmoneda = teclado.nextInt();

                    switch (opcionmoneda) {
                        case 1 -> {
                            mon20 = mon20 + 1;
                        }
                        case 2 -> {
                            mon50 = mon50 + 1;
                        }
                        case 3 -> {
                            mon100 = mon100 + 1;
                        }
                        case 4 -> {
                            mon200 = mon200 + 1;
                        }
                        case 5 -> {
                            mon500 = mon500 + 1;
                        }
                        default -> {
                            System.out.println("No es una opción valida");
                            break;
                        }
                    }
                }

                        case 2 -> {
                            System.out.println("La monedas que tienes por denominacion son:");
                            System.out.println("Monedas de 20$: " + mon20);
                            System.out.println("Monedas de 50$: " + mon50);
                            System.out.println("Monedas de 100$: " + mon100);
                            System.out.println("Monedas de 200$: " + mon200);
                            System.out.println("Monedas de 500$: " + mon500);
                        }

                        case 3 -> {
                            System.out.println("El total del dinero es: " + suma + "$");
                        }

                        case 4 -> {
                            System.out.println("Vaciar la alcancia");
                            mon20 = 0;
                            mon50 = 0;
                            mon100 = 0;
                            mon200 = 0;
                            mon500 = 0;
                            System.out.println("El valor es " + suma + "$");
                        }
                    }
            }while(opcionmenu !=4);
}
}