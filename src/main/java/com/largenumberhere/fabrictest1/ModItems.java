package com.largenumberhere.fabrictest1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import java.util.function.Function;

public class ModItems implements  ModInitializer  {
    public  static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // new item key
        RegistryKey<Item> itemKey = RegistryKey.of(Registry.ITEM.getKey(), Identifier.of(Test1.MOD_ID, name));

        // new item instance
        Item item = itemFactory.apply(settings);

        // register item
        Registry.register(Registry.ITEM, itemKey, item);

        return  item;
    }


    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("test1", "test1_group"))
            .icon(() -> new ItemStack(Items.APPLE))
            .build();

    public  static final Item SUBSTANCE = register("subtance", Item::new, (new Item.Settings()).group(ITEM_GROUP));


    @Override
    public void onInitialize() {
//        ModItems modItems = ModItems.create();
//        Test1.LOGGER.debug("initialized");
        Test1.LOGGER.debug("initialized");
    }

    public static ModItems create() {
        return new ModItems();
    }




}