package com.wei.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.wei.domain.Product;
import com.wei.service.ProductService;

/**
 * 商品管理的Action类
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	// 模型驱动使用的类
	private Product product = new Product();
	@Override
	public Product getModel() {
		return product;
	}
	
	// Struts2和Spring整合过程中按名称自动注入的业务层类
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	/**
	 * 保存商品的执行方法：save
	 */
	public String save(){
		System.out.println("Action中放入save方法执行了...");
		productService.save(product);
		return NONE;
	}

}
