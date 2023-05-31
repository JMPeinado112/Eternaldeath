package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class PiglinZombiDropProcedure extends PermadeathvModElements.ModElement {
	public PiglinZombiDropProcedure(PermadeathvModElements instance) {
		super(instance, 46);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure PiglinZombiDrop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency x for procedure PiglinZombiDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency y for procedure PiglinZombiDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency z for procedure PiglinZombiDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure PiglinZombiDrop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof ZombifiedPiglinEntity)) {
			if (((0.025 > Math.random()) && ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (false)))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_INGOT, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
			if (((0.7 > Math.random()) && ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (false)))) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z, new ItemStack(Items.GOLD_NUGGET, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
