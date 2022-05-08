package com.myapplication.ParkingApplication.data.dataStore;

import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import com.myapplication.ParkingApplication.data.entity.Vehicle;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Getter
public class InMemoryDataStore {
        private Map<String, ParkingSlot> slotTable;
        private Map<String, Vehicle> vehicleTable;

        public InMemoryDataStore(){
            slotTable = new HashMap<>();
            vehicleTable = new HashMap<>();
        }



}
