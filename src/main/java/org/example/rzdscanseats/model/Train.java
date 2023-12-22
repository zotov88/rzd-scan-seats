package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "rzd", name = "trains")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "carriages")
@Builder
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Carriage> carriages = new ArrayList<>();

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public void setRoute(Route route) {
        route.setTrain(this);
        this.route = route;
    }
}
