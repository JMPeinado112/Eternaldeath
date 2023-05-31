package net.mcreator.permadeathv.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.mcreator.permadeathv.PermadeathvModElements;

import java.lang.reflect.Method;

@PermadeathvModElements.ModElement.Tag
public class SkeletonToStrayDia5GameRule extends PermadeathvModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.BooleanValue> gamerule = GameRules.register("skeletonToStrayDia5", GameRules.Category.SPAWNING,
			create(false));
	public SkeletonToStrayDia5GameRule(PermadeathvModElements instance) {
		super(instance, 22);
	}

	public static GameRules.RuleType<GameRules.BooleanValue> create(boolean defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.BooleanValue.class, "func_223568_b", boolean.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.BooleanValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
