package com.example.workschedule.dal;

import java.sql.SQLException;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.workschedule.model.Bonus;
import com.example.workschedule.model.Company;
import com.example.workschedule.model.Currency;
import com.example.workschedule.model.WorkHistory;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public abstract class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final int DATABASE_VERSION = 2;

	private static String DB_NAME = "work_schedule.DB";

	private DatabaseHelper databaseHelper = null;

	private Context context;

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DATABASE_VERSION);

		this.context = context;

	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {

		try {
			TableUtils.createTable(connectionSource, WorkHistory.class);
			TableUtils.createTable(connectionSource, Company.class);
			TableUtils.createTable(connectionSource, Currency.class);
			TableUtils.createTable(connectionSource, Bonus.class);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {

		try {
			TableUtils.dropTable(connectionSource, WorkHistory.class, true);
			TableUtils.dropTable(connectionSource, Company.class, true);
			TableUtils.dropTable(connectionSource, Currency.class, true);
			TableUtils.dropTable(connectionSource, Bonus.class, true);

			onCreate(db, connectionSource);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected DatabaseHelper getHelper() {// (Context context)
		if (databaseHelper == null) {
			databaseHelper = OpenHelperManager.getHelper(context,
					DatabaseHelper.class);
		}
		return databaseHelper;
	}

	protected void releaseHelper() {
		if (databaseHelper != null) {
			OpenHelperManager.releaseHelper();
			databaseHelper = null;
		}
	}

	@Override
	public void close() {
		super.close();
	}

	// protected abstract Dao<?, Long> getDaoObject() throws SQLException;

}
