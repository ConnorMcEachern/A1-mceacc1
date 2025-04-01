package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FactorizerTest {

    StringFactorizer factorizer = new StringFactorizer();

    @Test
    public void testFactorize() {
        assertEquals("3a 2b c", factorizer.factorize("aaabbc"));
        assertEquals("a", factorizer.factorize("a"));
        assertEquals("2a 2b 2c", factorizer.factorize("aabbcc"));
        assertEquals("5x", factorizer.factorize("xxxxx"));
        assertEquals("z", factorizer.factorize("z"));
        assertEquals("3L 3R 2F R F R F", factorizer.factorize("LLLRRRFFRFRF"));
        assertEquals("L R F", factorizer.factorize("LRF"));
        assertEquals("10L 10R 10F", factorizer.factorize("LLLLLLLLLLRRRRRRRRRRFFFFFFFFFF"));
    }

    @Test
    public void testExpand() {
        assertEquals("aaabbc", factorizer.expand("3a 2b c"));
        assertEquals("a", factorizer.expand("a"));
        assertEquals("aabbcc", factorizer.expand("2a 2b 2c"));
        assertEquals("xxxxx", factorizer.expand("5x"));
        assertEquals("z", factorizer.expand("z"));
        assertEquals("LLLRRRFFRFRF", factorizer.expand("3L 3R 2F R F R F"));
        assertEquals("LRF", factorizer.expand("L R F"));
        assertEquals("LLLLLLLLLLRRRRRRRRRRFFFFFFFFFF", factorizer.expand("10L 10R 10F"));
    }

    @Test
    public void testFactorizeAndExpandConsistency() {
        String original = "aaabbc";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "aabbcc";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "xxxxx";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "z";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "LLLRRRFFRFRF";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "LRF";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
        original = "LLLLLLLLLLRRRRRRRRRRFFFFFFFFFF";
        assertEquals(original, factorizer.expand(factorizer.factorize(original)));
    }
}