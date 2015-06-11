package com.dao;

import java.util.List;

import com.domain.Member;
import com.domain.Product;

public interface ProductDao {
	//���������ť��ִ�еķ���
	public List<Product> searchProductBySearchBox(String searchBox);
	
	//�����Ʒ�б�ִ�еķ���
	public List<Product> searchProductByName(String name);
	
	//������빺�ﳵ��ťִ�еķ���
	public boolean addShoppingCart(String img,String name,double price,int quantity,String username);

	//��ȡ�û���Ϣ
	public List<Member> searchMemberByName(String name);
	
	//�޸��û�����
	public boolean updateMemPass(String name, String newMemPass);

	//�޸��û���ַ
	public boolean updateMemAdds(String name, String newMemAdds);

	//�޸��û�e-mail
	public boolean updateMemMail(String name, String newMemMail);
	
	//�޸��û��绰
	public boolean updateMemTel(String name, String newMemTel);
}
