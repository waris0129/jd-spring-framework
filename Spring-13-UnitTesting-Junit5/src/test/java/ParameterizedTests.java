import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests {


    //@ParameterizedTest
    /*
        @ValueSource
        @MethodSource --> static method
        @CsvSource
        @CsvFileSource
     */

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void test_ValueSource(String args){
        Assertions.assertTrue(!args.isEmpty());
    }


    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void test_ValueSource2(int args){
        Assertions.assertEquals(0,args%3);
    }



    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    @EmptySource
    @NullSource
    void test_ValueSource3(String args){
        Assertions.assertTrue(!args.isEmpty());
    }


    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    @NullAndEmptySource
    void test_ValueSource4(String args){
        Assertions.assertTrue(!args.isEmpty());
    }


    // MethodSource
    @ParameterizedTest
    @MethodSource("stringProvider")
    void methodSource1(String args){
        Assertions.assertNotNull(args);
    }

    static String[] stringProvider() {

        String [] str = {"java","js","ts",null};

        return str;
    }


    // @CsvSource
    @ParameterizedTest
    @CsvSource({
        "10,20,30",
        "20,20,40",
        "40,40,90"
    })
    void csvSource1(int num1, int num2, int result) {
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }



    //@CsvFileSource
    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv",numLinesToSkip = 1)
    void csvFileSource1(int num1, int num2, int result) {
        Assertions.assertEquals(result,Calculator.add(num1,num2));
    }



}
