package com.kjnext.service;

import java.util.List;

import com.kjnext.dao.ManageMasterDao;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.model.Product;

public class ManageMasterServiceImpl {

	ManageMasterDao manageMasterDao=new ManageMasterDao();
	
	public List<RaProductMaster> getProductList(){
		List<RaProductMaster> listProducts=manageMasterDao.getProducts();
		return listProducts;
	}

	public int addProduct(RaProductMaster product) {
		
		//is already exist 
		return manageMasterDao.addProduct(product);
	}

	public int updateProduct(RaProductMaster product) {
		return manageMasterDao.updateProduct(product);		
	}

	public RaProductMaster loadSingleProduct(int productId) {
		return manageMasterDao.loadSingleProduct(productId);			
	}

	public void deleteProduct(Integer productId) {
		manageMasterDao.deleteProduct(productId);
					
	}

	public boolean isProductExist(RaProductMaster raProductMaster2) {
		
		return manageMasterDao.isProductExist(raProductMaster2);
	}
}
