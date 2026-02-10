package com.pheonix.betterhitsounds.client.sound;

import net.minecraft.entity.Entity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ComboTracker {

    private static final Map<UUID, Integer> COMBOS = new HashMap<>();
    private static final Map<UUID, Integer> TIMERS = new HashMap<>();

    private static final int RESET_TICKS = 12;

    public static int hit(Entity entity) {
        UUID id = entity.getUuid();
        int combo = COMBOS.getOrDefault(id, 0) + 1;

        COMBOS.put(id, combo);
        TIMERS.put(id, RESET_TICKS);

        return combo;
    }

    public static void tick() {
        TIMERS.entrySet().removeIf(entry -> {
            int t = entry.getValue() - 1;
            if (t <= 0) {
                COMBOS.remove(entry.getKey());
                return true;
            }
            entry.setValue(t);
            return false;
        });
    }
}
