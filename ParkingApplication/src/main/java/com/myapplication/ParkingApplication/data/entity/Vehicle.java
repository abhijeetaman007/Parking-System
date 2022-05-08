package com.myapplication.ParkingApplication.data.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {
    private String id;
    private VehicleType type;

}
