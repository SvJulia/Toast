package com.example.julia.toast;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{

    Button button;
    EditText editText;
    //LinearLayout linearLayout;
    //String color;

    public static final String COLOR = "color";

    public static final int REQUEST_CODE = 0;

//    public static final Intent start(Context context) {
//        Intent starter = new Intent(context, ResultActivity.class);
//        return starter;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);

        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent = new Intent(ResultActivity.this, MainActivity.class);

        String chooseColor = editText.getText().toString();

        intent.putExtra(COLOR, chooseColor);

        setResult(RESULT_OK,intent);

        Toast toast2 = Toast.makeText(getApplicationContext(),
                "The color changed to " + chooseColor +"!", Toast.LENGTH_SHORT);
        toast2.show();

        finish();
    }
}
