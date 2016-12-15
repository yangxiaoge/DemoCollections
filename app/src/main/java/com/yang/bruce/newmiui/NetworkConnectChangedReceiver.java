package com.yang.bruce.newmiui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

/**
 * <pre>
 *      Author: Yang.JiaNan
 *      Time: 2016/12/12 12:54
 *      Email: yang.jianan@zte.com.cn
 *      Desc: 监听网络的改变状态,只有在用户操作网络连接开关(wifi,mobile)的时候接受广播,
 *            然后对相应的界面进行相应的操作，并将 状态 保存在我们的APP里面
 * </pre>
 */
public class NetworkConnectChangedReceiver extends BroadcastReceiver {
    private static final String TAG = "yangyangyang";
    public static final String TAG1 = "xxx";
    SPUtils spUtils ;

    @Override
    public void onReceive(final Context context, Intent intent) {
        spUtils = new SPUtils(context,"showDialog");

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        dialogBuilder.setTitle("Warning");
        dialogBuilder .setMessage("You are forced to be offline. Please try to login again.");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "ok?", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        alertDialog.show();

/*        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Intent intenadsft = new Intent(context, TranslucetActivity.class);
            context.startActivity(intenadsft);
//            //对话框
//            AlertDialog.Builder builder = new AlertDialog.Builder(context);
//            builder.setTitle("警告");
//            //正文
//            builder.setMessage("你已被强制下线，请重新登陆。");
//            //不可取消
//            builder.setCancelable(false);
//
//            AlertDialog alterDialog = builder.create();
//            //添加对话框类型：保证在广播中正常弹出
//            alterDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
//            //对话框展示
//            alterDialog.show();
        }*/
        // 这个监听网络连接的设置，包括wifi和移动数据的打开和关闭。.
        // 最好用的还是这个监听。wifi如果打开，关闭，以及连接上可用的连接都会接到监听。见log
        // 这个广播的最大弊端是比上边两个广播的反应要慢，如果只是要监听wifi，我觉得还是用上边两个配合比较合适
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            Intent intenadsft = new Intent(context, TranslucetActivity.class);
            context.startActivity(intenadsft);
            ConnectivityManager manager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            Log.i(TAG1, "CONNECTIVITY_ACTION");
            NetworkInfo activeNetwork = manager.getActiveNetworkInfo();
            if (activeNetwork != null) { // connected to the internet
                if (activeNetwork.isConnected()) {

                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        // connected to wifi
                        Log.e(TAG, "当前WiFi finish ");
                        //SysDialog.showMsgDia(context);
                        Toast.makeText(context.getApplicationContext(), "WiFi finish", Toast.LENGTH_SHORT).show();
                        spUtils.putBoolean("show",false);
                        EventBus.getDefault().post(new ChangeProfileEventBean(true,false));

                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        // connected to the mobile provider's data plan
                        //MCC(3位)+MNC(2位)
                        EventBus.getDefault().post(new ChangeProfileEventBean(true,true));
                        Log.e(TAG, "当前 mpt finish ");
                        TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                        if (telManager.getNetworkOperator().equals("41401") && telManager.getSubscriberId().startsWith("40401")) {
                            Toast.makeText(context, "mpt", Toast.LENGTH_SHORT).show();
                        }
                      else {
                            Log.e(TAG, "当前非mpt finish ");
                            EventBus.getDefault().post(new ChangeProfileEventBean(true,false));
                            Toast.makeText(context, "非mpt finish", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Log.e(TAG, "当前无网络 finish ");
                    EventBus.getDefault().post(new ChangeProfileEventBean(true,false));
                    Toast.makeText(context, "无网络 finish", Toast.LENGTH_SHORT).show();
                }

                Log.e(TAG1, "info.getTypeName()" + activeNetwork.getTypeName());
                Log.e(TAG1, "getSubtypeName()" + activeNetwork.getSubtypeName());
                Log.e(TAG1, "getState()" + activeNetwork.getState());
                Log.e(TAG1, "getDetailedState()"
                        + activeNetwork.getDetailedState().name());
                Log.e(TAG1, "getDetailedState()" + activeNetwork.getExtraInfo());
                Log.e(TAG1, "getType()" + activeNetwork.getType());
            } else {   // not connected to the internet
                Log.e(TAG, "当前没有网络连接，请确保你已经打开网络 ");
                Toast.makeText(context, "无网络 finish", Toast.LENGTH_SHORT).show();
                EventBus.getDefault().post(new ChangeProfileEventBean(true,false));
                //android.os.Process.killProcess(android.os.Process.myPid());
//                ShowDialogForNetWorkState.hideDialog();

                spUtils.putBoolean("show",true);
            }

        }
    }
}
