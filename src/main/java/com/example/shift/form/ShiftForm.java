package com.example.shift.form;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Valid
@NoArgsConstructor
@AllArgsConstructor

public class ShiftForm {


	private Integer id;			 //ID

	@NotNull(message = "年が空欄です")
	private Integer year;        // 年

	@NotNull(message = "月が空欄です")
	private Integer month;       // 月

	@NotNull(message = "日が空欄です")
	private Integer day;         // 日

	@NotNull(message = "時間が空欄です")
	private Integer startHour;		//開始時間

	@NotNull(message = "分が空欄です")
	private Integer startMinute;	//開始分

	@NotNull(message = "時間が空欄です")
	private Integer endHour;		//終了時間

	@NotNull(message = "分が空欄です")
	private Integer endMinute;		//終了分

	private LocalDate shiftDate;
	private LocalTime startTime;   // 開始時間
	private LocalTime endTime;     // 終了時間
	private Boolean isNew; //新規判定

	// シフト日を生成
	public LocalDate getShiftDate() {
		return LocalDate.of(year, month, day);
	}

	//開始時間を生成
	public LocalTime getStartTime() {
		return LocalTime.of(startHour, startMinute);
	}

	//終了時間を生成
	public LocalTime getEndTime() {
		return LocalTime.of(endHour, endMinute);
	}

	// 開始時間と終了時間のチェック
	public boolean isStartTimeBeforeEndTime() {
		if (startHour == null || startMinute == null || endHour == null || endMinute == null) {
			return true;
		}
		LocalTime start = LocalTime.of(startHour, startMinute);
		LocalTime end = LocalTime.of(endHour, endMinute);
		return start.isBefore(end);
	}

}
