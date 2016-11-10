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


public class Imagequiz extends Navigation_main
{
    ImageView image;
    RadioGroup rgroup;
    RadioButton r1,r2,r3;
    Button nextbutton;
    int[] questions = {R.drawable.finland,R.drawable.china,R.drawable.india};
    String[] ans = {"Finland","China","India"};
    String[] opt ={"Finland","China","India",
            "Finland","China","India",
            "Finland","China","India"};
    int index =0;
    public static int marks,correct,wrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_imagequiz);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_imagequiz, contentFrameLayout);


        image = (ImageView)findViewById(R.id.quizimage);
        nextbutton = (Button)findViewById(R.id.nextimage);
        rgroup = (RadioGroup)findViewById(R.id.radiogroup);
        r1 = (RadioButton)findViewById(R.id.ans1);
        r2 = (RadioButton)findViewById(R.id.ans2);
        r3 = (RadioButton)findViewById(R.id.ans3);
        //image.setText(questions[index]);
        image.setImageResource(questions[index]);
        r1.setText(opt[0]);
        r2.setText(opt[1]);
        r3.setText(opt[2]);
        nextbutton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RadioButton uanswer = (RadioButton)findViewById(rgroup.getCheckedRadioButtonId());
                String anstext = uanswer.getText().toString();
                if(anstext.equalsIgnoreCase(ans[index]))
                {
                    correct++;
                }else
                {
                    wrong++;
                }
                index++;
                rgroup.clearCheck();

                if(index<questions.length)
                {
                    image.setImageResource(questions[index]);
                    r1.setText(opt[index*3]);
                    r2.setText(opt[(index*3)+1]);
                    r3.setText(opt[(index*3)+2]);
                }
                else
                {
                    marks = correct;

                    Intent intent = new Intent(getApplicationContext(),ResultActivity.class);
                    intent.putExtra("activity","Imagequiz");
                    startActivity(intent);

                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_imagequiz, menu);
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
