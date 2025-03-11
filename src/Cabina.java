import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Cabina {
    private int id;
    private int local;
    private int distancia;
    private double duracion;
    private int celular;
    private int costoLocal=50;
    private int costoDistancia=350;
    private int costoCelular=150;
    private double localD;
    private double distanciaD;
    private double celularD;
    Random random;
    Scanner teclado = new Scanner(System.in);

    public Cabina() {
        random=new Random();
    }

    public Cabina(int id, int local, int distancia, int celular, double localD, double distanciaD, double celularD) {
        this.id = id;
        this.local = local;
        this.distancia = distancia;
        this.celular = celular;
        this.localD = localD;
        this.distanciaD = distanciaD;
        this.celularD = celularD;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public double getCelularD() {
        return celularD;
    }

    public void setCelularD(double celularD) {
        this.celularD = celularD;
    }

    public double getDistanciaD() {
        return distanciaD;
    }

    public void setDistanciaD(double distanciaD) {
        this.distanciaD = distanciaD;
    }

    public double getLocalD() {
        return localD;
    }

    public void setLocalD(double localD) {
        this.localD = localD;
    }

    @Override
    public String toString() {
        return "| Cabina: "+id+" | llamadas local: "+local+" | llamadas a distancia: "+distancia+" | llamadas a celular: "+celular+" | duracion local: "+localD+" | duracion celular: "+celularD+" | duracion distancia: "+distanciaD+" |";
    }

    public void crearCabina(List<Cabina> listaCabinas){
        int id;
        Cabina existe=null;

        do {//BUSCAR CABINA
            System.out.print("Digite un numero identificador para la cabina:");
            id = teclado.nextInt();
            teclado.nextLine();
            for (Cabina buscar : listaCabinas) {
                if (buscar.getId()!=id) {
                    existe=buscar;
                    break;
                }
            }
            if (existe==null && id>0) {
                System.out.println("Esta cabina con id "+id+" ya existe, intente de nuevo.");;
            }
            if(id<=0){
                System.out.println("El id"+id+" no es valido, intente de nuevo con numeros mayores a 0.");;
            }
        }while(existe==null);
        //EXITO
        listaCabinas.add(new Cabina(id,0,0,0,0,0,0));
        System.out.println("\nCabina creada correctamente");
    }

    public void escogerCabina(List<Cabina> listaCabinas){
        int id;
        Cabina existe=null;

        do {//BUSCAR CABINA
            System.out.print("Digite un numero identificador para la cabina:");
            id = teclado.nextInt();
            teclado.nextLine();
            for (Cabina buscar : listaCabinas) {
                if (buscar.getId()==id) {
                    existe=buscar;
                    break;
                }
            }
            if (existe==null) {
                System.out.println("Esta cabina con id "+id+" no existe, intente de nuevo.");;
            }
            if(id<=0){
                System.out.println("El id"+id+" no es valido, intente de nuevo con numeros mayores a 0.");;
            }
        }while(existe==null);
        System.out.print("Ha escogido la cabina "+id);

        //REGISTRAR LLAMADA
        System.out.print("\n-------Registrar llamada-------");
        System.out.println("\n1. Llamada local\n2. Llamada larga distancia\n3. Llamada a celular");
        int llamada;

        System.out.print("Digite la opcion de llamada:");
        llamada=teclado.nextInt();

        if (llamada==1){
            double duracion = random.nextInt(10) + 1;
            existe.setLocalD(existe.getLocalD()+duracion);
            existe.setLocal(existe.getLocal()+1);
            System.out.print("Llamada exitosa, duracion:"+existe.getLocalD()+" minutos");
        } else if (llamada==2) {
            double duracion = random.nextInt(10) + 1;
            existe.setDistanciaD(existe.getDistanciaD()+duracion);
            existe.setDistancia(existe.getDistancia()+1);
            System.out.print("Llamada exitosa, duracion:"+existe.getDistanciaD()+" minutos");
        }else{
            double duracion = random.nextInt(10) + 1;
            existe.setCelularD(existe.getCelularD()+duracion);
            existe.setCelular(existe.getCelular()+1);
            System.out.print("Llamada exitosa, duracion:"+existe.getCelularD()+" minutos");
        }
    }

    public void infoCabina(List<Cabina> listaCabinas) {
        int id;
        Cabina existe = null;
        do {//BUSCAR CABINA
            System.out.print("Digite un numero identificador para la cabina:");
            id = teclado.nextInt();
            teclado.nextLine();
            for (Cabina buscar : listaCabinas) {
                if (buscar.getId() == id) {
                    existe = buscar;
                    break;
                }
            }
            if (existe==null) {
                System.out.println("Esta cabina con id" + id + " no existe, intente de nuevo.");
            }
            if (id<=0) {
                System.out.println("El id" + id + " no es valido, intente de nuevo con numeros mayores a 0.");
            }

        }while(existe==null);
        //EXITO
        int llamadasTotal=existe.getCelular()+existe.getDistancia()+existe.getLocal();
        double costoTotal=(existe.getCelular()*costoCelular)+(existe.getLocal()*costoLocal)+(existe.getDistancia()*costoDistancia);
        System.out.print("La información de la cabina "+id+" es:");
        System.out.print("\n| Llamadas realizadas | local:"+existe.getLocal()+" | distancia:"+existe.getDistancia()+" | celular:"+existe.getCelular()+" |");
        System.out.print("\n| Duración minutos | local:"+existe.getLocalD()+" | distancia:"+existe.getDistanciaD()+" | celular:"+existe.getCelularD()+" |");
        System.out.print("\n| Costo | local:"+(existe.getLocal()*costoTotal)+" | distancia:"+(existe.getDistancia()*costoDistancia)+" | celular:"+(existe.getCelular()*costoCelular)+" |");
    }

    public void infoTotal(List<Cabina> listaCabinas){;
        for(Cabina Cabina:listaCabinas) {
            System.out.print("\nLa información de la cabina "+Cabina.getId()+" es:");
            System.out.print("Llamadas realizadas: "+(Cabina.getLocal()+Cabina.getDistancia()+Cabina.getCelular()));
            System.out.print(", Duración minutos: "+(Cabina.getLocalD()+Cabina.getDistanciaD()+Cabina.getCelularD()));
            System.out.print(", Costo total: "+(Cabina.getLocal()*costoLocal+Cabina.getDistancia()*costoDistancia+Cabina.getCelular()*costoCelular));
        }
    }

    public void reiniciarCabina(List<Cabina> listaCabinas){
        int id;
        Cabina existe=null;

        do {//BUSCAR CABINA
            System.out.print("Digite un numero identificador para la cabina:");
            id = teclado.nextInt();
            teclado.nextLine();
            for (Cabina buscar : listaCabinas) {
                if (buscar.getId()==id) {
                    existe=buscar;
                    break;
                }
            }
            if (existe==null) {
                System.out.println("Esta cabina con id"+id+" no existe, intente de nuevo.");
            }
            if(id<=0){
                System.out.println("El id"+id+" no es valido, intente de nuevo con numeros mayores a 0.");
            }
        }while(existe==null);
        //EXITO
        listaCabinas.add(new Cabina(id,0,0,0,0,0,0));
        System.out.println("Cabina reiniciada correctamente");;

    }
}
