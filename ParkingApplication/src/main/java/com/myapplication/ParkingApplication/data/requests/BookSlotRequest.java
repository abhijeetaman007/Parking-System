package com.myapplication.ParkingApplication.data.requests;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookSlotRequest {
    private String slotId;
    private String vehicleId;

}
