private void addBluetoothMac() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("请输入蓝牙地址");    //设置对话框标题
    builder.setIcon(R.drawable.logo);      //设置对话框标题前的图标

    final EditText edit = new EditText(this); //创建EditText输入框
    builder.setView(edit);                    //输入框赋值给Dialog
    
    //增加确定和取消按钮
    builder.setPositiveButton("确认", null);
    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    });

    builder.setCancelable(false);                 //设置按钮是否可以按返回键取消,false则不可以取消
    final AlertDialog dialog = builder.create();  //创建对话框
    dialog.setCanceledOnTouchOutside(false);      //设置弹出框失去焦点是否隐藏,即点击屏蔽其它地方是否隐藏
    
    dialog.show();                                //显示对话框，这里必须要先调show()方法，后面的getButton才有效 

    //处理确认按钮
    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String mac = edit.getText().toString(); //获取输入框的内容
            
            //正则校验蓝牙MAC合法性
            String patternMac="^[a-fA-F0-9]{2}(:[a-fA-F0-9]{2}){5}$";
            if(!Pattern.compile(patternMac).matcher(mac).find()){
                Toast.makeText(MainActivity.this, "蓝牙地址不合法", Toast.LENGTH_SHORT).show();
                return;
            }
            
            //输入合法，做其他处理
            //。。。
            
            dialog.dismiss(); //退出对话框
        }
    });
}

/*在创建AlertDialog时setPositiveButton方法的OnClickListener参数需传入null，
然后让dialog show出来以后，再通过getButton(AlertDialog.BUTTON_POSITIVE)方法
重新得到确定按钮，重设点击事件，这时如果不手动去调dialog.dismiss()，对话框就不会消失了。*/

