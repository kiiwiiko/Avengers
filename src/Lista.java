import java.util.ArrayList;
import java.util.List;

public class Lista {

    private List<Avenger> avengers = new ArrayList<>();

    //Se inicializa la lista en el constructor
    public Lista() {
        avengers = new ArrayList<>();
    }

    //Se añade cada dato a la lista
    public void agregarAvengers(String nombre, String misionAsignada, int nivelPeligro, double pagoMensual) {
        avengers.add(new Avenger(nombre, misionAsignada, nivelPeligro, pagoMensual));
    }

    //Contructor String para que se vea mejor la lista en pantalla
    public String mostrarAvengers() {
        StringBuilder sb = new StringBuilder();
        for (Avenger avenger : avengers) {
            sb.append(avenger.toString());
        }
        return sb.toString();
    }

    //Busqueda binaria por el id
    public Avenger buscarId(int id) {
        Avenger resultado = null;

        //Aqui no agregamos el Collections porq se ordenan de manera automatica por id
        //por el compareTo

        if(avengers.isEmpty()) {
            return null;
        }

        int left = 0;
        int right = avengers.size() - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            Avenger a =  avengers.get(mid);
            if(a.getId() == id) {
                resultado = a;
            }
            if(a.getId() < id) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resultado;
    }

    //Cambiamos cada parametro del avenger buscado
    public Avenger modificarDatos(Avenger a, String misionAsignada, int nivelPeligro, double pagoMensual) {
        a.setMisionAsignada(misionAsignada);
        a.setNivelPeligro(nivelPeligro);
        a.setPagoMensual(pagoMensual);
        a.setImpuestoGobierno(pagoMensual);
        a.setAporteFondoHeroes(pagoMensual);
        a.setPagoNetoRecibe(pagoMensual, a.getImpuestoGobierno(), a.getAporteFondoHeroes());
        return a;
    }




}
