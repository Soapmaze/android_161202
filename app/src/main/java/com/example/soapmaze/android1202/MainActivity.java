package com.example.soapmaze.android1202;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    DatePicker d_pick;
    TimePicker t_pick;
    TextView txt_reserving, txt_result;

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
        d_pick = (DatePicker)findViewById(R.id.datePicker);
        t_pick = (TimePicker)findViewById(R.id.timePicker);
        txt_result = (TextView) findViewById(R.id.tview_result);
        txt_reserving = (TextView)findViewById(R.id.tview_label);
        rd_date.setChecked(false);
        rd_time.setChecked(false);
        d_pick.setVisibility(View.INVISIBLE);
        t_pick.setVisibility(View.INVISIBLE);
        b_end.setVisibility(View.INVISIBLE);

        b_start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                r_time.start();
                String strColor = "#FF0000";
                txt_reserving.setTextColor(Color.parseColor(strColor));
                r_time.setTextColor(Color.parseColor(strColor));
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
                    case R.id.radio_Time :
                        t_pick.setVisibility(View.VISIBLE);
                        d_pick.setVisibility(View.INVISIBLE);
                        b_end.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
