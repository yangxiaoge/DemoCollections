package com.yang.bruce.newmiui;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/14 9:19
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class SysDialog {
    static AlertDialog alertDialog;

    public static  void showMsgDia(final Context context)
        {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            alertDialog = dialogBuilder.create();
            LayoutInflater inflaterDl = LayoutInflater.from(context);
            LinearLayout layout = (LinearLayout) inflaterDl.inflate(R.layout.login_dialog_finish_app, null);
            alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
            alertDialog.show();//关键位置
            alertDialog.getWindow().setContentView(layout);//关键位置

            // 取消按钮

            Button btnCancel = (Button) layout.findViewById(R.id.btn_cancle);
            btnCancel.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    alertDialog.dismiss();
                    Toast.makeText(context, "取消", Toast.LENGTH_SHORT).show();
                }
            });

        }

}
