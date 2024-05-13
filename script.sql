-- Step 1: Create Sequence
CREATE SEQUENCE SQE_ID_LOCATION_CPTT
       START WITH 1
       INCREMENT BY 1
       NO CYCLE;

CREATE SEQUENCE SQE_ID_HST_CPTT
       START WITH 1
       INCREMENT BY 1
       NO CYCLE;

CREATE SEQUENCE SQE_ID_SCREEN_CPTT
       START WITH 1
       INCREMENT BY 1
       NO CYCLE;

-- Step 2: Create Table
-- Table location
CREATE TABLE HELICOPTER_COMPETITOR_LOCATION (
    ID SERIAL PRIMARY KEY,
    NAME VARCHAR(100),
    RM_NM VARCHAR(100),
    AM_NM VARCHAR(100),
    CITY_NM VARCHAR(100),
    DATE_OCCUR VARCHAR(10),
    USER_ID VARCHAR(100),
    USER_NM varchar(100),
    REG_K_ID VARCHAR(20) NULL,
    REG_DT DATE NULL,
    UPD_K_ID VARCHAR(20) NULL,
    UPD_DT DATE NULL
);


-- History table occur
CREATE TABLE HELICOPTER_HST (
    ID SERIAL PRIMARY KEY,
    NAME_FILE VARCHAR(100),
    SIZE_FILE VARCHAR(100),
    TIME_START VARCHAR(100),
    END_START VARCHAR(100),
    STATUS VARCHAR(1000),
    MESSAGE_ERROR VARCHAR(4000),
    USER_ID VARCHAR(100),
    REG_K_ID VARCHAR(20) NULL,
    REG_DT DATE NULL,
    UPD_K_ID VARCHAR(20) NULL,
    UPD_DT DATE NULL
);

-- Table Schedule
CREATE TABLE HELICOPTER_SCREEN_SCHEDULE (
    ID SERIAL PRIMARY KEY,
    MOV_NM VARCHAR(100),
    SALE_TO_TM VARCHAR(10),
    SCN_DY VARCHAR(10),
    SCN_FR_TM VARCHAR(10),
    SCN_TO_TM VARCHAR(10),
    NAME VARCHAR(100),
    SCREEN_NM VARCHAR(100),
    SEAT_CNT INTEGER,
    BIZ_FR_DY VARCHAR(8),
    BIZ_TO_DY VARCHAR(8),
    DATE_OCCUR VARCHAR(10),
    USER_ID VARCHAR(100),
    USER_NM varchar(100),
    REG_K_ID VARCHAR(20) NULL,
    REG_DT DATE NULL,
    UPD_K_ID VARCHAR(20) NULL,
    UPD_DT DATE NULL
);



--testing
INSERT INTO HELICOPTER_HST (
    ID,NAME_FILE, SIZE_FILE, TIME_START, END_START,
    STATUS, MESSAGE_ERROR, USER_ID
) VALUES (
      NEXTVAL('sqe_id_hst_cptt'),
      :nameFile,
      :sizeFile,
      :timeStart,
      :endStart,
      :status,
      :messageError,
      :userId
);

--
--select id from HELICOPTER_COMPETITOR_LOCATION where name = :name and rm_nm = :rmNm and am_nm = :amNm and city_nm = :cityNm and user_id = :userId and date_occur = :dateOccur limit 1
--select * from HELICOPTER_COMPETITOR_LOCATION
--
-- "Multiplex,tSite code,Cinema,Screen,Format,BO,Admits,Seat,Date of showing,Session,Film,Time range,Session (Short),Cinema Map,Tier,Region,Area";
--
--Multiplex,Site code,Cinema,Screen,Format,BO,Admits,Seat,Date of showing,Session,Film,Time range,Session (Short),Cinema Map,Tier,Region,Area,City
--Multiplex,Site code,Cinema,Screen,Format,BO,Admits,Seat,Date of showing,Session,Film,Time range,Session (Short),Cinema Map,Tier,Region,Area,City
--
--SELECT sequence_name, start_value
--FROM information_schema.sequences
--WHERE sequence_name = 'sqe_that_cd_location_cptt';
--
--
--INSERT INTO HELICOPTER_COMPETITOR_LOCATION (
--    ID, THAT_CD, NAME, RM_CD, RM_NM, AM_CD, AM_NM, CITY_CD, CITY_NM,
--    DATE_OCCUR, USER_ID
--)
--VALUES (
--    NEXTVAL('sqe_id_location_cptt'),
--    NEXTVAL('sqe_that_cd_location_cptt'),
--    :name,
--    NEXTVAL('sqe_rm_location_cptt'),
--    :rmNm,
--    NEXTVAL('sqe_am_location_cptt'),
--    :amNm,
--    NEXTVAL('sqe_city_location_cptt'),
--    :cityNm,
--    :dateOccur,
--    :userId
--)
--
--
--INSERT INTO HELICOPTER_HST (
--    ID,NAME_FILE, SIZE_FILE, TIME_START, END_START,
--    STATUS, MESSAGE_ERROR, USER_ID
--) VALUES (
--      NEXTVAL('sqe_id_hst_cptt'),
--      :nameFile,
--      :sizeFile,
--      :timeStart,
--      :endStart,
--      :status,
--      :messageError,
--      :userId
--);
--
--select * from HELICOPTER_HST
--
--delete from HELICOPTER_HST
--
--
--
--select * from HELICOPTER_COMPETITOR_LOCATION
--drop table HELICOPTER_HST
--
--delete from HELICOPTER_COMPETITOR_LOCATION
--
--select hcl1_0.id from helicopter_competitor_location hcl1_0 where hcl1_0.name='' and hcl1_0.rm_nm=? and hcl1_0.am_nm=? and hcl1_0.city_nm=? and hcl1_0.user_id=? and hcl1_0.date_occur=?
--
--
--
