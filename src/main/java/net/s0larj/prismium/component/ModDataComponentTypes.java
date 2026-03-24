package net.s0larj.prismium.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import net.minecraft.util.Identifier;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.s0larj.prismium.Prismium;

import java.util.UUID;
import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));

    public static final ComponentType<Boolean> THROWN = register("thrown",
            builder -> builder.codec(Codec.BOOL).packetCodec(PacketCodecs.BOOL));

    public static final ComponentType<Integer> TOMA = register(
            "toma", builder -> builder.codec(Codecs.rangedInt(1, 99)).packetCodec(PacketCodecs.VAR_INT)
    );

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(Prismium.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        Prismium.LOGGER.info("Registering Data Component Types for " + Prismium.MOD_ID);
    }
}
