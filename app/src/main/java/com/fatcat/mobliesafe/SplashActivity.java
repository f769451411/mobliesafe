package com.fatcat.mobliesafe;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.fatcat.mobliesafe.util.PackageUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

public class SplashActivity extends Activity {
    private TextView mVersion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);  //代码方式去除标题
        setContentView(R.layout.activity_splash);
        //初始化配置文件
        initView();
        //检测apk是否更新
        update();
    }

    private void update() {
        HttpUtils httpUtils = new HttpUtils(2000);
        //链接请求服务器
        //method : 请求方式
        //url ： 请求路径
        //params : 请求参数   http://baidu.com/?name=ls&psw=123456
        //RequestCallBack : 请求的回调监听
        //ctrl+shift+x ：小转大  ctrl+shift+y ：大转小
        String CONTENTURL = "";
        httpUtils.send(HttpRequest.HttpMethod.GET, CONTENTURL, null, new RequestCallBack<String>() {
            @Override
            //请求成功返回
            public void onSuccess(ResponseInfo<String> responseInfo) {

            }
            //请求失败返回
            @Override
            public void onFailure(HttpException e, String s) {

            }
        });
    }

    private void initView() {
        mVersion = (TextView)findViewById(R.id.splash_tv_version);
        mVersion.setText("版本:"+ PackageUtil.getVersionName(this));
    }
}
