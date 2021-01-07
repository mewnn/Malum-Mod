package com.sammy.malum.core.init.blocks;

import com.sammy.malum.MalumConstants;
import com.sammy.malum.common.blocks.MalumDirectionalBlock;
import com.sammy.malum.common.blocks.MalumLeavesBlock;
import com.sammy.malum.common.blocks.MalumTallGrassBlock;
import com.sammy.malum.common.blocks.WitherSandBlock;
import com.sammy.malum.common.blocks.abstruceblock.AbstruseBlock;
import com.sammy.malum.common.blocks.arcaneworkbench.ArcaneWorkbenchBlock;
import com.sammy.malum.common.blocks.itemstand.ItemStandBlock;
import com.sammy.malum.common.blocks.lighting.EtherBlock;
import com.sammy.malum.common.blocks.lighting.EtherTorchBlock;
import com.sammy.malum.common.blocks.lighting.WallEtherTorchBlock;
import com.sammy.malum.common.blocks.spiritkiln.SpiritKilnBoundingBlock;
import com.sammy.malum.common.blocks.spiritkiln.SpiritKilnCoreBlock;
import com.sammy.malum.common.blocks.wildfarmland.WildFarmlandBlock;
import com.sammy.malum.common.world.features.tree.SunKissedTree;
import com.sammy.malum.core.init.MalumSounds;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;

import static com.sammy.malum.MalumMod.MODID;
import static net.minecraft.block.PressurePlateBlock.Sensitivity.EVERYTHING;
import static net.minecraft.block.PressurePlateBlock.Sensitivity.MOBS;


