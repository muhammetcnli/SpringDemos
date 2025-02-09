package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        // get the employee from db

        List<Employee> theEmployees = employeeService.findAll();

        // add that to the model
        model.addAttribute("employees", theEmployees);

        return "employees/list-employees";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        Employee theEmployee = new Employee();

        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model){

        Employee theEmployee = employeeService.findById(theId);

        model.addAttribute("employee", theEmployee);
        return "employees/employee-form";
    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theeId, Model model){

        employeeService.deleteById(theeId);
        return "redirect:/employees/list";


    }
}
