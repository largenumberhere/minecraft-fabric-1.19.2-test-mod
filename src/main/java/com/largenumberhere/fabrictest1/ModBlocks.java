package com.largenumberhere.fabrictest1;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;


public class ModBlocks implements ModInitializer {
    public static ModBlocks create() {
        return new ModBlocks();
    }

    private ModBlocks() {}

    public  static final Block TEST_BLOCK = BlockRegisterFactory.INSTANCE.register(
            "test_block",
            AbstractBlock.Settings.of(Material.AMETHYST)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );

    @Override
    public void onInitialize() {
        Test1.LOGGER.info("blocks registered");
    }
}
