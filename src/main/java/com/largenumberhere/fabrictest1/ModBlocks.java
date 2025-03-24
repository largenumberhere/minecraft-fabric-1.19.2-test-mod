package com.largenumberhere.fabrictest1;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.function.Function;

public class ModBlocks implements ModInitializer {
    public static ModBlocks create() {
        return new ModBlocks();
    }
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings);

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registry.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registry.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(Registry.BLOCK.getKey(), Identifier.of(Test1.MOD_ID, name));
    }

    private  static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(Registry.ITEM.getKey(), Identifier.of(Test1.MOD_ID, name));
    }

    public  static final Block TEST_BLOCK = register(
            "test_block",
            Block::new,
            AbstractBlock.Settings.of(Material.AMETHYST).sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true

    );


    @Override
    public void onInitialize() {}
}
