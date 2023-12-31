package net.minecraft.network.play.server;

import java.io.IOException;

import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;

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
public class S1FPacketSetExperience implements Packet<INetHandlerPlayClient> {
	private float field_149401_a;
	private int totalExperience;
	private int level;

	public S1FPacketSetExperience() {
	}

	public S1FPacketSetExperience(float parFloat1, int totalExperienceIn, int levelIn) {
		this.field_149401_a = parFloat1;
		this.totalExperience = totalExperienceIn;
		this.level = levelIn;
	}

	/**+
	 * Reads the raw packet data from the data stream.
	 */
	public void readPacketData(PacketBuffer parPacketBuffer) throws IOException {
		this.field_149401_a = parPacketBuffer.readFloat();
		this.level = parPacketBuffer.readVarIntFromBuffer();
		this.totalExperience = parPacketBuffer.readVarIntFromBuffer();
	}

	/**+
	 * Writes the raw packet data to the data stream.
	 */
	public void writePacketData(PacketBuffer parPacketBuffer) throws IOException {
		parPacketBuffer.writeFloat(this.field_149401_a);
		parPacketBuffer.writeVarIntToBuffer(this.level);
		parPacketBuffer.writeVarIntToBuffer(this.totalExperience);
	}

	/**+
	 * Passes this Packet on to the NetHandler for processing.
	 */
	public void processPacket(INetHandlerPlayClient inethandlerplayclient) {
		inethandlerplayclient.handleSetExperience(this);
	}

	public float func_149397_c() {
		return this.field_149401_a;
	}

	public int getTotalExperience() {
		return this.totalExperience;
	}

	public int getLevel() {
		return this.level;
	}
}