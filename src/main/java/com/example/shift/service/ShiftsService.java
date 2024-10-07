package com.example.shift.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.shift.entity.Shifts;
import com.example.shift.repository.ShiftsMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor

public class ShiftsService{

	private final ShiftsMapper shiftsMapper;

	
	//シフトを新規に挿入する
	public void saveShift(Shifts shift) {

		shiftsMapper.insertShift(shift);

	}

	
	// シフトをIDで取得する
	public Shifts getShiftById(Integer id) {
		return shiftsMapper.getShiftById(id);

	}

	
	// 全てのシフトを取得する
	public List<Shifts> getAllShifts() {

		return shiftsMapper.getAllShifts();
	}

	
	// シフトをIDで更新する
	public void updateShift(Shifts shift) {
		shiftsMapper.updateShift(shift);

	}

	
	// シフトをIDで削除する
	public void deleteShift(Integer id) {
		shiftsMapper.deleteShift(id);



	}


}
