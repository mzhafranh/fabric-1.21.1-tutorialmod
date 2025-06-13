package com.zxmasq.tutorialmod.item;

import com.zxmasq.tutorialmod.TutorialMod;
import com.zxmasq.tutorialmod.item.custom.GrassWandItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item ZX_LOGO = registerItem("zx_logo", new Item(new Item.Settings()));
    public static final Item RAW_COMMONIUM = registerItem("raw_commonium", new Item(new Item.Settings()));
    public static final Item COMMONIUM = registerItem("commonium", new Item(new Item.Settings()));

    public static final Item GRASS_WAND = registerItem("grass_wand", new GrassWandItem(new Item.Settings().maxDamage(250)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_COMMONIUM);
            entries.add(COMMONIUM);
        });
    }
}
