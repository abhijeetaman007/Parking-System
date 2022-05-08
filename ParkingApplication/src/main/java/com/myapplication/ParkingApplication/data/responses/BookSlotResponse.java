package com.myapplication.ParkingApplication.data.responses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookSlotResponse {
    private boolean isSuccess;
    private String msg;
}
