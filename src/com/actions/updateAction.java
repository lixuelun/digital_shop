package com.actions;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.services.*;
public class updateAction extends ActionSupport {

	Product product;
	@Resource
	private updateService updateService;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	//����ύ��ť��ִ�еķ���
	public String updateProduct(){
		
		// �ж��Ƿ������Ƿ�����
//		if(!product.getProPrice().equals(float.class) && !product.getClass().equals(float.class)){
//			return INPUT;
//		}
		
		// �ϴ�ͼƬ
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//�������ڸ�ʽ
		String now = df.format(new Date());
		
		try{
			System.out.println("����ͼƬ�洢");
			System.out.println("FileInputStream֮ǰ��"+product.getProImg());
			FileInputStream fi=new FileInputStream(product.getProImg());
			System.out.println("FileInputStream֮��"+product.getProImg());
			BufferedInputStream in=new BufferedInputStream(fi);
			
			product.setProImg((now+".jpg").toString());
			System.out.println(product.getProImg());
	  
			  FileOutputStream fo=new FileOutputStream("D:/JavaEE Tools/Tomcat/apache-tomcat-6.0.29/webapps/digital_shop/images/"+product.getProImg());
			  
			  BufferedOutputStream out=new BufferedOutputStream(fo);
			  byte[] buf=new byte[1024];
			  int len=in.read(buf);
			  while(len!=-1){
			   out.write(buf, 0, len);
			   len=in.read(buf);
			  }
			  out.close();
			  fo.close();
			  in.close();
			  fi.close();

			  
			  // ��������
			  product.setProDate(now);
			  updateService.insertIntoTableWithProduct(product);
//			  System.out.println("try test------------------------");
			  
			  return SUCCESS;
			
		}catch (Exception e){
			
//			  System.out.println("catch test------------------------");

			return SUCCESS;
		}
		
	}

	public updateService getProductService() {
		return updateService;
	}

	public void updateService(updateService updateService) {
		this.updateService = updateService;
	}
}
