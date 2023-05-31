package net.mcreator.permadeathv.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.Hand;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.permadeathv.world.ActivarDia15GameRule;
import net.mcreator.permadeathv.world.ActivarDia10GameRule;
import net.mcreator.permadeathv.PermadeathvModElements;
import net.mcreator.permadeathv.PermadeathvMod;

import java.util.Map;
import java.util.HashMap;

@PermadeathvModElements.ModElement.Tag
public class DiamondArmorEntitysProcedure extends PermadeathvModElements.ModElement {
	public DiamondArmorEntitysProcedure(PermadeathvModElements instance) {
		super(instance, 9);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency entity for procedure DiamondArmorEntitys!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PermadeathvMod.LOGGER.warn("Failed to load dependency world for procedure DiamondArmorEntitys!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (true))) {
			if ((entity instanceof WitherSkeletonEntity)) {
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
					ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD, (int) (1));
					_setstack.setCount((int) 1);
					((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
					if (entity instanceof ServerPlayerEntity)
						((ServerPlayerEntity) entity).inventory.markDirty();
				}
			} else if ((((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia10GameRule.gamerule)) == (true))
					&& ((world.getWorldInfo().getGameRulesInstance().getBoolean(ActivarDia15GameRule.gamerule)) == (false)))) {
				if ((entity instanceof ZombieEntity)) {
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
						ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD, (int) (1));
						_setstack.setCount((int) 1);
						((LivingEntity) entity).setHeldItem(Hand.MAIN_HAND, _setstack);
						if (entity instanceof ServerPlayerEntity)
							((ServerPlayerEntity) entity).inventory.markDirty();
					}
				}
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
