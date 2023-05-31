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
public class ReducirTormentaProcedure extends PermadeathvModElements.ModElement {
	public ReducirTormentaProcedure(PermadeathvModElements instance) {
		super(instance, 59);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure ReducirTormenta!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((PermadeathvModVariables.MapVariables.get(world).tormenta) > 0)) {
			if (((PermadeathvModVariables.MapVariables.get(world).Tiempo) == 40)) {
				if ((world.getWorldInfo().isThundering() == (false))) {
					if (world instanceof ServerWorld) {
						((World) world).getServer().getCommandManager()
								.handleCommand(
										new CommandSource(ICommandSource.DUMMY, new Vector3d(1, 100, 1), Vector2f.ZERO, (ServerWorld) world, 4, "",
												new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
										"weather thunder");
					}
				}
				PermadeathvModVariables.MapVariables.get(world).tormenta = (double) ((PermadeathvModVariables.MapVariables.get(world).tormenta) - 1);
				PermadeathvModVariables.MapVariables.get(world).syncData(world);
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
