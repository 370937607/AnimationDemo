package edu.niit.android.wechat.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.niit.android.wechat.R;
import edu.niit.android.wechat.ui.activity.PayActivity;
import edu.niit.android.wechat.ui.activity.ReceiveAddressActivity;
import edu.niit.android.wechat.util.OnDataCallbackListener;


public class MeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private OnDataCallbackListener mListener;

    public MeFragment() {
        // Required empty public constructor
    }

    public static MeFragment newInstance(String param1) {
        MeFragment fragment = new MeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    private View view;
    private ListView lvMe;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (mListener != null) {
            mListener.setActivityTitle("个人中心"); // Uri.parse("个人中心");
        }
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_me, container, false);
        }
        // 0. 获取数据
        initData();
        // 1. 初始化控件
        lvMe = view.findViewById(R.id.lv_me);
        // 2. 创建Adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getActivity(), // 上下文
                android.R.layout.simple_expandable_list_item_1, // 布局
                datas //数据
        );
//        lvMe.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        // 3. 给ListView设置Adapter
        lvMe.setAdapter(adapter);
        // 4. 给Item设置监听事件
        lvMe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = (String) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), data, Toast.LENGTH_LONG).show();
                if ("支付".equals(data)) {
                    Intent intent = new Intent(getActivity(), PayActivity.class);
                    intent.putExtra("title", data);
                    startActivity(intent);
                } else if ("设置".equals(data)) {
                    Intent intent = new Intent(getActivity(), ReceiveAddressActivity.class);
                    intent.putExtra("title", data);
                    startActivity(intent);
                }
            }
        });
        lvMe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                datas.remove((String) parent.getItemAtPosition(position));
                datas.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
        return view;
    }

    //    private String[] datas = {"支付", "收藏", "相册", "卡包", "表情", "设置"};
    private List<String> datas;

    private void initData() {
        datas = new ArrayList<>();
        datas.add("支付");
        datas.add("收藏");
        datas.add("相册");
        datas.add("卡包");
        datas.add("表情");
        datas.add("设置");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDataCallbackListener) {
            mListener = (OnDataCallbackListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
