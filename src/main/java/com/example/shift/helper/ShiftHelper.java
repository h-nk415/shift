package com.example.shift.helper;

import com.example.shift.entity.Shifts;
import com.example.shift.form.ShiftForm;

public class ShiftHelper {
	
	public static Shifts convertShift(ShiftForm form) {
		
		//shiftsへの変換
		
		Shifts shifts = new Shifts();
		shifts.setId(form.getId());
		shifts.setShiftDate(form.getShiftDate());
		shifts.setStartTime(form.getStartTime());
		shifts.setEndTime(form.getEndTime());
		return shifts;
		
	}
	
	public static ShiftForm convertShiftForm(Shifts shift) {
		
		//formへの変換
		
		ShiftForm form = new ShiftForm();
	    form.setId(shift.getId());
	    
	    // 日付を分割
	    if (shift.getShiftDate() != null) {
	        form.setYear(shift.getShiftDate().getYear());
	        form.setMonth(shift.getShiftDate().getMonthValue());
	        form.setDay(shift.getShiftDate().getDayOfMonth());
	    }
	    
	    // 時間の設定
	    if (shift.getStartTime() != null) {
	        form.setStartHour(shift.getStartTime().getHour());
	        form.setStartMinute(shift.getStartTime().getMinute());
	    }
	    if (shift.getEndTime() != null) {
	        form.setEndHour(shift.getEndTime().getHour());
	        form.setEndMinute(shift.getEndTime().getMinute());
	    }
	    
	    form.setIsNew(false);
	    return form;
	}

}