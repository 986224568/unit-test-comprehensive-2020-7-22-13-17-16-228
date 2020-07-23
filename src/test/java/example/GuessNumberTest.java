package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;




import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class GuessNumberTest {
    @Test
    void should_return_4A0B_when_guess_given_answer_1234_and_input_guess_1234() {
        //given
        int[] answer = {1,2,3,4};
        GenerateRandomNum generateRandomNum = Mockito.mock(GenerateRandomNum.class);
        when(generateRandomNum.generateRandomNum()).thenReturn(answer);
        GuessNumber guessNumber = new GuessNumber(generateRandomNum);
        int[] inputGuess = {1,2,3,4};
        //when
        String result = guessNumber.guess(inputGuess);
        //then
        assertEquals("4A0B",result);
    }

//    private class TestAnswerGenerator implements AnswerGenerator {
//        private int[] answer;
//        public TestAnswerGenerator(int[] answer) {
//            this.answer = answer;
//        }
//        @Override
//        public int[] generate() {
//            return answer;
//        }
//    }
}
