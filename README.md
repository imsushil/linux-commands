# Linux Commands

A java console application that imitates some of the linux commands. It supports both relative and absolute path.

1. **ls** : This command lists all the directories present in the current working directory.

2. **pwd** : It prints the current working directory.

3. **mkdir** : It creates a new directory in the provided path.
    - **Syntax**: mkdir /path/to/directory

4. **rm** : It deletes the specified directory if present.
    - **Syntax**: rm /path/to/directory
  
5. **cd** : This command is used to change the current working directory.

## SAMPLE IO

``````````
Starting application...
$>mkdir sushil
SUCC: sushil CREATED.
$>cd /java
ERR: DIRECTORY: java DOES NOT EXIST UNDER DIR: /
$>mkdir sushil/cpp
SUCC: cpp CREATED.
$>ls
DIRS: sushil
$>pwd
PATH: /
$>cd ./sushil
SUCC: REACHED.
$>pwd
PATH: /sushil
$>cd /
SUCC: REACHED.
$>pwd
PATH: /
$>cd ..
SUCC: REACHED.
$>cd ./../..
SUCC: REACHED.
$>pwd
PATH: /
$>cd ...
ERR: DIRECTORY: ... DOES NOT EXIST UNDER DIRECTORY: /
$>cd ./sushil/java
ERR: DIRECTORY: java DOES NOT EXIST UNDER DIRECTORY: sushil
$>ls
DIRS: cpp
$>rm ./sushil/cpp
ERR: DIRECTORY: sushil DOES NOT EXIST
$>pwd
PATH: /sushil
$>cd /
SUCC: REACHED.
$>rm ./sushil/cpp
SUCC: cpp DELETED
$>pwd
PATH: /
$>ls
DIRS: sushil
$>cd sushil
SUCC: REACHED.
$>rm /sushil
ERR: CANNOT DELETE DIRECTORY. EITHER IT IS THE PRESENT WORKING DIRECTORY OR PARENT 
OF THE PRESENT WORKING DIRECTORY
$>
``````````
