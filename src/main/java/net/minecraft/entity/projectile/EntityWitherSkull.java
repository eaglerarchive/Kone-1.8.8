package net.minecraft.entity.projectile;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

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
public class EntityWitherSkull extends EntityFireball {
	public EntityWitherSkull(World worldIn) {
		super(worldIn);
		this.setSize(0.3125F, 0.3125F);
	}

	public EntityWitherSkull(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
		super(worldIn, shooter, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}

	/**+
	 * Return the motion factor for this projectile. The factor is
	 * multiplied by the original motion.
	 */
	protected float getMotionFactor() {
		return this.isInvulnerable() ? 0.73F : super.getMotionFactor();
	}

	public EntityWitherSkull(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
		super(worldIn, x, y, z, accelX, accelY, accelZ);
		this.setSize(0.3125F, 0.3125F);
	}

	/**+
	 * Returns true if the entity is on fire. Used by render to add
	 * the fire effect on rendering.
	 */
	public boolean isBurning() {
		return false;
	}

	/**+
	 * Explosion resistance of a block relative to this entity
	 */
	public float getExplosionResistance(Explosion explosion, World world, BlockPos blockpos, IBlockState iblockstate) {
		float f = super.getExplosionResistance(explosion, world, blockpos, iblockstate);
		Block block = iblockstate.getBlock();
		if (this.isInvulnerable() && EntityWither.func_181033_a(block)) {
			f = Math.min(0.8F, f);
		}

		return f;
	}

	/**+
	 * Called when this EntityFireball hits a block or entity.
	 */
	protected void onImpact(MovingObjectPosition movingobjectposition) {

	}

	/**+
	 * Returns true if other Entities should be prevented from
	 * moving through this Entity.
	 */
	public boolean canBeCollidedWith() {
		return false;
	}

	/**+
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource var1, float var2) {
		return false;
	}

	protected void entityInit() {
		this.dataWatcher.addObject(10, Byte.valueOf((byte) 0));
	}

	/**+
	 * Return whether this skull comes from an invulnerable (aura)
	 * wither boss.
	 */
	public boolean isInvulnerable() {
		return this.dataWatcher.getWatchableObjectByte(10) == 1;
	}

	/**+
	 * Set whether this skull comes from an invulnerable (aura)
	 * wither boss.
	 */
	public void setInvulnerable(boolean invulnerable) {
		this.dataWatcher.updateObject(10, Byte.valueOf((byte) (invulnerable ? 1 : 0)));
	}
}