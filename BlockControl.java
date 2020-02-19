import java.util.Scanner;

/**
 * BASIC PREMISE:
 * This class controls Blocks colliding when sliding back and forth on a frictionless, one-dimensional surface
 * and counts collisions.
 * The collisions are perfectly elastic – both momentum and kinetic energy are conserved.
 * (The equations for such collisions are sourced from https://en.wikipedia.org/wiki/Elastic_collision#One-dimensional_Newtonian)
 * There are two blocks as well as a wall on the left, which is assumed to have infinite mass and position=0.0.
 * LeftBlock begins stationary, while RightBlock begins moving toward LeftBlock.
 *
 * MAIN PURPOSE:
 * This class counts how many collisions will occur between the two blocks and between LeftBlock and the wall.
 * 
 * COOL NOTE AND MAIN INCENTIVE TO IMPLEMENT:
 * If RightBlock's mass is a multiple of 100*d for some natural number d and LeftBlock's mass, 
 * the number of collisions will be the first d+1 digits of π.
 * For example, if LeftBlock.mass()==1 and RightBlock.mass()==100, collisionCount will equal 31, or the first 2 digits of π.
 *
 * Runs on the command line with no arguments
 * 
 * Uses Block.java by Mateen Kasim
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
public class BlockControl{
	
	//Positions in this scenario are unsigned, the wall position 0 is the minimum position
	private static final int WALL_POSITION = 0;
	private static final int LEFT_POSITION = 500;
	private static final int RIGHT_POSITION = 1000;

	//collisionCount is the primary output of this class
	private static int collisionCount;

	//These coefficients will be calculated below and are used to determine results of a collision
	//Purely based on the masses of the blocks
	//They are global so they may be calculated once initially and reused every time collide() is called
	private static double coeff1;
	private static double coeff2;
	private static double coeff3;
	private static double coeff4;

	public static void main(String[]args) throws Exception{

		//Ask user for masses of Blocks
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome!\nTwo blocks are on a frictionless surface, " 
			+ "sliding and colliding with each other and with a wall to the left.");
		System.out.println("This program counts the number of collisions of these two blocks when "
			+ "the block on the left is stationary and the block on the right is moving left.");
		System.out.println("Here, we assume perfectly elastic collisions.\n");
		System.out.println("What shall the mass of the left block be? Please enter an integer greater than zero:");
		double massLeft = scan.nextDouble();
		System.out.println("What shall the mass of the right block be? Please enter an integer greater than zero:");
		double massRight = scan.nextDouble();

		//This is commented out because it seems the velocity value does not change the results
		// System.out.println("Lastly, what shall the speed of the right block be? Please enter a double greater than zero:");
		// double rightVelocity = scan.nextDouble();


		//These are the Blocks that will be colliding, the scenario is now initialized
		Block leftBlock = new Block((int)massLeft,LEFT_POSITION);
		Block rightBlock = new Block((int)massRight,RIGHT_POSITION);
		collisionCount = 0;

		//These calculations are the reason why masses were stored as doubles even though user was asked for integers
		//Will be used in collide() method
		coeff1 = ((massLeft-massRight)/(massLeft+massRight));
		coeff2 = ((2*massRight)/(massLeft+massRight));
		coeff3 = ((2*massLeft)/(massLeft+massRight));
		coeff4 = ((massRight-massLeft)/(massLeft+massRight));

		//Begin the rightBlock moving to the left
		rightBlock.setVelocity(-10.0);

		//Keep checking for collisions until both Blocks are moving towards the right
		// but the rightBlock is moving faster than the leftBlock
		// i.e. leftBlock will never catch up to collide again
		while (rightBlock.velocity()<leftBlock.velocity() || rightBlock.velocity()<0 || leftBlock.velocity()<0){

			//Adjust positions
			leftBlock.setPosition(leftBlock.position()+leftBlock.velocity()*1);
			rightBlock.setPosition(rightBlock.position()+rightBlock.velocity()*1);


			//Collide if necessary
			//leftBlock collides with wall, bounces back with equal but opposite velocity
			// due to wall's ideally infinite mass
			if (leftBlock.position()<WALL_POSITION){
				leftBlock.setPosition(WALL_POSITION);
				leftBlock.setVelocity(leftBlock.velocity()*-1);
				collisionCount++;
			}
			//two blocks collide, collide() is called to calculate velocities
			// after a perfectly elastic collision
			if (rightBlock.position()<WALL_POSITION || rightBlock.position()<leftBlock.position()){
				rightBlock.setPosition(leftBlock.position());
				collide(leftBlock,rightBlock);
			}
		}

		//Output
		System.out.println("The two blocks collided a total of " + collisionCount + " times.");
	}


	/**
	 * Method to determine and set the resulting velocities when two blocks collide
	 * Assuming perfectly elastic collisions
	 * Results depend on masses of Blocks, which are accounted for in global coefficients calculated in main()
	 * Results also depend on initial velocities, which are accounted for in this method
	 * @param left Block that is on the left
	 * @param right Block that is on the right
	 */
	private static void collide(Block left, Block right){
		collisionCount++;

		double vInitLeft = left.velocity();
		double vInitRight = right.velocity();

		//Instead of calculating the coefficients every time, calculate them once in main and make them global
		//Use them here along with initial velocities to find final velocities
		double vFinalLeft = coeff1*vInitLeft;
		vFinalLeft += (coeff2*vInitRight);
		double vFinalRight = coeff3*vInitLeft;
		vFinalRight += (coeff4*vInitRight);

		//Set new velocities, signed
		left.setVelocity(vFinalLeft);
		right.setVelocity(vFinalRight);
	}


}