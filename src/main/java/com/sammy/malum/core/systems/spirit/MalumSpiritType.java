package com.sammy.malum.core.systems.spirit;

import com.sammy.malum.common.item.misc.MalumSpiritItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MalumSpiritType
{
    public static Map<ResourceLocation, MalumEntitySpiritDataBundle> SPIRIT_DATA = new HashMap<>();
    public final Color color;
    public final String identifier;
    protected Supplier<Item> splinterItem;

    public MalumSpiritType(String identifier, Color color, RegistryObject<Item> splinterItem)
    {
        this.identifier = identifier;
        this.color = color;
        this.splinterItem = splinterItem;
    }

    public MalumSpiritItem splinterItem()
    {
        return (MalumSpiritItem) splinterItem.get();
    }

}