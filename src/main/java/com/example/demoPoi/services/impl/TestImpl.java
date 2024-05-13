package com.example.demoPoi.services.impl;

import com.example.demoPoi.constants.MessageErrors;
import com.example.demoPoi.entities.HelicopterCompetitorLocation;
import com.example.demoPoi.entities.HelicopterHistory;
import com.example.demoPoi.entities.HelicopterScreenSchedule;
import com.example.demoPoi.exceptions.BadRequestException;
import com.example.demoPoi.repository.HelicopterCompetitorLocationRepository;
import com.example.demoPoi.repository.HelicopterHistoryRepository;
import com.example.demoPoi.repository.HelicopterScreenScheduleRepository;
import com.example.demoPoi.services.TestService;
import org.apache.logging.log4j.util.Strings;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Service
public class TestImpl implements TestService {

    @Autowired
    private HelicopterCompetitorLocationRepository helicopterCompetitorLocationRepository;
    @Autowired
    private HelicopterScreenScheduleRepository helicopterScreenScheduleRepository;
    @Autowired
    private HelicopterHistoryRepository helicopterHistoryRepository;

    private static final String REGEX_HEADER = "Multiplex,Site code,Screen,Format,BO,Admits,Seat,Date of showing,Start-time,End-time,Film,Time range,Session (Short),Cinema,Tier,Region,Area,RCM,RCM ID,City";
    private static final Integer ROW_HEADER = 1;
    private static final Integer COLUMN_MUTIPLEX = 1;
    private static final Integer COLUMN_SITE = 2;
    private static final Integer COLUMN_SCREEN = 3;

    private static final Integer COLUMN_FORMAT = 4;
    private static final Integer COLUMN_BO = 5;
    private static final Integer COLUMN_ADMITS = 6;
    private static final Integer COLUMN_SEAT = 7;
    private static final Integer COLUMN_DOS = 8;
    private static final Integer COLUMN_START_TIME = 9;

    private static final Integer COLUMN_END_TIME = 10;

    private static final Integer COLUMN_FILM = 11;

    private static final Integer COLUMN_TIME_RANGE = 12;

    private static final Integer COLUMN_SESSION = 13;

    private static final Integer COLUMN_CINEMA = 14;

    private static final Integer COLUMN_TIER = 15;

    private static final Integer COLUMN_REGION = 16;

    private static final Integer COLUMN_AREA = 17;

    private static final Integer COLUMN_RCM = 18;
    private static final Integer COLUMN_RCM_ID = 19;

    private static final Integer COLUMN_CITY = 20;


    private static final String STATUS_ERROR = "error";
    private static final String STATUS_SUCCESS = "success";
    private static final SimpleDateFormat dfOne = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat dfTwo = new SimpleDateFormat("yyyyMMdd hh:mm:ss");
    private static final SimpleDateFormat dfThree = new SimpleDateFormat("HH:mm:ss");

    private static final SimpleDateFormat dfFour = new SimpleDateFormat("HHmm");

