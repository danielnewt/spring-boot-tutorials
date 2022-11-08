package com.example.restapi.exampleRestApi.payroll.employees;

import org.springframework.data.jpa.repository.JpaRepository;

interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
