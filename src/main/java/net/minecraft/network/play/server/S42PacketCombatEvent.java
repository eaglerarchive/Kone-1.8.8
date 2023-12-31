package net.minecraft.network.play.server;

import java.io.IOException;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.util.CombatTracker;

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
public class S42PacketCombatEvent implements Packet<INetHandlerPlayClient> {
	public S42PacketCombatEvent.Event eventType;
	public int field_179774_b;
	public int field_179775_c;
	public int field_179772_d;
	public String deathMessage;

	public S42PacketCombatEvent() {
	}

	public S42PacketCombatEvent(CombatTracker combatTrackerIn, S42PacketCombatEvent.Event combatEventType) {
		this.eventType = combatEventType;
		EntityLivingBase entitylivingbase = combatTrackerIn.func_94550_c();
		switch (combatEventType) {
		case END_COMBAT:
			this.field_179772_d = combatTrackerIn.func_180134_f();
			this.field_179775_c = entitylivingbase == null ? -1 : entitylivingbase.getEntityId();
			break;
		case ENTITY_DIED:
			this.field_179774_b = combatTrackerIn.getFighter().getEntityId();
			this.field_179775_c = entitylivingbase == null ? -1 : entitylivingbase.getEntityId();
			this.deathMessage = combatTrackerIn.getDeathMessage().getUnformattedText();
		}

	}

	/**+
	 * Reads the raw packet data from the data stream.
	 */
	public void readPacketData(PacketBuffer parPacketBuffer) throws IOException {
		this.eventType = (S42PacketCombatEvent.Event) parPacketBuffer.readEnumValue(S42PacketCombatEvent.Event.class);
		if (this.eventType == S42PacketCombatEvent.Event.END_COMBAT) {
			this.field_179772_d = parPacketBuffer.readVarIntFromBuffer();
			this.field_179775_c = parPacketBuffer.readInt();
		} else if (this.eventType == S42PacketCombatEvent.Event.ENTITY_DIED) {
			this.field_179774_b = parPacketBuffer.readVarIntFromBuffer();
			this.field_179775_c = parPacketBuffer.readInt();
			this.deathMessage = parPacketBuffer.readStringFromBuffer(32767);
		}

	}

	/**+
	 * Writes the raw packet data to the data stream.
	 */
	public void writePacketData(PacketBuffer parPacketBuffer) throws IOException {
		parPacketBuffer.writeEnumValue(this.eventType);
		if (this.eventType == S42PacketCombatEvent.Event.END_COMBAT) {
			parPacketBuffer.writeVarIntToBuffer(this.field_179772_d);
			parPacketBuffer.writeInt(this.field_179775_c);
		} else if (this.eventType == S42PacketCombatEvent.Event.ENTITY_DIED) {
			parPacketBuffer.writeVarIntToBuffer(this.field_179774_b);
			parPacketBuffer.writeInt(this.field_179775_c);
			parPacketBuffer.writeString(this.deathMessage);
		}

	}

	/**+
	 * Passes this Packet on to the NetHandler for processing.
	 */
	public void processPacket(INetHandlerPlayClient inethandlerplayclient) {
		inethandlerplayclient.handleCombatEvent(this);
	}

	public static enum Event {
		ENTER_COMBAT, END_COMBAT, ENTITY_DIED;
	}
}