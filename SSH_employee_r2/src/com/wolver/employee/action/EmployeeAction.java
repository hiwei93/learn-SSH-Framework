package com.wolver.employee.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wolver.employee.entity.Department;
import com.wolver.employee.entity.Employee;
import com.wolver.employee.entity.PageBean;
import com.wolver.employee.service.DepartmentService;
import com.wolver.employee.service.EmployeeService;
/**
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	private static final long serialVersionUID = 1L;
	
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		return employee;
	}
	
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 注入业务层：
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	/**
	 * 登录执行的方法：
	 */
	public String login() {
		System.out.println("Login 执行了....");
		// 调用业务层的类：
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			// 登录失败
			this.addActionError("用户名或密码错误！");
			return INPUT;
		} else {
			// 登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	/**
	 * 分页查询员工的方法
	 */
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/**
	 * 跳转到添加员工页面的方法
	 */
	public String saveUI() {
		// 查询所有部门（需要注入DepartmentService）
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list); // 集合用set，对象用put
		return "saveUI";
	}
	
	/**
	 * 保存员工的方法
	 */
	public String save() {
		employeeService.save(employee);
		System.out.println("employee.save()" + employee);
		return "saveSuccess";
	}

	/**
	 * 编辑员工的方法
	 */
	public String edit() {
		// 根据员工ID查询员工
		employee = employeeService.findById(employee.getEid());
		// 查询所有的部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	/**
	 * 修改员工的方法
	 */
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/**
	 * 删除员工的方法
	 */
	public String delete() {
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
}
