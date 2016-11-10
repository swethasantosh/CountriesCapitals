package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Africadetails extends ActionBarActivity
{

    int pos=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_info);

        final TextView countryname = (TextView)findViewById(R.id.countryname);
        final TextView capitalname = (TextView)findViewById(R.id.capitalname);
        final ImageView image = (ImageView)findViewById(R.id.countryimage);


        final TextView currencytext = (TextView)findViewById(R.id.currency);


        Intent in =  getIntent();
        pos = in.getExtras().getInt("Position");


        final String[] country = in.getExtras().getStringArray("Country");
        final String[] capital = in.getExtras().getStringArray("Capital");
        final int[] images = in.getExtras().getIntArray("Images");
        getSupportActionBar().setTitle("About " + country[pos].toString());








        final String[] sacurrrencylist = this.getResources().getStringArray(R.array.AfricaCurrency);




        countryname.setText(country[pos]);

        capitalname.setText(capital[pos]);

        image.setImageResource(images[pos]);



        currencytext.setText(sacurrrencylist[pos]);



        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pos>=country.length-1){pos=0;}
                if(pos<country.length-1)
                {

                   pos++;

                    image.setImageResource(images[pos]);

                    capitalname.setText(capital[pos]);
                    countryname.setText(country[pos]);



                    currencytext.setText(sacurrrencylist[pos]);
                    getSupportActionBar().setTitle("About " + country[pos].toString());



                }
            }

        });
        Button backbutton = (Button)findViewById(R.id.button2);

        backbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pos>0)
                {

                    --pos;

                    image.setImageResource(images[pos]);


                    capitalname.setText(capital[pos]);
                    countryname.setText(country[pos]);



                    currencytext.setText(sacurrrencylist[pos]);
                    getSupportActionBar().setTitle("About " + country[pos].toString());




                }else{pos=country.length;}

            }

        });


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_country_info, menu);
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
