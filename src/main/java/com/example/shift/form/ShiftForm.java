package com.example.shift.form;

import java.time.Duration;
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

	/** ID */
	private Integer id;
	
	/** 年 */
	@NotNull(message = "年が空欄です")
	private Integer year;
	/** 月 */
	@NotNull(message = "月が空欄です")
	private Integer month;
	/** 日 */
	@NotNull(message = "日が空欄です")
	private Integer day;

	
	/** 開始時間 */
	@NotNull(message = "時間が空欄です")
	private Integer startHour;
	/** 開始分 */
	@NotNull(message = "分が空欄です")
	private Integer startMinute;

	
	/** 終了時間 */
	@NotNull(message = "時間が空欄です")
	private Integer endHour;
	/** 終了分 */
	@NotNull(message = "分が空欄です")
	private Integer endMinute;
	
	/** 休憩時間 */
	private Integer breakHour;
	/** 休憩分 */
	private Integer breakMinute;
	
	

	
	/** 新規判定 */
	private Boolean isNew;

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
	
	//休憩時間を生成
	public long getBreakTime() {
	    if (breakHour == null || breakMinute == null) {
	        return 0L;  // 休憩時間が設定されていない場合、0分とする
	    }
	   
	    return breakHour * 60L + breakMinute;
	}
	
	//実働時間を計算
	public String getWorkTime() {
		 Duration breakDuration = Duration.ofMinutes(getBreakTime());;
		Duration workDuration = Duration.between(getStartTime(), getEndTime()).minus(breakDuration);
	    

		    // 時間と分を抽出
		    long hours = workDuration.toHours();
		    long minutes = workDuration.toMinutes() % 60;

		    // 〇時間〇分という形式で返す
		    return hours + "時間" + minutes + "分";
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
