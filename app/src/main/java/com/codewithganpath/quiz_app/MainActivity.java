package com.codewithganpath.quiz_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btPlayQuiz,bt_about;

    public static Context context;

    long backPressedTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btPlayQuiz = findViewById(R.id.bt_playQuiz);
        bt_about = findViewById(R.id.bt_about);

        btPlayQuiz.setOnClickListener(this);
        bt_about.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.bt_playQuiz:

                Intent playIntent = new Intent(MainActivity.this,CategoryActivity.class);
                startActivity(playIntent);
                finish();
                break;

            case R.id.bt_about:

                Intent about = new Intent(MainActivity.this,DeveloperActivity.class);
                startActivity(about);
                finish();
                break;



        }

    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis()) {

            new AlertDialog.Builder(this)
                    .setTitle("Do you  want to exit?")
                    .setNegativeButton("No", null)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            setResult(RESULT_OK, new Intent().putExtra("Exit", true));
                            finish();
                        }
                    }).create().show();

        }else  {

            Toast.makeText(this, "Press Again to Exit", Toast.LENGTH_SHORT).show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i("BUGBUG","onStop() in MainActivity");
        finish();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        finish();
    }
}
