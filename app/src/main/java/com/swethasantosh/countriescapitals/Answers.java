package com.swethasantosh.countriescapitals;

/**
 * Created by Swetha on 10/20/2016.
 */
public class Answers
{

    String questions;
    String answers;
    String useranswers;

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getUseranswers() {
        return useranswers;
    }

    public void setUseranswers(String useranswers) {
        this.useranswers = useranswers;
    }


    Answers(String questions,String answers,String useranswers)
    {
        this.questions = questions;
        this.answers = answers;
        this.useranswers = useranswers;
    }

}
