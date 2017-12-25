
import android.util.Log;

/**
 * Created by hdz on 2017/12/23.
 */

public class Logger {
    public static void Debug(String tag, String log, boolean out) {
        if (out) {
            Debug(tag, log);
        }
    }
    public static void Debug(String tag, int log, boolean out) {
        if (out) {
            Debug(tag, log);
        }
    }
    public static void Debug(String log, boolean out) {
        if (out) {
            Debug(log);
        }
    }
    public static void Debug(int log, boolean out) {
        if (out) {
            Debug(log);
        }
    }

    public static void Debug(String tag, String log) {
        try {
            StackTraceElement[] a = new Throwable().getStackTrace();
            StackTraceElement ste = a[0];
            for (StackTraceElement anA : a) {
                if (!anA.getMethodName().equals("Debug")) {
                    ste = anA;
                    break;
                }
            }
            String  sClassName = ste.getClassName();
            String sMethodName = ste.getMethodName();
            int          iLine = ste.getLineNumber();
            String   sFileName = ste.getFileName();

            String sTmpClassName = "";
            int iPos = sClassName.lastIndexOf(".");
            if(iPos <=0 ) {
                sTmpClassName = sClassName;
            } else {
                sTmpClassName = sClassName.substring(iPos+1);
            }
            Log.d(tag, "[" + sFileName + ":" + iLine + " " + sTmpClassName + "::" + sMethodName + "] " + log);
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.d(tag, log);
        }
    }

    public static void Debug(String tag, int log) {
        Debug(tag, "" + log);
    }

    public static void Debug(String log) {
        Debug("MyLibstreaming", log);
    }

    public static void Debug(int log) {
        Debug(""+log);
    }


}
