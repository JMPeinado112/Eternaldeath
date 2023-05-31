package net.mcreator.permadeathv.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Util;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Hand;
import net.minecraft.server.MinecraftServer;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.permadeathv.world.ActivarDia60GameRule;
import net.mcreator.permadeathv.world.ActivarDia55GameRule;
import net.mcreator.permadeathv.world.ActivarDia50GameRule;
import net.mcreator.permadeathv.world.ActivarDia45GameRule;
import net.mcreator.permadeathv.world.ActivarDia40GameRule;
import net.mcreator.permadeathv.world.ActivarDia35GameRule;
import net.mcreator.permadeathv.world.ActivarDia30GameRule;
import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.item.TotemDeLaPerdicionItem;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class TotemFailDia30Procedure extends PermadeathvModElements.ModElement {
	public TotemFailDia30Procedure(PermadeathvModElements instance) {
		super(instance, 38);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure TotemFailDia30!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency x for procedure TotemFailDia30!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency y for procedure TotemFailDia30!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency z for procedure TotemFailDia30!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure TotemFailDia30!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double random = 0;
		boolean fallo = false;
		random = (double) Math.random();
		fallo = (boolean) (false);
		if ((((entity instanceof PlayerEntity) || (entity instanceof ServerPlayerEntity))
				&& ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
						.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())
						|| (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
								.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())))) {
			if (!world.isRemote()) {
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
							(new java.text.DecimalFormat((("\u00A74\u00A7lEl \u00A74\u00A7ltotem \u00A74\u00A7lha \u00A74\u00A7lsalido ##.## - ") + ""
									+ ((entity.getDisplayName().getString())))).format((random)))),
							ChatType.SYSTEM, Util.DUMMY_UUID);
			}
		}
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (false))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, (int) 200, 3, 3, 3, 1);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 8);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 180, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 800, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 800, (int) 0));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, (int) 200, 3, 3, 3, 1);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 8);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 180, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 800, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 800, (int) 0));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (true))) {
			if ((0.0001 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia30GameRule.gamerule)) == (true))) {
			if ((0.01 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia35GameRule.gamerule)) == (true))) {
			if ((0.03 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia40GameRule.gamerule)) == (true))) {
			if ((0.06 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia45GameRule.gamerule)) == (true))) {
			if ((0.1 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia50GameRule.gamerule)) == (true))) {
			if ((0.2 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia55GameRule.gamerule)) == (true))) {
			if ((0.3 > (random))) {
				fallo = (boolean) (true);
			}
		} else if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia60GameRule.gamerule)) == (true))) {
			if ((0.5 > (random))) {
				fallo = (boolean) (true);
			}
		}
		if (((fallo) == (false))) {
			if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.TOTEM_OF_UNDYING, x, y, z, (int) 200, 3, 3, 3, 1);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 8);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 180, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 800, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 800, (int) 0));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			} else if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)
					.getItem() == new ItemStack(TotemDeLaPerdicionItem.block, (int) (1)).getItem())) {
				if (world instanceof ServerWorld) {
					((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 200, 3, 3, 3, 1);
				}
				if (world instanceof World && !world.isRemote()) {
					((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1);
				} else {
					((World) world).playSound(x, y, z,
							(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.totem.use")),
							SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).setHealth((float) 8);
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).clearActivePotions();
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.ABSORPTION, (int) 180, (int) 2));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 800, (int) 1));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, (int) 800, (int) 0));
				if (entity instanceof LivingEntity) {
					ItemStack _setstack = new ItemStack(Blocks.AIR, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.OFF_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (dependencies.get("event") != null) {
					Object _obj = dependencies.get("event");
					if (_obj instanceof Event) {
						Event _evt = (Event) _obj;
						if (_evt.isCancelable())
							_evt.setCanceled(true);
					}
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
