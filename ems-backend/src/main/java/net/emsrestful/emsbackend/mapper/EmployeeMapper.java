package net.emsrestful.emsbackend.mapper;

import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.entity.Employee;

public class EmployeeMapper {
//    this is map EmployeeDto to Employee and vice versa
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getAddress(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhone(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getAddress(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getPhone(),
                employeeDto.getEmail()
        );
    }
}
