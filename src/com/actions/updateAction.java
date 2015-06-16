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
	
	//点击提交按钮会执行的方法
	public String updateProduct(){
		
		// 判断是否输入是否有误
//		if(!product.getProPrice().equals(float.class) && !product.getClass().equals(float.class)){
//			return INPUT;
//		}
		
		// 上传图片
		SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");//设置日期格式
		String now = df.format(new Date());
		
		try{
			System.out.println("进入图片存储");
			System.out.println("FileInputStream之前："+product.getProImg());
			FileInputStream fi=new FileInputStream(product.getProImg());
			System.out.println("FileInputStream之后："+product.getProImg());
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

			  
			  // 插入数据
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
