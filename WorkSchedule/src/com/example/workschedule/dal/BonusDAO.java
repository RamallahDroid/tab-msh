package com.example.workschedule.dal;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.example.workschedule.model.Bonus;
import com.j256.ormlite.dao.Dao;

public class BonusDAO extends DatabaseHelper {

	private static volatile Dao<Bonus, Long> bonusDao;

	public BonusDAO(Context context) {
		super(context);
	}

	protected Dao<Bonus, Long> getDaoObject() throws SQLException {

		if (bonusDao == null) {
			synchronized (BonusDAO.class) {
				if (bonusDao == null) {
					bonusDao = getDao(Bonus.class);
				}
			}
		}

		return bonusDao;
	}

	@Override
	public void close() {
		bonusDao = null;
		super.close();
	}

	public void insertAll(List<Bonus> list) {
		try {

			for (Bonus item : list) {
				getDaoObject().createOrUpdate(item);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
