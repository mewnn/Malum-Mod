package com.sammy.malum.client.renderer.entity;

import com.sammy.malum.core.helper.DataHelper;
import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.vehicle.Boat;

public class MalumBoatRenderer extends BoatRenderer
{
    private final ResourceLocation boatTexture;
    public MalumBoatRenderer(EntityRendererProvider.Context context, String textureName)
    {
        super(context);
        boatTexture = DataHelper.prefix("textures/entity/boat/" + textureName + "_boat.png");
    }

    @Override
    public ResourceLocation getTextureLocation(Boat p_113927_) {
        return boatTexture;
    }
}