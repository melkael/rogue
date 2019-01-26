# Projet Rogue-Like
##### Elkael Maxime, Robin Joran, Desquaires Joseph
## I] Exécution Maven

Remarque:toutes les commandes sont à effectuer dans le dossier suivant : "projet_rogue/Projet_Rogue/"

### 1) Création Du Package Maven

Pour créer le dossier cible (target) de l'application avec Maven,il faut se placer dans le dossier "projet_rogue/Projet_Rogue/" puis ouvrir un Terminal à ce niveau et taper la commande suivante : mvn package

Un dossier "target" contenant tous les fichiers nécessaires pour bien exécuter l'application devrait apparaitre dans le dossier Projet_Rogue

### 2) Création Du Site Maven et Checkstyle

* Pour générer le site internet Maven contenant les informations liées au projet,il faut taper la commande suivante dans le * Terminal: mvn site
* Allez ensuite dans le dossier target/site/ et ouvrir l'index.
* Cette commande permet aussi de générer les résultats de checkstyle

### 3) Exécution De L'Application

Pour exécuter l'application, il suffit de taper la commande : java -jar target/Projet_Rogue-1.0-SNAPSHOT.jar
L'application devrait s'exécuter directement dans le Terminal.

### 4) Nettoyage du dossier target

Il faut exécuter la commande suivante : mvn clean
Cette commande permet de supprimer le dossier target.
    
## II] Manuel Utilisateur

Voici les différentes actions que l'utilisateur devra effectuer pour le bon déroulement de l'application :
### 0) Bug Potentiel

Si l'affichage est décallé, il faut changer la police de votre terminal, essayez Roboto, chez moi elle fonctionne parfaitement

### 1) Menu De Démarrage De L'Application

* L'utilisateur arrive sur le menu de démarrage.
* Il a la possibilité de taper "N" pour commencer une partie ou de taper "C" pour charger une partie.
* Taper N menera a la partie 2).
* Taper C proposera a l'utilisateur de charger une partie parmi une liste de sauvegarde.Chaque fichier comporte un numéro,il suffit de taper le numéro correspondant a la partie sauvegardé souhaité pour la charger.

### 2) Menu Création Du Personnage

Lors de l'exécution de l'application,la première chose que l'utilisateur devra faire sera de créer son personnage.
Pour cela,il devra tout d'abord lui affecter un Nom,puis choisir sa classe.
Il y a deux classes disponibles : ASSASSIN ou CHEVALIER
Chacune possède des caracteristiques différentes : ASSASSIN a moins de pv et plus de dégats que le CHEVALIER
Après avoir effectuer son choix,l'utilisateur arrivera sur la première map.

### 3) Symboles Presents Sur La Map

Voici la représentation des différents éléments présents sur la map :

* .:Limites De La Map
* 🕯️:Mur De La Map
* 💂:Personnage
* 🚪:Porte 
* 🗡️:Epee
* 👻:Gobelins

### 4) Déplacement Du Personnage

Pour déplacer le Personnage, l'utilisateur devra taper les commandes suivantes:

* Pour se déplacer en haut : go haut
* Pour se déplacer en bas : go bas
* Pour se déplacer à droite : go droite
* Pour se déplacer à gauche : go gauche

### 5) Ramasser Un Objet

Pour ramasser un objet, l'utilisateur doit déplacer le Personnage jusqu'à la case où se trouve l'objet.
Une fois le symbole Du Personnage sur la case de l'objet,un message devrait apparaître concernant les bonus obtenus par le personnage (augmentation de dégats etc...)
Par Exemple,Le fait de ramasser une épée aura pour objectif d'augmenter les dégâts du Personnage.

### 6) Passer Une Porte et arriver dans un autre monde

Pour passer une porte,il suffit de tuer tous les monstres présents sur la map ce qui aura pour effet de débloquer la porte.
Cependant,lors du premier niveau, l'utilisateur peut passer directement la porte car aucun ennemis est présent.

### 7) Attaquer Les Monstres

Pour attaquer les monstres,l'utilisateur devra positionner le personnage à côté d'un monstre et taper les commandes suivantes selon la position du monstre :

* Le monstre est au-dessus du Personnage: atk haut
* Le monstre est en-dessous du Personnage: atk bas
* Le monstre est à droite du Personnage: atk droite
* Le monstre est à gauche du Personnage: atk gauche

Lors d'une attaque ,les monstres vont perdre des points de vie équivalents à la puissance de l'attaque du joueur.

### 8) Lancer Des Sorts

Pour lancer des sorts,l'utilisateur peut taper les commandes suivantes :

* cataclysm:pour toucher tous les ennemis présents sur le terrain
* soin:pour se soigner

### 9) Les Niveaux Du Jeu

Le Jeu possède différents niveaux.Pour accéder au niveau supérieur,il suffit que l'utilisateur tue tous les monstres et passe la porte du niveau où il se situe.
Chaque niveau est plus dur que les précédents ,c'est à dire qu'il y a plus de monstre ,plus fort et une map plus grande.

### 10) Sauvegarder Une Partie

Pour sauvegarder une partie, l'utilisateur devra taper la commande suivante : save
Celle-ci dirigera le joueur vers un menu lui disant de choisir le nom du fichier pour sa sauvegarde.
    
## III] Manuel Technique

Consulter la JavaDoc de l'application.
L'utilisateur doit se mettre dans le dossier target/apidocs/
Puis ouvrir index.html.
Le détail de chaque méthode de chaque classe et le détail des classes seront présentes .
