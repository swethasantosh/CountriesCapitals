package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class ContinentwiseQuiz extends Navigation_main
{
    public static String flagbtn;
    Button b3_africa,b4_asia,b5_europe,b6_na,b7_sa,b8_aus,b9_random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //
       // setContentView(R.layout.activity_continentwise_quiz);




        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_continentwise_quiz, contentFrameLayout);



        b3_africa =(Button)findViewById(R.id.button3);
        b4_asia =(Button)findViewById(R.id.button4);
        b5_europe =(Button)findViewById(R.id.button5);
        b6_na =(Button)findViewById(R.id.button6);
        b7_sa =(Button)findViewById(R.id.button7);
        b8_aus =(Button)findViewById(R.id.button8);
        b9_random =(Button)findViewById(R.id.button9);

        flagbtn = getIntent().getExtras().getString("ClassName").toString();


        b3_africa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent10 = new Intent(getApplicationContext(), AsiaQuiz.class);
                intent10.putExtra("activity_asia","AfricaQuiz");
                intent10.putExtra("classnamederived",flagbtn);
                startActivity(intent10);
            }
        });
        b4_asia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent9 = new Intent(getApplicationContext(), AsiaQuiz.class);
               intent9.putExtra("activity_asia","AsiaQuiz");
                intent9.putExtra("classnamederived",flagbtn);
                startActivity(intent9);
            }
        });

        b5_europe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent11 = new Intent(getApplicationContext(), AsiaQuiz.class);
                intent11.putExtra("activity_asia","EuropeQuiz");
                intent11.putExtra("classnamederived",flagbtn);

                startActivity(intent11);
            }
        });

        b6_na.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent6 = new Intent(getApplicationContext(), AsiaQuiz.class);
                intent6.putExtra("activity_asia","NAQuiz");
                intent6.putExtra("classnamederived",flagbtn);
                startActivity(intent6);
            }
        });
        b7_sa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent7 = new Intent(getApplicationContext(), AsiaQuiz.class);
                intent7.putExtra("activity_asia","SAQuiz");
                intent7.putExtra("classnamederived",flagbtn);
                startActivity(intent7);
            }
        });
        b8_aus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent8 = new Intent(getApplicationContext(), AsiaQuiz.class);
                intent8.putExtra("activity_asia","AusQuiz");
                intent8.putExtra("classnamederived",flagbtn);
                startActivity(intent8);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_continentwise_quiz, menu);
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
}
