package com.example.apigetkshitij;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView timepoint,cloudcover,seeing,transparency,liftedindex,rh2m,direction,speed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        timepoint=findViewById(R.id.timepoint);
        cloudcover=findViewById(R.id.cloudcover);
        seeing=findViewById(R.id.seeing);
        transparency=findViewById(R.id.transparency);
        liftedindex=findViewById(R.id.liftedindex);
        rh2m=findViewById(R.id.rh2m);
        direction=findViewById(R.id.direction);
        speed=findViewById(R.id.speed);

        Bundle bundle = getIntent().getExtras();
        String kundan = bundle.getString("timepoint");
        timepoint.setText(kundan);

        String kundan1 = bundle.getString("cloudcover");
        cloudcover.setText(kundan1);

        String kundan2 = bundle.getString("seeing");
        seeing.setText(kundan2);

        String kundan3 = bundle.getString("transparency");
        transparency.setText(kundan3);

        String kundan4 = bundle.getString("direction");
        liftedindex.setText(kundan4);

        String kundan5 = bundle.getString("speed");
        rh2m.setText(kundan5);

        String kundan6 = bundle.getString("direction1");
        direction.setText(kundan6);

        String kundan7 = bundle.getString("speed1");
        speed.setText(kundan7);
    }
}