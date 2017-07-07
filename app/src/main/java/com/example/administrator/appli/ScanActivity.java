package com.example.administrator.appli;

import android.app.Activity;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

/**
 * Created by Administrator on 2017/5/6 0006.
 */

public class ScanActivity extends Activity implements QRCodeView.Delegate{
    private static final String TAG = ScanActivity.class.getSimpleName();
    private static final int REQUEST_CODE_CHOOSE_QRCODE_FROM_GALLERY = 666;

    TextView topTitle;
    @Bind(R.id.zxingview)
    ZXingView mQRCodeView;
    private int isflsh=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
        mQRCodeView.setDelegate(this);
        mQRCodeView.startSpot();
    }


    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
        mQRCodeView.showScanRect();
        mQRCodeView.startSpot();
    }

    @Override
    protected void onStop() {
        if(null!=mQRCodeView){
            mQRCodeView.stopCamera();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
    }

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }
    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i(TAG, "result:" + result);
            //Toastui.show("识别成功！");
        Toast.makeText(ScanActivity.this,result,Toast.LENGTH_LONG).show();
        vibrate();
        mQRCodeView.startSpot();
//            if(null != result){
//            //System.out.println("result=="+result);
//            ///String data = "http://m.lvb.fenbot.com/app/start_record_video?param={\"item_id\":\"2026100\",\"domain\":\"http:\\/\\/api.test.wxfenxiao.com\",\"shop_id\":\"6\"}";
//            String mData = Uri.parse(result).getQueryParameter("param");
//            Gson gson = new Gson();
//            ScanModel model = gson.fromJson(mData,ScanModel.class);
//            String user_id =  ACache.get(BaseActivity.getInstance()).getAsString("user_id");
//            //showActivity(RecordActivity.class);
//            mainControl.getitem_check(user_id,model.getShop_id(),model.getItem_id(),model.getDomain());
//            ACache.get(BaseActivity.getInstance()).put("shop_id",model.getShop_id());
//            ACache.get(BaseActivity.getInstance()).put("item_id",model.getItem_id());
//            ACache.get(BaseActivity.getInstance()).put("domain",model.getDomain());
//            vibrate();
//            mQRCodeView.startSpot();
//            }else{
//                Toastui.show("请重新扫描!");
//                vibrate();
//                mQRCodeView.startSpot();
//            }
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

}
