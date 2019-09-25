package edu.niit.android.wechat.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.niit.android.wechat.util.OnDataCallbackListener;
import edu.niit.android.wechat.R;

public class FindFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    private TextView tvData;
    private OnDataCallbackListener listener;

    public FindFragment() {
        // Required empty public constructor
    }

    public static FindFragment newInstance(String param1) {
        FindFragment fragment = new FindFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, container, false);
        tvData = view.findViewById(R.id.tv_data);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            tvData.setText(mParam1);
        }

        // fragment向activity传递数据
        Context context = getContext();
        if (context instanceof OnDataCallbackListener) {
            listener = (OnDataCallbackListener) context;
            listener.setActivityTitle(getResources().getString(R.string.btn_find));
        }
        return view;
    }

}
