package com.yang.bruce.newmiui.webview_progress;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.yang.bruce.newmiui.NoDoubleClickUtils;
import com.yang.bruce.newmiui.R;
import com.yang.bruce.newmiui.permission.PermissionsActivity;
import com.yang.bruce.newmiui.permission.PermissionsChecker;

import me.yokeyword.fragmentation.SupportActivity;

public class WebViewProgressActivity extends SupportActivity {
    Button doubleClick;
    Button button;
    Button toWebView;
    EditText editText;
    private Uri uriData = Uri.parse("content://com.android.contacts/data");

    // 获取联系人信息的权限请求返回 code
    private static final int REQUEST_CODE = 0; // 请求码
    static final String[] PERMISSIONS = new String[]{Manifest.permission.READ_CONTACTS};
    private PermissionsChecker mPermissionsChecker;// 权限检测器
    private boolean allowToReadContacts; //授权成功标识

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPermissionsChecker = new PermissionsChecker(this);

        doubleClick = (Button) findViewById(R.id.double_click);
        button = (Button) findViewById(R.id.button);
        toWebView = (Button) findViewById(R.id.to_webview);
        editText = (EditText) findViewById(R.id.editText);

        // 获取联系人号码
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(WebViewProgressActivity.this, "android 6.0要在代码中判断申请权限!! 不然直接crash~~",
                        Toast.LENGTH_LONG).show();
                editText.setText("");   //做跳转之前先把电话号码清空
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    // 缺少权限时, 进入权限配置页面
                    if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
                        PermissionsActivity.startActivityForResult(WebViewProgressActivity.this, REQUEST_CODE, PERMISSIONS);
                    } else {
                        toGetContactsNumber();
                    }

                } else {
                    toGetContactsNumber();
                }

            }
        });

        doubleClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!NoDoubleClickUtils.isDoubleClick()) {
                    Toast.makeText(WebViewProgressActivity.this, "多次点击了!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //进度条WebView
        toWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WebViewProgressActivity.this, MainWebViewActivity.class);
//                intent.putExtra("url", "http://www.jianshu.com/users/25f8193d5561/");
                intent.putExtra("url", "http://blog.csdn.net/qq_20785431/article/details/51599073");
                intent.putExtra("title", "我的博客");
                startActivity(intent);
            }
        });
    }

    private void toGetContactsNumber() {
        //查询系统联系人
        Intent intent = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 2); // requestCode设置成 2,跟权限的区分开
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Lack permission to read phone state");
            builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    allowToReadContacts = false;

                }
            });
            builder.setCancelable(false);
            builder.create().show();
        } else {
            allowToReadContacts = true;

        }

        if (requestCode == 2) { //请求码为 2
            String strNumber = "";
            if (data != null) {  //判断返回的intent是不是为空

                Uri uri = data.getData();
                Log.i("info", uri.toString());  //在log打印出来获取的uri
                Cursor cursor = getContentResolver().query(uri, null, null, null, null);
                while (cursor.moveToNext()) {
                    String strID = cursor.getString(cursor.getColumnIndex("name_raw_contact_id"));
                    Cursor cursor2 = getContentResolver().query(uriData, null,
                            "raw_contact_id = " + strID + " and mimetype_id = 5", null, null);
                    if (cursor2.moveToFirst()) {
                        strNumber = cursor2.getString(cursor2.getColumnIndex("data1"));
                        strNumber = strNumber.replace(" ", "");
                        strNumber = strNumber.replace("-", "");
                    }
                    cursor2.close();
                }
                cursor.close();
                editText.setText(strNumber);

            }

        }

    }

}
