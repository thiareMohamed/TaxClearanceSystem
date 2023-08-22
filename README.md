#Système de Régularisation des Impôts

Ce référentiel contient le code source d'un système de régularisation des impôts, développé à l'aide de Spring Boot pour la création d'une API REST. Ce système permet aux utilisateurs de déclarer leurs impôts, d'effectuer des paiements pour leurs déclarations et de consulter la liste des déclarants, des déclarations et des paiements.

Fonctionnalités

    Ajout de déclarants avec leurs informations (identifiant, raison sociale, adresse, e-mail, téléphone).
    Ajout de déclarations associées à un déclarant avec des informations sur la date et le montant.
    Ajout de paiements liés à une déclaration avec des informations sur la date et le montant.
    Consultation de la liste des déclarants, des déclarations et des paiements.

Technologies Utilisées

    Java
    Spring Boot
    Spring Data JPA
    RESTful API

Comment Utiliser

    Clonez ce référentiel vers votre machine locale :

    git clone https://github.com/thiareMohamed/TaxClearanceSystem.git

    Importez le projet dans votre environnement de développement (Eclipse, IntelliJ, etc.) comme projet Spring Boot.

    Exécutez l'application. Les informations de connexion sont définies dans le fichier src/main/resources/application.properties.

    Utilisez un outil comme Postman pour tester les différentes fonctionnalités de l'API. Les endpoints seront disponibles à l'adresse http://localhost:8080/api.

Endpoints

    POST /api/declarants : Ajouter un nouveau déclarant.
    GET /api/declarants : Récupérer la liste des déclarants.
    POST /api/declarations : Ajouter une nouvelle déclaration pour un déclarant.
    GET /api/declarations : Récupérer la liste des déclarations.
    POST /api/paiements : Ajouter un nouveau paiement pour une déclaration.
    GET /api/paiements : Récupérer la liste des paiements.

Avertissement

Ce projet est destiné à des fins de démonstration et d'apprentissage. Il ne gère pas la sécurité ni les aspects de production. Assurez-vous de prendre en compte les bonnes pratiques de sécurité et d'optimisation si vous envisagez d'utiliser ce code dans un environnement de production.

Contribution

Les contributions sont les bienvenues ! Si vous souhaitez améliorer ce projet, n'hésitez pas à proposer des pull requests.


#THIARE 