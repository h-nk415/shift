package com.example.shift.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.shift.entity.Shifts;

@Mapper
public interface ShiftsMapper {
	void insertShift(Shifts shift); //シフトを新規に挿入する
    Shifts getShiftById(Integer id); // シフトをIDで取得する
    List<Shifts> getAllShifts(); // 全てのシフトを取得する
    void updateShift(Shifts shift); // シフトをIDで更新する
    void deleteShift(Integer id); // シフトをIDで削除する
    void updateShiftHourlyWage(Shifts shift); // 時給の更新メソッド

}
