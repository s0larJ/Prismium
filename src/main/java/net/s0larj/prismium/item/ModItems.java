package net.s0larj.prismium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.Prismium;
import net.s0larj.prismium.item.custom.ChiselItem;
import net.s0larj.prismium.item.custom.ModArmorItem;
import net.s0larj.prismium.item.custom.TomahawkItem;

import java.util.List;

public class ModItems {

    public static final Item PRISMIUM = registerItem("prismium", new Item(new Item.Settings()));
    public static final Item PRISMARITE = registerItem("prismarite", new Item(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            //allows us to add tooltip without custom item
            tooltip.add(Text.translatable("tooltip.prismium.prismarite.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item PRISMIUM_HELMET = registerItem("prismium_helmet",
            new ModArmorItem(ModArmorMaterials.PRISMIUM_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));

    public static final Item PRISMIUM_CHESTPLATE = registerItem("prismium_chestplate",
            new ArmorItem(ModArmorMaterials.PRISMIUM_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));

    public static final Item PRISMIUM_LEGGINGS = registerItem("prismium_leggings",
            new ArmorItem(ModArmorMaterials.PRISMIUM_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));

    public static final Item PRISMIUM_BOOTS = registerItem("prismium_boots",
            new ArmorItem(ModArmorMaterials.PRISMIUM_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item TOMAHAWK = registerItem("tomahawk", new TomahawkItem(new Item.Settings().maxCount(16)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Prismium.MOD_ID, name), item);
    }
    public static void registerModItems() {
        Prismium.LOGGER.info("Registering Mod Items for " + Prismium.MOD_ID);
        /*
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
           fabricItemGroupEntries.add(PRISMIUM);
           fabricItemGroupEntries.add(PRISMARITE);
        });
         */
    }
}
