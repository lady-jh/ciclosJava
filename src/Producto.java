import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Producto {
    private static List<Producto> productos = new ArrayList<>();
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {
    }

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    public static void crearProducto(){
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = teclado.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = teclado.nextDouble();
        System.out.print("Ingrese la cantidad en stock: ");
        int stock = teclado.nextInt();

        productos.add(new Producto(nombre, precio, stock));
    }

    public static void venderProducto(){
        Scanner scanner = new Scanner(System.in);
        int cantidad;
        System.out.print("Ingrese el nombre del producto a vender: ");
        String nombre = scanner.nextLine();

        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)) {
                do {
                    System.out.print("Ingrese la cantidad a vender: ");
                    cantidad = scanner.nextInt();

                    if (cantidad > p.getStock()) {
                        System.out.println("No hay suficiente stock para vender " + cantidad + " unidades.");
                    } else {
                        p.aplicarDescuento();
                        p.setStock(p.getStock() - cantidad);
                        System.out.println("Venta realizada con éxito. Nuevo stock: " + p.getStock());
                        return;
                    }
                } while (cantidad < 0 || cantidad > p.getStock());
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public static void reponerStock(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a reponer: ");
        String nombre = scanner.nextLine();
        int cantidad;

        do {
            System.out.print("Ingrese la cantidad a añadir: ");
            cantidad = scanner.nextInt();
            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor a 0. Intente de nuevo.");
            }
        } while (cantidad <= 0);

        for (Producto p : productos) {
            if (p.getNombre().equals(nombre)) {
                p.setStock(p.getStock() + cantidad);
                System.out.println("Stock actualizado. Nueva cantidad en stock: " + p.getStock());
                return;
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void aplicarDescuento(){
        double descuento = precio * 0.02;
        System.out.println("Se aplico un descuento del 2%, el precio fue: $" + (precio-descuento));
    }

    public static void mostrarInfo(){
        for(Producto lista:productos){
            System.out.println(lista);
        }
    }

    public static void aumentarPrecio(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a aumentar precio: ");
        String nombreProducto = scanner.nextLine().toLowerCase();

        Producto productoEncontrado = null;
        for (Producto p : productos) {
            if (p.nombre.equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = p;
                break;
            }
        }

        if (productoEncontrado != null) {
            double porcentaje;
            do {
                System.out.print("Ingrese el porcentaje de aumento: ");
                porcentaje = scanner.nextDouble();

                if (porcentaje <= 0) {
                    System.out.println("El porcentaje debe ser mayor a 0. Intente de nuevo.");
                }
            } while (porcentaje <= 0);

            double incremento = productoEncontrado.precio * (porcentaje / 100);
            productoEncontrado.precio += incremento;

            System.out.println("El nuevo precio de " + productoEncontrado.nombre + " es: $" + productoEncontrado.precio);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public double calcularValorInventario() {
        return this.precio * this.stock;
    }

    public static double valorTInventario(){
        double total = 0;
        for (Producto p : productos) {
            total += p.calcularValorInventario();
        }
        return total;
    }

    public static void compararPrecios(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el nombre del nuevo producto a comparar: ");
        String nombreNuevoProducto = scanner.nextLine();
        System.out.print("Ingrese el precio del nuevo producto: ");
        double precioNuevoProducto = scanner.nextDouble();
        scanner.nextLine();

        Producto productoEnLista = null;
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombreNuevoProducto)) {
                productoEnLista = p;
                break;
            }
        }

        if (precioNuevoProducto > productoEnLista.getPrecio()) {
            System.out.println("El producto nuevo " + nombreNuevoProducto + " es más caro: $" + precioNuevoProducto);
        } else if (precioNuevoProducto < productoEnLista.getPrecio()) {
            System.out.println("El producto en la tienda " + productoEnLista.getNombre() + " es más caro: $" + productoEnLista.getPrecio());
        } else {
            System.out.println("Ambos productos tienen el mismo precio.");
        }
    }
}
