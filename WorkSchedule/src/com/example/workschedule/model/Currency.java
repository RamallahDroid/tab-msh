package com.example.workschedule.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Currency {

	public static final String CURR_ID = "currId";
	public static final String CURR_DESC = "currDesc";
	public static final String CURR_SYMBOL = "currSymbol";

	@DatabaseField(generatedId = true)
	private long currId;
	@DatabaseField
	private String currDesc;
	@DatabaseField
	private String currSymbol;

	public Currency() {
	}

	public Currency(String currDesc, String currSymbol) {
		super();
		this.currDesc = currDesc;
		this.currSymbol = currSymbol;
	}

	public long getCurrId() {
		return currId;
	}

	public void setCurrId(long currId) {
		this.currId = currId;
	}

	public String getCurrDesc() {
		return currDesc;
	}

	public void setCurrDesc(String currDesc) {
		this.currDesc = currDesc;
	}

	public String getCurrSymbol() {
		return currSymbol;
	}

	public void setCurrSymbol(String currSymbol) {
		this.currSymbol = currSymbol;
	}
}
