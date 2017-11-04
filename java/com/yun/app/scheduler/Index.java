package com.yun.app.scheduler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Index extends AppCompatActivity {

    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);

        final Context ctx = Index.this;

        final TextView year = findViewById(R.id.year);
        final TextView month = findViewById(R.id.month);
        final TextView date = findViewById(R.id.date);
        final TextView hour = findViewById(R.id.hour);
        final TextView minute = findViewById(R.id.minute);
        final TextView today = findViewById(R.id.today);

        today.setText("오늘 날짜 : "+new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
/*        RadioButton set_date = findViewById(R.id.set_date);*/
/*        RadioButton set_time = findViewById(R.id.set_time);*/

        final CalendarView calendar = findViewById(R.id.calendar);
        final TimePicker clock = findViewById(R.id.clock);
/*        Button reservation_btn = findViewById(R.id.reservation_btn);*/

        clock.setVisibility(View.INVISIBLE);//시계가 안나오게 함.

        findViewById(R.id.set_date).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"CLICK",Toast.LENGTH_LONG).show();
                calendar.setVisibility(View.VISIBLE);//날짜 설정시 캘린더만 출력
                clock.setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.set_time).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx,"CLICK", Toast.LENGTH_SHORT).show();
                calendar.setVisibility(View.INVISIBLE);
                clock.setVisibility(View.VISIBLE);//시간 설정시 시계만 출력
            }
        });

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView v, int y, int m, int d) {
                temp=y+"/"+(m+1)+"/"+d;
            }
        });

        findViewById(R.id.calendar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(ctx,year+month,Toast.LENGTH_LONG).show();*/
            }
        });

        findViewById(R.id.clock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* Toast.makeText(ctx, hour+":"+minute, Toast.LENGTH_SHORT).show();*/
            }
        });

        findViewById(R.id.reservation_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(temp == null){
                    Toast.makeText(ctx,"날짜와 시간은 필수 선택해 주세요",Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ctx, "설정한 시간으로 예약합니다.", Toast.LENGTH_SHORT).show();
                    String[] arr = temp.split("/");
                    year.setText(arr[0]);
                    month.setText(arr[1]);
                    date.setText(arr[2]);
                    hour.setText(String.valueOf(clock.getHour()));
                    minute.setText(String.valueOf(clock.getMinute()));
                }
            }
        });



    }

}
