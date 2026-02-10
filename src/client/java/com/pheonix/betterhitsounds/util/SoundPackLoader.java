package com.pheonix.betterhitsounds.util;

import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class SoundPackLoader {

    public static Map<String, String> loadPacks() {
        Map<String, String> packs = new HashMap<>();
        packs.put("default", "Default");
        packs.put("bass", "Bass Boosted");
        packs.put("clicky", "Clicky PvP");
        packs.put("soft", "Soft Hits");

        return packs;
    }

    public static boolean exists(String path) {
        Identifier id = Identifier.of("betterhitsounds", "sounds/" + path + ".ogg");
        return MinecraftClient.getInstance()
                .getResourceManager()
                .getResource(id)
                .isPresent();
    }
}
