package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class MagmaCubeProcedure extends PermadeathvModElements.ModElement {
	public MagmaCubeProcedure(PermadeathvModElements instance) {
		super(instance, 96);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure MagmaCube!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure MagmaCube!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule))) {
			if (((entity instanceof MagmaCubeEntity) && ((((entity.getDisplayName().getString())).equals("\u00A74HyperMagma")) == (false)))) {
				{
					Entity _ent = entity;
					if (!_ent.world.isRemote && _ent.world.getServer() != null) {
						_ent.world.getServer().getCommandManager().handleCommand(
								_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
								"summon magma_cube ~ ~ ~ {Size:15, CustomName:\"\\\"\u00A74HyperMagma\\\"\"}");
					}
				}
				if (!entity.world.isRemote())
					entity.remove();
			}
		}
	}

	@SubscribeEvent
	public void onEntityTick(LivingEvent.LivingUpdateEvent event) {
		Entity entity = event.getEntityLiving();
		World world = entity.world;
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
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
