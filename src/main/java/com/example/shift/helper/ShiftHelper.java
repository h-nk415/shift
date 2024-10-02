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
		form.setShiftDate(shift.getShiftDate());
		form.setStartTime(shift.getStartTime());
		form.setEndTime(shift.getEndTime());
		
		//更新画面設定
		form.setIsNew(false);
		return form;
	}

}