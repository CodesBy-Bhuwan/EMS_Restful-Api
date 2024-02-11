package net.emsrestful.emsbackend.repo;

import net.emsrestful.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    
}
