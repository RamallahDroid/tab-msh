package com.example.workschedule.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Bonus {

	public static final String BONUS_ID = "bonusId";
	public static final String COMPANY = "company";
	public static final String MONTH = "month";
	public static final String BONUS_VALUE = "bonusValue";

	@DatabaseField(generatedId = true)
	private long bonusId;
	@DatabaseField(foreign = true, columnName = Company.COMP_ID, foreignAutoRefresh = true)
	private Company company;
	@DatabaseField
	private int month;
	@DatabaseField
	private double bonusValue;

	public Bonus() {
	}

	public Bonus(long bonusId, Company company, int month, double bonusValue) {
		super();
		this.bonusId = bonusId;
		this.company = company;
		this.month = month;
		this.bonusValue = bonusValue;
	}

	public long getBonusId() {
		return bonusId;
	}

	public void setBonusId(long bonusId) {
		this.bonusId = bonusId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public double getBonusValue() {
		return bonusValue;
	}

	public void setBonusValue(double bonusValue) {
		this.bonusValue = bonusValue;
	}
}
