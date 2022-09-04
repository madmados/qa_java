import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void alexGetFriendsTest() throws Exception {
        Alex alex = new Alex(feline);
        List<String> actual = alex.getFriends();
        assertEquals("Должны совпадать", List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман"), actual);
    }

    @Test
    public void alexGetPlaceOfLivingTest() throws Exception {
        Alex alex = new Alex(feline);
        String actual = alex.getPlaceOfLiving();
        assertEquals("Должны совпадать", "Нью-Йоркский зоопарк", actual);
    }

    @Test
    public void alexGetKittensTest() throws Exception {
        Alex alex = new Alex(feline);
        int actual = alex.getKittens();
        assertEquals("Должны совпадать", 0, actual);
    }
}
