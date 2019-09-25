package edu.niit.android.wechat.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.RadioGroup;

import edu.niit.android.wechat.R;
import edu.niit.android.wechat.ui.fragment.AddressFragment;
import edu.niit.android.wechat.ui.fragment.FindFragment;
import edu.niit.android.wechat.ui.fragment.MeFragment;
import edu.niit.android.wechat.ui.fragment.WechatFragment;
import edu.niit.android.wechat.util.OnDataCallbackListener;

public class MainActivity extends AppCompatActivity
        implements RadioGroup.OnCheckedChangeListener, OnDataCallbackListener {
    // SparseArray相当于Java的HashMap
    private SparseArray<Fragment> fragments;
    private RadioGroup group;

    @Override
    public void setActivityTitle(String data) {
        setTitle(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化Fragment
        initFragment();
        // 初始化View
        initView();
    }

    private void initView() {
        // 1. 获取RadioGroup对象，设置监听器
        group = findViewById(R.id.btn_group);
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        replaceFragment(fragments.get(checkedId)); // checkedId是RadioButton的id
    }

    private void initFragment() {
        // 1. 将创建的fragment放入集合中
        fragments = new SparseArray<>();
        fragments.put(R.id.btn_weixin, WechatFragment.newInstance()); // RadioButton的id
        fragments.put(R.id.btn_address, AddressFragment.newInstance());
        fragments.put(R.id.btn_find, FindFragment.newInstance("activity向FindFragment传递的数据"));
        fragments.put(R.id.btn_me, MeFragment.newInstance("activity向MeFragment传递的数据"));

        // activity像fragment传递数据
//        Fragment fragment = new FindFragment();
//        Bundle args = new Bundle();
//        args.putString("param1", "activity向fragment传递的数据");
//        fragment.setArguments(args);
//        fragments.put(R.id.btn_find, fragment);

        // 2. 初始化，将页面定位为第1个fragment
        replaceFragment(fragments.get(R.id.btn_weixin));
    }

    // 功能：对多个fragment进行管理和替换
    private void replaceFragment(Fragment fragment) {
        // 1. 获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        // 2. 开始FragmentTransaction的事务管理
        FragmentTransaction ft = manager.beginTransaction();
        // 3. 替换为新的Fragment
        ft.replace(R.id.content_layout, fragment); // activity中LinearLayout的id
        // 4. 事务提交
        ft.commit();
    }

}
