package com.example.shift.service.impl;

//import java.math.BigDecimal;
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
	//シフトを新規に挿入する
	public void saveShift(Shifts shift) {

		//計算結果をフィールドにセット
		//		shift.calculateTotalHours();
		//
		
		
		shiftsMapper.insertShift(shift);

	}

	@Override
	// シフトをIDで取得する
	public Shifts getShiftById(Integer id) {
		return shiftsMapper.getShiftById(id);

	}

	@Override
	// 全てのシフトを取得する
	public List<Shifts> getAllShifts() {

		return shiftsMapper.getAllShifts();
	}

	@Override
	// シフトをIDで更新する
	public void updateShift(Shifts shift) {
		shiftsMapper.updateShift(shift);

	}

	@Override
	// シフトをIDで削除する
	public void deleteShift(Integer id) {
		shiftsMapper.deleteShift(id);

	
	
}

	//	@Override
	//	// 時給の更新メソッド
	//	public void setHourlyWage(BigDecimal hourlyWage) {
	//		shiftsMapper.setShiftHourlyWage(hourlyWage);
	//		
	//	}

}
