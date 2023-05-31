package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia5GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class ZombieDia5Procedure extends PermadeathvModElements.ModElement {
	public ZombieDia5Procedure(PermadeathvModElements instance) {
		super(instance, 16);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure ZombieDia5!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure ZombieDia5!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof ZombieEntity)) {
			if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia5GameRule.gamerule)) == (true))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 1));
			}
		}
	}

	@SubscribeEvent
	public void onEntitySpawned(EntityJoinWorldEvent event) {
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
