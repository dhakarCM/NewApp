package com.phppoets.newapp.Model.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

@SerializedName("id")
@Expose
private int id;
@SerializedName("role_id")
@Expose
private int roleId;
@SerializedName("gst_number")
@Expose
private String gstNumber;
@SerializedName("id_card_no")
@Expose
private int idCardNo;
@SerializedName("company_organisation")
@Expose
private String companyOrganisation;
@SerializedName("due_amount")
@Expose
private int dueAmount;
@SerializedName("address")
@Expose
private String address;
@SerializedName("city")
@Expose
private String city;
@SerializedName("master_state_id")
@Expose
private int masterStateId;
@SerializedName("pincode")
@Expose
private int pincode;
@SerializedName("end_products_item_dealing_in")
@Expose
private String endProductsItemDealingIn;
@SerializedName("office_telephone")
@Expose
private String officeTelephone;
@SerializedName("residential_telephone")
@Expose
private String residentialTelephone;
@SerializedName("company_email_id")
@Expose
private String companyEmailId;
@SerializedName("grade")
@Expose
private int grade;
@SerializedName("category")
@Expose
private int category;
@SerializedName("classification")
@Expose
private int classification;
@SerializedName("year_of_joining")
@Expose
private String yearOfJoining;
@SerializedName("turn_over_id")
@Expose
private int turnOverId;
@SerializedName("member_flag")
@Expose
private int memberFlag;
@SerializedName("website")
@Expose
private String website;
@SerializedName("tag")
@Expose
private String tag;
@SerializedName("infrastructure")
@Expose
private String infrastructure;
@SerializedName("brief_description")
@Expose
private String briefDescription;
@SerializedName("company_image")
@Expose
private String companyImage;
@SerializedName("export")
@Expose
private String export;
@SerializedName("nationality")
@Expose
private String nationality;
@SerializedName("form_number")
@Expose
private int formNumber;
@SerializedName("amount_type")
@Expose
private String amountType;
@SerializedName("cheque_number")
@Expose
private String chequeNumber;
@SerializedName("cheque_date")
@Expose
private String chequeDate;
@SerializedName("payment_status")
@Expose
private String paymentStatus;
@SerializedName("transaction_id")
@Expose
private String transactionId;
@SerializedName("pan_card")
@Expose
private String panCard;
@SerializedName("company_registration")
@Expose
private String companyRegistration;
@SerializedName("ibc_code")
@Expose
private String ibcCode;
@SerializedName("non_member_exporter_email")
@Expose
private String nonMemberExporterEmail;
@SerializedName("company_fax")
@Expose
private String companyFax;
@SerializedName("no_of_employee")
@Expose
private String noOfEmployee;
@SerializedName("where_exporting_product")
@Expose
private String whereExportingProduct;
@SerializedName("industry_code")
@Expose
private String industryCode;
@SerializedName("onsite_treatment_facility_type")
@Expose
private String onsiteTreatmentFacilityType;
@SerializedName("expansions_planned_potential_effect")
@Expose
private String expansionsPlannedPotentialEffect;
@SerializedName("iso_registration")
@Expose
private String isoRegistration;
@SerializedName("existing_treatment_facility")
@Expose
private String existingTreatmentFacility;
@SerializedName("appropriate_cost")
@Expose
private String appropriateCost;
@SerializedName("company_type")
@Expose
private String companyType;
@SerializedName("company_image_fullpath")
@Expose
private String companyImageFullpath;

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public int getRoleId() {
return roleId;
}

public void setRoleId(int roleId) {
this.roleId = roleId;
}

public String getGstNumber() {
return gstNumber;
}

public void setGstNumber(String gstNumber) {
this.gstNumber = gstNumber;
}

public int getIdCardNo() {
return idCardNo;
}

public void setIdCardNo(int idCardNo) {
this.idCardNo = idCardNo;
}

public String getCompanyOrganisation() {
return companyOrganisation;
}

public void setCompanyOrganisation(String companyOrganisation) {
this.companyOrganisation = companyOrganisation;
}

public int getDueAmount() {
return dueAmount;
}

