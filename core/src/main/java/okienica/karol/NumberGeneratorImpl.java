package okienica.karol;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class NumberGeneratorImpl implements NumberGenerator {

    //    == fields ==
    private final Random random = new Random();

    @Getter
    private final int minNumber;

    @Getter
    private final int maxNumber;

    //    == constructors ==
    @Autowired
    public NumberGeneratorImpl(@MinNumber int minNumber, @MaxNumber int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
    }

    //    == public methods ==
    @Override
    public int next() {
        return random.nextInt(maxNumber - minNumber) + minNumber;
    }
}
