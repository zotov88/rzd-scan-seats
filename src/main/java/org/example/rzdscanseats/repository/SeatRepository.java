package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
