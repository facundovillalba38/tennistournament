# tennistournament

This Java project allow you to simulate Male and Female Tennis Tournament. You have to send a player list to the endpoint and it 
will automatically return the champion of the tournament based on diferent factors like the ability, the strength, speed, reaction and
even the luck. 

In order to test quickly I deployed the API rest in heroku and I implemented SWAGGER to give you a better interface to test it.

https://tenistournament.herokuapp.com/swagger-ui.html

The API is created with two endpoint, one to determine the Male Champion and another to determine the Female Champion.

Male Champion: https://tenistournament.herokuapp.com/api/tournament/male

Body Request:

[
  {
    "ability": 100,
    "name": "Federer",
    "speed": 20,
    "strength": 10
  },
{
    "ability": 40,
    "name": "Nadal",
    "speed": 30,
    "strength": 50
  },
{
    "ability": 45,
    "name": "Nole",
    "speed": 10,
    "strength": 10
  },
{
    "ability": 50,
    "name": "Delpo",
    "speed": 10,
    "strength": 39
  }
]

Female Champion: https://tenistournament.herokuapp.com/api/tournament/female

Body Request:

[
  {
    "ability": 55,
    "name": "Sharapova",
    "reaction": 20
  },
  {
    "ability": 30,
    "name": "Serena",
    "reaction": 13
  },
  {
    "ability": 40,
    "name": "Venus",
    "reaction": 21
  },
  {
    "ability": 70,
    "name": "Fernanda",
    "reaction": 3
  }
]

