package net.s0larj.prismium.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.s0larj.prismium.Prismium;
import net.s0larj.prismium.item.custom.ChiselItem;

public class ModItems {

    public static final Item PRISMIUM = registerItem("prismium", new Item(new Item.Settings()));
    public static final Item PRISMARITE = registerItem("prismarite", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));

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
