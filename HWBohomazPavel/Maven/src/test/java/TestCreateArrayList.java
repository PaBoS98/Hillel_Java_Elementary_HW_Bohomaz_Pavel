import com.lesson12.CreateArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestCreateArrayList {

    private CreateArrayList<String> test;

    @BeforeEach
    public void init() {
        System.out.println("Init ArrayList");
        test = new CreateArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
    }

    @Test
    public void testAddEl() {
        CreateArrayList<Integer> test = new CreateArrayList<>();
        Assertions.assertEquals(true, test.add(2));
    }

    @Test
    public void testAddByIndex() {
        Assertions.assertEquals(true, test.add(2, "test"));
    }

    @Test
    public void testAddByIndexNeg() {
        Assertions.assertEquals(false, test.add(test.size()+1, "test"));
    }

    @Test
    public void testRemoveByObject() {
        Assertions.assertEquals(true, test.remove("1"));
    }

    @Test
    public void testRemoveByObjectNeg() {
        Assertions.assertEquals(false, test.remove("10"));
    }

    @Test
    public void testRemoveByIndex() {
        Assertions.assertEquals(true, test.remove(3));
    }

    @Test
    public void testRemoveByIndexNeg() {
        Assertions.assertEquals(false, test.remove(5));
    }

    @Test
    public void testGet() {
        Assertions.assertEquals("3", test.get(2));
    }

    @Test
    public void testGetNeg() {
        Assertions.assertEquals(null, test.get(5));
    }

    @Test
    public void testContain() {
        Assertions.assertTrue(test.contain("1"));
    }

    @Test
    public void testContainNeg() {
        Assertions.assertFalse(test.contain("5974"));
    }

    @Test
    public void testClear() {
        test.clear();
        Assertions.assertEquals( 0, test.size());
    }

    @Test
    public void testEqualsSelf() {
        CreateArrayList<String> testEqual = test;
        Assertions.assertEquals(true, testEqual.equals(test));
    }

    @Test
    public void testEquals() {
        CreateArrayList<String> testEqual = new CreateArrayList<>();
        testEqual.add("1");
        testEqual.add("2");
        testEqual.add("3");
        testEqual.add("4");
        Assertions.assertEquals(true, test.equals(testEqual));
    }

    @Test
    public void testEqualsNeg() {
        CreateArrayList<String> testEqual = new CreateArrayList<>();
        testEqual.add("1");
        testEqual.add("4");
        Assertions.assertEquals(false, test.equals(testEqual));
    }

}
