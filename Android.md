## 如果通过adb查看当前显示的activity
Linux下：
```adb shell dumpsys activity | grep "mFocusedActivity"```
Windows下：
```adb shell dumpsys activity | findstr "mFocusedActivity"```
但我在as的terminal上输入命令提示：'findstr' 不是内部或外部命令，也不是可运行的程序 或批处理文件。
而在cmd以管理员身份运行却成功输出当前显示的Activity

## Android界面无标题并且全屏

``` Java
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // requesting to turn the title OFF
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // making it full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
    }
}
```
如果MainActivity继承的是AppCompatActivity，那么App主题需要继承*.NoActionBar，如Theme.AppCompat.Light.NoActionBar。修改res/values/styles.xml文件即可，如下：
``` xml
<resources>

    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
```