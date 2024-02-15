package org.example.rzdscanseats.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.rzdscanseats.enums.NotificatorType;

import java.time.LocalDate;

@Entity
@Table(schema = "rzd", name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "train")
@Builder
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityFrom;

    private String cityTo;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_ROUTE_USER"))
    private User user;

    @OneToOne(mappedBy = "route", cascade = CascadeType.ALL)
    private Train train;

    @Enumerated(value = EnumType.STRING)
    private NotificatorType notificatorType;
}
