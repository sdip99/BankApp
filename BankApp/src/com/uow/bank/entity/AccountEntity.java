package com.uow.bank.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class AccountEntity {

	@Id
	@Column(name="accNum")
	private int accNum;
	
	@Column(name="accHolderName")
	private String accHolderName;
	
	@Column(name="accBal")
	private int accBal;
	
	@Column(name="accType")
	private String accType;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="psCode")
	private String psCode;
	
	public AccountEntity() {}
	
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public String getAccHolderName() {
		return accHolderName;
	}
	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}
	public int getAccBal() {
		return accBal;
	}
	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPsCode() {
		return psCode;
	}
	public void setPsCode(String psCode) {
		this.psCode = psCode;
	}

	
}
