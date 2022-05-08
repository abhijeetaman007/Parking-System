package com.myapplication.ParkingApplication.restapis;

import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import com.myapplication.ParkingApplication.data.entity.VehicleType;
import com.myapplication.ParkingApplication.data.requests.BookSlotRequest;
import com.myapplication.ParkingApplication.data.requests.CreateSlotRequest;
import com.myapplication.ParkingApplication.data.responses.BookSlotResponse;
import com.myapplication.ParkingApplication.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {


//    Using the service class (which has the logic) in the controller
    @Autowired
    private ParkingService parkingService;


//    Mapping Path as GET Request:
//    Get Free Parking Slots based on VehicleType
    @GetMapping("/getFreeSlots/{vehicleType}")
    public List<ParkingSlot> getSlots(@PathVariable VehicleType vehicleType){

        if(vehicleType == null ){
            //If vehicle type is NULL return empty list
            return new ArrayList<>();
        }

        //        return new ArrayList<>();
        return parkingService.getAvailableSlotForVehicle(vehicleType);
    }

//    Create New Slots
    @PutMapping("/createSlot")
    public ParkingSlot createSlot(@RequestBody CreateSlotRequest createSlotRequest){
        return parkingService.createSlot(createSlotRequest);
    }


    @PostMapping("/bookSlot")
// @RequestBody will help in parsing Request Body sent as BookSlotRequestBody Object
    public BookSlotResponse bookSlot(@RequestBody BookSlotRequest bookSlotRequest){
//        builder.build() here is used to send a dummy response
        return BookSlotResponse.builder().build();
    }
}
