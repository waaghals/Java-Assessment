#Futurama Space Explorer
Futurama Space Explorer is een [Dungeon Crawler](http://en.wikipedia.org/wiki/Dungeon_crawl) geschreven voor het Java assessment.
Opdracht was om een tekst gebaseerde Dungeon Crawler te maken.
Hierbij heb ik inspiratie gehaald bij een van mijn favoriete series, Futurama

##Dependencies instaleren

In de folder staan de benodige jar files voor het project.
Het project maatk gebruik van de JUNG library voor het generaren van Graphs.

Deze jar files moeten in de build path worden gezet.
(Project - > Properties -> Java Build Path-> Liberies -> add JARS)

##Bekende bugs

###Opstarten
Soms loop het spel vast met het opstarten.
Ik heb geen idee waar het programma in vast loopt maar ik vermoed met het genereren van de Graph.
Door gewoon het programma op nieuw te starten wordt het probleem verholpen.

###Vechten met the Enemies
Door tijd gebrek heb ik dit niet af kunnen maken.
Dit is nogal slordig, zodra de enemy vecht dan komt de gebruik tekst van het wapen ook in de console te staan.
Teven is de aangebrachte schade nog niet zichtbaar in de console.
Er wordt ook niet mede gedeeld of de tegenstander dood is. (de speler wel, dan is de speler GAME OVER)

##Extra commando's
De volgende commando's staan niet in het HELP commando.
### stats 

> geeft statestieken weer over het gegenereerde level.

### map

> geeft een venster weer met daarin een abstrakte weergave van het huidige level.

### use nibler

> dit is een cheat welke je gelijk het gezochte item (Dark Matter, fuel) geeft. 
