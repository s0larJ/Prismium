package net.s0larj.prismium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.s0larj.prismium.block.ModBlocks;
import net.s0larj.prismium.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.PRISMIUM_BLOCK);
        addDrop(ModBlocks.PRISMARITE_BLOCK, oreDrops(ModBlocks.PRISMARITE_BLOCK, ModItems.PRISMARITE));
    }
}
