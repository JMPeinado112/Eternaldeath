
package net.mcreator.permadeathv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.permadeathv.PermadeathvModElements;

@PermadeathvModElements.ModElement.Tag
public class StrangePickaxeItem extends PermadeathvModElements.ModElement {
	@ObjectHolder("permadeathv:strange_pickaxe")
	public static final Item block = null;
	public StrangePickaxeItem(PermadeathvModElements instance) {
		super(instance, 76);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2050;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -2.8f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
		}.setRegistryName("strange_pickaxe"));
	}
}
