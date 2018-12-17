									Projet Rogue-Like
						Elkael Maxime, Robin Joran, Desquaires Joseph
						
I]Exécution Maven

   Remarque:toutes les commandes sont à effectuer dans le dossier suivant : "projet_rogue/Projet_Rogue/"

	1)Création Du Package Maven
		
		Pour créer le dossier cible (target) de l'application avec Maven,il faut se placer dans le dossier "projet_rogue/Projet_Rogue/"
		puis ouvrir un Terminal à ce niveau et taper la commande suivante : mvn package
		Un dossier "target" contenant tous les fichiers nécessaires pour bien exécuter l'application devrait apparaitre dans le dossier Projet_Rogue
	
	2)Création Du Site Maven
	
		Pour générer le site internet Maven contenant les informations liées au projet,il faut taper la commande suivante dans le Terminal: mvn site
		Allez ensuite dans le dossier target/site/ et ouvrir l'index.
		
	3)Exécution De L'Application
	
		Pour exécuter l'application, il suffit de taper la commande : java -jar target/Projet_Rogue-1.0-SNAPSHOT.jar
		L'application devrait s'exécuter directement dans le Terminal.
		
	4)Nettoyage du dossier target
	
		Il faut exécuter la commande suivante : mvn clean
		Cette commande permet de supprimer le dossier target.
		
II]Manuel Utilisateur

	Voici les différentes actions que l'utilisateur devra effectuer pour le bon déroulement de l'application :

	1)Menu Création Du Personnage
	
		Lors de l'exécution de l'application,la première chose que l'utilisateur devra faire sera de créer son personnage.
		Pour cela,il devra tout d'abord lui affecter un Nom,puis choisir sa classe.
		Il y a deux classes disponibles : ASSASSIN ou CHEVALIER
		Chacune possède des caracteristiques différentes : ASSASSIN a moins de pv et plus de dégats que le CHEVALIER
		Après avoir effectuer son choix,l'utilisateur arrivera sur la première map.
	
	2)Symboles Presents Sur La Map
	
		Voici la représentation des différents éléments présents sur la map :
		
			X:Limites De La Map
			#:Mur De La Map
			@:Personnage
			0:Porte 
			T:Epee
			G:Gobelins
			
	3)Déplacement Du Personnage 
	
		Pour déplacer le Personnage ,l'utilisateur devra taper les commandes suivantes:
		
			Pour se déplacer en haut : go haut
			Pour se déplacer en bas : go bas
			Pour se déplacer à droite : go droite
			Pour se déplacer à gauche : go gauche
	
	4)Ramasser Un Objet
	
		Pour ramasser un objet, l'utilisateur doit déplacer le Personnage jusqu'à la case où se trouve l'objet.
		Une fois le symbole Du Personnage sur la case de l'objet,un message devrait apparaître concernant les bonus 
		obtenus par le personnage (augmentation de dégats etc...)
		Par Exemple,Le fait de ramasser une épée aura pour objectif d'augmenter les dégâts du Personnage.
		
	5)Passer Une Porte et arriver dans un autre monde
	
		Pour passer une porte,il suffit de tuer tous les monstres présents sur la map ce qui aura pour effet de débloquer la porte.
		Cependant,lors du premier niveau, l'utilisateur peut passer directement la porte car aucun ennemis est présent.
		
	6)Attaquer Les Monstres
	
		Pour attaquer les monstres,l'utilisateur devra positionner le personnage à côté d'un monstre et taper les commandes suivantes selon
		où le monstre est positionné :
		
			Le monstre est au-dessus du Personnage: atk haut
			Le monstre est en-dessous du Personnage: atk bas
			Le monstre est à droite du Personnage: atk droite
			Le monstre est à gauche du Personnage: atk gauche
			
		Lors d'une attaque ,les monstres vont perdre des points de vies équivalents à la puissance de l'attaque du joueur.
	
	7)Les Niveaux Du Jeu
	
		Le Jeu possède différents niveaux.Pour accéder au niveau supérieur,il suffit que l'utilisateur tue tous les monstres
		et passe la porte du niveau où il se situe.
		Chaque niveau est plus dur que les précédents ,c'est à dire qu'il y a plus de monstre ,plus fort et une map plus grande.
		
	8)Sauvegarder Une Partie
	
		Pour sauvegarder une partie, l'utilisateur devra taper la commande suivante : save
		Celle-ci dirigera le joueur vers un menu lui disant de choisir le nom du fichier pour sa sauvegarde.
	
	9)Charger Une Partie
	
		Pour charger une partie,il faut que l'utilisateur arrive jusqu'à l'étape de la génération de la première map et il
		doit ensuite taper la commande suivante: load 
		Celle-ci dirigera l'utilisateur sur le menu de chargement qui lui proposera de taper le numéro de sa sauvegarde.
		

III]Manuel Technique

	Pour cela,il faut consulter la JavaDoc de l'application.
	L'utilisateur doit se mettre dans le dossier target/apidocs/
	Puis ouvrir index.html
