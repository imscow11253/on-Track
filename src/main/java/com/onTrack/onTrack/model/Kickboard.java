package com.onTrack.onTrack.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kickboard")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kickboard {
    @Id
    @Column(name = "kickboard_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kickboardId;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "battery", nullable = false)
    private Integer battery;


}
