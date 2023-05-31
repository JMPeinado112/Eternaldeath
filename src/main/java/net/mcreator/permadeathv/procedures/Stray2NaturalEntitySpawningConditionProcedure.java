package net.mcreator.permadeathv.procedures;

import net.minecraft.world.IWorld;

import net.mcreator.permadeathv.world.SkeletonToStrayDia5GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;

@PermadeathvModElements.ModElement.Tag
public class Stray2NaturalEntitySpawningConditionProcedure extends PermadeathvModElements.ModElement {
	public Stray2NaturalEntitySpawningConditionProcedure(PermadeathvModElements instance) {
		super(instance, 20);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure Stray2NaturalEntitySpawningCondition!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(SkeletonToStrayDia5GameRule.gamerule)) == (true))) {
			return (true);
		}
		return (false);
	}
}
