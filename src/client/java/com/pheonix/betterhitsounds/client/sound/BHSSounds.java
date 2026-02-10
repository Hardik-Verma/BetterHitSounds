package com.pheonix.betterhitsounds.client.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class BHSSounds {

    private static final Map<String, SoundEvent> CACHE = new HashMap<>();

    public static SoundEvent get(String id) {
        return CACHE.computeIfAbsent(id, key ->
                SoundEvent.of(Identifier.of("betterhitsounds", key)));
    }

    public static String build(
            String pack,
            String type,
            boolean crit,
            String weapon,
            boolean isPlayer,
            int combo
    ) {
        if (type.equals("kill")) return pack + ".kill.player";
        if (type.equals("shield")) return pack + ".shield.break";

        if (combo >= 3) {
            return pack + ".combo.player." + weapon + "." + Math.min(combo, 5);
        }

        return pack + "." +
                (crit ? "crit" : "normal") + "." +
                (isPlayer ? "player" : "mob") + "." +
                weapon + ".hit";
    }
}
