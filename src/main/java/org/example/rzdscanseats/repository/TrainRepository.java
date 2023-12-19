package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
}
