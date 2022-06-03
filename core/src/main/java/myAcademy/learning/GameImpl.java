package myAcademy.learning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game{
    private static final Logger log= LoggerFactory.getLogger(GameImpl.class);

    private final NumberGenerate numberGenerate;

    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerate numberGenerate,@GuessCount int guessCount) {
        this.numberGenerate = numberGenerate;
        this.guessCount = guessCount;
    }

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRage;


    @PostConstruct
    @Override
    public void reset() {
        smallest=numberGenerate.getMinNumber();
        guess=numberGenerate.getMinNumber();
        remainingGuesses=guessCount;
        biggest=numberGenerate.getMaxNumber();
        number=numberGenerate.next();
        log.debug("The number is {}",number);
    }

    @PreDestroy
    public void proDestroy(){
        log.info("in Game preDestroy()");
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess=guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {
        checkValidNumber();
        if (validNumberRage){
            if (guess>number){
                biggest=guess-1;
            }
            if (guess<number){
                smallest=guess+1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRage;
    }

    @Override
    public boolean isGameWon() {
        return guess==number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon()&& remainingGuesses<=0;
    }
    private void checkValidNumber(){
        validNumberRage=(guess>=smallest)&&(guess<=biggest);
    }

}
