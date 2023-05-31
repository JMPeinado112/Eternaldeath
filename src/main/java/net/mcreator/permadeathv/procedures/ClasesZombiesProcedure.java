package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.Enchantments;

import net.mcreator.permadeathv.world.ActivarDia15GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class ClasesZombiesProcedure extends PermadeathvModElements.ModElement {
	public ClasesZombiesProcedure(PermadeathvModElements instance) {
		super(instance, 72);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure ClasesZombies!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure ClasesZombies!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double random = 0;
		ItemStack hacha = ItemStack.EMPTY;
		ItemStack pala = ItemStack.EMPTY;
		ItemStack botas = ItemStack.EMPTY;
		hacha = new ItemStack(Items.DIAMOND_AXE, (int) (1));
		pala = new ItemStack(Items.DIAMOND_SHOVEL, (int) (1));
		botas = new ItemStack(Items.NETHERITE_BOOTS, (int) (1));
		random = (double) Math.random();
		if ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule))) {
			if ((entity instanceof HuskEntity)) {
				if ((0.3 >= (random))) {
					entity.setCustomName(new StringTextComponent("\u00A76\u00A7lStandard Gentlemen"));
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.NETHERITE_HELMET, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.NETHERITE_HELMET, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.NETHERITE_CHESTPLATE, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.NETHERITE_CHESTPLATE, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.NETHERITE_LEGGINGS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.NETHERITE_LEGGINGS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.NETHERITE_BOOTS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.NETHERITE_BOOTS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD, (int) (1));
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				} else if (((0.6 >= (random)) && (0.3 < (random)))) {
					entity.setCustomName(new StringTextComponent("\u00A78\u00A7lDont touch Me"));
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.DIAMOND_HELMET, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.DIAMOND_HELMET, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.DIAMOND_LEGGINGS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.DIAMOND_LEGGINGS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.DIAMOND_BOOTS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.DIAMOND_BOOTS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (hacha);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					((hacha)).addEnchantment(Enchantments.SHARPNESS, (int) 5);
					((hacha)).addEnchantment(Enchantments.KNOCKBACK, (int) 10);
				} else if (((1 >= (random)) && (0.6 < (random)))) {
					entity.setCustomName(new StringTextComponent("\u00A72\u00A7lCocaine Zombie"));
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.DIAMOND_HELMET, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
									new ItemStack(Items.DIAMOND_HELMET, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
									new ItemStack(Items.DIAMOND_CHESTPLATE, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.DIAMOND_LEGGINGS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
									new ItemStack(Items.DIAMOND_LEGGINGS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).inventory.armorInventory.set((int) 0, new ItemStack(Items.DIAMOND_BOOTS, (int) (1)));
						else
							((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
									new ItemStack(Items.DIAMOND_BOOTS, (int) (1)));
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					if (entity instanceof LivingEntity) {
						ItemStack _setstack = (pala);
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
					((pala)).addEnchantment(Enchantments.SHARPNESS, (int) 5);
				}
			} else if ((entity instanceof DrownedEntity)) {
				entity.setCustomName(new StringTextComponent("\u00A71\u00A7lMarine Beast"));
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 3, new ItemStack(Items.NETHERITE_HELMET, (int) (1)));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3),
								new ItemStack(Items.NETHERITE_HELMET, (int) (1)));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 2, new ItemStack(Items.NETHERITE_CHESTPLATE, (int) (1)));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 2),
								new ItemStack(Items.NETHERITE_CHESTPLATE, (int) (1)));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 1, new ItemStack(Items.NETHERITE_LEGGINGS, (int) (1)));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 1),
								new ItemStack(Items.NETHERITE_LEGGINGS, (int) (1)));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				if (entity instanceof LivingEntity) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).inventory.armorInventory.set((int) 0, (botas));
					else
						((LivingEntity) entity).setItemStackToSlot(EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 0),
								(botas));
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
				((botas)).addEnchantment(Enchantments.DEPTH_STRIDER, (int) 3);
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
