package com.example.shift.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.shift.entity.Shifts;
import com.example.shift.form.ShiftForm;
import com.example.shift.helper.ShiftHelper;
import com.example.shift.service.ShiftsService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/shift")
public class ShiftsController {
	
	private final ShiftsService shiftsService;
	
	//ホーム画面
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("home", shiftsService.getAllShifts());
		return "shift/home";
	}
	
	//登録画面
	@GetMapping("/form")
	public String form(@ModelAttribute ShiftForm form) {
		form.setIsNew(true);
		return "shift/form";
	}	
	
	//登録実行
	@PostMapping("/save")
	public String save(@ModelAttribute ShiftForm form, RedirectAttributes attributes) {
		// 年、月、日を取得
	    int year = form.getYear();
	    int month = form.getMonth();
	    int day = form.getDay();

	    // LocalDateオブジェクトを作成
	    LocalDate shiftDate = LocalDate.of(year, month, day);
	    
	    
	    //開始時間を取得
	    int startHour = form.getStartHour();
	    int startMinute = form.getStartMinute();
	    
	    //LocalTimeオブジェクトを作成
	    LocalTime startTime = LocalTime.of(startHour,startMinute);
		
	  //終了時間を取得
	    int endHour = form.getEndHour();
	    int endMinute = form.getEndMinute();
	    
	    //LocalTimeオブジェクトを作成
	    LocalTime endTime = LocalTime.of(endHour,endMinute);
	    
		Shifts shift = ShiftHelper.convertShift(form);
		
		shift.setShiftDate(shiftDate);
		shift.setStartTime(startTime);
		shift.setEndTime(endTime);
		shiftsService.saveShift(shift);
		attributes.addFlashAttribute("message", "シフトが登録されました");
		return "redirect:/shift/home";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Shifts target = shiftsService.getShiftById(id);
		if(target != null) {
			ShiftForm form = ShiftHelper.convertShiftForm(target);
			model.addAttribute("shiftForm", form);
			return "shift/form";
		} else {
			attributes.addFlashAttribute("message", "対象データがありません");
			return "redirect:/shift/home";
		}
		
	}
	
	@PostMapping("/update")
	public String update(ShiftForm form, RedirectAttributes attributes) {
		Shifts shift = ShiftHelper.convertShift(form);
		shiftsService.updateShift(shift);
		attributes.addFlashAttribute("message", "シフトが更新されました");
		return "redirect:/shift/home";
	}
	
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Shifts target = shiftsService.deleteShift(id);
		if(target != null) {
		attributes.addFlashAttribute("message", "シフトが削除されました");
		return "redirect:/shift/home";
		}else {
			attributes.addFlashAttribute("message", "対象データがありません");
			return "redirect:/shift/home";
		}
		
	}

}
