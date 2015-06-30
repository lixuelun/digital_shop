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
		
		System.out.println("befor   inser");
		Session session = sessionFactory.getCurrentSession();
		session.save(product);	
//		sessionFactory.getCurrentSession().persist(product);
		System.out.println("after   inser");
	}
	
	public List<Product> searchProductByCategory(String category){
		
		String hql="from Product as pro where pro.proCategoryid = '"+category+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

	public boolean register(String re_name, String re_pass, String re_adds,
			String re_mail, String re_tel) {
		String hql1="from Member as ac where ac.memName='"+re_name+"'";
		List<Product> clist=sessionFactory.getCurrentSession().createQuery(hql1).list();
		if(clist.size()!=0)
			return false;
		Member member=new Member();
		member.setMemAdds(re_adds);
		member.setMemMail(re_mail);
		member.setMemName(re_name);
		member.setMemPass(re_pass);
		member.setMemTel(re_tel);
		sessionFactory.getCurrentSession().persist(member);
		String hql2="from Member as ac where ac.memName='"+re_name+"' and ac.memPass='"+re_pass+"' and ac.memAdds='"+re_adds+"' and ac.memMail='"+re_mail+"' and ac.memTel='"+re_tel+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		if(list.size()==0)
			return false;
		else
			return true;
	}
}
