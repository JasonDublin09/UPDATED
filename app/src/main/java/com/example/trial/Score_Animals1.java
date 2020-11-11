package com.example.trial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score_Animals1 extends AppCompatActivity {
    Button btnTryAgain, btnMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_page);

        btnTryAgain = findViewById(R.id.btnTryagain);
        btnMain = findViewById(R.id.btnMainmenu);

        TextView scoreComment = findViewById(R.id.scoreCommentText);
        TextView scoring = findViewById(R.id.scoreText);

        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);
        if (score > 3) {
            scoreComment.setText("YOU'RE A STAR!");
            scoring.setText(score + " " + "/10");
            // showing correctness
        }
        else {
            scoreComment.setText("YOU CAN DO BETTER!");
            scoring.setText(score + " " + "/10");
        }

        btnTryAgain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startActivity(new Intent(Score_Animals1.this, Animals_Level1.class));
            }
        });
        /*
        btnMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startActivity(new Intent(Score_Animals1.this, Categories.class));
            }
        });
         */
    }
}