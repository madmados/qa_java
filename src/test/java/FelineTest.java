import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void felineEatMeatTest() throws Exception {
        Feline feline = new Feline();
        Feline felineTest = Mockito.spy(feline);
        Mockito.when(felineTest.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = felineTest.eatMeat();
        assertEquals("Должны совпадать", List.of("Животные", "Птицы", "Рыба"), actual);
    }


    @Test
    public void felineGetFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Должны совпадать","Кошачьи", actual);
    }

    @Test
    public void felineGetKittensTest() {
        Feline feline = new Feline();
        Feline felineTest = Mockito.spy(feline);
        Mockito.when(felineTest.getKittens(1)).thenReturn(1);
        int actual = felineTest.getKittens();
        assertEquals("Должны совпадать",1, actual);
    }
}
