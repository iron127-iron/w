package me.orig.fakevision;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private OreGenerator generator;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        generator = new OreGenerator(this);
        generator.generateNoise();
        getLogger().info("FakeVisionOre 已啟動");
    }

    public static Main getInstance() {
        return instance;
    }
}
