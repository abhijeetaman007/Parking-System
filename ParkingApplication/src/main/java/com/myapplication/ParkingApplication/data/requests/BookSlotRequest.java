package com.myapplication.ParkingApplication.data.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data //@Data is used to generate getters, setters, toString and hashCode methods
public class BookSlotRequest {
    private String slotId;
    private String vehicleId;
    private String ownerName;

//    @Override
//    public String toString() {
//        return super.toString();
//        return "BookSlotRequest{" +slotId+ "," +vehicleId+ "," +ownerName+ "}";
//    }

}
