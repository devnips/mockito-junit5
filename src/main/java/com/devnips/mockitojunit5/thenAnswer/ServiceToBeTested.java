package com.devnips.mockitojunit5.thenAnswer;

public class ServiceToBeTested {

    private final ServiceToBeMocked serviceToBeMocked;

    public ServiceToBeTested(ServiceToBeMocked serviceToBeMocked) {
        this.serviceToBeMocked = serviceToBeMocked;
    }

    public String methodToBeTested() {
        Callback callback = new Callback();
        serviceToBeMocked.submitCallback(callback);

        return "Value Received after callback = " + callback.getValue();
    }
}
