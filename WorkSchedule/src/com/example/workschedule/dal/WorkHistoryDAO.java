package com.example.workschedule.dal;

import java.sql.SQLException;

import android.content.Context;

import com.example.workschedule.model.WorkHistory;
import com.j256.ormlite.dao.Dao;

public class WorkHistoryDAO extends DatabaseHelper {

	private static volatile Dao<WorkHistory, Long> workHistDao;

	public WorkHistoryDAO(Context context) {
		super(context);
	}

	protected Dao<WorkHistory, Long> getDaoObject() throws SQLException {

		if (workHistDao == null) {
			synchronized (WorkHistoryDAO.class) {
				if (workHistDao == null) {
					workHistDao = getDao(WorkHistory.class);
				}
			}
		}

		return workHistDao;
	}

	@Override
	public void close() {
		workHistDao = null;
		super.close();
	}

}
