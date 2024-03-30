package com.onTrack.onTrack.repository;

import com.onTrack.onTrack.model.Kickboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KickboardRepository extends JpaRepository<Kickboard, Long> {
    Kickboard findByKickboardId(Long id);

    List<Kickboard> findAllByLatitudeBetweenAndLongitudeBetween(double minLatitude, double maxLatitude, double minLongitude, double maxLongitude);
}
