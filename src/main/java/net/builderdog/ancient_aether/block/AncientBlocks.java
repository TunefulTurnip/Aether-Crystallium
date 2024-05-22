package net.builderdog.ancient_aether.block;

import com.aetherteam.aether.block.construction.BookshelfBlock;
import com.aetherteam.aether.block.dungeon.DoorwayBlock;
import com.aetherteam.aether.block.dungeon.TrappedBlock;
import com.aetherteam.aether.block.dungeon.TreasureDoorwayBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropBlock;
import com.aetherteam.aether.block.natural.AetherDoubleDropsLeaves;
import com.aetherteam.aether.block.natural.AetherDoubleDropsOreBlock;
import com.aetherteam.aether.block.natural.AetherLogBlock;
import com.aetherteam.aether.effect.AetherEffects;
import com.aetherteam.aether.entity.AetherEntityTypes;
import com.aetherteam.aether.mixin.mixins.common.accessor.FireBlockAccessor;
import net.builderdog.ancient_aether.AncientAether;
import net.builderdog.ancient_aether.block.blocktype.*;
import net.builderdog.ancient_aether.data.resources.AncientLoot;
import net.builderdog.ancient_aether.entity.AncientEntityTypes;
import net.builderdog.ancient_aether.item.AncientItems;
import net.builderdog.ancient_aether.world.tree.AncientTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.minecraft.world.level.block.Blocks.*;

