package com.example.julia.toast;

import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.julia.toast.R.id.scroll;
import static com.example.julia.toast.R.id.textView1;
import static com.example.julia.toast.R.id.textView2;
import static com.example.julia.toast.R.id.textView3;
import static com.example.julia.toast.R.id.textViewTitle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:

                changeColor(R.color.colorRed, R.string.title_panther, R.string.about_panther1,
                        R.string.about_panther2, R.string.about_panther3, R.string.about_panther4,
                        R.drawable.panther, "The color changed to RED!");
                break;

            case R.id.button2:

                changeColor(R.color.colorGreen, R.string.title_leopard, R.string.about_leopard1,
                        R.string.about_leopard2, R.string.about_leopard3, R.string.about_leopard4,
                        R.drawable.leopard, "The color changed to GREEN!");
                break;

            case R.id.button3:

                changeColor(R.color.colorBlue, R.string.title_lynx, R.string.about_lynx1,
                        R.string.about_lynx2, R.string.about_lynx3, R.string.about_lynx4,
                        R.drawable.lynx, "The color changed to BLUE!");

                break;
        }
    }

    private void changeColor(int colorId, int titleId, int text1Id, int text2Id, int text3Id, int text4Id,
                             int imageId, String message)
    {
        ScrollView scroll = (ScrollView) findViewById(R.id.scroll);

        TextView textViewTitle = (TextView) findViewById(R.id.textViewTitle);
        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        TextView textView4 = (TextView) findViewById(R.id.textView4);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);


        scroll.setBackgroundColor(getResources().getColor(colorId));

        textViewTitle.setText(getResources().getString(titleId));

        textView1.setText(getResources().getString(text1Id));
        textView2.setText(getResources().getString(text2Id));
        textView3.setText(getResources().getString(text3Id));
        textView4.setText(getResources().getString(text4Id));

        imageView.setImageDrawable(getResources().getDrawable(imageId));

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();

    }

}
