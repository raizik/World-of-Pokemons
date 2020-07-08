# World-of-Pokemons

RESTfufl API for managing Pokemon battles using Spring Boot and H2 in-memory embedded SQL DB combined with Java 8 and Maven

## API calls


### Battle
```GET ​http://​localhost:<port>/battle/{trainer1_name}/{trainer2_name}```

### Get trainers' Pokemons bag

```GET ​http://​localhost:<port>/trainer/{trainer_name}```

### Catch a new Pokemon

```GET http://​localhost:<port>/trainer/{trainer_name}/catch/{pokemon_name}```

### Get all trainers' Pokemons bags

```GET ​http://​localhost:<port>/trainers```
