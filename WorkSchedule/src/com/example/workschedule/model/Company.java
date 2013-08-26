package com.example.workschedule.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Company {

	public static final String COMP_ID = "compId";
	public static final String NAME = "name";
	public static final String WRK_HR_VALUE = "wrkHrValue";
	public static final String OVERTIME_RATIO = "overtimeRatio";
	public static final String CURRENCY = "currency";
	public static final String IS_CURR_FIXED = "isCurrFixed";
	public static final String EXCHANGE_VALUE = "exchangeValue";

	@DatabaseField(generatedId = true)
	private long compId;
	@DatabaseField
	private String name;
	@DatabaseField
	private double wrkHrValue;
	@DatabaseField
	private double overtimeRatio;
	@DatabaseField(foreign = true, columnName = Currency.CURR_ID, foreignAutoRefresh = true)
	private Currency currency;
	@DatabaseField
	private boolean isCurrFixed;
	@DatabaseField
	private double exchangeValue;

	public Company() {
	}

	public Company(long compId, String name, double wrkHrValue,
			double overtimeRatio, Currency currency, boolean isCurrFixed,
			double exchangeValue) {
		super();
		this.compId = compId;
		this.name = name;
		this.wrkHrValue = wrkHrValue;
		this.overtimeRatio = overtimeRatio;
		this.currency = currency;
		this.isCurrFixed = isCurrFixed;
		this.exchangeValue = exchangeValue;
	}

	public long getCompId() {
		return compId;
	}

	public void setCompId(long compId) {
		this.compId = compId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWrkHrValue() {
		return wrkHrValue;
	}

	public void setWrkHrValue(double wrkHrValue) {
		this.wrkHrValue = wrkHrValue;
	}

	public double getOvertimeRatio() {
		return overtimeRatio;
	}

	public void setOvertimeRatio(double overtimeRatio) {
		this.overtimeRatio = overtimeRatio;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public boolean isCurrFixed() {
		return isCurrFixed;
	}

	public void setCurrFixed(boolean isCurrFixed) {
		this.isCurrFixed = isCurrFixed;
	}

	public double getExchangeValue() {
		return exchangeValue;
	}

	public void setExchangeValue(double exchangeValue) {
		this.exchangeValue = exchangeValue;
	}
}
