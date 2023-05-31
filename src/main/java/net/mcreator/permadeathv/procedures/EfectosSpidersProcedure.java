package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia5GameRule;
import net.mcreator.permadeathv.world.ActivarDia15GameRule;
import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class EfectosSpidersProcedure extends PermadeathvModElements.ModElement {
	public EfectosSpidersProcedure(PermadeathvModElements instance) {
		super(instance, 23);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure EfectosSpiders!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure EfectosSpiders!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double random = 0;
		random = (double) Math.random();
		if ((((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia5GameRule.gamerule)) == (true))
				&& ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (false)))) {
			if ((entity instanceof SpiderEntity)) {
				if ((((0.15 > (random)) && (0 < Math.random())) || (0 == (random)))) {
					entity.setCustomName(new StringTextComponent("Death Tank"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 2));
				} else if ((((0.3 > (random)) && (0.15 < (random))) || (0.15 == (random)))) {
					entity.setCustomName(new StringTextComponent("Unkillable"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				} else if ((((0.45 > (random)) && (0.3 < (random))) || (0.3 == (random)))) {
					entity.setCustomName(new StringTextComponent("can't run"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				} else if ((((0.6 > (random)) && (0.45 < (random))) || (0.45 == (random)))) {
					entity.setCustomName(new StringTextComponent("Eternal Unseen"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				} else if ((((0.75 > (random)) && (0.6 < (random))) || (0.6 == (random)))) {
					entity.setCustomName(new StringTextComponent("RUN"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 2));
				} else if ((((0.9 > (random)) && (0.75 < (random))) || (0.75 == (random)))) {
					entity.setCustomName(new StringTextComponent("Invisible Dead"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 2));
				} else if ((((1 > (random)) && (0.9 < (random))) || (0.9 == (random)))) {
					entity.setCustomName(new StringTextComponent("IM RETARDED"));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 999999999, (int) 0));
					if (entity instanceof LivingEntity)
						((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 0));
				}
			}
		} else if (((((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (true))
				&& ((entity instanceof SpiderEntity) == (true)))
				&& ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule)) == (false)))) {
			if ((((0.15 > (random)) && (0 < (random))) || (0 == (random)))) {
				entity.setCustomName(new StringTextComponent("Inmortal Dead"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if ((((0.3 > (random)) && (0.15 < (random))) || (0.15 == (random)))) {
				entity.setCustomName(new StringTextComponent("Useless"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if ((((0.45 > (random)) && (0.3 < (random))) || (0.3 == (random)))) {
				entity.setCustomName(new StringTextComponent("Invisible Dead"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if ((((0.6 > (random)) && (0.45 < (random))) || (0.45 == (random)))) {
				entity.setCustomName(new StringTextComponent("Eternal Unseen"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if ((((0.75 > (random)) && (0.6 < (random))) || (0.6 == (random)))) {
				entity.setCustomName(new StringTextComponent("RUN"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if ((((0.9 > (random)) && (0.75 < (random))) || (0.75 == (random)))) {
				entity.setCustomName(new StringTextComponent("Look at me, really"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if (((((1 > (random)) && (0.9 < (random))) || (0.9 == (random))) || (1 == (random)))) {
				entity.setCustomName(new StringTextComponent("IM RETARDED"));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.GLOWING, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule))
				&& ((entity instanceof BlazeEntity) || (entity instanceof SpiderEntity)))) {
			if ((0.3 > (random))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 4));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if (((0.6 > (random)) && (0.3 < (random)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.INVISIBILITY, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
			} else if (((1 > (random)) && (0.6 < (random)))) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.STRENGTH, (int) 999999999, (int) 4));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 999999999, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 999999999, (int) 3));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 999999999, (int) 7));
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
