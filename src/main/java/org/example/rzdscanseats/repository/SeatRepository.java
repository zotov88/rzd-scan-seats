package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
