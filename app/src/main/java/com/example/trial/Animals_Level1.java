package com.example.trial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class Animals_Level1 extends AppCompatActivity
        implements View.OnClickListener {
    // setting up things
    private Button A;
    private Button B;
    private Button C;
    private Button D;
    private ImageView qBox;
    private ImageView bg;
    private TextView score;
    private TextView scoreComment;

    private ImageButton nextButton;
    private ImageView Image;
    private TextView questionTextView;
    private int correct = 0;

    // to keep current question track
    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            // array of objects of class Question
            // providing questions from string
            // resource and the correct ans
            new Question(R.string.a, "Cat"),
            new Question(R.string.a, "Dog"),
            new Question(R.string.a, "Lion"),
            new Question(R.string.a, "Spider"),
            new Question(R.string.a, "Ant"),
            new Question(R.string.a, "Bird"),
            new Question(R.string.a, "Elephant"),
            new Question(R.string.a, "Dolphin"),
            new Question(R.string.a, "Hedgehog"),
            new Question(R.string.a, "Monkey"),

    };



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_level1);
        // setting up the buttons
        // associated with id
        A = findViewById(R.id.Abtn);
        B = findViewById(R.id.Bbtn);
        C = findViewById(R.id.Cbtn);
        D = findViewById(R.id.Dbtn);

        nextButton = findViewById(R.id.next_button);
        // register our buttons to listen to
        // click events
        questionTextView = findViewById(R.id.question_text_view);

        Image = findViewById(R.id.myimage);

        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);
        nextButton.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v)
    {
        A = findViewById(R.id.Abtn);
        B = findViewById(R.id.Bbtn);
        C = findViewById(R.id.Cbtn);
        D = findViewById(R.id.Dbtn);
        qBox = findViewById(R.id.question_Box);
        bg = findViewById(R.id.bg_image);
        score = findViewById(R.id.scoreText);
        scoreComment = findViewById(R.id.scoreCommentText);

        // checking which button is
        // clicked by user
        // in this case user choose false
        switch (v.getId()) {
            case R.id.Abtn:
                String aText = A.getText().toString();
                checkAnswer(aText);
                goNext();
                break;

            case R.id.Bbtn:
                String bText = B.getText().toString();
                checkAnswer(bText);
                goNext();
                break;

            case R.id.Cbtn:
                String cText = C.getText().toString();
                checkAnswer(cText);
                goNext();
                break;

            case R.id.Dbtn:
                String dText = D.getText().toString();
                checkAnswer(dText);
                goNext();
                break;

            case R.id.next_button:
                goNext();

                break;

        }
    }
    private void goNext(){
        // go to next question
        // limiting question bank range
        if (currentQuestionIndex < 10) {
            currentQuestionIndex++;
            // we are safe now!
            // last question reached
            // making buttons
            // invisible

            if (currentQuestionIndex == 10) {

                Intent intent = new Intent(getApplicationContext(), Score_Animals1.class);
                intent.putExtra("RIGHT_ANSWER_COUNT", correct);
                startActivity(intent);

            }

            else {

                updateQuestion();
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void updateQuestion() {
        Log.d("Current",
                "onClick: " + currentQuestionIndex);

        questionTextView.setText(questionBank[currentQuestionIndex].getAnswerResId());
        /*A.setText(choiceBank[currentChoiceIndex].getChoiceResId());
        B.setText(choiceBank[currentChoiceIndex].getChoiceResId());
        C.setText(choiceBank[currentChoiceIndex].getChoiceResId());
        D.setText(choiceBank[currentChoiceIndex].getChoiceResId()); */

        // setting the textview with new question
        switch (currentQuestionIndex) {
            case 0:
                Image.setImageResource(R.drawable.cat);
                A.setText("Ant");
                B.setText("Dog");
                C.setText("Giraffe");
                D.setText("Cat");
                break;
            case 1:
                Image.setImageResource(R.drawable.dogs);
                A.setText("Spider");
                B.setText("Penguin");
                C.setText("Dog");
                D.setText("Lizard");
                break;
            case 2:
                Image.setImageResource(R.drawable.lion);
                A.setText("Tiger");
                B.setText("Lion");
                C.setText("Puma");
                D.setText("Dog");
                break;
            case 3:
                Image.setImageResource(R.drawable.spider);
                A.setText("Crab");
                B.setText("Ant");
                C.setText("Spider");
                D.setText("Octopus");
                break;
            case 4:
                Image.setImageResource(R.drawable.ant);
                A.setText("Mantis");
                B.setText("Spider");
                C.setText("Ant");
                D.setText("Octopus");
                break;
            case 5:
                Image.setImageResource(R.drawable.birdy);
                A.setText("Bird");
                B.setText("Duck");
                C.setText("Fly");
                D.setText("Chicken");
                break;
            case 6:
                Image.setImageResource(R.drawable.elephant);
                A.setText("Boar");
                B.setText("Elephant");
                C.setText("Pig");
                D.setText("Warthog");
                break;
            case 7:
                Image.setImageResource(R.drawable.dolphin);
                A.setText("Shark");
                B.setText("Stingray");
                C.setText("Dolphin");
                D.setText("Eel");
                break;
            case 8:
                Image.setImageResource(R.drawable.hedgehog);
                A.setText("Porcupine");
                B.setText("Mouse");
                C.setText("Rabbit");
                D.setText("Hedgehog");
                break;
            case 9:
                Image.setImageResource(R.drawable.manky);
                A.setText("Tiger");
                B.setText("Monkey");
                C.setText("Dog");
                D.setText("Bear");
                break;
        }
    }

    private void checkAnswer(String userChooseCorrect)
    {
        String answerIsCorrect
                = questionBank[currentQuestionIndex]
                .isAnswerCorrect();
        // getting correct ans of current question
        int toastMessageId;
        // if ans matches with the
        // button clicked

        if (userChooseCorrect.equals(answerIsCorrect) ) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {
            // showing toast
            // message correct
            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(Animals_Level1.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }
}