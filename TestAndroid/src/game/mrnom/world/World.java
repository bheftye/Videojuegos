package game.mrnom.world;

import java.util.Random;

public class World {
	static final int WORLD_WIDTH = 10;
	static final int WORLD_HEIGHT = 19;
	
	static final int SCORE_INCREMENT = 10;
	
	static final float TICK_INITIAL = 0.5f;
	static final float TICK_DECREMENT = 0.005f;
	
	public int score = 0;
	public boolean gameOver = false;
	
	float tick = TICK_INITIAL;
	float tickTime = 0f;
	
	boolean [][] fields = new boolean[WORLD_WIDTH][WORLD_HEIGHT];
	
	public Snake snake;
	public Stain stain;
	
	private Random random;
	
	public World(){
		snake = new Snake();
		placeStain();
	}
	
	private void placeStain(){
		for(int i = 0; i < WORLD_WIDTH; i++){
			for(int j = 0; j < WORLD_HEIGHT; j++){
				fields[i][j] = false;
			}
		}
		
		for(int i = 0; i < snake.parts.size(); i++){
			SnakePart part = snake.parts.get(i);
			fields[part.x][part.y] = true;
		}
		
		int stainX = random.nextInt(WORLD_WIDTH);
		int stainY = random.nextInt(WORLD_HEIGHT);
		
		while(fields[stainX][stainY]){
			stainX = random.nextInt(WORLD_WIDTH);
			stainY = random.nextInt(WORLD_HEIGHT);
		}
		
		stain = new Stain(stainX, stainY, random.nextInt(3));
	}
	
	public void update(float deltaTime){
		tickTime+=deltaTime;
		if(tickTime > tick){
			snake.advance();
			if(snake.checkBitten()){
				gameOver = true;
				return;
			}
			SnakePart head = snake.parts.get(0);
			if(head.x == stain.x && head.y == stain.y){
				score+=SCORE_INCREMENT;
				snake.eat();
				if(snake.parts.size() == WORLD_WIDTH*WORLD_HEIGHT){
					gameOver = true;
					return;
				}
				else{
					placeStain();
				}
				
				if(score%50 == 0){
					tick-=TICK_DECREMENT;
				}
			}
		}
	}
}
