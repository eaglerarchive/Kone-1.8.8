package net.minecraft.client.model;

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
public class ModelChest extends ModelBase {
	/**+
	 * The chest lid in the chest's model.
	 */
	public ModelRenderer chestLid = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
	public ModelRenderer chestBelow;
	public ModelRenderer chestKnob;

	public ModelChest() {
		this.chestLid.addBox(0.0F, -5.0F, -14.0F, 14, 5, 14, 0.0F);
		this.chestLid.rotationPointX = 1.0F;
		this.chestLid.rotationPointY = 7.0F;
		this.chestLid.rotationPointZ = 15.0F;
		this.chestKnob = (new ModelRenderer(this, 0, 0)).setTextureSize(64, 64);
		this.chestKnob.addBox(-1.0F, -2.0F, -15.0F, 2, 4, 1, 0.0F);
		this.chestKnob.rotationPointX = 8.0F;
		this.chestKnob.rotationPointY = 7.0F;
		this.chestKnob.rotationPointZ = 15.0F;
		this.chestBelow = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
		this.chestBelow.addBox(0.0F, 0.0F, 0.0F, 14, 10, 14, 0.0F);
		this.chestBelow.rotationPointX = 1.0F;
		this.chestBelow.rotationPointY = 6.0F;
		this.chestBelow.rotationPointZ = 1.0F;
	}

	/**+
	 * This method renders out all parts of the chest model.
	 */
	public void renderAll() {
		this.chestKnob.rotateAngleX = this.chestLid.rotateAngleX;
		this.chestLid.render(0.0625F);
		this.chestKnob.render(0.0625F);
		this.chestBelow.render(0.0625F);
	}
}