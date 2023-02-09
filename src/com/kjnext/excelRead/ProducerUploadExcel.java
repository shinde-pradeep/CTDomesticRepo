package com.kjnext.excelRead;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

import com.kjnext.model.ParticipentProducerBusiness;

public class ProducerUploadExcel {
	private String[] cert_year;

	private String[] company_name;

	private String[] farm_name;

	private String[] certification_exp;

	private String[] total_area;

	private String[] area_in_prod;

	private String[] latitude;

	private String[] longitude;

	private String[] prod_total;

	private String[] country;

	private String[] producer_con_name;

	private String[] email;

	private String[] certification_no;

	private String[] failureReason;

	// without argument constructor
	public ProducerUploadExcel() {
	}

	private String inputFile;

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	// Read excel file
	public boolean readExcelFile(File strfileName,ParticipentProducerBusiness business) throws Exception {
		File inputWorkbook = new File(inputFile);
		Workbook workbook = null;
		try {
			workbook = workbook.getWorkbook(inputWorkbook);
			Sheet sheet = workbook.getSheet(0);
			int rows = sheet.getRows();
			System.out.println("rows :: " + rows);
			// read column..........
			failureReason = new String[rows - 1];
			Cell[] cert_yearC = sheet.getColumn(0);
			cert_year = new String[rows - 1];
			cert_year(cert_yearC, rows);

			Cell[] company_nameC = sheet.getColumn(1);
			company_name = new String[rows - 1];
			company_name(company_nameC, rows);

			Cell[] farm_nameC = sheet.getColumn(2);
			farm_name = new String[rows - 1];
			farm_name(farm_nameC, rows);

			Cell[] certification_expC = sheet.getColumn(3);
			certification_exp = new String[rows - 1];
			certification_exp(certification_expC, cert_yearC, rows);

			Cell[] total_areaC = sheet.getColumn(4);
			total_area = new String[rows - 1];
			total_area(total_areaC, rows);

			Cell[] area_in_prodC = sheet.getColumn(5);
			area_in_prod = new String[rows - 1];
			area_in_prod(area_in_prodC, rows);

			Cell[] latitudeC = sheet.getColumn(6);
			latitude = new String[rows - 1];
			latitude(latitudeC, rows);

			Cell[] longitudeC = sheet.getColumn(7);
			longitude = new String[rows - 1];
			longitude(longitudeC, rows);

			Cell[] prod_totalC = sheet.getColumn(8);
			prod_total = new String[rows - 1];
			prod_total(prod_totalC, rows);

			Cell[] countryC = sheet.getColumn(9);
			country = new String[rows - 1];
			country(countryC, rows);

			Cell[] producer_con_nameC = sheet.getColumn(10);
			producer_con_name = new String[rows - 1];
			producer_con_name(producer_con_nameC, rows);

			Cell[] emailC = sheet.getColumn(11);
			email = new String[rows - 1];
			email(emailC, rows);

			Cell[] certification_noC = sheet.getColumn(12);
			certification_no = new String[rows - 1];
			certification_no(certification_noC, rows);

			validateExcel(rows);
		    populateBean(business);
		} catch (Exception e) {
			System.out.println("Exception: readExcelFile() method: "
					+ e.getMessage());
			e.printStackTrace();
			throw new Exception(
					"Error while reading uploaded data. Please try again.");
		}
		return true;
	}

