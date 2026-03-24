package net.s0larj.prismium.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.s0larj.prismium.component.ModDataComponentTypes;
import net.s0larj.prismium.entity.custom.TomahawkProjectileEntity;


public class TomahawkItem extends Item {
    public TomahawkItem(Settings settings) {
        super(settings);
    }

    public TomahawkProjectileEntity tomahawk;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 0.5f, 0.4f);

        if (!world.isClient) {
            if (itemStack.get(ModDataComponentTypes.TOMA) == null) {
                tomahawk = new TomahawkProjectileEntity(world, user);
                itemStack.set(ModDataComponentTypes.TOMA, tomahawk.getId());
                tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.0f, 0f);
                world.spawnEntity(tomahawk);
            }else {
                world.getEntityById(itemStack.get(ModDataComponentTypes.TOMA)).discard();
                itemStack.set(ModDataComponentTypes.TOMA, null);
            }
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