@SuppressWarnings("deprecation")
public class AncientBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AncientAether.MODID);

    public static final DeferredBlock<Block> GRAVITY_GRAVEL = register("gravity_gravel", () -> new AetherDoubleDropBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE).jumpFactor(1.5F).strength(0.25F).sound(SoundType.GRAVEL)));
    public static final DeferredBlock<Block> WYND_ICE = register("wynd_ice", () -> new Block(Block.Properties.ofFullCopy(PACKED_ICE)));
    public static final DeferredBlock<Block> VALKYRIE_CLAY = register("valkyrie_clay", () -> new AetherDoubleDropBlock(Block.Properties.ofFullCopy(CLAY).mapColor(MapColor.SNOW)));

    public static final DeferredBlock<Block> AETHER_QUARTZ_ORE = register("aether_quartz_ore", () -> new AetherDoubleDropsOreBlock(UniformInt.of(2, 5), Block.Properties.ofFullCopy(NETHER_QUARTZ_ORE)));
    public static final DeferredBlock<Block> VALKYRUM_ORE = register("valkyrum_ore", () -> new ValkyrumBlock(Block.Properties.of().strength(5.0F, 5.0F).requiresCorrectToolForDrops().mapColor(MapColor.QUARTZ)));
    public static final DeferredBlock<Block> ATMOSINE_CRYSTAL = register("atmosine_crystal", () -> new AtmosineCrystalBlock(BlockBehaviour.Properties.of().strength(3.0F, 3.0F).mapColor(MapColor.COLOR_PINK).requiresCorrectToolForDrops().sound(SoundType.GLASS).noOcclusion().lightLevel(s -> 5)));

    public static final DeferredBlock<Block> CRYSTAL_SKYROOT_LEAVES = register("crystal_skyroot_leaves", () -> leaves(MapColor.DIAMOND, SoundType.GRASS));
    public static final DeferredBlock<Block> ENCHANTED_SKYROOT_LEAVES = register("enchanted_skyroot_leaves", () -> leaves(MapColor.COLOR_BLUE, SoundType.GRASS));
    public static final DeferredBlock<Block> SKYROOT_PINE_LEAVES = register("skyroot_pine_leaves", () -> leaves(MapColor.GRASS, SoundType.GRASS));
    public static final DeferredBlock<Block> BLUE_SKYROOT_PINE_LEAVES = register("blue_skyroot_pine_leaves", () -> leaves(MapColor.DIAMOND, SoundType.GRASS));
    public static final DeferredBlock<Block> HIGHSPROOT_LEAVES = register("highsproot_leaves", () -> leaves(MapColor.COLOR_LIGHT_BLUE, SoundType.GRASS));
    public static final DeferredBlock<Block> SAKURA_LEAVES = register("sakura_leaves", () -> leaves(MapColor.COLOR_PINK, SoundType.CHERRY_LEAVES));

    public static final DeferredBlock<Block> CRYSTAL_SKYROOT_SAPLING = register("crystal_skyroot_sapling", () -> new SaplingBlock(AncientTreeGrowers.CRYSTAL_SKYROOT, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));
    public static final DeferredBlock<Block> ENCHANTED_SKYROOT_SAPLING = register("enchanted_skyroot_sapling", () -> new SaplingBlock(AncientTreeGrowers.ENCHANTED_SKYROOT, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));
    public static final DeferredBlock<Block> SKYROOT_PINE_SAPLING = register("skyroot_pine_sapling", () -> new SaplingBlock(AncientTreeGrowers.SKYROOT_PINE_TREE, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));
    public static final DeferredBlock<Block> BLUE_SKYROOT_PINE_SAPLING = register("blue_skyroot_pine_sapling", () -> new SaplingBlock(AncientTreeGrowers.BLUE_SKYROOT_PINE_TREE, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));
    public static final DeferredBlock<Block> HIGHSPROOT_SAPLING = register("highsproot_sapling", () -> new SaplingBlock(AncientTreeGrowers.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));
    public static final DeferredBlock<Block> SAKURA_SAPLING = register("sakura_sapling", () -> new SaplingBlock(AncientTreeGrowers.SAKURA, BlockBehaviour.Properties.ofFullCopy(OAK_SAPLING)));

    public static final DeferredBlock<Block> SKY_GRASS = register("sky_grass", () -> new SkyGrassBlock(Block.Properties.ofFullCopy(SHORT_GRASS).offsetType(BlockBehaviour.OffsetType.XZ).hasPostProcess(AncientBlocks::always)));
    public static final DeferredBlock<Block> SUNSET_ROSE = register("sunset_rose", () -> new FlowerBlock(MobEffects.REGENERATION, 8, Block.Properties.ofFullCopy(DANDELION)));
    public static final DeferredBlock<Block> SKY_BLUES = register("sky_blues", () -> new FlowerBlock(AetherEffects.REMEDY, 6, Block.Properties.ofFullCopy(DANDELION)));
    public static final DeferredBlock<Block> WYND_THISTLE = register("wynd_thistle", () -> new FlowerBlock(MobEffects.SLOW_FALLING, 7, Block.Properties.ofFullCopy(DANDELION)));
    public static final DeferredBlock<Block> ELEVETIA = register("elevetia", () -> new FlowerBlock(MobEffects.LEVITATION, 4, Block.Properties.ofFullCopy(DANDELION)));
    public static final DeferredBlock<GrapeVineBlock> GRAPE_VINE = BLOCKS.register("grape_vine", () -> new GrapeVineBlock(Block.Properties.ofFullCopy(VINE).noLootTable()));
    public static final DeferredBlock<Block> SLAMMROOT_PLANT = BLOCKS.register("slammroot_plant", () -> new SlammrootPlantBlock(Block.Properties.of().offsetType(BlockBehaviour.OffsetType.XYZ).dynamicShape().noOcclusion().noCollission().mapColor(MapColor.PLANT).sound(SoundType.HANGING_ROOTS).instabreak().pushReaction(PushReaction.DESTROY).noTerrainParticles().noLootTable()));

    public static final DeferredBlock<RotatedPillarBlock> HIGHSPROOT_LOG = register("highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> HIGHSPROOT_WOOD = register("highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_HIGHSPROOT_LOG = register("stripped_highsproot_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_HIGHSPROOT_WOOD = register("stripped_highsproot_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> SAKURA_LOG = register("sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> SAKURA_WOOD = register("sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SAKURA_LOG = register("stripped_sakura_log", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SAKURA_WOOD = register("stripped_sakura_wood", () -> new AetherLogBlock(BlockBehaviour.Properties.ofFullCopy(STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<WallBlock> HIGHSPROOT_LOG_WALL = register("highsproot_log_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> HIGHSPROOT_WOOD_WALL = register("highsproot_wood_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> STRIPPED_HIGHSPROOT_LOG_WALL = register("stripped_highsproot_log_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> STRIPPED_HIGHSPROOT_WOOD_WALL = register("stripped_highsproot_wood_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> SAKURA_LOG_WALL = register("sakura_log_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> SAKURA_WOOD_WALL = register("sakura_wood_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> STRIPPED_SAKURA_LOG_WALL = register("stripped_sakura_log_wall", AncientBlocks::logWall);
    public static final DeferredBlock<WallBlock> STRIPPED_SAKURA_WOOD_WALL = register("stripped_sakura_wood_wall", AncientBlocks::logWall);

    public static final DeferredBlock<Block> HIGHSPROOT_PLANKS = register("highsproot_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS)));
    public static final DeferredBlock<StairBlock> HIGHSPROOT_STAIRS = register("highsproot_stairs", () -> new StairBlock(() -> HIGHSPROOT_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(HIGHSPROOT_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> HIGHSPROOT_SLAB = register("highsproot_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(HIGHSPROOT_PLANKS.get())));
    public static final DeferredBlock<FenceBlock> HIGHSPROOT_FENCE = register("highsproot_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(OAK_FENCE)));
    public static final DeferredBlock<FenceGateBlock> HIGHSPROOT_FENCE_GATE = register("highsproot_fence_gate", () -> new FenceGateBlock(AncientBlockSets.HIGHSPROOT, Block.Properties.ofFullCopy(OAK_FENCE_GATE)));
    public static final DeferredBlock<DoorBlock> HIGHSPROOT_DOOR = register("highsproot_door", () -> new DoorBlock(AncientBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> HIGHSPROOT_TRAPDOOR = register("highsproot_trapdoor", () -> new TrapDoorBlock(AncientBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(OAK_TRAPDOOR)));
    public static final DeferredBlock<ButtonBlock> HIGHSPROOT_BUTTON = register("highsproot_button", () -> new ButtonBlock(AncientBlockSets.HIGHSPROOT_BLOCK_SET, 30, Block.Properties.ofFullCopy(OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> HIGHSPROOT_PRESSURE_PLATE = register("highsproot_pressure_plate", () -> new PressurePlateBlock(AncientBlockSets.HIGHSPROOT_BLOCK_SET, Block.Properties.ofFullCopy(OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<StandingSignBlock> HIGHSPROOT_SIGN = BLOCKS.register("highsproot_sign", () -> new AncientSignBlock(AncientBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> HIGHSPROOT_WALL_SIGN = BLOCKS.register("highsproot_wall_sign", () -> new AncientWallSignBlock(AncientBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(OAK_WALL_SIGN)));
    public static final DeferredBlock<CeilingHangingSignBlock> HIGHSPROOT_HANGING_SIGN = BLOCKS.register("highsproot_hanging_sign", () -> new AncientCeilingHangingSignBlock(AncientBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(OAK_HANGING_SIGN)));
    public static final DeferredBlock<WallHangingSignBlock> HIGHSPROOT_WALL_HANGING_SIGN = BLOCKS.register("highsproot_wall_hanging_sign", () -> new AncientWallHangingSignBlock(AncientBlockSets.HIGHSPROOT, BlockBehaviour.Properties.ofFullCopy(OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<Block> HIGHSPROOT_BOOKSHELF = register("highsproot_bookshelf", () -> new BookshelfBlock(Block.Properties.ofFullCopy(BOOKSHELF)));

    public static final DeferredBlock<Block> SAKURA_PLANKS = register("sakura_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(OAK_PLANKS)));
    public static final DeferredBlock<StairBlock> SAKURA_STAIRS = register("sakura_stairs", () -> new StairBlock(() -> SAKURA_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(SAKURA_PLANKS.get())));
    public static final DeferredBlock<SlabBlock> SAKURA_SLAB = register("sakura_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(SAKURA_PLANKS.get())));
    public static final DeferredBlock<FenceBlock> SAKURA_FENCE = register("sakura_fence", () -> new FenceBlock(Block.Properties.ofFullCopy(OAK_FENCE)));
    public static final DeferredBlock<FenceGateBlock> SAKURA_FENCE_GATE = register("sakura_fence_gate", () -> new FenceGateBlock(AncientBlockSets.SAKURA, Block.Properties.ofFullCopy(OAK_FENCE_GATE)));
    public static final DeferredBlock<DoorBlock> SAKURA_DOOR = register("sakura_door", () -> new DoorBlock(AncientBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> SAKURA_TRAPDOOR = register("sakura_trapdoor", () -> new TrapDoorBlock(AncientBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(OAK_TRAPDOOR)));
    public static final DeferredBlock<ButtonBlock> SAKURA_BUTTON = register("sakura_button", () -> new ButtonBlock(AncientBlockSets.SAKURA_BLOCK_SET, 30, Block.Properties.ofFullCopy(OAK_BUTTON)));
    public static final DeferredBlock<PressurePlateBlock> SAKURA_PRESSURE_PLATE = register("sakura_pressure_plate", () -> new PressurePlateBlock(AncientBlockSets.SAKURA_BLOCK_SET, Block.Properties.ofFullCopy(OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<StandingSignBlock> SAKURA_SIGN = BLOCKS.register("sakura_sign", () -> new AncientSignBlock(AncientBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(OAK_SIGN)));
    public static final DeferredBlock<WallSignBlock> SAKURA_WALL_SIGN = BLOCKS.register("sakura_wall_sign", () -> new AncientWallSignBlock(AncientBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(OAK_WALL_SIGN)));
    public static final DeferredBlock<CeilingHangingSignBlock> SAKURA_HANGING_SIGN = BLOCKS.register("sakura_hanging_sign", () -> new AncientCeilingHangingSignBlock(AncientBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(OAK_HANGING_SIGN)));
    public static final DeferredBlock<WallHangingSignBlock> SAKURA_WALL_HANGING_SIGN = BLOCKS.register("sakura_wall_hanging_sign", () -> new AncientWallHangingSignBlock(AncientBlockSets.SAKURA, BlockBehaviour.Properties.ofFullCopy(OAK_WALL_HANGING_SIGN)));
    public static final DeferredBlock<Block> SAKURA_BOOKSHELF = register("sakura_bookshelf", () -> new BookshelfBlock(Block.Properties.ofFullCopy(BOOKSHELF)));

    public static final DeferredBlock<Block> VALKYRUM_BLOCK = register("valkyrum_block", () -> new ValkyrumBlock(Block.Properties.of().strength(6.0F, 8.0F).mapColor(MapColor.QUARTZ).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final DeferredBlock<TransparentBlock> AEROGEL_GLASS = register("aerogel_glass", () -> new AerogelGlassBlock(Block.Properties.of().mapColor(MapColor.DIAMOND).instrument(NoteBlockInstrument.IRON_XYLOPHONE).strength(1.0F, 2000.0F).sound(SoundType.METAL).noOcclusion().requiresCorrectToolForDrops().isRedstoneConductor(AncientBlocks::never).isSuffocating(AncientBlocks::never).isViewBlocking(AncientBlocks::never)));
    public static final DeferredBlock<IronBarsBlock> AEROGEL_GLASS_PANE = register("aerogel_glass_pane", () -> new IronBarsBlock(Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<DoorBlock> AEROGEL_GLASS_DOOR = register("aerogel_glass_door", () -> new DoorBlock(AncientBlockSets.AEROGEL_GLASS_BLOCK_SET, Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<TrapDoorBlock> AEROGEL_GLASS_TRAPDOOR = register("aerogel_glass_trapdoor", () -> new TrapDoorBlock(AncientBlockSets.AEROGEL_GLASS_BLOCK_SET, Block.Properties.ofFullCopy(AEROGEL_GLASS.get())));
    public static final DeferredBlock<Block> FLUFFALO_WOOL = register("fluffalo_wool", () -> new Block(BlockBehaviour.Properties.ofFullCopy(WHITE_WOOL).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    public static final DeferredBlock<CarpetBlock> FLUFFALO_CARPET = register("fluffalo_carpet", () -> new CarpetBlock(BlockBehaviour.Properties.ofFullCopy(FLUFFALO_WOOL.get())));

    public static final DeferredBlock<Block> CARVED_TILES = register("carved_tiles", () -> dungeonBlock(MapColor.STONE));
    public static final DeferredBlock<Block> WYND_SENTRY_STONE = register("wynd_sentry_stone", () -> new Block(Block.Properties.ofFullCopy(CARVED_TILES.get()).lightLevel(s -> 7)));
    public static final DeferredBlock<StairBlock> CARVED_TILE_STAIRS = register("carved_tile_stairs", () -> new StairBlock(() -> CARVED_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(CARVED_TILES.get())));
    public static final DeferredBlock<SlabBlock> CARVED_TILE_SLAB = register("carved_tile_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(CARVED_TILES.get())));
    public static final DeferredBlock<WallBlock> CARVED_TILE_WALL = register("carved_tile_wall", () -> new WallBlock(Block.Properties.ofFullCopy(CARVED_TILES.get())));

    public static final DeferredBlock<HorizontalDirectionalBlock> ANGELIC_CORNER_BRICK = register("angelic_corner_brick", () -> new HorizontalFacingBlock(Block.Properties.of().mapColor(MapColor.SAND).instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F, 6.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<Block> VALKYRIE_BRICKS = register("valkyrie_bricks", () -> new Block(Block.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASEDRUM).strength(0.5F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final DeferredBlock<StairBlock> VALKYRIE_BRICK_STAIRS = register("valkyrie_brick_stairs", () -> new StairBlock(() -> VALKYRIE_BRICKS.get().defaultBlockState(), Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> VALKYRIE_BRICK_SLAB = register("valkyrie_brick_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<WallBlock> VALKYRIE_BRICK_WALL = register("valkyrie_brick_wall", () -> new WallBlock(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<Block> VALKYRIE_TILES = register("valkyrie_tiles", () -> new Block(Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<StairBlock> VALKYRIE_TILE_STAIRS = register("valkyrie_tile_stairs", () -> new StairBlock(() -> VALKYRIE_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(VALKYRIE_BRICKS.get())));
    public static final DeferredBlock<SlabBlock> VALKYRIE_TILE_SLAB = register("valkyrie_tile_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(VALKYRIE_TILES.get())));
    public static final DeferredBlock<WallBlock> VALKYRIE_TILE_WALL = register("valkyrie_tile_wall", () -> new WallBlock(Block.Properties.ofFullCopy(VALKYRIE_TILES.get())));

    public static final DeferredBlock<Block> AEROGETIC_STONE = register("aerogetic_stone", () -> dungeonBlock(MapColor.COLOR_CYAN));
    public static final DeferredBlock<Block> AERONAUTIC_STONE = register("aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).lightLevel(s -> 11)));
    public static final DeferredBlock<Block> CORRUPTED_AERONAUTIC_STONE = register("corrupted_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(AERONAUTIC_STONE.get())));
    public static final DeferredBlock<StairBlock> AEROGETIC_STAIRS = register("aerogetic_stairs", () -> new StairBlock(() -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<SlabBlock> AEROGETIC_SLAB = register("aerogetic_slab", () -> new SlabBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<WallBlock> AEROGETIC_WALL = register("aerogetic_wall", () -> new WallBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));

    public static final DeferredBlock<RotatedPillarBlock> HOLYSTONE_BRICK_MOSAIC = register("holystone_brick_mosaic", () -> new RotatedPillarBlock(Block.Properties.of().mapColor(MapColor.WOOL).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 10.0F).requiresCorrectToolForDrops()));
    public static final DeferredBlock<RotatedPillarBlock> CARVED_STONE_MOSAIC = register("carved_stone_mosaic", () -> dungeonMosaic(MapColor.STONE));
    public static final DeferredBlock<RotatedPillarBlock> ANGELIC_STONE_MOSAIC = register("angelic_stone_mosaic", () -> dungeonMosaic(MapColor.SAND));
    public static final DeferredBlock<RotatedPillarBlock> HELLFIRE_STONE_MOSAIC = register("hellfire_stone_mosaic", () -> dungeonMosaic(MapColor.NETHER));
    public static final DeferredBlock<RotatedPillarBlock> AEROGETIC_STONE_MOSAIC = register("aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE.get())));
    public static final DeferredBlock<RotatedPillarBlock> GALE_STONE_MOSAIC = register("gale_stone_mosaic", () -> dungeonMosaic(MapColor.STONE));

    public static final DeferredBlock<Block> LOCKED_CARVED_TILES = register("locked_carved_tiles", () -> new Block(Block.Properties.ofFullCopy(CARVED_TILES.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_WYND_SENTRY_STONE = register("locked_wynd_sentry_stone", () -> new Block(Block.Properties.ofFullCopy(WYND_SENTRY_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_AEROGETIC_STONE = register("locked_aerogetic_stone", () -> new Block(Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_AERONAUTIC_STONE = register("locked_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).lightLevel(s -> 11).noLootTable()));
    public static final DeferredBlock<Block> LOCKED_CORRUPTED_AERONAUTIC_STONE = register("locked_corrupted_aeronautic_stone", () -> new Block(Block.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<RotatedPillarBlock> LOCKED_CARVED_STONE_MOSAIC = register("locked_carved_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(CARVED_STONE_MOSAIC.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_ANGELIC_STONE_MOSAIC = register("locked_angelic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(ANGELIC_STONE_MOSAIC.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_HELLFIRE_STONE_MOSAIC = register("locked_hellfire_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(HELLFIRE_STONE_MOSAIC.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_AEROGETIC_STONE_MOSAIC = register("locked_aerogetic_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(AEROGETIC_STONE_MOSAIC.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final DeferredBlock<RotatedPillarBlock> LOCKED_GALE_STONE_MOSAIC = register("locked_gale_stone_mosaic", () -> new RotatedPillarBlock(Block.Properties.ofFullCopy(CARVED_STONE_MOSAIC.get()).strength(-1.0F, 3600000.0F).noLootTable()));

    public static final DeferredBlock<Block> TRAPPED_CARVED_TILES = register("trapped_carved_tiles", () -> new TrappedBlock(AetherEntityTypes.SENTRY::get, () -> CARVED_TILES.get().defaultBlockState(), Block.Properties.ofFullCopy(CARVED_TILES.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_AEROGETIC_STONE = register("trapped_aerogetic_stone", () -> new TrappedBlock(AncientEntityTypes.AERONAUTIC_LEAPER::get, () -> AEROGETIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_AERONAUTIC_STONE = register("trapped_aeronautic_stone", () -> new TrappedBlock(AncientEntityTypes.AERONAUTIC_LEAPER::get, () -> AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TRAPPED_CORRUPTED_AERONAUTIC_STONE = register("trapped_corrupted_aeronautic_stone", () -> new TrappedBlock(AncientEntityTypes.AERONAUTIC_LEAPER::get, () -> CORRUPTED_AERONAUTIC_STONE.get().defaultBlockState(), Block.Properties.ofFullCopy(CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<Block> BOSS_DOORWAY_CARVED_STONE = register("boss_doorway_carved_stone", () -> new DoorwayBlock(AncientEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.ofFullCopy(LOCKED_CARVED_TILES.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_WYND_SENTRY_STONE = register("boss_doorway_wynd_sentry_stone", () -> new DoorwayBlock(AncientEntityTypes.MUTATED_AECHOR_PLANT::get, Block.Properties.ofFullCopy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_AEROGETIC_STONE = register("boss_doorway_aerogetic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_AERONAUTIC_STONE = register("boss_doorway_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> BOSS_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("boss_doorway_corrupted_aeronautic_stone", () -> new DoorwayBlock(AetherEntityTypes.SLIDER::get, BlockBehaviour.Properties.ofFullCopy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<Block> TREASURE_DOORWAY_WYND_SENTRY_STONE = register("treasure_doorway_wynd_sentry_stone", () -> new TreasureDoorwayBlock(Block.Properties.ofFullCopy(LOCKED_WYND_SENTRY_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_AEROGETIC_STONE = register("treasure_doorway_aerogetic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_AERONAUTIC_STONE = register("treasure_doorway_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_AERONAUTIC_STONE.get()).noLootTable()));
    public static final DeferredBlock<Block> TREASURE_DOORWAY_CORRUPTED_AERONAUTIC_STONE = register("treasure_doorway_corrupted_aeronautic_stone", () -> new TreasureDoorwayBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_CORRUPTED_AERONAUTIC_STONE.get()).noLootTable()));

    public static final DeferredBlock<LanternBlock> AMBROSIUM_LANTERN = register("ambrosium_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 15)));
    public static final DeferredBlock<LanternBlock> WYND_LANTERN = register("wynd_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 7)));
    public static final DeferredBlock<LanternBlock> SUN_LANTERN = register("sun_lantern", () -> new LanternBlock(BlockBehaviour.Properties.ofFullCopy(LANTERN).lightLevel(s -> 12)));
    public static final DeferredBlock<Block> AMBROSIUM_CAMPFIRE = register("ambrosium_campfire", () -> new AmbrosiumCampfireBlock(false, 1, Block.Properties.ofFullCopy(Blocks.CAMPFIRE)));

    public static final DeferredBlock<Block> VIOLET_AERCLOUD = register("violet_aercloud", () -> new VioletAercloudBlock(Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).instrument(NoteBlockInstrument.FLUTE).strength(0.3F).sound(SoundType.WOOL).noOcclusion().dynamicShape().isRedstoneConductor(AncientBlocks::never).isSuffocating(AncientBlocks::never).isViewBlocking(AncientBlocks::never)));
    public static final DeferredBlock<Block> WIND_BLOWER = register("wind_blower", () -> new WindBlowerBlock(Block.Properties.of().mapColor(MapColor.SNOW).instrument(NoteBlockInstrument.FLUTE).strength(0.3F).sound(SoundType.WOOL).noOcclusion().dynamicShape().isRedstoneConductor(AncientBlocks::never).isSuffocating(AncientBlocks::never).isViewBlocking(AncientBlocks::never)));
    public static final DeferredBlock<Block> SLIDER_PROTOTYPE = register("slider_prototype", () -> new SliderPrototypeBlock(BlockBehaviour.Properties.ofFullCopy(STONE).strength(5f).noOcclusion()));
    public static final DeferredBlock<Block> ANCIENT_OBELISK = register("ancient_obelisk", () -> new ObeliskBlock(BlockBehaviour.Properties.ofFullCopy(LOCKED_AEROGETIC_STONE.get()).lightLevel(s -> 3).noLootTable().noOcclusion()));
    public static final DeferredBlock<Block> POWERED_OBELISK = register("powered_obelisk", () -> new Block(BlockBehaviour.Properties.ofFullCopy(AEROGETIC_STONE.get()).strength(5f).lightLevel(s -> 12).noOcclusion()));

    public static final DeferredBlock<VaseBlock> HOLYSTONE_VASE = register("holystone_vase", () -> new VaseBlock(Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).instabreak().sound(SoundType.DECORATED_POT).noOcclusion().isSuffocating(AncientBlocks::never).isViewBlocking(AncientBlocks::never)));
    public static final DeferredBlock<VaseBlock> MOSSY_HOLYSTONE_VASE = register("mossy_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> FROZEN_HOLYSTONE_VASE = register("frozen_holystone_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> SENTRY_VASE = register("sentry_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> ANGELIC_VASE = register("angelic_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> HELLFIRE_VASE = register("hellfire_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> AEROGETIC_VASE = register("aerogetic_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));
    public static final DeferredBlock<VaseBlock> GALE_VASE = register("gale_vase", () -> new VaseBlock(BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get())));

    public static final DeferredBlock<AncientVaseBlock> ANCIENT_HOLYSTONE_VASE = register("ancient_holystone_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(HOLYSTONE_VASE.get()).sound(SoundType.DECORATED_POT_CRACKED).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_MOSSY_HOLYSTONE_VASE = register("ancient_mossy_holystone_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_MOSSY_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_FROZEN_HOLYSTONE_VASE = register("ancient_frozen_holystone_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_FROZEN_HOLYSTONE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_SENTRY_VASE = register("ancient_sentry_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_SENTRY_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_ANGELIC_VASE = register("ancient_angelic_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_ANGELIC_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_HELLFIRE_VASE = register("ancient_hellfire_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_HELLFIRE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_AEROGETIC_VASE = register("ancient_aerogetic_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_AEROGETIC_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));
    public static final DeferredBlock<AncientVaseBlock> ANCIENT_GALE_VASE = register("ancient_gale_vase", () -> new AncientVaseBlock(AncientLoot.SELECTORS_GALE_VASE, BlockBehaviour.Properties.ofFullCopy(ANCIENT_HOLYSTONE_VASE.get()).noLootTable()));

    public static final DeferredBlock<FlowerPotBlock> POTTED_CRYSTAL_SKYROOT_SAPLING = BLOCKS.register("potted_crystal_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, CRYSTAL_SKYROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ENCHANTED_SKYROOT_SAPLING = BLOCKS.register("potted_divine_skyroot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ENCHANTED_SKYROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKYROOT_PINE_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_BLUE_SKYROOT_PINE_SAPLING = BLOCKS.register("potted_blue_skyroot_pine_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, BLUE_SKYROOT_PINE_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_HIGHSPROOT_SAPLING = BLOCKS.register("potted_highsproot_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, HIGHSPROOT_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SAKURA_SAPLING = BLOCKS.register("potted_sakura_sapling", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SAKURA_SAPLING, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SUNSET_ROSE = BLOCKS.register("potted_highland_cyclamen", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SUNSET_ROSE, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_SKY_BLUES = BLOCKS.register("potted_sky_blues", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SKY_BLUES, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_WYND_THISTLE = BLOCKS.register("potted_wynd_thistle", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WYND_THISTLE, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));
    public static final DeferredBlock<FlowerPotBlock> POTTED_ELEVETIA = BLOCKS.register("potted_elevetia", () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ELEVETIA, Block.Properties.ofFullCopy(Blocks.FLOWER_POT)));

    private static Block leaves(MapColor mapColor, SoundType sound) {
        return new AetherDoubleDropsLeaves(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(sound)
                        .noOcclusion()
                        .isValidSpawn(AncientBlocks::ocelotOrParrot)
                        .isSuffocating(AncientBlocks::never)
                        .isViewBlocking(AncientBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(AncientBlocks::never)
        );
    }

    private static WallBlock logWall() {
        return new WallBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.WOOD)
                        .instrument(NoteBlockInstrument.BASS)
                        .ignitedByLava().strength(2.0F)
                        .sound(SoundType.WOOD)
        );
    }

    private static Block dungeonBlock(MapColor mapColor) {
        return new Block(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(0.5F, 6.0F)
                        .requiresCorrectToolForDrops()
        );
    }

    private static RotatedPillarBlock dungeonMosaic(MapColor mapColor) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(mapColor)
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(0.5F, 6.0F)
                        .requiresCorrectToolForDrops()
        );
    }

    public static void registerPots() {
        FlowerPotBlock pot = (FlowerPotBlock) Blocks.FLOWER_POT;
        pot.addPlant(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.getId(), AncientBlocks.POTTED_CRYSTAL_SKYROOT_SAPLING);
        pot.addPlant(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.getId(), AncientBlocks.POTTED_ENCHANTED_SKYROOT_SAPLING);
        pot.addPlant(AncientBlocks.SKYROOT_PINE_SAPLING.getId(), AncientBlocks.POTTED_SKYROOT_PINE_SAPLING);
        pot.addPlant(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.getId(), AncientBlocks.POTTED_BLUE_SKYROOT_PINE_SAPLING);
        pot.addPlant(AncientBlocks.HIGHSPROOT_SAPLING.getId(), AncientBlocks.POTTED_HIGHSPROOT_SAPLING);
        pot.addPlant(AncientBlocks.SAKURA_SAPLING.getId(), AncientBlocks.POTTED_SAKURA_SAPLING);
        pot.addPlant(AncientBlocks.SUNSET_ROSE.getId(), AncientBlocks.POTTED_SUNSET_ROSE);
        pot.addPlant(AncientBlocks.SKY_BLUES.getId(), AncientBlocks.POTTED_SKY_BLUES);
        pot.addPlant(AncientBlocks.WYND_THISTLE.getId(), AncientBlocks.POTTED_WYND_THISTLE);
        pot.addPlant(AncientBlocks.ELEVETIA.getId(), AncientBlocks.POTTED_ELEVETIA);
    }

    public static void registerFlammability() {
        FireBlockAccessor fireBlockAccessor = (FireBlockAccessor) Blocks.FIRE;
        fireBlockAccessor.callSetFlammable(AncientBlocks.CRYSTAL_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.ENCHANTED_SKYROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SKYROOT_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.BLUE_SKYROOT_PINE_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_LEAVES.get(), 30, 60);
        fireBlockAccessor.callSetFlammable(AncientBlocks.CRYSTAL_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.ENCHANTED_SKYROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SKYROOT_PINE_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.BLUE_SKYROOT_PINE_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SKY_GRASS.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_SAPLING.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SUNSET_ROSE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SKY_BLUES.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.WYND_THISTLE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.ELEVETIA.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.GRAPE_VINE.get(), 60, 100);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_HIGHSPROOT_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_SAKURA_LOG.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_SAKURA_WOOD.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_HIGHSPROOT_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_HIGHSPROOT_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_SAKURA_LOG_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.STRIPPED_SAKURA_WOOD_WALL.get(), 5, 5);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.HIGHSPROOT_FENCE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_PLANKS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_STAIRS.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_SLAB.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_FENCE_GATE.get(), 5, 20);
        fireBlockAccessor.callSetFlammable(AncientBlocks.SAKURA_FENCE.get(), 5, 20);
    }

    private static boolean never(BlockState test1, BlockGetter test2, BlockPos test3) {
        return false;
    }
    private static boolean always(BlockState test1, BlockGetter test2, BlockPos test3) {
        return true;
    }

    private static boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> entity) {
        return entity == EntityType.OCELOT || entity == EntityType.PARROT;
    }

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AncientItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}