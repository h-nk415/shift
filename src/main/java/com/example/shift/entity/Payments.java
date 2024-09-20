package com.example.shift.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payments {
	private Integer id;
	private int userId;            // ユーザーID
    private String month;         // 月（例: "2024-09"）
    private BigDecimal totalHours; // 合計勤務時間
    private BigDecimal totalSalary; // 合計給与

}
