package Ejercicios.EJ7;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej7 {
    static String[] materias;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String entrada = "Nombre_Alumno# LMSXI # SI # BD # PRO # CD # FOL;Alumno 1  # 4     #    # 5  #  2  # 8  # 9;Alumno 2     # 5     # 3  # 6  #  7  # 10 # 6;Alumno 3     # 7     # 4  # 9  #  9  # 9  # 8;";
        ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();

        String[] filas = entrada.split(";");

        String[] materias_split = filas[0].split("#");

        materias = new String[materias_split.length -1];

        for (int i= 1; i < materias.length; i++) {
            materias[i] = materias_split[i+1].strip();
        }

        for (int i=1; i< filas.length; i++) {
            listaAlumnos.add(new Alumno(filas[i].split("#"), materias.length));
        }

        int opcion = -1;

        do {
            try {
                System.out.println("Seleccione una opción.");
                pintarMenu();
                opcion = teclado.nextInt();
            }catch (Exception e) {
                opcion = -1;
            }



            switch (opcion) {
                case 1:
                    for (Alumno alumno: listaAlumnos)
                        System.out.println(alumno.getNombre() + ": " + alumno.getNotaMedia());
                    break;
                case 2:
                    notaMediaModulo(listaAlumnos);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("Opción no válida");
                    pintarMenu();
                    return;
            }

        }while (opcion !=7);

    }

    //Calcularla nota de media
    private static double[] notaMediaModulo(ArrayList<Alumno> alumnos) {
        double[] medias = new double[materias.length];

        for (int i=0; i< materias.length; i++) {
            int media = 0;
            int cuenta = 0;

            for (Alumno alumno: alumnos) {
                int nota = alumno.getMaterias(i);
                if (nota >= 0) {
                    media+= nota;
                    cuenta++;
                }
            }

            medias[i] = media / cuenta;
            System.out.println("El módulo: " + materias[i] +  " tieneuna nota media " + medias[i]);
        }
        return medias;
    }

    private static void alumnoMejorNotaPorModulo(ArrayList<Alumno> alumnos) {
        for (int i= 0; i<materias.length; i++) {
            int notasMasAlta = 0;
            String nombreAlumno = "";

            for (Alumno alumno: alumnos) {
                int nota = alumno.getMaterias(i);

                if (nota > notasMasAlta) {
                    
                }
            }
        }
    }

    //Calcula notaMediaMásAlta del alumno
    public static void notaMediaMasAlta(ArrayList<Alumno> alumnos) {
        double mediaMasAlta = 0.0;
        String materiaNotaMasAlta = "";

        double[] notasMedias = notaMediaModulo(alumnos);

        for (int i = 0; i<notasMedias.length; i++) {
            if(notasMedias[i] > mediaMasAlta) {
                mediaMasAlta = notasMedias[i];
                materiaNotaMasAlta = materias[i];
            }
        }
        System.out.println("La materia con la nota media más alta es: " + materiaNotaMasAlta + " con un: " + mediaMasAlta);
    }

    //Ménu Opciones
    private static void pintarMenu() {
        System.out.println("1. Calcular la nota media de cada alumno en el ciclo, teniendo en cuenta solo aquellos módulos que han cursado: ");
        System.out.println("2. Calcular la nota media de cada módulo, teniendo en cuenta solo aquellos alumnos que cursaron el módulo: ");
        System.out.println("3. Calcular el número de alumnos que aprobaron todos los módulos que han cursado: ");
        System.out.println("4. Calcular el número de alumnos que no han cursado algún módulo.");
        System.out.println("5. Indicar cuál es el módulo que tiene la nota media más alta: ");
        System.out.println("6. Indicar cuál es el alumno que mejor nota ha sacado por módulo.");
        System.out.println("7. Salir.");
    }
}
