import javax.swing.*;

public class Avenger implements Comparable<Avenger>{
    private int id;
    private String nombre;
    private String misionAsignada;
    private int nivelPeligro;
    private double pagoMensual;
    private double aporteFondoHeroes;
    private double impuestoGobierno;

    //Constructor de cada Avenger
    public Avenger(int id, String nombre, String misionAsignada, int nivelPeligro, double pagoMensual) {
        this.id = id;
        this.nombre = nombre;
        this.misionAsignada = misionAsignada;
        this.nivelPeligro = nivelPeligro;
        this.pagoMensual = pagoMensual;
        this.aporteFondoHeroes = calcularFondo(pagoMensual);
        this.impuestoGobierno = calcularImpuesto(pagoMensual);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMisionAsignada() {
        return misionAsignada;
    }

    public void setMisionAsignada(String misionAsignada) {
        this.misionAsignada = misionAsignada;
    }

    public int getNivelPeligro() {
        return nivelPeligro;
    }

    public void setNivelPeligro(int nivelPeligro) {
        this.nivelPeligro = nivelPeligro;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double getAporteFondoHeroes() {
        return aporteFondoHeroes;
    }

    public void setAporteFondoHeroes(double pagoMensual) {
        this.aporteFondoHeroes = calcularFondo(pagoMensual);
    }

    public double getImpuestoGobierno() {
        return impuestoGobierno;
    }

    public void setImpuestoGobierno(double pagoMensual) {
        this.impuestoGobierno = calcularImpuesto(pagoMensual);
    }

    //Calcular pagomensual
    private double calcularImpuesto(double pagoMensual) {
        double resultado = 0;

        double pagoAnual = pagoMensual * 12;

        if (pagoAnual <= 50000) resultado = 0;
        else if (pagoAnual > 50000 && pagoAnual <= 100000) resultado = (pagoAnual - 50000) * 0.10;
        else if (pagoAnual > 100000 && pagoAnual <= 200000) resultado = 5000 + (pagoAnual - 100000) * 0.20;
        else if (pagoAnual > 200000) resultado = 2500 + (pagoAnual - 200000) * 0.30;

        return resultado;

    }

    //Calcular Fondo
    private double calcularFondo(double pagoMensual) {
        double resultado = 0;
        resultado = pagoMensual * 0.08;
        return resultado;
    }

    @Override
    public String toString() {
        return "  Avenger  " +
                "\nID: " + id +
                "\nNombre: " + nombre +
                "\nMisión Asignada: " + misionAsignada +
                "\nNivel Peligro: " + nivelPeligro +
                "\nPago Mensual: " + pagoMensual +
                "\nAporte Fondo Heroes: " + aporteFondoHeroes +
                "\nImpuesto Gobierno: " + impuestoGobierno +
                "\n\n";
    }

    //Se va a ordenar por id
    public int compareTo(Avenger o) {
        return Integer.compare(this.id, o.id);
    }
}
