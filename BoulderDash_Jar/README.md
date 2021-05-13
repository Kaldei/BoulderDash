<h1 align="center">🕹️</br>BoulderDash</h1>
<p align="center">
  Game Documentation
</p>


---
## Gameplay
You controls Rockford and your goal is to collect at least 12 diamonds to unlock the exit door and then reach that door to win. The diamond counter is in the window title (at the top).

There are diamonds spread over the map but you can get even more by killing monster. To do this, you have to drop or push a boulder on their heads. They will drop diamonds according to the available space.

But be careful with these monsters: if they reach you, you lose.

</br>
<p align="center">
  <img src="https://i.ibb.co/G3RY3xN/Boulder-Dash.png" alt="Game Visual" width="400">
</p>


---
## Create your own maps 
### Rules
You can create your own map by editing the `map.txt` file. But there are few rules to respect:
* The first two lines of the file have to be respectively width and height of the map (in number of characters).
* Player will always start at the position (1;1), so set a Ground or a Background there.
* Circle you map with Walls. Otherwise, if an element goes out of the map, it will be stuck.
* This not mandatory but try to create a map "winnable": put enough Diamonds (so that the player can get at least 12) and put at least one Exit.

### Available Elements
* ` ` = Ground (Diggable)
* `.` = Background (Walkable)
* `R` = Red Monster (Moves randomly)
* `G` = Green Monster (Moves from right to left and vice versa)
* `O` = Boulder
* `D` = Exit Door
* `*` = Diamond
* `#` = Wall

Note: Any other character will be considered as Background.

### Here is the demo map
```
21
11
#####################
#..O..   O  * *     #
# * O.   O..      O.#
#     O   ..  OO   .#
# .G.   ...R. *O   .#
#################  .#
# ....             .#
# .O   ..O    ..G...#
#   ..R O*  ....**  #
#D **.. O* ..R..**  #
#####################
```


---
## Store your maps in a database
If you want, you can store your maps in a database. Here is the procedure:
* Create a local mySQL database named `boulderdash`.
* Create a `maps` table with columns `id` and `map`.
* Store your maps in map and give them an id.
* Finally the database has to be accessible with the user `root` and no password.

Then launch the game, when the "Do you want to load a map from database?" windows appear, you can select `Yes` and then choose the map you want to load.
