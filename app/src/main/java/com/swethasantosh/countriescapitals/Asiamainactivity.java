package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.widget.SearchView;
import android.view.MenuInflater;
import android.widget.Filter;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Swetha on 2/29/2016.
 */

public class Asiamainactivity extends Navigation_main

{
    AsiaListAdapter adapter;
    String[] countries;
    String[] capitals;
    ArrayList<String> aList;

    int[] flagimages = {R.drawable.afghanistan,
            R.drawable.armenia,
            R.drawable.azerbaijan,
            R.drawable.bahrain,
            R.drawable.bangladesh,
            R.drawable.bhutan,
            R.drawable.brunei,
            R.drawable.cambodia,
            R.drawable.china,
            R.drawable.cyprus,
            R.drawable.georgia,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.iran,
            R.drawable.iraq,
            R.drawable.israel,
            R.drawable.japan,
            R.drawable.jordan,
            R.drawable.kazakhstan,
            R.drawable.kuwait,
            R.drawable.kyrgyzstan,
            R.drawable.laos,
            R.drawable.lebanon,
            R.drawable.malaysia,
            R.drawable.maldives,
            R.drawable.mongolia,
            R.drawable.myanmar,
            R.drawable.nepal,
            R.drawable.koreanorth,
            R.drawable.oman,
            R.drawable.pakistan,
            R.drawable.palestine,
            R.drawable.philippines,
            R.drawable.qatar,
            R.drawable.russia,
            R.drawable.saudiarabia,
            R.drawable.singapore,
            R.drawable.koreasouth,
            R.drawable.srilanka,
            R.drawable.syria,
            R.drawable.taiwan,
            R.drawable.tajikistan,
            R.drawable.thailand,
            R.drawable.timorleste,
            R.drawable.turkey,
            R.drawable.turkmenistan,
            R.drawable.unitedarabemirates,
            R.drawable.uzbekistan,
            R.drawable.vietnam,
            R.drawable.yemen};

   ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_asia_adapter);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);


       countries =this.getResources().getStringArray(R.array.AsiaCountries);
       capitals = this.getResources().getStringArray(R.array.AsiaCapitals);
        aList=new ArrayList<>(Arrays.asList(countries));
        Collections.sort(aList);


        list = (ListView)findViewById(R.id.Asialist);

        adapter = new AsiaListAdapter(this,getAsiarow());

        //dapter2 = new FilterListAdapter(this, (ArrayList<AsiaSingleRow>)adapter.filterlist;);




        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent2 = new Intent(getApplicationContext(),Asiadetails.class);

                 intent2.putExtra("Position", position);
                intent2.putExtra("Country",countries);
                intent2.putExtra("Capital",capitals);
                intent2.putExtra("Images",flagimages);
                startActivity(intent2);

            }
        });
    }


    private ArrayList<AsiaSingleRow> getAsiarow()
    {
        ArrayList<AsiaSingleRow> asiarow = new ArrayList<AsiaSingleRow>();

        AsiaSingleRow asiaobj ;
        for (int i=0;i<countries.length;i++)

        {
            asiaobj = new AsiaSingleRow(aList.get(i),capitals[i],flagimages[i]);

            asiarow.add(asiaobj);
        }
        return asiarow;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();

        // Inflate the menu; this adds items to the action bar if it is present.
       inflater.inflate(R.menu.menu_asia_adapter, menu);



        MenuItem searchItem = menu.findItem(R.id.search);

        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        final SearchView searchView = (SearchView)searchItem.getActionView();






        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapter.getFilter().filter(newText);



                //adapter.getFilter().filter(newText);


                // return false;
              return true;
            }






        });


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

