
package pokemonslash.Pokemons;

import java.io.Serializable;


public enum PokemonBaseStats implements Serializable {
    BULBASAUR(1, "Bulbasaur", 45, 49, 49, 45, 65, 65, 64, 1),
    IVYSAUR(2, "Ivysaur", 60, 62, 63, 60, 80, 80, 141, 1),
    VENUSAUR(3, "Venusaur", 80, 82, 83, 80, 100, 100, 208, 1),
    CHARMANDER(4, "Charmander", 39, 52, 43, 65, 50, 50, 65, 1),
    CHARMELEON(5, "Charmeleon", 58, 64, 58, 80, 65, 65, 142, 1),
    CHARIZARD(6, "Charizard", 78, 84, 78, 100, 85, 85, 209, 1),
    SQUIRTLE(7, "Squirtle", 44, 48, 65, 43, 50, 50, 66, 1),
    WARTORTLE(8, "Wartortle", 59, 63, 80, 58, 65, 65, 143, 1),
    BLASTOISE(9, "Blastoise", 79, 83, 100, 78, 85, 85, 210, 1),
    CATERPIE(10, "Caterpie", 45, 30, 35, 45, 20, 20, 53, 2),
    METAPOD(11, "Metapod", 50, 20, 55, 30, 25, 25, 72, 2),
    BUTTERFREE(12, "Butterfree", 60, 45, 50, 70, 80, 80, 160, 2),
    WEEDLE(13, "Weedle", 40, 35, 30, 50, 20, 20, 52, 2),
    KAKUNA(14, "Kakuna", 45, 25, 50, 35, 25, 25, 71, 2),
    BEEDRILL(15, "Beedrill", 65, 80, 40, 75, 45, 45, 159, 2),
    PIDGEY(16, "Pidgey", 40, 45, 40, 56, 35, 35, 55, 1),
    PIDGEOTTO(17, "Pidgeotto", 63, 60, 55, 71, 50, 50, 113, 1),
    PIDGEOT(18, "Pidgeot", 83, 80, 75, 91, 70, 70, 172, 1),
    RATTATA(19, "Rattata", 30, 56, 35, 72, 25, 25, 57, 2),
    RATICATE(20, "Raticate", 55, 81, 60, 97, 50, 50, 116, 2),
    SPEAROW(21, "Spearow", 40, 60, 30, 70, 31, 31, 58, 2),
    FEAROW(22, "Fearow", 65, 90, 65, 100, 61, 61, 162, 2),
    EKANS(23, "Ekans", 35, 60, 44, 55, 40, 40, 62, 2),
    ARBOK(24, "Arbok", 60, 85, 69, 80, 65, 65, 147, 2),
    PIKACHU(25, "Pikachu", 35, 55, 30, 90, 50, 50, 82, 2),
    RAICHU(26, "Raichu", 60, 90, 55, 100, 90, 90, 122, 2),
    SANDSHREW(27, "Sandshrew", 50, 75, 85, 40, 30, 30, 93, 2),
    SANDSLASH(28, "Sandslash", 75, 100, 110, 65, 55, 55, 163, 2),
    NIDORANF(29, "NidoranF", 55, 47, 52, 41, 40, 40, 59, 1),
    NIDORINA(30, "Nidorina", 70, 62, 67, 56, 55, 55, 117, 1),
    NIDOQUEEN(31, "Nidoqueen", 90, 82, 87, 76, 75, 75, 194, 1),
    NIDORANM(32, "NidoranM", 46, 57, 40, 50, 40, 40, 60, 1),
    NIDORINO(33, "Nidorino", 61, 72, 57, 65, 55, 55, 118, 1),
    NIDOKING(34, "Nidoking", 81, 92, 77, 85, 75, 75, 195, 1),
    CLEFAIRY(35, "Clefairy", 70, 45, 48, 35, 60, 60, 68, 3),
    CLEFABLE(36, "Clefable", 95, 70, 73, 60, 85, 85, 129, 3),
    VULPIX(37, "Vulpix", 38, 41, 40, 65, 65, 65, 63, 2),
    NINETALES(38, "Ninetales", 73, 76, 75, 100, 100, 100, 178, 2),
    JIGGLYPUFF(39, "Jigglypuff", 115, 45, 20, 20, 25, 25, 76, 3),
    WIGGLYTUFF(40, "Wigglytuff", 140, 70, 45, 45, 50, 50, 109, 3),
    ZUBAT(41, "Zubat", 40, 45, 35, 55, 40, 40, 54, 2),
    GOLBAT(42, "Golbat", 75, 80, 70, 90, 75, 75, 171, 2),
    ODDISH(43, "Oddish", 45, 50, 55, 30, 75, 75, 78, 1),
    GLOOM(44, "Gloom", 60, 65, 70, 40, 85, 85, 132, 1),
    VILEPLUME(45, "Vileplume", 75, 80, 85, 50, 100, 100, 184, 1),
    PARAS(46, "Paras", 35, 70, 55, 25, 55, 55, 70, 2),
    PARASECT(47, "Parasect", 60, 95, 80, 30, 80, 80, 128, 2),
    VENONAT(48, "Venonat", 60, 55, 50, 45, 40, 40, 75, 2),
    VENOMOTH(49, "Venomoth", 70, 65, 60, 90, 90, 90, 138, 2),
    DIGLETT(50, "Diglett", 10, 55, 25, 95, 45, 45, 81, 2),
    DUGTRIO(51, "Dugtrio", 35, 80, 50, 120, 70, 70, 153, 2),
    MEOWTH(52, "Meowth", 40, 45, 35, 90, 40, 40, 69, 2),
    PERSIAN(53, "Persian", 65, 70, 60, 115, 65, 65, 148, 2),
    PSYDUCK(54, "Psyduck", 50, 52, 48, 55, 50, 50, 80, 2),
    GOLDUCK(55, "Golduck", 80, 82, 78, 85, 80, 80, 174, 2),
    MANKEY(56, "Mankey", 40, 80, 35, 70, 35, 35, 74, 2),
    PRIMEAPE(57, "Primeape", 65, 105, 60, 95, 60, 60, 149, 2),
    GROWLITHE(58, "Growlithe", 55, 70, 45, 60, 50, 50, 91, 4),
    ARCANINE(59, "Arcanine", 90, 110, 80, 95, 80, 80, 213, 4),
    POLIWAG(60, "Poliwag", 40, 50, 40, 90, 40, 40, 77, 1),
    POLIWHIRL(61, "Poliwhirl", 65, 65, 65, 90, 50, 50, 131, 1),
    POLIWRATH(62, "Poliwrath", 90, 85, 95, 70, 70, 70, 185, 1),
    ABRA(63, "Abra", 25, 20, 15, 90, 105, 105, 75, 1),
    KADABRA(64, "Kadabra", 40, 35, 30, 105, 120, 120, 145, 1),
    ALAKAZAM(65, "Alakazam", 55, 50, 45, 120, 135, 135, 186, 1),
    MACHOP(66, "Machop", 70, 80, 50, 35, 35, 35, 75, 1),
    MACHOKE(67, "Machoke", 80, 100, 70, 45, 50, 50, 146, 1),
    MACHAMP(68, "Machamp", 90, 130, 80, 55, 65, 65, 193, 1),
    BELLSPROUT(69, "Bellsprout", 50, 75, 35, 40, 70, 70, 84, 1),
    WEEPINBELL(70, "Weepinbell", 65, 90, 50, 55, 85, 85, 151, 1),
    VICTREEBEL(71, "Victreebel", 80, 105, 65, 70, 100, 100, 191, 1),
    TENTACOOL(72, "Tentacool", 40, 40, 35, 70, 100, 100, 105, 4),
    TENTACRUEL(73, "Tentacruel", 80, 70, 65, 100, 120, 120, 205, 4),
    GEODUDE(74, "Geodude", 40, 80, 100, 20, 30, 30, 73, 1),
    GRAVELER(75, "Graveler", 55, 95, 115, 35, 45, 45, 134, 1),
    GOLEM(76, "Golem", 80, 110, 130, 45, 55, 55, 177, 1),
    PONYTA(77, "Ponyta", 50, 85, 55, 90, 65, 65, 152, 2),
    RAPIDASH(78, "Rapidash", 65, 100, 70, 105, 80, 80, 192, 2),
    SLOWPOKE(79, "Slowpoke", 90, 65, 65, 15, 40, 40, 99, 2),
    SLOWBRO(80, "Slowbro", 95, 75, 110, 30, 80, 80, 164, 2),
    MAGNEMITE(81, "Magnemite", 25, 35, 70, 45, 95, 95, 89, 2),
    MAGNETON(82, "Magneton", 50, 60, 95, 70, 120, 120, 161, 2),
    FARFETCHD(83, "Farfetch'd", 52, 65, 55, 60, 58, 58, 94, 2),
    DODUO(84, "Doduo", 35, 85, 45, 75, 35, 35, 96, 2),
    DODRIO(85, "Dodrio", 60, 110, 70, 100, 60, 60, 158, 2),
    SEEL(86, "Seel", 65, 45, 55, 45, 70, 70, 100, 2),
    DEWGONG(87, "Dewgong", 90, 70, 80, 70, 95, 95, 176, 2),
    GRIMER(88, "Grimer", 80, 80, 50, 25, 40, 40, 90, 2),
    MUK(89, "Muk", 105, 105, 75, 50, 65, 65, 157, 2),
    SHELLDER(90, "Shellder", 30, 65, 100, 40, 45, 45, 97, 4),
    CLOYSTER(91, "Cloyster", 50, 95, 180, 70, 85, 85, 203, 4),
    GASTLY(92, "Gastly", 30, 35, 30, 80, 100, 100, 95, 1),
    HAUNTER(93, "Haunter", 45, 50, 45, 95, 115, 115, 126, 1),
    GENGAR(94, "Gengar", 60, 65, 60, 110, 130, 130, 190, 1),
    ONIX(95, "Onix", 35, 45, 160, 70, 30, 30, 108, 2),
    DROWZEE(96, "Drowzee", 60, 48, 45, 42, 90, 90, 102, 2),
    HYPNO(97, "Hypno", 85, 73, 70, 67, 115, 115, 165, 2),
    KRABBY(98, "Krabby", 30, 105, 90, 50, 25, 25, 115, 2),
    KINGLER(99, "Kingler", 55, 130, 115, 75, 50, 50, 206, 2),
    VOLTORB(100, "Voltorb", 40, 30, 50, 100, 55, 55, 103, 2),
    ELECTRODE(101, "Electrode", 60, 50, 70, 140, 80, 80, 150, 2),
    EXEGGCUTE(102, "Exeggcute", 60, 40, 80, 40, 60, 60, 98, 4),
    EXEGGUTOR(103, "Exeggutor", 95, 95, 85, 55, 125, 125, 212, 4),
    CUBONE(104, "Cubone", 50, 50, 95, 35, 40, 40, 87, 2),
    MAROWAK(105, "Marowak", 60, 80, 110, 45, 50, 50, 124, 2),
    HITMONLEE(106, "Hitmonlee", 50, 120, 53, 87, 35, 35, 139, 2),
    HITMONCHAN(107, "Hitmonchan", 50, 105, 79, 76, 35, 35, 140, 2),
    LICKITUNG(108, "Lickitung", 90, 55, 75, 30, 60, 60, 127, 2),
    KOFFING(109, "Koffing", 40, 65, 95, 35, 60, 60, 114, 2),
    WEEZING(110, "Weezing", 65, 90, 120, 60, 85, 85, 173, 2),
    RHYHORN(111, "Rhyhorn", 80, 85, 95, 25, 30, 30, 135, 4),
    RHYDON(112, "Rhydon", 105, 130, 120, 40, 45, 45, 204, 4),
    CHANSEY(113, "Chansey", 250, 5, 5, 50, 105, 105, 255, 3),
    TANGELA(114, "Tangela", 65, 55, 115, 60, 100, 100, 166, 2),
    KANGASKHAN(115, "Kangaskhan", 105, 95, 80, 90, 40, 40, 175, 2),
    HORSEA(116, "Horsea", 30, 40, 70, 60, 70, 70, 83, 2),
    SEADRA(117, "Seadra", 55, 65, 95, 85, 95, 95, 155, 2),
    GOLDEEN(118, "Goldeen", 45, 67, 60, 63, 50, 50, 111, 2),
    SEAKING(119, "Seaking", 80, 92, 65, 68, 80, 80, 170, 2),
    STARYU(120, "Staryu", 30, 45, 55, 85, 70, 70, 106, 4),
    STARMIE(121, "Starmie", 60, 75, 85, 115, 100, 100, 207, 4),
    MRMIME(122, "Mr. Mime", 40, 45, 65, 90, 90, 68, 136, 2),
    SCYTHER(123, "Scyther", 70, 110, 80, 105, 55, 55, 187, 2),
    JYNX(124, "Jynx", 65, 50, 35, 95, 95, 95, 137, 2),
    ELECTABUZZ(125, "Electabuzz", 65, 83, 57, 105, 85, 85, 156, 2),
    MAGMAR(126, "Magmar", 65, 95, 57, 93, 85, 85, 167, 2),
    PINSIR(127, "Pinsir", 65, 125, 100, 85, 55, 55, 200, 4),
    TAUROS(128, "Tauros", 75, 100, 95, 110, 70, 70, 211, 4),
    MAGIKARP(129, "Magikarp", 20, 10, 55, 80, 20, 20, 20, 4),
    GYARADOS(130, "Gyarados", 95, 125, 79, 81, 100, 100, 214, 4),
    LAPRAS(131, "Lapras", 130, 85, 80, 60, 95, 95, 219, 4),
    DITTO(132, "Ditto", 48, 48, 48, 48, 48, 48, 61, 2),
    EEVEE(133, "Eevee", 55, 55, 50, 55, 65, 65, 92, 2),
    VAPOREON(134, "Vaporeon", 130, 65, 60, 65, 110, 110, 196, 2),
    JOLTEON(135, "Jolteon", 65, 65, 60, 130, 110, 110, 197, 2),
    FLAREON(136, "Flareon", 65, 130, 60, 65, 110, 110, 198, 2),
    PORYGON(137, "Porygon", 65, 60, 70, 40, 75, 75, 130, 2),
    OMANYTE(138, "Omanyte", 35, 40, 100, 35, 90, 90, 99, 2),
    OMASTAR(139, "Omastar", 70, 60, 125, 55, 115, 115, 199, 2),
    KABUTO(140, "Kabuto", 30, 80, 90, 55, 45, 45, 99, 2),
    KABUTOPS(141, "Kabutops", 60, 115, 105, 80, 70, 70, 199, 2),
    AERODACTYL(142, "Aerodactyl", 80, 105, 65, 130, 60, 60, 202, 4),
    SNORLAX(143, "Snorlax", 160, 110, 65, 30, 65, 65, 154, 4),
    ARTICUNO(144, "Articuno", 90, 85, 100, 85, 125, 125, 215, 4),
    ZAPDOS(145, "Zapdos", 90, 90, 85, 100, 125, 125, 216, 4),
    MOLTRES(146, "Moltres", 90, 100, 90, 90, 125, 125, 217, 4),
    DRATINI(147, "Dratini", 41, 64, 45, 50, 50, 50, 67, 4),
    DRAGONAIR(148, "Dragonair", 61, 84, 65, 70, 70, 70, 144, 4),
    DRAGONITE(149, "Dragonite", 91, 134, 95, 80, 100, 100, 218, 4),
    MEWTWO(150, "Mewtwo", 106, 110, 90, 130, 154, 154, 220, 4),
    MEW(151, "Mew", 100, 100, 100, 100, 100, 100, 64, 1);


    public final int HP, attack,defense,special,speed,pokemonNumber,expYield,expSpeed;
    public final String nameOfPokemon;
    
    PokemonBaseStats(int pokemonNumber, String nameOfPokemon,int HP, int attack, int defense, int speed, int specialAttack, int specialDefence, int expYield,int expSpeed) {
        this.attack = attack;
        this.defense = defense;
        this.HP = HP;
        this.special = specialAttack;
        this.speed = speed;
        this.pokemonNumber = pokemonNumber;
        this.expYield = expYield;
        this.expSpeed = expSpeed;
        //expSpeed =speedType(1 - Medium Slow, 2-Medium Fast, 3 - Fast, 4 - Slow)
        this.nameOfPokemon=nameOfPokemon;
    }
    
    
    
}
