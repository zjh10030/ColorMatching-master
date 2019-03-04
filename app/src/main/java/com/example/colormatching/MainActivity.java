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
    }
        private int colorName1;
        private int colorName2;
        private int colorName3;
        private int colorName4;
        private int colorName5;
        private int colorName6;


    private void addListener() {
        EditText.OnEditorActionListener listener = new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionID, KeyEvent event) {
                if (actionID == EditorInfo.IME_ACTION_DONE) {

                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    String[] colors = getResources().getStringArray(R.array.colors);
                    EditText input1 = findViewById(R.id.color1);
                    String name1 = input1.getText().toString().toLowerCase();
                    EditText input2 = findViewById(R.id.color2);
                    String name2 = input2.getText().toString().toLowerCase();
                    EditText input3 = findViewById(R.id.color3);
                    String name3 = input3.getText().toString().toLowerCase();
                    EditText input4 = findViewById(R.id.color4);
                    String name4 = input4.getText().toString().toLowerCase();
                    EditText input5 = findViewById(R.id.color5);
                    String name5 = input5.getText().toString().toLowerCase();
                    EditText input6 = findViewById(R.id.color6);
                    String name6 = input6.getText().toString().toLowerCase();

                    if (v.getId() == R.id.color1) {
                        if (colors[colorName1].equals(name1)) {
                            answerPrintYes();
                        } else {
                            answerPrintNo();
                            input1.getText().clear();
                        }
                    }
                        if (v.getId() == R.id.color2) {
                            if (colors[colorName2].equals(name2)) {
                                answerPrintYes();
                            } else {
                                answerPrintNo();
                                input2.getText().clear();
                            }

                        }

                    if (v.getId() == R.id.color3) {
                        if (colors[colorName3].equals(name3)) {
                            answerPrintYes();
                        } else {
                            answerPrintNo();
                            input3.getText().clear();
                        }

                    }

                    if (v.getId() == R.id.color4) {
                        if (colors[colorName4].equals(name4)) {
                            answerPrintYes();
                        } else {
                            answerPrintNo();
                            input4.getText().clear();
                        }

                    }

                    if (v.getId() == R.id.color5) {
                        if (colors[colorName5].equals(name5)) {
                            answerPrintYes();
                        } else {
                            answerPrintNo();
                            input5.getText().clear();
                        }

                    }

                    if (v.getId() == R.id.color6) {
                        if (colors[colorName6].equals(name6)) {
                            answerPrintYes();
                        } else {
                            answerPrintNo();
                            input6.getText().clear();
                        }

                    }

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
        colorName1 = randomColor1;
        setColor2(colors[randomColor2]);
        colorName2 = randomColor2;
        setColor3(colors[randomColor3]);
        colorName3 = randomColor3;
        setColor4(colors[randomColor4]);
        colorName4 = randomColor4;
        setColor5(colors[randomColor5]);
        colorName5 = randomColor5;
        setColor6(colors[randomColor6]);
        colorName6 = randomColor6;
    }

    private void setColor1(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output1).setBackgroundColor(color);
        EditText input1 = findViewById(R.id.color1);
        input1.getText().clear();


    }

    private void setColor2(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output2).setBackgroundColor(color);
        EditText input2 = findViewById(R.id.color2);
        input2.getText().clear();
    }

    private void setColor3(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output3).setBackgroundColor(color);
        EditText input3 = findViewById(R.id.color3);
        input3.getText().clear();
    }

    private void setColor4(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output4).setBackgroundColor(color);
        EditText input4 = findViewById(R.id.color4);
        input4.getText().clear();
    }

    private void setColor5(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output5).setBackgroundColor(color);
        EditText input5 = findViewById(R.id.color5);
        input5.getText().clear();
    }

    private void setColor6(String name) {
        int colorID = getResources().getIdentifier(name, "color", this.getPackageName());

        int color = ContextCompat.getColor(this, colorID);

        findViewById(R.id.output6).setBackgroundColor(color);
        EditText input6 = findViewById(R.id.color6);
        input6.getText().clear();
    }

    private void answerPrintYes() {
        Toast.makeText(this, "This is the Correct Color Good Job!", Toast.LENGTH_SHORT).show();
    }
    private void answerPrintNo() {
        Toast.makeText(this, "This is not the Correct Color", Toast.LENGTH_SHORT).show();
        }

    }





