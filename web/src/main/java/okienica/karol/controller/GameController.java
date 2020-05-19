package okienica.karol.controller;

import lombok.extern.slf4j.Slf4j;
import okienica.karol.service.GameService;
import okienica.karol.util.AttributeNames;
import okienica.karol.util.GameMappings;
import okienica.karol.util.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GameController {

//    == fields ==
    private final GameService gameService;

//    == constructors ==
    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

//    == request methods ==
    @GetMapping(GameMappings.PLAY)
    public String play(Model model){
        model.addAttribute(AttributeNames.MAIN_MESSAGE, gameService.getMainMessage());
        model.addAttribute(AttributeNames.RESULT_MESSAGE, gameService.getResultMessage());
        log.info("model = {}", model);

        if(gameService.isGameOver()){
            return ViewNames.GAME_OVER;
        }

        return ViewNames.PLAY;
    }

    @PostMapping(GameMappings.PLAY)
    public String processMessage(@RequestParam int guess){
        log.info("guess = {}", guess);
        gameService.checkGuess(guess);
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.RESTART)
    public String restart(){
        gameService.reset();
        return GameMappings.REDIRECT_PLAY;
    }

    @GetMapping(GameMappings.HOME)
    public String home(){
        gameService.reset();
        return ViewNames.HOME;
    }
}
