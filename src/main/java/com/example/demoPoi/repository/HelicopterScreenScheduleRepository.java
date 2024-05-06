package com.example.demoPoi.repository;

import com.example.demoPoi.entities.HelicopterHistory;
import com.example.demoPoi.entities.HelicopterScreenSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface HelicopterScreenScheduleRepository extends JpaRepository<HelicopterScreenSchedule, Integer> {
    @Query(value = "select id " +
            "from HelicopterScreenSchedule where " +
            "movNm = :movNm " +
            "and scnDy = :scnDy " +
            "and name = :name " +
            "and screenNm = :screenNm " +
            "and seatCnt = :seatCnt " +
            "and dateOccur = :dateOccur " +
            "and userId = :userId "
    )
    List<Integer> findByCustom(String movNm, String scnDy, String name, String screenNm, String seatCnt, String dateOccur, String userId);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO HELICOPTER_SCREEN_SCHEDULE (\n" +
            "    ID, MOV_NM, SCN_DY, SCN_FR_TM, SCN_TO_TM,\n" +
            "    NAME, SCREEN_NM, SEAT_CNT, BIZ_FR_DY, BIZ_TO_DY, DATE_OCCUR, USER_ID\n" +
            ") \n" +
            "VALUES (\n" +
            "    NEXTVAL('sqe_id_screen_cptt'), \n" +
            "    :movNm,\n" +
            "    :scnDy,\n" +
            "    :scnFrTm,\n" +
            "    :scnToTm,\n" +
            "    :name,\n" +
            "    :screenNm,\n" +
            "    :seatCnt,\n" +
            "    :bizFrDy,\n" +
            "    :bizToDy,\n" +
            "    :dateOccur,\n" +
            "    :userId,   \n" +
            "    :userNm   \n" +
            ")", nativeQuery = true)
    void insertCustom(String movNm, String scnDy, String scnFrTm,
                      String scnToTm, String name, String screenNm, String seatCnt,
                      String bizFrDy, String bizToDy, String dateOccur, String userId,
                      String userNm
                      );

}
