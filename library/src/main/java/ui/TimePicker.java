package ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.cycle.single.library.R;

import java.util.Calendar;

public class TimePicker extends FrameLayout {

    private NumberPicker hourPicker;
    private NumberPicker minPicker;
    private NumberPicker ampmPicker;

    private Calendar mCalendar;


    public TimePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        mCalendar = Calendar.getInstance();
        ((LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(
                R.layout.time_picker, this, true);



        hourPicker = (NumberPicker) findViewById(R.id.time_hours);
        minPicker = (NumberPicker) findViewById(R.id.time_minutes);
        ampmPicker = (NumberPicker) findViewById(R.id.time_am_pm);

        minPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
        hourPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);
//        ampmPicker.setFormatter(NumberPicker.TWO_DIGIT_FORMATTER);


        hourPicker.setMinValue(0);
        hourPicker.setMaxValue(11);
        minPicker.setMinValue(0);
        minPicker.setMaxValue(59);

        ampmPicker.setMinValue(0);
        ampmPicker.setMaxValue(1);
        ampmPicker.setDisplayedValues(new String[]{"AM", "PM"});

        ampmPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

//                mCalendar.set(Calendar.AM,0);
            }
        });

        minPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                mCalendar.set(Calendar.MINUTE, newVal);

            }
        });

        hourPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal,
                                      int newVal) {
                mCalendar.set(Calendar.HOUR, newVal);
            }
        });

        updateTime();

    }


    public TimePicker(Context context) {
        this(context, null);
    }

    private void updateTime() {

        hourPicker.setValue(mCalendar.get(Calendar.HOUR_OF_DAY));
        minPicker.setValue(mCalendar.get(Calendar.MINUTE));
//        ampmPicker.setValue(mCalendar.get(Calendar.AM));
    }

    public int getHour() {
        return hourPicker.getValue();
    }

    public int getAmPmType()
    {
        return ampmPicker.getValue();
    }

    public int getMinute() {
        return mCalendar.get(Calendar.MINUTE);
    }

    public void setCalendar(Calendar calendar) {
        this.mCalendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY));
        this.mCalendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE));
        updateTime();
    }


}
