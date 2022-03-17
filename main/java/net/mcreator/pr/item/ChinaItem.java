
package net.mcreator.pr.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.entity.Entity;

import net.mcreator.pr.procedures.ChinaDangGongJuChuXianZaiShouZhongShiProcedure;
import net.mcreator.pr.PrModElements;

import java.util.Map;
import java.util.HashMap;

@PrModElements.ModElement.Tag
public class ChinaItem extends PrModElements.ModElement {
	@ObjectHolder("pr:china")
	public static final Item block = null;
	public ChinaItem(PrModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new SwordItem(new IItemTier() {
			public int getMaxUses() {
				return 100;
			}

			public float getEfficiency() {
				return 4f;
			}

			public float getAttackDamage() {
				return 1232f;
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
		}, 3, -3f, new Item.Properties().group(ItemGroup.COMBAT).isImmuneToFire()) {
			@Override
			public boolean hasContainerItem() {
				return true;
			}

			@Override
			public ItemStack getContainerItem(ItemStack itemstack) {
				return new ItemStack(this);
			}

			@Override
			public boolean isRepairable(ItemStack itemstack) {
				return false;
			}

			@Override
			public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
				super.inventoryTick(itemstack, world, entity, slot, selected);
				double x = entity.getPosX();
				double y = entity.getPosY();
				double z = entity.getPosZ();
				if (selected) {
					Map<String, Object> $_dependencies = new HashMap<>();
					$_dependencies.put("entity", entity);
					ChinaDangGongJuChuXianZaiShouZhongShiProcedure.executeProcedure($_dependencies);
				}
			}
		}.setRegistryName("china"));
	}
}
