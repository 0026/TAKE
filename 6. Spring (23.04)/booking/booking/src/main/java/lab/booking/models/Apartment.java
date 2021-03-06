package lab.booking.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Min(value = 1, message = "Value must be a positive integer")
    private int capacity;

    @OneToMany(mappedBy = "apartment")
    private List<Booking> bookings;
    // getters & setters
}
