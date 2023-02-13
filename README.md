# TP-Inversion-de-Contr-le


## Partie 1 :
  1. Créer l'interface IDao avec une méthode getDate
  2. Créer une implémentation de cette interface 
  3. Créer l'interface IMetier avec une méthode calcul
  4. Créer une implémentation de cette interface en utilisant le couplage faible
  5. Faire l'injection des dépendances :
    a. Par instanciation statique
    b. Par instanciation dynamique
    c. En utilisant le Framework Spring
        - Version XML
        - Version annotations
## Partie 2 : Mini Projet (Framework Injection des dépendance)
Développer un mini Framework qui permet de faire l'injection des dépendances avec ses deux version XML et Annotations
Concevoir et créer un mini Framework d'injection des dépendances similaire à Spring IOC
Le Framework doit permettre à un programmeur de faire l'injection des dépendances entre les différents composant de son application respectant les possibilités suivantes : 
  1- A travers un fichier XML de configuration en utilisant Jax Binding (OXM : Mapping Objet XML)
  2- En utilisant les annotations
  3- Possibilité d'injection via :
      a- Le constructeur
      b- Le Setter
      c- Attribut (accès direct à l'attribut : Field)
