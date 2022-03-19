package com.example.cartest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cartest.domain.Car;
import com.example.cartest.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/list")
    public void list(Model model) {
        model.addAttribute("list", carService.list());
    }

    @GetMapping("/register")
    public void registerForm(Car car, Model model) {

    }

    @PostMapping("/register")
    public String register(Model model, Car car) {
        this.carService.register(car);
        model.addAttribute("msg", "등록이 완료되었습니다.");
        return "success";
    }

    @GetMapping("/read")
    public void read(Model model, Integer id) {
        model.addAttribute(carService.read(id));
    }

    @GetMapping("/modify")
    public void modifyForm(Model model, Integer id) {
        model.addAttribute(carService.read(id));
    }

    @PostMapping("/modify")
    public String modify(Model model, Car car) {
        this.carService.modify(car);
        model.addAttribute("msg", "수정이 완료되었습니다.");
        return "success";
    }

    @PostMapping("/remove")
    public String remove(Model model, Integer id) {
        this.carService.delete(id);
        model.addAttribute("msg", "삭제가 완료되었습니다.");
        return "success";
    }
}
