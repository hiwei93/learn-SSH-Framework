package com.wolver.employee.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wolver.employee.entity.Department;
import com.wolver.employee.entity.PageBean;
import com.wolver.employee.service.DepartmentService;
/**
 * 部门管理的Action类
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {

	// 模型驱动使用的对象：
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	// 注入部门管理的Service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// 提供分页查询方法：
	public String findAll() {
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		// 将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}	
	
	// 跳转到添加部门的页面方法：
	public String saveUI(){
		return "saveUI";
	}
	
	// 添加部门的方法：
	public String save() {
		departmentService.save(department);
		return "saveSuccess";
	}
	
	// 编辑部门的方法
	public String edit() {
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	// 修改部门的方法
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
	}
	
	// 删除部门的发发
	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}

}
