package ranthy.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Sec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Sec = (EditText)findViewById(R.id.editText);
    }

    public void Start(View view) {
        int i = Integer.parseInt(Sec.getText().toString());
        int Second = i*1000;
        Intent intent = new Intent(this,Receiver.class);
        PendingIntent pendingIntent =  PendingIntent.getBroadcast(getApplicationContext(),2222,intent,0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + Second, pendingIntent);
        System.out.println("The Value of Minute " + i);
        System.out.println("The value of Second" + Second);
        System.out.println("The Value of Milli Seconds "+System.currentTimeMillis());
        Toast.makeText(this, "Alarm set in " + i + " Minutes",
                Toast.LENGTH_LONG).show();
    }
}
