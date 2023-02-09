package com.kjnext.action;

import java.util.List;

import com.kjnext.hibernate.RaDestinationPort;
import com.kjnext.service.DestinationPortServiceImpl;
import com.kjnext.hibernate.RaLoadPort;
public class DestinationPortAction extends BaseAction {

	DestinationPortServiceImpl destinationPortServiceImpl=new DestinationPortServiceImpl();
	RaDestinationPort destinationPort;
	RaLoadPort loadPort;
	List<RaDestinationPort> listport = null;
	List<RaLoadPort> listport1 = null;
	
	public String loadDestinationPort() {
		listport = destinationPortServiceImpl.getDestinationPortlist();
		if (!listport.isEmpty())
			return SUCCESS;

		return INPUT;
	}
	
	public String loadPort() {
		listport1  = destinationPortServiceImpl.loadPort();
		System.out.println(listport1);
		if (!listport1 .isEmpty())
			return SUCCESS;

		return INPUT;
	}
	
  
	public String addDestinationPortInput()
    { 
		//destinationPort.setDestPortId(null);
		return SUCCESS;
	}

	public String addDestinationPort() {
		
		destinationPort.setDestPortStatus("Active");
		destinationPortServiceImpl.addPortlist(destinationPort);
		
		loadDestinationPort();
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	public String updateDestinationPortInput()
	{
		destinationPort=destinationPortServiceImpl.loadSingleDestinationPort(destinationPort.getDestPortId());
		return SUCCESS;
	}
	
	public String updateDestinationPort()
	{
		destinationPortServiceImpl.updateDestinationPortList(destinationPort);
		loadDestinationPort();
		setNavigationFlg("success");
		return SUCCESS;
	}
	
	public String deActivePort()
	{
		
		destinationPortServiceImpl.deActivePort(destinationPort.getDestPortId());
		loadDestinationPort();
		return SUCCESS;
	}
	
	//////////////////////////////////////////////////////
	public RaDestinationPort getDestinationPort() {
		return destinationPort;
	}

	public void setDestinationPort(RaDestinationPort destinationPort) {
		this.destinationPort = destinationPort;
	}

	public List<RaDestinationPort> getListport() {
		return listport;
	}

	public void setListport(List<RaDestinationPort> listport) {
		this.listport = listport;
	}

	public RaLoadPort getLoadPort() {
		return loadPort;
	}

	public void setLoadPort(RaLoadPort loadPort) {
		this.loadPort = loadPort;
	}

	public List<RaLoadPort> getListport1() {
		return listport1;
	}

	public void setListport1(List<RaLoadPort> listport1) {
		this.listport1 = listport1;
	}
	
	
	
	
	
}
