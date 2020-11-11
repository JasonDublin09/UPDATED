package com.example.trial;

public class Question
{
    // answerResId will store question
    private int answerResId;

    // answerTrue will store correct answer
    // of the question provided
    private String answerCorrect;

    public Question(int answerResId, String answerCorrect)
    {
        // setting the values through
        // arguments passed in constructor
        this.answerResId = answerResId;
        this.answerCorrect= answerCorrect;
    }

    // returning the question passed
    public int getAnswerResId()
    {
        return answerResId;
    }

    // setting the question passed
    public void setAnswerResId(int answerResId)
    {
        this.answerResId = answerResId;
    }

    // returning the correct answer
    // of question
    public String isAnswerCorrect()
    {
        return answerCorrect;
    }

    // setting the correct
    // ans of question
    public void setAnswerCorrect(String answerCorrect)
    {
        this.answerCorrect = answerCorrect;
    }
}

