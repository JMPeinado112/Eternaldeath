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
public class CalcularTiempoProcedure extends PermadeathvModElements.ModElement {
	public CalcularTiempoProcedure(PermadeathvModElements instance) {
		super(instance, 64);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure CalcularTiempo!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double minutos = 0;
		double horas = 0;
		double dias = 0;
		if (((PermadeathvModVariables.MapVariables.get(world).tormenta) > 60)) {
			PermadeathvModVariables.MapVariables.get(world).tormenta = (double) ((PermadeathvModVariables.MapVariables.get(world).tormenta) - 60);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).minutos = (double) ((PermadeathvModVariables.MapVariables.get(world).minutos) + 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
		if (((PermadeathvModVariables.MapVariables.get(world).minutos) > 60)) {
			PermadeathvModVariables.MapVariables.get(world).minutos = (double) ((PermadeathvModVariables.MapVariables.get(world).minutos) - 60);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).horas = (double) ((PermadeathvModVariables.MapVariables.get(world).horas) + 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
		if (((PermadeathvModVariables.MapVariables.get(world).horas) > 24)) {
			PermadeathvModVariables.MapVariables.get(world).horas = (double) ((PermadeathvModVariables.MapVariables.get(world).horas) - 24);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).dias = (double) ((PermadeathvModVariables.MapVariables.get(world).dias) + 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((PermadeathvModVariables.MapVariables.get(world).tormenta) == 0) && ((PermadeathvModVariables.MapVariables.get(world).minutos) > 0))) {
			PermadeathvModVariables.MapVariables.get(world).tormenta = (double) ((PermadeathvModVariables.MapVariables.get(world).tormenta) + 60);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).minutos = (double) ((PermadeathvModVariables.MapVariables.get(world).minutos) - 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((PermadeathvModVariables.MapVariables.get(world).minutos) == 0) && ((PermadeathvModVariables.MapVariables.get(world).horas) > 0))) {
			PermadeathvModVariables.MapVariables.get(world).minutos = (double) ((PermadeathvModVariables.MapVariables.get(world).minutos) + 60);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).horas = (double) ((PermadeathvModVariables.MapVariables.get(world).horas) - 1);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
		}
		if ((((PermadeathvModVariables.MapVariables.get(world).horas) == 0) && ((PermadeathvModVariables.MapVariables.get(world).dias) > 0))) {
			PermadeathvModVariables.MapVariables.get(world).horas = (double) ((PermadeathvModVariables.MapVariables.get(world).horas) + 24);
			PermadeathvModVariables.MapVariables.get(world).syncData(world);
			PermadeathvModVariables.MapVariables.get(world).dias = (double) ((PermadeathvModVariables.MapVariables.get(world).dias) - 1);
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
