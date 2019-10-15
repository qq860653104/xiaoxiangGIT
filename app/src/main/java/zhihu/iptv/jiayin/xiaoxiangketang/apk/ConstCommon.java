package zhihu.iptv.jiayin.xiaoxiangketang.apk;


public class ConstCommon {
        //http://39.105.70.121/test3/v3final/
    //
    public static String apkName="http://v3tv.sieget.com/v3final/chuanbojiekou/think_test/public/index.php/index/index/getAppInfo?name=";
//    public static String BASE_URL="http://39.105.70.121/test3/v3final/chuanbojiekou/think_test/public/index.php/index/index/";
//    public static String MAIN_URL="getHomeJson2";
//    public static String getMainUrl(String sin){
//        return BASE_URL+MAIN_URL+"?mac="+getSerial()+"&sin="+sin;
//    }


//    public static String getSerial(){
//        String wifi_mac = (String) SPUtils.get(QuanWangTong.globalVar, "WIFI_MAC", "");
////        String wifi_mac = zhihu.iptv.jiayin.zhihuiptv.apk.SPUtils.get(QuanBuActivity)
//        String ethernetAddress = getEthernetAddress();
//        if(!TextUtils.isEmpty(ethernetAddress)){
//            SPUtils.put(QuanWangTong.globalVar,"WIFI_MAC",ethernetAddress);
//            return ethernetAddress;
//        }
//        if (TextUtils.isEmpty(wifi_mac)) {
//            WifiManager wifiManager = (WifiManager)QuanWangTong.globalVar.getSystemService(Context.WIFI_SERVICE);
//            WifiInfo info = (null==wifiManager)?null:wifiManager.getConnectionInfo();
//            if(null != info){
//                wifi_mac = info.getMacAddress();
//                SPUtils.put(QuanWangTong.globalVar,"WIFI_MAC",wifi_mac);
//            }
//        }
//            return wifi_mac;
//
//    }
//
//    private static String getEthernetAddress() {
//        try {
//            return loadFileAsString("/sys/class/net/eth0/address").toUpperCase(Locale.ENGLISH).substring(0, 17);
//        } catch (IOException e) {
//            return null;
//        }
//    }
//
//    private static String loadFileAsString(String filePath) throws IOException{
//        StringBuffer fileData = new StringBuffer(1000);
//        BufferedReader reader = new BufferedReader(new FileReader(filePath));
//        char[] buf = new char[1024]; int numRead=0;
//        while((numRead=reader.read(buf)) != -1){
//            String readData = String.valueOf(buf, 0, numRead);
//            fileData.append(readData);
//        }
//        reader.close();
//        return fileData.toString();
//    }
}
