package net.minecraft.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.BaseAttributeMap;
import net.minecraft.util.ResourceLocation;

/**+
 * This portion of EaglercraftX contains deobfuscated Minecraft 1.8 source code.
 * 
 * Minecraft 1.8.8 bytecode is (c) 2015 Mojang AB. "Do not distribute!"
 * Mod Coder Pack v9.18 deobfuscation configs are (c) Copyright by the MCP Team
 * 
 * EaglercraftX 1.8 patch files are (c) 2022 LAX1DUDE. All Rights Reserved.
 * 
 * WITH THE EXCEPTION OF PATCH FILES, MINIFIED JAVASCRIPT, AND ALL FILES
 * NORMALLY FOUND IN AN UNMODIFIED MINECRAFT RESOURCE PACK, YOU ARE NOT ALLOWED
 * TO SHARE, DISTRIBUTE, OR REPURPOSE ANY FILE USED BY OR PRODUCED BY THE
 * SOFTWARE IN THIS REPOSITORY WITHOUT PRIOR PERMISSION FROM THE PROJECT AUTHOR.
 * 
 * NOT FOR COMMERCIAL OR MALICIOUS USE
 * 
 * (please read the 'LICENSE' file this repo's root directory for more info) 
 * 
 */
public class PotionAbsorption extends Potion {
	protected PotionAbsorption(int potionID, ResourceLocation location, boolean badEffect, int potionColor) {
		super(potionID, location, badEffect, potionColor);
	}

	public void removeAttributesModifiersFromEntity(EntityLivingBase entityLivingBaseIn, BaseAttributeMap amplifier,
			int parInt1) {
		entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() - (float) (4 * (parInt1 + 1)));
		super.removeAttributesModifiersFromEntity(entityLivingBaseIn, amplifier, parInt1);
	}

	public void applyAttributesModifiersToEntity(EntityLivingBase entityLivingBaseIn, BaseAttributeMap amplifier,
			int parInt1) {
		entityLivingBaseIn.setAbsorptionAmount(entityLivingBaseIn.getAbsorptionAmount() + (float) (4 * (parInt1 + 1)));
		super.applyAttributesModifiersToEntity(entityLivingBaseIn, amplifier, parInt1);
	}
}