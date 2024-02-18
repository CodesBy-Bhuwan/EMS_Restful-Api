package net.emsrestful.emsbackend.controller;

import lombok.AllArgsConstructor;
import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

}
