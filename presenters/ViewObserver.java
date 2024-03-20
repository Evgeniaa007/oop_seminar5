package seminar5.presenters;

import java.util.Date;

/**
 * Интерфейс наблюдателя за представлением
*/
public interface ViewObserver {

    /**
     * Произошло событие, пользователь нажал на кнопку резерва столика (Реакция на возбуждение события)
     * @param orderDate дата резерва
     * @param tableNo номер столика
     * @param name имя
     */
    void onReservationTable(Date orderDate, int tableNo, String name);
    
    /**
     * Произошло событие изменения бронирования
     * @param oldReservation предыдущий номер брони
     * @param reservationDate новая дата брони
     * @param tableNo новый номер столика
     * @param name имя
     */
    void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
}
