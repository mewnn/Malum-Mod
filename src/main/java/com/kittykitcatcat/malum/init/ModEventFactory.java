package com.kittykitcatcat.malum.init;

import com.kittykitcatcat.malum.events.SpiritHarvestEvent;
import com.kittykitcatcat.malum.events.SpiritIntegrityUpdateEvent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.function.Supplier;

public class ModEventFactory extends ForgeEventFactory
{
    public static SpiritHarvestEvent.Pre preSpiritHarvest(LivingEntity target, PlayerEntity playerEntity)
    {
        SpiritHarvestEvent.Pre event = new SpiritHarvestEvent.Pre(target, playerEntity);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
    public static SpiritHarvestEvent.Post postSpiritHarvest(LivingEntity target, PlayerEntity playerEntity, int spiritCount)
    {
        SpiritHarvestEvent.Post event = new SpiritHarvestEvent.Post(target, playerEntity, spiritCount);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
    
    public static SpiritIntegrityUpdateEvent.Decrease decreaseSpiritIntegrity(ItemStack stack, PlayerEntity playerEntity, int integrityChange)
    {
        SpiritIntegrityUpdateEvent.Decrease event = new SpiritIntegrityUpdateEvent.Decrease(stack, playerEntity, integrityChange);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
    public static SpiritIntegrityUpdateEvent.Fill fillSpiritIntegrity(ItemStack stack, PlayerEntity playerEntity, int integrityChange)
    {
        SpiritIntegrityUpdateEvent.Fill event = new SpiritIntegrityUpdateEvent.Fill(stack, playerEntity, integrityChange);
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
}