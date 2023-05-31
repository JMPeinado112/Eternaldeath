
package net.mcreator.permadeathv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.AxeItem;

import net.mcreator.permadeathv.PermadeathvModElements;

@PermadeathvModElements.ModElement.Tag
public class StrangeAxeItem extends PermadeathvModElements.ModElement {
	@ObjectHolder("permadeathv:strange_axe")
	public static final Item block = null;
	public StrangeAxeItem(PermadeathvModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new AxeItem(new IItemTier() {
			public int getMaxUses() {
				return 2050;
			}

			public float getEfficiency() {
				return 9f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 0;
			}

			public int getEnchantability() {
				return 15;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -3f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
		}.setRegistryName("strange_axe"));
	}
}
