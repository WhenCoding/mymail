package cn.e3.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3.manager.service.ItemCatService;
import cn.e3.mapper.TbItemCatMapper;
import cn.e3.pojo.TbItemCat;
import cn.e3.pojo.TbItemCatExample;
import cn.e3.pojo.TbItemCatExample.Criteria;
import cn.e3.utils.TreeNode;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper mapper;
	@Override
	public List<TreeNode> findItemCatList(Long parentId) {
		//创建集合，封装树形列表
		List<TreeNode> treeList = new ArrayList<>();
		//根据父Id查询商品类别
		//创建example对象:类似hibernate的qbc查询
		TbItemCatExample example = new TbItemCatExample();
		Criteria criteria = example.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		List<TbItemCat> list = mapper.selectByExample(example);
		
		for (TbItemCat tbItemCat : list) {
			TreeNode treeNode = new TreeNode();
			treeNode.setId(tbItemCat.getId());
			//节点状态，'open' 不能继续打开，没有子节点 或 'closed'可以打开,即是还有子节点
			treeNode.setState(tbItemCat.getIsParent()?"closed":"open");
			treeNode.setText(tbItemCat.getName());
			treeList.add(treeNode);
		}
		return treeList;
	}

}
