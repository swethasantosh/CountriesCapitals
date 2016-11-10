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
public class EuropeMainActivity extends Navigation_main
{
    AsiaListAdapter adapter;
    String[] capitals;
    String[] countries;
    int[] flagimages = {R.drawable.albania,
            R.drawable.andorra,
            R.drawable.armenia,
            R.drawable.austria,
            R.drawable.azerbaijan,
            R.drawable.belarus,
            R.drawable.belgium,
            R.drawable.bosniahercegovina,
            R.drawable.bulgaria,
            R.drawable.croatia,
            R.drawable.cyprus,
            R.drawable.czechrepublic,
            R.drawable.denmark,
            R.drawable.estonia,
            R.drawable.finland,
            R.drawable.france,
            R.drawable.georgia,
            R.drawable.germany,
            R.drawable.greece,
            R.drawable.hungary,
            R.drawable.iceland,
            R.drawable.ireland,
            R.drawable.italy,
            R.drawable.kazakhstan,
            R.drawable.kosovo,
            R.drawable.latvia,
            R.drawable.liechtenstein,
            R.drawable.lithuania,
            R.drawable.luxembourg,
            R.drawable.macedonia,
            R.drawable.malta,
            R.drawable.moldova,
            R.drawable.monaco,
            R.drawable.montenegro,
            R.drawable.netherlands,
            R.drawable.norway,
            R.drawable.poland,
            R.drawable.portugal,
            R.drawable.romania,
            R.drawable.russia,
            R.drawable.sanmarino,
            R.drawable.serbia,
            R.drawable.slovakia,
            R.drawable.slovenia,
            R.drawable.spain,
            R.drawable.sweden,
            R.drawable.switzerland,
            R.drawable.turkey,
            R.drawable.ukraine,
            R.drawable.unitedkingdom,
            R.drawable.vaticancity};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //setContentView(R.layout.activity_europe_list_adapter);
       // setContentView(R.layout.activity_asia_adapter);


        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);


        countries =this.getResources().getStringArray(R.array.EuropeCountries);
        capitals = this.getResources().getStringArray(R.array.EuropeCapitals);

       /* ListView list = (ListView)findViewById(R.id.Europelist);
        list.setAdapter(new EuropeListAdapter(this));
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
                Intent intent2 = new Intent(getApplicationContext(),Europedetails.class);
                intent2.putExtra("Position",position);

                intent2.putExtra("Country",countries);
                intent2.putExtra("Capital",capitals);
                intent2.putExtra("Images",flagimages);


                //intent2.putExtra("name","Europe");

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
        });         */

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

