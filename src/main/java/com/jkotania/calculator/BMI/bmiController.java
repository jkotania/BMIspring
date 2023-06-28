package com.jkotania.calculator.BMI;

import com.jkotania.calculator.Controller.calc;
import com.jkotania.calculator.BMI.BmiEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class bmiController {

    private final BmiEntryRepository bmiEntryRepository;

    @Autowired
    public bmiController(BmiEntryRepository bmiEntryRepository) {
        this.bmiEntryRepository = bmiEntryRepository;
    }

    @GetMapping("/index")
    public String viewForm(Model model) {
        model.addAttribute("calc", new calc());
        return "index";
    }

    @PostMapping("/calc")
    public String calculateForm(@ModelAttribute calc calc, BindingResult result, Model model) {
        model.addAttribute("calc", calc);

        // Przykład zapisu wpisu BMI do bazy danych
        BmiEntry bmiEntry = new BmiEntry();
        // Ustawienie wartości BMIEntry na podstawie obiektu calc
        bmiEntry.setWeight(calc.getWeight());
        bmiEntry.setHeight(calc.getHeight());
        bmiEntryRepository.save(bmiEntry);

        return "bmi";
    }

}
