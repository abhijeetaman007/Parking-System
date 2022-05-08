package com.myapplication.ParkingApplication.data.entity;

import lombok.*;

//Following comes under Lombok
@Getter
@Setter
//Getter and Setter for all private fields
@NoArgsConstructor  //Empty constructor
@AllArgsConstructor //Constructor with all fields
@Builder //Helps to dynamically decide while creating object if we want just id and type then we can just pass that or any other combination required
@Data //It has toString implemented so can be used directly for printing, Data also comes under Lombok

public class ParkingSlot {
    private String id;
    private VehicleType type;
    private boolean occupied;
    private String vehicleId;

////    Overriding toString -- to print object
//    @Override
//    public String toString(){
//        System.out.println("("+id+" ,"+type+" ,"+occupied+" ,"+vehicleId+")");
//    }
}
