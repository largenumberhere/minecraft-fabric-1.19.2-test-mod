package com.largenumberhere.fabrictest1;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.function.Function;

public class ItemRegisterFactory {
    public static final ItemRegisterFactory INSTANCE = new ItemRegisterFactory();
    private  ItemRegisterFactory() {}
    public Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // new item key
        RegistryKey<Item> itemKey = RegistryKey.of(Registry.ITEM.getKey(), Identifier.of(Test1.MOD_ID, name));

        // new item instance
        Item item = itemFactory.apply(settings);

        // register item
        Registry.register(Registry.ITEM, itemKey, item);

        return  item;
    }

}
