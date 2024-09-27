package com.example.shift.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Shifts {
//	private User user; //ユーザーID（外部キー）
	private Integer id; // シフトID
    private LocalDate shiftDate;   // シフト日
    private LocalTime startTime;   // 開始時間
    private LocalTime endTime;     // 終了時間
//    private Duration totalHours; // 勤務時間
    
//    public void calculateTotalHours() {
//        if (startTime != null && endTime != null) {
//            this.totalHours = Duration.between(startTime, endTime);
//        }
//    }
//    
//    public String formatTotalHours() {
//        if (totalHours != null) {
//            long hours = totalHours.toHours();
//            long minutes = totalHours.toMinutesPart();
//            return hours + "時間" + minutes + "分";
//        }
//        return "0時間0分";
//    }
//
}
