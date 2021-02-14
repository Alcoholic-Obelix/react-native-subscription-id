package com.reactlibrary;

import android.annotation.TargetApi;
import android.os.Build;
import android.telephony.SubscriptionManager;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class SubscriptionIdModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    public SubscriptionIdModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "SubscriptionId";
    }

    @TargetApi(Build.VERSION_CODES.N)
    @ReactMethod
    public void getSubscriptionId(final Promise promise) {

        int id = 0;
        String idString = "";
        try {
            id = SubscriptionManager.getDefaultSubscriptionId();
            if(id != SubscriptionManager.INVALID_SUBSCRIPTION_ID) {
                idString = String.valueOf(id);
            }
        }catch(Exception err) {
            err.printStackTrace();
        }

        promise.resolve(idString);
    }
}
