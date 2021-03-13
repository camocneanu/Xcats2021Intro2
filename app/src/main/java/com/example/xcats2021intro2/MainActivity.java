package com.example.xcats2021intro2;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context;
    Button allianceButton;
    Button toastButtonStudents;
    Button toastButtonPeople;
    TeamStates.FRCAlliance currentAlliance;
    RadioGroup numberOfStudentsRadioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        allianceButton = findViewById(R.id.allianceButton);
        toastButtonStudents = findViewById(R.id.toastButton);
        toastButtonPeople =  findViewById(R.id.toastStudentsButton);
        setAllianceAttributes(TeamStates.FRCAlliance.BLUE);
        numberOfStudentsRadioGroup = findViewById(R.id.numberOfStudentsRadioGroup);

        toastButtonStudents.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                makeEmotionToast(v);
            }
        });

        toastButtonPeople.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                makeEmotionToast(v);
            }
        });

    }

    public void toggleXCatButtonText(View view){
        Button button = findViewById(R.id.xcats_button);
        if(button.getText().equals(getText(R.string.greetings_hello_xcats))){
            button.setText(R.string.greetings_bye_xcats);
        } else if(button.getText().equals(getText(R.string.greetings_bye_xcats))){
            button.setText(R.string.greetings_hello_xcats);
        }
    }

    public void toggleAllianceButtonText(View view){
        switch(currentAlliance){
            case BLUE:
                setAllianceAttributes(TeamStates.FRCAlliance.RED);
                break;
            case RED:
                setAllianceAttributes(TeamStates.FRCAlliance.BLUE);
                break;
        }
    }

    public void setAllianceAttributes(TeamStates.FRCAlliance alliance){
        allianceButton.setText(alliance.toString());
        allianceButton.setBackgroundColor(getResources().getColor(alliance.getColorInt()));
        View mainActivityView = this.getWindow().getDecorView();
        mainActivityView.setBackgroundColor(getResources().getColor(alliance.getBackgroundColorInt()));
        currentAlliance = alliance;
    }

    public void makeStudentNumberToast(View view) {
        int selectedRadioButtonId = numberOfStudentsRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selectedRadioButtonId);
        int numberOfStudents = 0;
        if (selectedButton != null) {
            numberOfStudents = Integer.parseInt(selectedButton.getText().toString());
        }

        String toastText = "No students are here today :(";
        if(numberOfStudents == 1){
            toastText = "1 student is here today";
        } else{
            toastText = Integer.toString(numberOfStudents) +" students are here today";
        }
        Toast.makeText(context, toastText, Toast.LENGTH_SHORT).show();
    }

    public void makeEmotionToast(View view) {
        RadioGroup emotionRadioGroup = findViewById(R.id.peopleInAttendanceRadioGroup);
        RadioButton selectedEmotionRadioButton = findViewById(emotionRadioGroup.getCheckedRadioButtonId());

        String emotionText = "Choose a button";

        if(selectedEmotionRadioButton != null) {
            if (selectedEmotionRadioButton.equals(findViewById(R.id.radioButtonSad))) {
                emotionText = "Sad!";
            } else if (selectedEmotionRadioButton.equals(findViewById(R.id.radioButtonOk))) {
                emotionText = "Ok.";
            } else if (selectedEmotionRadioButton.equals(findViewById(R.id.radioButtonHappy))) {
                emotionText = "Happy!";
            }
        }
        Toast.makeText(context, emotionText, Toast.LENGTH_SHORT).show();
    }
}