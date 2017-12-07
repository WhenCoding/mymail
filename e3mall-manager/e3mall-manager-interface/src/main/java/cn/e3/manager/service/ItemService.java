package cn.e3.manager.service;

import cn.e3.pojo.TbItem;
import cn.e3.utils.DatagridPagebean;

public interface ItemService {
	//根据id查询商品
	TbItem findById(Long itemId);
	//分页查询商品
	DatagridPagebean findItemListByPageBean(Integer page,Integer rows);
}
