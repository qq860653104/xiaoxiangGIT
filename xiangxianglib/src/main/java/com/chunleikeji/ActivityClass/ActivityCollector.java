package com.chunleikeji.ActivityClass;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }

        /**
         * ActivityCollector.addActivity(this);  放在需要一同finish的Activity的onCreate中
         * ActivityCollector.finishAll();        一句话finish多个Activity,放在跳转
         * */
    }
}
