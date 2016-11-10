package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class AsiaQuiz extends Navigation_main
{

    TextView text;
    ImageView flag;
    RadioGroup rgroup;
    RadioButton r1,r2,r3,r4;
    Button nextbutton;

    public static String nextlevelbtn;

    public static String classname;

    Random random = new Random();

    public String[] q1 = {"Algeria Capital?","Angola Capital?","Benin Capital?",
                    "Botswana Capital?","BurkinaFaso Capital?","Burundi Capital?",
                    "Cabo Verde Capital?","Cameroon Capital?","Central African Republic Capital?","Chad Capital?"};

   public String[] ans = {"Algeris","Luanda","Porto-novo","Gaborone","Ouagadougou","Bujumbura","Praia","Yaounde","Bangui","NDjamena"};
   public  String[] opt ={"Algeris","Luanda","Porto-novo","Gaborone","Ouagadougou","Bujumbura","Praia","Yaounde","Bangui","NDjamena",
            "Algeris","Luanda","Porto-novo"};



    String[] q2 = {"Afghanistan Capital?","Armenia Capital?","Azerbaijan Capital?",
            "Bahrain Capital?","Bangladesh Capital?","Bhutan Capital?",
            "Brunei Capital?","Cambodia Capital?","China Capital?","Cyprus Capital?"};
    String[] ans2 = {"Kabul","Yerevan","Baku","Manama","Dhaka","Thimphu","BandarSeri Begawan","Phnom penh","Beijing","Nicosia"};
    String[] opt2 ={"Kabul","Yerevan","Baku","Manama","Dhaka","Thimphu","BandarSeri Begawan","Phnom penh","Beijing","Nicosia",
            "Kabul","Yerevan","Baku"};

    String[] q3 = {"Albania Capital?","Andorra Capital?","Armenia Capital?",
            "Austria Capital?","Azerbaijan Capital?","Belarus Capital?",
            "Belgium Capital?","Bosnia and Herzegovina Capital?","Bulgaria Capital?","Croatia Capital?"};
    String[] ans3 = {"Tirana","Andorrala vella","Yerevan","Vienna","Baku","Minsk","Brussels","Sarajevo","Sofia","Zagreb"};
    String[] opt3 ={"Tirana","Andorrala vella","Yerevan","Vienna","Baku","Minsk","Brussels","Sarajevo","Sofia","Zagreb",
            "Tirana","Andorrala vella","Yerevan"};

    String[] q4 = {"Australia Capital?","Fiji Capital?","Kiribati Capital?",
            "Marshall islands Capital?","Micronesia Capital?","Nauru Capital?",
            "Newzeland Capital?","Palau Capital?","Papua New Guinea Capital?","Samoa Capital?"};
    String[] ans4 = {"Canberra","Suva","South Tarawa","Majuro","Palikir","Yaren District","Wellington","Nagerulmud","PortMoresby","Apia"};
    String[] opt4 ={"Canberra","Suva","South Tarawa","Majuro","Palikir","Yaren District","Wellington","Nagerulmud","PortMoresby","Apia",
            "Canberra","Suva","South Tarawa"};

    String[] q5 = {"Antigua and Barbuda Capital?","Bahamas Capital?","Barbados Capital?",
            "Belize Capital?","Canada Capital?","Costarica Capital?",
            "Cuba Capital?","Dominica Capital?","Dominican Republic Capital?","El Salvador Capital?"};
    String[] ans5 = {"Saint Johns","Nassau","BridgeTown","Belmopan","Ottowa","SanJose","Havana","Roseau","SantoDomingo","San Salvador"};
    String[] opt5 ={"Saint Johns","Nassau","BridgeTown","Belmopan","Ottowa","SanJose","Havana","Roseau","SantoDomingo","San Salvador",
            "Saint Johns","Nassau","BridgeTown"};

    String[] q6 = {"Argentina Capital?","Bolivia Capital?","Brazil Capital?",
            "Chile Capital?","Colombia Capital?","Ecuador Capital?",
            "Guyana Capital?","Paraguy Capital?","Peru Capital?","Suriname Capital?"};
    String[] ans6 = {"Buenos Aries","Lapez","Brasilia","Santiago","Bogota","Quito","GeorgeTown","Asuncion","Lima","Paramaribo"};
    String[] opt6 ={"Buenos Aries","Lapez","Brasilia","Santiago","Bogota","Quito","GeorgeTown","Asuncion","Lima","Paramaribo",
            "Buenos Aries","Lapez","Brasilia"};




    //flagquiz



    Integer[] q = new Integer[] {R.drawable.algeria,R.drawable.angola,R.drawable.benin,
            R.drawable.botswana,R.drawable.burkinafaso,R.drawable.burundi,
            R.drawable.caboverde,R.drawable.cameroon,R.drawable.centralafricanrepublic,R.drawable.chad};

    Integer[] r = new Integer[]{R.drawable.afghanistan,R.drawable.armenia,R.drawable.azerbaijan,
                R.drawable.bahrain,R.drawable.bangladesh,R.drawable.bhutan,R.drawable.brunei,R.drawable.cambodia,
                R.drawable.china,R.drawable.cyprus};

    Integer[] s =new Integer[] { R.drawable.albania, R.drawable.andorra, R.drawable.armenia,
            R.drawable.austria, R.drawable.azerbaijan, R.drawable.belarus,
            R.drawable.belgium, R.drawable.bosniahercegovina, R.drawable.bulgaria, R.drawable.croatia};

    Integer[] t =new Integer[] { R.drawable.australia, R.drawable.fiji, R.drawable.kiribati,
            R.drawable.marshallislands, R.drawable.micronesia, R.drawable.nauru,
            R.drawable.newzealand, R.drawable.palau, R.drawable.papuanewguinea, R.drawable.samoa};


   Integer[] u = new Integer[] { R.drawable.antigua, R.drawable.bahamas, R.drawable.barbados,
           R.drawable.belize, R.drawable.canada, R.drawable.costarica,
           R.drawable.cuba, R.drawable.dominica, R.drawable.dominicanrepublic, R.drawable.elsalvador};

    Integer[] v = new Integer[] { R.drawable.argentina, R.drawable.bolivia, R.drawable.brazil,
            R.drawable.chile, R.drawable.colombia, R.drawable.ecuador,
            R.drawable.guyana, R.drawable.paraguay, R.drawable.peru, R.drawable.suriname};

  /*  String[] ans_f = {"Algeris","Luanda","Porto-novo","Gaborone","Ouagadougou","Bujumbura","Praia","Yaounde","Bangui","NDjamena"};
    String[] opt_f ={"Algeris","Luanda","Porto-novo","Gaborone","Ouagadougou","Bujumbura","Praia","Yaounde","Bangui","NDjamena",
            "Algeris","Luanda","Porto-novo"};*/


    TextView numbertext;



    int index =0;
    public static int marks,correct,wrong;



    String[] answers_array = new String[10];


    String anstext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_asia_quiz);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_quiz, contentFrameLayout);

        text = (TextView)findViewById(R.id.quetion);
        flag = (ImageView)findViewById(R.id.flagimage);
        numbertext = (TextView)findViewById(R.id.numbertext);





        nextbutton = (Button)findViewById(R.id.nextquestion);
        rgroup = (RadioGroup)findViewById(R.id.radiogroup);
        r1 = (RadioButton)findViewById(R.id.ans1);
        r2 = (RadioButton)findViewById(R.id.ans2);
        r3 = (RadioButton)findViewById(R.id.ans3);
        r4 = (RadioButton)findViewById(R.id.ans4);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




       nextlevelbtn = getIntent().getExtras().getString("activity_asia").toString();

        classname = getIntent().getExtras().getString("classnamederived").toString();




        if(classname.equals("FlagQuiz"))
        {

            text.setVisibility(View.GONE);
            flag.setVisibility(View.VISIBLE);
            //flag.setImageResource(R.drawable.india);

            numbertext.setText((index+1) +" Out of 10 ");


            switch (nextlevelbtn)
            {
                case "AfricaQuiz":
                    q = q;
                    ans = ans;
                    opt = opt;
                    getSupportActionBar().setTitle("Africa countries flag Quiz");
                    break;
                case "AsiaQuiz":
                    q = r;
                    ans = ans2;
                    opt = opt2;
                    getSupportActionBar().setTitle("Asia countries flag Quiz");
                    break;
                case "EuropeQuiz":
                    q= s;
                    ans = ans3;
                    opt = opt3;
                    getSupportActionBar().setTitle("Europe Quiz");
                    break;
                case "AusQuiz":
                    q = t;
                    ans = ans4;
                    opt = opt4;
                    getSupportActionBar().setTitle("Australia Quiz");
                    break;
                case "NAQuiz":
                    q = u;
                    ans = ans5;
                    opt = opt5;
                    getSupportActionBar().setTitle("North America Quiz");
                    break;
                case "SAQuiz":
                    q = v;
                    ans = ans6;
                    opt = opt6;
                    getSupportActionBar().setTitle("South America Quiz");
                    break;


            }


           // text.setText(q1[index]);
            flag.setImageResource(q[index]);
            r1.setText(opt[0]);
            r2.setText(opt[1]);
            r3.setText(opt[2]);
            r4.setText(opt[3]);

        }



        if(classname.equalsIgnoreCase("NameQuiz"))
        {
            numbertext.setText((index+1) +" Out of 10 ");


            switch (nextlevelbtn) {
                case "AfricaQuiz":
                    q1 = q1;
                    ans = ans;
                    opt = opt;
                    getSupportActionBar().setTitle("Africa Quiz");
                    break;
                case "AsiaQuiz":
                    q1 = q2;
                    ans = ans2;
                    opt = opt2;
                    getSupportActionBar().setTitle("ASia Quiz");
                    break;
                case "EuropeQuiz":
                    q1 = q3;
                    ans = ans3;
                    opt = opt3;
                    getSupportActionBar().setTitle("Europe Quiz");
                    break;
                case "AusQuiz":
                    q1 = q4;
                    ans = ans4;
                    opt = opt4;
                    getSupportActionBar().setTitle("Australia Quiz");
                    break;
                case "NAQuiz":
                    q1 = q5;
                    ans = ans5;
                    opt = opt5;
                    getSupportActionBar().setTitle("North America Quiz");
                    break;
                case "SAQuiz":
                    q1 = q6;
                    ans = ans6;
                    opt = opt6;
                    getSupportActionBar().setTitle("South America Quiz");
                    break;


            }
            text.setText(q1[index]);
            r1.setText(opt[0]);
            r2.setText(opt[1]);
            r3.setText(opt[2]);
            r4.setText(opt[3]);


        }






       /* text.setText(q1[index]);
        r1.setText(opt[0]);
        r2.setText(opt[1]);
        r3.setText(opt[2]);
        r4.setText(opt[3]);  */



        nextbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                RadioButton uanswer = (RadioButton)findViewById(rgroup.getCheckedRadioButtonId());
                if(rgroup.getCheckedRadioButtonId() == -1)
                {                    Toast.makeText(getApplicationContext(), "Choose an answer", Toast.LENGTH_LONG).show();
                }
                else
                {
                    //String anstext = uanswer.getText().toString();
                    anstext = uanswer.getText().toString();



                    //Toast.makeText(getApplicationContext(),anstext+"added",Toast.LENGTH_LONG).show();





                    if (anstext.equalsIgnoreCase(ans[index])) {
                        correct++;
                    } else {
                        wrong++;
                    }


                    answers_array[index] = anstext;
                    //Toast.makeText(getApplicationContext(),anstext+"added",Toast.LENGTH_LONG).show();


                    index++;
                    rgroup.clearCheck();


                //numbertext.setText((index+1)+ " Out of 10");
                    if (index < q1.length)
                    {
                        numbertext.setText((index+1)+ " Out of 10");

                        text.setText(q1[index]);
                        flag.setImageResource(q[index]);


                        r1.setText(opt[(index)+1 ]);
                        r2.setText(opt[(index)]);
                        r4.setText(opt[(index) + 3]);
                        r3.setText(opt[(index) + 2]);
                        

                       /* r1.setText(opt[index * 3]);
                        r2.setText(opt[(index * 3) + 1]);
                        r3.setText(opt[(index * 3) + 2]);*/

                    } else {
                        marks = correct;

                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        intent.putExtra("activity", "AsiaQuiz");
                        //intent.putExtra("activity",nextlevelbtn);

                        intent.putExtra("questions",q1);
                        intent.putExtra("answers",ans);
                        intent.putExtra("selectedanswers",answers_array);

                        startActivity(intent);



                       /* if(classname.equals("FlagQuiz"))
                        {
                            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                            intent.putExtra("activity", "FlagQuiz");
                            //intent.putExtra("activity",nextlevelbtn);

                            intent.putExtra("questions",q);
                            intent.putExtra("answers",ans);
                            intent.putExtra("selectedanswers",answers_array);

                            startActivity(intent);

                        }

                        if(classname.equalsIgnoreCase("NameQuiz"))
                        {
                            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                            intent.putExtra("activity", "NameQuiz");
                            //intent.putExtra("activity",nextlevelbtn);

                            intent.putExtra("questions",q1);
                            intent.putExtra("answers",ans);
                            intent.putExtra("selectedanswers",answers_array);

                            startActivity(intent);

                        }*/

                    }
                }

            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asia_quiz, menu);
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
