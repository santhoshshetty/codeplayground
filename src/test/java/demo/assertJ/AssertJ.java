package demo.assertJ;

import org.assertj.core.data.Offset;
import org.assertj.core.data.Percentage;
import org.assertj.jodatime.api.Assertions;
import org.joda.time.LocalDate;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.assertj.core.api.BDDAssertions.then;


public class AssertJ {
    public static void main(String[] args) throws IOException {
        //Equal Assertions
        assertThat("John Doe").isEqualTo("John Doe");
        assertThat("John").isNotEqualTo("Doe");

        //Null Assertions
        String value="John";
        String nullValue = null;
        assertThat(value).as("Non Null Check").isNotNull();
        assertThat(nullValue).as("Null Check").isNull();

        //Boolean Assertions
        Boolean boolValue = true;
        assertThat(boolValue).isTrue();
        assertThat(boolValue).isNotEqualTo(false);

        //String Assertions - Chaining the Assertions
        String strValue="Happy New Year";
        assertThat(strValue)
                .describedAs("String Assertions")
                .isNotNull()
                .startsWith("Happy")
                .contains("New")
                .endsWith("Year")
                .isNotBlank()
                .isNotEmpty()
                .overridingErrorMessage(()->"Custom Message..")
                .containsWhitespaces()
                .doesNotContainOnlyWhitespaces()
                .isMixedCase()
                .containsIgnoringWhitespaces("HappyNewYear")
                .hasSizeGreaterThan(5)
                .as("Input contains only the characters and space")
                .matches("^[a-zA-Z ]*")
                .describedAs("Input doesn't contain the numbers")
                .doesNotMatch("\\d.*")
                .isInstanceOf(String.class);
        assertThat("Game'of'Thrones").isEqualToNormalizingPunctuationAndWhitespace("GameofThrones");

        //Numeric Assertions
        int number=58;
        assertThat(number)
                .describedAs("Numeric Assertions")
                .isPositive()
                .isNotNegative()
                .isNotZero()
                .isBetween(35,70)
                .isInstanceOf(Integer.class)
                .isEven()
                .isCloseTo(60, Offset.offset(2))
                .isCloseTo(52, Percentage.withPercentage(15))
                .isNotCloseTo(70,Percentage.withPercentage(5));

        //List based Iterable Assertions
        List<String> languages= Arrays.asList("Java","Python","Ruby","Go");
        List<String> spokenLanguage=Arrays.asList("English","Deutsch");
        assertThat(languages)
                .hasSize(4)
                .hasSizeLessThan(6)
                .isNotEmpty()
                .isNotNull()
                .doesNotContainNull()
                .doesNotHaveDuplicates()
                .isInstanceOf(List.class)
                .doesNotContainAnyElementsOf(spokenLanguage)
                .withFailMessage(()->"Input doen't matches criteria")
                .allMatch(s->s.matches("^[a-zA-Z]*"))
                .containsExactly("Java","Python","Ruby","Go");

        //Map based Assertions
        Map<String, String> sports=new HashMap<>();
        sports.put("Cricket","England");
        sports.put("Football","Germany");
        sports.put("Hockey","India");
        assertThat(sports)
                .hasSize(3)
                .containsKey("Cricket")
                .containsValue("India")
                .containsEntry("Football","Germany")
                .isInstanceOf(Map.class)
                .isNotNull()
                .satisfies(sport -> assertThat(sport.size()>2));

        //Object based Assertions
        Student s1=new Student("James",24,"Hyd");
        Student s2=new Student("John",28,"BLR");
        Student s3=new Student("Rosy",26,"Mum");
        assertThat(s1)
                .isInstanceOf(Student.class)
                .as("%s age should be less than 35",s1.getName())
                .hasFieldOrProperty("age")
                .hasFieldOrPropertyWithValue("city","Hyd")
                .hasNoNullFieldsOrProperties()
                .extracting(s -> s.getAge())
                .isEqualTo(24);

        //File based Assertions
        File fileObj= new File(System.getProperty("user.dir").concat(System.getProperty("file.separator")+"Sample.txt"));
        assertThat(fileObj)
                .describedAs("File Assertions")
                .canRead()
                .canWrite()
                .isFile()
                .hasExtension("txt");

        //Exception Assertions
        assertThatThrownBy(()->getException()).as("Check Exception").isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()->{throw new Exception("foo");}).hasMessage("foo");

        //Date and Time Based Assertions
        LocalDate date=new LocalDate(2023,1,1);
        Assertions.assertThat(date)
                .hasYear(2023)
                .hasMonthOfYear(1)
                .hasDayOfMonth(1)
                .isBefore(new LocalDate(2024,1,1));

        //BDD Assertions
        then("AssertJ")
                .satisfies(val->{
                    assertThat(val).isNotNull();
                    assertThat(val.length()).isGreaterThan(4);
                });

    }
    public static void getException(){
        throw new RuntimeException();
    }
}
