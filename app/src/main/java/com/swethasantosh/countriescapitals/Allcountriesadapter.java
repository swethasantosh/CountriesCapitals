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
 * Created by Swetha on 3/5/2016.
 */
public class Allcountriesadapter extends Navigation_main
{
    AsiaListAdapter adapter;
    String[] capitals,s1,s2,s3,s4,s5,s6,c1,c2,c3,c4,c5,c6;
    String[] countries;
   // int[] flagimages;
    ArrayList<String> allList;
   // String search;
    int[] flagimages = {R.drawable.algeria, R.drawable.angola, R.drawable.benin,
           R.drawable.botswana, R.drawable.burkinafaso, R.drawable.burundi, R.drawable.caboverde,
           R.drawable.cameroon, R.drawable.centralafricanrepublic,
           R.drawable.chad, R.drawable.comoros,
           R.drawable.congo,
           R.drawable.congodemocraticrepublicof,
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
           R.drawable.uganda, R.drawable.zambia, R.drawable.zimbabwe,R.drawable.afghanistan,
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
           R.drawable.yemen,R.drawable.australia,
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
           R.drawable.vanuatu,R.drawable.albania,
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
           R.drawable.vaticancity,R.drawable.antigua,
           R.drawable.bahamas,
           R.drawable.barbados,
           R.drawable.belize,
           R.drawable.canada,
           R.drawable.costarica,
           R.drawable.cuba,
           R.drawable.dominica,
           R.drawable.dominicanrepublic,
           R.drawable.elsalvador,
           R.drawable.grenada,
           R.drawable.guatemala
           ,R.drawable.haiti,
           R.drawable.honduras,
           R.drawable.jamaica,
           R.drawable.mexico,
           R.drawable.nicaragua,
           R.drawable.panama,
           R.drawable.stkittsnevis,
           R.drawable.stlucia,
           R.drawable.stvincentthegrenadines,
           R.drawable.togo,
           R.drawable.unitedstatesofamerica,R.drawable.argentina,
           R.drawable.bolivia,
           R.drawable.brazil,
           R.drawable.chile,
           R.drawable.colombia,
           R.drawable.ecuador,
           R.drawable.guyana,
           R.drawable.paraguay,
           R.drawable.peru,
           R.drawable.suriname,
           R.drawable.uruguay,
           R.drawable.venezuela};
    /*
    int[] i1 = {R.drawable.algeria, R.drawable.angola, R.drawable.benin,
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
    int[] i2 ={R.drawable.afghanistan,
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
    int[] i3 ={R.drawable.australia,
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
    int[] i4= {R.drawable.albania,
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
    int[] i5 = {R.drawable.antigua,
            R.drawable.bahamas,
            R.drawable.barbados,
            R.drawable.belize,
            R.drawable.canada,
            R.drawable.costarica,
            R.drawable.cuba,
            R.drawable.dominica,
            R.drawable.dominicanrepublic,
            R.drawable.elsalvador,
            R.drawable.grenada,
            R.drawable.guatemala
            ,R.drawable.haiti,
            R.drawable.honduras,
            R.drawable.jamaica,
            R.drawable.mexico,
            R.drawable.nicaragua,
            R.drawable.panama,
            R.drawable.stkittsnevis,
            R.drawable.stlucia,
            R.drawable.stvincentthegrenadines,
            R.drawable.togo,
            R.drawable.unitedstatesofamerica};
    int[] i6= {R.drawable.argentina,
            R.drawable.bolivia,
            R.drawable.brazil,
            R.drawable.chile,
            R.drawable.colombia,
            R.drawable.ecuador,
            R.drawable.guyana,
            R.drawable.paraguay,
            R.drawable.peru,
            R.drawable.suriname,
            R.drawable.uruguay,
            R.drawable.venezuela};

*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_asia_adapter);



        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);

        s1 = this.getResources().getStringArray(R.array.AfricaCountries);
        s2 = this.getResources().getStringArray(R.array.AsiaCountries);
        s3 = this.getResources().getStringArray(R.array.AustraliaCountires);
        s4 = this.getResources().getStringArray(R.array.EuropeCountries);
        s5 = this.getResources().getStringArray(R.array.NorthAmericaCountires);
        s6 = this.getResources().getStringArray(R.array.SAmericaCountries);

        c1 = this.getResources().getStringArray(R.array.AfricaCapitals);
        c2 = this.getResources().getStringArray(R.array.AsiaCapitals);
        c3 = this.getResources().getStringArray(R.array.AustraliaCapitals);
        c4 = this.getResources().getStringArray(R.array.EuropeCapitals);
        c5 = this.getResources().getStringArray(R.array.NorthAmericaCapitals);
        c6 = this.getResources().getStringArray(R.array.SAmericaCapitals);

        countries = this.combine(s1, s2, s3, s4, s5, s6);
        capitals = this.combinecapitals(c1, c2, c3, c4, c5, c6);
       // flagimages = this.combineimages(i1, i2, i3, i4, i5, i6);


/*
        //to sort listitems
        allList = new ArrayList<>(Arrays.asList(countries));
        Collections.sort(allList);*/


