package com.kjnext.excelRead;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import com.kjnext.action.BaseAction;



public class ParticipentProducerModel extends BaseAction{

	private File excelFile = null;
	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}
    
	
}
