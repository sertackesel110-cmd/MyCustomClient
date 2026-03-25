package com.kendiadin.client;

import com.kendiadin.client.modules.ModuleManager;
import com.kendiadin.client.gui.ClickGuiScreen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ClientMain implements ModInitializer {
    @Override
    public void onInitialize() {
        // Sistemi başlat
        ModuleManager.init();

        // Her oyun "tick"inde (anında) tuş basılıp basılmadığını kontrol et
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            // Eğer oyun içindeysek ve bir menü açık değilse
            if (client.player != null && client.currentScreen == null) {
                // SAĞ SHIFT tuşuna basıldı mı kontrol et
                if (InputUtil.isKeyPressed(client.getWindow().getHandle(), GLFW.GLFW_KEY_RIGHT_SHIFT)) {
                    // Bizim menümüzü aç
                    client.setScreen(new ClickGuiScreen());
                }
            }
        });
    }
}

