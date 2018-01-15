package team.zhuoke.sdk.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;

import team.zhuoke.sdk.utils.SdkUtils;


/**
 * @author Yunr
 * @date 2018/01/15 10:56
 */
public class ZKBaseDialog extends AlertDialog.Builder {

    private AlertDialog dialog;

    public ZKBaseDialog(@NonNull Context context) {
        super(context);
    }

    public ZKBaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public AlertDialog create() {
        setPositiveButton("复制", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                copy();
            }
        });
        setNegativeButton("分享", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                share();
            }
        });
        dialog = super.create();
        return dialog;
    }

    void copy() {
        TextView mTitleView = dialog.findViewById(android.support.v7.appcompat.R.id.alertTitle);
        TextView mMessageView = dialog.findViewById(android.R.id.message);
        SdkUtils.copyText(mTitleView.getText().toString(), mMessageView.getText().toString(), getContext());
        Log.e("-----",mTitleView.getText().toString() + "|||" + mMessageView.getText().toString());
    }

    void share() {

    }
}