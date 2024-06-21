package dev.ultreon.xypercode.mods;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final Item CUSTOM_ITEM = new Item(new Item.Properties());

    public static void registerItems() {
        Registry.register(BuiltInRegistries.ITEM, ResourceLocation.tryBuild(MyMod.MOD_ID, "custom_item"), CUSTOM_ITEM);
    }
}
