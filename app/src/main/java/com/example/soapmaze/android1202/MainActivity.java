package com.example.soapmaze.android1202;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer r_time;
    Button b_start, b_end;
    RadioGroup rd;
    RadioButton rd_date, rd_time;
    CalendarView d_pick;
    TimePicker t_pick;
    TextView txt_reserving, txt_result;
    String datetime;
    String selected_date, selected_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r_time = (Chronometer)findViewById(R.id.chron_time);
        b_start = (Button)findViewById(R.id.btn_reserve);
        b_end = (Button)findViewById(R.id.btn_complete);
        rd = (RadioGroup)findViewById(R.id.rad_group);
        rd_date = (RadioButton)findViewById(R.id.radio_date);
        rd_time = (RadioButton)findViewById(R.id.radio_Time);
        d_pick = (CalendarView)findViewById(R.id.calendarView);
        t_pick = (TimePicker)findViewById(R.id.timePicker);
        txt_result = (TextView) findViewById(R.id.tview_result);
        rd.setVisibility(View.INVISIBLE);
        rd_date.setChecked(false);
        rd_time.setChecked(false);
        d_pick.setVisibility(View.INVISIBLE);
        t_pick.setVisibility(View.INVISIBLE);
        b_end.setVisibility(View.INVISIBLE);
        datetime = "";
        selected_date = "";
        selected_time = "";



        b_start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                r_time.start();
                String strColor = "#FF0000";
                r_time.setTextColor(Color.parseColor(strColor));
                rd.setVisibility(View.VISIBLE);
            }
        });

        rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i) {
                    case R.id.radio_date :
                        d_pick.setVisibility(View.VISIBLE);
                        t_pick.setVisibility(View.INVISIBLE);
                        b_end.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radio_Time :
                        d_pick.setVisibility(View.INVISIBLE);
                        t_pick.setVisibility(View.VISIBLE);
                        b_end.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        d_pick.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int date) {
                selected_date = year + "년 ";
                selected_date += (month+1) + "월 ";
                selected_date += date + "일 ";
            }
        });

        t_pick.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                selected_time = i + "시 ";
                selected_time += i1 + "분";
            }
        });

        b_end.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                datetime = selected_date + selected_time;
                txt_result.setText(datetime);
                r_time.stop();
                String strColor = "#0000FF";
                r_time.setTextColor(Color.parseColor(strColor));
            }
        });

    }
}
