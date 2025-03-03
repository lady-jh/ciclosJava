import java.util.Scanner;
public class Operaciones {
    String titular;
    double saldo;
    int numeroCuenta;

    public Operaciones() {
    }

    public Operaciones(String titular, double saldo, int numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "Operaciones{" +
                "titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta=" + numeroCuenta +
                '}';
    }

    public void recibirDinero() {
        Scanner teclado=new Scanner(System.in);
        double cantidad;
        do {
            System.out.print("Ingrese la cantidad a consignar: ");
            cantidad=teclado.nextDouble();

            if (cantidad>0) {
                saldo=saldo+cantidad;
                System.out.println("Depósito correcto, su nuevo saldo es: "+saldo+"$");
            }else if(cantidad<=0) {
                System.out.println(cantidad+" no es un valor valido, ingrese una cantidad válida mayor a 0.");
            }
        }while(cantidad<=0);
    }

    public void retirarDinero() {
        Scanner teclado=new Scanner(System.in);
        double cantidad;
        do {
            System.out.print("Ingrese la cantidad a retirar: ");
            cantidad=teclado.nextDouble();

            if (cantidad>saldo) {
                System.out.println("No tiene suficiente saldo. Su saldo disponible es: $"+saldo);
                System.out.println("Intente nuevamente.");
            }else if(cantidad<=0) {
                System.out.println("Ingrese una cantidad válida mayor a 0.");
            }
        }while(cantidad>saldo || cantidad<=0);
        saldo=saldo-cantidad;
        System.out.println("Retiro exitoso. Su nuevo saldo es: $" + saldo);
    }

    public void mostrarInfo() {
        System.out.println("\n---- Información de la Cuenta ----");
        System.out.println("Titular: "+titular);
        System.out.println("Número de Cuenta: "+numeroCuenta);
        System.out.println("Saldo Disponible: "+saldo+"$");
    }

}

