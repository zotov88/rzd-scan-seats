package org.example.rzdscanseats.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rzdscanseats.enums.SeatType;

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

    @Enumerated(EnumType.STRING)
    private SeatType type;

    @ManyToOne
    @JoinColumn(name = "carriage_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SEAT_CARRIAGE"))
    private Carriage carriage;
}
