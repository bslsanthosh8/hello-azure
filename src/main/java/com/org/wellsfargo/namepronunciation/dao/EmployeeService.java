package com.org.wellsfargo.namepronunciation.dao;

import com.org.wellsfargo.namepronunciation.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeService extends JpaRepository<Employee, String> {
}
