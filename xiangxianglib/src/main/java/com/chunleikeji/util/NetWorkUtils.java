package com.chunleikeji.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetWorkUtils {
    public static boolean isNetworkAvailable(Activity activity, NetISConnected netISConnected)
    {
        if (activity != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mInternetNetWorkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_ETHERNET);
            boolean hasInternet = !ObjectUtil.isNullObject(mInternetNetWorkInfo) && mInternetNetWorkInfo.isConnected() && mInternetNetWorkInfo.isAvailable();
           if(!hasInternet){
               return   isWiFiActive(activity);
           }else{
               return true;
           }
        }
        return false;
    }
    public static boolean isWiFiActive(Context inContext) {
        Context context = inContext.getApplicationContext();
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getTypeName().equals("WIFI") && info[i].isConnected()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public interface NetISConnected {
        public void hasNet();
        public void noNet();
    }
    public static class ObjectUtil {

        /**
         * 判断对象是否为空
         * @param object
         * @return
         */
        public static boolean isNullObject (Object object) {

            if (object == null) {
                return true;
            }

            return false;
        }
    }


}
