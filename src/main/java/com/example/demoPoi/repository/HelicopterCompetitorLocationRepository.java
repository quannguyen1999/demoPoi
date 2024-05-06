package com.example.demoPoi.repository;

import com.example.demoPoi.entities.HelicopterCompetitorLocation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface HelicopterCompetitorLocationRepository extends JpaRepository<HelicopterCompetitorLocation, Integer> {
    @Query(value = "select id " +
            "from HelicopterCompetitorLocation where " +
            "name = :name " +
            "and rmNm = :rmNm " +
            "and amNm = :amNm " +
            "and cityNm = :cityNm " +
            "and userId = :userId " +
            "and dateOccur = :dateOccur ")
    List<Integer> findByCustom(String name, String rmNm, String amNm, String cityNm, String userId, String dateOccur);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HELICOPTER_COMPETITOR_LOCATION (\n" +
            "    ID, NAME, RM_NM, AM_NM, CITY_NM,\n" +
            "    DATE_OCCUR, USER_ID, USER_NM\n" +
            ") \n" +
            "VALUES (\n" +
            "    NEXTVAL('sqe_id_location_cptt'), \n" +
            "    :name,\n" +
            "    :rmNm,\n" +
            "    :amNm,\n" +
            "    :cityNm,\n" +
            "    :dateOccur,\n" +
            "    :userId,   \n" +
            "    :userNm   \n" +
            ")", nativeQuery = true)
    void insertCustom(String name, String rmNm, String amNm, String cityNm, String dateOccur, String userId, String userNm);




}
