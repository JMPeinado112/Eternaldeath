
package net.mcreator.permadeathv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.permadeathv.PermadeathvModElements;

@PermadeathvModElements.ModElement.Tag
public class StrangeSwordItem extends PermadeathvModElements.ModElement {
	@ObjectHolder("permadeathv:strange_sword")
	public static final Item block = null;
	public StrangeSwordItem(PermadeathvModElements instance) {
		super(instance, 77);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 2050;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 2;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.4f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
		}.setRegistryName("strange_sword"));
	}
}
