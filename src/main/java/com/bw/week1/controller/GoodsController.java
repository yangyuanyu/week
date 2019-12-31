package com.bw.week1.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bw.week1.domain.Brand;
import com.bw.week1.domain.Goods;
import com.bw.week1.domain.Type;
import com.bw.week1.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping("/list")
	public String list(Goods goods,Model model,@RequestParam(defaultValue="1")int pageNum) {
		PageHelper.startPage(pageNum, 3);
		List<Goods> list=goodsService.list(goods);
		PageInfo<Goods> pageInfo=new PageInfo<>(list);
		model.addAttribute("pg", pageInfo);
		model.addAttribute("g", goods);
		return "list";
	}
	
	@GetMapping("add")
	public String add() {
		return "add";
	}
	@ResponseBody
	@RequestMapping("add")
	public boolean add(Goods goods,MultipartFile file) {
		if (null !=file && !file.isEmpty()) {
			String path="d:/week1/";
			String oldFileName=file.getOriginalFilename();
			String fileName=UUID.randomUUID() + oldFileName.substring(oldFileName.lastIndexOf("."));
			File f=new File(path,fileName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return goodsService.insert(goods)>0;
	}
	
	@ResponseBody
	@GetMapping("selectTypes")
	public List<Type> selectTypes(){
		return goodsService.selectTpes();
	}
	
	@ResponseBody
	@GetMapping("selectBrands")
	public List<Brand> selectBrands(){
		return goodsService.selectBrands();
	}
	
	@RequestMapping("/toUpdate")
	public String toUpdate(@RequestParam("gid")int gid,Model model) {
		Goods goods=goodsService.toUpdate(gid);
		model.addAttribute("g",goods);
		return "update";
   }
	@RequestMapping("/update")
	public String update(Goods goods) {
		goodsService.update(goods);
		return "redirect:list";
	}
	
	@RequestMapping("/delAll")
	public String delAll(int[] ids) {
		goodsService.delAll(ids);
		return "redirect:list";
	}
}
