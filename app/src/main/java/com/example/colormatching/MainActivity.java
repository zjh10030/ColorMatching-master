package com.example.colormatching;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.util.Collections.shuffle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListener();
      // I was close to figuring this out and its almost 2 o clock in the morning
        // I've worked my entire weekend if I had to guess I've worked a total of 5 hours+ on this
        // and I don't think its worth me pulling my hair out.
        // I got to a point were if there was one answer it works no problem but just will not work
        // properly with two inputs I don't know if there might have been on edit text method like how
        // the view view works with the button that was one of the things I kept trying to google with
        // no luck hopefully I get at least half credit I would have seen a tutor about this but out of
        // my other work I thought this would be something I could handle but apperently I underestimated
        // how complex the text-answer system was. I'm not saying that you should do this but it might have
        // have been helpful for certain people to review how to interact with multiple EditTexts in a single
        // method as I'm sure it more simple then it can possibly be but a 5 minute review would be very welcomed
        // when using a new enviorment like android app creator.
    }

    private int colorAnswer1;
    private int colorAnswer2;

    private void addListener() {
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event) {
                if (actionID == EditorInfo.IME_ACTION_DONE) {
                    answerCheck1(null);
                    answerCheck2(null);

                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    return true;
                }

                return false;

            }
        };


        EditText input = findViewById(R.id.color1);
        input.setOnEditorActionListener(listener);
        EditText input2 = findViewById(R.id.color2);
        input2.setOnEditorActionListener(listener);
        EditText input3 = findViewById(R.id.color3);
        input3.setOnEditorActionListener(listener);
        EditText input4 = findViewById(R.id.color4);
        input4.setOnEditorActionListener(listener);
        EditText input5 = findViewById(R.id.color5);
        input5.setOnEditorActionListener(listener);
        EditText input6 = findViewById(R.id.color6);
        input6.setOnEditorActionListener(listener);

    }



    public void Shuffle(View view) {
        String[] colors = getResources().getStringArray(R.array.colors);


        int randomColor1 = (int) (colors.length * Math.random());
        int randomColor2 = (int) (colors.length * Math.random());
        if (randomColor1 == randomColor2) {
            while (randomColor1 == randomColor2) {
                randomColor2 = (int) (colors.length * Math.random());
            }
        }
        int randomColor3 = (int) (colors.length * Math.random());
        if (randomColor3 == randomColor2 || randomColor3 == randomColor1) {
            while (randomColor3 == randomColor2 || randomColor3 == randomColor1) {
                randomColor3 = (int) (colors.length * Math.random());
            }
        }
        int randomColor4 = (int) (colors.length * Math.random());
        if (randomColor4 == randomColor2 || randomColor4 == randomColor1 || randomColor4 == randomColor3) {
            while (randomColor4 == randomColor2 || randomColor4 == randomColor1 || randomColor4 == randomColor3) {
                randomColor4 = (int) (colors.length * Math.random());
            }
        }
        int randomColor5 = (int) (colors.length * Math.random());
        if (randomColor5 == randomColor2 || randomColor5 == randomColor1 || randomColor5 == randomColor3 || randomColor5 == randomColor4) {
            while (randomColor5 == randomColor2 || randomColor5 == randomColor1 || randomColor5 == randomColor3 || randomColor5 == randomColor4) {
                randomColor5 = (int) (colors.length * Math.random());
            }
        }
        int randomColor6 = (int) (colors.length * Math.random());
        if (randomColor6 == randomColor2 || randomColor6 == randomColor1 || randomColor6 == randomColor3 || randomColor6 == randomColor4 || randomColor6 == randomColor5) {
            while (randomColor6 == randomColor2 || randomColor6 == randomColor1 || randomColor6 == randomColor3 || randomColor6 == randomColor4 || randomColor6 == randomColor5) {
                randomColor6 = (int) (colors.length * Math.random());
            }
        }

        setColor1(colors[randomColor1]);
        this.colorAnswer1 = randomColor1;
        setColor2(colors[randomColor2]);
        this.colorAnswer2 = randomColor2;
        setColor3(colors[randomColor3]);
        setColor4(colors[randomColor4]);
        setColor5(colors[randomColor5]);
        setColor6(colors[randomColor6]);
    }

    private void setColor1(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output1).setBackgroundColor(color);

    }

    private void setColor2(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output2).setBackgroundColor(color);

    }

    private void setColor3(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output3).setBackgroundColor(color);

    }

    private void setColor4(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output4).setBackgroundColor(color);

    }

    private void setColor5(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output5).setBackgroundColor(color);

    }

    private void setColor6(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output6).setBackgroundColor(color);

    }

    public void answerCheck1(View view) {
        String[] colors = getResources().getStringArray(R.array.colors);
        String answer1 = colors[colorAnswer1];
        EditText input1 = findViewById(R.id.color1);
        String color1 = input1.getText().toString().toLowerCase();

        if (color1.equals(answer1)) {
            Toast.makeText(this, "This is the Correct Color Good Job!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "This is incorrect please try again", Toast.LENGTH_SHORT).show();
        }

    }
    public void answerCheck2 (View view ) {
        String[] colors = getResources().getStringArray(R.array.colors);
        String answer2 = colors[colorAnswer2];
        EditText input2 = findViewById(R.id.color2);
        String color2 = input2.getText().toString().toLowerCase();

        if (color2.equals(answer2)) {
            Toast.makeText(this, "This is the Correct Color Good Job!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "This is incorrect please try again", Toast.LENGTH_SHORT).show();
        }
    }

    }

