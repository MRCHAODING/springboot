package com.atdc.springboottest.controller;

import com.atdc.springboottest.dao.DepartmentDao;
import com.atdc.springboottest.dao.EmployeeDao;
import com.atdc.springboottest.pojo.Department;
import com.atdc.springboottest.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> allEmployee = employeeDao.getAllEmployee();
        model.addAttribute("emps", allEmployee);
        return "list";
    }

    @GetMapping("/empsadd")
    public String toAddpage(Model model) {
        Collection<Department> departMents = departmentDao.getDepartMents();
        model.addAttribute("departments",departMents);
        return "add";
    }
    @PostMapping("/emps")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id,Model model){
        System.out.println("debug"+id);
        Employee employeeByid = employeeDao.getEmployeeByid(id);
        System.out.println(employeeByid);
        model.addAttribute("emp",employeeByid);
        Collection<Department> departMents = departmentDao.getDepartMents();
        model.addAttribute("departments",departMents);
        return "update";
    }
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    @GetMapping("/deleemp/{id}")
    public String deleteemp(@PathVariable("id")Integer id){
        employeeDao.deleteEmployeeByid(id);
        return "redirect:/emps";

    }
}
