package com.deli.newsdemo.ui.newsdetails;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.deli.newsdemo.R;
import com.deli.newsdemo.mvpframe.base.BaseFrameFragment;
import com.deli.newsdemo.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @auther : qiudeli QQ:364978880
 * @date : 2017/7/23 15:13
 * @describe :
 */

public class NewsDetailsFragment extends BaseFrameFragment<NewsDetailsPresenter, NewsDetailsModel>
        implements NewsDetailsContract.View {

    @BindView(R.id.btn_back)
    Button btn_back;
    @BindView(R.id.close_all)
    Button btn_close_all;

    public static final String TAG = "NewsDetailsFragment";

    private MainActivity mCallback;

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_news_details);
        unbinder = ButterKnife.bind(this, getContentView());
        setFragmentId(R.id.container);

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initView() {
        super.initView();
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(TAG, "im details");
                mCallback = (MainActivity) getActivity();
                mCallback.onMessage(bundle, TAG);
            }
        });
        btn_close_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(TAG, "im details");
                mCallback = (MainActivity) getActivity();
                mCallback.onMessage(bundle, "back");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }

}