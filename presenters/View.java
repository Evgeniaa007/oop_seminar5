package seminar5.presenters;

import java.util.Collection;
import java.util.Date;
import seminar5.models.Table;

/**
 * Интерфейс взаимодействия с представлением
 */
public interface View {
    
    /**
     * Отображение списка столиков в приложении
     * @param tables список столов
     */
    void showTables(Collection<Table> tables);


    /**
     * Регистрация наблюдателя
     * @param observer наблюдатель
     */
    void registerObserver (ViewObserver observer);

    /**
     * Отобразить результат бронирования столика
     * @param reservationNo номер брони
     */
    void showReservationResult(int reservationNo); 

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     * @param orderDate дата бронирования
     * @param tableNo номер столика
     * @param name имя
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Отобразить результат изменения бронирования столика
     * @param ChangeReservationNo номер брони
     * @param newTableNo новый номер столика
     */
    void showChangeReservationResult(int ChangeReservationNo, int newTableNo, String name);

    /**
     * Изменение бронирования (пользователь нажал на кнопку изменения резерва) (смена номера столика или имени)
     */
    void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name);
    
    /**
     * Отображение списка столиков в приложении после изменения бронирования
     * @param tables список столов
     */
    void showTablesRemove(Collection<Table> tables);

}
