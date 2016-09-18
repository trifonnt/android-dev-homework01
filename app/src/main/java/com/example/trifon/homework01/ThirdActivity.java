package com.example.trifon.homework01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by trifon on 18.09.16.
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

	private final static String TAG_FOR_DEBUG = ThirdActivity.class.getSimpleName();

	private TextView txtView01;
	private TextView txtView02;
	private Button returnButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		txtView01 = (TextView) findViewById(R.id.act03_textView_01);
		txtView02 = (TextView) findViewById(R.id.act03_textView_02);
		returnButton = (Button) findViewById(R.id.act03_return_button);

		Intent intent = getIntent();
		if (intent != null) {
			int txtViewId = intent.getIntExtra("txtViewId", -1);
			String txtViewContent = intent.getStringExtra("txtViewContent");

			txtView01.setText(String.valueOf(txtViewId));
			txtView02.setText(txtViewContent);
		}

		returnButton.setOnClickListener(this);
	}


	@Override
	public void onClick(View view) {
		if (view.getId() == R.id.act03_return_button) {
			Log.d(TAG_FOR_DEBUG, "Clicked Return button!");

			Intent returnIntent = getIntent();
			returnIntent.putExtra("result", 500);
			setResult(RESULT_OK, returnIntent);
			finish();
		}
	}
}
