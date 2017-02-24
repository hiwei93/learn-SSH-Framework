package com.wei.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.wei.domain.Product;

/**
 * 商品管理的DAO的类
 */
public class ProductDao extends HibernateDaoSupport{

	public void save(Product product) {

		System.out.println("DAO中的save方法执行了...");
		System.out.println("product.getPname() is " + product.getPname());
		System.out.println("product.getPrice() is " + product.getPrice());
		
		this.getHibernateTemplate().save(product);
	}

}
