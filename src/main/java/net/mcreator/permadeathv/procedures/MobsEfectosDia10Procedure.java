package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia15GameRule;
import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

@PermadeathvModElements.ModElement.Tag
public class MobsEfectosDia10Procedure extends PermadeathvModElements.ModElement {
	public MobsEfectosDia10Procedure(PermadeathvModElements instance) {
		super(instance, 51);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure MobsEfectosDia10!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure MobsEfectosDia10!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (true))) {
			if ((((entity instanceof PlayerEntity) == (false)) || ((entity instanceof ServerPlayerEntity) == (false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 0));
				if ((600 > (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.STRENGTH)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity)))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 0));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 0));
				if ((600 > (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.RESISTANCE)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity)))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 0));
				}
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule)) == (true))) {
			if ((((entity instanceof PlayerEntity) == (false)) || ((entity instanceof ServerPlayerEntity) == (false)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 1));
				if ((600 > (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.STRENGTH)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity)))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 1));
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 1));
				if ((600 > (new Object() {
					int check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == Effects.RESISTANCE)
									return effect.getDuration();
							}
						}
						return 0;
					}
				}.check(entity)))) {
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 1));
				}
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
