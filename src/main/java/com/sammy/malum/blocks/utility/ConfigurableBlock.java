package com.sammy.malum.blocks.utility;

import com.sammy.malum.items.staves.BasicStave;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;


public interface ConfigurableBlock
{
    int options();
    
    default void configureTileEntity(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit, ConfigurableTileEntity tileEntity, int option, boolean isSneaking)
    {
    
    }
    
    default ActionResultType blockInteraction(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        return ActionResultType.FAIL;
    }
    
    default ActionResultType activateBlock(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit)
    {
        if (!worldIn.isRemote())
        {
            if (worldIn.getTileEntity(pos) instanceof ConfigurableTileEntity)
            {
                ItemStack stack = player.getHeldItem(handIn);
                if (stack.getItem() instanceof BasicStave)
                {
                    if (((BasicStave) stack.getItem()).getOption(stack).option == 2)
                    {
                        ConfigurableTileEntity tileEntity = (ConfigurableTileEntity) worldIn.getTileEntity(pos);
                        configureTileEntity(state, worldIn, pos, player, handIn, hit, tileEntity, tileEntity.option, player.isSneaking());
                        return ActionResultType.SUCCESS;
                    }
                }
                else
                {
                    return blockInteraction(state, worldIn, pos, player, handIn, hit);
                }
            }
        }
        return ActionResultType.SUCCESS;
    }
}