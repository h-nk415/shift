package com.example.shift.service;

import java.util.List;

import com.example.shift.entity.Shifts;

public interface ShiftsService {

	void saveShift(Shifts shift);

	Shifts getShiftById(Integer id);

	List<Shifts> getAllShifts();

	void updateShift(Shifts shift);

	void deleteShift(Integer id);

}
