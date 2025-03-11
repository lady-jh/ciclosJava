import java.util.Scanner;
import java.util.List;

public class Producto {
    private String nombre;
    private double precio;
    private int stock;
    Scanner teclado = new Scanner(System.in);

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "| nombre:"+nombre+" | precio:"+precio+" | stock:"+stock+" |";
    }

    public void crearProducto(List<Producto>listaProductos){
        String nombre;
        double precio;
        int stock;
        //NOMBRE
        System.out.print("Digite el nombre:");
        nombre = teclado.nextLine();
        do {//PRECIO
            System.out.print("Digite el precio:");
            precio = teclado.nextDouble();
            teclado.nextLine();
            if(precio<=0){
                System.out.println("El precio "+precio+" no es valido, debe ser mayor a 0$");
            }else{
                do {//STOCK
                    System.out.print("Digite el stock:");
                    stock = teclado.nextInt();
                    teclado.nextLine();
                    if(stock<=0){
                        System.out.println("El stock "+stock+" no es valido, debe ser mayor a 0$");
                    }else{//EXITO
                        listaProductos.add(new Producto(nombre,precio,stock));
                        System.out.println("\nProducto creado correctamente");
                    }
                }while(stock<=0);
            }
        }while(precio<=0);
    }

    public void venderProducto(List<Producto> listaProductos) {
        String nombre;
        int descuento;
        int cantidad;
        Producto existe = null;

        do {//BUSCAR EL PRODUCTO
            System.out.print("\nDigite el nombre del producto:");
            nombre = teclado.nextLine();
            for (Producto buscado : listaProductos) {
                if (buscado.getNombre().equals(nombre)) {
                    existe = buscado;
                    break;
                }
            }
            if (existe == null) {
                System.out.println("El producto "+nombre+" no existe, intente de nuevo.");
            }
        }while(existe==null);

        int stockInicial = existe.getStock();
        do {//CANTIDAD A VENDER
            System.out.print("Digite la cantidad a vender:");
            cantidad = teclado.nextInt();
            teclado.nextLine();
            if (cantidad <= 0) {
                System.out.println("La cantidad " + cantidad + " no es válida, debe ser mayor a 0.");
            } else if (cantidad > stockInicial) {
                System.out.println("No hay suficiente stock, el valor debe ser menor a " + stockInicial);
            }
        } while (cantidad <= 0 || cantidad > stockInicial);

        do {//APLICAR DESCUENTO
            System.out.print("\nDigite 1 para aplicar descuento o 2 para no aplicarlo:");
            descuento = teclado.nextInt();
            teclado.nextLine();
            if (descuento == 1) {
                double total = existe.getPrecio()-existe.aplicarDescuento();
                existe.setStock(existe.getStock()-cantidad);
                System.out.println("Se aplicó el descuento, precio final: " + total + "$");
            } else if (descuento == 2) {
                existe.setStock(existe.getStock()-cantidad);
                System.out.println("No se aplicó el descuento, precio " + existe.getPrecio());
            } else {
                System.out.println("Opción no válida, digite 1 o 2.");
            }
        } while (descuento != 1 && descuento != 2);
        System.out.println("Venta exitosa, nuevo stock: " + existe.getStock());
    }

    public void reponerStock(List<Producto> listaProductos){
        String nombre;
        int cantidad;
        Producto existe = null;

        do {//BUSCAR EL PRODUCTO
            System.out.print("\nDigite el nombre del producto:");
            nombre = teclado.nextLine();
            for (Producto buscado : listaProductos) {
                if (buscado.getNombre().equals(nombre)) {
                    existe = buscado;
                    break;
                }
            }
            if (existe == null) {
                System.out.println("El producto "+nombre+" no existe, intente de nuevo.");
            }
        }while(existe==null);

        int stockInicial = existe.getStock();
        do {//CANTIDAD A SUMAR
            System.out.print("Digite la cantidad a agregar:");
            cantidad = teclado.nextInt();
            teclado.nextLine();
            if (cantidad <= 0) {
                System.out.println("La cantidad " + cantidad + " no es válida, debe ser mayor a 0.");
            } else {
                existe.setStock(existe.getStock()+cantidad);

                System.out.println("Stock actualizado correctamente, pasó de "+stockInicial+" a "+existe.getStock()+" unidades.");
            }
        } while (cantidad <= 0);
    }

    public double aplicarDescuento(){
        double descuento=precio*0.02;
        return descuento;
    }

    public void mostrarInformacion(List<Producto>listaProductos){
        for(Producto producto:listaProductos) {
            System.out.println(producto);
        }
    }

    public void aumentarPrecio(List<Producto>listaProductos){
        String nombre;
        double cantidad;
        Producto existe = null;

        do {//BUSCAR EL PRODUCTO
            System.out.print("\nDigite el nombre del producto:");
            nombre = teclado.nextLine();
            for (Producto buscado : listaProductos) {
                if (buscado.getNombre().equals(nombre)) {
                    existe = buscado;
                    break;
                }
            }
            if (existe == null) {
                System.out.println("El producto "+nombre+" no existe, intente de nuevo.");
            }
        }while(existe==null);

        double precioInicial = existe.getPrecio();
        do {//PRECIO NUEVO
            System.out.print("Digite el porcentaje a aumentar:");
            cantidad = teclado.nextDouble();
            teclado.nextLine();
            if (cantidad <= 0) {
                System.out.println("El precio " + cantidad + " no es válido, debe ser mayor a 0.");
            } else {
                double aumento = (precioInicial * cantidad) / 100;
                existe.setPrecio(precioInicial + aumento);
                System.out.println("Precio actualizado correctamente, pasó de "+precioInicial+"$ a "+existe.getPrecio()+"$.");
            }
        } while (cantidad <= 0);
    }

    public void valorInventario(List<Producto>listaProductos){
        String nombre;
        Producto existe = null;

        do {//BUSCAR EL PRODUCTO
            System.out.print("\nDigite el nombre del producto:");
            nombre = teclado.nextLine();
            for (Producto buscado : listaProductos) {
                if (buscado.getNombre().equals(nombre)) {
                    existe = buscado;
                    break;
                }
            }
            if (existe == null) {
                System.out.println("El producto "+nombre+" no existe, intente de nuevo.");
            }
        }while(existe==null);

        double total=existe.getPrecio()*existe.getStock();
        System.out.print("El valor en inventario de "+existe.getNombre()+" es "+total+"$");

        double totalTodo=0;
        for (Producto buscado : listaProductos) {
            totalTodo += buscado.getPrecio() * buscado.getStock();
        }
        System.out.print("\nEl valor de todo el inventario es "+totalTodo+"$");
    }

    public void compararPrecios(List<Producto>listaProductos){
        String nombre1,nombre2;
        Producto pro1=null,pro2=null;

        do {//BUSCAR EL PRODUCTO 1
            System.out.print("\nDigite el nombre del primer producto:");
            nombre1 = teclado.nextLine();
            for (Producto buscado1 : listaProductos) {
                if (buscado1.getNombre().equals(nombre1)) {
                    pro1 = buscado1;
                    break;
                }
            }
            if (pro1 == null) {
                System.out.println("El producto "+nombre1+" no existe, intente de nuevo.");
            }
        }while(pro1==null);

        do {//BUSCAR EL PRODUCTO 2
            System.out.print("\nDigite el nombre del segundo producto:");
            nombre2 = teclado.nextLine();
            for (Producto buscado2 : listaProductos) {
                if (buscado2.getNombre().equals(nombre2)) {
                    pro2 = buscado2;
                    break;
                }
            }
            if (pro2 == null) {
                System.out.println("El producto "+nombre2+" no existe, intente de nuevo.");
            }
        }while(pro2==null);

        //COMPARAR PRECIOS
        System.out.println(pro1.getNombre()+ " cuesta " + pro1.getPrecio());
        System.out.println(pro2.getNombre()+ " cuesta " + pro2.getPrecio());
        if (pro1.getPrecio() > pro2.getPrecio()) {
            System.out.println(pro1.getNombre() + " es más caro que " + pro2.getNombre());
        } else if (pro1.getPrecio() < pro2.getPrecio()) {
            System.out.println(pro2.getNombre() + " es más caro que " + pro1.getNombre());
        } else {
            System.out.println("Ambos productos tienen el mismo precio.");
        }
    }
}

