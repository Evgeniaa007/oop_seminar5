package seminar5.presenters;

import java.util.Date;

/**
 * Класс взаимодействия модели с представлениями
 */
public class BookingPresenter implements ViewObserver{

    private Model model;
    private View view;
    
    public BookingPresenter(Model model, View view){
        this.model = model;
        this.view = view;
        view.registerObserver(this);
    }

    /**
     * Отобразить список столиков(на представлении)
     */
    public void updateTablesView(){
        view.showTables(model.loadTables());
    }

    /**
     * Отобразить список столиков(на представлении) после изменения бронирования
     */
    public void updateRemove(){
        view.showTablesRemove(model.loadTables());
    }

    /**
     * Метод обновления результата бронирования столика
     * @param reservationNo Номер бронирования
     */
    private void updateReservationTableView(int reservationNo){
        view.showReservationResult(reservationNo);
    }

    /**
     * Метод обновления результата бронирования после изменения бронирования
     */
    private void updateChangeReservationTableView(int ChangeReservationNo, int newTableNo, String name){ 
        view.showChangeReservationResult(ChangeReservationNo, newTableNo, name);
    } 

    /**
     * // Получение номера бронирования
     */
    @Override
    public void onReservationTable(Date orderDate, int tableNo, String name) {
        try {
            int reservationNo = model.reservationTable(orderDate, tableNo, name);
            updateReservationTableView(reservationNo);
        } catch (Exception e) {
            updateReservationTableView(-1);
        }
    }

    /**
     * Получение номера бронирования после изменения бронирования
     */
    @Override
    public void onChangeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        try {
            int ChangeReservationNo = model.changeReservationTable(oldReservation, reservationDate, tableNo, name); 
            updateChangeReservationTableView(ChangeReservationNo, tableNo, name);
        } catch (Exception e) {
            updateChangeReservationTableView(-1, -1, "");
        }
    }
}