@SuppressWarnings("unused")
public class MalumBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    
    //region properties
    
    public static AbstractBlock.Properties TAINTED_ROCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).sound(MalumSounds.TAINTED_ROCK).setRequiresTool().hardnessAndResistance(1.25F, 9.0F);
    }
    
    public static AbstractBlock.Properties DARKENED_ROCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ROCK, MaterialColor.STONE).setRequiresTool().sound(MalumSounds.DARKENED_ROCK).hardnessAndResistance(2.25F, 3600.0F);
    }
    
    public static AbstractBlock.Properties SUN_KISSED_WOOD_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.WOOD, MaterialColor.YELLOW).sound(SoundType.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(1.75F, 4.0F);
    }
    
    public static AbstractBlock.Properties TAINTED_WOOD_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.WOOD, MaterialColor.PURPLE).sound(SoundType.WOOD).harvestTool(ToolType.AXE).hardnessAndResistance(2F, 4.0F);
    }
    public static AbstractBlock.Properties SUN_KISSED_GRASS_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.YELLOW).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.45f);
    }
    public static AbstractBlock.Properties SUN_KISSED_PLANTS_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.YELLOW).doesNotBlockMovement().notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE).zeroHardnessAndResistance();
    }
    
    
    public static AbstractBlock.Properties TAINTED_GRASS_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.PURPLE).sound(SoundType.GROUND).harvestTool(ToolType.SHOVEL).hardnessAndResistance(0.45f).tickRandomly();
    }
    public static AbstractBlock.Properties TAINTED_PLANTS_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.PLANTS, MaterialColor.PURPLE).doesNotBlockMovement().notSolid().sound(SoundType.PLANT).harvestTool(ToolType.HOE).zeroHardnessAndResistance();
    }
    
    public static AbstractBlock.Properties LEAVES_PROPERTIES()
    {
        return AbstractBlock.Properties.from(Blocks.OAK_LEAVES);
    }
    
    public static AbstractBlock.Properties ABSTRUSE_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BLUE).sound(SoundType.CLOTH).zeroHardnessAndResistance().noDrops().notSolid();
    }
    
    public static AbstractBlock.Properties TRANSMISSIVE_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.IRON, MaterialColor.YELLOW).sound(MalumSounds.TRANSMISSIVE_ALLOY).notSolid().hardnessAndResistance(2F, 16.0F);
    }
    
    public static AbstractBlock.Properties SPIRITED_STEEL_BLOCK_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.IRON, MaterialColor.BLUE).sound(MalumSounds.SPIRITED_STEEL_BLOCK).hardnessAndResistance(5f,3600f);
    }
    
    public static AbstractBlock.Properties SPIRIT_JAR_PROPERTIES()
    {
        return AbstractBlock.Properties.create(Material.GLASS, MaterialColor.BLUE).sound(MalumSounds.TRANSMISSIVE_ALLOY).notSolid();
    }
    //endregion
    
    //region tainted rock
    public static final RegistryObject<Block> TAINTED_ROCK = BLOCKS.register("tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_TAINTED_ROCK = BLOCKS.register("smooth_tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_TAINTED_ROCK = BLOCKS.register("polished_tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_BRICKS = BLOCKS.register("tainted_rock_bricks", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_BRICKS = BLOCKS.register("cracked_tainted_rock_bricks", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_BRICKS = BLOCKS.register("mossy_tainted_rock_bricks", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_TILES = BLOCKS.register("tainted_rock_tiles", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_TILES = BLOCKS.register("cracked_tainted_rock_tiles", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_TILES = BLOCKS.register("mossy_tainted_rock_tiles", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_PILLAR = BLOCKS.register("tainted_rock_pillar", () -> new RotatedPillarBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_PILLAR_CAP = BLOCKS.register("tainted_rock_pillar_cap", () -> new MalumDirectionalBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_COLUMN = BLOCKS.register("tainted_rock_column", () -> new RotatedPillarBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_COLUMN_CAP = BLOCKS.register("tainted_rock_column_cap", () -> new MalumDirectionalBlock(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> CUT_TAINTED_ROCK = BLOCKS.register("cut_tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CHISELED_TAINTED_ROCK = BLOCKS.register("chiseled_tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> FLARED_TAINTED_ROCK = BLOCKS.register("flared_tainted_rock", () -> new Block(TAINTED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 15))));
    public static final RegistryObject<Block> HORIZONTAL_FLARED_TAINTED_ROCK = BLOCKS.register("horizontal_flared_tainted_rock", () -> new RotatedPillarBlock(TAINTED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 15))));
    public static final RegistryObject<Block> TAINTED_ETHER_LANTERN = BLOCKS.register("tainted_ether_lantern", () -> new LanternBlock(TAINTED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 12))));
    
    public static final RegistryObject<Block> TAINTED_ROCK_SLAB = BLOCKS.register("tainted_rock_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_TAINTED_ROCK_SLAB = BLOCKS.register("smooth_tainted_rock_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_TAINTED_ROCK_SLAB = BLOCKS.register("polished_tainted_rock_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_BRICKS_SLAB = BLOCKS.register("tainted_rock_bricks_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_BRICKS_SLAB = BLOCKS.register("cracked_tainted_rock_bricks_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_BRICKS_SLAB = BLOCKS.register("mossy_tainted_rock_bricks_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_TILES_SLAB = BLOCKS.register("tainted_rock_tiles_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_TILES_SLAB = BLOCKS.register("cracked_tainted_rock_tiles_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_TILES_SLAB = BLOCKS.register("mossy_tainted_rock_tiles_slab", () -> new SlabBlock(TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_STAIRS = BLOCKS.register("tainted_rock_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_TAINTED_ROCK_STAIRS = BLOCKS.register("smooth_tainted_rock_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_TAINTED_ROCK_STAIRS = BLOCKS.register("polished_tainted_rock_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_BRICKS_STAIRS = BLOCKS.register("tainted_rock_bricks_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_BRICKS_STAIRS = BLOCKS.register("cracked_tainted_rock_bricks_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_BRICKS_STAIRS = BLOCKS.register("mossy_tainted_rock_bricks_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_TILES_STAIRS = BLOCKS.register("tainted_rock_tiles_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_TILES_STAIRS = BLOCKS.register("cracked_tainted_rock_tiles_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_TILES_STAIRS = BLOCKS.register("mossy_tainted_rock_tiles_stairs", () -> new StairsBlock(TAINTED_ROCK.get().getDefaultState(), TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_PRESSURE_PLATE = BLOCKS.register("tainted_rock_pressure_plate", () -> new PressurePlateBlock(MOBS, TAINTED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> TAINTED_ROCK_WALL = BLOCKS.register("tainted_rock_wall", () -> new WallBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> TAINTED_ROCK_BRICKS_WALL = BLOCKS.register("tainted_rock_bricks_wall", () -> new WallBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_TAINTED_ROCK_BRICKS_WALL = BLOCKS.register("mossy_tainted_rock_bricks_wall", () -> new WallBlock(TAINTED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_TAINTED_ROCK_BRICKS_WALL = BLOCKS.register("cracked_tainted_rock_bricks_wall", () -> new WallBlock(TAINTED_ROCK_PROPERTIES()));
    //endregion
    
    //region darkened rock
    public static final RegistryObject<Block> DARKENED_ROCK = BLOCKS.register("darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_DARKENED_ROCK = BLOCKS.register("smooth_darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_DARKENED_ROCK = BLOCKS.register("polished_darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_BRICKS = BLOCKS.register("darkened_rock_bricks", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_BRICKS = BLOCKS.register("cracked_darkened_rock_bricks", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_BRICKS = BLOCKS.register("mossy_darkened_rock_bricks", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_TILES = BLOCKS.register("darkened_rock_tiles", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_TILES = BLOCKS.register("cracked_darkened_rock_tiles", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_TILES = BLOCKS.register("mossy_darkened_rock_tiles", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_PILLAR = BLOCKS.register("darkened_rock_pillar", () -> new RotatedPillarBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_PILLAR_CAP = BLOCKS.register("darkened_rock_pillar_cap", () -> new MalumDirectionalBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_COLUMN = BLOCKS.register("darkened_rock_column", () -> new RotatedPillarBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_COLUMN_CAP = BLOCKS.register("darkened_rock_column_cap", () -> new MalumDirectionalBlock(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> CUT_DARKENED_ROCK = BLOCKS.register("cut_darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CHISELED_DARKENED_ROCK = BLOCKS.register("chiseled_darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> FLARED_DARKENED_ROCK = BLOCKS.register("flared_darkened_rock", () -> new Block(DARKENED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 15))));
    public static final RegistryObject<Block> HORIZONTAL_FLARED_DARKENED_ROCK = BLOCKS.register("horizontal_flared_darkened_rock", () -> new RotatedPillarBlock(DARKENED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 15))));
    public static final RegistryObject<Block> DARKENED_ETHER_LANTERN = BLOCKS.register("darkened_ether_lantern", () -> new LanternBlock(DARKENED_ROCK_PROPERTIES().setLightLevel(b -> light(b, 12))));
    
    public static final RegistryObject<Block> DARKENED_ROCK_SLAB = BLOCKS.register("darkened_rock_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_DARKENED_ROCK_SLAB = BLOCKS.register("smooth_darkened_rock_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_DARKENED_ROCK_SLAB = BLOCKS.register("polished_darkened_rock_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_BRICKS_SLAB = BLOCKS.register("darkened_rock_bricks_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_BRICKS_SLAB = BLOCKS.register("cracked_darkened_rock_bricks_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_BRICKS_SLAB = BLOCKS.register("mossy_darkened_rock_bricks_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_TILES_SLAB = BLOCKS.register("darkened_rock_tiles_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_TILES_SLAB = BLOCKS.register("cracked_darkened_rock_tiles_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_TILES_SLAB = BLOCKS.register("mossy_darkened_rock_tiles_slab", () -> new SlabBlock(DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_STAIRS = BLOCKS.register("darkened_rock_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> SMOOTH_DARKENED_ROCK_STAIRS = BLOCKS.register("smooth_darkened_rock_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> POLISHED_DARKENED_ROCK_STAIRS = BLOCKS.register("polished_darkened_rock_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_BRICKS_STAIRS = BLOCKS.register("darkened_rock_bricks_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_BRICKS_STAIRS = BLOCKS.register("cracked_darkened_rock_bricks_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_BRICKS_STAIRS = BLOCKS.register("mossy_darkened_rock_bricks_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_TILES_STAIRS = BLOCKS.register("darkened_rock_tiles_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_TILES_STAIRS = BLOCKS.register("cracked_darkened_rock_tiles_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_TILES_STAIRS = BLOCKS.register("mossy_darkened_rock_tiles_stairs", () -> new StairsBlock(DARKENED_ROCK.get().getDefaultState(), DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_PRESSURE_PLATE = BLOCKS.register("darkened_rock_pressure_plate", () -> new PressurePlateBlock(MOBS, DARKENED_ROCK_PROPERTIES()));
    
    public static final RegistryObject<Block> DARKENED_ROCK_WALL = BLOCKS.register("darkened_rock_wall", () -> new WallBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> DARKENED_ROCK_BRICKS_WALL = BLOCKS.register("darkened_rock_bricks_wall", () -> new WallBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> MOSSY_DARKENED_ROCK_BRICKS_WALL = BLOCKS.register("mossy_darkened_rock_bricks_wall", () -> new WallBlock(DARKENED_ROCK_PROPERTIES()));
    public static final RegistryObject<Block> CRACKED_DARKENED_ROCK_BRICKS_WALL = BLOCKS.register("cracked_darkened_rock_bricks_wall", () -> new WallBlock(DARKENED_ROCK_PROPERTIES()));
    //endregion
    
    //region sun kissed wood
    public static final RegistryObject<Block> SUN_KISSED_LOG = BLOCKS.register("sun_kissed_log", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> STRIPPED_SUN_KISSED_LOG = BLOCKS.register("stripped_sun_kissed_log", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_WOOD = BLOCKS.register("sun_kissed_wood", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> STRIPPED_SUN_KISSED_WOOD = BLOCKS.register("stripped_sun_kissed_wood", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> SUN_KISSED_PLANKS = BLOCKS.register("sun_kissed_planks", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_SLAB = BLOCKS.register("sun_kissed_planks_slab", () -> new SlabBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_STAIRS = BLOCKS.register("sun_kissed_planks_stairs", () -> new StairsBlock(SUN_KISSED_PLANKS.get().getDefaultState(), SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> VERTICAL_SUN_KISSED_PLANKS = BLOCKS.register("vertical_sun_kissed_planks", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> VERTICAL_SUN_KISSED_PLANKS_SLAB = BLOCKS.register("vertical_sun_kissed_planks_slab", () -> new SlabBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> VERTICAL_SUN_KISSED_PLANKS_STAIRS = BLOCKS.register("vertical_sun_kissed_planks_stairs", () -> new StairsBlock(VERTICAL_SUN_KISSED_PLANKS.get().getDefaultState(), SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> BOLTED_SUN_KISSED_PLANKS = BLOCKS.register("bolted_sun_kissed_planks", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> BOLTED_SUN_KISSED_PLANKS_SLAB = BLOCKS.register("bolted_sun_kissed_planks_slab", () -> new SlabBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> BOLTED_SUN_KISSED_PLANKS_STAIRS = BLOCKS.register("bolted_sun_kissed_planks_stairs", () -> new StairsBlock(SUN_KISSED_PLANKS.get().getDefaultState(), SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> SUN_KISSED_PANEL = BLOCKS.register("sun_kissed_panel", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PANEL_SLAB = BLOCKS.register("sun_kissed_panel_slab", () -> new SlabBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PANEL_STAIRS = BLOCKS.register("sun_kissed_panel_stairs", () -> new StairsBlock(SUN_KISSED_PANEL.get().getDefaultState(), SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> SUN_KISSED_TILES = BLOCKS.register("sun_kissed_tiles", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_TILES_SLAB = BLOCKS.register("sun_kissed_tiles_slab", () -> new SlabBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_TILES_STAIRS = BLOCKS.register("sun_kissed_tiles_stairs", () -> new StairsBlock(SUN_KISSED_TILES.get().getDefaultState(), SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> CUT_SUN_KISSED_PLANKS = BLOCKS.register("cut_sun_kissed_planks", () -> new Block(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_BEAM = BLOCKS.register("sun_kissed_beam", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> BOLTED_SUN_KISSED_BEAM = BLOCKS.register("bolted_sun_kissed_beam", () -> new RotatedPillarBlock(SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> SUN_KISSED_DOOR = BLOCKS.register("sun_kissed_door", () -> new DoorBlock(SUN_KISSED_WOOD_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> SUN_KISSED_TRAPDOOR = BLOCKS.register("sun_kissed_trapdoor", () -> new TrapDoorBlock(SUN_KISSED_WOOD_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> SOLID_SUN_KISSED_TRAPDOOR = BLOCKS.register("solid_sun_kissed_trapdoor", () -> new TrapDoorBlock(SUN_KISSED_WOOD_PROPERTIES().notSolid()));
    
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_BUTTON = BLOCKS.register("sun_kissed_planks_button", () -> new WoodButtonBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_PRESSURE_PLATE = BLOCKS.register("sun_kissed_planks_pressure_plate", () -> new PressurePlateBlock(EVERYTHING, SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_FENCE = BLOCKS.register("sun_kissed_planks_fence", () -> new FenceBlock(SUN_KISSED_WOOD_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_PLANKS_FENCE_GATE = BLOCKS.register("sun_kissed_planks_fence_gate", () -> new FenceGateBlock(SUN_KISSED_WOOD_PROPERTIES()));
    
    public static final RegistryObject<Block> ORANGE_ETHER_TORCH = BLOCKS.register("orange_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.ORANGE));
    public static final RegistryObject<Block> MAGENTA_ETHER_TORCH = BLOCKS.register("magenta_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.MAGENTA));
    public static final RegistryObject<Block> LIGHT_BLUE_ETHER_TORCH = BLOCKS.register("light_blue_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIGHT_BLUE));
    public static final RegistryObject<Block> YELLOW_ETHER_TORCH = BLOCKS.register("yellow_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.YELLOW));
    public static final RegistryObject<Block> ETHER_TORCH = BLOCKS.register("ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.PINK));
    public static final RegistryObject<Block> LIME_ETHER_TORCH = BLOCKS.register("lime_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIME));
    public static final RegistryObject<Block> CYAN_ETHER_TORCH = BLOCKS.register("cyan_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.CYAN));
    public static final RegistryObject<Block> PURPLE_ETHER_TORCH = BLOCKS.register("purple_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.PURPLE));
    public static final RegistryObject<Block> BLUE_ETHER_TORCH = BLOCKS.register("blue_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BLUE));
    public static final RegistryObject<Block> BROWN_ETHER_TORCH = BLOCKS.register("brown_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BROWN));
    public static final RegistryObject<Block> GREEN_ETHER_TORCH = BLOCKS.register("green_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.GREEN));
    public static final RegistryObject<Block> RED_ETHER_TORCH = BLOCKS.register("red_ether_torch", () -> new EtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.RED));
    
    public static final RegistryObject<Block> ORANGE_WALL_ETHER_TORCH = BLOCKS.register("orange_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.ORANGE));
    public static final RegistryObject<Block> MAGENTA_WALL_ETHER_TORCH = BLOCKS.register("magenta_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.MAGENTA));
    public static final RegistryObject<Block> LIGHT_BLUE_WALL_ETHER_TORCH = BLOCKS.register("light_blue_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIGHT_BLUE));
    public static final RegistryObject<Block> YELLOW_WALL_ETHER_TORCH = BLOCKS.register("yellow_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.YELLOW));
    public static final RegistryObject<Block> WALL_ETHER_TORCH = BLOCKS.register("wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.PINK));
    public static final RegistryObject<Block> LIME_WALL_ETHER_TORCH = BLOCKS.register("lime_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIME));
    public static final RegistryObject<Block> CYAN_WALL_ETHER_TORCH = BLOCKS.register("cyan_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.CYAN));
    public static final RegistryObject<Block> PURPLE_WALL_ETHER_TORCH = BLOCKS.register("purple_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.darkest()));
    public static final RegistryObject<Block> BLUE_WALL_ETHER_TORCH = BLOCKS.register("blue_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BLUE));
    public static final RegistryObject<Block> BROWN_WALL_ETHER_TORCH = BLOCKS.register("brown_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BROWN));
    public static final RegistryObject<Block> GREEN_WALL_ETHER_TORCH = BLOCKS.register("green_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.GREEN));
    public static final RegistryObject<Block> RED_WALL_ETHER_TORCH = BLOCKS.register("red_wall_ether_torch", () -> new WallEtherTorchBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.RED));
    
    public static final RegistryObject<Block> ORANGE_ETHER = BLOCKS.register("orange_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.ORANGE));
    public static final RegistryObject<Block> MAGENTA_ETHER = BLOCKS.register("magenta_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.MAGENTA));
    public static final RegistryObject<Block> LIGHT_BLUE_ETHER = BLOCKS.register("light_blue_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIGHT_BLUE));
    public static final RegistryObject<Block> YELLOW_ETHER = BLOCKS.register("yellow_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.YELLOW));
    public static final RegistryObject<Block> ETHER = BLOCKS.register("ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.PINK));
    public static final RegistryObject<Block> LIME_ETHER = BLOCKS.register("lime_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.LIME));
    public static final RegistryObject<Block> CYAN_ETHER = BLOCKS.register("cyan_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.CYAN));
    public static final RegistryObject<Block> PURPLE_ETHER = BLOCKS.register("purple_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.PURPLE));
    public static final RegistryObject<Block> BLUE_ETHER = BLOCKS.register("blue_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BLUE));
    public static final RegistryObject<Block> BROWN_ETHER = BLOCKS.register("brown_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.BROWN));
    public static final RegistryObject<Block> GREEN_ETHER = BLOCKS.register("green_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.GREEN));
    public static final RegistryObject<Block> RED_ETHER = BLOCKS.register("red_ether", () -> new EtherBlock(SUN_KISSED_WOOD_PROPERTIES().doesNotBlockMovement().zeroHardnessAndResistance().setLightLevel((b) -> light(b,14)), MalumConstants.RED));
    
    //endregion
    
    public static final RegistryObject<Block> MARIGOLD = BLOCKS.register("marigold", () -> new BushBlock(SUN_KISSED_PLANTS_PROPERTIES()));
    
    //region sun kissed biome blocks
    public static final RegistryObject<Block> SUN_KISSED_GRASS_BLOCK = BLOCKS.register("sun_kissed_grass_block", () -> new GrassBlock(SUN_KISSED_GRASS_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TALL_SUN_KISSED_GRASS = BLOCKS.register("tall_sun_kissed_grass", () -> new DoublePlantBlock(SUN_KISSED_PLANTS_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_GRASS = BLOCKS.register("sun_kissed_grass", () -> new MalumTallGrassBlock(SUN_KISSED_PLANTS_PROPERTIES(), TALL_SUN_KISSED_GRASS));
    public static final RegistryObject<Block> SHORT_SUN_KISSED_GRASS = BLOCKS.register("short_sun_kissed_grass", () -> new MalumTallGrassBlock(SUN_KISSED_PLANTS_PROPERTIES(), TALL_SUN_KISSED_GRASS));
    public static final RegistryObject<Block> SUN_KISSED_SAPLING = BLOCKS.register("sun_kissed_sapling", () -> new SaplingBlock(new SunKissedTree(), SUN_KISSED_PLANTS_PROPERTIES()));
    public static final RegistryObject<Block> SUN_KISSED_LEAVES = BLOCKS.register("sun_kissed_leaves", () -> new MalumLeavesBlock(LEAVES_PROPERTIES(), new Color(180, 85, 13), new Color(255, 213, 78)));
    
    public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender", () -> new DoublePlantBlock(SUN_KISSED_PLANTS_PROPERTIES()));
    //endregion
    
    
    //region contents
    public static final RegistryObject<Block> BLAZE_QUARTZ_ORE = BLOCKS.register("blaze_quartz_ore", () -> new Block(AbstractBlock.Properties.from(Blocks.NETHER_QUARTZ_ORE)));
    public static final RegistryObject<Block> ABSTRUSE_BLOCK = BLOCKS.register("abstruse_block", () -> new AbstruseBlock(ABSTRUSE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_BLOCK = BLOCKS.register("transmissive_metal_block", () -> new Block(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_BLOCK_SLAB = BLOCKS.register("transmissive_metal_block_slab", () -> new SlabBlock(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_BLOCK_STAIRS = BLOCKS.register("transmissive_metal_block_stairs", () -> new StairsBlock(TRANSMISSIVE_METAL_BLOCK.get().getDefaultState(), TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_TILES = BLOCKS.register("transmissive_metal_tiles", () -> new Block(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_TILES_SLAB = BLOCKS.register("transmissive_metal_tiles_slab", () -> new SlabBlock(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> TRANSMISSIVE_METAL_TILES_STAIRS = BLOCKS.register("transmissive_metal_tiles_stairs", () -> new StairsBlock(TRANSMISSIVE_METAL_TILES.get().getDefaultState(), TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_TRANSMISSIVE_METAL = BLOCKS.register("stacked_transmissive_metal", () -> new Block(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_TRANSMISSIVE_METAL_SLAB = BLOCKS.register("stacked_transmissive_metal_slab", () -> new SlabBlock(TRANSMISSIVE_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_TRANSMISSIVE_METAL_STAIRS = BLOCKS.register("stacked_transmissive_metal_stairs", () -> new StairsBlock(STACKED_TRANSMISSIVE_METAL.get().getDefaultState(), TRANSMISSIVE_BLOCK_PROPERTIES()));
    
    public static final RegistryObject<Block> SPIRITED_STEEL_BLOCK = BLOCKS.register("spirited_steel_block", () -> new Block(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> SPIRITED_STEEL_BLOCK_SLAB = BLOCKS.register("spirited_steel_block_slab", () -> new SlabBlock(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> SPIRITED_STEEL_BLOCK_STAIRS = BLOCKS.register("spirited_steel_block_stairs", () -> new StairsBlock(SPIRITED_STEEL_BLOCK.get().getDefaultState(), SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> SPIRITED_STEEL_TILES = BLOCKS.register("spirited_steel_tiles", () -> new Block(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> SPIRITED_STEEL_TILES_SLAB = BLOCKS.register("spirited_steel_tiles_slab", () -> new SlabBlock(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> SPIRITED_STEEL_TILES_STAIRS = BLOCKS.register("spirited_steel_tiles_stairs", () -> new StairsBlock(SPIRITED_STEEL_TILES.get().getDefaultState(), SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_SPIRITED_STEEL = BLOCKS.register("stacked_spirited_steel", () -> new Block(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_SPIRITED_STEEL_SLAB = BLOCKS.register("stacked_spirited_steel_slab", () -> new SlabBlock(SPIRITED_STEEL_BLOCK_PROPERTIES()));
    public static final RegistryObject<Block> STACKED_SPIRITED_STEEL_STAIRS = BLOCKS.register("stacked_spirited_steel_stairs", () -> new StairsBlock(STACKED_SPIRITED_STEEL.get().getDefaultState(), SPIRITED_STEEL_BLOCK_PROPERTIES()));
    
    public static final RegistryObject<Block> WITHER_SAND = BLOCKS.register("wither_sand", () -> new WitherSandBlock(AbstractBlock.Properties.from(Blocks.SOUL_SAND).harvestTool(ToolType.SHOVEL)));
    //endregion
    
    //region crafting blocks
    //    public static final RegistryObject<Block> ARCANE_CRAFTING_TABLE = BLOCKS.register("arcane_crafting_table", () -> new ArcaneCraftingTableBlock(TAINTED_WOOD_PROPERTIES().notSolid()));
    //
    public static final RegistryObject<Block> SPIRIT_KILN = BLOCKS.register("spirit_kiln", () -> new SpiritKilnCoreBlock(TAINTED_ROCK_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> SPIRIT_KILN_TOP = BLOCKS.register("spirit_kiln_top", () -> new SpiritKilnBoundingBlock(TAINTED_ROCK_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> ARCANE_WORKBENCH = BLOCKS.register("arcane_workbench", () -> new ArcaneWorkbenchBlock(TAINTED_ROCK_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> ITEM_STAND = BLOCKS.register("item_stand", () -> new ItemStandBlock(TAINTED_ROCK_PROPERTIES().notSolid()));
    public static final RegistryObject<Block> WILD_FARMLAND = BLOCKS.register("wild_farmland", () -> new WildFarmlandBlock(SUN_KISSED_GRASS_BLOCK_PROPERTIES().notSolid().tickRandomly()));
    //endregion
    
    public static int light(BlockState state, int strength)
    {
        if (ModList.get().isLoaded("hypcore"))
        {
            if (FMLEnvironment.dist == Dist.CLIENT)
            {
                return 0;
            }
        }
        return strength;
    }
}