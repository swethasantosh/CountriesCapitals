package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
//import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Navigation_main extends ActionBarActivity implements AdapterView.OnItemClickListener
{
    private DrawerLayout drawerlayout;
    private ListView listview;
    private String[] navlist;
    private ActionBarDrawerToggle drawerlistener;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
   // protected void onCreateDrawer(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.navigation_main);
     // setContentView(R.layout.activity_main_activity2);
        navlist = getResources().getStringArray(R.array.list_navdraw);
        listview = (ListView) findViewById(R.id.drawerlist);


      /* LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       FrameLayout container  = (FrameLayout)findViewById(R.id.framelayout);
       inflater.inflate(R.layout.activity_main_activity2,container);*/


        listview.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,navlist));
        listview.setOnItemClickListener(this);

        drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);


      // View header = getLayoutInflater().inflate(R.layout.activity_main_activity2, null);



       drawerlistener = new ActionBarDrawerToggle(this, drawerlayout,
              R.drawable.ic_drawer,R.string.drawer_open,R.string.drawer_close)
        {
            @Override
            public void onDrawerOpened(View drawerView)
            {
                //Toast.makeText(Navigation_main.this,"Drawer opened",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDrawerClosed(View drawerView)
            {
                //Toast.makeText(Navigation_main.this,"Drawer closed",Toast.LENGTH_LONG).show();
            }
        };
        drawerlayout.setDrawerListener(drawerlistener);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_drawer);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerlistener.syncState();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        //Toast.makeText(this,navlist[position]+"was selected",Toast.LENGTH_LONG).show();
        String text = navlist[position].toString();
        switch (text)
        {case "Home":
            Intent intent1 = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent1);
            break;
        case "Africa":
                Intent intent2 = new Intent(getApplicationContext(),Africa.class);
                startActivity(intent2);
                break;

        case "Asia":
                Intent intent3 = new Intent(getApplicationContext(),Asiamainactivity.class);
                startActivity(intent3);
                break;

        case "Europe":
                Intent intent4 = new Intent(getApplicationContext(),EuropeMainActivity.class);
                startActivity(intent4);
                break;

        case "North America":
                Intent intent5 = new Intent(getApplicationContext(),NorthAmericaMainActivity.class);
                startActivity(intent5);
                break;

        case "South America":
                Intent intent6 = new Intent(getApplicationContext(),SouthAmerica.class);
                startActivity(intent6);
                break;

        case "Australia":
                Intent intent7 = new Intent(getApplicationContext(),AusraliaMainActivity.class);
                startActivity(intent7);
                break;

        case "All Countries":
                Intent intent8 = new Intent(getApplicationContext(),Allcountriesadapter.class);
                startActivity(intent8);
                break;
        case "Flag Quiz":
                Intent intent9 = new Intent(getApplicationContext(),ContinentwiseQuiz.class);
                intent9.putExtra("ClassName","FlagQuiz");
                startActivity(intent9);
                break;
        case "Name Quiz":
                Intent intent10 = new Intent(getApplicationContext(),ContinentwiseQuiz.class);
                intent10.putExtra("ClassName","NameQuiz");
                startActivity(intent10);
                break;
        case "Antarctica":
                Intent intent11 = new Intent(getApplicationContext(),Antarctica.class);
                startActivity(intent11);
                break;


        }
        selectItem(position);

    }

    private void selectItem(int position)
    {
        listview.setItemChecked(position,true);
        setTitle(navlist[position]);

    }
    public void setTitle(String title)
    {
        getSupportActionBar().setTitle(title);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_navigation_main, menu);
        return true;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(drawerlistener.onOptionsItemSelected(item))
        {
            return true;
        }
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
