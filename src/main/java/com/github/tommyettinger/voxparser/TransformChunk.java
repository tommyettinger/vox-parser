package com.github.tommyettinger.voxparser;

import com.badlogic.gdx.math.Vector3;

public class TransformChunk extends AbstractChunk {

    /**
     * A TransformChunk has one child, a GroupChunk. It is referenced by index.
     */
    public int childId;
    /**
     * Reserved, unused.
     */
    public int reservedId;
    /**
     * Currently unused.
     */
    public int layerId;
    /**
     * Outer array always has length 1 for 1 frame; inside it is a DICT type, with indexed String pairs.
     */
    public String[][][] frameAttributes;
    public float roll, pitch, yaw;
    public Vector3 translation = new Vector3();
    public TransformChunk(){
        attributes = new String[0][0];
        frameAttributes = new String[0][0][0];
    }
    public TransformChunk(int id, String[][] attributes, int childId, int reservedId, int layerId,
                          String[][][] frameAttributes){
        this.id = id;
        this.attributes = attributes == null ? new String[0][0] : attributes;
        this.childId = childId;
        this.reservedId = reservedId;
        this.layerId = layerId;
        this.frameAttributes = frameAttributes == null ? new String[0][0][0] : frameAttributes;
        if(this.frameAttributes.length != 0)
        {
            VoxParser.getRotation(this, this.frameAttributes[0]);
            VoxParser.getTranslation(translation, this.frameAttributes[0]);
        }
    }
}
