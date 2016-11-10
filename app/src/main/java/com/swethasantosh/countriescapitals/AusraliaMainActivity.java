package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by Swetha on 2/29/2016.
 */
public class AusraliaMainActivity extends Navigation_main
{
    AsiaListAdapter adapter;
    String[] capitals;
    String[] countries;
    int[] flagimages = {R.drawable.australia,
            R.drawable.fiji,
            R.drawable.kiribati,
            R.drawable.marshallislands,
            R.drawable.micronesia,
            R.drawable.nauru,
            R.drawable.newzealand,
            R.drawable.palau,
            R.drawable.papuanewguinea,
            R.drawable.samoa,
            R.drawable.solomonislands,
            R.drawable.tonga,
            R.drawable.tuvalu,
            R.drawable.vanuatu};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_asia_adapter);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);

        /*
        ListView list = (ListView)findViewById(R.id.Ausislist);
        list.setAdapter(new AustaliaListAdapter(this));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent2 = new Intent(getApplicationContext(),CountryInfo.class);
                startActivity(intent2);

            }
        });
    }*/
        countries =this.getResources().getStringArray(R.array.AustraliaCountires);
        capitals = this.getResources().getStringArray(R.array.AustraliaCapitals);

        //final EditText search = (EditText)findViewById(R.id.search2);
        final ListView list = (ListView)findViewById(R.id.Asialist);

        adapter = new AsiaListAdapter(this,getAsiarow());


        list.setAdapter(adapter);
        /*
        search.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                adapter.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
*/
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent2 = new Intent(getApplicationContext(),Australiadetails.class);
                intent2.putExtra("Position",position);

                intent2.putExtra("Country",countries);
                intent2.putExtra("Capital",capitals);
                intent2.putExtra("Images",flagimages);

                //intent2.putExtra("name","Australia");


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
            asiaobj = new AsiaSingleRow(countries[i],capitals[i],flagimages[i]);

            asiarow.add(asiaobj);
        }
        return asiarow;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asia_adapter, menu);


/*
        MenuItem searchItem = menu.findItem(R.id.search);

        //SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        SearchView searchView = (SearchView)searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                adapter.getFilter().filter(newText);

                return false;
            }
        });     */

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

