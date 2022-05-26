package com.myapplication.ParkingApplication.data.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity(name = "Vehicle")
@Table(name = "vehicle")
public class Vehicle {

    @Id
    private String vehicleId; //Primary Key
    @Enumerated(EnumType.STRING)//EnumType.STRING is used to convert the enum to string in database otherwise it will stored in default way as ordinal (zero-based indexing)
    private VehicleType vehicleType;
    private String ownerName;


}
