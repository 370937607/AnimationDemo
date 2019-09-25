package edu.niit.android.wechat.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.niit.android.wechat.model.Address;
import edu.niit.android.wechat.util.OnDataCallbackListener;
import edu.niit.android.wechat.R;


public class AddressFragment extends Fragment {

    private OnDataCallbackListener listener;

    public AddressFragment() {
        // Required empty public constructor
    }

    public static AddressFragment newInstance() {
        return new AddressFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_address, container, false);
        setHasOptionsMenu(true);
        // fragment向activity传递数据
        Context context = getContext();
        if (context instanceof OnDataCallbackListener) {
            listener = (OnDataCallbackListener) context;
            listener.setActivityTitle(getResources().getString(R.string.btn_address));
        }

        // 1. 初始化数据
        initData();
        // 2. 初始化ListView
        initListView(view);
        return view;
    }
    private ListView lvAddress;
    private void initListView(View view) {
        // 1.
        lvAddress = view.findViewById(R.id.lv_address);
        // 2.
        SimpleAdapter adapter = new SimpleAdapter(
                getActivity(),  // 上下文
                headerMap,      // 数据
                R.layout.item_address,  // listview的item的layout布局
                new String[] {"img", "name"},   // hashmap对应的key
                new int[] {R.id.iv_header, R.id.tv_name} // item的layout布局中的控件id
        );
        // 3.
        lvAddress.setAdapter(adapter);
        // 4.
        lvAddress.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String, Object> data = (HashMap<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(parent.getContext(), (String)data.get("name"), Toast.LENGTH_LONG).show();
            }
        });
    }
//    private int[] headers = {R.mipmap.ic_launcher, R.mipmap.ic_launcher,
//            R.mipmap.ic_launcher, R.mipmap.ic_launcher };
//    private String[] names = {"张三", "王五", "李四", "王二"};
    private List<Address> addresses;
    private List<HashMap<String, Object>> headerMap;
    private void initData() {
        addresses = new ArrayList<>();
        addresses.add(new Address(R.mipmap.ic_launcher, "张三"));
        addresses.add(new Address(R.mipmap.ic_launcher, "王五"));
        addresses.add(new Address(R.mipmap.ic_launcher, "李四"));
        addresses.add(new Address(R.mipmap.ic_launcher, "王二"));

        headerMap = new ArrayList<>();
        for(Address address : addresses) {
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("img", address.getImg());
            map1.put("name", address.getName());
            headerMap.add(map1);
        }
//        for(int i = 0; i < headers.length; i++) {
//
//            HashMap<String, Object> map1 = new HashMap<>();
//            map1.put("img", headers[i]);
//            map1.put("name", names[i]);
//            headerMap.add(map1);
//        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_address, menu);
    }
}
