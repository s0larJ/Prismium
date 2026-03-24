package net.s0larj.prismium.item.custom;


import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.s0larj.prismium.Prismium;
import net.s0larj.prismium.component.ModDataComponentTypes;
import net.s0larj.prismium.entity.custom.TomahawkProjectileEntity;
import net.minecraft.text.Text;

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
            if (itemStack.get(ModDataComponentTypes.THROWN) == null || Boolean.FALSE.equals(itemStack.get(ModDataComponentTypes.THROWN))) {
                itemStack.set(ModDataComponentTypes.THROWN, true);
                itemStack.set(ModDataComponentTypes.TOMA, tomahawk.getId());
                tomahawk = new TomahawkProjectileEntity(world, user);
                tomahawk.setVelocity(user, user.getPitch(), user.getYaw(), 0.0f, 2.0f, 0f);
                world.spawnEntity(tomahawk);
            }else {
                itemStack.set(ModDataComponentTypes.THROWN, false);
                world.getEntityById(itemStack.get(ModDataComponentTypes.TOMA)).discard();
                System.out.println(itemStack.get(ModDataComponentTypes.TOMA));
            }
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
