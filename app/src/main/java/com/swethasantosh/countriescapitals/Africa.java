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


public class Africa extends Navigation_main
{
    AsiaListAdapter adapter;
    String[] capitals;
    String[] countries;
    int[] flagimages = {R.drawable.algeria, R.drawable.angola, R.drawable.benin,
            R.drawable.botswana, R.drawable.burkinafaso, R.drawable.burundi, R.drawable.caboverde,
            R.drawable.cameroon, R.drawable.centralafricanrepublic,
            R.drawable.chad, R.drawable.comoros, R.drawable.congo, R.drawable.congodemocraticrepublicof,
            R.drawable.cotedivoire, R.drawable.djibouti,
            R.drawable.egypt, R.drawable.equatorialguinea, R.drawable.eritrea, R.drawable.ethiopia, R.drawable.gabon,
            R.drawable.gambia,
            R.drawable.ghana, R.drawable.guinea, R.drawable.guineabissau, R.drawable.kenya, R.drawable.lesotho,
            R.drawable.liberia,
            R.drawable.libya, R.drawable.madagascar, R.drawable.malawi, R.drawable.mali, R.drawable.mauritania,
            R.drawable.mauritius,
            R.drawable.morocco, R.drawable.mozambique, R.drawable.namibia, R.drawable.niger, R.drawable.nigeria,
            R.drawable.rwanda,
            R.drawable.saotomeandprincipe, R.drawable.senegal, R.drawable.seychelles, R.drawable.sierraleone,
            R.drawable.somalia, R.drawable.southafrica,
            R.drawable.southsudan, R.drawable.sudan, R.drawable.swaziland, R.drawable.tanzania, R.drawable.togo,
            R.drawable.tunisia,
            R.drawable.uganda, R.drawable.zambia, R.drawable.zimbabwe};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_asia_adapter);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);



       /* final ListView list = (ListView)findViewById(R.id.Africalist);
        list.setAdapter(new AfricaListAdapter(this));
        final EditText search_edit = (EditText)findViewById(R.id.search);
/*
        search_edit.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                String searchstring = search_edit.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(searchstring);
                Toast.makeText(getApplicationContext(),"Text changed",Toast.LENGTH_LONG).show();
                //int txtlength = searchstring.length();
                // int listlength = list.getAdapter().getCount();

            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });  */


       /* list.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id)
            {

                Intent intent2 = new Intent(getApplicationContext(),CountryInfo.class);
                //String A1 = (list.getItemAtPosition(position).toString());

               final String Countryname = ((TextView)view.findViewById(R.id.rowtext)).getText().toString();
                final String Capitalname = ((TextView)view.findViewById(R.id.rowtext2)).getText().toString();
                ImageView image = (ImageView)view.findViewById(R.id.rowimage);
                Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();

                Toast.makeText(getApplicationContext(),Countryname+Capitalname,Toast.LENGTH_LONG).show();
                intent2.putExtra("Capital",Capitalname);
                intent2.putExtra("Country",Countryname);
                intent2.putExtra("Image",bitmap);
                 startActivity(intent2);
            }
        });
    }*/
        countries =this.getResources().getStringArray(R.array.AfricaCountries);
        capitals = this.getResources().getStringArray(R.array.AfricaCapitals);

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
               // Intent intent2 = new Intent(getApplicationContext(),CountryInfo.class);
                Intent intent2 = new Intent(getApplicationContext(),Africadetails.class);
                intent2.putExtra("Position",position);

                intent2.putExtra("Country",countries);
                intent2.putExtra("Capital",capitals);
                intent2.putExtra("Images",flagimages);


                //intent2.putExtra("name","Africa");

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
        });   */

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
