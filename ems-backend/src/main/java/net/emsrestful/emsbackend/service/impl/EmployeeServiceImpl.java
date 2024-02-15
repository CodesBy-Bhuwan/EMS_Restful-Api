package net.emsrestful.emsbackend.service.impl;

import lombok.AllArgsConstructor;
import net.emsrestful.emsbackend.dto.EmployeeDto;
import net.emsrestful.emsbackend.repo.EmployeeRepo;
import net.emsrestful.emsbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return null;
    }
}
