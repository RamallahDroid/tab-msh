package com.example.workschedule.dal;

import java.sql.SQLException;
import java.util.List;

import android.content.Context;

import com.example.workschedule.model.Currency;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.table.TableUtils;

public class CurrencyDAO extends DatabaseHelper {

	private static volatile Dao<Currency, Long> currencyDao;

	public CurrencyDAO(Context context) {
		super(context);
	}

	protected Dao<Currency, Long> getDaoObject() throws SQLException {

		if (currencyDao == null) {
			synchronized (CurrencyDAO.class) {
				if (currencyDao == null) {
					currencyDao = getDao(Currency.class);
				}
			}
		}

		return currencyDao;
	}

	@Override
	public void close() {
		currencyDao = null;
		super.close();
	}

	public void insertAll(List<Currency> list) {
		try {

			for (Currency item : list) {
				getDaoObject().createOrUpdate(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Currency> getAllCurrencies() {

		try {
			return getDaoObject().queryForAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void clearTable() {
		try {
			TableUtils.clearTable(connectionSource, Currency.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
