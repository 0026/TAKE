package lab.booking.repositories;

import lab.booking.models.Booking;
import org.springframework.data.repository.CrudRepository;


public interface BookingRepository extends CrudRepository<Booking, Long> {


}