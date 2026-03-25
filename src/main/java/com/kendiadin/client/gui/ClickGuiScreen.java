package com.kendiadin.client.gui;

import com.kendiadin.client.modules.Module;
import com.kendiadin.client.modules.ModuleManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

public class ClickGuiScreen extends Screen {
    public ClickGuiScreen() {
        super(Text.literal("Click GUI"));
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        // Arka planı karart
        this.renderInGameBackground(context);

        int yOffset = 40; // Butonların başlayacağı yükseklik

        // ModuleManager içindeki tüm modülleri listele
        for (Module m : ModuleManager.getModules()) {
            // Modül açıksa YEŞİL, kapalıysa KIRMIZI renk yap
            int color = m.isEnabled() ? 0xFF00FF00 : 0xFFFF0000;
            
            // Buton kutusunu çiz (Basit bir dikdörtgen)
            context.fill(20, yOffset, 120, yOffset + 20, 0x80000000); // Siyah şeffaf arka plan
            
            // Modül adını yaz
            context.drawTextWithShadow(this.textRenderer, m.getName(), 25, yOffset + 5, color);
            
            yOffset += 25; // Bir sonraki buton için aşağı kay
        }

        super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        int yOffset = 40;

        for (Module m : ModuleManager.getModules()) {
            // Eğer fare tıklanan koordinat butonun üzerindeyse
            if (mouseX >= 20 && mouseX <= 120 && mouseY >= yOffset && mouseY <= yOffset + 20) {
                m.toggle(); // Modülü aç veya kapat
                return true;
            }
            yOffset += 25;
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
