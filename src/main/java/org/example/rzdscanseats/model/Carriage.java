package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "rzd", name = "carriages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "seats")
@Builder
public class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private int countSeats;

    @Enumerated(EnumType.STRING)
    private CarriageType type;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CARRIAGE_TRAIN"))
    private Train train;

    @Builder.Default
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "carriage", cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();
}
