package com.example.trifon.homework01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by trifon on 18.09.16.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

	private final static String TAG_FOR_DEBUG = MainActivity.class.getSimpleName();

	private Button btn01;
	private int timesBtn01Clicked;

	private Button btn02;
	private int timesBtn02Clicked;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Log.d(TAG_FOR_DEBUG, "onCreate");

		// @Trifon - get reference to buttons
		btn01 = (Button) findViewById(R.id.button01);
		btn01.setOnClickListener(this);

		btn02 = (Button) findViewById(R.id.button02);
	}

	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.button01) {
			timesBtn01Clicked++;
			Log.d(TAG_FOR_DEBUG, "Button01 was clicked: " + String.valueOf(timesBtn01Clicked));

			btn01.setText(String.valueOf(timesBtn01Clicked));
		}
	}

	public void onButton02Clicked(View view) {
		if (view.getId() == R.id.button02) {
			timesBtn02Clicked++;
			Log.d(TAG_FOR_DEBUG, "Button02 was clicked: " + String.valueOf(timesBtn02Clicked));
			btn02.setText(String.valueOf(timesBtn02Clicked));

			// Exits from the application
			//finish();
		}
	}
}