import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AwordTest {
    private Aword aword;

    @Before
    public void init() {
        aword = new Aword("wuhu!", 114, 514);
    }
    @Test
    public void mergec() {
        Aword aword1 = new Aword("qifeile.", 0, 0);
        Assert.assertEquals("wuhu!qifeile.", aword.mergec(aword1).getValue());
    }

    @Test
    public void testMergec() {
        Assert.assertEquals("wuhu!qifeile.", aword.mergec("qifeile.").getValue());
    }

    @Test
    public void getValue() {
        Assert.assertEquals(aword.getValue(), "wuhu!");
    }
}