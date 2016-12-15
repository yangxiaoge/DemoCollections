package com.yang.bruce.newmiui;

import android.content.Context;
import android.support.v7.app.AlertDialog;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/12 16:36
 *      Email: yang.jianan@zte.com.cn
 *      Desc:
 * </pre>
 */
public class ShowDialogForNetWorkState {
    static AlertDialog.Builder builder;
    static AlertDialog dialog;

    public static void showDialog(Context context, String msg) {
        //hideDialog(); //先判断当前 有没有dialog在展示中!

        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(msg);
        dialog = builder.create();
        //dialog.setCancelable(false);
        dialog.show();
    }

    public static void hideDialog() {
        if (dialog != null && builder != null) {
            dialog.dismiss();
        }
    }
}