    @Override
    public void handlerData(byte[] data) {
        String dateOccur = dfOne.format(new Date());
        //Delete data
        helicopterCompetitorLocationRepository.deleteDataToday(dateOccur);
        helicopterScreenScheduleRepository.deleteDataToday(dateOccur);

        HelicopterHistory historyHelicopter = initHistoryHelicopter(new HelicopterHistory());
        try
        {
            // Create a ByteArrayInputStream from the byte array
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(byteArrayInputStream);
            //Get first/desired sheet from the workbook
            XSSFSheet ws = wb.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = ws.iterator();
            int rowNumber = 1;
            while (rowIterator.hasNext())
            {
                int column = 1;
                HelicopterCompetitorLocation helicopterCompetitorLocation = null;
                HelicopterScreenSchedule helicopterScreenSchedule = null;
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                //Validate Header Excel
                validateExcelFile(cellIterator, rowNumber, ws);

                while (cellIterator.hasNext() && rowNumber != ROW_HEADER)
                {
                    Cell cell = cellIterator.next();
                    if(column == 1 && isCellEmpty(cell)){
                        break;
                    }
                    //Handler Location
                    helicopterCompetitorLocation = handlerExcelHelicopterLocation(column, helicopterCompetitorLocation, cell, dateOccur);

                    //Handler Screen X
                    helicopterScreenSchedule = handlerExcelCinema(column, helicopterScreenSchedule, cell, dateOccur);

                    column++;
                }

                //Handler Insert here
                //Helicopter Location
                handlerDBHelicopterLocation(helicopterCompetitorLocation);
                //Helicopter cinema
                handlerDBHelicopterCinema(helicopterScreenSchedule);

                rowNumber++;
            }
            wb.close();
            byteArrayInputStream.close();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            historyHelicopter.setStatus(STATUS_ERROR);
            historyHelicopter.setMessageError(ex.getMessage());
        }
        historyHelicopter.setEndStart(dfTwo.format(new Date()));
        handlerDBHelicopterHistory(historyHelicopter);
    }

    private void handlerDBHelicopterLocation(HelicopterCompetitorLocation helicopterCompetitorLocation){
        if(!ObjectUtils.isEmpty(helicopterCompetitorLocation)) {
            boolean isUserExists = StringUtils.hasLength(helicopterCompetitorLocation.getUserId());
            boolean isNameExists = StringUtils.hasLength(helicopterCompetitorLocation.getName());
            boolean isRmExists = StringUtils.hasLength(helicopterCompetitorLocation.getRmNm());
            boolean isAmExists = StringUtils.hasLength(helicopterCompetitorLocation.getAmNm());
            boolean isCityExists = StringUtils.hasLength(helicopterCompetitorLocation.getCityNm());
            boolean isRecordExists = ObjectUtils.isEmpty(helicopterCompetitorLocationRepository.findByCustom(helicopterCompetitorLocation.getName(), helicopterCompetitorLocation.getRmNm(), helicopterCompetitorLocation.getAmNm(), helicopterCompetitorLocation.getCityNm(), helicopterCompetitorLocation.getUserId(), helicopterCompetitorLocation.getDateOccur()));

            if(isRecordExists && isUserExists && isNameExists && isAmExists && isCityExists && isRmExists){
                helicopterCompetitorLocationRepository.insertCustom(
                        helicopterCompetitorLocation.getName(),
                        helicopterCompetitorLocation.getRmNm(),
                        helicopterCompetitorLocation.getAmNm(),
                        helicopterCompetitorLocation.getCityNm(),
                        helicopterCompetitorLocation.getDateOccur(),
                        helicopterCompetitorLocation.getUserId(),
                        helicopterCompetitorLocation.getUserNm()
                );
            }
        }
    }

    private void handlerDBHelicopterCinema(HelicopterScreenSchedule helicopterScreenSchedule){
        if(!ObjectUtils.isEmpty(helicopterScreenSchedule)) {
            boolean isUserExists = StringUtils.hasLength(helicopterScreenSchedule.getUserId());
            boolean isMovExists = StringUtils.hasLength(helicopterScreenSchedule.getMovNm());
            boolean isScnDyExists = StringUtils.hasLength(helicopterScreenSchedule.getScnDy());
            boolean isNameExists = StringUtils.hasLength(helicopterScreenSchedule.getName());
            boolean isScreenExists = StringUtils.hasLength(helicopterScreenSchedule.getScreenNm());
            boolean isSeatCntExists = StringUtils.hasLength(helicopterScreenSchedule.getSeatCnt());
            boolean isRecordExists = ObjectUtils.isEmpty(helicopterScreenScheduleRepository
                    .findByCustom(helicopterScreenSchedule.getMovNm(),
                            helicopterScreenSchedule.getScnDy(),
                            helicopterScreenSchedule.getName(),
                            helicopterScreenSchedule.getScreenNm(),
                            helicopterScreenSchedule.getSeatCnt(),
                            helicopterScreenSchedule.getDateOccur(),
                            helicopterScreenSchedule.getUserId()
                    ));
            if(isUserExists && isMovExists && isScnDyExists && isNameExists && isScreenExists && isSeatCntExists && isRecordExists){
                helicopterScreenScheduleRepository.insertCustom(
                        helicopterScreenSchedule.getMovNm(),
                        helicopterScreenSchedule.getScnDy(),
                        helicopterScreenSchedule.getScnFrTm(),
                        helicopterScreenSchedule.getScnToTm(),
                        helicopterScreenSchedule.getName(),
                        helicopterScreenSchedule.getScreenNm(),
                        helicopterScreenSchedule.getSeatCnt(),
                        helicopterScreenSchedule.getBizFrDy(),
                        helicopterScreenSchedule.getBizToDy(),
                        helicopterScreenSchedule.getDateOccur(),
                        helicopterScreenSchedule.getUserId(),
                        helicopterScreenSchedule.getUserNm()
                );

            }
        }
    }

