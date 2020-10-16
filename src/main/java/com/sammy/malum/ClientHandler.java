package com.sammy.malum;

import com.sammy.malum.blocks.machines.funkengine.FunkEngineTileEntity;
import com.sammy.malum.blocks.machines.spiritfurnace.SpiritFurnaceBottomTileEntity;
import com.sammy.malum.blocks.utility.FancyRenderer;
import com.sammy.malum.capabilities.MalumDataProvider;
import com.sammy.malum.init.ModSounds;
import com.sammy.malum.init.ModTooltips;
import com.sammy.malum.items.armor.ItemSpiritHunterArmor;
import com.sammy.malum.items.armor.ItemSpiritedSteelBattleArmor;
import com.sammy.malum.items.armor.ItemUmbraSteelBattleArmor;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.sammy.malum.items.armor.ModArmor;
import com.sammy.malum.items.curios.CurioNetherborneCapacitor;
import com.sammy.malum.items.staves.BasicStave;
import com.sammy.malum.items.staves.SpiritwoodStave;
import com.sammy.malum.network.packets.HuskChangePacket;
import com.sammy.malum.network.packets.UpdateStaveNBT;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.text.*;
import net.minecraft.world.World;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.fml.network.PacketDistributor;
import top.theillusivec4.curios.api.CuriosApi;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.sammy.malum.capabilities.MalumDataProvider.getHusk;
import static com.sammy.malum.network.NetworkManager.INSTANCE;
import static net.minecraft.util.math.RayTraceResult.Type.BLOCK;

public class ClientHandler
{
    public static void setHusk(int id, boolean value)
    {
        World world = Minecraft.getInstance().world;
        if (world != null)
        {
            if (world.getEntityByID(id) instanceof LivingEntity)
            {
                MalumDataProvider.setHusk((LivingEntity) world.getEntityByID(id), value);
            }
        }
    }
    
    
    public static SimpleSound sound;
    public static void spiritHarvestStart(PlayerEntity playerEntity)
    {
        float pitch = 1;
        if (CuriosApi.getCuriosHelper().findEquippedCurio(stack -> stack.getItem() instanceof CurioNetherborneCapacitor, playerEntity).isPresent())
        {
            pitch = 2;
        }
        sound = new SimpleSound(ModSounds.spirit_harvest_drain, SoundCategory.BLOCKS, 1, pitch, playerEntity.getPosition());
        Minecraft.getInstance().getSoundHandler().play(sound);
    }
    public static void spiritHarvestStop()
    {
        stopPlayingSound(sound);
        sound = null;
    }
    
    public static void spiritFurnaceTick(SpiritFurnaceBottomTileEntity tileEntity)
    {
        boolean success = playLoopingSound(tileEntity.sound);
        if (success)
        {
            tileEntity.sound = new SimpleSound(ModSounds.furnace_loop, SoundCategory.BLOCKS, 1, 1, tileEntity.getPos());
        }
    }
    public static void spiritFurnaceStop(SpiritFurnaceBottomTileEntity tileEntity)
    {
        if (tileEntity.sound instanceof SimpleSound)
        {
            stopPlayingSound((SimpleSound) tileEntity.sound);
            tileEntity.sound = null;
        }
    }
    
    public static void funkEngineTick(FunkEngineTileEntity tileEntity)
    {
        ItemStack stack = tileEntity.inventory.getStackInSlot(0);
        if (stack.getItem() instanceof MusicDiscItem)
        {
            MusicDiscItem item = (MusicDiscItem) stack.getItem();
            boolean success = playLoopingSound(tileEntity.sound);
            if (success)
            {
                tileEntity.sound = new SimpleSound(item.getSound(), SoundCategory.BLOCKS, 1, 1, tileEntity.getPos());
            }
        }
        else
        {
            funkEngineStop(tileEntity);
        }
    }
    public static void funkEngineStop(FunkEngineTileEntity tileEntity)
    {
        if (tileEntity.sound instanceof SimpleSound)
        {
            stopPlayingSound((SimpleSound) tileEntity.sound);
            tileEntity.sound = null;
        }
    }
    public static boolean playLoopingSound(Object sound)
    {
        if (sound instanceof SimpleSound)
        {
            SimpleSound simpleSound = (SimpleSound) sound;
            if (!Minecraft.getInstance().getSoundHandler().isPlaying(simpleSound))
            {
                Minecraft.getInstance().getSoundHandler().play(simpleSound);
            }
            return false;
        }
        return sound == null;
    }
    
