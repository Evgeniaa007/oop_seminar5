package seminar5.models;

import java.util.Date;
/**
 * Объект бронирования стола
 */
public class Reservation {
    private static int counter = 1000; // Номер брони

    private int id;

    private Table table;

    private Date date;

    private String name;

    public Reservation(Table table, Date date, String name){

        id = ++counter;
        this.table = table;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s дата %s имя %s", table, date, name);
    }

}
