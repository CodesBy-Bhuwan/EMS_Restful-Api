package net.emsrestful.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController //will be to handle http req
@RequestMapping("/api/employees") //to def base url for all the http's
public class EmployeeController {

    private EmployeeService employeeService;

//Area to build Add_Employee Rest api
    @PostMapping //to map incoming http post req to this method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
//        @requestBody will extract json from json and convert json into employeedto java obj
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

//    Area to build Emp  Rest api
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
//        Annoting path var due to id->uri and employeeId are named different so to prescribe them as single thing
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
//    Area to get ALLEmp Rest api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

}
