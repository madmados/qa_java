import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionMaleTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Должны совпадать",true, actual);
    }

    @Test
    public void lionFemaleTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Должны совпадать", false, actual);
    }
    @Test
    public void lionExceptionTest() {
        Exception e = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Неизвестный", feline);
        });
        assertEquals("Должны совпадать","Используйте допустимые значения пола животного - самец или самка", e.getMessage());
    }

    @Test
    public void lionGetKittensTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actual = lion.getKittens();
        assertEquals("Должны совпадать",1, actual);
    }

    @Test
    public void lionDoesHaveManeTest() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean actual = lion.doesHaveMane();
        assertEquals("Должны совпадать", false, actual);
    }

    @Test
    public void lionGetFoodTest() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = lion.getFood();
        assertEquals("Должны совпадать", List.of("Животные", "Птицы", "Рыба"), actual);
    }
}
