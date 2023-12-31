package net.minecraft.client.model;

import net.minecraft.util.Vec3;

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
public class PositionTextureVertex {
	public Vec3 vector3D;
	public float texturePositionX;
	public float texturePositionY;

	public PositionTextureVertex(float parFloat1, float parFloat2, float parFloat3, float parFloat4, float parFloat5) {
		this(new Vec3((double) parFloat1, (double) parFloat2, (double) parFloat3), parFloat4, parFloat5);
	}

	public PositionTextureVertex setTexturePosition(float parFloat1, float parFloat2) {
		return new PositionTextureVertex(this, parFloat1, parFloat2);
	}

	public PositionTextureVertex(PositionTextureVertex textureVertex, float texturePositionXIn,
			float texturePositionYIn) {
		this.vector3D = textureVertex.vector3D;
		this.texturePositionX = texturePositionXIn;
		this.texturePositionY = texturePositionYIn;
	}

	public PositionTextureVertex(Vec3 vector3DIn, float texturePositionXIn, float texturePositionYIn) {
		this.vector3D = vector3DIn;
		this.texturePositionX = texturePositionXIn;
		this.texturePositionY = texturePositionYIn;
	}
}