package com.logisticscraft.logisticsapi.item;

import java.util.Optional;

import org.bukkit.inventory.ItemStack;

import com.logisticscraft.logisticsapi.data.LogisticBlockFace;
import com.logisticscraft.logisticsapi.data.LogisticDataHolder;

import lombok.NonNull;

public interface ItemStorage extends LogisticDataHolder {

	ItemStack extractItem(LogisticBlockFace extractionSide, int maxExtractAmount, boolean simulate);
	
	ItemStack insertItem(LogisticBlockFace insertSide, ItemStack insertedItem, boolean simulate);
	
	int howMuchSpaceForItemAsync(LogisticBlockFace insertDirection, ItemStack insertion);
	
    default boolean allowItemInsertion(@NonNull LogisticBlockFace blockFace, Optional<ItemStack> item){
    	return true;
    }
    
    default boolean allowItemExtraction(@NonNull LogisticBlockFace blockFace, Optional<ItemStack> item){
    	return true;
    }

}