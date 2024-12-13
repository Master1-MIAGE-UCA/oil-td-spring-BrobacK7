
# Application de Lancer de Dés - Spring Boot

## Description

Cette application permet de simuler des lancers de dés et d'enregistrer l'historique des lancers dans une base de données. Elle expose des API REST pour effectuer les lancers et consulter l'historique.

## Fonctionnalités

1. **Lancer un dé (1 seul)**  
   L'utilisateur peut lancer un seul dé et obtenir le résultat (un nombre entre 1 et 6).

2. **Lancer plusieurs dés (X dés)**  
   L'utilisateur peut lancer un nombre spécifique de dés et obtenir les résultats sous forme de liste.

3. **Historique des lancers de dés**  
   L'application enregistre chaque lancer dans la base de données avec les informations suivantes :
  - Le nombre de dés lancés
  - Les résultats des dés
  - Le timestamp du lancer

4. **Affichage de l'historique des lancers**  
   Une API permet de consulter l'historique des lancers de dés effectués.

## Prérequis

- **Java 11 ou supérieur**
- **Maven** ou **Gradle** (pour la gestion des dépendances)
- **Base de données** (H2 en mémoire est utilisé par défaut pour les tests)

## Installation

1. **Cloner le dépôt**

   Clonez le projet sur votre machine locale :

   ```bash
   git clone https://votre-repository.git
   ```

2. **Installer les dépendances**

   Si vous utilisez Maven :
   ```bash
   mvn clean install
   ```

   Si vous utilisez Gradle :
   ```bash
   gradle build
   ```

3. **Configurer la base de données (optionnel)**

   Le projet utilise H2 en mémoire par défaut pour les tests. Si vous souhaitez utiliser une autre base de données, vous devez configurer les paramètres dans le fichier `application.properties` :

   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   ```

   Pour une base de données MySQL ou PostgreSQL, modifiez les configurations en conséquence.

4. **Démarrer l'application**

   Vous pouvez démarrer l'application en exécutant la classe `DiceApplication` qui contient le point d'entrée principal :

   ```bash
   mvn spring-boot:run
   ```

   Ou en utilisant Gradle :

   ```bash
   gradle bootRun
   ```

   L'application sera lancée sur le port `8081`.

## Endpoints API

Voici les endpoints exposés par l'application :

### 1. **Lancer un seul dé**
- **URL** : `/dice/rollDice`
- **Méthode HTTP** : `GET`
- **Réponse** : Une liste contenant un seul nombre entre 1 et 6, représentant le résultat du dé lancé.

Exemple de réponse :
   ```json
   [4]
   ```

### 2. **Lancer plusieurs dés**
- **URL** : `/dice/rollDices/{count}`
- **Méthode HTTP** : `GET`
- **Paramètres** : `count` (nombre de dés à lancer)
- **Réponse** : Une liste des résultats des dés lancés.

Exemple de réponse (lorsque `count=3`) :
   ```json
   [4, 2, 6]
   ```

### 3. **Consulter l'historique des lancers**
- **URL** : `/diceLogs`
- **Méthode HTTP** : `GET`
- **Réponse** : Une liste des historiques de lancers de dés.

Exemple de réponse :
   ```json
   [
     {
       "id": 1,
       "diceCount": 3,
       "results": [4, 2, 6],
       "timestamp": "2024-12-13T12:34:56"
     },
     {
       "id": 2,
       "diceCount": 1,
       "results": [5],
       "timestamp": "2024-12-13T12:35:12"
     }
   ]
   ```

## Tests

Les tests unitaires et d'intégration sont inclus dans le projet. Pour les exécuter, vous pouvez utiliser les commandes suivantes :

- **Maven** :
  ```bash
  mvn test
  ```

- **Gradle** :
  ```bash
  gradle test
  ```

Ces tests vérifient que l'application fonctionne comme prévu, que les lancers de dés sont effectués correctement et que l'historique est bien enregistré dans la base de données.

## Contribuer

1. Forkez ce projet
2. Créez une branche (`git checkout -b feature/nom-de-votre-branche`)
3. Commitez vos modifications (`git commit -am 'Ajoute une nouvelle fonctionnalité'`)
4. Poussez vers votre branche (`git push origin feature/nom-de-votre-branche`)
5. Créez une nouvelle Pull Request

## License

Ce projet est sous licence MIT. Voir le fichier [LICENSE](LICENSE) pour plus de détails.
