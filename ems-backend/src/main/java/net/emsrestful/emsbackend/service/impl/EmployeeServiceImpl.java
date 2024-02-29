package net.emsrestful.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.entity.Employee;
import net.emsrestful.emsbackend.exception.ResourceNotFound;
import net.emsrestful.emsbackend.mapper.EmployeeMapper;
import net.emsrestful.emsbackend.repo.EmployeeRepo;
import net.emsrestful.emsbackend.service.EmployeeService;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

//        we need to convert employeedto into jpa enity
//        to store employe entiy into db

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepo.save(employee);


        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
//    This is give us details of emp using employeeid
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId)
                .orElseThrow(() -> 
                        new ResourceNotFound("Employee doesn't exists : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepo.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {

       Employee employee = employeeRepo.findById(employeeId).orElseThrow(
                () -> new ResourceNotFound("Employee not found" + employeeId)
//        Its better if we use ResourceNotFoundException instead of old concept
                );
       employee.setFirstName(updateEmployee.getFirstName());
       employee.setLastName(updateEmployee.getLastName());
       employee.setEmail(updateEmployee.getEmail());
       employee.setPhone(updateEmployee.getPhone());
       employee.setAddress(updateEmployee.getAddress());

       Employee updatedEmployeeObj = employeeRepo.save(employee);
//       This save keyword will update+save also will be able to insert id if is absent
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }
}
