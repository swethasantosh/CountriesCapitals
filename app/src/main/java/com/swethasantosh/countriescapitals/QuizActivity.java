package com.swethasantosh.countriescapitals;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends Navigation_main
{
    TextView text;
    RadioGroup rgroup;
    RadioButton r1,r2,r3;
    Button nextbutton;


   String[] q1 = {"Finland Capital?","China Capital?","India Capital?"};
    String[] ans = {"Helsinki","Beizing","Delhi"};
    String[] opt ={"Helsinki","Beizing","Delhi",
                    "Helsinki","Beizing","Delhi",
                     "Helsinki","Beizing","Delhi"};

    String[] q2 = {"Afghanistan Capital?","Albania Capital?","Algeria Capital?"};
    String[] ans2 = {"Kabul","Tirana","Algiers"};
    String[] opt2 ={"Kabul","Beizing","Delhi",
            "Tirana","Beizing","Delhi",
            "Helsinki","Algiers","Delhi"};
    int index =0;
    public static int marks,correct,wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_quiz);



        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_asia_adapter, contentFrameLayout);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        text = (TextView)findViewById(R.id.quetion);
        nextbutton = (Button)findViewById(R.id.nextquestion);
        rgroup = (RadioGroup)findViewById(R.id.radiogroup);
        r1 = (RadioButton)findViewById(R.id.ans1);
        r2 = (RadioButton)findViewById(R.id.ans2);
        r3 = (RadioButton)findViewById(R.id.ans3);

        text.setText(q1[index]);
        r1.setText(opt[0]);
        r2.setText(opt[1]);
        r3.setText(opt[2]);

        nextbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {


                RadioButton uanswer = (RadioButton)findViewById(rgroup.getCheckedRadioButtonId());
                if(rgroup.getCheckedRadioButtonId() == -1)
                {                    Toast.makeText(getApplicationContext(),"Choose an answer",Toast.LENGTH_LONG).show();
                }
                else
                {
                    String anstext = uanswer.getText().toString();


                    if (anstext.equalsIgnoreCase(ans[index])) {
                        correct++;
                    } else {
                        wrong++;
                    }
                    index++;
                    rgroup.clearCheck();

                    if (index < q1.length) {
                        text.setText(q1[index]);
                        r1.setText(opt[index * 3]);
                        r2.setText(opt[(index * 3) + 1]);
                        r3.setText(opt[(index * 3) + 2]);
                    } else {
                        marks = correct;

                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        intent.putExtra("activity", "QuizActivity");
                        startActivity(intent);

                    }
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
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
