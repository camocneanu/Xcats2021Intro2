package com.example.xcats2021intro2;

import android.graphics.Color;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

public class TeamStates {

    enum FRCAlliance {
        BLUE("Blue", R.color.frc_blue, R.color.light_blue_background),
        RED("Red", R.color.frc_red, R.color.light_red_background);

        String allianceName;
        int allianceColorInt;
        int backgroundColorInt;

        private FRCAlliance(String name, @ColorRes int color, int backgroundColor) {
            allianceName = name;
            allianceColorInt = color;
            backgroundColorInt = backgroundColor;
        }

        @Override
        public String toString(){
            return allianceName;
        }

        public int getColorInt(){
            return allianceColorInt;
        }

        public int getBackgroundColorInt() { return backgroundColorInt; }
    }

    enum RobotPosition{
        LEFT, CENTER, RIGHT
    }

}
