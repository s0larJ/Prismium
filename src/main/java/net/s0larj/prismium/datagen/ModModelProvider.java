package net.s0larj.prismium.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.loader.impl.lib.sat4j.minisat.orders.VarOrderHeap;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.block.ModBlocks;
import net.s0larj.prismium.block.custom.LampBlock;
import net.s0larj.prismium.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PRISMARITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MAGIC_BLOCK);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.LAMP_BLOCK, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.LAMP_BLOCK,"_on",Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.LAMP_BLOCK)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(LampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PRISMIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PRISMARITE, Models.GENERATED);
        //itemModelGenerator.register(ModItems.CHISEL, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRISMIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRISMIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRISMIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PRISMIUM_BOOTS));
    }
}
