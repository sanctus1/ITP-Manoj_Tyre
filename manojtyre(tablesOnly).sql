-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 17, 2017 at 12:44 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `manojtyre`
--

-- --------------------------------------------------------

--
-- Table structure for table `a`
--

CREATE TABLE `a` (
  `jid` int(11) NOT NULL,
  `cid` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `appoint_tbl`
--

CREATE TABLE `appoint_tbl` (
  `jid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `contact` varchar(13) NOT NULL,
  `reg_no` varchar(30) NOT NULL,
  `v_type` varchar(20) NOT NULL,
  `j_type` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `s_hh` int(11) NOT NULL,
  `s_mm` int(11) NOT NULL,
  `s_am_or_pm` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `Number` int(11) NOT NULL,
  `CatCode` varchar(25) NOT NULL,
  `Descrip` varchar(150) NOT NULL,
  `ReorderLevel` int(11) NOT NULL,
  `ReorderQty` int(11) NOT NULL,
  `BufferStock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `commision`
--

CREATE TABLE `commision` (
  `num` int(11) NOT NULL,
  `employeeID` varchar(15) NOT NULL,
  `jobID` varchar(15) NOT NULL,
  `date` varchar(15) NOT NULL,
  `amount` int(15) NOT NULL,
  `Commisson_Rate` int(2) NOT NULL,
  `Commission_Amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `comnew`
--

CREATE TABLE `comnew` (
  `employeeID` varchar(20) NOT NULL,
  `commision_amt` int(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint_battery`
--

CREATE TABLE `complaint_battery` (
  `id` int(11) NOT NULL,
  `battery_type` varchar(25) DEFAULT NULL,
  `service_life` int(11) DEFAULT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `company` varchar(25) DEFAULT NULL,
  `sold_price` double DEFAULT NULL,
  `dateof_sale` date DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint_item`
--

CREATE TABLE `complaint_item` (
  `cid` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `complaint_date` date DEFAULT NULL,
  `customer_name` varchar(25) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `vehicle_reg_no` varchar(10) DEFAULT NULL,
  `customer_address` varchar(250) DEFAULT NULL,
  `complaint_type` varchar(25) DEFAULT NULL,
  `claim_type` varchar(25) DEFAULT NULL,
  `eligible_status` tinyint(1) DEFAULT NULL,
  `item_type` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint_service`
--

CREATE TABLE `complaint_service` (
  `id` int(11) NOT NULL,
  `complaint_id` varchar(25) DEFAULT NULL,
  `job_no` int(11) DEFAULT NULL,
  `eligible_status` tinyint(1) DEFAULT NULL,
  `job_date` date DEFAULT NULL,
  `cusid` int(11) DEFAULT NULL,
  `cusname` varchar(25) DEFAULT NULL,
  `cus_address` varchar(250) DEFAULT NULL,
  `techid` int(11) DEFAULT NULL,
  `techname` varchar(25) DEFAULT NULL,
  `next_service_date` date DEFAULT NULL,
  `vehicle_reg_no` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `complaint_tyre`
--

CREATE TABLE `complaint_tyre` (
  `id` int(11) NOT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `date_of_sale` date DEFAULT NULL,
  `sold_price` double DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `service_life` int(11) DEFAULT NULL,
  `original_tire_depth` double DEFAULT NULL,
  `waste_tire_depth` double DEFAULT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `company` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `CusId` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Address` varchar(50) NOT NULL,
  `ContactNo` int(11) NOT NULL,
  `status` varchar(11) NOT NULL,
  `Remarks` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer1`
--

CREATE TABLE `customer1` (
  `Cusid` int(11) NOT NULL,
  `status` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emp_attendance`
--

CREATE TABLE `emp_attendance` (
  `Emp_ID` varchar(15) DEFAULT NULL,
  `Date` varchar(20) DEFAULT NULL,
  `Come_time` varchar(10) DEFAULT NULL,
  `Out_time` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `emp_details`
--

CREATE TABLE `emp_details` (
  `EmpNo` int(4) NOT NULL,
  `Emp_ID` varchar(15) DEFAULT NULL,
  `F_name` varchar(30) DEFAULT NULL,
  `M_name` varchar(30) DEFAULT NULL,
  `L_name` varchar(30) DEFAULT NULL,
  `DOB` varchar(20) DEFAULT NULL,
  `NIC` varchar(10) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `HTP` varchar(10) DEFAULT NULL,
  `MTP` varchar(10) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Experience` varchar(500) DEFAULT NULL,
  `Join_Date` varchar(20) DEFAULT NULL,
  `Work_Shift` varchar(20) DEFAULT NULL,
  `Images` longblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `etfdet`
--

CREATE TABLE `etfdet` (
  `Number` int(10) NOT NULL,
  `employeeID` varchar(10) NOT NULL,
  `month` varchar(10) NOT NULL,
  `salary` int(10) NOT NULL,
  `epf` int(20) NOT NULL,
  `etf` int(20) NOT NULL,
  `Existing_ETF_EPF` int(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `etfepf`
--

CREATE TABLE `etfepf` (
  `employeeID` varchar(11) NOT NULL,
  `Full_ETF_EPF` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `finalsal`
--

CREATE TABLE `finalsal` (
  `employeeID` varchar(20) NOT NULL,
  `Existing_ETF_EPF` int(10) NOT NULL DEFAULT '0',
  `ETF_rate` int(2) NOT NULL DEFAULT '0',
  `EPF_rate` int(2) DEFAULT '0',
  `Salary` int(10) DEFAULT '0',
  `Commisions` int(10) DEFAULT '0',
  `Loans` int(10) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `finalsaldet`
--

CREATE TABLE `finalsaldet` (
  `employeeID` varchar(20) NOT NULL,
  `month` varchar(20) NOT NULL,
  `ETF_rate` int(2) NOT NULL,
  `EPF_rate` int(2) NOT NULL,
  `Existing_ETF_EPF` int(10) DEFAULT '0',
  `Salary` int(19) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_job_table`
--

CREATE TABLE `final_job_table` (
  `jid` int(10) NOT NULL,
  `cusID` int(10) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `contact` int(15) DEFAULT NULL,
  `reg_no` varchar(30) NOT NULL,
  `v_type` varchar(30) DEFAULT NULL,
  `job_type` varchar(30) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `st_hh` int(10) DEFAULT NULL,
  `st_mm` int(10) DEFAULT NULL,
  `st_am_pm` varchar(10) DEFAULT NULL,
  `eid` varchar(30) DEFAULT NULL,
  `fin_hh` int(10) DEFAULT NULL,
  `fin_mm` int(10) DEFAULT NULL,
  `fin_am_pm` varchar(10) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fulloan`
--

CREATE TABLE `fulloan` (
  `employeeID` varchar(20) NOT NULL,
  `Full_Loan_Amount` int(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

CREATE TABLE `invoice` (
  `invoicenumber` int(11) NOT NULL,
  `ordernum` int(11) NOT NULL,
  `supid` varchar(20) NOT NULL,
  `recieveddate` varchar(12) NOT NULL,
  `tottalprice` varchar(10) NOT NULL,
  `paymentdetail` varchar(250) NOT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'notpaid'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `ItemCode` varchar(20) NOT NULL,
  `SerialNo` varchar(20) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `ManufactName` varchar(50) NOT NULL,
  `SellingPri` float NOT NULL,
  `BinID` varchar(20) NOT NULL,
  `PurchUnit` varchar(50) NOT NULL,
  `Image` longblob,
  `SuplierPri` float NOT NULL,
  `SupDiscount` float NOT NULL,
  `CusDiscL1` float NOT NULL,
  `CusDickL2` float NOT NULL,
  `CusDiskL3` float NOT NULL,
  `ExtDescription` varchar(350) NOT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `CatCode` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `job_details`
--

CREATE TABLE `job_details` (
  `id` int(11) NOT NULL,
  `v_type` varchar(100) NOT NULL,
  `reg_no` varchar(30) NOT NULL,
  `j_type` varchar(100) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `date` date NOT NULL,
  `s_hh` int(11) NOT NULL,
  `s_mm` int(11) NOT NULL,
  `s_am_or_pm` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `leave_request`
--

CREATE TABLE `leave_request` (
  `RequestNo` int(4) NOT NULL,
  `Emp_ID` varchar(15) DEFAULT NULL,
  `Emp_Name` varchar(100) DEFAULT NULL,
  `Work_Shift` varchar(20) DEFAULT NULL,
  `Contact_No` varchar(10) DEFAULT NULL,
  `Reason` varchar(100) DEFAULT NULL,
  `Request_Date` varchar(20) DEFAULT NULL,
  `Leave_Date` varchar(10) DEFAULT NULL,
  `Duration` varchar(2) DEFAULT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `LeaveAcceptance` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loandetails`
--

CREATE TABLE `loandetails` (
  `num` int(11) NOT NULL,
  `employeeID` varchar(20) NOT NULL,
  `Loan_date` varchar(15) NOT NULL,
  `loanAmount` int(10) NOT NULL,
  `Full_loan` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `loyaltyscheme`
--

CREATE TABLE `loyaltyscheme` (
  `CustomerID` varchar(11) NOT NULL,
  `Amount` float NOT NULL,
  `SalesRange` varchar(11) NOT NULL,
  `RatingPoint` int(11) NOT NULL,
  `CurrentTotalLoyaltyLevel` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `ordernumber` int(11) NOT NULL,
  `supid` varchar(50) NOT NULL,
  `serialno` varchar(50) NOT NULL,
  `quantity` varchar(50) NOT NULL,
  `dateneeded` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  `manufacturer` varchar(50) NOT NULL,
  `date` varchar(50) NOT NULL,
  `invreseiveandpaid` varchar(5) NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment_battery`
--

CREATE TABLE `payment_battery` (
  `id` int(11) NOT NULL,
  `complant_id` int(11) DEFAULT NULL,
  `complaint_type` varchar(25) DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `battery_type` varchar(25) DEFAULT NULL,
  `claim_type` varchar(25) DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `complaint_date` date DEFAULT NULL,
  `customer_name` varchar(25) DEFAULT NULL,
  `customer_address` varchar(250) DEFAULT NULL,
  `invoice_no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payment_tyre`
--

CREATE TABLE `payment_tyre` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `complaint_type` varchar(25) DEFAULT NULL,
  `complaint_date` date DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `tyre_type` varchar(25) DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `cusname` varchar(25) DEFAULT NULL,
  `cus_address` varchar(250) DEFAULT NULL,
  `invoice_no` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `pricelist`
--

CREATE TABLE `pricelist` (
  `companyid` varchar(10) NOT NULL,
  `serialno` varchar(20) NOT NULL,
  `description` varchar(250) NOT NULL,
  `date` varchar(12) NOT NULL,
  `effectfrom` varchar(10) NOT NULL,
  `retailprice` double NOT NULL,
  `tax` float NOT NULL,
  `retailpricewithtaxes` double NOT NULL,
  `wholesaleprice` double NOT NULL,
  `type` varchar(20) NOT NULL,
  `manufacturer` varchar(30) NOT NULL,
  `discount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `prorata_battery`
--

CREATE TABLE `prorata_battery` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `battery_type` varchar(25) DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `replaced_date` date DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `special_price` double DEFAULT NULL,
  `discount_percentage` double DEFAULT NULL,
  `date_of_sale` date DEFAULT NULL,
  `company` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `refund_tyre`
--

CREATE TABLE `refund_tyre` (
  `id` int(11) NOT NULL,
  `complaint_id` varchar(25) DEFAULT NULL,
  `tax_amount` double DEFAULT NULL,
  `refund_date` date DEFAULT NULL,
  `company` varchar(25) DEFAULT NULL,
  `claiming_amount` double DEFAULT NULL,
  `invoice_no` int(11) DEFAULT NULL,
  `refund_amount` double DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `replaced_battery`
--

CREATE TABLE `replaced_battery` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `battery_type` varchar(25) NOT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `replaced_date` date DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `date_of_sale` date DEFAULT NULL,
  `company` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `replaced_tyre`
--

CREATE TABLE `replaced_tyre` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `item_id` varchar(25) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `serial_no` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `sp_price` double DEFAULT NULL,
  `date_of_sale` date DEFAULT NULL,
  `companny` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `set_job`
--

CREATE TABLE `set_job` (
  `jid` int(11) NOT NULL,
  `eid` varchar(30) NOT NULL,
  `actual_st_HH` int(11) NOT NULL,
  `actual_st_MM` int(11) NOT NULL,
  `actual_st_ampm` varchar(5) NOT NULL,
  `duration_hh` int(11) NOT NULL,
  `duration_mm` int(11) NOT NULL,
  `e_hh` int(11) NOT NULL,
  `e_mm` int(11) NOT NULL,
  `e_am_pm` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sitem`
--

CREATE TABLE `sitem` (
  `ItemCategory` varchar(25) NOT NULL,
  `ItemID` varchar(25) NOT NULL,
  `cus_id` varchar(25) DEFAULT NULL,
  `Discount` double NOT NULL,
  `ItemUnitprice` double NOT NULL,
  `Warrenty` varchar(10) NOT NULL,
  `Amount` double DEFAULT NULL,
  `vehicle_reg_no` varchar(25) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `spricelist`
--

CREATE TABLE `spricelist` (
  `Service` varchar(50) NOT NULL,
  `Price` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sservice`
--

CREATE TABLE `sservice` (
  `ServiceType` varchar(50) NOT NULL,
  `ServicePrice` int(11) NOT NULL,
  `JobID` int(5) NOT NULL,
  `ServiceAmount` double DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE `stock` (
  `StockId` int(11) NOT NULL,
  `ReorderLevel` int(11) NOT NULL,
  `ReorderQty` int(11) NOT NULL,
  `BufferStock` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `stransaction`
--

CREATE TABLE `stransaction` (
  `Date` varchar(10) NOT NULL,
  `TransID` int(5) NOT NULL,
  `CustomerID` int(5) NOT NULL,
  `PayType` varchar(10) NOT NULL,
  `Amount` double NOT NULL,
  `Discount` double NOT NULL,
  `TotalAmount` double NOT NULL,
  `Description` varchar(50) NOT NULL,
  `ItemID` varchar(25) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subjob`
--

CREATE TABLE `subjob` (
  `jid` int(11) NOT NULL,
  `sub_des` varchar(200) NOT NULL,
  `sub_hh` int(11) NOT NULL,
  `sub_mm` int(11) NOT NULL,
  `sub_am_pm` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `suplier`
--

CREATE TABLE `suplier` (
  `supid` varchar(6) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT 'halz'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `supplier1`
--

CREATE TABLE `supplier1` (
  `Supplier_ID` varchar(15) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Product_ID` varchar(50) DEFAULT NULL,
  `Product_Name` varchar(50) DEFAULT NULL,
  `Size` varchar(50) DEFAULT NULL,
  `Retail_Price` varchar(100) DEFAULT NULL,
  `Qty` varchar(50) DEFAULT NULL,
  `Contact_No` int(11) DEFAULT NULL,
  `Remarks` varchar(50) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `swarrenty`
--

CREATE TABLE `swarrenty` (
  `itemid` int(5) NOT NULL,
  `wcsno` int(10) NOT NULL,
  `validp` varchar(10) NOT NULL,
  `startdate` varchar(10) NOT NULL,
  `enddate` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `temp`
--

CREATE TABLE `temp` (
  `supid` varchar(10) NOT NULL,
  `serialno` varchar(10) NOT NULL,
  `description` varchar(250) NOT NULL,
  `effectfrom` varchar(10) NOT NULL,
  `retailprice` double NOT NULL,
  `tax` double NOT NULL,
  `retailpricewithtaxes` double NOT NULL,
  `wholesaleprice` double NOT NULL,
  `type` varchar(10) NOT NULL,
  `manufacturer` varchar(20) NOT NULL,
  `discount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `temp_item_tbl`
--

CREATE TABLE `temp_item_tbl` (
  `jobID` int(11) NOT NULL,
  `ItemID` varchar(20) NOT NULL,
  `ItemName` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tires`
--

CREATE TABLE `tires` (
  `supid` varchar(10) NOT NULL,
  `serialno` varchar(20) NOT NULL,
  `size` varchar(20) NOT NULL DEFAULT '200x150',
  `pattern` varchar(30) NOT NULL DEFAULT 'abc',
  `pr` varchar(5) NOT NULL DEFAULT 'PR',
  `countryoforigin` varchar(30) NOT NULL DEFAULT 'Sri Lanka'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `EmpID` varchar(11) NOT NULL,
  `jobID` varchar(15) NOT NULL,
  `date` varchar(15) NOT NULL,
  `amount` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warranty_check_details`
--

CREATE TABLE `warranty_check_details` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `tech_id` int(11) DEFAULT NULL,
  `tech_name` varchar(25) DEFAULT NULL,
  `eligible_status` tinyint(1) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warranty_claim_service`
--

CREATE TABLE `warranty_claim_service` (
  `id` int(11) NOT NULL,
  `complaint_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `full_service_cost` double DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `final_cost` double DEFAULT NULL,
  `next_service_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warranty_details_battery`
--

CREATE TABLE `warranty_details_battery` (
  `id` int(11) NOT NULL,
  `company` varchar(25) DEFAULT NULL,
  `battery_type` varchar(25) DEFAULT NULL,
  `replacement_period` int(11) DEFAULT NULL,
  `prorata_period` int(11) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `warranty_details_tyre`
--

CREATE TABLE `warranty_details_tyre` (
  `id` int(11) NOT NULL,
  `company` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  `warranty_period` int(11) DEFAULT NULL,
  `tax` int(11) DEFAULT NULL,
  `claim_amount` double DEFAULT NULL,
  `originaltyredepth` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatCode`),
  ADD UNIQUE KEY `Num` (`Number`);

--
-- Indexes for table `commision`
--
ALTER TABLE `commision`
  ADD PRIMARY KEY (`employeeID`,`jobID`),
  ADD UNIQUE KEY `num` (`num`);

--
-- Indexes for table `complaint_battery`
--
ALTER TABLE `complaint_battery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `complaint_item`
--
ALTER TABLE `complaint_item`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `complaint_service`
--
ALTER TABLE `complaint_service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `complaint_tyre`
--
ALTER TABLE `complaint_tyre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CusId`);

--
-- Indexes for table `emp_details`
--
ALTER TABLE `emp_details`
  ADD PRIMARY KEY (`EmpNo`),
  ADD UNIQUE KEY `unic` (`Emp_ID`);

--
-- Indexes for table `etfdet`
--
ALTER TABLE `etfdet`
  ADD PRIMARY KEY (`employeeID`,`month`),
  ADD UNIQUE KEY `Number` (`Number`);

--
-- Indexes for table `etfepf`
--
ALTER TABLE `etfepf`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `finalsal`
--
ALTER TABLE `finalsal`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `finalsaldet`
--
ALTER TABLE `finalsaldet`
  ADD PRIMARY KEY (`employeeID`,`month`);

--
-- Indexes for table `final_job_table`
--
ALTER TABLE `final_job_table`
  ADD PRIMARY KEY (`jid`);

--
-- Indexes for table `fulloan`
--
ALTER TABLE `fulloan`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `invoice`
--
ALTER TABLE `invoice`
  ADD PRIMARY KEY (`invoicenumber`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`ItemCode`),
  ADD KEY `CatCode` (`CatCode`),
  ADD KEY `CatCode_2` (`CatCode`);

--
-- Indexes for table `leave_request`
--
ALTER TABLE `leave_request`
  ADD PRIMARY KEY (`RequestNo`);

--
-- Indexes for table `loandetails`
--
ALTER TABLE `loandetails`
  ADD PRIMARY KEY (`num`);

--
-- Indexes for table `loyaltyscheme`
--
ALTER TABLE `loyaltyscheme`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`ordernumber`,`supid`,`serialno`);

--
-- Indexes for table `payment_battery`
--
ALTER TABLE `payment_battery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment_tyre`
--
ALTER TABLE `payment_tyre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pricelist`
--
ALTER TABLE `pricelist`
  ADD PRIMARY KEY (`companyid`,`serialno`);

--
-- Indexes for table `prorata_battery`
--
ALTER TABLE `prorata_battery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `refund_tyre`
--
ALTER TABLE `refund_tyre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `replaced_battery`
--
ALTER TABLE `replaced_battery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `replaced_tyre`
--
ALTER TABLE `replaced_tyre`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sitem`
--
ALTER TABLE `sitem`
  ADD PRIMARY KEY (`ItemID`);

--
-- Indexes for table `spricelist`
--
ALTER TABLE `spricelist`
  ADD PRIMARY KEY (`Service`);

--
-- Indexes for table `sservice`
--
ALTER TABLE `sservice`
  ADD PRIMARY KEY (`JobID`);

--
-- Indexes for table `stock`
--
ALTER TABLE `stock`
  ADD PRIMARY KEY (`StockId`);

--
-- Indexes for table `stransaction`
--
ALTER TABLE `stransaction`
  ADD PRIMARY KEY (`TransID`),
  ADD UNIQUE KEY `transid` (`TransID`);

--
-- Indexes for table `suplier`
--
ALTER TABLE `suplier`
  ADD PRIMARY KEY (`supid`);

--
-- Indexes for table `supplier1`
--
ALTER TABLE `supplier1`
  ADD PRIMARY KEY (`Supplier_ID`);

--
-- Indexes for table `swarrenty`
--
ALTER TABLE `swarrenty`
  ADD PRIMARY KEY (`wcsno`);

--
-- Indexes for table `temp`
--
ALTER TABLE `temp`
  ADD PRIMARY KEY (`supid`,`serialno`);

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `warranty_check_details`
--
ALTER TABLE `warranty_check_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `warranty_claim_service`
--
ALTER TABLE `warranty_claim_service`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `warranty_details_battery`
--
ALTER TABLE `warranty_details_battery`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `warranty_details_tyre`
--
ALTER TABLE `warranty_details_tyre`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `Number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `commision`
--
ALTER TABLE `commision`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT for table `complaint_battery`
--
ALTER TABLE `complaint_battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `complaint_item`
--
ALTER TABLE `complaint_item`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `complaint_service`
--
ALTER TABLE `complaint_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `complaint_tyre`
--
ALTER TABLE `complaint_tyre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `emp_details`
--
ALTER TABLE `emp_details`
  MODIFY `EmpNo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `etfdet`
--
ALTER TABLE `etfdet`
  MODIFY `Number` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=61;
--
-- AUTO_INCREMENT for table `leave_request`
--
ALTER TABLE `leave_request`
  MODIFY `RequestNo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `loandetails`
--
ALTER TABLE `loandetails`
  MODIFY `num` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
--
-- AUTO_INCREMENT for table `payment_battery`
--
ALTER TABLE `payment_battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `payment_tyre`
--
ALTER TABLE `payment_tyre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `prorata_battery`
--
ALTER TABLE `prorata_battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `refund_tyre`
--
ALTER TABLE `refund_tyre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `replaced_battery`
--
ALTER TABLE `replaced_battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `replaced_tyre`
--
ALTER TABLE `replaced_tyre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `stock`
--
ALTER TABLE `stock`
  MODIFY `StockId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `stransaction`
--
ALTER TABLE `stransaction`
  MODIFY `TransID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66666669;
--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warranty_check_details`
--
ALTER TABLE `warranty_check_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warranty_claim_service`
--
ALTER TABLE `warranty_claim_service`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `warranty_details_battery`
--
ALTER TABLE `warranty_details_battery`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `warranty_details_tyre`
--
ALTER TABLE `warranty_details_tyre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
