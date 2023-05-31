package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia15GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class CocaineZombieProcedure extends PermadeathvModElements.ModElement {
	public CocaineZombieProcedure(PermadeathvModElements instance) {
		super(instance, 73);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure CocaineZombie!");
			return;
		}
		if (dependencies.get("sourceentity") == null) {
			if (!dependencies.containsKey("sourceentity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency sourceentity for procedure CocaineZombie!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure CocaineZombie!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((sourceentity instanceof HuskEntity)) {
			if ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule))) {
				if ((((sourceentity.getDisplayName().getString())).equals("\u00A72\u00A7lCocaine Zombie"))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, (int) 200, (int) 1));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.NAUSEA, (int) 200, (int) 1));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.POISON, (int) 200, (int) 0));
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
