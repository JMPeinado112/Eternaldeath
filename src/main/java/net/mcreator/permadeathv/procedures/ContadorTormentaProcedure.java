package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.permadeathv.PermadeathvModVariables;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class ContadorTormentaProcedure extends PermadeathvModElements.ModElement {
	public ContadorTormentaProcedure(PermadeathvModElements instance) {
		super(instance, 57);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure ContadorTormenta!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double tiempo = 0;
		if (((PermadeathvModVariables.MapVariables.get(world).tormenta) > 0)) {
			if (((PermadeathvModVariables.MapVariables.get(world).Tiempo) == 40)) {
				if (world instanceof ServerWorld) {
					((World) world).getServer().getCommandManager().handleCommand(
							new CommandSource(ICommandSource.DUMMY, new Vector3d(0, 0, 0), Vector2f.ZERO, (ServerWorld) world, 4, "",
									new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
							(("title ") + "" + ("@a ") + "" + ("actionbar \"") + "" + ((((("Quedan ") + ""
									+ ((new java.text.DecimalFormat("##.#").format((PermadeathvModVariables.MapVariables.get(world).dias)))) + ""
									+ (":") + ""
									+ ((new java.text.DecimalFormat("##.#").format((PermadeathvModVariables.MapVariables.get(world).horas)))) + ""
									+ (":")))
									+ ""
									+ ((((new java.text.DecimalFormat("##.#").format((PermadeathvModVariables.MapVariables.get(world).minutos)))) + ""
											+ (":") + ""
											+ ((new java.text.DecimalFormat("##.#")
													.format((PermadeathvModVariables.MapVariables.get(world).tormenta))))
											+ "" + (" de tormenta\"")))))));
				}
			}
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
