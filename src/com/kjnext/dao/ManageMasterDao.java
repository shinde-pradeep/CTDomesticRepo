package com.kjnext.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Expression;

import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaUserMaster;
import com.kjnext.model.Product;
import com.kjnext.utility.hibernate.HibernateUtil;

public class ManageMasterDao {

	// take from DB
	static List<RaProductMaster> listProduct = new ArrayList<RaProductMaster>();

	public List<RaProductMaster> getProducts() {
		
			List list=HibernateUtil.getSession().createCriteria(RaProductMaster.class).list();
			listProduct=list;
		
		
		return listProduct;
	}

	// add to DB from Hibernate
	public int addProduct(RaProductMaster product) {
		//listProduct.add(product);
		//product.setProductId(listProduct.size());
		product.setProductStatus("Active");
		
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.save(product);
		transaction.commit();
		return product.getProductId();
	}

	public int updateProduct(RaProductMaster product) {
		//listProduct.set(product.getProductId(), product);
		System.out.println("updt roduct"+product.getProductId());
		HibernateUtil.closeSession();
		Session session= HibernateUtil.getSession();
		Transaction transaction=session.beginTransaction();
		session.saveOrUpdate(product);
		transaction.commit();
		return product.getProductId();
	}

	public RaProductMaster loadSingleProduct(int productId) {
		// return (RaProductMaster)listProduct.get(productId-1);
		
		
		
		System.out.println("Product ID........" + productId);
		RaProductMaster raProductMaster = (RaProductMaster) HibernateUtil
				.getSession().load(RaProductMaster.class, productId);
		return raProductMaster;

	}

	public void deleteProduct(Integer productId) {
		if(productId>0){
		
			HibernateUtil.closeSession();
			Session session= HibernateUtil.getSession();
			Transaction transaction=session.beginTransaction();
			RaProductMaster product=(RaProductMaster)session.load(RaProductMaster.class,productId );
			product.setProductStatus("Dactive");
			session.saveOrUpdate(product);
			transaction.commit();

			
			
		/*	RaProductMaster product=(RaProductMaster)HibernateUtil.getSession().load(RaProductMaster.class,productId );
			product.setProductStatus("Dactive");
			HibernateUtil.getSession().saveOrUpdate(product);
			HibernateUtil.commitTransaction();
			*/
			
		}
		

	}

	public boolean isProductExist(RaProductMaster raProductMaster2) {
		try {

			List<RaProductMaster> list = (ArrayList<RaProductMaster>) HibernateUtil
					.getSession().createCriteria(RaProductMaster.class).add(
							Expression.eq("productType", raProductMaster2
									.getProductType())).list();
			if (list.isEmpty()) {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}