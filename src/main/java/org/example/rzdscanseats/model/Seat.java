package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(schema = "rzd", name = "seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer number;

    private Double price;

    @Enumerated(value = EnumType.STRING)
    private SeatType type;

    @ManyToOne
    @JoinColumn(name = "carriage_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SEAT_CARRIAGE"))
    private Carriage carriage;
}
