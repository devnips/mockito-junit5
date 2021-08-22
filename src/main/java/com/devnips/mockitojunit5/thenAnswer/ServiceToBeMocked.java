package com.devnips.mockitojunit5.thenAnswer;

public class ServiceToBeMocked {

    public void submitCallback(Callback callback) {
        //some logic that sets value back in callback.
        callback.setValue(null);
    }
}
