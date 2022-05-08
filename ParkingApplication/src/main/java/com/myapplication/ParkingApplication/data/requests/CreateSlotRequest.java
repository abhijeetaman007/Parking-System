package com.myapplication.ParkingApplication.data.requests;

import com.myapplication.ParkingApplication.data.entity.VehicleType;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSlotRequest {
    private VehicleType vehicleType;
}
