package com.sammy.malum.common.spiritrite;

import com.sammy.malum.common.packets.particle.BlockMistParticlePacket;
import com.sammy.malum.common.packets.particle.MagicParticlePacket;
import com.sammy.malum.core.systems.rites.MalumRiteType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.PacketDistributor;

import java.util.ArrayList;

import static com.sammy.malum.core.registry.content.SpiritTypeRegistry.*;
import static com.sammy.malum.core.registry.misc.PacketRegistry.INSTANCE;

public class EldritchSacredRiteType extends MalumRiteType {
    public EldritchSacredRiteType() {
        super("eldritch_sacred_rite", ELDRITCH_SPIRIT, ARCANE_SPIRIT, SACRED_SPIRIT, SACRED_SPIRIT);
    }

    @Override
    public void riteEffect(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            getNearbyBlocks(BonemealableBlock.class, level, pos, false).forEach(p -> {
                if (level.random.nextFloat() <= 0.02f) {
                    BlockState state = level.getBlockState(p);
                    BonemealableBlock growable = (BonemealableBlock) state.getBlock();
                    ServerLevel serverLevel = (ServerLevel) level;
                    if (growable.isValidBonemealTarget(serverLevel, p, state, false)) {
                        growable.performBonemeal(serverLevel, level.random, p, state);
                        BlockPos particlePos = state.canOcclude() ? p : p.below();
                        INSTANCE.send(PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(pos)), new BlockMistParticlePacket(SACRED_SPIRIT_COLOR, particlePos.getX(), particlePos.getY(), particlePos.getZ()));
                    }
                }
            });
        }
    }

    @Override
    public void corruptedRiteEffect(Level level, BlockPos pos) {
        if (!level.isClientSide) {
            ArrayList<Animal> entities = getNearbyEntities(Animal.class, level, pos, true);
            entities.removeIf(e -> e.getAge() < 0);
            if (entities.size() > 30) {
                return;
            }
            entities.forEach(e -> {
                if (e.canFallInLove() && e.getAge() == 0) {
                    if (level.random.nextFloat() <= 0.05f) {
                        e.setInLoveTime(600);
                        INSTANCE.send(PacketDistributor.TRACKING_ENTITY.with(() -> e), new MagicParticlePacket(SACRED_SPIRIT_COLOR, e.blockPosition().getX(), e.blockPosition().getY()+e.getBbHeight()/2f, e.blockPosition().getZ()));
                    }
                }
            });
        }
    }

    @Override
    public int range(boolean corrupted) {
        return defaultRange()/2;
    }
}