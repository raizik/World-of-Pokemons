package com.plainid.assignment.controller;


import com.plainid.assignment.dao.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Pokemon controller
 */
@RestController
@RequestMapping(value="",method = RequestMethod.GET,headers="Accept=application/json")
public class PokemonController {

    //private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    private final PokemonDao pDao;
    private final TrainerDao tDao;

    PokemonController(PokemonDao pd, TrainerDao td) {
        this.pDao = pd;
        this.tDao = td;
    }

    //@Autowired
    //PokemonDao pDao;
    /**
     * Get all pokemons in the world
     * @return List of pokemons in the world.
     */
   @GetMapping("/pokemon/list")
    public PokemonList getPokemons() {
       List<Pokemon> rows = pDao.getAll();
       PokemonList pokemonList = new PokemonList();
       pokemonList.setPokemons(rows);
       //log.info(pokemonList.getPokemons().get(0).toString());
       return pokemonList;
    }
    @GetMapping("/trainers")
    public TrainersList getTrainers() {
        List<Trainer> rows = tDao.getAll();
        TrainersList tList = new TrainersList();
        tList.setTrainers(rows);
        return tList;
    }
    @GetMapping("/trainer/{trainer_name}")
    public Trainer getTrainer(@PathVariable("trainer_name") String trainer_name) {
        Trainer t = tDao.get(trainer_name);
       return t;
    }
    @GetMapping("/battle/{trainer1_name}/{trainer2_name}")
    public ArrayList<String> getBattle(@PathVariable String trainer1_name, @PathVariable String trainer2_name) {
       Trainer t1 = tDao.get(trainer1_name);
       Trainer t2 = tDao.get(trainer2_name);

        Battle b = new Battle();
       b.goBattle(t1, t2);
       //update trainers levels in the DB
        tDao.update(t1, t1.getLevel(),0);
        tDao.update(t2, t2.getLevel(),0);
       ArrayList<String> l_res = new ArrayList<String>();
       l_res.add("{status: " + b.getStatus());
       l_res.add("message: " + b.getMessage() + "}");
       return l_res;
    }
    @GetMapping("/trainer/{trainer_name}/catch/{pokemon_name}")
    public List<Pokemon> getCatch(@PathVariable String trainer_name, @PathVariable String pokemon_name) {
       //check if pokemon already caught by another trainer
       if (pDao.get(pokemon_name).getTname() != "")
           return null;
        Trainer t = tDao.get(trainer_name);
        int insertion_time = (t.getBagSize() == 0) ? 0 : (t.getBagSize());
       if (t.isBagFull()) {
           //delete most former pokemon from bag
           Pokemon p = tDao.getMostFormerPokemon(t);
           pDao.update(p, "",2);
           //update pokemons in bag with insertion times: 1-->0 and 2-->1
           pDao.update(t.getBag().get(1), t.getName(), 0);
           pDao.update(t.getBag().get(2), t.getName(), 1);
           //caught pokemon is newest pokemon in bag
           insertion_time = 2;
       }
        Pokemon p_updated = pDao.get(pokemon_name);

        pDao.update(p_updated, trainer_name, insertion_time);
       Trainer t_updated = tDao.get(trainer_name);
       if (!t_updated.isBagFull())
           tDao.updateBagSize(t_updated, t_updated.getBagSize() + 1);
       return t_updated.getBag();
    }
}


