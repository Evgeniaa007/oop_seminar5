package seminar5.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import seminar5.presenters.Model;

/**
 * Класс взаимодейсвтия со столами
 * Создание столов
 */
public class TableService implements Model{

    private Collection<Table> tables;

    @Override
    public Collection<Table> loadTables() {
        if (tables == null){
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        
        }

        return tables;
    }

    /**
     * Бронирование столов
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) { //Результат бронирования столика
        for (Table table : tables) { // Проходим по всем столикам
            if (table.getNo() == tableNo){ // Нахождение нужного столика по номеру
                Reservation reservation = new Reservation(table, reservationDate, name); // Создание объекта бронирования
                table.getReservations().add(reservation); // Добавление бронирования в список бронирования
                return reservation.getId(); // Возвращение номера брони
            }          
        }
        throw new RuntimeException("Некорректный номер столика");
    }

    /**
     * Результат изменения бронирования
     */
    @Override
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) { 
        Reservation newReservation = null;
        for (Table table : tables) { // Проходим по всем столикам
            for (Reservation reservation : table.getReservations()) { // Проходим по циклу резервов
                if (reservation.getId() == oldReservation){ // Если номер брони совпадает
                    newReservation = reservation;
                    //table.getReservations().remove(reservation); // Удаление брони
                }
            }
            table.getReservations().removeIf(id -> id.getId() == oldReservation);
        }
        for (Table table : tables){  
            if (table.getNo() == tableNo){
                newReservation.setTable(table); // Устанавливаю новый столик в списке резервов
                newReservation.setName(name); // Устанавливаю новое имя в списке резервов
                table.getReservations().add(newReservation);
                return newReservation.getId(); // Возвращение номера брони
            }     
        }            
        throw new RuntimeException("Некорректный номер столика");
    }

}