    private void handlerDBHelicopterHistory(HelicopterHistory helicopterHistory){
        helicopterHistoryRepository.insertCustom(helicopterHistory.getNameFile(),
                helicopterHistory.getSizeFile(),
                helicopterHistory.getTimeStart(),
                helicopterHistory.getEndStart(),
                helicopterHistory.getStatus(),
                helicopterHistory.getMessageError(),
                helicopterHistory.getUserId()
        );
    }

    private void validateExcelFile(Iterator<Cell> cellIterator, Integer rowNumber, XSSFSheet ws){
        String valueAppend = "";
        if(rowNumber != ROW_HEADER){
            return;
        }
        while (cellIterator.hasNext()){
            Iterator<Row> rowIterator = ws.iterator();
            while (rowIterator.hasNext())
            {
                if(!cellIterator.hasNext()){
                    break;
                }
                Cell cell = cellIterator.next();
                valueAppend += getCellType(cell);
                valueAppend+=",";
            }
        }

        String firstValue = REGEX_HEADER.toLowerCase();
        String secondValue = valueAppend.substring(0, valueAppend.length() - 1).toLowerCase();
        if(!firstValue.equalsIgnoreCase(secondValue)){
            throw new BadRequestException(MessageErrors.EXCEL_HEADER_INVALID);
        }

    }

    private HelicopterHistory initHistoryHelicopter(HelicopterHistory historyHelicopter){
        historyHelicopter.setDateRun(dfOne.format(new Date()));
        historyHelicopter.setTimeStart(dfTwo.format(new Date()));
        historyHelicopter.setDateRun(dfOne.format(new Date()));
        historyHelicopter.setStatus(STATUS_SUCCESS);
        return historyHelicopter;
    }

    private HelicopterScreenSchedule handlerExcelCinema(
            Integer column, HelicopterScreenSchedule helicopterScreenSchedule, Cell cell, String dateOccur
    ) throws ParseException {
        if(ObjectUtils.isEmpty(helicopterScreenSchedule)){
            helicopterScreenSchedule = new HelicopterScreenSchedule();
            helicopterScreenSchedule.setBizFrDy("20170101");
            helicopterScreenSchedule.setBizToDy("20990101");
            helicopterScreenSchedule.setDateOccur(dateOccur);
        }
        //~Screen
        if(column == COLUMN_SCREEN){
            helicopterScreenSchedule.setScreenNm(removeLastZero(getCellType(cell)));
        }
        //Cinema
        if(column == COLUMN_CINEMA){
            helicopterScreenSchedule.setName(getCellType(cell));
        }
        //~Seat
        if(column == COLUMN_SEAT){
            helicopterScreenSchedule.setSeatCnt(removeLastZero(getCellType(cell)));
        }
        //~Date Of Showing
        if(column == COLUMN_DOS){
            helicopterScreenSchedule.setScnDy(removeLastZero(getCellType(cell)));
        }
        //~Film
        if(column == COLUMN_FILM){
            helicopterScreenSchedule.setMovNm(getCellType(cell));
        }
        //~Start Time
        if(column == COLUMN_START_TIME){
            helicopterScreenSchedule.setScnFrTm(convertTimeToHHmm(getCellType(cell)));
        }
        //~End Time
        if(column == COLUMN_END_TIME){
            helicopterScreenSchedule.setScnToTm(convertTimeToHHmm(getCellType(cell)));
        }
        //~RCM
        if(column == COLUMN_RCM){
            helicopterScreenSchedule.setUserNm(getCellType(cell));
        }
        //~RCM_ID
        if(column == COLUMN_RCM_ID){
            helicopterScreenSchedule.setUserId(removeLastZero(getCellType(cell)));
        }
        return helicopterScreenSchedule;
    }

