import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AwordsTest {
    private Awords awords;

    @Before
    public void init() {
        awords = new Awords(0, 0);
    }

    @Test
    public void getLen() {
        for (int i = 0; i < 3; i++) {
            awords.addin(i + 1, i + 1);
            Assert.assertEquals(awords.getLen(), i + 2);
        }
    }
}