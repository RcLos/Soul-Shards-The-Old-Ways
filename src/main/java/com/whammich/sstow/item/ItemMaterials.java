package com.whammich.sstow.item;

import com.google.common.collect.Lists;
import com.whammich.sstow.RegistrarSoulShards;
import com.whammich.sstow.SoulShardsTOW;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemMaterials extends Item {

    public static final String INGOT_CORRUPTED = "ingotCorrupted";
    public static final String CORRUPTED_ESSENCE = "dustCorrupted";
    public static final String DUST_VILE = "dustVile";

    private static List<String> names = Lists.newArrayList();

    public ItemMaterials() {
        super();

        setUnlocalizedName(SoulShardsTOW.MODID + ".material.");
        setCreativeTab(SoulShardsTOW.TAB_SS);
        setHasSubtypes(true);

        buildItems();
    }

    private void buildItems() {
        names.add(0, INGOT_CORRUPTED);
        names.add(1, CORRUPTED_ESSENCE);
        names.add(2, DUST_VILE);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return getUnlocalizedName() + names.get(stack.getItemDamage());
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> list) {
        for (int i = 0; i < names.size(); i++)
            list.add(new ItemStack(this, 1, i));
    }

    public static ItemStack getStack(String name, int amount) {
        return new ItemStack(RegistrarSoulShards.MATERIALS, amount, names.indexOf(name));
    }

    public static ItemStack getStack(String name) {
        return getStack(name, 1);
    }
}
