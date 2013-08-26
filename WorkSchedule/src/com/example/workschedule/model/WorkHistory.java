package com.example.workschedule.model;

import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class WorkHistory {

	public static final String WRK_HIST_ID = "workHistId";
	public static final String COMPANY = "company";
	public static final String START_TIME = "startTime";
	public static final String END_TIME = "endTime";
	public static final String IS_OVERTIME = "isOvertime";
	public static final String ESTIMATION_AMOUNT = "estimationAmount";

	@DatabaseField(generatedId = true)
	private long workHistId;
	@DatabaseField(foreign = true, columnName = Company.COMP_ID, foreignAutoRefresh = true)
	private Company company;

	// private Date day;

	@DatabaseField
	private Date startTime;
	@DatabaseField
	private Date endTime;

	// private date timeDuration;

	@DatabaseField
	private boolean isOvertime;
	@DatabaseField
	private double estimationAmount;

	public WorkHistory() {
	}

	public WorkHistory(long workHistId, Company company, Date startTime,
			Date endTime, boolean isOvertime, double estimationAmount) {
		super();
		this.workHistId = workHistId;
		this.company = company;
		this.startTime = startTime;
		this.endTime = endTime;
		this.isOvertime = isOvertime;
		this.estimationAmount = estimationAmount;
	}

	public long getWorkHistId() {
		return workHistId;
	}

	public void setWorkHistId(long workHistId) {
		this.workHistId = workHistId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isOvertime() {
		return isOvertime;
	}

	public void setOvertime(boolean isOvertime) {
		this.isOvertime = isOvertime;
	}

	public double getEstimationAmount() {
		return estimationAmount;
	}

	public void setEstimationAmount(double estimationAmount) {
		this.estimationAmount = estimationAmount;
	}
}
