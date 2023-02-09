package com.kjnext.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.model.Product;
import com.kjnext.model.UserTo;
import com.kjnext.service.ManageMasterServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class ManageMasterAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<String, String> mapMenu = null;

	List<RaProductMaster> listProduct = null;

	ManageMasterServiceImpl manageMasterServiceImpl = new ManageMasterServiceImpl();

	RaProductMaster raProductMaster;
	String navigationFlg;
	public String loadMenu() {
		return SUCCESS;
	}

	public Map<String, String> getMapMenu() {
		return mapMenu;
	}

	public void setMapMenu(Map<String, String> mapMenu) {
		this.mapMenu = mapMenu;
	}

	public String loadProducts() {
		listProduct = manageMasterServiceImpl.getProductList();
		if (!listProduct.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	public String addProductInput() {
		return SUCCESS;
	}
	public String addProduct() {
		//UserTo user=(UserTo) session.get("UserInfo");
		//System.out.println(user.getUserId());
		if(isProductExist(raProductMaster)){
			addActionError(getText("error.duplicate.value"));
			return SUCCESS;
		}
		manageMasterServiceImpl.addProduct(raProductMaster);
		loadProducts();
		setNavigationFlg("success");
		return SUCCESS;
	}

	private boolean isProductExist(RaProductMaster raProductMaster2) {
		boolean exist=false;
		return manageMasterServiceImpl.isProductExist(raProductMaster2);
	}

	public String updateProductInput() {
		System.out.println("product Id printed.for updating.." + raProductMaster.getProductId());
		
		raProductMaster=manageMasterServiceImpl.loadSingleProduct(raProductMaster.getProductId());
		return SUCCESS;
	}

	public String updateProduct() {
		
		if(isProductExist(raProductMaster)){
			addActionError(getText("error.duplicate.value"));
			return SUCCESS;
		}
		raProductMaster.setProductStatus("Active");
		manageMasterServiceImpl.updateProduct(raProductMaster);
		loadProducts();
		setNavigationFlg("success");
		return SUCCESS;
	}

	public String deleteProduct() {
		System.out.println("deleteProcess");
	//	System.out.println("product Id printed.for deleting.." + raProductMaster.getProductId());
		System.out.println(raProductMaster+"...........");
		manageMasterServiceImpl.deleteProduct(raProductMaster.getProductId());
		System.out.println("product Id printed.for deleting.." + raProductMaster.getProductId());
		System.out.println("nextProcess");
		loadProducts();
		return SUCCESS;
		
	}
	public List<RaProductMaster> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<RaProductMaster> listProduct) {
		this.listProduct = listProduct;
	}

	

	public String getNavigationFlg() {
		return navigationFlg;
	}

	public void setNavigationFlg(String navigationFlg) {
		this.navigationFlg = navigationFlg;
	}

	public RaProductMaster getRaProductMaster() {
		return raProductMaster;
	}

	public void setRaProductMaster(RaProductMaster raProductMaster) {
		this.raProductMaster = raProductMaster;
	}

}
