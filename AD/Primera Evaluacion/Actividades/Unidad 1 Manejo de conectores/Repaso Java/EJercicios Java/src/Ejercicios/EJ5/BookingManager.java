package Ejercicios.EJ5;

public class BookingManager {
    public static final int MAX_FRANJAS = 6;
    public static final int MIN_FRANJA = 1;

    private Piscina piscina;
    private String[][] reservasPorFranja;

    public BookingManager(Piscina piscina) {
        this.piscina = piscina;

        this.reservasPorFranja = new String[MAX_FRANJAS][piscina.getAforo()];
    }

    public boolean isDisponible(int franja) {
        for (String item: reservasPorFranja[franja -1]) {
            if (item == null)
                return true;
        }
        return false;
    }
}