    private String removeLastZero(String value){
        if(!StringUtils.hasLength(value)){
            return Strings.EMPTY;
        }
        // Remove ".0" if it exists
        if (value.endsWith(".0")) {
            value = value.substring(0, value.length() - 2);
        }
        return value;
    }

    private String convertTimeToHHmm(String value) {
        double numericValue = Double.parseDouble(value);
        int totalSecondsInDay = 24 * 60 * 60;

        // Step 1: Multiply the fractional part by the total number of seconds in a day
        int totalSeconds = (int) (numericValue * totalSecondsInDay);

        // Step 2: Convert the total seconds to hours, minutes, and seconds
        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        // Format the result as "HH:mm:ss"
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return time;
    }

    private HelicopterCompetitorLocation handlerExcelHelicopterLocation(
            Integer column, HelicopterCompetitorLocation helicopterCompetitorLocation, Cell cell, String dateOccur
    ){
        if(ObjectUtils.isEmpty(helicopterCompetitorLocation)){
            helicopterCompetitorLocation = new HelicopterCompetitorLocation();
            helicopterCompetitorLocation.setDateOccur(dateOccur);
        }
        //Cinema
        if(column == COLUMN_CINEMA){
            helicopterCompetitorLocation.setName(getCellType(cell));
        }
        //~Region
        if(column == COLUMN_REGION){
            helicopterCompetitorLocation.setRmNm(getCellType(cell));
        }
        //~Area
        if(column == COLUMN_AREA){
            helicopterCompetitorLocation.setAmNm(getCellType(cell));
        }
        //~City
        if(column == COLUMN_CITY){
            helicopterCompetitorLocation.setCityNm(getCellType(cell));
        }
        //~RCM
        if(column == COLUMN_RCM){
            helicopterCompetitorLocation.setUserNm(getCellType(cell));
        }
        //~RCM_ID
        if(column == COLUMN_RCM_ID){
            helicopterCompetitorLocation.setUserId(getCellType(cell));
        }
        return helicopterCompetitorLocation;
    }

    private boolean isCellEmpty(Cell cell){
        boolean isCellEmpty = Boolean.TRUE;
        switch (cell.getCellType())
        {
            case Cell.CELL_TYPE_NUMERIC:
                isCellEmpty = ObjectUtils.isEmpty(cell.getNumericCellValue());
                break;
            case Cell.CELL_TYPE_STRING:
                isCellEmpty = ObjectUtils.isEmpty(cell.getStringCellValue());
                break;
        }
        return isCellEmpty;
    }

    private String getCellType(Cell cell){
        StringBuilder result = new StringBuilder();
        switch (cell.getCellType())
        {
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    System.out.println("amazing");
                    result.append(dfThree.format(cell.getDateCellValue()));
                } else {
                    result.append(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_STRING:
                result.append(cell.getStringCellValue());
                break;
            case Cell.CELL_TYPE_FORMULA:
                result.append(cell.getCellFormula());
                break;
        }
        return result.toString().trim();
    }
}
