import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lista {

    private List<Avenger> avengers = new ArrayList<>();

    public Lista() {
        avengers = new ArrayList<>();
    }

    public List<Avenger> getAvengers() {
        return avengers;
    }

    public void setAvengers(int id, String nombre, String misionAsignada, int nivelPeligro, double pagoMensual) {
        avengers.add(new Avenger(id, nombre, misionAsignada, nivelPeligro, pagoMensual));
        Collections.sort(avengers);
    }

    public Avenger buscarId(List<Avenger> avengers, int id) {
        Avenger resultado = null;

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

    public Avenger modificarDatos(Avenger avenger, String misionAsignada, int nivelPeligro, double pagoMensual) {
        avenger.setMisionAsignada(misionAsignada);
        avenger.setNivelPeligro(nivelPeligro);
        avenger.setPagoMensual(pagoMensual);
        avenger.setImpuestoGobierno(pagoMensual);
        avenger.setImpuestoGobierno(pagoMensual);
        avenger.setAporteFondoHeroes(pagoMensual);
        return avenger;
    }




}
