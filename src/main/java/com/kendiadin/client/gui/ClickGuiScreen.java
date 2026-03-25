package com.kendiadin.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Click GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Ekranın arka planını hafif siyah yapar
        this.renderBackground(context, mouseX, mouseY, delta);
        
        // Ekrana bir yazı yazdıralım (Test amaçlı)
        context.drawCenteredTextWithShadow(this.textRenderer, "MY CUSTOM CLIENT MENU", this.width / 2, 20, 0xFFFFFF);
        
        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean shouldPause() {
        return false; // Menü açılınca oyunun durmamasını sağlar
    }
}

