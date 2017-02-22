package com.bsit.model;

import java.util.List;

public class LeftMenu {
	
	private SysFunction menu;
	
	private List<SysFunction> sonMenu;

	public SysFunction getMenu() {
		return menu;
	}

	public void setMenu(SysFunction menu) {
		this.menu = menu;
	}

	public List<SysFunction> getSonMenu() {
		return sonMenu;
	}

	public void setSonMenu(List<SysFunction> sonMenu) {
		this.sonMenu = sonMenu;
	}

}
