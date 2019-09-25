package edu.niit.android.wechat.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.niit.android.wechat.R;
import edu.niit.android.wechat.model.Message;
import edu.niit.android.wechat.ui.activity.ChatActivity;
import edu.niit.android.wechat.ui.adapter.MessageAdapter;
import edu.niit.android.wechat.util.OnDataCallbackListener;
import edu.niit.android.wechat.util.PopupList;

public class WechatFragment extends Fragment {
    private ListView lvMsg;
    private List<Message> msgs;
    private OnDataCallbackListener listener;
    private List<String> popupMenu;

    // 构造方法
    public WechatFragment() {
        // Required empty public constructor
    }

    // 工厂方法
    public static WechatFragment newInstance() {
        return new WechatFragment();
    }

    // 相当于Activity的onCreate()的功能和作用
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wechat, container, false);
        // 显示选项菜单
        setHasOptionsMenu(true);

        // fragment向activity传递数据
        Context context = getContext();
        if (context instanceof OnDataCallbackListener) {
            listener = (OnDataCallbackListener) context;
            listener.setActivityTitle("微信");
        }
        // 初始化数据
        initData();
        // 初始化控件
        initView(view);

        // 气泡菜单
        popupMenu = new ArrayList<>();
        popupMenu.add("复制");
        popupMenu.add("删除");
        popupMenu.add("分享");
        popupMenu.add("更多...");

        PopupList popup = new PopupList(getContext());
        popup.bind(lvMsg, popupMenu, new PopupList.PopupListListener() {
            @Override
            public boolean showPopupList(View adapterView, View contextView, int contextPosition) {
                return true;
            }

            @Override
            public void onPopupListClick(View contextView, int contextPosition, int position) {
                Toast.makeText(getContext(), contextPosition + ", " + position, Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    private void initData() {
        msgs = new ArrayList<>();
        msgs.add(new Message(R.drawable.icon_public, "订阅号消息", "[2条]南工院：春天美景", "2019/5/1", false));
        msgs.add(new Message(R.drawable.icon_qunliao, "群聊", "Mary：下午去比赛", "昨天", true));
        msgs.add(new Message(R.drawable.head, "ales", "[1条]晚上去看复联4", "14:40", false));
    }

    private void initView(View view) {
        // 1. 初始化列表控件
        lvMsg = view.findViewById(R.id.lv_messages);
        // 2. 设置列表的适配器
        lvMsg.setAdapter(new MessageAdapter(getContext(), msgs));
        // 3. 设置每个子项的监听器
        lvMsg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Message msg = (Message) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), msg.toString(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(), ChatActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (Message msg : msgs) {
            titles.add(msg.getSubTitle());
        }
        return titles;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_weixin, menu);
    }


}
