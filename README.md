# time_collision
Java textual turn based game that demonstrates CRUD OOP

#Project details
-----------------

1. Textual turn based game
2. Create realms, citizens and buildings
3. Assign citizens occupations
4. Assign citizens to army
5. If there is an army go on conquest
6. Reduce other realms population to zero through battle

#Game start
-----------------

1. Two players required to enter their names
2. Each player then...
3. Either chooses from a pre made realm or create own realm
4. If pre made realm is chosen it is removed from list before second player chooses their realm
5. If create realm is chosen....
6. Firstly select between two types. (Germanic or Roman)
7. Give the realm a name
8. Creation of 4 citizens is then required
9. The game starts with the two players' realms plus two premade realms for a total of four reamls

#Citizen creation
-----------------

1. The first citizen created is the ruler of the realm
2. Give your citizen a name
3. Assign a gender

#Gameplay
-----------------

1. Various turn options to choose from
2. Enter the corresponding number to choose one of the selections
3. CRUD operations on differing menu selections
4. Some choices are turn ending while others are not
5. Viewing your realms options are not turn ending
6. Conscripting a citizen to the army is turn ending 
7. The goal is to reduce the other realms populations to zero

#Battle
-----------------

1. In order to go to battle a check is made if that player has conscripted a citizen into the army
2. Combat uses modulus to determine hand to hand combat between to participants
3. When a player chooses to go to battle vs another realm a check is made if that realm has a standing army
4. If there is a standing army in the defending realm then those soldiers fight first
5. If there is no army or if the defending soldiers are defeated then the citizens have to defend the realm
6. Rulers and soldiers have a higher chance if success fighting vs citizens
7. The battle will continue until either the attacking army size is zero or the defending realm has a population of zero
