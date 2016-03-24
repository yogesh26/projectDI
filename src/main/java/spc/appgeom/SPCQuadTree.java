package spc.appgeom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YogeshK on 2015-10-14.
 */
public class SPCQuadTree {

    // Arbitrary constant to indicate how many elements can be stored in this quad tree node
    private static final int QT_NODE_CAPACITY = 4;

    // Axis-aligned bounding box stored as a center with half-dimensions
    // to represent the boundaries of this quad tree
    SPCRect2D boundary;

    // Points in this quad tree node
    List<SPCBaseObject> lstObjects;

    int level;
    // Children
    SPCQuadTree northWest;
    SPCQuadTree northEast;
    SPCQuadTree southWest;
    SPCQuadTree southEast;

    // Methods
    //function subdivide() {...} // create four children that fully divide this quad into four quads of equal area
    //function queryRange(AABB range) {...}

    // Insert a point into the QuadTree
    public boolean insert(SPCBaseObject p)
    {

        // Ignore objects that do not belong in this quad tree
        if (!boundary.containsObject(p))
            return false; // object cannot be added

        // If there is space in this quad tree, add the object here
        if (lstObjects.size() < QT_NODE_CAPACITY)
        {
            lstObjects.add(p);
            return true;
        }

        // Otherwise, subdivide and then add the point to whichever node will accept it
        if (northWest == null)
            splitNode();

        if (northWest.insert(p)) return true;
        if (northEast.insert(p)) return true;
        if (southWest.insert(p)) return true;
        if (southEast.insert(p)) return true;

        // Otherwise, the point cannot be inserted for some unknown reason (this should never happen)
        return false;
    }
    public boolean splitNode(){
        int subWidth = (int)(boundary.getWidth() / 2);
        int subHeight = (int)(boundary.getHeight() / 2);
        int x = (int)boundary.getOrigin().getFX();
        int y = (int)boundary.getOrigin().getFY();

        northWest = new SPCQuadTree(level+1, new SPCRect2D(x + subWidth, y, subWidth, subHeight));
        northEast = new SPCQuadTree(level+1, new SPCRect2D(x, y, subWidth, subHeight));
        southWest = new SPCQuadTree(level+1, new SPCRect2D(x, y + subHeight, subWidth, subHeight));
        southEast = new SPCQuadTree(level+1, new SPCRect2D(x + subWidth, y + subHeight, subWidth, subHeight));

        return false;
    }
    public SPCQuadTree(){

    }
    public SPCQuadTree(int level, SPCRect2D bound){
        this.level = level;
        this.boundary = bound;
        lstObjects = new ArrayList<SPCBaseObject>();
        northWest = null;
        northEast = null;
        southWest = null;
        southEast = null;
    }

    /*
 * Determine which node the object belongs to. -1 means
 * object cannot completely fit within a child node and is part
 * of the parent node
 */
    private int getIndex(SPCRect2D pRect) {
        int index = -1;
        double verticalMidpoint = boundary.getOrigin().getFX() + (boundary.getWidth() / 2);
        double horizontalMidpoint = boundary.getOrigin().getFY() + (boundary.getHeight() / 2);

        // Object can completely fit within the top quadrants
        boolean topQuadrant = (pRect.getOrigin().getFY() < horizontalMidpoint && pRect.getOrigin().getFY() + pRect.getHeight() < horizontalMidpoint);
        // Object can completely fit within the bottom quadrants
        boolean bottomQuadrant = (pRect.getOrigin().getFY() > horizontalMidpoint);

        // Object can completely fit within the left quadrants
        if (pRect.getOrigin().getFX() < verticalMidpoint && pRect.getOrigin().getFX() + pRect.getWidth() < verticalMidpoint) {
            if (topQuadrant) {
                index = 1;
            }
            else if (bottomQuadrant) {
                index = 2;
            }
        }
        // Object can completely fit within the right quadrants
        else if (pRect.getOrigin().getFX() > verticalMidpoint) {
            if (topQuadrant) {
                index = 0;
            }
            else if (bottomQuadrant) {
                index = 3;
            }
        }

        return index;
    }
}
