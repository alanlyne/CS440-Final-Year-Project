package com.alanlyne.tbm.WIP.wipQuiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alanlyne.tbm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class wipQuiz extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView t1_question;
    int total = 0;
    int correct = 0;
    int wrong = 0;

    int computerCount=0;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wip_quiz);
        b1 = findViewById(R.id.reset);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        t1_question = findViewById(R.id.questionText);
        //timerTxt = findViewById(R.id.timerTxt);

        updateQuestion();
        //reverseTimer(60,timerTxt);
    }

    private void updateQuestion() {
        computerCount++;
        if (computerCount > 2) {
            Toast.makeText(getApplicationContext(),"Game Over",Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(wipQuiz.this,ResultActivity.class);
            myIntent.putExtra("total",String.valueOf(total));
            myIntent.putExtra("correct",String.valueOf(correct));
            myIntent.putExtra("incorrect",String.valueOf(wrong));
            startActivity(myIntent);

        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(computerCount));
            total++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final wipQuestions questions = dataSnapshot.getValue(wipQuestions.class);
                    t1_question.setText(questions.getQuestion());
                    b1.setText(questions.getOption1());
                    b2.setText(questions.getOption2());
                    b3.setText(questions.getOption3());
                    b4.setText(questions.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b1.getText().toString().equals(questions.getAnswer())) {
                                b1.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b1.setBackgroundColor(Color.RED);

                                if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b2.getText().toString().equals(questions.getAnswer())) {
                                b2.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b2.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b3.getText().toString().equals(questions.getAnswer())) {
                                b3.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b3.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });


                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (b4.getText().toString().equals(questions.getAnswer())) {
                                b4.setBackgroundColor(Color.GREEN);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b4.setBackgroundColor(Color.RED);

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundColor(Color.GREEN);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundColor(Color.GREEN);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundColor(Color.GREEN);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b2.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b3.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        b4.setBackgroundColor(Color.parseColor("#03A9F4"));
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }

//    public void reverseTimer(int seconds, final TextView tv){
//        new CountDownTimer(seconds * 1000 + 1000, 1000){
//            public void onTick(long millisUntilFinished){
//                int seconds = (int) (millisUntilFinished / 1000);
//                int minutes = seconds / 60;
//                seconds = seconds % 60;
//                tv.setText(String.format("%02d", minutes) + ":" + String.format("%02d", seconds));
//            }
//            public void onFinish(){
//                tv.setText("Completed");
//                Intent myIntent = new Intent(wipQuiz.this, ResultActivity.class);
//                myIntent.putExtra("total", String.valueOf(total));
//                myIntent.putExtra("correct", String.valueOf(correct));
//                myIntent.putExtra("wrong", String.valueOf(wrong));
//                startActivity(myIntent);
//            }
//        }.start();
//    }
}
