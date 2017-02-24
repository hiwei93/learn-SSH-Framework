package com.wolver.employee.dao;

import java.util.List;

import com.wolver.employee.entity.Employee;

/**
 * 员工管理的DAO接口
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
