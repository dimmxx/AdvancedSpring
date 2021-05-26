package org.example.controller;

public class ProfilingController implements ProfilingControllerMBean {

    public boolean enabled = true;

    public ProfilingController() {
    }

    public ProfilingController(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
