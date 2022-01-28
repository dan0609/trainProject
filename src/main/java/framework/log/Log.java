package framework.log;

import framework.trigger.Trigger;

public class Log {
    public static void debug(String tag, String msg) {
        if (Trigger.DEBUG) {
            System.out.println("debug:" + tag + " " + msg);
        }
    }

    public static void info(String tag, String msg) {

        System.out.println("info:" + tag + " " + msg);
    }
}
