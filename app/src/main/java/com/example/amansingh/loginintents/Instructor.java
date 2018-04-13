package com.example.amansingh.loginintents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Instructor extends AppCompatActivity
{

    Button b,o;
    ImageView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructor);
        Intent i = getIntent();
        b = (Button)findViewById(R.id.capture);
        o = (Button)findViewById(R.id.open);
        v = (ImageView)findViewById(R.id.imageView);
        String user = i.getStringExtra("user");
        Toast.makeText(Instructor.this,"Welcome Instructor "+user,Toast.LENGTH_LONG).show();
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://www.google.com"));
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100) {
            if (resultCode == RESULT_OK) {
                Bundle b = data.getExtras();
                Bitmap image = (Bitmap)b.get("data");
                v.setImageBitmap(image);
            }
            else
            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(Instructor.this,"User cancelled",Toast.LENGTH_LONG).show();
            }
        }
    }
}
