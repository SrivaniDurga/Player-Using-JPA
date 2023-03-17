package com.example.player.controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.player.model.Player;
import com.example.player.service.PlayerJpaService;
import org.springframework.beans.factory.annotation.Autowired;
@RestController
public class PlayerController{
    @Autowired
    public PlayerJpaService playersevice;
    @GetMapping("/players")
    public ArrayList<Player> getPlayers(){
        return playersevice.getPlayers();
    }
    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable ("playerId") int playerId){
        return playersevice.getPlayerById(playerId);
    }
    @PostMapping("/players")
    public Player addPlayerpost(@RequestBody Player player){
        return playersevice.addPlayer(player);
    }
    @PutMapping("/players/{playerId}")
    public Player updatePlayer(@PathVariable ("playerId") int playerId , @RequestBody Player player){
        return playersevice.updatePlayer(playerId , player);
    }
    @DeleteMapping("/players/{playerId}")
    public void deleteplayerss(@PathVariable ("playerId") int playerId){
        playersevice.deletePlayer(playerId);
    }

}