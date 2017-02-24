package com.wolver.employee.service;

import com.wolver.employee.entity.Employee;
import com.wolver.employee.entity.PageBean;

/**
 * 员工管理的业务层接口
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
