package com.supchikwork;

import net.fabricmc.api.ModInitializer;
import com.supchikwork.wyhConfig;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


import net.minecraft.entity.LivingEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class maincos implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("whatyouheath");

    public static final whyuheathconfig CONFIG = whyuheathconfig.createAndLoad();

    public static Text appendHP(PlayerEntity player, Text text) {


        String Nametag = CONFIG.HealthIndicator().replace("&","§") + String.valueOf( player.getHealth () );

        if ( CONFIG.ArmorShow () ) {

        Nametag = Nametag + CONFIG.ArmorIndicator().replace("&","§") + String.valueOf( player.getArmor  () );

        }


        MutableText tier = Text.of(Nametag).copy();


        if (tier != null) {
            tier.append(Text.of("§r§7 | §r").copy());
            return tier.append(text);
        }

        return text;
    }



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}
