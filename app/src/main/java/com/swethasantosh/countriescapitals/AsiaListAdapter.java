package com.swethasantosh.countriescapitals;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class AsiaListAdapter  extends BaseAdapter implements Filterable
{
    TextToSpeech t1;


   // ArrayList<AsiaSingleRow> asiarow;


   List<AsiaSingleRow> asiarow;


    //List<AsiaSingleRow> originalist;

    AsiaSingleRow asiaobj;
    Context context;
    CustomFilter filter;
    ArrayList<AsiaSingleRow> filterlist ;


   public AsiaListAdapter(Context c,ArrayList<AsiaSingleRow> asiarow)
   {
        this.context = c;
        this.asiarow = asiarow;
       //this.originalist = asiarow;
        this.filterlist = asiarow;

   }

    @Override
    public int getCount()
    {

        return asiarow.size();
       // return originalist.size();

        //return filterlist.size();

    }
    @Override
    public Object getItem(int position)
    {
        return asiarow.get(position);
       // return filterlist.get(position);
        // return originalist.get(position);

    }

    @Override
    public long getItemId(int position) {

        return asiarow.indexOf(getItem(position));
        //return filterlist.indexOf(getItem(position));
        // return originalist.indexOf(getItem(position));


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView ==null)
        {
            convertView = inflater.inflate(R.layout.listrow_structure,null);
        }

        final TextView countries = (TextView)convertView.findViewById(R.id.rowtext);
        final TextView capitals = (TextView)convertView.findViewById(R.id.rowtext2);
        ImageView flagimages = (ImageView)convertView.findViewById(R.id.rowimage);

        countries.setText(asiarow.get(position).getCountries());
        capitals.setText(asiarow.get(position).getCapitals());
        flagimages.setImageResource(asiarow.get(position).getFlagimages());



       /* countries.setText(originalist.get(position).getCountries());
        capitals.setText(originalist.get(position).getCapitals());
        flagimages.setImageResource(originalist.get(position).getFlagimages());*/



         /* countries.setText(filterlist.get(position).getCountries());
        capitals.setText(filterlist.get(position).getCapitals());
        flagimages.setImageResource(filterlist.get(position).getFlagimages());*/


        Button audiobtn = (Button)convertView.findViewById(R.id.audio);

        t1=new TextToSpeech(this.context, new TextToSpeech.OnInitListener()
        {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });


        audiobtn.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v)
            {
                String toSpeak = countries.getText().toString();
                final String toSpeak2 = capitals.getText().toString();
                String[] newtext = {toSpeak+ " " +toSpeak2};

               // t1.speak(toSpeak +  toSpeak2 , TextToSpeech.QUEUE_FLUSH, null);
                 //t1.speak(toSpeak + "  " + "    "+ toSpeak2  , TextToSpeech.QUEUE_FLUSH, null);
                //t1.playSilentUtterance(3000,TextToSpeech.QUEUE_FLUSH,toSpeak2);
                t1.speak( toSpeak , TextToSpeech.QUEUE_FLUSH, null);

                t1.setPitch((float) 1.5);


                final Handler h = new Handler();

                    Runnable t = new Thread() {
                        @Override
                        public void run() {

                            t1.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID");


                        }
                    };
                    h.postDelayed(t, 1300);
                }

        });

        return convertView;
    }



    @Override
    public Filter getFilter()
    {
        if(filter == null)
        {
            filter = new CustomFilter();
        }
        return filter;
    }


    //Inner class
    class CustomFilter extends Filter
    {


        @Override
        protected FilterResults performFiltering(CharSequence constraint)
        {
            FilterResults results = new FilterResults();

            //final List<AsiaSingleRow> list = asiarow;



            if(constraint !=null && constraint.length()>0)
            {

                constraint = constraint.toString().toUpperCase();

                ArrayList<AsiaSingleRow> filters = new ArrayList<>();

                for (int i=0;i<filterlist.size();i++)
                    {
                        if(filterlist.get(i).getCountries().toUpperCase().contains(constraint))
                     {
                        AsiaSingleRow asiaobj = new AsiaSingleRow(filterlist.get(i).getCountries(),filterlist.get(i).getCapitals(),filterlist.get(i).getFlagimages());
                        filters.add(asiaobj);
                     }
                    //to search by capital
                    else
                    {
                        if(filterlist.get(i).getCapitals().toUpperCase().contains(constraint))

                        {
                            AsiaSingleRow asiaobj = new AsiaSingleRow(filterlist.get(i).getCountries(),filterlist.get(i).getCapitals(),filterlist.get(i).getFlagimages());
                            filters.add(asiaobj);
                        }
                    }
                }

                results.count = filters.size();
                results.values = filters;

            }
            else
            {
                //results.count = filterlist.size();
                //results.values = filterlist;
                results.count = asiarow.size();
                results.values = asiarow;
            }



            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results)
        {
            asiarow = (ArrayList<AsiaSingleRow>)results.values;

            // filterlist = (ArrayList<AsiaSingleRow>)results.values;

            notifyDataSetChanged();
            // AsiaListAdapter.this.notifyDataSetChanged();

        }

    }
}



                /*
                for (int i=0;i<list.size();i++)
                {
                    if(list.get(i).getCountries().toUpperCase().contains(constraint))
                    {
                        AsiaSingleRow asiaobj = new AsiaSingleRow(list.get(i).getCountries(),list.get(i).getCapitals(),list.get(i).getFlagimages());
                        filters.add(asiaobj);
                    }
                    //to search by capital
                    else
                    {
                        if(list.get(i).getCapitals().toUpperCase().contains(constraint))

                        {
                            AsiaSingleRow asiaobj = new AsiaSingleRow(list.get(i).getCountries(),list.get(i).getCapitals(),list.get(i).getFlagimages());
                            filters.add(asiaobj);
                        }
                    }
                }



            else
            {
                results.count = list.size();
                results.values = list;
            }*/










