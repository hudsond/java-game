package com.hudson.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.hudson.game.level.tile.Tile;

public class SpawnLevel extends Level{

	private Tile[] tiles;
	private int[] levelPixels;
	
	public SpawnLevel(String path) {
		super(path);
		
	}
	
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file." );
		}
	}
	
	//	Grass = 0xFF00
	//	Grass2 = 0xFFFF00
	//	Rock = 0x7F7F00
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i ++) {
			if (levelPixels[i] == 0xff00) tiles[i] = Tile.grass;
			if (levelPixels[i] == 0xffff00) tiles[i] = Tile.grass2;
			if (levelPixels[i] == 0x7f7f00) tiles[i] = Tile.rock;
		}
	}
	

}
