package com.example.workschedule.dal;

import java.sql.SQLException;

import android.content.Context;

import com.example.workschedule.model.Company;
import com.j256.ormlite.dao.Dao;

public class CompanyDAO extends DatabaseHelper {

	private static volatile Dao<Company, Long> companyDao;

	public CompanyDAO(Context context) {
		super(context);
	}

	protected Dao<Company, Long> getDaoObject() throws SQLException {

		if (companyDao == null) {
			synchronized (CompanyDAO.class) {
				if (companyDao == null) {
					companyDao = getDao(Company.class);
				}
			}
		}

		return companyDao;
	}

	@Override
	public void close() {
		companyDao = null;
		super.close();
	}
}
