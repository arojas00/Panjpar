/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author jafet
 */
public class ValidatorPanjpar extends Validator<PlayerPanjpar>{

    @Override
    public Boolean checkTable(PlayerPanjpar attacker, PlayerPanjpar defender, 
            Boolean round, String trumpType) {
        ArrayList<Integer> values = new ArrayList<>();
        Boolean valid = false;
        if(round){
            if(attacker.getTable().getCards().size() <= 
                    defender.getHand().getCards().size()){
                int size = attacker.getTable().getCards().size();
                switch (size) {
                    case 1: valid = true;
                        break;
                    case 3: for (Card aux : attacker.getTable().getCards()) {
                                values.add(aux.getValue());
                            }
                            Collections.sort(values);
                            if(Objects.equals(values.get(0), values.get(1)) ||
                                  Objects.equals(values.get(1), values.get(2))){
                                valid = true;
                            }
                        break;

                    case 5: 
                            for (Card aux : attacker.getTable().getCards()) {
                                values.add(aux.getValue());
                            }
                            Collections.sort(values);
                            Map<Integer, Integer> countMap = new HashMap<>();
                            for (Integer item : values) {
                                if (countMap.containsKey(item)){
                                    countMap.put(item, countMap.get(item) + 1);
                                }else{
                                    countMap.put(item, 1);
                                }
                            }
                            int pairs = 0;
                            int trio = 0;
                            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                                if (null != entry.getValue()) {
                                    switch (entry.getValue()) {
                                        case 4:
                                            pairs += 2;
                                        case 2:
                                            pairs++;
                                            break;
                                        case 3:
                                            trio++;
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            }
                            if(pairs == 2 || (pairs == 1 && trio == 1)){
                                valid = true;
                            }
                        break;

                    default: valid = false;
                        break;
                }
            }
        } else {
            valid = defender.getTable().getCards().size() <= 
                    attacker.getTable().getCards().size();
        }
        return valid;
    }

    @Override
    public Boolean checkPlay(PlayerPanjpar attacker, PlayerPanjpar defender, 
            String trumpType) {
        Boolean victory = false;
        int victoryCount = 0;
        int size = attacker.getTable().getCards().size();
        if(defender.getTable().getCards().size() < 
                attacker.getTable().getCards().size()){
            for(int i = defender.getTable().getCards().size(); i < size; i++){
                defender.getHand().getCards().add(
                        attacker.getTable().getCard(i));
            }
        }
        for(int i = 0; i < defender.getTable().getCards().size(); i++){
            if(defender.getTable().getCard(i).getType().equals(trumpType) && 
                    attacker.getTable().getCard(i).getType().equals(trumpType)){
                if(defender.getTable().getCard(i).getValue() > 
                        attacker.getTable().getCard(i).getValue()){
                    victoryCount++;
                } else {
                    defender.getHand().getCards().add(
                            defender.getTable().getCard(i));
                    defender.getHand().getCards().add(
                            attacker.getTable().getCard(i));
                }
            } else if(defender.getTable().getCard(i).getType().equals(trumpType)){
                victoryCount++;
            } else {
                if(defender.getTable().getCard(i).getType().equals(
                        attacker.getTable().getCard(i).getType()) && 
                        defender.getTable().getCard(i).getValue() > 
                        attacker.getTable().getCard(i).getValue()){
                    victoryCount++;
                } else {
                    defender.getHand().getCards().add(
                            defender.getTable().getCard(i));
                    defender.getHand().getCards().add(
                            attacker.getTable().getCard(i));
                }
            }
        }
        if(victoryCount == size){
            victory = true;
        }
        return victory;
    }

    @Override
    public int checkWinner(PlayerPanjpar attacker, PlayerPanjpar defender) {
        if(defender.getHand().isEmpty() && 
                attacker.getHand().isEmpty()){
            return 1;
        }else{
            if(attacker.getHand().isEmpty()){
                return 2;
            } else if(defender.getHand().isEmpty()){
                return 3;
            }
        }
        return 0;
    }
    
}
