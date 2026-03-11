package net.s0larj.prismium.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.sound.BlockSoundGroup;
import net.s0larj.prismium.Prismium;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.block.custom.MagicBlock;

public class ModBlocks {

    public static final Block PRISMIUM_BLOCK = registerBlock("prismium_block", new Block(AbstractBlock.Settings.create().strength(5f).
            requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block PRISMARITE_BLOCK = registerBlock("prismarite_block", new Block(AbstractBlock.Settings.create().strength(5f).
            requiresTool().sounds(BlockSoundGroup.METAL)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block", new MagicBlock(AbstractBlock.Settings.create().strength(1f)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Prismium.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Prismium.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks(){
        Prismium.LOGGER.info("Registering Mod Blocks for " + Prismium.MOD_ID);
        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PRISMIUM_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.PRISMARITE_BLOCK);
        });
         */
    }
}
