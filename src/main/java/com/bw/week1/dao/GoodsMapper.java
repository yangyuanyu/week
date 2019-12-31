package com.bw.week1.dao;

import java.util.List;

import com.bw.week1.domain.Brand;
import com.bw.week1.domain.Goods;
import com.bw.week1.domain.Type;

public interface GoodsMapper {

	List<Goods> list(Goods goods);
	
	int insert (Goods goods);
	List<Type> selectTypes();
	List<Brand> selectBrands();

	Goods toUpdate(int gid);

	Object update(Goods goods);

	List<Goods> getList(int gid, Goods goods);

	void delAll(int[] ids);
}
