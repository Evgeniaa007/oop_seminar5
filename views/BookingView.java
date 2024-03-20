package seminar5.views;

import seminar5.models.Reservation;
import seminar5.models.Table;
import seminar5.presenters.View;
import seminar5.presenters.ViewObserver;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Представление
 */
public class BookingView implements View {

    /**
     * Хранит в себе коллекцию наблюдателей
     */
    private Collection<ViewObserver> observers;
    
    /**
     * Отображение списка столиков в приложении
     */
    @Override
    public void showTables(Collection<Table> tables){
        for(Table table : tables){
            System.out.println(table);
        }
    }

    /**
     * Отображение списка столиков в приложении после изменения бронирования
     */
    @Override
    public void showTablesRemove(Collection<Table> tables){
        for(Table table : tables){
            for (Reservation reservation : table.getReservations()) {
                System.out.println(reservation);
            }
        }
    }

    /**
     * Действие клиента (пользователь нажал на кнопку бронирования), бронирование столика
     */
    @Override
    public void reservationTable(Date orderDate, int tableNo, String name){
        if (observers != null){ // Если существует хотя бы один наблюдатель
            for (ViewObserver observer : observers) { // Пройдем по всем наблюдателям
                observer.onReservationTable(orderDate, tableNo, name); // "Эмулируем" (Возбуждаем) событие бронирования столика
            }
        }
    }

    /**
     * Регистрация наблюдателя
     */
    @Override
    public void registerObserver(ViewObserver observer) { //Добавление нового наблюдателя
        if (observers == null){
            observers = new ArrayList<>();
        }
        observers.add(observer);
    }

    /**
     * Отобразить результат бронирования столика
     */
    @Override
    public void showReservationResult(int reservationNo) {
        if (reservationNo > 0){
            System.out.printf("Столик успешно забронирован. Номер брони: #%d\n", reservationNo);
        }
        else {
            System.out.printf("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }
    }

    /**
     * Изменение бронирования (пользователь нажал на кнопку изменения резерва) (смена номера столика или имени)
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){ 
        if (observers != null){ // Если существует хотя бы один наблюдатель
            for (ViewObserver observer : observers) { // Пройдем по всем наблюдателям
                observer.onChangeReservationTable(oldReservation, reservationDate, tableNo, name); // "Эмулируем" (Возбуждаем) событие изменения бронирования столика
            }
        }
    }

    /**
     * Отобразить результат изменения бронирования
     */
    @Override
    public void showChangeReservationResult(int ChangeReservationNo, int newTableNo, String name) {
        if (ChangeReservationNo > 0){
            System.out.printf("Изменение брони по номеру № #%d прошло успешно. Ваш новый номер столика: #%d, имя: %s\n", ChangeReservationNo, newTableNo, name);
        }
        else {
            System.out.printf("Произошла ошибка при попытке забронировать столик.\nПовторите операцию позже.");
        }
    }
}
