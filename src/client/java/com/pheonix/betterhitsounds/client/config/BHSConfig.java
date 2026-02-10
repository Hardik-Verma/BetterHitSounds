package com.pheonix.betterhitsounds.client.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Files;
import java.nio.file.Path;

public class BHSConfig {

    private static final Gson GSON =
            new GsonBuilder().setPrettyPrinting().create();

    private static final Path FILE =
            FabricLoader.getInstance()
                    .getConfigDir()
                    .resolve("betterhitsounds.json");

    public static BHSConfig INSTANCE = new BHSConfig();

    // ✅ Minimal, stable config
    public boolean enabled = true;
    public float volume = 1.0f;
    public float maxHearDistance = 16.0f;

    public static void load() {
        try {
            if (Files.exists(FILE)) {
                INSTANCE = GSON.fromJson(
                        Files.readString(FILE),
                        BHSConfig.class
                );
            }
            save();
        } catch (Exception e) {
            INSTANCE = new BHSConfig();
        }
    }

    public static void save() {
        try {
            Files.writeString(FILE, GSON.toJson(INSTANCE));
        } catch (Exception ignored) {}
    }
}
