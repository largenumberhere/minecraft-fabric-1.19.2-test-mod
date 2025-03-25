package com.largenumberhere.fabrictest1;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.function.Function;

public class BlockRegisterFactory {
    public static final BlockRegisterFactory INSTANCE = new BlockRegisterFactory();

    private BlockRegisterFactory() {
    }

    public Block register(String name, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        return register(name, Block::new, settings, shouldRegisterItem);
    }

    public Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
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

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(Registry.ITEM.getKey(), Identifier.of(Test1.MOD_ID, name));
    }

}