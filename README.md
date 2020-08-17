# Block-Collide
A simulation of colliding blocks programmed in Java. With specified initial conditions, the program finds how many times two blocks collide with no friction and perfectly elastic collisions.<br>

Run BlockControl.java from the command line with no arguments.

## BASIC PREMISE:
This class controls Blocks colliding when sliding back and forth on a frictionless, one-dimensional surface
and counts collisions.<br>
The collisions are perfectly elastic – both momentum and kinetic energy are conserved.<br>
(The equations for such collisions are sourced from https://en.wikipedia.org/wiki/Elastic_collision#One-dimensional_Newtonian) <br>
There are two blocks as well as a wall on the left, which is defined to have infinite mass and position=0.0. <br>
LeftBlock begins stationary, while RightBlock begins moving toward LeftBlock.

## MAIN PURPOSE:
This class counts how many collisions will occur between the two blocks and between LeftBlock and the wall.

### COOL NOTE AND MAIN INCENTIVE TO IMPLEMENT:
If RightBlock's mass is a multiple of LeftBlock's mass and 100*d for some natural number d, 
the number of collisions will be the first d+1 digits of π.
For example, if LeftBlock.mass()==1 and RightBlock.mass()==100, collisionCount will equal 31, or the first 2 digits of π.

## INSPIRATION
* YouTube video "So why do colliding blocks compute pi?" by 3Blue1Brown, 2019
  * https://www.youtube.com/watch?v=jsYwFizhncE
* and paper by "PLAYING POOL WITH π (THE NUMBER π FROM A BILLIARD POINT OF VIEW)" by Gregory Galperin, 2003
  * https://www.maths.tcd.ie/~lebed/Galperin.%20Playing%20pool%20with%20pi.pdf
