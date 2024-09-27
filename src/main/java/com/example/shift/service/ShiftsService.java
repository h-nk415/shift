package com.example.shift.service;

//import java.math.BigDecimal;
import java.util.List;

import com.example.shift.entity.Shifts;

public interface ShiftsService {

	void saveShift(Shifts shift);

	Shifts getShiftById(Integer id);

	List<Shifts> getAllShifts();

	void updateShift(Shifts shift);

	Shifts deleteShift(Integer id);
	
//	void setHourlyWage(BigDecimal hourlyWage);

}
