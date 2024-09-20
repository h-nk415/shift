package com.example.shift.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Shifts {
	private Integer id;                // シフトID
    private LocalDate shiftDate;   // シフト日
    private LocalTime startTime;   // 開始時間
    private LocalTime endTime;     // 終了時間
    private BigDecimal totalHours; // 合計勤務時間
    private BigDecimal hourlyWage; // 時給
	

}
