package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Navigation_main
{
    Button b3_africa,b4_asia,b5_europe,b6_na,b7_sa,b8_aus,b9_anta,b10_all,b11_flag,b12_name;

    private DrawerLayout drawerlayout;
    RadioGroup r;
    TextView textmsg;
    private ActionBarDrawerToggle drawerlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        //textmsg = (TextView)findViewById(R.id.textmsg);


        b3_africa =(Button)findViewById(R.id.button3);
        b4_asia =(Button)findViewById(R.id.button4);
        b5_europe =(Button)findViewById(R.id.button5);
        b6_na =(Button)findViewById(R.id.button6);
        b7_sa =(Button)findViewById(R.id.button7);
        b8_aus =(Button)findViewById(R.id.button8);
        b9_anta =(Button)findViewById(R.id.button9);
        b10_all =(Button)findViewById(R.id.button10);
        b11_flag =(Button)findViewById(R.id.button11);
        b12_name =(Button)findViewById(R.id.button12);




        b3_africa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent10 = new Intent(getApplicationContext(), Africa.class);

                startActivity(intent10);
            }
        });
        b4_asia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent9 = new Intent(getApplicationContext(), Asiamainactivity.class);

                startActivity(intent9);
            }
        });

        b5_europe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent11 = new Intent(getApplicationContext(), EuropeMainActivity.class);

                startActivity(intent11);
            }
        });

        b6_na.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent6 = new Intent(getApplicationContext(), NorthAmericaMainActivity.class);

                startActivity(intent6);
            }
        });
        b7_sa.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent7 = new Intent(getApplicationContext(), SouthAmerica.class);

                startActivity(intent7);
            }
        });
        b8_aus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent8 = new Intent(getApplicationContext(), AusraliaMainActivity.class);

                startActivity(intent8);
            }
        });
        b9_anta.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent9 = new Intent(getApplicationContext(), Antarctica.class);

                startActivity(intent9);
            }
        });
        b10_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent10 = new Intent(getApplicationContext(), Allcountriesadapter.class);

                startActivity(intent10);
            }
        });
        b11_flag.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //Intent intent11 = new Intent(getApplicationContext(),Imagequiz.class);
                Intent intent11 = new Intent(getApplicationContext(),ContinentwiseQuiz.class);
                intent11.putExtra("ClassName","FlagQuiz");
                startActivity(intent11);
            }
        });
        b12_name.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent12 = new Intent(getApplicationContext(), ContinentwiseQuiz.class);
                intent12.putExtra("ClassName","NameQuiz");
                startActivity(intent12);
            }
        });


    }

    public void onRadioButtonClicked(View v)
    {
        boolean checked = ((RadioButton)v).isChecked();
        switch (v.getId())
        {
            case R.id.radioButton:
                if(checked)
                {
                    Intent intent1 = new Intent(getApplicationContext(),Africa.class);
                    startActivity(intent1);
                    break;
                }
            case R.id.radioButton2:
                if(checked)
                {
                    Intent intent2 = new Intent(getApplicationContext(),Asiamainactivity.class);
                    startActivity(intent2);
                    break;
                }
            case R.id.radioButton3:
                if(checked)
                {
                    Intent intent3 = new Intent(getApplicationContext(),EuropeMainActivity.class);
                    startActivity(intent3);
                    break;
                }
            case R.id.radioButton4:
                if(checked)
                {
                    Intent intent4 = new Intent(getApplicationContext(),NorthAmericaMainActivity.class);
                    startActivity(intent4);
                    break;
                }

            case R.id.radioButton5:
                if(checked) {
                    Intent intent5 = new Intent(getApplicationContext(), SouthAmerica.class);
                    startActivity(intent5);
                    break;
                }
            case R.id.radioButton6:
                if(checked) {
                    Intent intent6 = new Intent(getApplicationContext(), AusraliaMainActivity.class);
                    startActivity(intent6);
                    break;
                }
            case R.id.radioButton7:
                if(checked) {
                    Intent intent7 = new Intent(getApplicationContext(),Allcountriesadapter.class);
                    startActivity(intent7);
                    break;
                }
            case R.id.radioButton8:
                if(checked) {
                    Intent intent8 = new Intent(getApplicationContext(), Imagequiz.class);
                    startActivity(intent8);
                    break;
                }
            case R.id.radioButton9:
                if(checked) {

                    Intent intent9 = new Intent(getApplicationContext(), ContinentwiseQuiz.class);
                    startActivity(intent9);
                    break;
                }
            case R.id.radioButton10:
                if(checked) {

                    Intent intent10 = new Intent(getApplicationContext(), Antarctica.class);
                    startActivity(intent10);
                    break;
                }
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
