package seminar5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

/**
 * Модель стола
 */
public class Table {
    private static int counter; // Идентификатор столика

    private int no; // Номер столика

    private Collection<Reservation> reservations = new ArrayList<>(); // Коллекция бронирований стола

    public int getNo() {
        return no;
    }

    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public Table(){
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
    
}
