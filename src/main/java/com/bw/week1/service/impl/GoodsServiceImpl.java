package com.bw.week1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.week1.dao.GoodsMapper;
import com.bw.week1.domain.Brand;
import com.bw.week1.domain.Goods;
import com.bw.week1.domain.Type;
import com.bw.week1.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> list(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.list(goods);
	}

	@Override
	public int insert(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.insert(goods);
	}

	@Override
	public List<Type> selectTpes() {
		// TODO Auto-generated method stub
		return goodsMapper.selectTypes();
	}

	@Override
	public List<Brand> selectBrands() {
		// TODO Auto-generated method stub
		return goodsMapper.selectBrands();
	}

	@Override
	public void update(Goods goods) {
		goodsMapper.update(goods);
	}
	@Override
	public void delAll(int[] ids) {
		goodsMapper.delAll(ids);
	}
	@Override
	public Goods toUpdate(int gid) {
		return goodsMapper.toUpdate(gid);
	}
}
