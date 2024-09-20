package com.example.shift.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shift.entity.Shifts;
import com.example.shift.repository.ShiftsMapper;
import com.example.shift.service.ShiftsService;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class ShiftsServiceImpl implements ShiftsService{
	
	private final ShiftsMapper shiftsMapper;

	@Override
	public void saveShift(Shifts shift) {
		BigDecimal totalHours = shift.getEndTime() - shift.getStartTime();
		
		shiftsMapper.insertShift(shift);
		
	}

	@Override
	public Shifts getShiftById(Integer id) {
		return shiftsMapper.getShiftById(id);
		
	}

	@Override
	public List<Shifts> getAllShifts() {
		return null;
	}

	@Override
	public void updateShift(Shifts shift) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void deleteShift(Integer id) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
