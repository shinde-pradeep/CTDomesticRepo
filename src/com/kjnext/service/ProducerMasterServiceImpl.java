package com.kjnext.service;

import java.io.File;
import java.util.*;
import java.text.*;

import org.jmesa.view.excel.ExcelView;

import jxl.Sheet;
import jxl.Workbook;//poi

import com.kjnext.dao.ProducerMasterDAO;
import com.kjnext.hibernate.RaProducerMaster;
import com.kjnext.hibernate.RaProductMaster;
import com.kjnext.hibernate.RaProducerDataUpload ;
import com.kjnext.hibernate.RaProducerDataUploadId ;

public class ProducerMasterServiceImpl {
	ProducerMasterDAO producerDAO = new ProducerMasterDAO();
	Integer prodid;
	public List<RaProducerDataUploadId> loadProducerDataUploadId() {
		List<RaProducerDataUploadId> producerLists = producerDAO.loadProducer1();
		return producerLists;
	}
	public List<RaProducerMaster> loadProducers() {
		List<RaProducerMaster> producerLists = producerDAO.loadProducer();
		return producerLists;
	}
	public List<RaProducerDataUpload> loadProducerDataUpload () {
		List<RaProducerDataUpload> producerLists = producerDAO.loadProducer2();
		return producerLists;
	}

