package com.example.demoPoi.repository;

import com.example.demoPoi.entities.HelicopterCompetitorLocation;
import com.example.demoPoi.entities.HelicopterHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HelicopterHistoryRepository extends JpaRepository<HelicopterHistory, Integer> {
    @Query(value = "INSERT INTO HELICOPTER_HST (\n" +
            "    ID,NAME_FILE, SIZE_FILE, TIME_START, END_START,\n" +
            "    STATUS, MESSAGE_ERROR, USER_ID\n" +
            ") VALUES (\n" +
            "      NEXTVAL('sqe_id_hst_cptt'),\n" +
            "      :nameFile,\n" +
            "      :sizeFile,\n" +
            "      :timeStart,\n" +
            "      :endStart,\n" +
            "      :status,\n" +
            "      :messageError,\n" +
            "      :userId\n" +
            ");", nativeQuery = true)
    void insertCustom(String nameFile, String sizeFile, String timeStart, String endStart, String status, String messageError, String userId);

}
