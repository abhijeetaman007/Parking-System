package com.myapplication.ParkingApplication.repository;

import com.myapplication.ParkingApplication.data.dataStore.InMemoryDataStore;
import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository //Alias to @Component
public class ParkingRepository {

    @Autowired
    private InMemoryDataStore inMemoryDataStore;

    public void createSlot(ParkingSlot parkingSlot) {
        //put is method used with map to set key,value pairs
        inMemoryDataStore.getSlotTable().put(parkingSlot.getId(), parkingSlot);
        System.out.println(inMemoryDataStore.getSlotTable());
    }

    public List<ParkingSlot> getAllSlot(){
//             values() is a method used with Map to get all values -- read more
        return new ArrayList<>(inMemoryDataStore.getSlotTable().values());
    }


    public ParkingSlot getSlotById(String id){
        return inMemoryDataStore.getSlotTable().get(id);
    }

}
