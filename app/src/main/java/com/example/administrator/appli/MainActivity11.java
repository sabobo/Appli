package com.example.administrator.appli;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zaaach.citypicker.CityPickerActivity;

public class MainActivity11 extends AppCompatActivity {
    private static final int REQUEST_CODE_PICK_CITY = 233;
    private TextView resultTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultTV = (TextView) findViewById(R.id.tv_result);
        findViewById(R.id.btn_select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity11.this, CityPickerActivity.class), REQUEST_CODE_PICK_CITY);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            final   String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            final   String city_id = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITYID);
            Toast.makeText(MainActivity11.this,"11111=city="+city +"=city_id="+city_id ,Toast.LENGTH_LONG).show();
            if (data != null){
                // String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                resultTV.setText("当前选择：" + city);
            }
        }
    }
}
