package com.example.workschedule.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.bugsense.trace.BugSenseHandler;
import com.example.workschedule.R;
import com.example.workschedule.dal.CurrencyDAO;
import com.example.workschedule.model.Currency;

public class MainActivity extends Activity {

	private static final String API_KEY = "822c1f57";
	private TextView textview;
	private Object obj;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// initiate BugSense
		BugSenseHandler.initAndStartSession(this, API_KEY);

		setContentView(R.layout.activity_main);

		CurrencyDAO dao = new CurrencyDAO(this);
		dao.clearTable();

		textview = (TextView) findViewById(R.id.textview);

		List<Currency> bonusList = new ArrayList<Currency>();
		bonusList.add(new Currency("dollar", "$"));
		bonusList.add(new Currency("dinar", "JD"));
		bonusList.add(new Currency("euro", "€"));

		try {
			obj.toString();
		} catch (Exception e) {

			BugSenseHandler
					.sendExceptionMessage("with handled", "Exception", e);

		}
		dao.insertAll(bonusList);

		textview.setText(dao.getAllCurrencies().get(0).getCurrDesc());

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onStart() {

		BugSenseHandler.startSession(this);

		super.onStart();
	}

	@Override
	protected void onDestroy() {

		BugSenseHandler.closeSession(this);

		super.onDestroy();
	}

}
