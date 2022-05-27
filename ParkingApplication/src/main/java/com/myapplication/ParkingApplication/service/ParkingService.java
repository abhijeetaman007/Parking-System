package com.myapplication.ParkingApplication.service;

import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import com.myapplication.ParkingApplication.data.entity.Vehicle;
import com.myapplication.ParkingApplication.data.entity.VehicleType;
import com.myapplication.ParkingApplication.data.requests.BookSlotRequest;
import com.myapplication.ParkingApplication.data.requests.CreateSlotRequest;
import com.myapplication.ParkingApplication.data.responses.BookSlotResponse;
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
//        List<ParkingSlot> parkingSlots = parkingRepository.getFreeSlotForType(vehicleType);
        //Using Named Query implementation
        List<ParkingSlot> parkingSlots = parkingRepository.getFreeSlotForType2(vehicleType);
        return parkingSlots;
    }

    public ParkingSlot createSlot(CreateSlotRequest createSlotRequest){
        System.out.println("Request Create Slot Vehicle Type"+createSlotRequest.getVehicleType().toString());
        ParkingSlot parkingSlot = ParkingSlot.builder()
                .id(UUID.randomUUID().toString())
                .vehicleType(createSlotRequest.getVehicleType())
                .occupied(false)
                .build();
        parkingRepository.createAndUpdateParkingSlot(parkingSlot);
        return parkingSlot;
    }

    public BookSlotResponse bookSlot(BookSlotRequest bookSlotRequest){
        System.out.println("Book Slot Request"+bookSlotRequest.toString());
        ParkingSlot parkingSlot = parkingRepository.getSlotById(bookSlotRequest.getSlotId());
        if(parkingSlot.isOccupied()){
            return BookSlotResponse.builder()
                    .isSuccess(false)
                    .msg("Parking slot is occupied")
                    .build();
        }

        Vehicle vehicle = parkingRepository.getVehicleById(bookSlotRequest.getVehicleId());
        if(vehicle == null){
            vehicle = Vehicle.builder()
                    .vehicleId(bookSlotRequest.getVehicleId())
                    .vehicleType(parkingSlot.getVehicleType())
                    .ownerName(bookSlotRequest.getOwnerName())
                    .build();
        }

        parkingSlot.setOccupied(true);
        parkingSlot.setVehicleId(bookSlotRequest.getVehicleId());
        //Above code is not persisting to DB
        parkingRepository.createAndUpdateParkingSlot(parkingSlot);
        parkingRepository.createVehicle(vehicle);

        return BookSlotResponse.builder()
                .isSuccess(true)
                .msg("Parking slot booked successfully")
                .build();
    }


}
