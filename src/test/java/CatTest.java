import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    Feline feline;

    @Test
    public void catGetSoundTest() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        assertEquals("Должны совпадать", "Мяу", actual);
    }

    @Test
    public void catGetFoodTest() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(cat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actual = cat.getFood();
        assertEquals("Должны совпадать", List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void catGetFoodExceptionTest() {
        try {
            Cat cat = new Cat(feline);
            Mockito.when(cat.getFood()).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        }
        catch (Exception e) {
            assertEquals("Должны совпадать","Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

}
