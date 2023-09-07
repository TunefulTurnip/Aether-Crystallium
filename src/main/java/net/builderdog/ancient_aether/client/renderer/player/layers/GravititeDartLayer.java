package net.builderdog.ancient_aether.client.renderer.player.layers;

import com.aetherteam.aether.client.renderer.player.layer.AbstractDartLayer;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.entity.projectile.dart.AbstractDart;
import com.aetherteam.aether.entity.projectile.dart.GoldenDart;
import com.mojang.blaze3d.vertex.PoseStack;
import net.builderdog.ancient_aether.capability.player.AncientAetherPlayer;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nonnull;
import java.util.Optional;

public class GravititeDartLayer<T extends LivingEntity, M extends PlayerModel<T>> extends AbstractDartLayer<T, M> {
    public GravititeDartLayer(EntityRenderDispatcher renderDispatcher, LivingEntityRenderer<T, M> renderer) {
        super(renderDispatcher, renderer);
    }

    protected int numStuck(@Nonnull T entity) {
        if (entity instanceof Player player) {
            Optional<AncientAetherPlayer> ancientAetherPlayerOptional = AncientAetherPlayer.get(player).resolve();
            if (ancientAetherPlayerOptional.isPresent()) {
                return (ancientAetherPlayerOptional.get()).getGravititeDartCount();
            }
        }
        return 0;
    }

    protected void renderStuckItem(@Nonnull PoseStack poseStack, @Nonnull MultiBufferSource buffer, int packedLight, @Nonnull Entity entity, float f, float f1, float f2, float partialTicks) {
        AbstractDart dart = new GoldenDart(AetherEntityTypes.GOLDEN_DART.get(), entity.level);
        dart.setPos(entity.getX(), entity.getY(), entity.getZ());
        this.renderStuckDart(dart, poseStack, buffer, packedLight, entity, f, f1, f2, partialTicks);
    }
}