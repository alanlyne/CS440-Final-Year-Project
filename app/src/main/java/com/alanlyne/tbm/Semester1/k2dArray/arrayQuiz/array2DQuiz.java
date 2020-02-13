package com.alanlyne.tbm.Semester1.k2dArray.arrayQuiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alanlyne.tbm.R;
import com.alanlyne.tbm.Semester1.k2dArray.Array2D;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class array2DQuiz extends AppCompatActivity {
    Button b1, b2, b3, b4;
    TextView t1_question, x;
    int total = 0;
    int correct = 0;
    int wrong = 0;

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
            Intent x = new Intent(array2DQuiz.this, Array2D.class);
            startActivity(x);
        });

        t1_question = findViewById(R.id.questionText);
        //timerTxt = findViewById(R.id.timerTxt);

        updateQuestion();
        //reverseTimer(60,timerTxt);
    }

    private void updateQuestion() {
        computerCount++;
        if (computerCount > 5) {
            Toast.makeText(getApplicationContext(), "Game Over", Toast.LENGTH_SHORT).show();
            Intent myIntent = new Intent(array2DQuiz.this, array2DQuizResult.class);
            myIntent.putExtra("total", String.valueOf(total));
            myIntent.putExtra("correct", String.valueOf(correct));
            myIntent.putExtra("incorrect", String.valueOf(wrong));
            startActivity(myIntent);

        } else {
            reference = FirebaseDatabase.getInstance().getReference().child("array2DQuiz").child(String.valueOf(computerCount));
            total++;
            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    final array2DQuizQ questions = dataSnapshot.getValue(array2DQuizQ.class);
                    t1_question.setText(questions.getQuestion());
                    b1.setText(questions.getOption1());
                    b2.setText(questions.getOption2());
                    b3.setText(questions.getOption3());
                    b4.setText(questions.getOption4());

                    b1.setOnClickListener(v -> {
                        if (b1.getText().toString().equals(questions.getAnswer())) {
                            b1.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b1.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
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
                            handler.postDelayed(() -> {
                                //correct++;
                                b1.setBackgroundResource(R.drawable.b_round);
                                b2.setBackgroundResource(R.drawable.b_round);
                                b3.setBackgroundResource(R.drawable.b_round);
                                b4.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
                            }, 1500);
                        }
                    });


                    b2.setOnClickListener(v -> {
                        if (b2.getText().toString().equals(questions.getAnswer())) {
                            b2.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b2.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
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
                            handler.postDelayed(() -> {
                                //correct++;
                                b1.setBackgroundResource(R.drawable.b_round);
                                b2.setBackgroundResource(R.drawable.b_round);
                                b3.setBackgroundResource(R.drawable.b_round);
                                b4.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
                            }, 1500);
                        }
                    });


                    b3.setOnClickListener(v -> {
                        if (b3.getText().toString().equals(questions.getAnswer())) {
                            b3.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b3.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
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
                            handler.postDelayed(() -> {
                                //correct++;
                                b1.setBackgroundResource(R.drawable.b_round);
                                b2.setBackgroundResource(R.drawable.b_round);
                                b3.setBackgroundResource(R.drawable.b_round);
                                b4.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
                            }, 1500);
                        }
                    });


                    b4.setOnClickListener(v -> {
                        if (b4.getText().toString().equals(questions.getAnswer())) {
                            b4.setBackgroundColor(Color.GREEN);
                            Handler handler = new Handler();
                            handler.postDelayed(() -> {
                                correct++;
                                b4.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
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
                            handler.postDelayed(() -> {
                                //correct++;
                                b1.setBackgroundResource(R.drawable.b_round);
                                b2.setBackgroundResource(R.drawable.b_round);
                                b3.setBackgroundResource(R.drawable.b_round);
                                b4.setBackgroundResource(R.drawable.b_round);
                                updateQuestion();
                            }, 1500);
                        }
                    });

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
