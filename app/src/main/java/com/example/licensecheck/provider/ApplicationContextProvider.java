package com.example.licensecheck.provider;

/**
 * Created by andrey on 17.06.18.
 * Using:
 * public static void someMethod() {
 *     Context context = App.getContext();
 * }
 *
 *
 * AndroidManifest.xml:
 * <application
 *      android:allowBackup="true"
 *      android:icon="@mipmap/ic_launcher"
 *      android:label="@string/app_name"
 *      android:supportsRtl="true"
 *      android:name=".ApplicationContextProvider"<<<<<<<<<<<<<<
 *      android:theme="@style/AppTheme">
 */
import android.app.Application;
import android.content.Context;

public class ApplicationContextProvider extends Application {

/*    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }*/

    /**
     * Keeps a reference of the application context
     */
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }

    /**
     * Returns the application context
     *
     * @return application context
     */
    public static Context getContext() {
        return sContext;
    }

}
