package net.gamerk.rubymod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

import static net.gamerk.rubymod.item.init.ModItems2.COBALT_SWORD;

public class WeaknessEnchantment extends Enchantment {
    public WeaknessEnchantment(Enchantment.Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        super.onTargetDamaged(user, target, level);

        if (!user.world.isClient()) {
            ServerWorld world = ((ServerWorld) user.world);
            PlayerEntity player = ((PlayerEntity) user);

            float chance = user.getRandom().nextFloat();
            if (chance <= 0.2 + (level * 0.1)) {
                WeaknessEnchantment.causeWeakness((LivingEntity) target, 10);
            }

        }
    }
    public static void causeWeakness(LivingEntity target, int amplifier){
        StatusEffectInstance weakness = new StatusEffectInstance(StatusEffects.WEAKNESS, 60, amplifier);
        target.addStatusEffect(weakness);
    }
    @Override
    public boolean isAvailableForRandomSelection() {
        return true;
    }
    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return true;
    }
    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isOf(COBALT_SWORD);
    }

    @Override
    public boolean isTreasure() {
        return true;
    }
}
