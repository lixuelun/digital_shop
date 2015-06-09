package com.services;

import java.util.List;

import com.domain.Back;

public interface backService {
	public interface ProductService {
		//点击提交申请回插入数据
		public List<Back> commitOfBack();
	}

}
