package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.model.Carriage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarriageRepository extends JpaRepository<Carriage, Long> {
}
