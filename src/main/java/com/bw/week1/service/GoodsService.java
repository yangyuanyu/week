package com.bw.week1.service;

import java.util.List;

import com.bw.week1.domain.Brand;
import com.bw.week1.domain.Goods;
import com.bw.week1.domain.Type;

public interface GoodsService {

	List<Goods> list(Goods goods);

	int insert(Goods goods);

	List<Type> selectTpes();

	List<Brand> selectBrands();

	Goods toUpdate(int gid);

	void update(Goods goods);

	void delAll(int[] ids);
	
	
}
