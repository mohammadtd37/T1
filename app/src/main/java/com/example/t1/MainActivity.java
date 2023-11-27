package com.example.t1;



import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView im ;
    TextView text , time;
    EditText con;
    Button btn, button;
    int counter = 6 ;

    Random rand = new Random();
    int random;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        text = findViewById(R.id.text);
        con = findViewById(R.id.con);
        button = findViewById(R.id.button);
        time = findViewById(R.id.time);
        im = findViewById(R.id.im);
        Bitmap img = BitmapFactory.decodeResource(this.getResources(),R.drawable.numbers_background);
        im.setImageBitmap(img);








        random = rand.nextInt(100 + 1); // number 1 to 100
//      Toast.makeText(this, random + "", Toast.LENGTH_SHORT).show();   show in timeline
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNumber(2000);
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String x = con.getText().toString();
                    int number = Integer.parseInt(x);
                    checkNumber(number);
                }
                catch (NumberFormatException x ){


                }




            }

        });


    }

    private void checkNumber(int number) {
        if (1000>number && number>100){
            text.setText("Wrong");
            time.setText(counter+" Time Play");
            counter++ ;
        } else if (number==2000) {
            random = rand.nextInt(100 + 1); // number 1 to 100
            text.setText("rest game");
            counter = 7  ;
            time.setText(counter+" Time Play");
        }
        else {
            if (number == random) {
                text.setText("Win");
                counter = 7;
                random = rand.nextInt(100 + 1); // number 1 to 100
            }
            else if (number > random) {
                text.setText("High");
            }
            else if (number < random) {           // output your condition
                text.setText("Low");
            }
            if (counter == 1) {
                text.setText("Lose" + random);
                counter = 7;
                random = rand.nextInt(100+ 1); // number 1 to 100
            }
        }

        counter -= 1;
        time.setText(counter + " Time Play");
        con.setText("");
    }
}

