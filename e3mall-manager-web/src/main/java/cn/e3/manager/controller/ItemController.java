package cn.e3.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3.manager.service.ItemService;
import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

@Controller
public class ItemController {

	@Autowired
	private ItemService service;
	/**
	 * 根据id查询商品
	 * @param itemId
	 * @return
	 */
	@RequestMapping("item/{itemId}")
	@ResponseBody
	public TbItem findById(@PathVariable("itemId") Long itemId){
		return service.findById(itemId);
	}
	
	/**
	 * 分页查询所有商品
	 */
	@RequestMapping("item/list")
	@ResponseBody
	public DatagridPagebean findItemListByPageBean(@RequestParam(defaultValue="1") Integer page,
			 @RequestParam(defaultValue="30") Integer rows){
		return service.findItemListByPageBean(page,rows);
	}
}
