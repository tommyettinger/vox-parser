package com.github.tommyettinger.voxparser;

import com.badlogic.gdx.utils.IntMap;

import java.util.ArrayList;
import java.util.Arrays;

public class VoxModel {
    public int[] palette;
    public ArrayList<byte[][][]> grids;
    public IntMap<VoxMaterial> materials;
    public IntMap<TransformChunk> transformChunks;
    public IntMap<GroupChunk> groupChunks;
    public IntMap<ShapeChunk> shapeChunks;
    public VoxModel(){
        palette = Arrays.copyOf(VoxParser.defaultPalette, 256);
        grids = new ArrayList<>(1);
        materials = new IntMap<>(256);
        transformChunks = new IntMap<>(8);
        groupChunks = new IntMap<>(1);
        shapeChunks = new IntMap<>(8);
    }

    public VoxModel copy(){
        VoxModel next = new VoxModel();
        next.palette = Arrays.copyOf(palette, palette.length);
        ArrayList<byte[][][]> nextGrids = new ArrayList<>(grids.size());
        for (int i = 0; i < grids.size(); i++) {
            nextGrids.add(Tools3D.deepCopy(grids.get(i)));
        }
        next.grids = nextGrids;
        return next;
    }
}
