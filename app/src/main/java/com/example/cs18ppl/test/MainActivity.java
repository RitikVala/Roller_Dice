package com.example.cs18ppl.test;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int Count = 0;
    int guessCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void generate(View view) {
        //Computer View
        TextView results = (TextView) this.findViewById(R.id.txt1);
        TextView results1 = (TextView) this.findViewById(R.id.finalview);
        //User input box
        EditText Num1 = (EditText) this.findViewById(R.id.userInput);
        String text_check = Num1.getText().toString().trim();

        //Use try and Catch
        try {

            if (text_check.isEmpty() || text_check == null) {
                results1.setText("Please Enter A Value");
            } else {
                guessCount++;
                TextView guess = (TextView) this.findViewById(R.id.numguess);
                Random r = new Random();
                int randNum = r.nextInt(7 - 1) + 1;
                int Num2 = Integer.parseInt(Num1.getText().toString());

                if (Num2 == randNum) {
                    scoreBoard(view);
                }


                String CompGen = String.valueOf(randNum);
                results.setText("Computer's Number: \r" + CompGen);
                results1.setText("Your Number: \r" + Num2);
                guess.setText("Guess Counter: \n" + guessCount);

            }
        }
        catch(Exception ex){
            Log.e("Error" , "Error");
        }

    }

    public void scoreBoard(View View) {
        Count++;
        TextView scoreCard = (TextView) this.findViewById(R.id.score);
        scoreCard.setText("Your Score:" + Count);

    }
}