package com.kendiadin.client.modules;

public abstract class Module {
    private String name;
    private boolean enabled = false;

    public Module(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public boolean isEnabled() { return enabled; }

    public void toggle() {
        this.enabled = !this.enabled;
        if (enabled) onEnable(); else onDisable();
    }

    public abstract void onEnable();
    public abstract void onDisable();
}

