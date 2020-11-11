package com.example.trial;

public class Choices {
    // answerResId will store question
    private int choiceResId;

    // answerTrue will store correct answer
    // of the question provided

    public Choices(int choiceResId )
    {
        // setting the values through
        // arguments passed in constructor
        this.choiceResId = choiceResId;
    }

    public int getChoiceResId()
    {
        return choiceResId;
    }

    // setting the question passed
    public void setChoiceResId(int answerResId)
    {
        this.choiceResId = answerResId;
    }

    // returning the correct answer
    // of question

}

