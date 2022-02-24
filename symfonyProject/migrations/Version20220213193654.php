<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220213193654 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE article (id INT AUTO_INCREMENT NOT NULL, date_creation DATETIME NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE categorie_e (id INT AUTO_INCREMENT NOT NULL, nom_cat_e VARCHAR(25) NOT NULL, image_e VARCHAR(255) NOT NULL, description LONGTEXT NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE categorie_m (id INT AUTO_INCREMENT NOT NULL, nom_cat_m VARCHAR(25) NOT NULL, icon VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE categorie_t (id INT AUTO_INCREMENT NOT NULL, type_transport VARCHAR(25) NOT NULL, image_transport VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE commande (id INT AUTO_INCREMENT NOT NULL, date_commande DATETIME NOT NULL, adresse_destination VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE commande_article (commande_id INT NOT NULL, article_id INT NOT NULL,INDEX IDX_F4817CC682EA2E54 (commande_id), INDEX IDX_F4817CC67294869C (article_id), PRIMARY KEY(commande_id, article_id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE evenement (id INT AUTO_INCREMENT NOT NULL, id_cat_e_id INT DEFAULT NULL, nom_e VARCHAR(25) NOT NULL, date_deb DATE NOT NULL, date_fin DATE NOT NULL, image_e VARCHAR(255) NOT NULL, description LONGTEXT NOT NULL, prix_e DOUBLE PRECISION NOT NULL, INDEX IDX_B26681EF954DF2B (id_cat_e_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE materiel (id INT AUTO_INCREMENT NOT NULL, id_cat_m_id INT DEFAULT NULL, prix_m DOUBLE PRECISION NOT NULL, description LONGTEXT NOT NULL, etat VARCHAR(25) NOT NULL, nom_materiel VARCHAR(25) NOT NULL, dispo TINYINT(1) NOT NULL, image_m VARCHAR(255) NOT NULL, INDEX IDX_18D2B0913CE0F7C4 (id_cat_m_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE region (id INT AUTO_INCREMENT NOT NULL, ville VARCHAR(25) NOT NULL, rue VARCHAR(25) NOT NULL, code_postal BIGINT NOT NULL, gouvernerat VARCHAR(25) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE restaurant (id INT AUTO_INCREMENT NOT NULL, id_region_id INT DEFAULT NULL, nom_resto VARCHAR(25) NOT NULL, num_tel BIGINT NOT NULL, horraire_ouverture TIME NOT NULL, horraire_fermeture TIME NOT NULL, INDEX IDX_EB95123F1813BD72 (id_region_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE transport (id INT AUTO_INCREMENT NOT NULL, id_cat_t_id INT DEFAULT NULL, lieu_depart VARCHAR(25) NOT NULL, lieu_arrivee VARCHAR(25) NOT NULL, date_dep DATE NOT NULL, date_arrivee DATE NOT NULL, heure_arrivee TIME NOT NULL, heure_depart TIME NOT NULL, date_retour DATE NOT NULL, heure_retour TIME NOT NULL, nb_place INT NOT NULL, nb_bagage INT NOT NULL, prix_t DOUBLE PRECISION NOT NULL, disponibilite TINYINT(1) NOT NULL, INDEX IDX_66AB212E11F1EFD1 (id_cat_t_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE commande_article ADD CONSTRAINT FK_F4817CC682EA2E54 FOREIGN KEY (commande_id) REFERENCES commande (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE commande_article ADD CONSTRAINT FK_F4817CC67294869C FOREIGN KEY (article_id) REFERENCES article (id) ON DELETE CASCADE');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681EF954DF2B FOREIGN KEY (id_cat_e_id) REFERENCES categorie_e (id)');
        $this->addSql('ALTER TABLE materiel ADD CONSTRAINT FK_18D2B0913CE0F7C4 FOREIGN KEY (id_cat_m_id) REFERENCES categorie_m (id)');
        $this->addSql('ALTER TABLE restaurant ADD CONSTRAINT FK_EB95123F1813BD72 FOREIGN KEY (id_region_id) REFERENCES region (id)');
        $this->addSql('ALTER TABLE transport ADD CONSTRAINT FK_66AB212E11F1EFD1 FOREIGN KEY (id_cat_t_id) REFERENCES categorie_t (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commande_article DROP FOREIGN KEY FK_F4817CC67294869C');
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681EF954DF2B');
        $this->addSql('ALTER TABLE materiel DROP FOREIGN KEY FK_18D2B0913CE0F7C4');
        $this->addSql('ALTER TABLE transport DROP FOREIGN KEY FK_66AB212E11F1EFD1');
        $this->addSql('ALTER TABLE commande_article DROP FOREIGN KEY FK_F4817CC682EA2E54');
        $this->addSql('ALTER TABLE restaurant DROP FOREIGN KEY FK_EB95123F1813BD72');
        $this->addSql('DROP TABLE article');
        $this->addSql('DROP TABLE categorie_e');
        $this->addSql('DROP TABLE categorie_m');
        $this->addSql('DROP TABLE categorie_t');
        $this->addSql('DROP TABLE commande');
        $this->addSql('DROP TABLE commande_article');
        $this->addSql('DROP TABLE evenement');
        $this->addSql('DROP TABLE materiel');
        $this->addSql('DROP TABLE region');
        $this->addSql('DROP TABLE restaurant');
        $this->addSql('DROP TABLE transport');
    }
}
