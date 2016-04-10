package com.belhopat.backoffice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Candidate {

	@Id
	@GeneratedValue
	private Long id;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date dob;

	private String gender;

	private String personalEmail;

	private String personalContactNo;

	private String familyContact1;

	private String familyContact2;

	private String familyEmail;

	@OneToMany
	private List<FamilyMember> familyMembers;

	private String onsiteContactNo;

	private String bloodGroup;

	@OneToOne
	private Address currentAddress;

	@OneToOne
	private Address permanentAddress;

	@OneToOne
	private Address onsiteAddress;

	@OneToMany
	private List<Skill> skillSet;

	private Integer priorExperienceYear;

	private Integer priorExperienceMonth;

	@ManyToOne
	private Country countryOfOrigin;

	@ManyToOne
	private Country countryToVisit;

	private String client;

	private String partner;

	@OneToOne
	private BankAccount bankAccount;

	@OneToOne
	private Passport passport;

	@OneToOne
	private OfficialDetails officialDetails;

	private Date doj;

	@ManyToOne
	private LookupDetail division;

	@ManyToOne
	private LookupDetail designation;

	@ManyToOne
	private LookupDetail employmentStatus;

	private String SourcedBy;

	private String purpose;

	public Candidate(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public String getPersonalContactNo() {
		return personalContactNo;
	}

	public void setPersonalContactNo(String personalContactNo) {
		this.personalContactNo = personalContactNo;
	}

	public String getFamilyContact1() {
		return familyContact1;
	}

	public void setFamilyContact1(String familyContact1) {
		this.familyContact1 = familyContact1;
	}

	public String getFamilyContact2() {
		return familyContact2;
	}

	public void setFamilyContact2(String familyContact2) {
		this.familyContact2 = familyContact2;
	}

	public String getFamilyEmail() {
		return familyEmail;
	}

	public void setFamilyEmail(String familyEmail) {
		this.familyEmail = familyEmail;
	}

	public List<FamilyMember> getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(List<FamilyMember> familyMembers) {
		this.familyMembers = familyMembers;
	}

	public String getOnsiteContactNo() {
		return onsiteContactNo;
	}

	public void setOnsiteContactNo(String onsiteContactNo) {
		this.onsiteContactNo = onsiteContactNo;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Address getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(Address currentAddress) {
		this.currentAddress = currentAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Address getOnsiteAddress() {
		return onsiteAddress;
	}

	public void setOnsiteAddress(Address onsiteAddress) {
		this.onsiteAddress = onsiteAddress;
	}

	public List<Skill> getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(List<Skill> skillSet) {
		this.skillSet = skillSet;
	}

	public Integer getPriorExperienceYear() {
		return priorExperienceYear;
	}

	public void setPriorExperienceYear(Integer priorExperienceYear) {
		this.priorExperienceYear = priorExperienceYear;
	}

	public Integer getPriorExperienceMonth() {
		return priorExperienceMonth;
	}

	public void setPriorExperienceMonth(Integer priorExperienceMonth) {
		this.priorExperienceMonth = priorExperienceMonth;
	}

	public Country getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(Country countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public Country getCountryToVisit() {
		return countryToVisit;
	}

	public void setCountryToVisit(Country countryToVisit) {
		this.countryToVisit = countryToVisit;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public OfficialDetails getOfficialDetails() {
		return officialDetails;
	}

	public void setOfficialDetails(OfficialDetails officialDetails) {
		this.officialDetails = officialDetails;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public LookupDetail getDivision() {
		return division;
	}

	public void setDivision(LookupDetail division) {
		this.division = division;
	}

	public LookupDetail getDesignation() {
		return designation;
	}

	public void setDesignation(LookupDetail designation) {
		this.designation = designation;
	}

	public LookupDetail getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(LookupDetail employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	public String getSourcedBy() {
		return SourcedBy;
	}

	public void setSourcedBy(String sourcedBy) {
		SourcedBy = sourcedBy;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", dob=" + dob + ", gender=" + gender + ", personalEmail=" + personalEmail
				+ ", personalContactNo=" + personalContactNo + ", familyContact1=" + familyContact1
				+ ", familyContact2=" + familyContact2 + ", familyEmail=" + familyEmail + ", familyMembers="
				+ familyMembers + ", onsiteContactNo=" + onsiteContactNo + ", bloodGroup=" + bloodGroup
				+ ", currentAddress=" + currentAddress + ", permanentAddress=" + permanentAddress + ", onsiteAddress="
				+ onsiteAddress + ", skillSet=" + skillSet + ", priorExperienceYear=" + priorExperienceYear
				+ ", priorExperienceMonth=" + priorExperienceMonth + ", countryOfOrigin=" + countryOfOrigin
				+ ", countryToVisit=" + countryToVisit + ", client=" + client + ", partner=" + partner
				+ ", bankAccount=" + bankAccount + ", passport=" + passport + ", officialDetails=" + officialDetails
				+ ", doj=" + doj + ", division=" + division + ", designation=" + designation + ", employmentStatus="
				+ employmentStatus + ", SourcedBy=" + SourcedBy + ", purpose=" + purpose + "]";
	}

}
