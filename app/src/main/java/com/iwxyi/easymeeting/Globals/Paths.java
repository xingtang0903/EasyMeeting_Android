package com.iwxyi.easymeeting.Globals;

import android.widget.Toast;

public class Paths {
    public static final String DATAPATH = "/EasyMeeting/";
    public static final String NETPATH = "http://iwxyi.com/thinkphp5/public/index.php/android/Client/"; // 网络路径
    public static final String PCIP = "192.168.43.135"; // 本机电脑IP，调试用 // 192.168.103.2 不知道为啥这个IP也可以诶？
    public static final String NETPATHD = "http://"+ PCIP +"/easymeeting/public/index.php/android/Client/"; // 调试

    public static String getNetpath(String action) {
        return NETPATH + action;
    }

    public static String getNetpath(String action, String[] arg) {
        StringBuilder url = new StringBuilder(NETPATH + action + "?");
        int count = arg.length;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                if (i > 0)
                    url.append("&");
                url.append(arg[i]).append("=");
            }
            else {
                url.append(arg[i]);
            }
        }
        return url.toString();
    }

    public static String getNetUser(String action, String[] arg) {
        String url = getNetpath(action, arg);
        if (arg.length == 0)
            url += "?";
        else
            url += "&";
        url += "user=" + User.user_id;
        return url;
    }
}
