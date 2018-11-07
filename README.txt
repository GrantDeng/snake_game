
Snake Game:
  I develop this game in OS X with the JDK version 1.8. The main 
development tool I use is Intellij IDEA.

 The game is control by keyboard. It use arrow keys to move, space 
key to pause, and key R to restart. the snake will die once you eat 
yourself of hit the board. The default setting of frame rate is 60FPS 
and speed is 7. The speed is base on how many moves per second. The game
will close when you close the window.

  My design of this Snake game is that I use two class, one is use to 
draw out the graphics which extends the JPanel class and overwrite 
the paintComponent() function. Also, I create a class which 
implements ActionLIstener and KeyListener. This class will handle 
the key input and the frame rate setting

  In additional, I add a reverse mode as a power up in enhancements.
After each time you eat a "apple", it has 20% chance to enter the 
reverse mode until you eat the next "apple". In the reverse mode, 
the direction is reverse, which means when you press UP, the snake
will go DOWN.

