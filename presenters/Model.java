package seminar5.presenters;

import seminar5.models.Table;
import java.util.Collection;
import java.util.Date;

/**
 * Интерфейс взаимодействия с моделями
 */
public interface Model {
    
    /**
     * Создание столиков
     */
    Collection<Table> loadTables(); 

    /**
     * бронирование столиков
     * @param reservationDate дата брони
     * @param tableNo номер стола
     * @param name имя
     */
    int reservationTable(Date reservationDate, int tableNo, String name);

    /**
     * Изменение бронирования
     * @param oldReservation старый номер брони
     * @param reservationDate дата брони
     * @param tableNo номер стола
     * @param name имя
     */
    int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name); 

}
