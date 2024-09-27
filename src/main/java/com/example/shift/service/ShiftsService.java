package com.example.shift.service;

//import java.math.BigDecimal;
import java.util.List;

import com.example.shift.entity.Shifts;

public interface ShiftsService {

	void saveShift(Shifts shift);//シフトを新規に挿入する

	Shifts getShiftById(Integer id);// シフトをIDで取得する

	List<Shifts> getAllShifts();// 全てのシフトを取得する

	void updateShift(Shifts shift);// シフトをIDで更新する

	void deleteShift(Integer id);// シフトをIDで削除する
	
//	void setHourlyWage(BigDecimal hourlyWage);

}