        //Toast.makeText(getApplicationContext(), "length" + capitals[200], Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),"s1length"+s1.length,Toast.LENGTH_LONG).show();


        //final EditText search = (EditText)findViewById(R.id.search2);
       // String search1=getIntent().getExtras().getString("searchstring").toString();


        //search.setText(search1);

        final ListView list = (ListView)findViewById(R.id.Asialist);

         adapter = new AsiaListAdapter(this,getAsiarow());


        list.setAdapter(adapter);
/*
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
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
                Intent intent2 = new Intent(getApplicationContext(),Allcountriesinfo.class);

                intent2.putExtra("Position",position);
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
            asiaobj = new AsiaSingleRow(countries[i],capitals[i],flagimages[i]);
           // asiaobj = new AsiaSingleRow(allList.get(i),capitals[i],flagimages[i]);

            asiarow.add(asiaobj);
        }
        return asiarow;
    }




    public String[] combinecapitals(String[] c1, String[] c2, String[] c3, String[] c4, String[] c5, String[] c6)
    {
        int resultlength = c1.length+c2.length+c3.length+c4.length+c5.length+c6.length;
        String[] result = new String[resultlength];
        System.arraycopy(c1,0,result,0,c1.length);

        System.arraycopy(c2,0,result,c1.length,c2.length);
        System.arraycopy(c3,0,result,c1.length+c2.length,c3.length);
        System.arraycopy(c4,0,result,c1.length+c2.length+c3.length,c4.length);
        System.arraycopy(c5,0,result,c1.length+c2.length+c3.length+c4.length,c5.length);
        System.arraycopy(c6,0,result,c1.length+c2.length+c3.length+c4.length+c5.length,c6.length);

        return result;
    }
/*
    public int[] combineimages(int[] i1, int[] i2, int[] i3, int[] i4, int[] i5, int[] i6)
    {
        int arraylength = i1.length+i2.length+i3.length+i4.length+i5.length+i6.length;
        int[] result = new int[arraylength];
        System.arraycopy(i1,0,result,0,i1.length);
        System.arraycopy(i2,0,result,i1.length,i2.length);
        System.arraycopy(i3,0,result,i1.length+i2.length,i3.length);
        System.arraycopy(i4,0,result,i1.length+i2.length+i3.length,i4.length);
        System.arraycopy(i5,0,result,i1.length+i2.length+i3.length+i4.length,i5.length);
        System.arraycopy(i6,0,result,i1.length+i2.length+i3.length+i4.length+i5.length,i6.length);

        return result;
    }
 */
    public String[] combine(String[] s1, String[] s2, String[] s3, String[] s4, String[] s5, String[] s6)
    {
        int length = s1.length+s2.length+s3.length+s4.length+s5.length+s6.length;
        String[] result = new String[length];
        System.arraycopy(s1,0,result,0,s1.length);
        System.arraycopy(s2,0,result,s1.length,s2.length);
        System.arraycopy(s3,0,result,s1.length+s2.length,s3.length);
        System.arraycopy(s4,0,result,s1.length+s2.length+s3.length,s4.length);
        System.arraycopy(s5,0,result,s1.length+s2.length+s3.length+s4.length,s5.length);
        System.arraycopy(s6,0,result,s1.length+s2.length+s3.length+s4.length+s5.length,s6.length);

        return result;
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
        }); */

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


