package org.HRMFwk.Utils;
import java.io.IOException;

public class AutoITUtil {
    public static void runAutoITScript(String scriptPath) {
        try {
            Process process = Runtime.getRuntime().exec(scriptPath);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runAutoITScriptWithParams(String scriptPath, String params) {
        try {
            Process process = Runtime.getRuntime().exec(scriptPath + " " + params);
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}