    public static void stopPlayingSound(SimpleSound sound)
    {
        if (sound != null)
        {
            if (Minecraft.getInstance().getSoundHandler().isPlaying(sound))
            {
                Minecraft.getInstance().getSoundHandler().stop(sound);
            }
        }
    }
    
    //region TOOLTIP THINGIES
    public static void makeTooltip(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn, ArrayList<ITextComponent> components)
    {
        if (!Screen.hasShiftDown())
        {
            tooltip.add(new TranslationTextComponent("malum.tooltip.hold").mergeStyle(TextFormatting.GRAY)
                    .append(makeImportantComponent("malum.tooltip.sneak", false)));
        }
        else
        {
            tooltip.add(makeTranslationComponent("malum.tooltip.hold")
                    .append(makeImportantComponent("malum.tooltip.sneak", true)));
            tooltip.addAll(components);
        }
    }
    
    public static IFormattableTextComponent makeTranslationComponent(String message)
    {
        return new TranslationTextComponent(message).mergeStyle(TextFormatting.WHITE);
    }
    public static IFormattableTextComponent makeImportantComponent(String message, boolean litUp)
    {
        if (litUp)
        {
            return new StringTextComponent("[").mergeStyle(TextFormatting.WHITE)
                    .append(new TranslationTextComponent(message).mergeStyle(TextFormatting.LIGHT_PURPLE))
                    .append(new StringTextComponent("] ").mergeStyle(TextFormatting.WHITE)).mergeStyle(TextFormatting.BOLD);
        }
        else
        {
            return new StringTextComponent("[").mergeStyle(TextFormatting.GRAY)
                    .append(new TranslationTextComponent(message).mergeStyle(TextFormatting.DARK_PURPLE))
                    .append(new StringTextComponent("] ").mergeStyle(TextFormatting.GRAY)).mergeStyle(TextFormatting.BOLD);
        }
    }
    
    //region RENDERING NONSENSE
    public static void renderTEdataInTheCoolFancyWayWithoutCaringAboutSides(TileEntity blockEntity, FancyRenderer renderer, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, TileEntityRendererDispatcher renderDispatcher, ArrayList<ITextComponent> components)
    {
        if (renderDispatcher.renderInfo != null)
        {
            Minecraft minecraft = Minecraft.getInstance();
            World world = minecraft.world;
            if (minecraft.objectMouseOver == null || world == null)
            {
                return;
            }
            if (minecraft.objectMouseOver.getType().equals(BLOCK))
            {
                BlockRayTraceResult mouseOver = (BlockRayTraceResult) minecraft.objectMouseOver;
                if (renderer.lookingAtPos() == null || !renderer.lookingAtPos().equals(mouseOver.getPos()))
                {
                    renderer.setLookingAtPos( mouseOver.getPos());
                    renderer.setTime(0);
                }
                if (world.getTileEntity(mouseOver.getPos()) != null)
                {
                    if (world.getTileEntity(mouseOver.getPos()).equals(blockEntity))
                    {
                        TileEntity tileEntity = world.getTileEntity(mouseOver.getPos());
                        if (tileEntity.getPos().equals(blockEntity.getPos()))
                        {
                            if (renderer.lookingAtPos() != null && renderer.lookingAtPos().equals(mouseOver.getPos()) && renderer.time() < 1)
                            {
                                renderer.setTime(renderer.time() + 0.1f);
                            }
                            FontRenderer fontrenderer = renderDispatcher.getFontRenderer();
                            float spacing = 0.2f;
                            int current = components.size() + 1;
                            for (ITextComponent component : components)
                            {
                                String text = component.getString();
                                float xOffset = (float) (-fontrenderer.getStringWidth(text) / 2);
                                matrixStack.push();
                                
                                Matrix4f matrix4f = matrixStack.getLast().getMatrix();
                                
                                matrixStack.translate(0.5, 0.5, 0.5);
                                
                                matrixStack.rotate(renderDispatcher.renderInfo.getRotation());
                                float positionOffset = current * spacing - (float)components.size() * spacing / 2;
                                matrixStack.translate(0, positionOffset, 0);
                                
                                matrixStack.scale(-0.025F * renderer.time(), -0.025F * renderer.time(), 0.025F * renderer.time());
                                
                                fontrenderer.renderString(text, xOffset, 0, -1, true, matrix4f, iRenderTypeBuffer, false, (int) 0f << 24, 192);
                                
                                matrixStack.pop();
                                current--;
                            }
                        }
                    }
                }
            }
            else
            {
                renderer.setLookingAtPos(null);
                renderer.setTime(0);
            }
        }
    }
    
