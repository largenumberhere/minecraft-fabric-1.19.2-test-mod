package com.largenumberhere.fabrictest1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;


public class ModItemsRegisry implements  ModInitializer  {
    public static ModItemsRegisry create() {
        return new ModItemsRegisry();
    }

    private ModItemsRegisry() {}

    private static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("test1", "test1_group"))
            .icon(() -> new ItemStack(Items.APPLE))
            .build();

    public  static final Item SUBSTANCE = ItemRegisterFactory.INSTANCE.register("substance",Item::new, (new Item.Settings()).group(ITEM_GROUP));


    @Override
    public void onInitialize() {
        Test1.LOGGER.info("items registered");
    }


}