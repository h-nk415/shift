package com.example.shift.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
@ControllerAdvice
public class ShiftsController {

	private final ShiftsService shiftsService;

	//ホーム画面
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("home", shiftsService.getAllShifts());
		return "shift/home";
	}

	//登録画面の表示
	@GetMapping("/form")
	public String form(@ModelAttribute ShiftForm form) {
		form.setIsNew(true);
		return "shift/form";
	}	



	//登録実行
	@PostMapping("/save")
	public String save(@Validated ShiftForm form, BindingResult bindingResult, RedirectAttributes attributes) {

		//入力チェック
		if(bindingResult.hasErrors()) {
			form.setIsNew(true);

			return "shift/form";
		}

		// 開始時間と終了時間のチェック
		if (!form.isStartTimeBeforeEndTime()) {
			bindingResult.rejectValue("startHour", "error.startTime", "開始時間は終了時間よりも前でなければなりません");
			form.setIsNew(true);
			return "shift/form";
		}


		//エンティティへ変換
		Shifts shift = ShiftHelper.convertShift(form);
		
		//登録実行
		shiftsService.saveShift(shift);

		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "シフトが登録されました");

		//PRGパターン
		return "redirect:/shift/home";
	}


	//修正画面の表示
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model, RedirectAttributes attributes) {

		//IDに対応するシフトを取得
		Shifts target = shiftsService.getShiftById(id);


		if(target != null) {
			//データがあればフォームに変換
			ShiftForm form = ShiftHelper.convertShiftForm(target);

			//モデルに格納
			model.addAttribute("shiftForm", form);
			return "shift/form";
		} else {
			//データがない場合フラッシュメッセージを表示
			attributes.addFlashAttribute("message", "対象データがありません");

			//PRGパターン
			return "redirect:/shift/home";
		}

	}

	//修正実行
	@PostMapping("/update")
	public String update(@Validated ShiftForm form, BindingResult bindingResult,  RedirectAttributes attributes) {

		//入力チェック
		if(bindingResult.hasErrors()) {
			form.setIsNew(false);
			return "shift/form";
		}

		//エンティティへ変換
		Shifts shift = ShiftHelper.convertShift(form);

		//更新実行
		shiftsService.updateShift(shift);

		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "シフトが更新されました");

		//PRGパターン
		return "redirect:/shift/home";
	}

	//削除
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, Model model, RedirectAttributes attributes) {

		//IDに対応するシフトを削除
		shiftsService.deleteShift(id);

		//フラッシュメッセージ
		attributes.addFlashAttribute("message", "シフトが削除されました");

		//PRGパターン
		return "redirect:/shift/home";


	}

}
