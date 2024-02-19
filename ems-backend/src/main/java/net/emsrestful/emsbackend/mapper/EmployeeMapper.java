package net.emsrestful.emsbackend.mapper;

import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.entity.Employee;

public class EmployeeMapper {
//    this is map EmployeeDto to Employee and vice versa
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getAddress(),
                employee.getPhone()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getAddress(),
                employeeDto.getPhone()
        );
    }
}
