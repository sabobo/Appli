package com.example.administrator.appli;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;

import java.util.List;

/**
 * Created by Administrator on 2017/4/8 0008.
 */

public class Main extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        AlphaTitleScrollView scroll = (AlphaTitleScrollView) findViewById(R.id.scrollview);
        LinearLayout title = (LinearLayout) findViewById(R.id.title);
        ImageView head = (ImageView) findViewById(R.id.head);
        scroll.setTitleAndHead(title, head);
        title.getBackground().setAlpha(0);
        Acp.getInstance(this).request(new AcpOptions.Builder()
                        .setPermissions(Manifest.permission.CALL_PHONE
                                , Manifest.permission.CAMERA
                                , Manifest.permission.RECORD_AUDIO
                                , Manifest.permission.READ_EXTERNAL_STORAGE
                                , Manifest.permission.WRITE_EXTERNAL_STORAGE
                                , Manifest.permission.VIBRATE
                        ).build(),
                new AcpListener() {
                    @Override
                    public void onGranted() {// writeSD();// getIMEI();
                    }
                    @Override
                    public void onDenied(List<String> permissions) {
                        // makeText(permissions.toString() + "权限拒绝") ;
                    }
                });
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Main.this,ScanActivity.class));
            }
        });
    }
}
