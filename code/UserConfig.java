import android.content.Context;
import android.content.SharedPreferences;


public class UserConfig {

    public static void saveStartMode(Context context, boolean isAuto) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("AutoStart", isAuto);
        editor.commit();
    }

    public static boolean getStartMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return preferences.getBoolean("AutoStart", false);
    }

    public static void saveConnectMode(Context context, int mode) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("ConnectMode", mode);
        editor.commit();
    }

    public static int getConnectMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return preferences.getInt("ConnectMode", 0);
    }


    public static void saveiPhoneMode(Context context, int mode) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("ConnectMode", mode);
        editor.commit();
    }

    public static int getiPhoneMode(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return preferences.getInt("ConnectMode", 0);
    }

}