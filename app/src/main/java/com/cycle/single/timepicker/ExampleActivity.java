package com.cycle.single.timepicker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import ui.TimePicker;


public class ExampleActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.time_picker);
        findViewById(R.id.a).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ExampleActivity.this, timePicker.getHour()+
                        ":"+ timePicker.getMinute()+  ":"+timePicker.getAmPmType(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
