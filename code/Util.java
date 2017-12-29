package demo.hdz.rtspdemo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by admin on 2017/12/27.
 */

public class Util {
    //将得到的int类型的IP转换为String类型
    public static String intToIP(int i) {

        return ( (i >> 0)  & 0xFF ) + "." +
                ( (i >> 8)  & 0xFF ) + "." +
                ( (i >> 16) & 0xFF ) + "." +
                ( (i >> 24) & 0xFF ) ;
    }

    public static void alert(Context context, final String msg) {
        final String error = (msg == null) ? "Error unknown" : msg;
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(error).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {}
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
