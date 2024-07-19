package codenamed.extras.block.entity;

import codenamed.extras.Extras;
import codenamed.extras.registry.ExtrasBlockEntityType;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class JarBlockEntity extends BlockEntity implements Inventory {

    private final DefaultedList<ItemStack> inventory;

    private int currentSize = 0;


    public JarBlockEntity(BlockPos pos, BlockState state) {
        super(ExtrasBlockEntityType.JAR, pos, state);
        this.inventory = DefaultedList.ofSize(9, ItemStack.EMPTY);

    }

    public  int getCurrentSize() {
        return  this.currentSize;
    }

    @Override
    public int size() {
        return inventory.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getStack(int slot) {
        return inventory.get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        currentSize--;

        return null;
    }

    @Override
    public ItemStack removeStack(int slot) {
        currentSize--;
        Extras.LOGGER.info(inventory.getLast().toString());
        inventory.removeLast();
        return ItemStack.EMPTY;
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        inventory.set(slot, stack);
        currentSize++;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return false;
    }

    @Override
    public void clear() {

    }

    public  ItemStack getRenderStack(int index) {


        return getStack(index);
    }

    public void removeStack() {
        currentSize--;
    }
}