    public static void renderTEdataInTheCoolFancyWay(TileEntity blockEntity, FancyRenderer renderer, MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, TileEntityRendererDispatcher renderDispatcher, ArrayList<ITextComponent> components)
    {
        if (renderDispatcher.renderInfo != null)
        {
            Minecraft minecraft = Minecraft.getInstance();
            World world = minecraft.world;
            if (minecraft.objectMouseOver == null || world == null)
            {
                return;
            }
            if (minecraft.objectMouseOver.getType().equals(BLOCK))
            {
                BlockRayTraceResult mouseOver = (BlockRayTraceResult) minecraft.objectMouseOver;
                if ((renderer.lookingAtFace() == null || !renderer.lookingAtFace().equals(mouseOver.getFace())) || (renderer.lookingAtPos() == null || !renderer.lookingAtPos().equals(mouseOver.getPos())))
                {
                    renderer.setLookingAtFace( mouseOver.getFace());
                    renderer.setLookingAtPos( mouseOver.getPos());
                    renderer.setTime(0);
                }
                if (world.getTileEntity(mouseOver.getPos()) != null)
                {
                    if (world.getTileEntity(mouseOver.getPos()).equals(blockEntity))
                    {
                        TileEntity tileEntity = world.getTileEntity(mouseOver.getPos());
                        Vector3f direction = mouseOver.getFace().toVector3f();
                        if (tileEntity.getPos().equals(blockEntity.getPos()))
                        {
                            if (renderer.lookingAtPos() != null && renderer.lookingAtPos().equals(mouseOver.getPos()) && renderer.time() < 1)
                            {
                                renderer.setTime(renderer.time() + 0.1f);
                            }
                            FontRenderer fontrenderer = renderDispatcher.getFontRenderer();
                            float spacing = 0.2f;
                            int current = components.size() + 1;
                            for (ITextComponent component : components)
                            {
                                String text = component.getString();
                                float xOffset = (float) (-fontrenderer.getStringWidth(text) / 2);
                                matrixStack.push();
                
                                Matrix4f matrix4f = matrixStack.getLast().getMatrix();
                
                                matrixStack.translate(0.5, 0.5, 0.5);
                
                                matrixStack.translate(direction.getX(), direction.getY(), direction.getZ());
                                
                                matrixStack.rotate(renderDispatcher.renderInfo.getRotation());
                                float positionOffset = current * spacing - (float)components.size() * spacing / 2;
                                matrixStack.translate(0, positionOffset, 0);
                
                                matrixStack.scale(-0.025F * renderer.time(), -0.025F * renderer.time(), 0.025F * renderer.time());
                
                                fontrenderer.renderString(text, xOffset, 0, -1, true, matrix4f, iRenderTypeBuffer, false, (int) 0f << 24, 192);
                
                                matrixStack.pop();
                                current--;
                            }
                        }
                    }
                }
            }
            else
            {
                renderer.setLookingAtPos(null);
                renderer.setTime(0);
            }
        }
    }
    public static ITextComponent makeGenericSpiritDependantTooltip(String message, String spirit)
    {
        //Uses [spiritType] spirits to [message]
        return makeTranslationComponent("malum.tooltip.sconsumer.desc.c") //Uses
                .append(makeImportantComponent(spirit, true))
                .append(makeTranslationComponent("malum.tooltip.sconsumer.desc.d"))
                .append(makeImportantComponent(message, true));
    }
    
