package com.myapplication.ParkingApplication.data.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//Following comes under Lombok
@Getter
@Setter
//Getter and Setter for all private fields
@NoArgsConstructor  //Empty constructor
@AllArgsConstructor //Constructor with all fields
@Builder //Helps to dynamically decide while creating object if we want just id and type then we can just pass that or any other combination required
@Data //It has toString implemented so can be used directly for printing, Data also comes under Lombok

@Entity(name = "ParkingSlot") //Name of the class which would be an entity
@Table(name = "parking_slot") //Mapping to Table in DB
public class ParkingSlot {

    @Id //Primary key
    @GenericGenerator(name = "system-uuid", strategy = "uuid") //Generates UUID
    @GeneratedValue(generator = "system-uuid") //Tells to use the generator when ID is not passed and generator used will be with name system-uuid as which refers to the above mentioned generator
    private String id;
    @Enumerated(EnumType.STRING)//Enumeration for type of parking slot
    private VehicleType vehicleType;
    private boolean occupied;
    private String vehicleId;

}
