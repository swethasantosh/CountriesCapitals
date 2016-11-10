package com.swethasantosh.countriescapitals;

import android.view.View;

/**
 * Created by Swetha on 3/3/2016.
 */
public class AsiaSingleRow
{
    int flagimages;
    String countries;
   String capitals;




    public int getFlagimages() {
        return flagimages;
    }

    public void setFlagimages(int flagimages)
    {
        this.flagimages = flagimages;
    }

    public String getCapitals() {
        return capitals;
    }

    public void setCapitals(String capitals) {
        this.capitals = capitals;
    }



    public String getCountries()

    {

        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }


    AsiaSingleRow(String countries,String capitals,int flagimages)
    {
        this.capitals = capitals;
        this.countries = countries;
        this.flagimages = flagimages;


    }


}
