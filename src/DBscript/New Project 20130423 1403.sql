-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.22-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema kjnext
--

CREATE DATABASE IF NOT EXISTS kjnext;
USE kjnext;

--
-- Definition of table `ra_acl_master`
--

DROP TABLE IF EXISTS `ra_acl_master`;
CREATE TABLE `ra_acl_master` (
  `ACL_ID` int(15) NOT NULL default '0',
  `ACTION` varchar(100) default NULL,
  `SUB_MODULE_ID` int(15) default NULL,
  PRIMARY KEY  (`ACL_ID`),
  KEY `SUB_MODULE_ID` (`SUB_MODULE_ID`),
  CONSTRAINT `ra_acl_master_ibfk_1` FOREIGN KEY (`SUB_MODULE_ID`) REFERENCES `ra_sub_module` (`SUB_MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_acl_master`
--

/*!40000 ALTER TABLE `ra_acl_master` DISABLE KEYS */;
INSERT INTO `ra_acl_master` (`ACL_ID`,`ACTION`,`SUB_MODULE_ID`) VALUES 
 (101,'	Show All Users',1);
/*!40000 ALTER TABLE `ra_acl_master` ENABLE KEYS */;


--
-- Definition of table `ra_buss_category`
--

DROP TABLE IF EXISTS `ra_buss_category`;
CREATE TABLE `ra_buss_category` (
  `BUSS_CAT_ID` int(15) NOT NULL,
  `DESCRIPTION` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_buss_category`
--

/*!40000 ALTER TABLE `ra_buss_category` DISABLE KEYS */;
INSERT INTO `ra_buss_category` (`BUSS_CAT_ID`,`DESCRIPTION`) VALUES 
 (1,'Importer (green coffee)'),
 (2,'Coffee Roaster/Retailer');
/*!40000 ALTER TABLE `ra_buss_category` ENABLE KEYS */;


--
-- Definition of table `ra_buss_supply_prod`
--

DROP TABLE IF EXISTS `ra_buss_supply_prod`;
CREATE TABLE `ra_buss_supply_prod` (
  `BUSS_CAT_ID` int(15) NOT NULL,
  `BUISNESS_TYPE_ID` int(15) default NULL,
  KEY `BUISNESS_TYPE_ID` (`BUISNESS_TYPE_ID`),
  CONSTRAINT `ra_buss_supply_prod_ibfk_1` FOREIGN KEY (`BUISNESS_TYPE_ID`) REFERENCES `ra_bussiness_type_master` (`BUISNESS_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_buss_supply_prod`
--

/*!40000 ALTER TABLE `ra_buss_supply_prod` DISABLE KEYS */;
INSERT INTO `ra_buss_supply_prod` (`BUSS_CAT_ID`,`BUISNESS_TYPE_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_buss_supply_prod` ENABLE KEYS */;


--
-- Definition of table `ra_bussiness_type_master`
--

DROP TABLE IF EXISTS `ra_bussiness_type_master`;
CREATE TABLE `ra_bussiness_type_master` (
  `BUISNESS_TYPE_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(100) default NULL,
  `BUSS_STATUS` varchar(20) default 'Active',
  `BUISNESS_TYPE` varchar(100) default NULL,
  PRIMARY KEY  (`BUISNESS_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_bussiness_type_master`
--

/*!40000 ALTER TABLE `ra_bussiness_type_master` DISABLE KEYS */;
INSERT INTO `ra_bussiness_type_master` (`BUISNESS_TYPE_ID`,`DESCRIPTION`,`BUSS_STATUS`,`BUISNESS_TYPE`) VALUES 
 (1,'Apple','Active','Importer'),
 (2,'Banana','Active','Distributor'),
 (3,'Mango','Active','Ingredient Supplier'),
 (4,'Potato','Active','Online Retailer'),
 (5,'Cabbage','Active','Importer'),
 (6,'Capsicum','Active','Importer'),
 (7,'Carrot, Banana','Active','Distributor'),
 (8,'Chilli','Active','Importer'),
 (9,'Garlic','Active','Online Retailer'),
 (10,'Onion','Active','Ingredient Supplier'),
 (11,'Turmeric','Active','Importer'),
 (12,'Grape','Active','Ingredient Supplier'),
 (13,'Coconut','Active','Distributor');
/*!40000 ALTER TABLE `ra_bussiness_type_master` ENABLE KEYS */;


--
-- Definition of table `ra_cer_prod_form`
--

DROP TABLE IF EXISTS `ra_cer_prod_form`;
CREATE TABLE `ra_cer_prod_form` (
  `CER_PRODUCT_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(50) default NULL,
  PRIMARY KEY  (`CER_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_cer_prod_form`
--

/*!40000 ALTER TABLE `ra_cer_prod_form` DISABLE KEYS */;
INSERT INTO `ra_cer_prod_form` (`CER_PRODUCT_ID`,`DESCRIPTION`) VALUES 
 (1,'Brewed Coffee'),
 (2,'Packaged Roasted Coffee');
/*!40000 ALTER TABLE `ra_cer_prod_form` ENABLE KEYS */;


--
-- Definition of table `ra_company_brand`
--

DROP TABLE IF EXISTS `ra_company_brand`;
CREATE TABLE `ra_company_brand` (
  `BRAND_ID` int(15) NOT NULL default '0',
  `BRAND_NAME` varchar(50) default NULL,
  `COMPANY_ID` int(15) default NULL,
  PRIMARY KEY  (`BRAND_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_brand`
--

/*!40000 ALTER TABLE `ra_company_brand` DISABLE KEYS */;
INSERT INTO `ra_company_brand` (`BRAND_ID`,`BRAND_NAME`,`COMPANY_ID`) VALUES 
 (101,'Coffee',1);
/*!40000 ALTER TABLE `ra_company_brand` ENABLE KEYS */;


--
-- Definition of table `ra_company_buss_supply`
--

DROP TABLE IF EXISTS `ra_company_buss_supply`;
CREATE TABLE `ra_company_buss_supply` (
  `BUSS_CAT_ID` int(15) NOT NULL,
  `COMPANY_ID` int(15) NOT NULL,
  PRIMARY KEY  (`BUSS_CAT_ID`,`COMPANY_ID`),
  KEY `COMPANY_ID` (`COMPANY_ID`),
  CONSTRAINT `ra_company_buss_supply_ibfk_1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_buss_supply`
--

/*!40000 ALTER TABLE `ra_company_buss_supply` DISABLE KEYS */;
INSERT INTO `ra_company_buss_supply` (`BUSS_CAT_ID`,`COMPANY_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_company_buss_supply` ENABLE KEYS */;


--
-- Definition of table `ra_company_bussiness`
--

DROP TABLE IF EXISTS `ra_company_bussiness`;
CREATE TABLE `ra_company_bussiness` (
  `COMPANY_ID` int(15) NOT NULL default '0',
  `BUISNESS_TYPE_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`COMPANY_ID`,`BUISNESS_TYPE_ID`),
  KEY `BUISNESS_TYPE_ID` (`BUISNESS_TYPE_ID`),
  CONSTRAINT `ra_company_bussiness_ibfk_1` FOREIGN KEY (`BUISNESS_TYPE_ID`) REFERENCES `ra_bussiness_type_master` (`BUISNESS_TYPE_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `ra_company_bussiness_ibfk_2` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_bussiness`
--

/*!40000 ALTER TABLE `ra_company_bussiness` DISABLE KEYS */;
INSERT INTO `ra_company_bussiness` (`COMPANY_ID`,`BUISNESS_TYPE_ID`) VALUES 
 (1,1),
 (4,2),
 (6,3),
 (1,4),
 (3,6),
 (5,8),
 (7,10);
/*!40000 ALTER TABLE `ra_company_bussiness` ENABLE KEYS */;


--
-- Definition of table `ra_company_cer_prod`
--

DROP TABLE IF EXISTS `ra_company_cer_prod`;
CREATE TABLE `ra_company_cer_prod` (
  `CER_PRODUCT_ID` int(15) NOT NULL default '0',
  `COMPANY_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`CER_PRODUCT_ID`,`COMPANY_ID`),
  KEY `COMPANY_ID` (`COMPANY_ID`),
  CONSTRAINT `ra_company_cer_prod_ibfk_1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`),
  CONSTRAINT `ra_company_cer_prod_ibfk_2` FOREIGN KEY (`CER_PRODUCT_ID`) REFERENCES `ra_cer_prod_form` (`CER_PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_cer_prod`
--

/*!40000 ALTER TABLE `ra_company_cer_prod` DISABLE KEYS */;
INSERT INTO `ra_company_cer_prod` (`CER_PRODUCT_ID`,`COMPANY_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_company_cer_prod` ENABLE KEYS */;


--
-- Definition of table `ra_company_master`
--

DROP TABLE IF EXISTS `ra_company_master`;
CREATE TABLE `ra_company_master` (
  `COMPANY_ID` int(15) NOT NULL default '0',
  `COMPANY_NAME` varchar(100) NOT NULL,
  `COMPANY_HOLDING` varchar(100) default NULL,
  `CREATE_DATE` date NOT NULL,
  `COMPANY_STATUS` char(1) NOT NULL,
  `MODIFY_DATE` date default NULL,
  `PRI_FNAME` varchar(50) default NULL,
  `MAX_USERS` int(15) default NULL,
  `PRI_LNAME` varchar(50) default NULL,
  `PRI_POSITION` varchar(50) default NULL,
  `PRI_OFFADDRESS` varchar(100) default NULL,
  `PRI_CITY` varchar(50) default NULL,
  `PRI_DISTRICT` varchar(50) default NULL,
  `PRI_ZIP` varchar(20) default NULL,
  `PRI_STATE_ID` int(15) default NULL,
  `PRI_PHONE` varchar(25) default NULL,
  `PRI_FAX` varchar(25) default NULL,
  `PRI_EMAIL` varchar(50) default NULL,
  `PRI_URL1` varchar(100) default NULL,
  `PRI_URL2` varchar(50) default NULL,
  `SR_FNAME` varchar(50) default NULL,
  `SR_LNAME` varchar(50) default NULL,
  `SR_POSITION` varchar(50) default NULL,
  `SR_ADDRESS` varchar(100) default NULL,
  `SR_CITY` varchar(50) default NULL,
  `SR_DISTRICT` varchar(50) default NULL,
  `SR_ZIP` varchar(20) default NULL,
  `SR_STATE_ID` int(15) default NULL,
  `SR_PHONE` varchar(25) default NULL,
  `SR_FAX` varchar(25) default NULL,
  `SR_EMAIL` varchar(50) default NULL,
  `COMMENTS` varchar(500) default NULL,
  `RA_CERTIFIED_PROD` char(1) default NULL,
  `PROD_FUTURE` char(1) default NULL,
  `PROD_FUTURE_DATE` date default NULL,
  `SALE_PURCHASE_RA_PROD` char(1) default NULL,
  `SALE_PURCHASE_RA_FUTURE` char(1) default NULL,
  `SALE_PURCHASE_RA_FUTURE_DATE` date default NULL,
  `TOT_OUTLET` int(15) default NULL,
  `TOT_OUTLET_RA` int(15) default NULL,
  `ANNUAL_SALE` int(15) default NULL,
  `RA_SEAL` char(1) default NULL,
  `RA_SEAL_ADVT` char(1) default NULL,
  `RA_MEMBERSHIP` char(1) default NULL,
  `SALE_PURCHASE_BRAND` varchar(50) default NULL,
  `RA_CERTIFIED_PROD_SUPPLY` varchar(50) default NULL,
  `OTHER_BUSSINESS_TYPE` varchar(20) default NULL,
  `OTHER_BUSS_PRODUCT` varchar(20) default NULL,
  `OTHER_EXP_SALE_PRODUCT` varchar(20) default NULL,
  `OTHER_IMP_SUPPLY_PRODUCT` varchar(18) default NULL,
  `RA_SUPPLY_PROD` varchar(30) default NULL,
  `LOGO_FPHOTO` varchar(100) default NULL,
  `LOGO_SPHOTO` varchar(100) default NULL,
  `LOGO_TPHOTO` varchar(100) default NULL,
  `SEAL_COMMENTS` varchar(1000) default NULL,
  `OTHER_PRODUCT` varchar(20) default NULL,
  `RA_PROD_BRAND1` varchar(50) default NULL,
  `RA_PROD_BRAND2` varchar(50) default NULL,
  `RA_PROD_BRAND3` varchar(50) default NULL,
  `RA_PROD_BRAND4` varchar(50) default NULL,
  `NEWL_MEM_FNAME` varchar(50) default NULL,
  `NEWL_MEM_FLNAME` varchar(50) default NULL,
  `NEWL_MEM_FTITLE` varchar(50) default NULL,
  `NEWL_MEM_FEMAIL` varchar(50) default NULL,
  `NEWL_MEM_SNAME` varchar(50) default NULL,
  `NEWL_MEM_SLNAME` varchar(50) default NULL,
  `NEWL_MEM_STITLE` varchar(50) default NULL,
  `NEWL_MEM_SEMAIL` varchar(50) default NULL,
  `NEWL_MEM_TNAME` varchar(50) default NULL,
  `NEWL_MEM_TLNAME` varchar(50) default NULL,
  `NEWL_MEM_TTITLE` varchar(50) default NULL,
  `NEWL_MEM_TEMAIL` varchar(50) default NULL,
  `RA_USER_AGREEMENT` varchar(500) default NULL,
  `RA_PRIVACY_POLICY` varchar(500) default NULL,
  `OTHER_PROD_FORM` varchar(20) default NULL,
  `SCAA_SCORING` varchar(20) default NULL,
  `CUP_PROFILE` varchar(20) default NULL,
  `CUST_PHONE` varchar(25) default NULL,
  `AGREEMENT_STATUS` char(1) default 'N',
  PRIMARY KEY  (`COMPANY_ID`),
  UNIQUE KEY `UNIQ_COMPANY_NAME` (`COMPANY_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_master`
--

/*!40000 ALTER TABLE `ra_company_master` DISABLE KEYS */;
INSERT INTO `ra_company_master` (`COMPANY_ID`,`COMPANY_NAME`,`COMPANY_HOLDING`,`CREATE_DATE`,`COMPANY_STATUS`,`MODIFY_DATE`,`PRI_FNAME`,`MAX_USERS`,`PRI_LNAME`,`PRI_POSITION`,`PRI_OFFADDRESS`,`PRI_CITY`,`PRI_DISTRICT`,`PRI_ZIP`,`PRI_STATE_ID`,`PRI_PHONE`,`PRI_FAX`,`PRI_EMAIL`,`PRI_URL1`,`PRI_URL2`,`SR_FNAME`,`SR_LNAME`,`SR_POSITION`,`SR_ADDRESS`,`SR_CITY`,`SR_DISTRICT`,`SR_ZIP`,`SR_STATE_ID`,`SR_PHONE`,`SR_FAX`,`SR_EMAIL`,`COMMENTS`,`RA_CERTIFIED_PROD`,`PROD_FUTURE`,`PROD_FUTURE_DATE`,`SALE_PURCHASE_RA_PROD`,`SALE_PURCHASE_RA_FUTURE`,`SALE_PURCHASE_RA_FUTURE_DATE`,`TOT_OUTLET`,`TOT_OUTLET_RA`,`ANNUAL_SALE`,`RA_SEAL`,`RA_SEAL_ADVT`,`RA_MEMBERSHIP`,`SALE_PURCHASE_BRAND`,`RA_CERTIFIED_PROD_SUPPLY`,`OTHER_BUSSINESS_TYPE`,`OTHER_BUSS_PRODUCT`,`OTHER_EXP_SALE_PRODUCT`,`OTHER_IMP_SUPPLY_PRODUCT`,`RA_SUPPLY_PROD`,`LOGO_FPHOTO`,`LOGO_SPHOTO`,`LOGO_TPHOTO`,`SEAL_COMMENTS`,`OTHER_PRODUCT`,`RA_PROD_BRAND1`,`RA_PROD_BRAND2`,`RA_PROD_BRAND3`,`RA_PROD_BRAND4`,`NEWL_MEM_FNAME`,`NEWL_MEM_FLNAME`,`NEWL_MEM_FTITLE`,`NEWL_MEM_FEMAIL`,`NEWL_MEM_SNAME`,`NEWL_MEM_SLNAME`,`NEWL_MEM_STITLE`,`NEWL_MEM_SEMAIL`,`NEWL_MEM_TNAME`,`NEWL_MEM_TLNAME`,`NEWL_MEM_TTITLE`,`NEWL_MEM_TEMAIL`,`RA_USER_AGREEMENT`,`RA_PRIVACY_POLICY`,`OTHER_PROD_FORM`,`SCAA_SCORING`,`CUP_PROFILE`,`CUST_PHONE`,`AGREEMENT_STATUS`) VALUES 
 (1,'JP_Morgan ','Maximize Profit','1999-09-10','A','2000-10-10','Morgan',0,'JP','User','	New Delhi','Delhi','Delhi','921056',1,'011202356','010245678945','JP_Morgan@gmail.com','www.JPMorgan.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N'),
 (2,'Barclay_Capital ','Available 24 Hours','2002-12-10','A',NULL,'Barclay',NULL,'Foroses','User','Mumbai','Mumbai','Mumbai',NULL,NULL,NULL,'02245671589','Barclay@gmail.com','www.BarclayCapital.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
 (3,'Glencore_International ','Public Compnay','2000-01-08','A',NULL,'Glencore',0,'Hood','User','Noida','Noida','Noida','8221115',1,'72624','673453','Glencore@gmail.com','www.Glencore_International .com',NULL,'Banana','Apple','user','Sasaram','Sasaram','Rohtas','821115',4,'65356','7665','banapple@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'banana,Apple',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'53456',NULL),
 (4,'Phibro ','Over 100 Years','1913-01-08','A','2006-05-24','Phibro',NULL,'Latern','User','Mumbai','Mumbai','Rohtas','8221115',1,'726243','223445','Phibro@gmail.com','www.Phibro.co.in',NULL,'Banana Food','Apple Food','user','','Sasaram','Rohtas','821115',9,'65356','7665','banapple@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'banana,Apple',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'435435',NULL),
 (5,'Angel Commodity','Owners Are Producers','2010-01-08','A',NULL,'Producers Firm',NULL,'Angel','User','Pune','Pune','Pune','C',1,'324554','454335','AngelCommodity@gmail.com','www.AngelCommodity.com',NULL,'','','','','','','',0,'','','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'banana,Apple',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'6545',NULL),
 (6,'Commodity Trading System','Commodity Trading','2013-01-10','A',NULL,'Admin',NULL,'Admin','Admin','Pune','Pune','Pune','411106',1,'254376','5367376','Commodity_Trading2011@gmail.com','www.commoditytrading.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'7375375','N'),
 (7,'Kotak Commodity','Producer\'s Company','2008-01-08','A',NULL,'Kotak Firm',NULL,'Kotak','User','Nashik','Nashik',NULL,NULL,NULL,NULL,'4424786','Kotak_Commodity@gmai.com','www.KotakCommodity.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'N');
/*!40000 ALTER TABLE `ra_company_master` ENABLE KEYS */;


--
-- Definition of table `ra_company_outlet`
--

DROP TABLE IF EXISTS `ra_company_outlet`;
CREATE TABLE `ra_company_outlet` (
  `COMPANY_ID` int(15) NOT NULL,
  `OUTLET_TYPE_ID` int(15) NOT NULL,
  PRIMARY KEY  (`COMPANY_ID`,`OUTLET_TYPE_ID`),
  KEY `OUTLET_TYPE_ID` (`OUTLET_TYPE_ID`),
  CONSTRAINT `ra_company_outlet_ibfk_1` FOREIGN KEY (`OUTLET_TYPE_ID`) REFERENCES `ra_outlet_master` (`OUTLET_TYPE_ID`),
  CONSTRAINT `ra_company_outlet_ibfk_2` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_outlet`
--

/*!40000 ALTER TABLE `ra_company_outlet` DISABLE KEYS */;
INSERT INTO `ra_company_outlet` (`COMPANY_ID`,`OUTLET_TYPE_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_company_outlet` ENABLE KEYS */;


--
-- Definition of table `ra_company_product`
--

DROP TABLE IF EXISTS `ra_company_product`;
CREATE TABLE `ra_company_product` (
  `COMPANY_ID` int(15) NOT NULL default '0',
  `PRODUCT_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`COMPANY_ID`,`PRODUCT_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `ra_company_product_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `ra_product_master` (`PRODUCT_ID`),
  CONSTRAINT `ra_company_product_ibfk_2` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_product`
--

/*!40000 ALTER TABLE `ra_company_product` DISABLE KEYS */;
INSERT INTO `ra_company_product` (`COMPANY_ID`,`PRODUCT_ID`) VALUES 
 (1,1),
 (2,1),
 (1,2),
 (2,4),
 (3,6),
 (2,8);
/*!40000 ALTER TABLE `ra_company_product` ENABLE KEYS */;


--
-- Definition of table `ra_company_state`
--

DROP TABLE IF EXISTS `ra_company_state`;
CREATE TABLE `ra_company_state` (
  `COMPANY_ID` int(15) NOT NULL default '0',
  `STATE_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`COMPANY_ID`,`STATE_ID`),
  KEY `STATE_ID` (`STATE_ID`),
  CONSTRAINT `ra_company_state_ibfk_1` FOREIGN KEY (`STATE_ID`) REFERENCES `ra_state_master` (`STATE_ID`),
  CONSTRAINT `ra_company_state_ibfk_2` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_company_state`
--

/*!40000 ALTER TABLE `ra_company_state` DISABLE KEYS */;
INSERT INTO `ra_company_state` (`COMPANY_ID`,`STATE_ID`) VALUES 
 (1,1),
 (2,1),
 (3,1),
 (4,1),
 (5,1),
 (6,1),
 (7,1);
/*!40000 ALTER TABLE `ra_company_state` ENABLE KEYS */;


--
-- Definition of table `ra_delivery_month`
--

DROP TABLE IF EXISTS `ra_delivery_month`;
CREATE TABLE `ra_delivery_month` (
  `MONTH_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(20) default NULL,
  `STATUS` varchar(20) default 'Active',
  `DELIVERY_MONTH` varchar(20) default NULL,
  `EXCHANGE_TYPE` varchar(20) default NULL,
  PRIMARY KEY  (`MONTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_delivery_month`
--

/*!40000 ALTER TABLE `ra_delivery_month` DISABLE KEYS */;
INSERT INTO `ra_delivery_month` (`MONTH_ID`,`DESCRIPTION`,`STATUS`,`DELIVERY_MONTH`,`EXCHANGE_TYPE`) VALUES 
 (1,NULL,'Active',NULL,NULL),
 (2,NULL,'Active',NULL,NULL),
 (3,NULL,'Active',NULL,NULL),
 (4,NULL,'Active',NULL,NULL),
 (5,NULL,'Active',NULL,NULL),
 (6,NULL,'Active',NULL,NULL),
 (7,NULL,'Active',NULL,NULL),
 (8,NULL,'Active',NULL,NULL),
 (9,NULL,'Active',NULL,NULL),
 (10,NULL,'Active',NULL,NULL),
 (11,'Bananas','Active','20-05-11','	NYBOT'),
 (12,NULL,'Active',NULL,NULL);
/*!40000 ALTER TABLE `ra_delivery_month` ENABLE KEYS */;


--
-- Definition of table `ra_destination_port`
--

DROP TABLE IF EXISTS `ra_destination_port`;
CREATE TABLE `ra_destination_port` (
  `DEST_PORT_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(255) default NULL,
  `DEST_PORT_STATUS` varchar(20) default 'Active',
  `DESTINATION_PORT` varchar(255) default NULL,
  PRIMARY KEY  (`DEST_PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_destination_port`
--

/*!40000 ALTER TABLE `ra_destination_port` DISABLE KEYS */;
INSERT INTO `ra_destination_port` (`DEST_PORT_ID`,`DESCRIPTION`,`DEST_PORT_STATUS`,`DESTINATION_PORT`) VALUES 
 (1,'Mumbai','Active','West Mumbai'),
 (2,'Pune','Active','Pune'),
 (3,'Aurangabad','Active','Aurangabad'),
 (4,'Nashik','Active','Nashik'),
 (5,'Satara','Active','Satara');
/*!40000 ALTER TABLE `ra_destination_port` ENABLE KEYS */;


--
-- Definition of table `ra_differential`
--

DROP TABLE IF EXISTS `ra_differential`;
CREATE TABLE `ra_differential` (
  `PRICE_EXCHANGE` varchar(20) NOT NULL,
  `PRICE_CONTRACT_MON` varchar(20) NOT NULL,
  `PRICE_EFF_DATE` date NOT NULL,
  `DIFF_CURRENCY` varchar(20) default NULL,
  `DIFF_CRE_TMSTMP` date default NULL,
  `DIFF_UPD_TMSTMP` date default NULL,
  `PRICE_STATUS` varchar(20) default 'Active',
  `EXCHANGE_TYPE` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_differential`
--

/*!40000 ALTER TABLE `ra_differential` DISABLE KEYS */;
/*!40000 ALTER TABLE `ra_differential` ENABLE KEYS */;


--
-- Definition of table `ra_farm_master`
--

DROP TABLE IF EXISTS `ra_farm_master`;
CREATE TABLE `ra_farm_master` (
  `FARM_NAME` varchar(150) NOT NULL,
  `FARM_ID` int(15) NOT NULL,
  PRIMARY KEY  (`FARM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_farm_master`
--

/*!40000 ALTER TABLE `ra_farm_master` DISABLE KEYS */;
INSERT INTO `ra_farm_master` (`FARM_NAME`,`FARM_ID`) VALUES 
 ('Baldev Farm',1),
 ('CHS Farm',2),
 ('Lucky Farm',3),
 ('Ritesh Farm',4);
/*!40000 ALTER TABLE `ra_farm_master` ENABLE KEYS */;


--
-- Definition of table `ra_grade_master`
--

DROP TABLE IF EXISTS `ra_grade_master`;
CREATE TABLE `ra_grade_master` (
  `GRADE_ID` int(15) NOT NULL default '0',
  `GRADE_DISP_NAME` varchar(255) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  `GRADE_TYPE` varchar(255) default NULL,
  `STATUS` varchar(20) default 'Active',
  PRIMARY KEY  (`GRADE_ID`),
  KEY `ORIGIN_ID` (`ORIGIN_ID`),
  CONSTRAINT `ra_grade_master_ibfk_1` FOREIGN KEY (`ORIGIN_ID`) REFERENCES `ra_origin_master` (`ORIGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_grade_master`
--

/*!40000 ALTER TABLE `ra_grade_master` DISABLE KEYS */;
INSERT INTO `ra_grade_master` (`GRADE_ID`,`GRADE_DISP_NAME`,`ORIGIN_ID`,`GRADE_TYPE`,`STATUS`) VALUES 
 (1,'A',1,'A','Active'),
 (2,'B+',1,'B+','Active'),
 (3,'B',1,'B','Active'),
 (201,'A+',1,'A+','Active');
/*!40000 ALTER TABLE `ra_grade_master` ENABLE KEYS */;


--
-- Definition of table `ra_licensing_agreement`
--

DROP TABLE IF EXISTS `ra_licensing_agreement`;
CREATE TABLE `ra_licensing_agreement` (
  `COMPANY_ID` int(15) default NULL,
  `COMPANY_NAME` varchar(100) default NULL,
  `JURISDICTION` varchar(100) default NULL,
  `LEGAL_ENTITY` varchar(100) default NULL,
  `ADDRESS` varchar(100) default NULL,
  `FAX` varchar(25) default NULL,
  `LA_EXIPIRY_DATE` date default NULL,
  `LA_STATUS` char(1) default 'P',
  `CONTACT_NAME` varchar(100) default NULL,
  `LA_START_DATE` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_licensing_agreement`
--

/*!40000 ALTER TABLE `ra_licensing_agreement` DISABLE KEYS */;
/*!40000 ALTER TABLE `ra_licensing_agreement` ENABLE KEYS */;


--
-- Definition of table `ra_load_port`
--

DROP TABLE IF EXISTS `ra_load_port`;
CREATE TABLE `ra_load_port` (
  `LOAD_ID` int(15) NOT NULL default '0',
  `ORIGIN_ID` int(15) NOT NULL,
  `DESCRIPTION` varchar(255) default NULL,
  `LOAD_PORT_STATUS` varchar(20) default 'Active',
  `LOAD_PORT_TYPE` varchar(255) default NULL,
  PRIMARY KEY  (`LOAD_ID`),
  KEY `ORIGIN_ID` (`ORIGIN_ID`),
  CONSTRAINT `ra_load_port_ibfk_1` FOREIGN KEY (`ORIGIN_ID`) REFERENCES `ra_origin_master` (`ORIGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_load_port`
--

/*!40000 ALTER TABLE `ra_load_port` DISABLE KEYS */;
INSERT INTO `ra_load_port` (`LOAD_ID`,`ORIGIN_ID`,`DESCRIPTION`,`LOAD_PORT_STATUS`,`LOAD_PORT_TYPE`) VALUES 
 (1,1,'Mumbai','Active','Mumbai'),
 (3,1,'Aurangabad','Active','Aurangabad'),
 (4,1,'Nashik','Active','Nashik'),
 (501,1,'Pune','Active','Pune');
/*!40000 ALTER TABLE `ra_load_port` ENABLE KEYS */;


--
-- Definition of table `ra_material_master`
--

DROP TABLE IF EXISTS `ra_material_master`;
CREATE TABLE `ra_material_master` (
  `MATERIAL_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(50) default NULL,
  PRIMARY KEY  (`MATERIAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_material_master`
--

/*!40000 ALTER TABLE `ra_material_master` DISABLE KEYS */;
INSERT INTO `ra_material_master` (`MATERIAL_ID`,`DESCRIPTION`) VALUES 
 (1,'Point of Sale Materials');
/*!40000 ALTER TABLE `ra_material_master` ENABLE KEYS */;


--
-- Definition of table `ra_module_access`
--

DROP TABLE IF EXISTS `ra_module_access`;
CREATE TABLE `ra_module_access` (
  `MODULE_ID` int(15) default NULL,
  `ROLE_SHORT_NAME` varchar(10) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_module_access`
--

/*!40000 ALTER TABLE `ra_module_access` DISABLE KEYS */;
INSERT INTO `ra_module_access` (`MODULE_ID`,`ROLE_SHORT_NAME`) VALUES 
 (1,'CA'),
 (2,'PA'),
 (3,'CU'),
 (4,'PU');
/*!40000 ALTER TABLE `ra_module_access` ENABLE KEYS */;


--
-- Definition of table `ra_module_master`
--

DROP TABLE IF EXISTS `ra_module_master`;
CREATE TABLE `ra_module_master` (
  `MODULE_ID` int(10) NOT NULL default '0',
  `MODULE_NAME` varchar(50) NOT NULL,
  `IMAGE_NAME` varchar(50) NOT NULL,
  `IMAGE_WIDTH` int(10) NOT NULL,
  `IMAGE_LAYER_WIDTH` varchar(50) NOT NULL,
  PRIMARY KEY  (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_module_master`
--

/*!40000 ALTER TABLE `ra_module_master` DISABLE KEYS */;
INSERT INTO `ra_module_master` (`MODULE_ID`,`MODULE_NAME`,`IMAGE_NAME`,`IMAGE_WIDTH`,`IMAGE_LAYER_WIDTH`) VALUES 
 (1,'Administration','Administration',110,'150');
/*!40000 ALTER TABLE `ra_module_master` ENABLE KEYS */;


--
-- Definition of table `ra_origin_master`
--

DROP TABLE IF EXISTS `ra_origin_master`;
CREATE TABLE `ra_origin_master` (
  `ORIGIN_ID` int(15) NOT NULL default '0',
  `ORIGIN_DISP_NAME` varchar(255) default NULL,
  `ORIGIN_TYPE` varchar(255) default NULL,
  `ORIGIN_STATUS` varchar(20) default 'Active',
  `ORIGIN_BAG_SIZE` varchar(20) default NULL,
  PRIMARY KEY  (`ORIGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_origin_master`
--

/*!40000 ALTER TABLE `ra_origin_master` DISABLE KEYS */;
INSERT INTO `ra_origin_master` (`ORIGIN_ID`,`ORIGIN_DISP_NAME`,`ORIGIN_TYPE`,`ORIGIN_STATUS`,`ORIGIN_BAG_SIZE`) VALUES 
 (1,'North','North','Active','50 Kg Bags'),
 (2,'South','South','Active','50 kg bags'),
 (3,'West','West','Active',NULL),
 (4,'East','East','Active',NULL);
/*!40000 ALTER TABLE `ra_origin_master` ENABLE KEYS */;


--
-- Definition of table `ra_outlet_master`
--

DROP TABLE IF EXISTS `ra_outlet_master`;
CREATE TABLE `ra_outlet_master` (
  `OUTLET_TYPE_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(100) default NULL,
  PRIMARY KEY  (`OUTLET_TYPE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_outlet_master`
--

/*!40000 ALTER TABLE `ra_outlet_master` DISABLE KEYS */;
INSERT INTO `ra_outlet_master` (`OUTLET_TYPE_ID`,`DESCRIPTION`) VALUES 
 (1,'Coffee Roaster/Retailer'),
 (2,'Food Processor/Manufacturer');
/*!40000 ALTER TABLE `ra_outlet_master` ENABLE KEYS */;


--
-- Definition of table `ra_price_basis`
--

DROP TABLE IF EXISTS `ra_price_basis`;
CREATE TABLE `ra_price_basis` (
  `PR_BASIS_ID` int(15) NOT NULL default '0',
  `PR_BASIS_DSP_NAME` varchar(20) default NULL,
  `PR_BASIS_DESC` varchar(255) default NULL,
  PRIMARY KEY  (`PR_BASIS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_price_basis`
--

/*!40000 ALTER TABLE `ra_price_basis` DISABLE KEYS */;
INSERT INTO `ra_price_basis` (`PR_BASIS_ID`,`PR_BASIS_DSP_NAME`,`PR_BASIS_DESC`) VALUES 
 (1,'	Delivered','	Delivered'),
 (2,'	Overland','	Overland');
/*!40000 ALTER TABLE `ra_price_basis` ENABLE KEYS */;


--
-- Definition of table `ra_prod_region`
--

DROP TABLE IF EXISTS `ra_prod_region`;
CREATE TABLE `ra_prod_region` (
  `PROD_REGION_ID` int(15) NOT NULL default '0',
  `PROD_DESCRIPTION` varchar(50) default NULL,
  `PROD_REGION_TYPE` varchar(50) default NULL,
  `PROD_STATUS` varchar(20) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  PRIMARY KEY  (`PROD_REGION_ID`),
  KEY `ORIGIN_ID` (`ORIGIN_ID`),
  CONSTRAINT `ra_prod_region_ibfk_1` FOREIGN KEY (`ORIGIN_ID`) REFERENCES `ra_origin_master` (`ORIGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_prod_region`
--

/*!40000 ALTER TABLE `ra_prod_region` DISABLE KEYS */;
INSERT INTO `ra_prod_region` (`PROD_REGION_ID`,`PROD_DESCRIPTION`,`PROD_REGION_TYPE`,`PROD_STATUS`,`ORIGIN_ID`) VALUES 
 (301,'	A24seven','	A24seven','Active',1);
/*!40000 ALTER TABLE `ra_prod_region` ENABLE KEYS */;


--
-- Definition of table `ra_prod_req_int`
--

DROP TABLE IF EXISTS `ra_prod_req_int`;
CREATE TABLE `ra_prod_req_int` (
  `PROD_REQ_ID` int(15) NOT NULL,
  `DESCRIPTION` varchar(100) default NULL,
  PRIMARY KEY  (`PROD_REQ_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_prod_req_int`
--

/*!40000 ALTER TABLE `ra_prod_req_int` DISABLE KEYS */;
INSERT INTO `ra_prod_req_int` (`PROD_REQ_ID`,`DESCRIPTION`) VALUES 
 (1,'Information for Research'),
 (2,'Registering my Company');
/*!40000 ALTER TABLE `ra_prod_req_int` ENABLE KEYS */;


--
-- Definition of table `ra_producer_data_upload`
--

DROP TABLE IF EXISTS `ra_producer_data_upload`;
CREATE TABLE `ra_producer_data_upload` (
  `PRODUCER_ID` int(15) NOT NULL auto_increment,
  `CER_YEAR` varchar(100) NOT NULL,
  `FARM_NAME` varchar(150) NOT NULL,
  `VARIETY` varchar(50) default NULL,
  `ALTITUDE` varchar(50) default NULL,
  `TOTAL_HECTARES` double default NULL,
  `PROD_HECTARES` double default NULL,
  `LONGITUDE` varchar(50) default NULL,
  `LATITUDE` varchar(50) default NULL,
  `ANNUAL_QTY` varchar(50) default NULL,
  `CER_EXPIRE_DATE` date default NULL,
  `CER_NUMBER` varchar(50) default NULL,
  `PICTURES_UPLOAD` varchar(255) default NULL,
  `FARM_UNIQUE_INFO` varchar(500) default NULL,
  `SPECIAL_PROJECT` varchar(500) default NULL,
  `SPECIAL_CONSERVATION` varchar(500) default NULL,
  `RA_BENEFITS` varchar(500) default NULL,
  `OTHER_CER_NUMBER` varchar(50) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  `GRADE_ID` int(15) default NULL,
  `FARM_ID` int(15) default NULL,
  UNIQUE KEY `PRODUCER_ID` (`PRODUCER_ID`,`FARM_NAME`,`CER_YEAR`),
  CONSTRAINT `ra_producer_data_upload_ibfk_1` FOREIGN KEY (`PRODUCER_ID`) REFERENCES `ra_producer_master` (`PRODUCER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_producer_data_upload`
--

/*!40000 ALTER TABLE `ra_producer_data_upload` DISABLE KEYS */;
INSERT INTO `ra_producer_data_upload` (`PRODUCER_ID`,`CER_YEAR`,`FARM_NAME`,`VARIETY`,`ALTITUDE`,`TOTAL_HECTARES`,`PROD_HECTARES`,`LONGITUDE`,`LATITUDE`,`ANNUAL_QTY`,`CER_EXPIRE_DATE`,`CER_NUMBER`,`PICTURES_UPLOAD`,`FARM_UNIQUE_INFO`,`SPECIAL_PROJECT`,`SPECIAL_CONSERVATION`,`RA_BENEFITS`,`OTHER_CER_NUMBER`,`ORIGIN_ID`,`GRADE_ID`,`FARM_ID`) VALUES 
 (1,'2013','Baldev Farm',NULL,'12',15,3,'13.23','72.87','100','2014-03-03','1',NULL,NULL,NULL,NULL,NULL,NULL,1,1,1),
 (2,'2013','CHS Farm',NULL,NULL,25,5,'13.23','72.89','150','2014-03-03','2',NULL,NULL,NULL,NULL,NULL,NULL,1,1,2),
 (3,'2013','Lucky Farm',NULL,NULL,12,4,'15.45','50.44','80','2014-03-03','3',NULL,NULL,NULL,NULL,NULL,NULL,1,1,3),
 (4,'2014','Ritesh Farm',NULL,NULL,23,8,'15.45','78.98','200','2014-03-03','4',NULL,NULL,NULL,NULL,NULL,NULL,1,1,4);
/*!40000 ALTER TABLE `ra_producer_data_upload` ENABLE KEYS */;


--
-- Definition of table `ra_producer_event_data`
--

DROP TABLE IF EXISTS `ra_producer_event_data`;
CREATE TABLE `ra_producer_event_data` (
  `PRODUCER_ID` int(15) NOT NULL default '0',
  `QTY_VIOLATION` varchar(20) default NULL,
  `TRANS_ID` int(15) NOT NULL default '0',
  `VIOLATION_DATE` date default NULL,
  `FARM_NAME` varchar(100) default NULL,
  PRIMARY KEY  (`PRODUCER_ID`,`TRANS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_producer_event_data`
--

/*!40000 ALTER TABLE `ra_producer_event_data` DISABLE KEYS */;
INSERT INTO `ra_producer_event_data` (`PRODUCER_ID`,`QTY_VIOLATION`,`TRANS_ID`,`VIOLATION_DATE`,`FARM_NAME`) VALUES 
 (501,'-10.0',601,'2020-08-10','889');
/*!40000 ALTER TABLE `ra_producer_event_data` ENABLE KEYS */;


--
-- Definition of table `ra_producer_event_data_edit`
--

DROP TABLE IF EXISTS `ra_producer_event_data_edit`;
CREATE TABLE `ra_producer_event_data_edit` (
  `PRODUCER_ID` int(15) default NULL,
  `QTY_VIOLATION` varchar(20) default NULL,
  `TRANS_ID` int(15) NOT NULL,
  `VIOLATION_DATE` date default NULL,
  `FARM_NAME` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_producer_event_data_edit`
--

/*!40000 ALTER TABLE `ra_producer_event_data_edit` DISABLE KEYS */;
/*!40000 ALTER TABLE `ra_producer_event_data_edit` ENABLE KEYS */;


--
-- Definition of table `ra_producer_master`
--

DROP TABLE IF EXISTS `ra_producer_master`;
CREATE TABLE `ra_producer_master` (
  `PRODUCER_ID` int(15) NOT NULL auto_increment,
  `ORIGNIZATION_NAME` varchar(150) default NULL,
  `LAST_LOGIN_TIMESTAMP` date default NULL,
  `SEND_REMIND_MAIL` int(15) default NULL,
  `CONTACT_NAME` varchar(100) default NULL,
  `PRODUCER_STATUS` char(1) default NULL,
  `EMAIL` varchar(100) default NULL,
  `SALES_CONTACT` varchar(100) default NULL,
  `CITY` varchar(50) default NULL,
  `SALES_EMAIL` varchar(100) default NULL,
  `SALES_PHONE` varchar(50) default NULL,
  `SALES_FAX` varchar(50) default NULL,
  `SALES_URL` char(80) default NULL,
  `CREATE_DATE` date default NULL,
  `UPDATE_DATE` date default NULL,
  `ANONYMOUS` char(1) default NULL,
  `STATE` varchar(100) default NULL,
  `USER_ID` int(15) default NULL,
  `CONSUME_QTY` int(15) default NULL,
  `TOTAL_QTY` int(15) default NULL,
  `PROD_REGION_ID` int(15) default NULL,
  `PRODUCT_ID` int(15) default '1',
  PRIMARY KEY  (`PRODUCER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_producer_master`
--

/*!40000 ALTER TABLE `ra_producer_master` DISABLE KEYS */;
INSERT INTO `ra_producer_master` (`PRODUCER_ID`,`ORIGNIZATION_NAME`,`LAST_LOGIN_TIMESTAMP`,`SEND_REMIND_MAIL`,`CONTACT_NAME`,`PRODUCER_STATUS`,`EMAIL`,`SALES_CONTACT`,`CITY`,`SALES_EMAIL`,`SALES_PHONE`,`SALES_FAX`,`SALES_URL`,`CREATE_DATE`,`UPDATE_DATE`,`ANONYMOUS`,`STATE`,`USER_ID`,`CONSUME_QTY`,`TOTAL_QTY`,`PROD_REGION_ID`,`PRODUCT_ID`) VALUES 
 (1,'Baldev',NULL,NULL,'Baldev Pawar','A','baldev@gmail.com','988998766','Baramati',NULL,NULL,NULL,NULL,'2013-03-03',NULL,NULL,'Maharashtra',10,NULL,100,NULL,1),
 (2,'Chandrakant',NULL,NULL,'Chandrakant','A','Chandrakant@gmail.com','9874365469','Pune',NULL,'8754645109','20374859','www.chs.com','2013-03-29',NULL,NULL,'Maharashtra',11,NULL,NULL,NULL,3),
 (3,'Lucky',NULL,NULL,'Lucky singh','A','Luckysingh@gmail.com','9874365469','Aurangabad',NULL,'8754645109','20374859','www.chs.com','2013-03-29',NULL,NULL,'Maharashtra',13,NULL,NULL,NULL,10),
 (4,'Grape farm',NULL,NULL,'Ritesh','A','ritesh@gmail.com','9874365469','Nanded',NULL,'8754645109','20374859','www.chs.com','2013-03-29',NULL,NULL,'Maharashtra',18,NULL,NULL,NULL,12),
 (5,'CHS',NULL,NULL,'CHS','A','chs@gmail.com','9874365469','Vanarasi',NULL,'8754645109','20374859','www.chs.com',NULL,NULL,NULL,'UP',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ra_producer_master` ENABLE KEYS */;


--
-- Definition of table `ra_product_master`
--

DROP TABLE IF EXISTS `ra_product_master`;
CREATE TABLE `ra_product_master` (
  `PRODUCT_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(50) default NULL,
  `PRODUCT_STATUS` varchar(20) default 'Active',
  `PRODUCT_TYPE` varchar(50) default NULL,
  PRIMARY KEY  (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_product_master`
--

/*!40000 ALTER TABLE `ra_product_master` DISABLE KEYS */;
INSERT INTO `ra_product_master` (`PRODUCT_ID`,`DESCRIPTION`,`PRODUCT_STATUS`,`PRODUCT_TYPE`) VALUES 
 (1,'Banana ','Active','Bananaa'),
 (2,'Apple','Active','Apple'),
 (3,'Mango ','Active','Mango'),
 (4,'Potato','Active','Potato'),
 (5,'Cabbage','Active','Cabbage'),
 (6,'Capsicum','Active','Capsicum'),
 (7,'Carrot','Active','Carrot'),
 (8,'Chilli','Active','Chilli'),
 (9,'Garlic','Active','Garlic'),
 (10,'Onion','Active','Onion'),
 (11,'Turmeric','Active','Turmeric'),
 (12,'Grape','Active','grape'),
 (13,'Coconut','Active','Coconut');
/*!40000 ALTER TABLE `ra_product_master` ENABLE KEYS */;


--
-- Definition of table `ra_request_buss`
--

DROP TABLE IF EXISTS `ra_request_buss`;
CREATE TABLE `ra_request_buss` (
  `REQUEST_ID` int(15) NOT NULL default '0',
  `BUISNESS_TYPE_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`REQUEST_ID`,`BUISNESS_TYPE_ID`),
  KEY `BUISNESS_TYPE_ID` (`BUISNESS_TYPE_ID`),
  CONSTRAINT `ra_request_buss_ibfk_1` FOREIGN KEY (`BUISNESS_TYPE_ID`) REFERENCES `ra_bussiness_type_master` (`BUISNESS_TYPE_ID`),
  CONSTRAINT `ra_request_buss_ibfk_2` FOREIGN KEY (`REQUEST_ID`) REFERENCES `ra_request_info` (`REQUEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_request_buss`
--

/*!40000 ALTER TABLE `ra_request_buss` DISABLE KEYS */;
INSERT INTO `ra_request_buss` (`REQUEST_ID`,`BUISNESS_TYPE_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_request_buss` ENABLE KEYS */;


--
-- Definition of table `ra_request_info`
--

DROP TABLE IF EXISTS `ra_request_info`;
CREATE TABLE `ra_request_info` (
  `REQUEST_ID` int(15) NOT NULL default '0',
  `CREATE_DATE` date default NULL,
  `MODIFY_DATE` date default NULL,
  `COMPANY_NAME` varchar(100) default NULL,
  `FIRST_NAME` varchar(50) default NULL,
  `COMPANY_HOLDING` varchar(100) default NULL,
  `POSITION` varchar(50) default NULL,
  `OFF_ADDRESS` varchar(100) default NULL,
  `CITY` varchar(50) default NULL,
  `STATE` varchar(50) default NULL,
  `ZIP` varchar(20) default NULL,
  `COUNTRY_ID` int(15) default NULL,
  `PHONE` varchar(25) default NULL,
  `FAX` varchar(25) default NULL,
  `EMAIL` varchar(50) default NULL,
  `COMMENTS` varchar(500) default NULL,
  `REQUEST_STATUS` char(1) default 'A',
  `OTHER_BUSS_TYPE` varchar(20) default NULL,
  `OTHER_PRODUCT` varchar(20) default NULL,
  `PROD_REQ_ID` int(15) default NULL,
  `PROD_REQ_OTHER` varchar(100) default NULL,
  `PROD_INTEREST` varchar(100) default NULL,
  PRIMARY KEY  (`REQUEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_request_info`
--

/*!40000 ALTER TABLE `ra_request_info` DISABLE KEYS */;
INSERT INTO `ra_request_info` (`REQUEST_ID`,`CREATE_DATE`,`MODIFY_DATE`,`COMPANY_NAME`,`FIRST_NAME`,`COMPANY_HOLDING`,`POSITION`,`OFF_ADDRESS`,`CITY`,`STATE`,`ZIP`,`COUNTRY_ID`,`PHONE`,`FAX`,`EMAIL`,`COMMENTS`,`REQUEST_STATUS`,`OTHER_BUSS_TYPE`,`OTHER_PRODUCT`,`PROD_REQ_ID`,`PROD_REQ_OTHER`,`PROD_INTEREST`) VALUES 
 (1,'2015-08-09','2010-10-10','Coffee House','	Sangeetha','	Sangeetha Coffee','CEO','Pune','Pune','Maharastra','411028',1,'020365754',NULL,'sangeethaCoffee@gmail.com',NULL,'A',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ra_request_info` ENABLE KEYS */;


--
-- Definition of table `ra_request_product`
--

DROP TABLE IF EXISTS `ra_request_product`;
CREATE TABLE `ra_request_product` (
  `REQUEST_ID` int(15) NOT NULL default '0',
  `PRODUCT_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`REQUEST_ID`,`PRODUCT_ID`),
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  CONSTRAINT `ra_request_product_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `ra_product_master` (`PRODUCT_ID`),
  CONSTRAINT `ra_request_product_ibfk_2` FOREIGN KEY (`REQUEST_ID`) REFERENCES `ra_request_info` (`REQUEST_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_request_product`
--

/*!40000 ALTER TABLE `ra_request_product` DISABLE KEYS */;
INSERT INTO `ra_request_product` (`REQUEST_ID`,`PRODUCT_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_request_product` ENABLE KEYS */;


--
-- Definition of table `ra_role_master`
--

DROP TABLE IF EXISTS `ra_role_master`;
CREATE TABLE `ra_role_master` (
  `ROLE_ID` int(15) NOT NULL default '0',
  `ROLE_NAME` varchar(50) default NULL,
  `ROLE_SHORT_NAME` varchar(5) default NULL,
  PRIMARY KEY  (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_role_master`
--

/*!40000 ALTER TABLE `ra_role_master` DISABLE KEYS */;
INSERT INTO `ra_role_master` (`ROLE_ID`,`ROLE_NAME`,`ROLE_SHORT_NAME`) VALUES 
 (1,'Company Admin','CA'),
 (2,'Company User','CU'),
 (3,'	Producer Admin','PA'),
 (4,'Producer User','PU'),
 (5,'Administrator','A'),
 (6,'Admin User','AU');
/*!40000 ALTER TABLE `ra_role_master` ENABLE KEYS */;


--
-- Definition of table `ra_seal_brand`
--

DROP TABLE IF EXISTS `ra_seal_brand`;
CREATE TABLE `ra_seal_brand` (
  `SEAL_ID` int(15) default NULL,
  `BRAND_ID` int(15) default NULL,
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_brand_ibfk_1` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_brand`
--

/*!40000 ALTER TABLE `ra_seal_brand` DISABLE KEYS */;
INSERT INTO `ra_seal_brand` (`SEAL_ID`,`BRAND_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_seal_brand` ENABLE KEYS */;


--
-- Definition of table `ra_seal_history`
--

DROP TABLE IF EXISTS `ra_seal_history`;
CREATE TABLE `ra_seal_history` (
  `SEAL_ID` int(15) default NULL,
  `CREATE_DATE` date default NULL,
  `USER_ID` int(15) default NULL,
  `ACTIVITY_TYPE` varchar(20) default NULL,
  `ACTIVITY_DESC` varchar(4000) default NULL,
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_history_ibfk_1` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_history`
--

/*!40000 ALTER TABLE `ra_seal_history` DISABLE KEYS */;
INSERT INTO `ra_seal_history` (`SEAL_ID`,`CREATE_DATE`,`USER_ID`,`ACTIVITY_TYPE`,`ACTIVITY_DESC`) VALUES 
 (1,'2020-06-10',1,'Updated','Supplier'),
 (1,'2020-06-10',1,'Updated','Supplier'),
 (1,'2020-06-10',1,'Updated','Supplier');
/*!40000 ALTER TABLE `ra_seal_history` ENABLE KEYS */;


--
-- Definition of table `ra_seal_master`
--

DROP TABLE IF EXISTS `ra_seal_master`;
CREATE TABLE `ra_seal_master` (
  `SEAL_ID` int(15) NOT NULL default '0',
  `COMPANY_ID` int(15) default NULL,
  `NAME` varchar(50) default NULL,
  `EMAIL` varchar(100) default NULL,
  `UPLOAD_DATA1` varchar(200) default NULL,
  `UPLOAD_DATA2` varchar(200) default NULL,
  `UPLOAD_DATA3` varchar(200) default NULL,
  `UPLOAD_DATA4` varchar(200) default NULL,
  `APPLICATION_DATE` date default NULL,
  `LAUNCH_DATE` date default NULL,
  `REG_AREAS` char(1) default NULL,
  `BLEND_RA_CER_CONTENT` char(1) default NULL,
  `PROD_CONTENT` char(1) default NULL,
  `SELL_PROD_OUTLET` varchar(50) default NULL,
  `OTHER_SEAL_PROD` varchar(20) default NULL,
  `OTHER_MATERIAL` varchar(20) default NULL,
  `OTHER_OUTLET` varchar(20) default NULL,
  `SEAL_STATUS` char(1) default NULL,
  `OTHER_REGION` varchar(20) default NULL,
  `OTHER_SUPPLIER` varchar(20) default NULL,
  `APPLICATION_COMMENTS` varchar(4000) default NULL,
  `OPTIONAL` varchar(1200) character set utf8 default NULL,
  `MANDATORY` varchar(1200) character set utf8 default NULL,
  PRIMARY KEY  (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_master`
--

/*!40000 ALTER TABLE `ra_seal_master` DISABLE KEYS */;
INSERT INTO `ra_seal_master` (`SEAL_ID`,`COMPANY_ID`,`NAME`,`EMAIL`,`UPLOAD_DATA1`,`UPLOAD_DATA2`,`UPLOAD_DATA3`,`UPLOAD_DATA4`,`APPLICATION_DATE`,`LAUNCH_DATE`,`REG_AREAS`,`BLEND_RA_CER_CONTENT`,`PROD_CONTENT`,`SELL_PROD_OUTLET`,`OTHER_SEAL_PROD`,`OTHER_MATERIAL`,`OTHER_OUTLET`,`SEAL_STATUS`,`OTHER_REGION`,`OTHER_SUPPLIER`,`APPLICATION_COMMENTS`,`OPTIONAL`,`MANDATORY`) VALUES 
 (1,1,'kunal','kunal@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ra_seal_master` ENABLE KEYS */;


--
-- Definition of table `ra_seal_material`
--

DROP TABLE IF EXISTS `ra_seal_material`;
CREATE TABLE `ra_seal_material` (
  `MATERIAL_ID` int(15) NOT NULL default '0',
  `SEAL_ID` int(15) NOT NULL default '0',
  PRIMARY KEY  (`MATERIAL_ID`,`SEAL_ID`),
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_material_ibfk_1` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`),
  CONSTRAINT `ra_seal_material_ibfk_2` FOREIGN KEY (`MATERIAL_ID`) REFERENCES `ra_material_master` (`MATERIAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_material`
--

/*!40000 ALTER TABLE `ra_seal_material` DISABLE KEYS */;
INSERT INTO `ra_seal_material` (`MATERIAL_ID`,`SEAL_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_seal_material` ENABLE KEYS */;


--
-- Definition of table `ra_seal_product`
--

DROP TABLE IF EXISTS `ra_seal_product`;
CREATE TABLE `ra_seal_product` (
  `SEAL_ID` int(15) default NULL,
  `PRODUCT_ID` int(15) default NULL,
  KEY `PRODUCT_ID` (`PRODUCT_ID`),
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_product_ibfk_1` FOREIGN KEY (`PRODUCT_ID`) REFERENCES `ra_product_master` (`PRODUCT_ID`),
  CONSTRAINT `ra_seal_product_ibfk_2` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_product`
--

/*!40000 ALTER TABLE `ra_seal_product` DISABLE KEYS */;
INSERT INTO `ra_seal_product` (`SEAL_ID`,`PRODUCT_ID`) VALUES 
 (1,1);
/*!40000 ALTER TABLE `ra_seal_product` ENABLE KEYS */;


--
-- Definition of table `ra_seal_state`
--

DROP TABLE IF EXISTS `ra_seal_state`;
CREATE TABLE `ra_seal_state` (
  `SEAL_ID` int(15) default NULL,
  `REGION_ID` int(15) default NULL,
  `STATE_ID` int(15) default NULL,
  KEY `STATE_ID` (`STATE_ID`),
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_state_ibfk_1` FOREIGN KEY (`STATE_ID`) REFERENCES `ra_state_master` (`STATE_ID`),
  CONSTRAINT `ra_seal_state_ibfk_2` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_state`
--

/*!40000 ALTER TABLE `ra_seal_state` DISABLE KEYS */;
INSERT INTO `ra_seal_state` (`SEAL_ID`,`REGION_ID`,`STATE_ID`) VALUES 
 (1,1,11),
 (1,5,11);
/*!40000 ALTER TABLE `ra_seal_state` ENABLE KEYS */;


--
-- Definition of table `ra_seal_supplier`
--

DROP TABLE IF EXISTS `ra_seal_supplier`;
CREATE TABLE `ra_seal_supplier` (
  `COMPANY_ID` int(15) default NULL,
  `SEAL_ID` int(15) default NULL,
  `SUPPLIER_TYPE` int(15) default NULL,
  KEY `SEAL_ID` (`SEAL_ID`),
  CONSTRAINT `ra_seal_supplier_ibfk_1` FOREIGN KEY (`SEAL_ID`) REFERENCES `ra_seal_master` (`SEAL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_seal_supplier`
--

/*!40000 ALTER TABLE `ra_seal_supplier` DISABLE KEYS */;
INSERT INTO `ra_seal_supplier` (`COMPANY_ID`,`SEAL_ID`,`SUPPLIER_TYPE`) VALUES 
 (1,1,1);
/*!40000 ALTER TABLE `ra_seal_supplier` ENABLE KEYS */;


--
-- Definition of table `ra_selling_region`
--

DROP TABLE IF EXISTS `ra_selling_region`;
CREATE TABLE `ra_selling_region` (
  `REGION_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(50) default NULL,
  `REGION_TYPE` varchar(50) default NULL,
  `STATUS` varchar(20) default 'Active',
  PRIMARY KEY  (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_selling_region`
--

/*!40000 ALTER TABLE `ra_selling_region` DISABLE KEYS */;
INSERT INTO `ra_selling_region` (`REGION_ID`,`DESCRIPTION`,`REGION_TYPE`,`STATUS`) VALUES 
 (1,'East','East ','Active'),
 (2,'North ','North ','Active'),
 (3,'South ','South ','Active'),
 (4,'West','West','Active');
/*!40000 ALTER TABLE `ra_selling_region` ENABLE KEYS */;


--
-- Definition of table `ra_state_master`
--

DROP TABLE IF EXISTS `ra_state_master`;
CREATE TABLE `ra_state_master` (
  `STATE_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(50) default NULL,
  `REGION_ID` int(15) default NULL,
  `STATE_STATUS` varchar(20) default 'Active',
  `STATE_TYPE` varchar(50) default NULL,
  PRIMARY KEY  (`STATE_ID`),
  KEY `REGION_ID` (`REGION_ID`),
  CONSTRAINT `ra_state_master_ibfk_1` FOREIGN KEY (`REGION_ID`) REFERENCES `ra_selling_region` (`REGION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_state_master`
--

/*!40000 ALTER TABLE `ra_state_master` DISABLE KEYS */;
INSERT INTO `ra_state_master` (`STATE_ID`,`DESCRIPTION`,`REGION_ID`,`STATE_STATUS`,`STATE_TYPE`) VALUES 
 (1,'Maharashtra',4,'Active','Maharashtra'),
 (2,'Gujarat',4,'Active','Gujrat'),
 (3,'Rajastan',4,'Active','Rajastan'),
 (4,'Utter Pradesh',2,'Active','UP'),
 (5,'Madhya Pradesh',2,'Active','Mp'),
 (6,'Andhra Pradesh',3,'Active','AP'),
 (7,'Karnataka',3,'Active','Karnatka'),
 (8,'Tamilnadu',3,'Active','Tamil'),
 (9,'Jamu & Kashmir',2,'Active','Jammu'),
 (10,'Kerala',3,'Active','Kerala'),
 (11,'Himachal Pradesh',2,'Active','Himachal Pradesh'),
 (15,'Jharkhand',2,'Active','Jharkhand'),
 (18,'Bihar',1,'Active','Bihar'),
 (19,'Delhi',2,'Active','Delhi');
/*!40000 ALTER TABLE `ra_state_master` ENABLE KEYS */;


--
-- Definition of table `ra_sub_module`
--

DROP TABLE IF EXISTS `ra_sub_module`;
CREATE TABLE `ra_sub_module` (
  `SUB_MODULE_ID` int(15) NOT NULL default '0',
  `SUB_MODULE_NAME` varchar(50) default NULL,
  `MODULE_ID` int(15) default NULL,
  PRIMARY KEY  (`SUB_MODULE_ID`),
  KEY `MODULE_ID` (`MODULE_ID`),
  CONSTRAINT `ra_sub_module_ibfk_1` FOREIGN KEY (`MODULE_ID`) REFERENCES `ra_module_master` (`MODULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_sub_module`
--

/*!40000 ALTER TABLE `ra_sub_module` DISABLE KEYS */;
INSERT INTO `ra_sub_module` (`SUB_MODULE_ID`,`SUB_MODULE_NAME`,`MODULE_ID`) VALUES 
 (1,'Manage Masters',1);
/*!40000 ALTER TABLE `ra_sub_module` ENABLE KEYS */;


--
-- Definition of table `ra_submod_access`
--

DROP TABLE IF EXISTS `ra_submod_access`;
CREATE TABLE `ra_submod_access` (
  `SUB_MODULE_ID` int(15) default NULL,
  `ROLE_SHORT_NAME` varchar(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_submod_access`
--

/*!40000 ALTER TABLE `ra_submod_access` DISABLE KEYS */;
INSERT INTO `ra_submod_access` (`SUB_MODULE_ID`,`ROLE_SHORT_NAME`) VALUES 
 (1,'CU'),
 (2,'PU'),
 (3,'PA'),
 (4,'CA');
/*!40000 ALTER TABLE `ra_submod_access` ENABLE KEYS */;


--
-- Definition of table `ra_trac_crop_year`
--

DROP TABLE IF EXISTS `ra_trac_crop_year`;
CREATE TABLE `ra_trac_crop_year` (
  `CROP_YEAR_ID` int(15) NOT NULL default '0',
  `DESCRIPTION` varchar(20) default NULL,
  PRIMARY KEY  (`CROP_YEAR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_trac_crop_year`
--

/*!40000 ALTER TABLE `ra_trac_crop_year` DISABLE KEYS */;
INSERT INTO `ra_trac_crop_year` (`CROP_YEAR_ID`,`DESCRIPTION`) VALUES 
 (1,'2010-2011'),
 (2,'2011-2012'),
 (3,'2012-2013'),
 (4,'2013-2014'),
 (5,'2014-2015');
/*!40000 ALTER TABLE `ra_trac_crop_year` ENABLE KEYS */;


--
-- Definition of table `ra_trace_consume`
--

DROP TABLE IF EXISTS `ra_trace_consume`;
CREATE TABLE `ra_trace_consume` (
  `TRANS_ID` int(15) default NULL,
  `CONTAINER_ID` int(15) default NULL,
  `CONSUME_QTY` int(15) default NULL,
  `BRAND_ID` int(15) default NULL,
  `CONSUME_DATE` date default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_trace_consume`
--

/*!40000 ALTER TABLE `ra_trace_consume` DISABLE KEYS */;
INSERT INTO `ra_trace_consume` (`TRANS_ID`,`CONTAINER_ID`,`CONSUME_QTY`,`BRAND_ID`,`CONSUME_DATE`) VALUES 
 (101,201,1000,401,'2010-01-10');
/*!40000 ALTER TABLE `ra_trace_consume` ENABLE KEYS */;


--
-- Definition of table `ra_trace_offers`
--

DROP TABLE IF EXISTS `ra_trace_offers`;
CREATE TABLE `ra_trace_offers` (
  `OFFER_ID` int(15) NOT NULL default '0',
  `COMPANY_ID` int(15) default NULL,
  `OFFER_DATE` date default NULL,
  `AVAILABILITY_DATE` date default NULL,
  `EXPIRATION_DATE` date default NULL,
  `USER_ID` int(15) default NULL,
  `FIRST_NAME` varchar(50) default NULL,
  `LAST_NAME` varchar(50) default NULL,
  `EMAIL` varchar(50) default NULL,
  `PHONE` varchar(25) default NULL,
  `OFFER_QTY` int(15) default NULL,
  `QTY_UOM` varchar(50) default NULL,
  `OFFER_PRICE` int(15) default NULL,
  `OFFER_PRICE_UOM` varchar(50) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  `GRADE_ID` int(15) default NULL,
  `COUNTRY_ID` int(15) default NULL,
  `CITY` varchar(255) default NULL,
  `COMMENTS` varchar(300) default NULL,
  `PRODUCER_ID` int(15) default NULL,
  `DEST_PORT_ID` int(15) default NULL,
  `LOAD_ID` int(15) default NULL,
  `PRODUCT_ID` int(15) default NULL,
  `FARM_NAME` varchar(150) default NULL,
  `OTHER_CITY` varchar(255) default NULL,
  `FARM_ID` int(15) default NULL,
  PRIMARY KEY  (`OFFER_ID`),
  KEY `ORIGIN_ID` (`ORIGIN_ID`),
  KEY `GRADE_ID` (`GRADE_ID`),
  KEY `DEST_PORT_ID` (`DEST_PORT_ID`),
  KEY `COMPANY_ID` (`COMPANY_ID`),
  CONSTRAINT `ra_trace_offers_ibfk_1` FOREIGN KEY (`ORIGIN_ID`) REFERENCES `ra_origin_master` (`ORIGIN_ID`),
  CONSTRAINT `ra_trace_offers_ibfk_2` FOREIGN KEY (`GRADE_ID`) REFERENCES `ra_grade_master` (`GRADE_ID`),
  CONSTRAINT `ra_trace_offers_ibfk_3` FOREIGN KEY (`DEST_PORT_ID`) REFERENCES `ra_destination_port` (`DEST_PORT_ID`),
  CONSTRAINT `ra_trace_offers_ibfk_4` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_trace_offers`
--

/*!40000 ALTER TABLE `ra_trace_offers` DISABLE KEYS */;
INSERT INTO `ra_trace_offers` (`OFFER_ID`,`COMPANY_ID`,`OFFER_DATE`,`AVAILABILITY_DATE`,`EXPIRATION_DATE`,`USER_ID`,`FIRST_NAME`,`LAST_NAME`,`EMAIL`,`PHONE`,`OFFER_QTY`,`QTY_UOM`,`OFFER_PRICE`,`OFFER_PRICE_UOM`,`ORIGIN_ID`,`GRADE_ID`,`COUNTRY_ID`,`CITY`,`COMMENTS`,`PRODUCER_ID`,`DEST_PORT_ID`,`LOAD_ID`,`PRODUCT_ID`,`FARM_NAME`,`OTHER_CITY`,`FARM_ID`) VALUES 
 (1,1,'2013-02-10','2013-03-10','2013-02-10',2,'mehta','Company','mehta@gmail.com','020238794',100,'25 Kg Bag',50000,'USD/Kg',1,201,1,'Pune','better quality',10,1,1,1,'Bladev Farm','Banana',1),
 (2,2,'2013-01-07','2013-02-07','2013-02-08',5,'Mahesh','sonu','chandrakant@gmail.com','76002637',100,'25Kg Bag',25000,'10 Per kg',1,201,6,'pune','Better Quality',11,1,501,4,NULL,'',2),
 (5,2,'2013-04-05','2013-05-05','2013-05-06',10,'narsing','bhadekar','bnarsing@','2222222',200,'45 kg/bag',50000,'5000',1,201,1,'pune','dfdf',NULL,2,1,0,NULL,'',2);
/*!40000 ALTER TABLE `ra_trace_offers` ENABLE KEYS */;


--
-- Definition of table `ra_traceability`
--

DROP TABLE IF EXISTS `ra_traceability`;
CREATE TABLE `ra_traceability` (
  `TRACE_ID` int(15) NOT NULL,
  `CUSTOMER_ID` int(15) default NULL,
  `TRANS_DATE` date default NULL,
  `BUYER_ID` varchar(20) default NULL,
  `SELLER_ID` varchar(20) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  `CROP_YEAR_ID` int(15) default NULL,
  `PR_BASIS_ID` int(15) default NULL,
  `PRICE_TYPE` varchar(50) default NULL,
  `PRICE` double default NULL,
  `PRICE_UNIT` varchar(50) default NULL,
  `PRCIE_EXCHANGE` varchar(20) default NULL,
  `STATE_ID` int(15) default NULL,
  `LOAD_ID` int(15) default NULL,
  `DEST_PORT_ID` int(15) default NULL,
  `ORDER_TYPE` varchar(20) default NULL,
  `DELIVERY_MONTH_ID` int(15) default NULL,
  `USER_ID` int(15) default NULL,
  `NO_OF_CONTAINERS` int(15) default NULL,
  `STATUS` char(2) default 'A',
  `PARENT_TRANS_ID` int(15) default NULL,
  `CREATE_DATE` date default NULL,
  `PREM_PRICE` double default NULL,
  `PREM_PRICE_UOM` varchar(50) default NULL,
  `PREV_STATUS` char(2) default NULL,
  `TRANSACTION_ID` int(15) unsigned default '1000',
  PRIMARY KEY  (`TRACE_ID`),
  UNIQUE KEY `TRANS_ID` USING BTREE (`TRACE_ID`,`CUSTOMER_ID`),
  KEY `DEST_PORT_ID` (`DEST_PORT_ID`),
  KEY `ORIGIN_ID` (`ORIGIN_ID`),
  KEY `CROP_YEAR_ID` (`CROP_YEAR_ID`),
  KEY `PR_BASIS_ID` (`PR_BASIS_ID`),
  KEY `STATE_ID` (`STATE_ID`),
  KEY `LOAD_ID` (`LOAD_ID`),
  KEY `DELIVERY_MONTH_ID` (`DELIVERY_MONTH_ID`),
  CONSTRAINT `ra_traceability_ibfk_1` FOREIGN KEY (`DEST_PORT_ID`) REFERENCES `ra_destination_port` (`DEST_PORT_ID`),
  CONSTRAINT `ra_traceability_ibfk_2` FOREIGN KEY (`ORIGIN_ID`) REFERENCES `ra_origin_master` (`ORIGIN_ID`),
  CONSTRAINT `ra_traceability_ibfk_3` FOREIGN KEY (`CROP_YEAR_ID`) REFERENCES `ra_trac_crop_year` (`CROP_YEAR_ID`),
  CONSTRAINT `ra_traceability_ibfk_4` FOREIGN KEY (`PR_BASIS_ID`) REFERENCES `ra_price_basis` (`PR_BASIS_ID`),
  CONSTRAINT `ra_traceability_ibfk_5` FOREIGN KEY (`STATE_ID`) REFERENCES `ra_state_master` (`STATE_ID`),
  CONSTRAINT `ra_traceability_ibfk_6` FOREIGN KEY (`LOAD_ID`) REFERENCES `ra_load_port` (`LOAD_ID`),
  CONSTRAINT `ra_traceability_ibfk_7` FOREIGN KEY (`DELIVERY_MONTH_ID`) REFERENCES `ra_delivery_month` (`MONTH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_traceability`
--

/*!40000 ALTER TABLE `ra_traceability` DISABLE KEYS */;
INSERT INTO `ra_traceability` (`TRACE_ID`,`CUSTOMER_ID`,`TRANS_DATE`,`BUYER_ID`,`SELLER_ID`,`ORIGIN_ID`,`CROP_YEAR_ID`,`PR_BASIS_ID`,`PRICE_TYPE`,`PRICE`,`PRICE_UNIT`,`PRCIE_EXCHANGE`,`STATE_ID`,`LOAD_ID`,`DEST_PORT_ID`,`ORDER_TYPE`,`DELIVERY_MONTH_ID`,`USER_ID`,`NO_OF_CONTAINERS`,`STATUS`,`PARENT_TRANS_ID`,`CREATE_DATE`,`PREM_PRICE`,`PREM_PRICE_UOM`,`PREV_STATUS`,`TRANSACTION_ID`) VALUES 
 (1,1,'2013-08-01','2','10',4,2,1,'baldev',1000,'baldev','JP_Morgan ',1,3,1,'Sell',11,1,NULL,'A',NULL,'2013-01-10',2000,NULL,NULL,1025432),
 (2,2,'2013-11-01','2','10',3,2,2,'baldev',1500,'baldev','mehta',1,4,1,'Sell',11,1,NULL,'A',NULL,'2013-01-10',500,NULL,NULL,1025433),
 (3,2,'2013-03-01','2','10',3,1,1,'baldev',2000,'baldev','mehta',1,501,3,'Sell',11,1,NULL,'A',NULL,'2013-01-11',2500,NULL,'Ac',1025435),
 (4,3,'2013-10-01','2','10',3,2,1,'baldev',1500,'baldev','JP_Morgan ',1,4,5,'Sell',11,1,NULL,'A',NULL,'2013-01-10',2000,NULL,NULL,2095643),
 (5,2,'2013-11-01','2','10',1,1,1,'baldev',2000,'baldev','JP_Morgan ',1,501,1,'Sell',11,1,NULL,'A',NULL,'2013-01-11',2500,NULL,'Ac',2094563),
 (27,1,'2013-11-01','2','10',1,2,1,'baldev',120000,'baldev','JP_Morgan ',1,1,1,'Sell',11,1,NULL,'A',NULL,'2013-04-05',5000,NULL,NULL,3098564),
 (31,1,'2013-11-11','2','10',3,3,1,'baldev',200000,'baldev','JP_Morgan ',1,501,1,'Sell',11,2,NULL,'A',NULL,'2013-04-07',5000,NULL,NULL,30046798);
/*!40000 ALTER TABLE `ra_traceability` ENABLE KEYS */;


--
-- Definition of table `ra_traceability_edit`
--

DROP TABLE IF EXISTS `ra_traceability_edit`;
CREATE TABLE `ra_traceability_edit` (
  `TRANS_ID` int(15) default NULL,
  `CUSTOMER_ID` int(15) default NULL,
  `TRANS_DATE` date default NULL,
  `BUYER_ID` varchar(20) default NULL,
  `SELLER_ID` varchar(20) default NULL,
  `ORIGIN_ID` int(15) default NULL,
  `CROP_YEAR_ID` int(15) default NULL,
  `PR_BASIS_ID` int(15) default NULL,
  `PRICE_TYPE` char(1) default NULL,
  `PRICE` double default NULL,
  `PRICE_UNIT` varchar(50) default NULL,
  `PRCIE_EXCHANGE` varchar(20) default NULL,
  `STATE_ID` int(15) default NULL,
  `LOAD_ID` int(15) default NULL,
  `DEST_PORT_ID` int(15) default NULL,
  `ORDER_TYPE` varchar(20) default NULL,
  `DELIVERY_MONTH_ID` int(15) default NULL,
  `USER_ID` int(15) default NULL,
  `NO_OF_CONTAINERS` int(15) default NULL,
  `STATUS` char(2) default 'A',
  `PARENT_TRANS_ID` int(15) default NULL,
  `PREM_PRICE` double default NULL,
  `PREM_PRICE_UOM` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_traceability_edit`
--

/*!40000 ALTER TABLE `ra_traceability_edit` DISABLE KEYS */;
/*!40000 ALTER TABLE `ra_traceability_edit` ENABLE KEYS */;


--
-- Definition of table `ra_unit_conv`
--

DROP TABLE IF EXISTS `ra_unit_conv`;
CREATE TABLE `ra_unit_conv` (
  `FROM_UNIT` varchar(20) default NULL,
  `TO_UNIT` varchar(20) default NULL,
  `CONV_FACTOR` double default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_unit_conv`
--

/*!40000 ALTER TABLE `ra_unit_conv` DISABLE KEYS */;
INSERT INTO `ra_unit_conv` (`FROM_UNIT`,`TO_UNIT`,`CONV_FACTOR`) VALUES 
 ('65Kg Bags','65Kg Bags',1.05);
/*!40000 ALTER TABLE `ra_unit_conv` ENABLE KEYS */;


--
-- Definition of table `ra_unit_measures`
--

DROP TABLE IF EXISTS `ra_unit_measures`;
CREATE TABLE `ra_unit_measures` (
  `UNIT_DSP_VAL` varchar(20) default NULL,
  `UNIT_SHRT_NAME` varchar(20) default NULL,
  UNIQUE KEY `UNIT_DSP_VAL` (`UNIT_DSP_VAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_unit_measures`
--

/*!40000 ALTER TABLE `ra_unit_measures` DISABLE KEYS */;
INSERT INTO `ra_unit_measures` (`UNIT_DSP_VAL`,`UNIT_SHRT_NAME`) VALUES 
 ('60 Kg Bags','60Kg'),
 ('100 Kg Bags','100Kg');
/*!40000 ALTER TABLE `ra_unit_measures` ENABLE KEYS */;


--
-- Definition of table `ra_user_acl`
--

DROP TABLE IF EXISTS `ra_user_acl`;
CREATE TABLE `ra_user_acl` (
  `ACL_ID` int(15) default NULL,
  `USER_ID` int(15) default NULL,
  KEY `ACL_ID` (`ACL_ID`),
  KEY `USER_ID` (`USER_ID`),
  CONSTRAINT `ra_user_acl_ibfk_1` FOREIGN KEY (`ACL_ID`) REFERENCES `ra_acl_master` (`ACL_ID`),
  CONSTRAINT `ra_user_acl_ibfk_2` FOREIGN KEY (`USER_ID`) REFERENCES `ra_user_master` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_user_acl`
--

/*!40000 ALTER TABLE `ra_user_acl` DISABLE KEYS */;
INSERT INTO `ra_user_acl` (`ACL_ID`,`USER_ID`) VALUES 
 (101,1);
/*!40000 ALTER TABLE `ra_user_acl` ENABLE KEYS */;


--
-- Definition of table `ra_user_master`
--

DROP TABLE IF EXISTS `ra_user_master`;
CREATE TABLE `ra_user_master` (
  `USER_ID` int(15) NOT NULL default '0',
  `LOGIN_NAME` varchar(100) default NULL,
  `PRODUCER_ID` int(15) default NULL,
  `CREATE_DATE` date default NULL,
  `PASSWORD` varchar(25) NOT NULL,
  `MODIFY_DATE` date default NULL,
  `COMPANY_ID` int(15) default NULL,
  `FIRST_NAME` varchar(50) NOT NULL,
  `USER_STATUS` char(1) default NULL,
  `LAST_NAME` varchar(50) default NULL,
  `POSITION` varchar(50) default NULL,
  `OFFICE_ADDRESS` varchar(100) default NULL,
  `CITY` varchar(50) default NULL,
  `DISTRICT` varchar(50) default NULL,
  `ZIP` varchar(20) default NULL,
  `STATE` varchar(50) NOT NULL,
  `PHONE` varchar(25) default NULL,
  `FAX` varchar(25) default NULL,
  `EMAIL` varchar(50) NOT NULL,
  `COMMENTS` varchar(500) default NULL,
  `USER_TYPE` varchar(20) default NULL,
  PRIMARY KEY  (`USER_ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  KEY `COMPANY_ID` (`COMPANY_ID`),
  CONSTRAINT `ra_user_master_ibfk_1` FOREIGN KEY (`COMPANY_ID`) REFERENCES `ra_company_master` (`COMPANY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ra_user_master`
--

/*!40000 ALTER TABLE `ra_user_master` DISABLE KEYS */;
INSERT INTO `ra_user_master` (`USER_ID`,`LOGIN_NAME`,`PRODUCER_ID`,`CREATE_DATE`,`PASSWORD`,`MODIFY_DATE`,`COMPANY_ID`,`FIRST_NAME`,`USER_STATUS`,`LAST_NAME`,`POSITION`,`OFFICE_ADDRESS`,`CITY`,`DISTRICT`,`ZIP`,`STATE`,`PHONE`,`FAX`,`EMAIL`,`COMMENTS`,`USER_TYPE`) VALUES 
 (1,'Admin',0,'2020-02-10','admin','2010-04-10',6,'admin','A','Commodity','Administrator','karve nagar','Pune','Pune','411056','Maharashtra','9876542350','02045712372','kjnext@gmail.com','Admin of System','admin'),
 (2,'JP_Morgan ',0,'2012-10-12','ymehta2','2012-12-12',1,'mehta','A','company','Trader','karve ','pune','pune','411038','MH','23947856',NULL,'mehta@gmail.com',NULL,'traders'),
 (5,'Barclay_Capital ',0,'2013-01-08','SSM24U',NULL,2,'Mahesh','A','rtuyrtuyh','Trader','yhtyujt','utiu','yutyu','656','MH',NULL,'3454565','chandrakant@gmail.com',NULL,'traders'),
 (7,'Glencore_International ',0,'2013-01-09','banapplefood',NULL,3,'Mayank','D','hghjyuy','Trader','hghgjhjh','hjhjh','kjkjkj','787656','MH',NULL,'76544','jimtssm@gmail.com',NULL,'traders'),
 (10,'baldev@gmail.com',1,'2013-01-09','baldev',NULL,7,'baldev','A','jhghjg','user','khkyh','Pune','kugu','654542','MH','563432','5432432','kunal@kjnext.com',NULL,'producers'),
 (11,'Chandrakant@gmail.com',2,'2013-01-09','chandrakant',NULL,7,'Chandrakant','A','SUMIT','user','pune','pune','pune','411028','1','276376','6735676','kjnext@kjnext.com',NULL,'producers'),
 (12,'bnarsing2011@gmail.com',0,'2013-01-10','bnarsing2011',NULL,6,'narsing','A','hfhdgjh','user','Karvenagar','pune','pune','411048','MH','254376','5367376','kirankothawade@kjnext.com',NULL,'producers'),
 (13,'Luckysingh@gmail.com',3,'2013-01-19','luckysingh',NULL,7,'Luckysingh','A','Kumar','user','pune','pune','pune','411038','6','6235469','63475487','ssm@gmail.com',NULL,'producers'),
 (15,'Phibro',0,'2013-03-14','chs',NULL,4,'Chandra singh','A','bhadekar','Trader','pune','pune','pune','3444444','6','44444444','3242424','ndb_2009',NULL,'traders'),
 (16,'narsing',0,'2013-03-14','narsing',NULL,6,'narsing','A','pande','user','pune','pune','pune','411111','6','3333333333','3242424','narsingbhadekar@gmail.com',NULL,'admin'),
 (17,'bhal',0,'2013-03-14','bhal',NULL,6,'bhal','A','bhusse','user','pune','pune','pune','411111','6','44444444','3242424','bhal.busse',NULL,'admin'),
 (18,'Kotak Commodity',0,'2013-03-14','ritesh',NULL,7,'ritesh','A','mmmm','Trader','pune','pune','pune','411111','18','3333333333','3242424','nnnn',NULL,'traders'),
 (19,'ganesg',4,'2013-03-14','ganesh',NULL,1,'ganesh','A','thomabare','user','pune','pune','pune','411111','6','44444444','3242424','ganesh',NULL,'producers'),
 (20,'Angel Commodity',0,'2013-03-19','techsoft',NULL,5,'amol','A','patil','Trader','pune','pune','pune','411111','6','11111111111','9876655','patil@gmail.com',NULL,'traders');
/*!40000 ALTER TABLE `ra_user_master` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
