package net.s0larj.prismium.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.s0larj.prismium.item.ModItems;
import net.s0larj.prismium.util.ModTags;

import java.util.List;

public class MagicBlock extends Block {

    public MagicBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }

    @Override
    //when an entity lands on this block, run method
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        //is the entity an item?
        if(entity instanceof ItemEntity itemEntity){
            //is the item prismarite?
            if(isValidItem(itemEntity.getStack())){
                //turn prismarite into prismium
                itemEntity.setStack(new ItemStack(ModItems.PRISMIUM, itemEntity.getStack().getCount()));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    private boolean isValidItem(ItemStack stack) {
        return stack.isIn(ModTags.Items.TRANSFORMABLE_ITEMS);
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {

        tooltip.add(Text.translatable("tooltip.prismium.magic_block.tooltip"));
        tooltip.add(Text.translatable("tooltip.prismium.magic_block.tooltip.2"));

        super.appendTooltip(stack, context, tooltip, options);
    }
}
