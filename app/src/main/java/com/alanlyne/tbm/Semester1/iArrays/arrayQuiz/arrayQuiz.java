package com.alanlyne.tbm.Semester1.iArrays.arrayQuiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.iArrays.Arrays;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class arrayQuiz extends AppCompatActivity {
    Button b1, b2, b3, b4;
    TextView t1_question, x;
    int total = 0;
    int correct = 0;
    int wrong = 0;
    private long mLastClickTime = 0;
    int computerCount = 0;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        b1 = findViewById(R.id.reset);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);

        x = findViewById(R.id.x);
        x.setOnClickListener(v -> {
            Intent x = new Intent(arrayQuiz.this, Arrays.class);
            startActivity(x);
        });

        t1_question = findViewById(R.id.questionText);
        //timerTxt = findViewById(R.id.timerTxt);

        updateQuestion();
        //reverseTimer(60,timerTxt);
    }

    @Override
    public void onBackPressed()
    {
        Intent end = new Intent(arrayQuiz.this, Arrays.class);
        startActivity(end);
    }

    private void updateQuestion() {
        computerCount++;
        if (computerCount > 5) {
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(arrayQuiz.this, arrayQuizResult.class);
            myIntent.putExtra("total", String.valueOf(total));
            myIntent.putExtra("correct", String.valueOf(correct));
            myIntent.putExtra("incorrect", String.valueOf(wrong));
            startActivity(myIntent);

        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("arrayQuiz").child(String.valueOf(computerCount));
            total++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final arrayQuizQ questions = dataSnapshot.getValue(arrayQuizQ.class);
                    t1_question.setText(questions.getQuestion());
                    b1.setText(questions.getOption1());
                    b2.setText(questions.getOption2());
                    b3.setText(questions.getOption3());
                    b4.setText(questions.getOption4());

                    b1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                                System.out.println("Fun");
                            }
                            else {
                                mLastClickTime = SystemClock.elapsedRealtime();

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                b1.setBackgroundResource(R.drawable.quizgreen);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b1.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b1.setBackgroundResource(R.drawable.quizred);

                                if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundResource(R.drawable.quizgreen);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundResource(R.drawable.b_round);
                                        b2.setBackgroundResource(R.drawable.b_round);
                                        b3.setBackgroundResource(R.drawable.b_round);
                                        b4.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }}
                    });


                    b2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                                System.out.println("Fun");
                            }
                            else {
                                mLastClickTime = SystemClock.elapsedRealtime();

                                if (b2.getText().toString().equals(questions.getAnswer())) {
                                b2.setBackgroundResource(R.drawable.quizgreen);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b2.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b2.setBackgroundResource(R.drawable.quizred);;

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundResource(R.drawable.quizgreen);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundResource(R.drawable.b_round);
                                        b2.setBackgroundResource(R.drawable.b_round);
                                        b3.setBackgroundResource(R.drawable.b_round);
                                        b4.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }}
                    });


                    b3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                                System.out.println("Fun");
                            }
                            else {
                                mLastClickTime = SystemClock.elapsedRealtime();

                                if (b3.getText().toString().equals(questions.getAnswer())) {
                                b3.setBackgroundResource(R.drawable.quizgreen);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b3.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b3.setBackgroundResource(R.drawable.quizred);

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b4.getText().toString().equals(questions.getAnswer())) {
                                    b4.setBackgroundResource(R.drawable.quizgreen);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundResource(R.drawable.b_round);
                                        b2.setBackgroundResource(R.drawable.b_round);
                                        b3.setBackgroundResource(R.drawable.b_round);
                                        b4.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }}
                    });


                    b4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (SystemClock.elapsedRealtime() - mLastClickTime < 1500) {
                                System.out.println("Fun");
                            }
                            else {
                                mLastClickTime = SystemClock.elapsedRealtime();

                                if (b4.getText().toString().equals(questions.getAnswer())) {
                                b4.setBackgroundResource(R.drawable.quizgreen);
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        correct++;
                                        b4.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            } else {
                                wrong++;
                                b4.setBackgroundResource(R.drawable.quizred);

                                if (b1.getText().toString().equals(questions.getAnswer())) {
                                    b1.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b3.getText().toString().equals(questions.getAnswer())) {
                                    b3.setBackgroundResource(R.drawable.quizgreen);
                                } else if (b2.getText().toString().equals(questions.getAnswer())) {
                                    b2.setBackgroundResource(R.drawable.quizgreen);
                                }


                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //correct++;
                                        b1.setBackgroundResource(R.drawable.b_round);
                                        b2.setBackgroundResource(R.drawable.b_round);
                                        b3.setBackgroundResource(R.drawable.b_round);
                                        b4.setBackgroundResource(R.drawable.b_round);
                                        updateQuestion();
                                    }
                                }, 1500);
                            }
                        }}
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}