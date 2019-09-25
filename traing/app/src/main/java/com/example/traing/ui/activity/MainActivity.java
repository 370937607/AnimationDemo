package com.example.traing.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.traing.bean.Persen;
import com.example.traing.R;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;


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

        button = findViewById(R.id.btn);
        button.setOnClickListener(this);

//        1 初始化bmom
        Bmob.initialize(this, "df59acdae2e6bfd468be00b11797dd66");


        // 初始化Fragment
        initFragment();
        // 初始化View
        initView();




        //2.添加一行数据
//        Persen persen = new Persen();
//        persen.setName("meng");
//        persen.setAddress("11123");
//        persen.save(new SaveListener<String>() {
//            @Override
//            public void done(String s, BmobException e) {
//                if(e!=null){
//                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
//                }else {
//                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
//                }
//
//            }
//        });

        //3.查询一行数据
        /*BmobQuery<Persen> query = new BmobQuery<>();
        query.getObject("acfbb9675d", new QueryListener<Persen>() {
            @Override
            public void done(Persen persen, BmobException e) {
                if(e==null){
                    Show(persen.toString());
                }

            }


        });*/

        //4.修改数据
//        Persen persen = new Persen();
//        persen.setName("denny");
//        persen.update("01ac0c3cdb", new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if (e == null) {
//                    show("update success!");
//                }
//            }
//        });


//        5.删除数据
//        Persen persen = new Persen();
//        persen.setObjectId("01ac0c3cdb");
//        persen.delete(new UpdateListener() {
//            @Override
//            public void done(BmobException e) {
//                if(e==null){
//                    show("delete success!");
//                }
//            }
//        });
    }

    private void initView() {
        // 1. 获取RadioGroup对象，设置监听器
        group = findViewById(R.id.btn_group);
        group.setOnCheckedChangeListener(this);
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


    //
    private void show(String msq) {
        Toast.makeText(MainActivity.this, msq, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn:

                Intent intent = new Intent(MainActivity.this,Rejest.class);
                startActivity(intent);
                break;
        }
    }

}