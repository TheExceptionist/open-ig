/*
 * Copyright 2008-2011, David Karnok 
 * The file is part of the Open Imperium Galactica project.
 * 
 * The code should be distributed under the LGPL license.
 * See http://www.gnu.org/licenses/lgpl.html for details.
 */

package hu.openig.model;

import java.awt.image.BufferedImage;

/**
 * A base class for space objects (beams, projectiles, ships, ground defenses).
 * @author akarnokd, 2011.08.15.
 */
public abstract class SpacewarObject {
	/** The current location. */
	public double x;
	/** The current location. */
	public double y;
	/** The owner player. */
	public Player owner;
	/**
	 * Get the image of this space object.
	 * @return the image
	 */
	public abstract BufferedImage get();
	/**
	 * Test if the object intersects with a rectangle.
	 * @param x the rectangle X
	 * @param y the rectangle Y
	 * @param width the rectangle width
	 * @param height the rectangle height
	 * @return true if intersects
	 */
	public boolean intersects(double x, double y, double width, double height) {
		int w = get().getWidth();
		int h = get().getHeight();
		
		double x0 = this.x - (w / 2);
		double x1 = x0 + w - 1;
		double y0 = this.y - (h / 2);
		double y1 = y0 + h - 1;
		
		return !(x1 < x || x + width < x0) && !(y1 < y || y + height < y0);
	}
	/**
	 * Test if two spacewar objects intersect.
	 * @param other the other object
	 * @return true if intersect
	 */
	public boolean intersects(SpacewarObject other) {
		int w = other.get().getWidth();
		int h = other.get().getHeight();
		return intersects(other.x - (w / 2), other.y - (h / 2), w , h);
	}
}