    public static void modifyStaveData(InputEvent.MouseScrollEvent event)
    {
        PlayerEntity playerEntity = Minecraft.getInstance().player;
        if (playerEntity.isSneaking())
        {
            ItemStack stack = playerEntity.getHeldItemMainhand();
            if (!(stack.getItem() instanceof BasicStave))
            {
                stack = playerEntity.getHeldItemOffhand();
            }
            if (stack.getItem() instanceof BasicStave)
            {
                int actualChange = event.getScrollDelta() > 0 ? 1 : -1;
                int finalNBT = stack.getTag().getInt("malum:staveOption") + actualChange;
                INSTANCE.sendToServer(new UpdateStaveNBT(stack, finalNBT));
                
                event.setCanceled(true);
            }
        }
    }
    public static void makeSpiritTooltip(PlayerEntity playerEntity, ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        ArrayList<ITextComponent> newComponents = new ArrayList<>();
        if (ModTooltips.tooltips.containsKey(stack.getItem()))
        {
            newComponents.addAll(ModTooltips.tooltips.get(stack.getItem()));
        }
        if (stack.getItem() instanceof ModArmor)
        {
            for(ItemStack armorItem : playerEntity.getArmorInventoryList())
            {
                if (armorItem != stack) continue;
                {
                    if (stack.getItem() instanceof ItemSpiritHunterArmor)
                    {
                        if (ItemSpiritHunterArmor.hasArmorSet(playerEntity))
                        {
                            newComponents.add(ModTooltips.extraSpirit(1));
                            newComponents.add(ModTooltips.extraIntegrity(25));
                        }
                    }
                    if (stack.getItem() instanceof ItemSpiritedSteelBattleArmor)
                    {
                        if (ItemSpiritedSteelBattleArmor.hasArmorSet(playerEntity))
                        {
                            newComponents.add(makeTranslationComponent("malum.tooltip.spirit_harvest")
                                    .append(makeImportantComponent("malum.tooltip.setbonus.spirited_steel", true)));
                        }
                    }
                    if (stack.getItem() instanceof ItemUmbraSteelBattleArmor)
                    {
                        if (ItemUmbraSteelBattleArmor.hasArmorSet(playerEntity))
                        {
                            newComponents.add(ModTooltips.extraSpirit(2));
                            newComponents.add(ModTooltips.extraIntegrity(25));
                            newComponents.add(makeTranslationComponent("malum.tooltip.spirit_harvest")
                                    .append(makeImportantComponent("malum.tooltip.setbonus.umbral_steel", true)));
                        }
                    }
                }
                break;
            }
        }
        if (stack.getItem() instanceof SpiritStorage)
        {
            if (SpiritDataHelper.doesItemHaveSpirit(stack))
            {
                SpiritStorage spiritStorage = (SpiritStorage) stack.getItem();
                if (spiritStorage.capacity() != 0)
                {
                    newComponents.add(makeTranslationComponent("malum.tooltip.sstorage.desc") //contains
                            .append(makeImportantComponent(stack.getTag().getInt(SpiritDataHelper.countNBT) + "/" + spiritStorage.capacity(), true)) //[amount/max]
                            .append(makeImportantComponent(SpiritDataHelper.getName(stack.getTag().getString(SpiritDataHelper.typeNBT)), true)) //[spiritType]
                            .append(makeTranslationComponent("malum.tooltip.spirit.desc.c"))); //spirits
                }
            }
        }
        if (stack.getItem() instanceof SpiritConsumer)
        {
            if (stack.getTag() != null)
            {
                SpiritConsumer spiritStorage = (SpiritConsumer) stack.getItem();
                if (spiritStorage.durability() != 0)
                {
                    newComponents.add(makeTranslationComponent("malum.tooltip.sconsumer.desc.a") //has
                            .append(makeImportantComponent(stack.getTag().getInt(SpiritDataHelper.spiritIntegrityNBT) + "/" + spiritStorage.durability(), true)) //[amount/max]
                            .append(makeTranslationComponent("malum.tooltip.sconsumer.desc.b"))); //spirit integrity
                }
            }
        }

        if (stack.getItem() instanceof SpiritDescription)
        {
            SpiritDescription spiritStorage = (SpiritDescription) stack.getItem();
            if (spiritStorage.components() != null && !spiritStorage.components().isEmpty())
            {
                newComponents.addAll(spiritStorage.components());
            }
        }
        if (!newComponents.isEmpty())
        {
            makeTooltip(stack, worldIn, tooltip, flagIn, newComponents);
        }
    }
}