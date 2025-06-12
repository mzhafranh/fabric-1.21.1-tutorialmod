package com.zxmasq.tutorialmod.item;

import com.zxmasq.tutorialmod.TutorialMod;
import com.zxmasq.tutorialmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup COMMONIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "commonium_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.COMMONIUM))
                    .displayName(Text.translatable("itemgroup.tutorialmod.commonium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COMMONIUM);
                        entries.add(ModItems.RAW_COMMONIUM);
                    }).build());

    public static final ItemGroup COMMONIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "commonium_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.COMMONIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.commonium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.COMMONIUM_BLOCK);
                        entries.add(ModBlocks.COMMONIUM_ORE);
                        entries.add(ModBlocks.COMMONIUM_DEEPSLATE_ORE);
                    }).build());

    public static void registerItemGroups(){
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }
}
