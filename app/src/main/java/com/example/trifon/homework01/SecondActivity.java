package com.example.trifon.homework01;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by trifon on 18.09.16.
 */
public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String TAG_FOR_DEBUG = SecondActivity.class.getSimpleName();

    static final int START_ACTIVITY_03_REQUEST = 500;  // The request code

    private TextView txtView;
    private int lastBtnId;
    private Button btn01;
    private Button btn02;
    private Button btn03;

    private int countBtn01Clicked = 0;
    private int countBtn02Clicked = 0;
    private int countBtn03Clicked = 0;

    private boolean resultFromActivityThree = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        Log.d(TAG_FOR_DEBUG, "onCreate");

        // @Trifon - get reference to buttons
        txtView = (TextView) findViewById(R.id.act02_textView);
        btn01 = (Button) findViewById(R.id.act02_button_01);
        btn02 = (Button) findViewById(R.id.act02_button_02);
        btn03 = (Button) findViewById(R.id.act02_button_03);

        txtView.setOnClickListener(this);
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.act02_textView) {
            Intent thirdActivityIntent = new Intent(SecondActivity.this, ThirdActivity.class);
            thirdActivityIntent.putExtra("txtViewId", lastBtnId);
            thirdActivityIntent.putExtra("txtViewContent", txtView.getText());

            //startActivity( thirdActivytIntent );
            startActivityForResult(thirdActivityIntent, START_ACTIVITY_03_REQUEST);
        }

        lastBtnId = view.getId(); // Remember Id of the last pressed Button!
        if (view.getId() == R.id.act02_button_01) {
            countBtn01Clicked++;
            countBtn01Clicked = countBtn01Clicked % 2;
            if (countBtn01Clicked == 1) {
                // Show Id of the button
                txtView.setText(R.string.act02_button_01);
            } else {
                // Show the text of the button
                txtView.setText(String.valueOf(R.id.act02_button_01));
            }
        }

        if (view.getId() == R.id.act02_button_02) {
            countBtn02Clicked++;
            countBtn02Clicked = countBtn02Clicked % 2;
            if (countBtn02Clicked == 1) {
                // Show Id of the button
                txtView.setText(R.string.act02_button_02);
            } else {
                // Show the text of the button
                txtView.setText(String.valueOf(R.id.act02_button_02));
            }
        }

        if (view.getId() == R.id.act02_button_03) {
            countBtn03Clicked++;
            countBtn03Clicked = countBtn03Clicked % 2;
            if (countBtn03Clicked == 1) {
                // Show Id of the button
                txtView.setText(R.string.act02_button_03);
            } else {
                // Show the text of the button
                txtView.setText(String.valueOf(R.id.act02_button_03));
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d(TAG_FOR_DEBUG, "onActivityResult - resultCode = " + resultCode);

        if (resultCode == RESULT_CANCELED) {
            return;
        }

        // Check which request we're responding to
        if (requestCode == START_ACTIVITY_03_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                int extra = intent.getIntExtra("", -1);
                Log.d(TAG_FOR_DEBUG, "onActivityResult");
            }
        }
    }

    // Impleemnted in order to update UI after returning from ThirdActivity
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG_FOR_DEBUG, "onResume - resultFromActivityThree = " + resultFromActivityThree);
        if (resultFromActivityThree) {
//          PhysicalTagProperties.this.setLocation(global_lat, global_lng);
            resultFromActivityThree = false;
        }
    }
}