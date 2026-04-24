package me.orig.fakevision;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    private OreGenerator generator;

    @Override
    public void onEnable() {
        instance = this;

        generator = new OreGenerator(this);
        generator.generateNoise();

        getLogger().info("FakeVisionOre 已啟動（支援 1.21.11）");
    }

    public static Main getInstance() {
        return instance;
    }
}
