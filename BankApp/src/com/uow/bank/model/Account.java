package com.uow.bank.model;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.uow.bank.validation.PSCode;

public class Account {

	@NotNull
	private int accNum;

	@NotNull
	@Size(min=2,max=50,message="Invalid length")
	@Pattern(regexp="[A-Za-z(\\s)]+", message="Name should not conatin any digits")
	private String accHolderName;

	@NotNull
	@Min(value=5000, message="Minimum bal must be 5000")
	private int accBal;

	@NotNull
	private String accType;
	
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@NotNull
	@Past(message="Future date is not allowed")
	private Date dob;
	
	@NotNull
	@PSCode
	private String psCode;

	public Account() {}

	public Account(int accNum, String accHolderName, int accBal, String accType, Date dob, String psCode) {
		super();
		this.accNum = accNum;
		this.accHolderName = accHolderName;
		this.accBal = accBal;
		this.accType = accType;
		this.dob = dob;
		this.psCode = psCode;
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

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", accHolderName=" + accHolderName + ", accBal=" + accBal
				+ ", accType=" + accType + ", dob=" + dob + ", psCode=" + psCode + "]";
	}

}
