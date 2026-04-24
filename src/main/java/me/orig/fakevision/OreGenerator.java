package me.orig.fakevision;

import org.bukkit.*;
import org.bukkit.block.Block;

import java.util.Random;

public class OreGenerator {

    private final Main plugin;
    private final Random random = new Random();

    public OreGenerator(Main plugin) {
        this.plugin = plugin;
    }

    public void generateNoise() {

        World world = Bukkit.getWorlds().get(0);

        int amount = 400;
        int radius = 1000;

        for (int i = 0; i < amount; i++) {

            int x = random.nextInt(radius * 2) - radius;
            int z = random.nextInt(radius * 2) - radius;
            int y = random.nextInt(45) + 5;

            Block block = world.getBlockAt(x, y, z);

            if (block.getType() == Material.STONE) {
                if (random.nextDouble() < 0.35) {
                    block.setType(getFakeOre());
                }
            }
        }

        plugin.getLogger().info("視覺礦污染完成");
    }

    private Material getFakeOre() {
        Material[] pool = {
                Material.DIAMOND_ORE,
                Material.DIAMOND_ORE,
                Material.EMERALD_ORE,
                Material.GOLD_ORE,
                Material.REDSTONE_ORE,
                Material.IRON_ORE
        };

        return pool[random.nextInt(pool.length)];
    }
}
