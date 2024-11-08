package com.example.shift.controller;

import java.time.LocalDate;

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
        LocalDate currentDate = LocalDate.now();
        model.addAttribute("currentDate", currentDate);
        model.addAttribute("home", shiftsService.getAllShifts());
        return "shift/home";
    }
    
    //IDの詳細表示
    @GetMapping("/{id}")
    public String detail(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
        Shifts shift = shiftsService.getShiftById(id);
        if(shift != null) {
            model.addAttribute("shift", shift);
            return "shift/detail";
        } else {
            attributes.addFlashAttribute("message", "対象データがありません");
            return "redirect:/shift/home";
        }
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
        if(bindingResult.hasErrors()) {
            form.setIsNew(true);
            return "shift/form";
        }

        if (!form.isStartTimeBeforeEndTime()) {
            bindingResult.rejectValue("startHour", "error.startTime", "開始時間は終了時間よりも前でなければなりません");
            form.setIsNew(true);
            return "shift/form";
        }

        Shifts shift = ShiftHelper.convertShift(form);
        shiftsService.saveShift(shift);
        attributes.addFlashAttribute("message", "シフトが登録されました");
        return "redirect:/shift/home";
    }

    //修正画面の表示
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

    //修正実行
    @PostMapping("/update")
    public String update(@Validated ShiftForm form, BindingResult bindingResult,  RedirectAttributes attributes) {
        if(bindingResult.hasErrors()) {
            form.setIsNew(false);
            return "shift/form";
        }

        if (!form.isStartTimeBeforeEndTime()) {
            bindingResult.rejectValue("startHour", "error.startTime", "開始時間は終了時間よりも前でなければなりません");
            form.setIsNew(false);
            return "shift/form";
        }

        Shifts shift = ShiftHelper.convertShift(form);
        shiftsService.updateShift(shift);
        attributes.addFlashAttribute("message", "シフトが更新されました");
        return "redirect:/shift/home";
    }

    //削除
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, RedirectAttributes attributes) {
        shiftsService.deleteShift(id);
        attributes.addFlashAttribute("message", "シフトが削除されました");
        return "redirect:/shift/home";
    }
}