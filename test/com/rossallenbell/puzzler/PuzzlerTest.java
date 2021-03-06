package com.rossallenbell.puzzler;

import static com.rossallenbell.puzzler.util.TestUtil.MOTORCYLEHEIGHT;
import static com.rossallenbell.puzzler.util.TestUtil.MOTORCYLEWIDTH;
import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.junit.BeforeClass;
import org.junit.Test;

public class PuzzlerTest {
    
    private static BufferedImage image;
    private static Puzzler puzzler;
    
    @BeforeClass
    public static void initialize() throws IOException {
        URL resourceURL = PuzzlerTest.class.getClassLoader().getResource("test-resources/motorcycle.jpg");
        image = ImageIO.read(resourceURL);
        puzzler = new Puzzler();
    }
    
    @Test
    public void testPuzzlefy() {
        Puzzle puzzle = puzzler.puzzlefy(image, 150, 100, 10);
        
        assertEquals(150, puzzle.getWidthInPixels());
        assertEquals(100, puzzle.getHeightInPixels());
        assertEquals(10, puzzle.getPieceSizeInPixels());
    }
    
    @Test
    public void testPuzzlefyDefaultSizes() {
        Puzzle puzzle = puzzler.puzzlefy(image, 40);
        
        assertEquals(MOTORCYLEWIDTH, puzzle.getWidthInPixels());
        assertEquals(MOTORCYLEHEIGHT, puzzle.getHeightInPixels());
        assertEquals(40, puzzle.getPieceSizeInPixels());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testPuzzlefyInvalidSizeInput() {
        puzzler.puzzlefy(image, 150, 100, 15);
    }
    
}
