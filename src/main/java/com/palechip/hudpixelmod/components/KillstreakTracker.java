package com.palechip.hudpixelmod.components;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.util.EnumChatFormatting;

public class KillstreakTracker implements IComponent {
    private int currentKillstreak;
    private int greatestKillstreak;
    
    private boolean showGreatest;
    
    private final String CURRENT_KILLSTREAK_DISPLAY_TEXT = EnumChatFormatting.DARK_PURPLE + "Killstreak: ";
    private final String GREATEST_KILLSTREAK_DISPLAY_TEXT = EnumChatFormatting.LIGHT_PURPLE + "Best Killstreak: ";

    @Override
    public void setupNewGame() {
        //reset
        this.currentKillstreak = 0;
        this.greatestKillstreak = 0;
        this.showGreatest = false;
    }

    @Override
    public void onGameEnd() {
        this.showGreatest = true;
    }

    @Override
    public void onChatMessage(String textMessage, String formattedMessage) {
        String username = FMLClientHandler.instance().getClient().getSession().getUsername();
        // Quake
        if(textMessage.contains(username + " gibbed ")) {
            this.currentKillstreak++;
            if(this.currentKillstreak > this.greatestKillstreak) {
                this.greatestKillstreak = this.currentKillstreak;
            }
        } else if(textMessage.contains(" gibbed " + username)) {
            this.currentKillstreak = 0;
        }
    }

    @Override
    public String getRenderingString() {
        if(this.showGreatest) {
            return GREATEST_KILLSTREAK_DISPLAY_TEXT + this.greatestKillstreak;
        } else {
            return CURRENT_KILLSTREAK_DISPLAY_TEXT + this.currentKillstreak;
        }
    }

    @Override
    public void onTickUpdate() { }
    
    @Override
    public void onGameStart() { }
}
