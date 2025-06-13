package com.zxmasq.tutorialmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class GrassWandItem extends Item {
    public GrassWandItem(Settings settings) {
        super(settings);
    }

    private static final Map<Block, Block> GRASS_WAND_MAP =
            Map.of(
                    Blocks.DIRT, Blocks.GRASS_BLOCK,
                    Blocks.COARSE_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.ROOTED_DIRT, Blocks.GRASS_BLOCK,
                    Blocks.DIRT_PATH, Blocks.GRASS_BLOCK
            );

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (GRASS_WAND_MAP.containsKey(clickedBlock)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GRASS_WAND_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GRASS_PLACE, SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }
}
