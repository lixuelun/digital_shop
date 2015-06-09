package com.services;

import java.util.List;

import com.domain.Member;
import com.domain.Product;



public interface ProductService {
	//���������ť��ִ�еķ���
	public List<Product> searchProductBySearchBox(String searchBox);
	
	//�����Ʒ�б�ִ�еķ���
	public List<Product> searchProductByName(String name);
	
	//������빺�ﳵ��ťִ�еķ���
	public boolean addShoppingCart(String img,String name,double price,int quantity);
	
	//��ȡ�û���Ϣ
	public List<Member> searchMemberByName(String name);

	//�޸��û�����
	public boolean updateMemPass(String name, String newMemPass);
}
