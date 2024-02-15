package org.example.rzdscanseats.repository;

import org.example.rzdscanseats.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {

    List<Route> getRoutesByUserId(Long id);

    @Query(nativeQuery = true,
            value = """
            select distinct user_id
            from rzd.routes
            """)
    List<Long> getDistinctByUserId();
}
