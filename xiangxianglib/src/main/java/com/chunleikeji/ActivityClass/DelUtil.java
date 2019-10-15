package com.chunleikeji.ActivityClass;

import java.io.File;

public class DelUtil {
    public static  boolean DelUtil(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        int tag = tempList.length/4;
        for (int i = 0; i < tag; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                DelUtil(path + "/" + tempList[i]);// 删除文件夹里面的文件
                flag = true;
            }
        }
        return flag;
    }
}
