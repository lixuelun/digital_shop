package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Member;
import com.domain.Product;
import com.domain.ShoppingCart;

public class ProductDaoImpl implements ProductDao{
	
	@Resource
	private SessionFactory sessionFactory;

	public List<Product> searchProductBySearchBox(String searchBox) {
		
		String hql="from Product as pro where pro.proName like '%"+searchBox+"%'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public List<Product> searchProductByName(String name) {
		String hql="from Product as pro where pro.proName = '"+name+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public boolean addShoppingCart(String img, String name, double price, int quantity, String username) {
		ShoppingCart shoppingCart=new ShoppingCart();
		shoppingCart.setAdminName(username);
		shoppingCart.setImg(img);
		shoppingCart.setName(name);
		shoppingCart.setPrice(price);
		shoppingCart.setQuantity(quantity);
		sessionFactory.getCurrentSession().persist(shoppingCart);
		String hql="from ShoppingCart as ac where ac.name='"+name+"' and ac.quantity='"+quantity+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list.size()==0)
			return false;
		else
			return true;
	}

	public List<Member> searchMemberByName(String name) {
		String hql="from Member as m where m.memName = '"+name+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public boolean updateMemPass(String name, String newMemPass) {
		String hql="update Member as m set m.memPass ='"+newMemPass+"' where m.memName ='"+name+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql2="from Member as m where m.memName = '"+name+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		for(Member t:list)
			if(t.getMemPass().equals(newMemPass)){
				return true;
			}	
		return false;
	}

	public boolean updateMemAdds(String name, String newMemAdds) {
		String hql="update Member as m set m.memAdds ='"+newMemAdds+"' where m.memName ='"+name+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql2="from Member as m where m.memName = '"+name+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		for(Member t:list)
			if(t.getMemAdds().equals(newMemAdds)){
				return true;
			}	
		return false;
	}

	public boolean updateMemMail(String name, String newMemMail) {
		String hql="update Member as m set m.memMail ='"+newMemMail+"' where m.memName ='"+name+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql2="from Member as m where m.memName = '"+name+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		for(Member t:list)
			if(t.getMemMail().equals(newMemMail)){
				return true;
			}	
		return false;
	}

	public boolean updateMemTel(String name, String newMemTel) {
		String hql="update Member as m set m.memTel ='"+newMemTel+"' where m.memName ='"+name+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql2="from Member as m where m.memName = '"+name+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		for(Member t:list)
			if(t.getMemMail().equals(newMemTel)){
				return true;
			}	
		return false;
	}
	
	// simpleem
	// 插入一条数据
	public void insertIntoTableWithProduct(Product product){
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(product);	
	}
	
	// 查找分类
	public List<Product> searchProductByCategory(String category){
		
		String hql="from Product as pro where pro.proCategoryid = '"+category+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
}
