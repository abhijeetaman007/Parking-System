package com.myapplication.ParkingApplication.service;

import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import com.myapplication.ParkingApplication.data.entity.VehicleType;
import com.myapplication.ParkingApplication.data.requests.CreateSlotRequest;
import com.myapplication.ParkingApplication.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    public List<ParkingSlot> getAvailableSlotForVehicle(VehicleType vehicleType){
        List<ParkingSlot> parkingSlots = parkingRepository.getAllSlot();
        List<ParkingSlot> results = new ArrayList<>();
        for(ParkingSlot parkingSlot:parkingSlots){
            if(results.size() > 10){
                break;
            }
            if(!parkingSlot.isOccupied() && parkingSlot.getType().equals(vehicleType)){
                results.add(parkingSlot);
            }
        }
        return results;
    }

    public ParkingSlot createSlot(CreateSlotRequest createSlotRequest){
        System.out.println("Request Create Slot Vehicle Type"+createSlotRequest.getVehicleType().toString());
        ParkingSlot parkingSlot = ParkingSlot.builder()
                .id(UUID.randomUUID().toString())
                .type(createSlotRequest.getVehicleType())
                .occupied(false)
                .build();
        parkingRepository.createSlot(parkingSlot);
        return parkingSlot;
    }

}
