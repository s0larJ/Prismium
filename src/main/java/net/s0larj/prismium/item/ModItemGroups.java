package net.s0larj.prismium.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.Prismium;
import net.s0larj.prismium.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup PRISMIUM_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prismium.MOD_ID, "prismium_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PRISMIUM_BLOCK))
                    .displayName(Text.translatable("itemgroup.prismium.prismium_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.PRISMIUM_BLOCK);
                        entries.add(ModBlocks.PRISMARITE_BLOCK);
                        entries.add(ModBlocks.MAGIC_BLOCK);
                    })
                    .build());

    public static final ItemGroup PRISMIUM_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Prismium.MOD_ID, "prismium_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PRISMIUM))
                    .displayName(Text.translatable("itemgroup.prismium.prismium_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PRISMIUM);
                        entries.add(ModItems.PRISMARITE);
                        entries.add(ModItems.CHISEL);
                    })
                    .build());

    public static void registerItemGroups() {
        Prismium.LOGGER.info("Registering Item Groups for " + Prismium.MOD_ID);
    }
}
