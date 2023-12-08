package org.example.rzdscanseats.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "rzd", name = "trains")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Builder.Default
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "train")
    private List<Carriage> carriages = new ArrayList<>();

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToOne
    @JoinColumn(name = "route_id")
    private Route route;

    public void setRoutes(Route route) {
        route.setTrain(this);
        this.route = route;
    }

}
