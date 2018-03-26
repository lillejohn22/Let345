README.txt med allmänna kommentarer om lösningen. 
Bifoga även källtextfiler med eventuella komparatorklasser

Uppgift 1. AngloTrainer

Ordlistan läses från en fil till en TreeSet<String> (dictSet) för att ordnas alfabetiskt. 

Listans längsta ord hittas och lika många bokstäver genereras till randomLetters.

Genom att jämföra randomLetters med varje element i dictSet efter att de sorterats i alfabetisk ordning 
läggs alla rätta svar in i en ny TreeSet<String> (apprWordsSet). 
 
En Scanner läser spelarens gissning och om den är korrekt tas ordet bort ur apprWordsSet och spelet fortsätter. 
Annars skrivs apprWordsSet ut och programmet avslutas.  
 
För att fånga ctrl+z används en try/catch sats där "NoSuchElementException" fångas för att 
på så sätt kunna skriva ut de rätta alternativen. 

För att minska antalet try/catch kastas IOException till Main där felmeddelandet skrivs ut. 

Hjälpsamma outputs skrivs ut för att guida spelaren.



Upphift 2.

Alla orden i texten läggs i en osorterad HashMap, unsortedDict, med ordet som nyckel och frekvensen som data. HashMap väljs för det ej behöver vara sorterat 
och både ordet och frekvensen behöver sparas, och dubbletter ska vara möjliga. 

Genom att lopa genom unsortedDict med nyckeln som index räknas antalet gånger varje ord förekommer, vilket görs med computeFrequencyMap.   
 
Första ordlistan kopieras från unsortedDict till en TreeMap<String, Integer> för att bli alfabetiskt ordnad direkt och behålla de frekvenser som finns i unsortedDict.

Andra ordlistan genereras genom att de osorterade orden flippas, läggs till en TreeSet för att sorteras och sedan flippas tillbaks och läggs i en List, backwardsSorted.  
Flippningen sker med reverseAllWords och flippas med Javas standardbibilotek på listor.

Tredje ordlistan bildas utifrån att HashMapen unsortedDict kopieras till en TreeMap som sorteras efter frekvsen med Comparatorn i FreqComparator och därefter i bokstavsordning.
   
FreqComparator sorterar vilken av två Map som har störst frekvesen, (baserat på att frekvesen sparas som data och inte nyckel).

Därefter skrivs allt de tre soterade listorna till varsin fil genom att iterara över datan eller nyckeln. 