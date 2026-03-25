package com.kendiadin.client.modules;

import net.minecraft.client.MinecraftClient;

public class FullBright extends Module {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public FullBright() {
        super("FullBright");
    }

    @Override
    public void onEnable() {
        // Parlaklığı 100 katına çıkar (Gece görüşü etkisi)
        mc.options.getGamma().setValue(100.0);
    }

    @Override
    public void onDisable() {
        // Parlaklığı normale döndür
        mc.options.getGamma().setValue(1.0);
    }
}