public void setDueAmount(int dueAmount) {
this.dueAmount = dueAmount;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getCity() {
return city;
}

public void setCity(String city) {
this.city = city;
}

public int getMasterStateId() {
return masterStateId;
}

public void setMasterStateId(int masterStateId) {
this.masterStateId = masterStateId;
}

public int getPincode() {
return pincode;
}

public void setPincode(int pincode) {
this.pincode = pincode;
}

public String getEndProductsItemDealingIn() {
return endProductsItemDealingIn;
}

public void setEndProductsItemDealingIn(String endProductsItemDealingIn) {
this.endProductsItemDealingIn = endProductsItemDealingIn;
}

public String getOfficeTelephone() {
return officeTelephone;
}

public void setOfficeTelephone(String officeTelephone) {
this.officeTelephone = officeTelephone;
}

public String getResidentialTelephone() {
return residentialTelephone;
}

public void setResidentialTelephone(String residentialTelephone) {
this.residentialTelephone = residentialTelephone;
}

public String getCompanyEmailId() {
return companyEmailId;
}

public void setCompanyEmailId(String companyEmailId) {
this.companyEmailId = companyEmailId;
}

public int getGrade() {
return grade;
}

public void setGrade(int grade) {
this.grade = grade;
}

public int getCategory() {
return category;
}

public void setCategory(int category) {
this.category = category;
}

public int getClassification() {
return classification;
}

public void setClassification(int classification) {
this.classification = classification;
}

public String getYearOfJoining() {
return yearOfJoining;
}

public void setYearOfJoining(String yearOfJoining) {
this.yearOfJoining = yearOfJoining;
}

public int getTurnOverId() {
return turnOverId;
}

public void setTurnOverId(int turnOverId) {
this.turnOverId = turnOverId;
}

public int getMemberFlag() {
return memberFlag;
}

public void setMemberFlag(int memberFlag) {
this.memberFlag = memberFlag;
}

public String getWebsite() {
return website;
}

public void setWebsite(String website) {
this.website = website;
}

public String getTag() {
return tag;
}

public void setTag(String tag) {
this.tag = tag;
}

public String getInfrastructure() {
return infrastructure;
}

public void setInfrastructure(String infrastructure) {
this.infrastructure = infrastructure;
}

public String getBriefDescription() {
return briefDescription;
}

public void setBriefDescription(String briefDescription) {
this.briefDescription = briefDescription;
}

public String getCompanyImage() {
return companyImage;
}

public void setCompanyImage(String companyImage) {
this.companyImage = companyImage;
}

public String getExport() {
return export;
}

public void setExport(String export) {
this.export = export;
}

public String getNationality() {
return nationality;
}

public void setNationality(String nationality) {
this.nationality = nationality;
}

public int getFormNumber() {
return formNumber;
}

public void setFormNumber(int formNumber) {
this.formNumber = formNumber;
}

public String getAmountType() {
return amountType;
}

public void setAmountType(String amountType) {
this.amountType = amountType;
}

public String getChequeNumber() {
return chequeNumber;
}

public void setChequeNumber(String chequeNumber) {
this.chequeNumber = chequeNumber;
}

public String getChequeDate() {
return chequeDate;
}

public void setChequeDate(String chequeDate) {
this.chequeDate = chequeDate;
}

public String getPaymentStatus() {
return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
this.paymentStatus = paymentStatus;
}

public String getTransactionId() {
return transactionId;
}

public void setTransactionId(String transactionId) {
this.transactionId = transactionId;
}

public String getPanCard() {
return panCard;
}

public void setPanCard(String panCard) {
this.panCard = panCard;
}

public String getCompanyRegistration() {
return companyRegistration;
}

public void setCompanyRegistration(String companyRegistration) {
this.companyRegistration = companyRegistration;
}

public String getIbcCode() {
return ibcCode;
}

public void setIbcCode(String ibcCode) {
this.ibcCode = ibcCode;
}

public String getNonMemberExporterEmail() {
return nonMemberExporterEmail;
}

public void setNonMemberExporterEmail(String nonMemberExporterEmail) {
this.nonMemberExporterEmail = nonMemberExporterEmail;
}

public String getCompanyFax() {
return companyFax;
}

public void setCompanyFax(String companyFax) {
this.companyFax = companyFax;
}

public String getNoOfEmployee() {
return noOfEmployee;
}

public void setNoOfEmployee(String noOfEmployee) {
this.noOfEmployee = noOfEmployee;
}

public String getWhereExportingProduct() {
return whereExportingProduct;
}

public void setWhereExportingProduct(String whereExportingProduct) {
this.whereExportingProduct = whereExportingProduct;
}

public String getIndustryCode() {
return industryCode;
}

public void setIndustryCode(String industryCode) {
this.industryCode = industryCode;
}

public String getOnsiteTreatmentFacilityType() {
return onsiteTreatmentFacilityType;
}

public void setOnsiteTreatmentFacilityType(String onsiteTreatmentFacilityType) {
this.onsiteTreatmentFacilityType = onsiteTreatmentFacilityType;
}

public String getExpansionsPlannedPotentialEffect() {
return expansionsPlannedPotentialEffect;
}

public void setExpansionsPlannedPotentialEffect(String expansionsPlannedPotentialEffect) {
this.expansionsPlannedPotentialEffect = expansionsPlannedPotentialEffect;
}

public String getIsoRegistration() {
return isoRegistration;
}

public void setIsoRegistration(String isoRegistration) {
this.isoRegistration = isoRegistration;
}

public String getExistingTreatmentFacility() {
return existingTreatmentFacility;
}

public void setExistingTreatmentFacility(String existingTreatmentFacility) {
this.existingTreatmentFacility = existingTreatmentFacility;
}

public String getAppropriateCost() {
return appropriateCost;
}

public void setAppropriateCost(String appropriateCost) {
this.appropriateCost = appropriateCost;
}

public String getCompanyType() {
return companyType;
}

public void setCompanyType(String companyType) {
this.companyType = companyType;
}

public String getCompanyImageFullpath() {
return companyImageFullpath;
}

public void setCompanyImageFullpath(String companyImageFullpath) {
this.companyImageFullpath = companyImageFullpath;
}

}