package com.kjnext.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.kjnext.dao.ParticipatingCompanyDao;
import com.kjnext.hibernate.RaCompanyMaster;
import com.kjnext.hibernate.RaCompanyOutlet;
import com.kjnext.hibernate.RaCompanyOutletId;
import com.kjnext.hibernate.RaCompanyProduct;
import com.kjnext.hibernate.RaCompanyProductId;
import com.kjnext.hibernate.RaOutletMaster;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.model.ParticiatingComany;


public class ParticipatingCompanyServiceImpl {
	String name;
	String outlatename="";
	String productname="";
	RaCompanyMaster raCompanyMaster;
	RaOutletMaster raOutletMaster;
	RaCompanyOutlet raCompanyOutlets;
	RaCompanyProduct raCompanyProduct; 
	RaCompanyProductId raCompanyProductId;
	RaCompanyOutletId raCompanyOutletId;
	RaProductMaster raProductMaster;
	List<ParticiatingComany>  listPaticipatingCompany=new ArrayList<ParticiatingComany>();
	ParticiatingComany particiatingComany;
	ParticipatingCompanyDao participatingCompanyDao=new ParticipatingCompanyDao();
	
	public List<ParticiatingComany> getCompanyList(){
		List<RaCompanyMaster> listCompany= participatingCompanyDao.getCompany();
		if (!listCompany.isEmpty())
		{
			for (RaCompanyMaster st : listCompany) {
				
				particiatingComany=new ParticiatingComany();
				particiatingComany.setCompanyId(st.getCompanyId());
				particiatingComany.setCompanyName(st.getCompanyName());
				particiatingComany.setCompanyStatus(st.getCompanyStatus());
				particiatingComany.setDescription(st.getCompanyHolding());
				
				//Outlate of company
				/*	Set s=st.getRaCompanyOutlets();
					Iterator itrIterator=s.iterator();
					while(itrIterator.hasNext())
					{
						raCompanyOutlets=(RaCompanyOutlet)itrIterator.next();
						raCompanyOutletId=raCompanyOutlets.getId();
						raOutletMaster=raCompanyOutletId.getRaOutletMaster();
	
						name=   raOutletMaster.getDescription();
      
						outlatename=outlatename.concat(name);
						outlatename=outlatename.concat(",");
					}
				particiatingComany.setDescription(outlatename);
				*/
				//Product of company
				Set product=st.getRaCompanyProducts();
				Iterator productIterator=product.iterator();
				while(productIterator.hasNext())
				{
					raCompanyProduct=(RaCompanyProduct)productIterator.next();
					raCompanyProductId=raCompanyProduct.getId();
					raProductMaster=raCompanyProductId.getRaProductMaster();

					name=   raProductMaster.getProductType();
  
					productname=productname.concat(name);
					productname=productname.concat(",");
				}
			particiatingComany.setProductType(productname);
		
				listPaticipatingCompany.add(particiatingComany);
			}
		}
		return listPaticipatingCompany;
	}
	public List<ParticiatingComany> loadCompanyReport(){
		List<RaCompanyMaster> listCompany= participatingCompanyDao.loadCompanyReport();
		if (!listCompany.isEmpty())
		{
			for (RaCompanyMaster st : listCompany) {
				
				particiatingComany=new ParticiatingComany();
				particiatingComany.setCompanyId(st.getCompanyId());
				particiatingComany.setCompanyName(st.getCompanyName());
				particiatingComany.setCompanyStatus(st.getCompanyStatus());
				particiatingComany.setDescription(st.getCompanyHolding());

				particiatingComany.setCreateDate(st.getCreateDate());
				/*	Set s=st.getRaCompanyOutlets();
					Iterator itrIterator=s.iterator();
					while(itrIterator.hasNext())
					{
						raCompanyOutlets=(RaCompanyOutlet)itrIterator.next();
						raCompanyOutletId=raCompanyOutlets.getId();
						raOutletMaster=raCompanyOutletId.getRaOutletMaster();
	
						name=   raOutletMaster.getDescription();
      
						outlatename=outlatename.concat(name);
						outlatename=outlatename.concat(",");
					}
				particiatingComany.setDescription(outlatename);
				*/
				//Product of company
				Set product=st.getRaCompanyProducts();
				Iterator productIterator=product.iterator();
				while(productIterator.hasNext())
				{
					raCompanyProduct=(RaCompanyProduct)productIterator.next();
					raCompanyProductId=raCompanyProduct.getId();
					raProductMaster=raCompanyProductId.getRaProductMaster();

					name=   raProductMaster.getProductType();
  
					productname=productname.concat(name);
					productname=productname.concat(",");
				}
			particiatingComany.setProductType(productname);
		
				listPaticipatingCompany.add(particiatingComany);
			}
		}
		return listPaticipatingCompany;
	}
	
	public void insertRecords(RaCompanyMaster raCompanyMaster)
	{
		participatingCompanyDao.insertRecord(raCompanyMaster);
	}
	public void insertOutlets(RaOutletMaster raOutletMaster)
	{
		participatingCompanyDao.insertOutlet(raOutletMaster);
	}
	public void updateRecords(RaCompanyMaster raCompanyMaster)
	{
		participatingCompanyDao.updateRecord(raCompanyMaster);
	}
	public RaCompanyMaster loadSinglecompany(Integer companyId)
	{
		return participatingCompanyDao.loadSingleCompany(companyId);
	}
	public void deActiveRecords(Integer companyId)
	{
		participatingCompanyDao.deActiveCompany(companyId);
	}
	public void ActiveRecords(Integer companyId)
	{
		participatingCompanyDao.ActiveCompany(companyId);
	}

}
