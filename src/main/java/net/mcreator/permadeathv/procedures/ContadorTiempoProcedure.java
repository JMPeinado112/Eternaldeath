package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import net.mcreator.permadeathv.PermadeathvModVariables;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class ContadorTiempoProcedure extends PermadeathvModElements.ModElement {
	public ContadorTiempoProcedure(PermadeathvModElements instance) {
		super(instance, 58);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure ContadorTiempo!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((PermadeathvModVariables.MapVariables.get(world).Tiempo) == 0)) {
			PermadeathvModVariables.MapVariables.get(world).Tiempo = (double) 40;
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		} else {
			PermadeathvModVariables.MapVariables.get(world).Tiempo = (double) ((PermadeathvModVariables.MapVariables.get(world).Tiempo) - 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
	}

	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			IWorld world = event.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", world);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
