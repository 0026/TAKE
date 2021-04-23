package lab.booking.controllers;

import lab.booking.models.Apartment;
import lab.booking.models.Booking;
import lab.booking.repositories.ApartmentRepository;
import lab.booking.repositories.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private BookingRepository bookingRepository;
    private ApartmentRepository apartmentRepository;
    public BookingController(BookingRepository bookingRepository,
                             ApartmentRepository apartmentRepository) {
        this.bookingRepository = bookingRepository;
        this.apartmentRepository = apartmentRepository;
    }
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute(new Booking());
        model.addAttribute("bookings", bookingRepository.findAll());
        return "bookings";
    }
    @PostMapping
    public String create(@Valid Booking booking, Errors errors,
                         Model model) {
        String view;
        if (errors.hasErrors()) {
            model.addAttribute("bookings",
                    bookingRepository.findAll());
            view = "bookings";
        } else {
            int numGuests = booking.getNumGuests();
            LocalDate startDay = booking.getFromDate();
            LocalDate endDay = booking.getToDate();
            List<Apartment> availableApartments =
                    apartmentRepository.getFreeApartments(numGuests, startDay, endDay);
            if(availableApartments.size() > 0) {
                booking.setApartment(availableApartments.get(0));
                bookingRepository.save(booking);
                view = "redirect:/bookings";
            } else {
                model.addAttribute("noApartmentAvailable", true);
                model.addAttribute("bookings",
                        bookingRepository.findAll());
                view = "bookings";
            }
        }
        return view;
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id){
        bookingRepository.deleteById(id.longValue());
        return "redirect:/bookings";
    }
}

