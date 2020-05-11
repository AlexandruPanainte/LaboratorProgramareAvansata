package Lab11java.service;

import Lab11java.model.Game;
import Lab11java.model.Player;
import Lab11java.repo.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PlayerService {
    @Autowired
    private PlayerRepository repository;
    //Salveaza un player
    public Player savePlayer(Player player){                    
        return repository.save(player);
    }
    //Salveaza playeri
    public List<Player> savePlayers(List<Player> players){     
        return repository.saveAll(players);
    }
    public List<Player> getPlayers(){
        return repository.findAll();
    }
    //Cautare dupa id
    public Player getPlayerById(int id){                        
        return repository.findPlayerById(id).orElse(null);
    }
    public Game createGame() {
    }
    //Cautare dupa nume
    public Player getPlayerByName(String name){                 
        return repository.findByName(name);
    }
    //Sterge un player in functie de id
    public String deletePlayer(int id){
        repository.deleteById(id);
        return "Player-ul cu id-ul "+id+" a fost sters";        
    }
    public Player playerUpdate(Player player){
        Player playerExistent = repository.findPlayerById(player.getId()).orElse(null);
        playerExistent.setName(player.getName());
        return repository.save(playerExistent);
    }

    public List<Game> getAllGame() {
    }
}