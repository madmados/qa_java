import com.example.Animal;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test
    public void animalGetFoodPredatorTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Хищник");
        assertEquals("Должны совпадать", List.of("Животные", "Птицы", "Рыба"), actual);
    }

    @Test
    public void animalGetFoodHerbivoreTest() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood("Травоядное");
        assertEquals("Должны совпадать", List.of("Трава", "Различные растения"), actual);
    }

    @Test
    public void animalGetFoodExceptionTest() {
        try {
            Animal animal = new Animal();
            Mockito.when(animal.getFood("Ошибка")).thenThrow(new Exception("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        }
        catch (Exception e) {
            assertEquals("Должны совпадать","Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }

    @Test
    public void animalGetFamilyTest() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        assertEquals("Должны совпадать", "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }

}
