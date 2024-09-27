package com.example.shift.helper;

import com.example.shift.entity.Shifts;
import com.example.shift.form.ShiftForm;

public class ShiftHelper {
	
	public static Shifts convertShift(ShiftForm form) {
		Shifts shifts = new Shifts();
		shifts.setId(form.getId());
		shifts.setShiftDate(form.getShiftDate());
		shifts.setStartTime(form.getStartTime());
		shifts.setEndTime(form.getEndTime());
		return shifts;
		
	}
	
	public static ShiftForm convertShiftForm(Shifts shift) {
		ShiftForm form = new ShiftForm();
		form.setId(shift.getId());
		form.setShiftDate(shift.getShiftDate());
		form.setStartTime(shift.getStartTime());
		form.setEndTime(shift.getEndTime());
		
		form.setIsNew(false);
		return form;
	}

}
