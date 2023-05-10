package com.example.demo.controller;

//import com.example.demo.repo.UserRepo;
import com.example.demo.models.Employee;
import com.example.demo.models.User;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {

//    private UserRepo userRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EmployeeRepo employeeRepo;
    @GetMapping("/")
    public String getPage(){
        return "Welcome To REST";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping(value = "/employee")
    public List<Employee> getEmployee(){
        return employeeRepo.findAll();
    }


    @PostMapping(value = "/save/user")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved User...";
    }
    @PostMapping(value = "/save/employee")
    public String saveEmployee(@RequestBody Employee employee){
        employeeRepo.save(employee);
        return "Saved Employee...";
    }


    @PutMapping(value = "update/user/{id}")
    public String updateUser(@PathVariable long id,@RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated user...";
    }
    @PutMapping(value = "update/employee/{id}")
    public String updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Employee updatedEmployee = employeeRepo.findById(id).get();
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setRole(employee.getRole());
        employeeRepo.save(updatedEmployee);
        return "updated employee...";
    }

    @DeleteMapping(value = "/delete/user/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete user with the id: "+id;
    }
    @DeleteMapping(value = "/delete/employee/{id}")
    public String deleteEmployee(@PathVariable long id){
        Employee deleteEmployee = employeeRepo.findById(id).get();
        employeeRepo.delete(deleteEmployee);
        return "Delete employee with the id: "+id;
    }
}
