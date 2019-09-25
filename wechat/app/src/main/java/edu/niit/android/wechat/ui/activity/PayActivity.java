package edu.niit.android.wechat.ui.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.niit.android.wechat.R;
import edu.niit.android.wechat.model.ThreeService;
import edu.niit.android.wechat.ui.adapter.GridViewAdapter;

public class PayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        initData();
        initView();
    }
    private GridView gridView;
    private void initView() {
        gridView = findViewById(R.id.gv_tencent);
        gridView.setAdapter(new GridViewAdapter(this, services));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ThreeService service = (ThreeService) parent.getItemAtPosition(position);
                Toast.makeText(PayActivity.this, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
    // 给ThreeService集合赋值
    private List<ThreeService> services;
    private void initData() {
        services = new ArrayList<>();
        services.add(new ThreeService(R.mipmap.pay, "信用卡还款"));
        services.add(new ThreeService(R.mipmap.phone, "手机充值"));
        services.add(new ThreeService(R.mipmap.money, "理财通"));
        services.add(new ThreeService(R.mipmap.bill, "生活缴费"));
        services.add(new ThreeService(R.mipmap.city, "城市服务"));
        services.add(new ThreeService(R.mipmap.q_coin, "Q币充值"));
        services.add(new ThreeService(R.mipmap.benefit, "腾讯公益"));
        services.add(new ThreeService(R.mipmap.insurance, "保险服务"));
        services.add(new ThreeService(R.mipmap.debit, "微粒贷借钱"));

        // 修改标题
        Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));

        // 设置显示系统默认的返回键： <-
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    // 处理home键的回退事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
