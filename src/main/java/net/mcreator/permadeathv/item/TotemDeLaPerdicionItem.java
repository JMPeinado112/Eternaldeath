
package net.mcreator.permadeathv.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.permadeathv.PermadeathvModElements;

import java.util.List;

@PermadeathvModElements.ModElement.Tag
public class TotemDeLaPerdicionItem extends PermadeathvModElements.ModElement {
	@ObjectHolder("permadeathv:totem_de_la_perdicion")
	public static final Item block = null;
	public TotemDeLaPerdicionItem(PermadeathvModElements instance) {
		super(instance, 25);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ItemGroup.COMBAT).maxStackSize(1).isImmuneToFire().rarity(Rarity.EPIC));
			setRegistryName("totem_de_la_perdicion");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Es un totem"));
			list.add(new StringTextComponent("o no..."));
		}
	}
}
