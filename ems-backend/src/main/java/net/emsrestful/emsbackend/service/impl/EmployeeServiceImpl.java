package net.emsrestful.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.entity.Employee;
import net.emsrestful.emsbackend.exception.ResourceNotFound;
import net.emsrestful.emsbackend.mapper.EmployeeMapper;
import net.emsrestful.emsbackend.repo.EmployeeRepo;
import net.emsrestful.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

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
}
