package cn.e3.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3.manager.service.ItemService;
import cn.e3.mapper.TbItemMapper;
import cn.e3.pojo.TbItem;
import cn.e3.pojo.TbItemExample;
import cn.e3.utils.DatagridPagebean;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper mapper;

	@Override
	public TbItem findById(Long itemId) {
		return mapper.selectByPrimaryKey(itemId);
	}

	@Override
	public DatagridPagebean findItemListByPageBean(Integer page, Integer rows) {
		//创建example对象
		TbItemExample tbItemExample = new TbItemExample();
		//查询之前设置分页
		PageHelper.startPage(page, rows);
		//执行查询
		List<TbItem> list = mapper.selectByExample(tbItemExample);
		
		//封装分页的所有信息
		PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(list);
		//封装DatagridPagebean对象
		DatagridPagebean pagebean = new DatagridPagebean();
		pagebean.setRows(pageInfo.getList());
		pagebean.setTotal(pageInfo.getTotal());

		return pagebean;
	}
}
