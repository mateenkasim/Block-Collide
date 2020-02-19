/**
 * A class defining a Block object, which slides back and forth on a one-dimensional surface
 * It has a mass, side-length, position, and velocity
 *
 * Intended for BlockControl.java by Mateen Kasim, but could be generalizable
 *
 * Implemented based on 
 * YouTube video "So why do colliding blocks compute pi?" by 3Blue1Brown, 2019
 * https://www.youtube.com/watch?v=jsYwFizhncE
 * and paper by "PLAYING POOL WITH π (THE NUMBER π FROM A BILLIARD POINT OF VIEW)" by Gregory Galperin, 2003
 * https://www.maths.tcd.ie/~lebed/Galperin.%20Playing%20pool%20with%20pi.pdf
 *
 * @author Mateen Kasim
 * @since Dec 2019
 */

public class Block{

	//Data defining the state of this Block
	/**
	 * mass of Block, integer
	 */
	private int mass;

	/**
	 * height of Block, integer
	 * Defined here to be log10(mass)+1
	 * Blocks are squares, so width is also height
	 * Only useful if Block is to be animated
	 */
	private int height;

	/**
	 * position of Block in one-dimensional space, double
	 */
	private double x;

	/**
	 * velocity of Block in one-dimensional space, double
	 * Signed: negative means moving left, positive means moving right
	 */
	private double velocity;


	//Constructor
	/**
	 * Constructor for the Block, only one valid constructor
	 * @param m mass of block
	 * @param x positive of block
	 */
	public Block(int m, double x){
		setMass(m);
		setPosition(x);
	}


	//Setters
	/**
	 * Sets mass to a new value, also sets height because height is dependent on mass
	 * @param w new mass of Block
	 */
	public void setMass(int w){
		mass = w;
		int newHeight = (int)(Math.log(w)/Math.log(10));	//Set height = log10(mass)+1
		setHeight(newHeight);
	}

	//Only called by setMass
	private void setHeight(int h){
		height = ++h;
	}

	/**
	 * Sets position to a new value
	 * @param x new position of Block
	 */
	public void setPosition(double x){
		this.x = x;
	}

	/**
	 * Sets velocity to a new value
	 * @param x new velocity of Block
	 */
	public void setVelocity(double v){
		velocity = v;
	}



	//Getters
	/**
	 * Gets mass of this
	 * @return mass, integer
	 */
	public int mass(){
		return mass;
	}

	/**
	 * Gets height of this
	 * @return height, integer
	 */
	public int height(){
		return height;
	}

	/**
	 * Gets position of this
	 * @return position, double
	 */
	public double position(){
		return x;
	}

	/**
	 * Gets velocity of this
	 * @return velocity, double
	 */
	public double velocity(){
		return velocity;
	}

	

}