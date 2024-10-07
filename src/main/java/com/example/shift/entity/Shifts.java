package com.example.shift.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class Shifts {

	/** ID */
	private Integer id;
	
	/** シフト日 */
	private LocalDate shiftDate;
	/** 開始時間 */
	private LocalTime startTime;
	/** 終了時間 */
	private LocalTime endTime;
	/** 休憩時間 */
	private LocalTime breakTime;
    

}
