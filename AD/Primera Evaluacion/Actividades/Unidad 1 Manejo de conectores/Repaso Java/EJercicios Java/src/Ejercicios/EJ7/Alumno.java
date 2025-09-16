package Ejercicios.EJ7;

import java.util.Arrays;

public class Alumno {

    private int materias[];
    private String nombre;
    private double media = 0;
    private int modulosCursados = 0;
    private boolean aprobadoTodo = true;

    public Alumno(String[] fila, int longitud) {
        this.materias = new int[longitud];
        this.nombre = fila[0];

        for (int i = 1; i<fila.length; i++) {
            try {
                this.materias[i-1] = Integer.parseInt(fila[i].strip());

                if (this.materias[i-1] <5)
                    this.aprobadoTodo = false;

                this.media +=this.materias[i-1];
                this.modulosCursados++;
            }catch (Exception e) {
                this.materias[i -1] = -1;
            }
        }
        this.media = this.media /this.modulosCursados;
    }

    public int getMaterias(int pos) {
        return this.materias[pos];
    }


    public String getNombre() {
        return nombre;
    }


    public double getNotaMedia() {
        return media;
    }


    public int getModulosCursados() {
        return modulosCursados;
    }

    public void setModulosCursados(int modulosCursados) {
        this.modulosCursados = modulosCursados;
    }

    public boolean isAprobadoTodo() {
        return aprobadoTodo;
    }

    public void setAprobadoTodo(boolean aprobadoTodo) {
        this.aprobadoTodo = aprobadoTodo;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "materias=" + Arrays.toString(materias) +
                ", nombre='" + nombre + '\'' +
                ", media=" + media +
                ", modulosCursados=" + modulosCursados +
                ", aprobadoTodo=" + aprobadoTodo +
                '}';
    }
}