	public int insertProducers(RaProducerMaster producerMaster,RaProducerDataUploadId raProducerDataUploadId) {
		return producerDAO.insertProducer(producerMaster,raProducerDataUploadId);
	}
    public RaProducerMaster loadSingleProducer(Integer ProdId)
    {
    	RaProducerMaster raProducerMaster=producerDAO.loadSingleProducer(ProdId);
    	return raProducerMaster;
    }
	public int insertProducers1(RaProducerMaster producerMaster) {
		
		
				
		return producerDAO.insertProducer1(producerMaster);
	}
	public void readExcelSheet1(String destFile, RaProducerMaster producerMaster,RaProducerDataUploadId raProducerDataUploadId) {
		File excelSheet = null;
		Workbook workbook = null;

		try {
			Workbook wb = Workbook.getWorkbook(new File(destFile));
			System.out.println(wb.getNumberOfSheets());
			// for (int sheetNo = 0; sheetNo < wb.getNumberOfSheets();
			// sheetNo++)
			int sheetNo = 0;
			if (sheetNo == 0) {
				Sheet sheet = wb.getSheet(sheetNo);
				int columns = sheet.getColumns();
				int rows = sheet.getRows();

				System.out.println("Sheet Name\t"
						+ wb.getSheet(sheetNo).getName());
				for (int row = 1; row < rows; row++) {
					try {

						for (int col = 0; col < columns; col++) {

							if (sheet.getCell(col, row).getContents() == null
									|| sheet.getCell(col, row).getContents() == "") {
								System.out
										.println(" excel cell in blank.........");
							} else if (col == 0) {
								if (sheet.getCell(col, row).getContents() == null
										|| sheet.getCell(col, row)
												.getContents() == "") {
									System.out
											.println(" excel cell in blank.........");
								} else {
									producerMaster.setOrignizationName(sheet
											.getCell(0, row).getContents());
								}
							}

							else if (col == 1) {
								if (sheet.getCell(col, row).getContents() == null
										|| sheet.getCell(col, row)
												.getContents() == "") {
									System.out
											.println(" excel cell in blank.........");

								} else {
									producerMaster.setContactName(sheet
											.getCell(1, row).getContents());
								}
							} else if (col == 2) {
								
								producerMaster.setProducerStatus(sheet.getCell(
										2, row).getContents());
							} else if (col == 3) {
								producerMaster.setEmail(sheet.getCell(3, row)
										.getContents());
							} else if (col == 4) {
								producerMaster.setSalesContact(sheet.getCell(4,
										row).getContents());
							} else if (col == 5) {
								producerMaster.setCity(sheet.getCell(5, row)
										.getContents());
							} else if (col == 6) {
								producerMaster.setSalesPhone(sheet.getCell(6,
										row).getContents());
							}

							else if (col == 7) {
								producerMaster.setSalesFax(sheet
										.getCell(7, row).getContents());
							} else if (col == 8) {
								producerMaster.setSalesUrl(sheet
										.getCell(8, row).getContents());
							}
							/*
							 * else if (col == 9) { String str=sheet.getCell(9,
							 * row).getContents(); Date cdate = new
							 * SimpleDateFormat("yyyy-M-d",
							 * Locale.ENGLISH).parse(str);
							 * producerMaster.setCreateDate(cdate); }
							 */
							else if (col == 9) {
								producerMaster.setState(sheet.getCell(9, row)
										.getContents());
							}
							else if (col == 10) {
									
								
								//raProducerDataUploadId.setProducerId();
								System.out.println(sheet.getCell(10, row).getContents());
								raProducerDataUploadId.setCerYear(sheet.getCell(10, row)
										.getContents());
							}
							else if (col == 11) {
								raProducerDataUploadId.setFarmName(sheet.getCell(11, row)
										.getContents());
							}
							else if (col == 12) {
								raProducerDataUploadId.setAltitude(sheet.getCell(12, row)
										.getContents());
							}
							else if (col == 13) {
								raProducerDataUploadId.setTotalHectares( Double.parseDouble(sheet.getCell(13, row)
										.getContents()));
							}
							else if (col == 14) {
								raProducerDataUploadId.setProdHectares(Double.parseDouble(sheet.getCell(14, row)
										.getContents()));
							}
							else if (col == 15) {
								raProducerDataUploadId.setLongitude(sheet.getCell(15, row)
										.getContents());
							}
							else if (col == 16) {
								raProducerDataUploadId.setLatitude(sheet.getCell(16, row)
										.getContents());
							}
							else if (col == 17) {
								raProducerDataUploadId.setAnnualQty(sheet.getCell(17, row)
										.getContents());
							}
							else if (col == 18) {
								DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
								Date d = (Date)formatter.parse(sheet.getCell(18, row)
										.getContents());
								raProducerDataUploadId.setCerExpireDate(d);
							}
							else if (col == 19) {
								raProducerDataUploadId.setCerNumber(sheet.getCell(17, row)
										.getContents());
								//calling fuction to set producer data
								insertProducers1(producerMaster);
							}
						}// End of for loop First

						// dao code goes here
						// producerMaster.setCreateDate(new java.util.Date());
						// insertProducers(producerMaster);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}// End of for loop Second
				producerMaster.setCreateDate(new java.util.Date());
				//calling function to set producer farm data upload
				insertProducers(producerMaster,raProducerDataUploadId);
			} // End of for loop Third
			else {
				System.out.println(" ........sheet 1 only...");

			}
		}// end of try
		catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}
	public void readExcelSheet(String destFile, RaProducerMaster producerMaster,RaProducerDataUploadId raProducerDataUploadId) {
		File excelSheet = null;
		Workbook workbook = null;
		
		try {
			Workbook wb = Workbook.getWorkbook(new File(destFile));
			System.out.println(wb.getNumberOfSheets());
			// for (int sheetNo = 0; sheetNo < wb.getNumberOfSheets();
			// sheetNo++)
			System.out.println(wb);
			System.out.println(destFile);
			int sheetNo = 0;
			if (sheetNo == 0) {
				Sheet sheet = wb.getSheet(sheetNo);
				int columns = sheet.getColumns();
				int rows = sheet.getRows();

				System.out.println("Sheet Name\t"
						+ wb.getSheet(sheetNo).getName());
				for (int row = 1; row < rows; row++) {
					try {

						for (int col = 0; col < columns; col++) {

							if (sheet.getCell(col, row).getContents() == null
									|| sheet.getCell(col, row).getContents() == "") {
								System.out
										.println(" excel cell in blank.........");
							} 
							else if (col == 0) {
								if (sheet.getCell(col, row).getContents() == null
										|| sheet.getCell(col, row)
												.getContents() == "") {
									System.out
											.println(" excel cell in blank.........");
								} else {
									producerMaster.setOrignizationName(sheet
											.getCell(0, row).getContents());
								}
							}

							else if (col == 1) {
								if (sheet.getCell(col, row).getContents() == null
										|| sheet.getCell(col, row)
												.getContents() == "") {
									System.out
											.println(" excel cell in blank.........");

								} else {
									producerMaster.setContactName(sheet
											.getCell(1, row).getContents());
								}
							} else if (col == 2) {
								
								producerMaster.setProducerStatus(sheet.getCell(
										2, row).getContents());
							} else if (col == 3) {
								producerMaster.setEmail(sheet.getCell(3, row)
										.getContents());
							} else if (col == 4) {
								producerMaster.setSalesContact(sheet.getCell(4,
										row).getContents());
							} else if (col == 5) {
								producerMaster.setCity(sheet.getCell(5, row)
										.getContents());
							} else if (col == 6) {
								producerMaster.setSalesPhone(sheet.getCell(6,
										row).getContents());
							}

							else if (col == 7) {
								producerMaster.setSalesFax(sheet
										.getCell(7, row).getContents());
							} else if (col == 8) {
								producerMaster.setSalesUrl(sheet
										.getCell(8, row).getContents());
							}
							/*
							 * else if (col == 9) { String str=sheet.getCell(9,
							 * row).getContents(); Date cdate = new
							 * SimpleDateFormat("yyyy-M-d",
							 * Locale.ENGLISH).parse(str);
							 * producerMaster.setCreateDate(cdate); }
							 */
							else if (col == 9) {
								producerMaster.setState(sheet.getCell(9, row)
										.getContents());
								producerMaster.setCreateDate(new java.util.Date());

								//prodid=insertProducers(producerMaster);
							}
							
						/*	else if (col == 10) 
							{


							DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
							Date d = (Date)formatter.parse(sheet.getCell(18, row)
									.getContents());
						//	RaProducerDataUploadId	raProducerDataUploadId=new raProducerDataUploadId(producerMaster,sheet.getCell(10, row).getContents(), sheet.getCell(11, row).getContents(),"", sheet.getCell(12, row).getContents(), Double.parseDouble(sheet.getCell(13, row).getContents()), Double.parseDouble(sheet.getCell(14, row).getContents()), sheet.getCell(15, row).getContents(), sheet.getCell(16, row).getContents(), sheet.getCell(17, row).getContents(),d, sheet.getCell(19, row).getContents(),"","" ,"" ,"","" ,"" ,"",0,0,0); 
							
							
							
							}*/
							else if (col == 10) {
									
								
								//raProducerDataUploadId.setProducerId();
								System.out.println(sheet.getCell(10, row).getContents());
								raProducerDataUploadId.setCerYear(sheet.getCell(10, row)
										.getContents());
							}
							else if (col == 11) {
								raProducerDataUploadId.setFarmName(sheet.getCell(11, row)
										.getContents());
							}
							else if (col == 12) {
								raProducerDataUploadId.setAltitude(sheet.getCell(12, row)
										.getContents());
							}
							else if (col == 13) {
								raProducerDataUploadId.setTotalHectares( Double.parseDouble(sheet.getCell(13, row)
										.getContents()));
							}
							else if (col == 14) {
								raProducerDataUploadId.setProdHectares(Double.parseDouble(sheet.getCell(14, row)
										.getContents()));
							}
							else if (col == 15) {
								raProducerDataUploadId.setLongitude(sheet.getCell(15, row)
										.getContents());
							}
							else if (col == 16) {
								raProducerDataUploadId.setLatitude(sheet.getCell(16, row)
										.getContents());
							}
							else if (col == 17) {
								raProducerDataUploadId.setAnnualQty(sheet.getCell(17, row)
										.getContents());
							}
							else if (col == 18) {
								DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
								Date d = (Date)formatter.parse(sheet.getCell(18, row)
										.getContents());
								raProducerDataUploadId.setCerExpireDate(d);
							}
							else if (col == 19) {
								raProducerDataUploadId.setCerNumber(sheet.getCell(17, row)
										.getContents());
							//	insertProducers1(producerMaster,raProducerDataUploadId);
							}
						}// End of for loop First

						// dao code goes here
						// producerMaster.setCreateDate(new java.util.Date());
						// insertProducers(producerMaster);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}// End of for loop Second
								
			} // End of for loop Third
			else {
				System.out.println(" ........sheet 1 only...");

			}
		}// end of try
		catch (Exception ioe) {
			ioe.printStackTrace();
		}

	}
}
