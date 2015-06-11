package com.dao;

import java.util.List;

import com.domain.Member;
import com.domain.Product;

public interface ProductDao {
	//点击搜索按钮会执行的方法
	public List<Product> searchProductBySearchBox(String searchBox);
	
	//点击商品列表执行的方法
	public List<Product> searchProductByName(String name);
	
	//点击加入购物车按钮执行的方法
	public boolean addShoppingCart(String img,String name,double price,int quantity,String username);

	//获取用户信息
	public List<Member> searchMemberByName(String name);
	
	//修改用户密码
	public boolean updateMemPass(String name, String newMemPass);

	//修改用户地址
	public boolean updateMemAdds(String name, String newMemAdds);

	//修改用户e-mail
	public boolean updateMemMail(String name, String newMemMail);
	
	//修改用户电话
	public boolean updateMemTel(String name, String newMemTel);
}
