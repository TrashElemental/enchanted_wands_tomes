package net.trashelemental.junkyard_lib.visual.particle;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;

import java.util.Random;

public class ParticleMethods {

    /**
     * Particles burst outwards from an entity.
     */
    public static void ParticlesBurst(Level level, ParticleOptions particleType, double x, double y, double z, int count, double speed) {
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(particleType, x, y, z, count, 0, 0, 0, speed);
        }
    }

    /**
     * Particles appear around an entity.
     */
    public static void ParticlesAround(Level level, ParticleOptions particleType, Entity entity, int count, double spread) {
        Random random = new Random();

        if (level instanceof ServerLevel serverLevel) {
            for (int i = 0; i < count; i++) {
                double offsetX = (random.nextDouble() - 0.5) * spread;
                double offsetY = (random.nextDouble() - 0.5) * spread;
                double offsetZ = (random.nextDouble() - 0.5) * spread;

                serverLevel.addParticle(
                        particleType, entity.getX() + offsetX, entity.getY() + offsetY, entity.getZ() + offsetZ,
                        0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Creates a trail of particles from one entity to another.
     */
    public static void ParticleTrailEntityToEntity(Level level, ParticleOptions particleType, Entity source, Entity destination, int count) {
        if (level instanceof ServerLevel serverLevel) {

            double deltaX = destination.getX() - source.getX();
            double deltaY = destination.getY() - source.getY();
            double deltaZ = destination.getZ() - source.getZ();

            for (int i = 0; i <= count; i++) {
                double progress = i / (double) count;
                double particleX = destination.getX() + deltaX * progress;
                double particleY = destination.getY() + deltaY * progress + 0.5;
                double particleZ = destination.getZ() + deltaZ * progress;

                serverLevel.sendParticles(particleType, particleX, particleY, particleZ,
                        1,0, 0, 0, 0);
            }
        }
    }

    /**
     * Creates a trail of particles from a block to an entity.
     */
    public static void ParticleTrailBlockToEntity(Level level, ParticleOptions particleType, BlockPos block, Entity entity, int count) {
        if (level instanceof ServerLevel serverLevel) {

            double deltaX = entity.getX() - block.getX();
            double deltaY = entity.getY() - block.getY();
            double deltaZ = entity.getZ() - block.getZ();

            for (int i = 0; i <= count; i++) {
                double progress = i / (double) count;
                double particleX = entity.getX() + deltaX * progress;
                double particleY = entity.getY() + deltaY * progress + 0.5;
                double particleZ = entity.getZ() + deltaZ * progress;

                serverLevel.sendParticles(particleType, particleX, particleY, particleZ,
                        1,0, 0, 0, 0);
            }
        }
    }

    /**
     * Creates a trail of particles from one block to another.
     */
    public static void ParticleTrailBlockToBlock(Level level, ParticleOptions particleType, BlockPos source, BlockPos destination, int count) {
        if (level instanceof ServerLevel serverLevel) {

            double deltaX = destination.getX() - source.getX();
            double deltaY = destination.getY() - source.getY();
            double deltaZ = destination.getZ() - source.getZ();

            for (int i = 0; i <= count; i++) {
                double progress = i / (double) count;
                double particleX = destination.getX() + deltaX * progress;
                double particleY = destination.getY() + deltaY * progress + 0.5;
                double particleZ = destination.getZ() + deltaZ * progress;

                serverLevel.sendParticles(particleType, particleX, particleY, particleZ,
                        1,0, 0, 0, 0);
            }
        }
    }




}

