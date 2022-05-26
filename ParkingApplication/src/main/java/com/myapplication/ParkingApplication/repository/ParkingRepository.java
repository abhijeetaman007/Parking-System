package com.myapplication.ParkingApplication.repository;

import com.myapplication.ParkingApplication.data.entity.ParkingSlot;
import com.myapplication.ParkingApplication.data.entity.Vehicle;
import com.myapplication.ParkingApplication.data.entity.VehicleType;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import  javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository //Alias to @Component
//@Transactional //Removing this transactional annotation and taking to API level to make each API call transactional
public class ParkingRepository {

    @Autowired
    @PersistenceContext //  @PersistenceContext is used to inject the EntityManager into the repository
    private EntityManager entityManager;

    public void createAndUpdateParkingSlot(ParkingSlot parkingSlot) {
        entityManager.merge(parkingSlot);//Used to save and update the entity -- if new then creates else just updates
    }

    public List<ParkingSlot> getFreeSlotForType(VehicleType vehicleType){
        //Creating a query
        //Two ways -(For criteria query in jpa)
        //1. Typed Query  -- Typed query is used to create a query and execute it
        //2. Named Query  -- Named query is used to avoid hard coding the query

        //Typed Query implementation of criteria query
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ParkingSlot> criteriaQuery = criteriaBuilder.createQuery(ParkingSlot.class);
        Root<ParkingSlot> parkingSlotRoot = criteriaQuery.from(ParkingSlot.class); //Root is used to get the table which we are querying
        criteriaQuery.where(
                criteriaBuilder.equal(parkingSlotRoot.get("occupied"), false),
                criteriaBuilder.equal(parkingSlotRoot.get("vehicleType"), vehicleType)
        );
        //Get at max 10 records
        TypedQuery<ParkingSlot> query = entityManager.createQuery(criteriaQuery).setMaxResults(2); //Typed query will return the list of objects of entity type(ParkingSlot)
        return query.getResultList();
     }

    public ParkingSlot getSlotById(String id){
        return entityManager.find(ParkingSlot.class, id);//Here it will search for table referenced by the identity and search for the id and return the object of entity type
    }

    public void createVehicle(Vehicle vehicle){
        entityManager.merge(vehicle);
    }

    public Vehicle getVehicleById(String id){
        return entityManager.find(Vehicle.class, id);
    }




}

//Methods used with EntityManager
// - merge(Object entity)
// - find(Class entityClass, Object primaryKey)
// - remove(Object entity)
// - persist(Object entity)