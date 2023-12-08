package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(schema = "rzd", name = "routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

//    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne(mappedBy = "route")
    private Train train;
}
