package seminar5;

import java.util.Date;
import seminar5.models.*;
import seminar5.presenters.*;
import seminar5.views.BookingView;

public class Program {
    
    public static void main(String[] args) {
        Model model = new TableService();
        View view = new BookingView();
        BookingPresenter presenter = new BookingPresenter(model, view);
        presenter.updateTablesView();

        view.reservationTable(new Date(), 4, "Станислав");
        view.reservationTable(new Date(), 5, "Маша");
        view.reservationTable(new Date(), 1, "Оля");
        view.reservationTable(new Date(), 2, "Кирилл");
        view.reservationTable(new Date(), 2, "Олег");
        view.changeReservationTable(1001, new Date(), 2, "Марина");
        view.changeReservationTable(1003, new Date(), 5, "Оля");
        System.out.println("********");
        presenter.updateRemove();
       
    }
}