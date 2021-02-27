import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    public static void initiate(){
        System.out.println("initiate test");
    }

    @AfterAll
    public static void end(){
        System.out.println("end");
    }

    @BeforeEach
    public void eachBefore(){
        System.out.println("before each test start");
    }


    @AfterEach
    public void eachAfter(){
        System.out.println("after each test end");
    }


    @Test
    void add() {
        System.out.println("test add");
        int actual = Calculator.add(1,2);
        assertEquals(3,3);
    }

    @Test
    void test1(){
        System.out.println("test test1");
        int [] arr1 = {1,2,3};
        int [] arr2 = {1,2,3};

        assertArrayEquals(arr1,arr2);
    }


    @Test
    void test2(){
        System.out.println("test test2");

        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void test3(){
        System.out.println("test test3");

        String nullString = null;
         String notNull = "ABC";

         assertNull(nullString);
         assertNotNull(notNull);
    }


    @Test
    void throwError() {
        System.out.println("test throw");
        assertThrows(NullPointerException.class,()->{
            Calculator.throwError();
        });


    }
}

