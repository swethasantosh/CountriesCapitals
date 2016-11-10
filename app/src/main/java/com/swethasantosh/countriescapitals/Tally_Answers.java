package com.swethasantosh.countriescapitals;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Tally_Answers extends ActionBarActivity
{
    AsiaQuiz obj;
    String[] qs;
    String[] an;
    String[] uans;
  /* String[] qs;
    String[] an ;
    String[] uans ;*/
    ListView answerslist;
    String[] quizquestions,quizanswers,useranswers ,flagorname;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tally__answers);


        //flagorname = getIntent().getExtras().getStringArray("flagorname");

        quizquestions = getIntent().getExtras().getStringArray("questions");
        quizanswers = getIntent().getExtras().getStringArray("answers");
        useranswers = getIntent().getExtras().getStringArray("selectedanswers");



        qs= quizquestions;
        an = quizanswers;
       uans =  useranswers  ;


       /* qs= Tally_Answers.this.getResources().getStringArray(R.array.AsiaCountries);
        an = Tally_Answers.this.getResources().getStringArray(R.array.AsiaCountries);
        uans = Tally_Answers.this.getResources().getStringArray(R.array.AsiaCountries);*/




        answerslist = (ListView)findViewById(R.id.listView);


        ListitemAdapter adapter = new ListitemAdapter(this,getAnswers());

        answerslist.setAdapter(adapter);
       // answerslist.setAdapter(new ListitemAdapter(qs,an,uans));
       // answerslist.setAdapter(new ListitemAdapter(this));

        //ArrayAdapter<String> adapter = new ArrayAdapter(this,R.layout.answerslistrow,an);
        //answerslist.setAdapter(adapter);




    }

    private ArrayList<Answers> getAnswers()
    {
        ArrayList<Answers> answerlist = new ArrayList<>();

        Answers ansobj ;

        for (int i=0;i<qs.length;i++)

        {
            //asiaobj = new AsiaSingleRow(countries[i],capitals[i],flagimages[i]);
            ansobj = new Answers(qs[i],an[i],uans[i]);

            answerlist.add(ansobj);
        }
        return answerlist;


    }


    class ListitemAdapter extends BaseAdapter
    {
        Context context;
        ArrayList<Answers> answerlist;
        String[] qs;
        String[] ans;
        String[] uans;


        public ListitemAdapter(Context context,ArrayList<Answers> answerlist)
         {
             this.context =context;
             this.answerlist = answerlist;

         }
       /* public  ListitemAdapter(Context c)
        {
            answerlist = new ArrayList<Answers>();
           /* qs = null;
            ans= null;
            uans = null;*/

           /* Resources res = c.getResources();
            String[] quest = res.getStringArray(R.array.AsiaCapitals);
            String[] answ = res.getStringArray(R.array.AsiaCountries);
            String[] uansw = res.getStringArray(R.array.AsiaCurrency);
            for(int i=0;i<quest.length;i++)
            {
                answerlist.add(new Answers(quest[i],answ[i],uansw[i]));
            }
        }*/
       /* public  ListitemAdapter(String[] text1,String[] text2,String[] text3)
        {
            qs = text1;
            ans= text2;
            uans = text3;
        }*/

        @Override
        public int getCount() {
            // return answerlist.size();
           // return qs.length;
            return  answerlist.size();
        }

        @Override
        public Object getItem(int position) {
            // return answerlist.get(position);
            //return null;
            return answerlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            //return answerlist.indexOf(getItem(position));
            return  position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
           LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             /*if(convertView ==null)
            {
                convertView = inflater.inflate(R.layout.answerslistrow,null);
            }*/
           // LayoutInflater inflater = getLayoutInflater();
            View row;
            row = inflater.inflate(R.layout.answerslistrow, parent, false);


            TextView question;
            TextView correctanswer;
            TextView useranswer;
            ImageView image;
          /*  if(flagorname.equals("FlagQuiz"))
            {
                question = (TextView)row.findViewById(R.id.textView4);
                image = (ImageView)row.findViewById(R.id.flagimage2);
                question.setVisibility(View.GONE);
                image.setVisibility(View.VISIBLE);
                correctanswer = (TextView)row.findViewById(R.id.textView5);
                useranswer = (TextView)row.findViewById(R.id.textView7);

            }else {*/


                question = (TextView) row.findViewById(R.id.textView4);
                 correctanswer = (TextView) row.findViewById(R.id.textView5);
                 useranswer = (TextView) row.findViewById(R.id.textView7);
           // }




           /* text.setVisibility(View.GONE);
            flag.setVisibility(View.VISIBLE);*/



            int pos = position+1;

            question.setText(+pos+ " . "+answerlist.get(position).getQuestions());
            correctanswer.setText(answerlist.get(position).getAnswers());
            useranswer.setText(answerlist.get(position).getUseranswers());
           /* question.setText(qs[position]);
            correctanswer.setText(ans[position]);
            useranswer.setText(uans[position]);*/
            //return convertView;

           /* Answers temp = answerlist.get(position);
            question.setText(temp.questions);
            correctanswer.setText(temp.answers);
            useranswer.setText(temp.useranswers);*/
            return  row;
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tally__answers, menu);
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
