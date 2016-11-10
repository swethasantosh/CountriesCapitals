package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity2 extends Navigation_main
{
    private DrawerLayout drawerlayout;
    RadioGroup r;
    TextView textmsg;
    private ActionBarDrawerToggle drawerlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main_activity2, contentFrameLayout);



       /* drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        drawerlistener = new ActionBarDrawerToggle(this, drawerlayout,
                R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close);
        drawerlayout.setDrawerListener(drawerlistener);*/

        //setContentView(R.layout.activity_main_activity2);
        //textmsg = (TextView)findViewById(R.id.textmsg);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
