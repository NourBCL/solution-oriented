<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220220121102 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE commande_e (id INT AUTO_INCREMENT NOT NULL, date_creation DATETIME NOT NULL, address_destination VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE commande_m (id INT AUTO_INCREMENT NOT NULL, date_creation DATETIME NOT NULL, address_destination VARCHAR(255) NOT NULL, total DOUBLE PRECISION NOT NULL, quantite INT NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE evenement ADD e_c_id INT NOT NULL');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681EE32B239F FOREIGN KEY (e_c_id) REFERENCES commande_e (id)');
        $this->addSql('CREATE INDEX IDX_B26681EE32B239F ON evenement (e_c_id)');
        $this->addSql('ALTER TABLE materiel ADD m_c_id INT NOT NULL');
        $this->addSql('ALTER TABLE materiel ADD CONSTRAINT FK_18D2B091F78A1F2 FOREIGN KEY (m_c_id) REFERENCES commande_m (id)');
        $this->addSql('CREATE INDEX IDX_18D2B091F78A1F2 ON materiel (m_c_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681EE32B239F');
        $this->addSql('ALTER TABLE materiel DROP FOREIGN KEY FK_18D2B091F78A1F2');
        $this->addSql('DROP TABLE commande_e');
        $this->addSql('DROP TABLE commande_m');
        $this->addSql('DROP INDEX IDX_B26681EE32B239F ON evenement');
        $this->addSql('ALTER TABLE evenement DROP e_c_id');
        $this->addSql('DROP INDEX IDX_18D2B091F78A1F2 ON materiel');
        $this->addSql('ALTER TABLE materiel DROP m_c_id');
    }
}
