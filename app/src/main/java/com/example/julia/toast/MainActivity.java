package com.example.julia.toast;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;
    Button btn_ChooseColor;

    ImageView imageView;

    ScrollView scroll;

    static final private int CHOOSE_COLOR = 0;
    static final private int GALLEY_REQUEST = 1;
    static final private String IMAGE_VIEW = "image";
    static final private String COLOR_VIEW = "color";

    int parsedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        btn_ChooseColor = (Button) findViewById(R.id.btn_ChooseColor);

        imageView = (ImageView) findViewById(R.id.imageView);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

        btn_ChooseColor.setOnClickListener(this);

        imageView.setOnClickListener(this);

        getValues(savedInstanceState);
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

            case R.id.btn_ChooseColor:

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(intent, CHOOSE_COLOR);

                break;

            case R.id.imageView:

                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent,GALLEY_REQUEST);

                break;
        }
    }

    private void changeColor(int colorId, int titleId, int text1Id, int text2Id, int text3Id, int text4Id,
                             int imageId, String message) {
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


    private void getValues(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }

        imageView.setImageBitmap((Bitmap) savedInstanceState.getParcelable(IMAGE_VIEW));
        //scroll.setBackgroundColor(savedInstanceState.getInt(COLOR_VIEW));
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);

        imageView = (ImageView) findViewById(R.id.imageView);
        scroll = (ScrollView) findViewById(R.id.scroll);

        saveInstanceState.putParcelable(IMAGE_VIEW, ((BitmapDrawable) imageView.getDrawable()).getBitmap());
        //saveInstanceState.putInt(COLOR_VIEW, parsedColor);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK)
        {
            return;
        }

        if (requestCode == CHOOSE_COLOR) {

            String colorText = data.getStringExtra(ResultActivity.COLOR);
            parsedColor = Color.parseColor(colorText);

            ScrollView scroll = (ScrollView) findViewById(R.id.scroll);
            scroll.setBackgroundColor(parsedColor);

        }

        if (requestCode == GALLEY_REQUEST){

            imageView = (ImageView) findViewById(R.id.imageView);

            Uri selectedImage = data.getData();
            imageView.setImageURI(selectedImage);

        }
    }

}