package net.minecraft.client.gui.inventory;

import net.lax1dude.eaglercraft.v1_8.opengl.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerBrewingStand;
import net.minecraft.inventory.IInventory;
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
public class GuiBrewingStand extends GuiContainer {
	private static final ResourceLocation brewingStandGuiTextures = new ResourceLocation(
			"textures/gui/container/brewing_stand.png");
	private final InventoryPlayer playerInventory;
	private IInventory tileBrewingStand;

	public GuiBrewingStand(InventoryPlayer playerInv, IInventory parIInventory) {
		super(new ContainerBrewingStand(playerInv, parIInventory));
		this.playerInventory = playerInv;
		this.tileBrewingStand = parIInventory;
	}

	/**+
	 * Draw the foreground layer for the GuiContainer (everything in
	 * front of the items). Args : mouseX, mouseY
	 */
	protected void drawGuiContainerForegroundLayer(int var1, int var2) {
		String s = this.tileBrewingStand.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8,
				this.ySize - 96 + 2, 4210752);
	}

	/**+
	 * Args : renderPartialTicks, mouseX, mouseY
	 */
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(brewingStandGuiTextures);
		int i = (this.width - this.xSize) / 2;
		int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		int k = this.tileBrewingStand.getField(0);
		if (k > 0) {
			int l = (int) (28.0F * (1.0F - (float) k / 400.0F));
			if (l > 0) {
				this.drawTexturedModalRect(i + 97, j + 16, 176, 0, 9, l);
			}

			int i1 = k / 2 % 7;
			switch (i1) {
			case 0:
				l = 29;
				break;
			case 1:
				l = 24;
				break;
			case 2:
				l = 20;
				break;
			case 3:
				l = 16;
				break;
			case 4:
				l = 11;
				break;
			case 5:
				l = 6;
				break;
			case 6:
				l = 0;
			}

			if (l > 0) {
				this.drawTexturedModalRect(i + 65, j + 14 + 29 - l, 185, 29 - l, 12, l);
			}
		}

	}
}