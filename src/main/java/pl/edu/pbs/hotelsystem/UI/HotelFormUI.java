package pl.edu.pbs.hotelsystem.UI;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pbs.hotelsystem.Dto.Room;
import pl.edu.pbs.hotelsystem.Repository.ReveservationRepository;
import pl.edu.pbs.hotelsystem.Repository.RoomRepository;
import pl.edu.pbs.hotelsystem.Repository.UserRepository;

@Route("/form")
public class HotelFormUI extends VerticalLayout {
    @Autowired
    ReveservationRepository reservationRepo;
    @Autowired
    RoomRepository roomRepo;
    @Autowired
    UserRepository userRepo;

    public HotelFormUI() {
        FormLayout layoutWithFormItems = new FormLayout();


        NumberField numberOfPesons = new NumberField();
        NumberField priceRoom_mniejsza = new NumberField();
        NumberField priceRoom_wieksza = new NumberField();
        DatePicker datePickerDateOfArrival = new DatePicker();
        DatePicker datePickerDepartureDate = new DatePicker();
        Button searchDate = new Button("Search");
        layoutWithFormItems.addFormItem(numberOfPesons, "Number of person name");
        layoutWithFormItems.addFormItem(priceRoom_mniejsza, "Price for day from-mniejsza");
        layoutWithFormItems.addFormItem(priceRoom_wieksza, "Price for day to-wieszka");
        layoutWithFormItems.addFormItem(datePickerDateOfArrival, "Date of Arrival");
        layoutWithFormItems.addFormItem(datePickerDepartureDate, "Departure Date");
        layoutWithFormItems.addFormItem(searchDate, "");
        Grid<Room> roomGrid = new Grid<>(Room.class, false);
        roomGrid.addColumn(Room::getId).setHeader("lp");
        roomGrid.addColumn(Room::getCapacity).setHeader("Capacity");
        roomGrid.addColumn(Room::getRatePerDay).setHeader("RatePerDay");

        searchDate.addClickListener(event -> {
            roomGrid.setItems(roomRepo.findAll().stream().filter(room -> reservationRepo.findByRoom(room).stream()
                            .allMatch(reservation -> datePickerDateOfArrival.getValue().isAfter(reservation.getDateOfArrival()) ||
                                    datePickerDepartureDate.getValue().isAfter(reservation.getDepartureDate())))
                    .filter(room -> room.getRatePerDay() >= priceRoom_mniejsza.getValue() && room.getRatePerDay() <= priceRoom_wieksza.getValue())
                    .filter(room -> numberOfPesons.getValue() <= room.getCapacity()));
        });
        add(layoutWithFormItems, roomGrid);
    }


}
