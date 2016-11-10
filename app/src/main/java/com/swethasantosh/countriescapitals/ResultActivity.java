package com.swethasantosh.countriescapitals;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


public class ResultActivity extends Navigation_main {
    TextView scoretext,scorepercent;
    Button restartquiz ,next_level,restartanswers;
    String activityname;

    String[] quizquestions,quizanswers,useranswers;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_result);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.framelayout); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_result, contentFrameLayout);


       // scoretext = (TextView)findViewById(R.id.scoretext);
        restartquiz =(Button)findViewById(R.id.restartquiz);
        scorepercent = (TextView)findViewById(R.id.score);

        //next_level = (Button)findViewById(R.id.NextLevel);

        restartanswers =(Button)findViewById(R.id.restartanswers);



        ProgressBar progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(10);
        progressBar.setVisibility(View.VISIBLE);

        //progressBar.getProgressDrawable().setColorFilter(Color.BLUE, PorterDuff.Mode.MULTIPLY);



        /*ObjectAnimator animation = ObjectAnimator.ofInt (progressBar, "progress", 0, 500); // see this max value coming back here, we animale towards that value
        animation.setDuration (5000); //in milliseconds
        animation.setInterpolator (new DecelerateInterpolator());
        animation.start ();*/





        StringBuffer sb = new StringBuffer();
        activityname = getIntent().getExtras().getString("activity").toString();




        quizquestions = getIntent().getExtras().getStringArray("questions");
        quizanswers = getIntent().getExtras().getStringArray("answers");
        useranswers = getIntent().getExtras().getStringArray("selectedanswers");




      /*  if (activityname.equalsIgnoreCase("Imagequiz")) {
            sb.append("Correct answers:"+Imagequiz.correct);
            sb.append("Wrong answers:" + Imagequiz.wrong);
            sb.append("final score:" +Imagequiz.marks);
            scoretext.setText(sb);

            Imagequiz.correct = 0;
            Imagequiz.wrong=0;

        } else {*/

            sb.append("Correct answers:" + AsiaQuiz.correct);
            sb.append("Wrong answers:" + AsiaQuiz.wrong);
            sb.append("final score:" + AsiaQuiz.marks);

            /*sb.append("Correct answers:" + QuizActivity.correct);
            sb.append("Wrong answers:" + QuizActivity.wrong);
            sb.append("final score:" + QuizActivity.marks);*/
            //scoretext.setText(sb);
            int i = AsiaQuiz.correct;
        i = (int) ((i / 10.0) * 100);


        scorepercent.setText("You  scored "+ i + " % " + "("+AsiaQuiz.correct + " /10)");



            progressBar.setProgress(AsiaQuiz.correct);
            progressBar.setSecondaryProgress(AsiaQuiz.wrong + AsiaQuiz.correct);

            AsiaQuiz.correct = 0;
            AsiaQuiz.wrong=0;



        restartquiz.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //if(activityname.equalsIgnoreCase("QuizActivity"))


               // if(activityname.equalsIgnoreCase("AsiaQuiz"))



                //if(activityname.equalsIgnoreCase("AfricaQuiz"))
                //{
                    Intent intent = new Intent(getApplicationContext(), AsiaQuiz.class);
                    //intent.putExtra("activity_asia",activityname);
                    intent.putExtra("activity_asia",AsiaQuiz.nextlevelbtn);

                    intent.putExtra("classnamederived",AsiaQuiz.classname);
                    startActivity(intent);
                //}

            }
        });
      /*  next_level.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent nextintent = new Intent(getApplicationContext(),AsiaQuiz.class);
                startActivity(nextintent);

            }
        });*/

        if(AsiaQuiz.classname.equals("FlagQuiz"))
        {
            restartanswers.setVisibility(View.INVISIBLE);
        }
        else {
            restartanswers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent nextintent2 = new Intent(getApplicationContext(), Tally_Answers.class);

                    //nextintent2.putExtra("flagorname",activityname);

                    nextintent2.putExtra("questions", quizquestions);
                    nextintent2.putExtra("answers", quizanswers);
                    nextintent2.putExtra("selectedanswers", useranswers);

                    startActivity(nextintent2);


                }
            });
        }


      /*  next_level.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               Intent intentnext = new Intent(getApplicationContext(), ContinentwiseQuiz.class);

                //Intent intent1 = new Intent(getApplicationContext(), Tally_Answers.class);

               // intent1.putExtra("nextlevel_btn","ResultActivity_asia");
                startActivity(intentnext);

            }
        });*/
    }

    @Override
    public void onBackPressed()
    {

       // Intent intent2 = new Intent(getApplicationContext(), ContinentwiseQuiz.class);
        //startActivity(intent2);
        super.onBackPressed();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
        if (id == R.id.action_share)
        {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
            sendIntent.setType("text/plain");
           // startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.action_share)));
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
