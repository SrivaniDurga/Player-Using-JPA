
package com.example.player.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.repository.PlayerJpaRepository;
import com.example.player.repository.PlayerRepository;
@Service
public class PlayerJpaService implements PlayerRepository{
    @Autowired

    private PlayerJpaRepository songJpaRepository;

    @Override
    public ArrayList<Player> getPlayers(){
        List<Player> songList = songJpaRepository.findAll();
        ArrayList<Player> songs = new ArrayList<>(songList);
        return songs;
    }
    @Override
    public Player getPlayerById(int playerId){
        try{
            Player song = songJpaRepository.findById(playerId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Player addPlayer(Player player){
        songJpaRepository.save(player);
        return player;      
    }
    @Override
    public Player updatePlayer(int playerId , Player player){
        try{
            Player newSong = songJpaRepository.findById(playerId).get();
            
            if(player.getPlayerName() != null){
                newSong.setPlayerName(player.getPlayerName());
            }

            if(player.getJerseyNumber() != 0){
                newSong.setJerseyNumber(player.getJerseyNumber()); 
            }

            if(player.getRole() != null){
                newSong.setRole(player.getRole());
            }

            songJpaRepository.save(newSong);
            return newSong;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
    @Override
    public void deletePlayer(int playerId){
        try{
            songJpaRepository.deleteById(playerId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
