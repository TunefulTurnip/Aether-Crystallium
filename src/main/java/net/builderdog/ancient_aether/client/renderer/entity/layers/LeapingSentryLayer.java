package net.builderdog.ancient_aether.client.renderer.entity.layers;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.entity.monster.dungeon.Sentry;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.entity.monster.LeapingSentry;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nonnull;

public class LeapingSentryLayer<T extends LeapingSentry, M extends SlimeModel<T>> extends EyesLayer<T, M> {
	private static final RenderType SENTRY_EYE = RenderType.eyes(new ResourceLocation(AncientAether.MOD_ID, "textures/entity/leaping_sentry/eye.png"));

	public LeapingSentryLayer(RenderLayerParent<T, M> entityRenderer) {
		super(entityRenderer);
	}

	@Override
	public void render(@Nonnull PoseStack poseStack, MultiBufferSource buffer, int packedLight, @Nonnull T sentry, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		VertexConsumer consumer = buffer.getBuffer(this.renderType());
		if (sentry.isAwake()) {
			this.getParentModel().renderToBuffer(poseStack, consumer, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		}
	}

	@Nonnull
	@Override
	public RenderType renderType() {
		return SENTRY_EYE;
	}
}