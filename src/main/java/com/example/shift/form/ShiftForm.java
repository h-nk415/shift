package com.example.shift.form;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@NotNull(message = "入力が不正です")
public class ShiftForm {
	
	private Integer id;
	private Integer year;        // 年を格納
	private Integer month;       // 月を格納
	private Integer day;         // 日を格納
	
	private Integer startHour;
	private Integer startMinute;
	
	private Integer endHour;
	private Integer endMinute;
	
	private LocalDate shiftDate;
	private LocalTime startTime;   // 開始時間
	private LocalTime endTime;     // 終了時間
	private Boolean isNew; //新規判定
	
	 // LocalDateを生成するメソッドを追加
    public LocalDate getShiftDate() {
        return LocalDate.of(year, month, day);
    }
    
    public LocalTime getStartTime() {
    	return LocalTime.of(startHour, startMinute);
    }
    
    public LocalTime getEndTime() {
    	return LocalTime.of(endHour, endMinute);
    }

}
