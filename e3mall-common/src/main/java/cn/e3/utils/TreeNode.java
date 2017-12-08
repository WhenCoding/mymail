package cn.e3.utils;

import java.io.Serializable;

public class TreeNode implements Serializable{
	/**EasyUI 树形菜单：
	 	返回 json 固定格式数据：
		从服务器返回的数据
	    [{
		"id": 1,
		"text": "Node 1",
		"state": "closed"
		}]
	 */
	private Long id;
	private String text;
	private String state;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