	private void cert_year(Cell[] cert_yearC, int rows) {
		if (cert_yearC.length > 1) {
			for (int i = 1; i < cert_yearC.length; i++) {
				failureReason[i - 1] = "";
				String cert_year = cert_yearC[i].getContents().trim();
				System.out.println("cert_year :: " + cert_year + "\t length ::"
						+ cert_year.length());
				try {
					if (cert_year.trim().length() > 4) {
						this.cert_year[i - 1] = "";
						failureReason[i - 1] = failureReason[i - 1]
								+ "\n Length of certification year can not be greater than 4 ,";
						continue;
					} else if (cert_year.equals("")) {
						this.cert_year[i - 1] = "";
						failureReason[i - 1] = failureReason[i - 1]
								+ "\n Certification year is blank ,";
						continue;
					} else if (!cert_year.equals("")) {
						java.util.Date date1 = new java.util.Date();
						int year = date1.getYear();
						int year1 = Integer.parseInt(cert_year);
						if (year < year1) {
							this.cert_year[i - 1] = "";
							failureReason[i - 1] = failureReason[i - 1]
									+ "\n Certification year can not be greater than current year ,";
							continue;
						}
					}
					this.cert_year[i - 1] = cert_year;
				} catch (NumberFormatException nfe) {
					System.out.println("NumberFormatException ::"
							+ nfe.getMessage());
					nfe.printStackTrace();
					this.cert_year[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Certification year should be numeric value ,";
					continue;
				}// catch
			}// end of for
		}// end of outer if
	}

	private void company_name(Cell[] company_nameC, int rows) {
		if (company_nameC.length > 1) {
			for (int i = 1; i < company_nameC.length; i++) {
				String company_name = company_nameC[i].getContents().trim();
				if (company_name.length() > 150) {
					this.failureReason[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of organisation name can not be greater than 150, ";
					continue;
				}
				if (company_name.equals("")) {
					this.failureReason[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Organisation name can not be blank ,";
					continue;
				}
				this.company_name[i - 1] = company_name;
			}
		}
	}// End of Company_name()

	private void farm_name(Cell[] farm_nameC, int rows) {
		if (farm_nameC.length > 1) {
			for (int i = 0; i < farm_nameC.length; i++) {
				String farm_name = farm_nameC[i].getContents().trim();
				if (farm_name.length() > 150) {
					failureReason[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Lenght of Farm name can not be greater than 150 character ,";
					continue;
				}
				if (farm_name.equals("")) {
					this.failureReason[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Farm name is blank ,";
					continue;
				}
				this.farm_name[i - 1] = farm_name;
			}
		}

	}// End of farm_name()

	private void certification_exp(Cell[] certification_expC,
			Cell[] cert_yearC, int rows) {
		if (certification_expC.length > 1) {
			for (int i = 1; i < certification_expC.length; ++i) {
				String certification_exp = null;
				try {
					String cert_year = cert_yearC[i].getContents().trim();
					if (!cert_year.equals("")) {
						if ((certification_expC[i].getType() != CellType.DATE)
								&& (certification_expC[i].getType().toString()
										.trim().indexOf("Formula") < 0)) {
							if (certification_expC[i].getContents().trim()
									.equals("")) {
								failureReason[i - 1] = failureReason[i - 1]
										+ " \n 	Certification expiration date is blank, ";
							} else {
								failureReason[i - 1] = failureReason[i - 1]
										+ " \n Date format is not valid, ";
							}
							this.certification_exp[i - 1] = "";
							continue;
						} else if (certification_expC[i].getType() == CellType.DATE
								|| certification_expC[i].getType().toString().trim().indexOf("Formula") >= 0) {

							certification_exp = certification_expC[i]
									.getContents().trim();
						}

						if (certification_exp != null
								&& (certification_exp.indexOf("/") >= 0 || certification_exp.indexOf("-") >= 0)) {

							this.certification_exp[i - 1] = certification_exp;
						}

						System.out.println("Certification Date.............: "+ certification_exp);

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

						System.out.println("Certification Date.............: "
								+ sdf.format(certification_expC[i].getContents()));

						java.util.Date date = new java.util.Date(certification_exp);
						int year = date.getYear() + 1900;
						int year1 = Integer.parseInt(cert_year);

						if (year < year1) {
							failureReason[i - 1] = failureReason[i - 1]
									+ " \n Expiration date can not be less than certification year,";
							this.certification_exp[i - 1] = "";
						}
						if (this.certification_exp[i - 1] == null) {
							failureReason[i - 1] = failureReason[i - 1]
									+ " \n Date format is not valid,";
							this.certification_exp[i - 1] = "";
						}
					} else {
						if (certification_expC[i].getContents().trim().equals(
								"")) {
							failureReason[i - 1] = failureReason[i - 1]
									+ " \n Certification expiration date is blank, ";
						} else {
							failureReason[i - 1] = failureReason[i - 1]
									+ " \n Date format is not valid, ";
						}
						this.certification_exp[i - 1] = "";
						continue;
					}// else

				} catch (NumberFormatException nfe) {
					System.out.println("NumberFormatException--->"
							+ nfe.getMessage());
					nfe.printStackTrace();
					continue;
				} catch (Exception ex) {
					System.out.println("Exception--->" + ex.getMessage());
					ex.printStackTrace();
					failureReason[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Issue with Certification expiration date.";
					continue;
				}// catch
			}// for
		}// outer if
	}// end certification_exp()

	private void total_area(Cell[] total_areaC, int rows) {
		if (total_areaC.length > 1) {
			for (int i = 1; i < total_areaC.length; ++i) {
				String total_area = total_areaC[i].getContents().trim();
				if (total_area.length() > 30) {
					this.total_area[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of total area can not be greater than 30,";
					continue;
				}
				if (total_area.equals("")) {
					this.total_area[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Total area is blank,";
					continue;
				}
				try {
					if (total_area.length() != 0) {
						Double.parseDouble(total_area);
					}

				} catch (Exception e) {
					e.printStackTrace();
					this.total_area[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Total area should be positive number,";
					continue;
				}
				this.total_area[i - 1] = total_area;
			}
		}
	}

	private void area_in_prod(Cell[] area_in_prodC, int rows) {
		if (area_in_prodC.length > 1) {
			for (int i = 1; i < area_in_prodC.length; ++i) {
				String area_in_prod = area_in_prodC[i].getContents().trim();
				if (area_in_prod.length() > 30) {
					this.area_in_prod[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of area in production can not be greater than 30,";
					continue;
				}
				if (area_in_prod.equals("")) {
					this.area_in_prod[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Area in production is blank,";
					continue;
				}
				try {
					if (area_in_prod.length() != 0) {
						Double.parseDouble(area_in_prod);
					}
				} catch (Exception e) {
					e.printStackTrace();
					this.area_in_prod[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Area in production should be positive number,";
					continue;

				}
				this.area_in_prod[i - 1] = area_in_prod;
			}
		}
	}

	private void latitude(Cell[] latitudeC, int rows) {
		if (latitudeC.length > 1) {
			for (int i = 1; i < latitudeC.length; ++i) {
				String latitude = latitudeC[i].getContents().trim();
				if (latitude.length() > 20) {
					this.latitude[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Length of latitude can not be greater than 20,";
					continue;
				}
				if (latitude.equals("")) {
					this.latitude[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Latitude is blank,";
					continue;
				}
				this.latitude[i - 1] = latitude;
			}
		}
	}

	private void longitude(Cell[] longitudeC, int rows) {
		if (longitudeC.length > 1) {
			for (int i = 1; i < longitudeC.length; ++i) {
				String longitude = longitudeC[i].getContents().trim();
				if (longitude.length() > 20) {
					this.longitude[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Length of longitude can not be greater than 20,";
					continue;
				}
				if (longitude.equals("")) {
					this.longitude[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Longitude is blank,";
					continue;
				}
				this.longitude[i - 1] = longitude;
			}
		}
	}

	private void prod_total(Cell[] prod_totalC, int rows) {
		if (prod_totalC.length > 1) {
			for (int i = 1; i < prod_totalC.length; ++i) {
				String prod_total = prod_totalC[i].getContents().trim();
				if (prod_total.length() > 30) {
					this.prod_total[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Length of production total can not be greater than 30,";
					continue;
				}
				if (prod_total.equals("")) {
					this.prod_total[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Production total is blank,";
					continue;
				}
				try {
					if (prod_total.length() != 0) {
						Double.parseDouble(prod_total);
					}

				} catch (Exception e) {
					e.printStackTrace();
					this.prod_total[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "  \n Production total should be positive number,";
					continue;
				}
				this.prod_total[i - 1] = prod_total;
			}
		}
	}

	private void country(Cell[] countryC, int rows) {
		if (countryC.length > 1) {
			for (int i = 1; i < countryC.length; ++i) {
				String country = countryC[i].getContents().trim();
				if (country.length() > 40) {
					this.country[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Length of country can not be greater than 40,";
					continue;
				}
				if (country.equals("")) {
					this.country[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Country is blank,";
					continue;
				}
				this.country[i - 1] = country;
			}
		}
	}

	private void producer_con_name(Cell[] producer_con_nameC, int rows) {
		if (producer_con_nameC.length > 1) {
			for (int i = 1; i < producer_con_nameC.length; ++i) {
				String producer_con_name = producer_con_nameC[i].getContents()
						.trim();
				if (producer_con_name.length() > 40) {
					this.producer_con_name[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of contact name can not be greater than 40,";
					continue;
				}
				if (producer_con_name.equals("")) {
					this.producer_con_name[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Contact name is blank,";
					continue;
				}
				this.producer_con_name[i - 1] = producer_con_name;
			}
		}
	}

	private void email(Cell[] emailC, int rows) {
		if (emailC.length > 1) {
			for (int i = 1; i < emailC.length; ++i) {
				String email = emailC[i].getContents().trim();
				if (email.length() > 40) {
					this.email[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of email can not be greater than 40, ";
					continue;
				}
				if (email.equals("")) {
					this.email[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Email is blank,";
					continue;
				}
				if (email.indexOf("@") == -1 || email.indexOf(".") == -1) {
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n  Email format is not valid,";
					this.email[i - 1] = "";
					continue;
				}
				this.email[i - 1] = email;
			}
		}
	}

	private void certification_no(Cell[] certification_noC, int rows) {
		if (certification_noC.length > 1) {
			for (int i = 1; i < certification_noC.length; ++i) {
				String certification_no = certification_noC[i].getContents()
						.trim();
				if (certification_no.length() > 40) {
					this.certification_no[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ "\n Length of certification number can not be greater than 40,";
					continue;
				}
				if (certification_no.equals("")) {
					this.certification_no[i - 1] = "";
					failureReason[i - 1] = failureReason[i - 1]
							+ " \n Certification number is blank,";
					continue;
				}
				this.certification_no[i - 1] = certification_no;
			}
		}
	}

	// validate field

	private void validateExcel(int rows) throws Exception {
		for (int i = 0; i < rows - 1; i++) {
			if (this.area_in_prod[i] == null || this.cert_year[i] == null
					|| this.certification_exp[i] == null
					|| this.certification_no[i] == null
					|| this.company_name[i] == null || this.country[i] == null
					|| this.email[i] == null || this.farm_name[i] == null
					|| this.latitude[i] == null || this.longitude[i] == null
					|| this.prod_total[i] == null
					|| this.producer_con_name[i] == null
					|| this.total_area[i] == null
					|| this.area_in_prod[i].trim() == ""
					|| this.cert_year[i].trim() == ""
					|| this.certification_exp[i].trim() == ""
					|| this.certification_no[i].trim() == ""
					|| this.company_name[i].trim() == ""
					|| this.country[i].trim() == ""
					|| this.email[i].trim() == ""
					|| this.farm_name[i].trim() == ""
					|| this.latitude[i].trim() == ""
					|| this.longitude[i].trim() == ""
					|| this.prod_total[i].trim() == ""
					|| this.producer_con_name[i].trim() == ""
					|| this.total_area[i].trim() == "") {
				if (failureReason[i] == null || failureReason[i].length() < 1) {
					failureReason[i] = failureReason[i]
							+ "\n Some Excel field is blank ,";
				}
				cert_year[i] = "0";
			}

		}
	}
	private void populateBean(ParticipentProducerBusiness business)throws Exception
	{
		try {
			business.setArea_in_prod(this.area_in_prod);
			business.setCert_year(this.cert_year);
			business.setCertification_exp(this.certification_exp);
			business.setCertification_no(this.certification_no);
			business.setCountry(this.country);
			business.setCompany_name(this.company_name);
			business.setEmail(this.email);
			business.setFarm_name(this.farm_name);
			business.setLatitude(this.latitude);
			business.setLongitude(this.longitude);
			business.setProd_total(this.prod_total);
			business.setProducer_con_name(this.producer_con_name);
			business.setTotal_area(this.total_area);
			business.setTotal_area(this.total_area);
		} catch (Exception e) {
			throw new Exception("Error populating data from excel upload");
		}
	}
	// :::::::::::::::::::::::::::::::::::::
	/*public void read() throws IOException {
		File inputWorkbook = new File(inputFile);
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(inputWorkbook);
			// Get the first sheet
			Sheet sheet = workbook.getSheet(0);
			// Loop over first 10 column and lines

			for (int j = 0; j < sheet.getColumns(); j++) {
				for (int i = 0; i < sheet.getRows(); i++) {
					Cell cell = sheet.getCell(j, i);
					CellType type = cell.getType();
					if (type == CellType.LABEL) {
						System.out.println("I got a label "
								+ cell.getContents());
					}

					if (type == CellType.NUMBER) {
						System.out.println("I got a number "
								+ cell.getContents());
					}
					cell.getCellFormat();
				}
			}
		}

		catch (Exception e) {
			// TODO: handle exception
		}
	}*/
	// getter and setter method not required}
}
