package team.zhuoke.sdk.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


/**
 * BaseActivity
 * <p>
 * Created by WangQing on 2017/10/28.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    protected TextView mTitle;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mContext = this;

        initViews();
        initListener();
        initData();
    }


    //获取资源ID
    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initListener();

    protected abstract void initData();

    protected void initToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        //  设置了左上角的返回按钮
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    protected void setVisibility(View view, boolean isShow) {
        if (view != null) {
            view.setVisibility(isShow ? VISIBLE : GONE);
        }
    }

}