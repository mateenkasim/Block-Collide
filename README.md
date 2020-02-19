# Block-Collide
A simulation of colliding blocks programmed in Java. With specified initial conditions, the program finds how many times two blocks collide with no friction and perfectly elastic collisions.

Run BlockControl.java from the command line.

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
