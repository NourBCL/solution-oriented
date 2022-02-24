<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220219223037 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE commande_t (id INT AUTO_INCREMENT NOT NULL, date_creation DATETIME NOT NULL, address_destination VARCHAR(255) NOT NULL, PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE transport ADD t_c_id INT NOT NULL');
        $this->addSql('ALTER TABLE transport ADD CONSTRAINT FK_66AB212E2BA1F2A1 FOREIGN KEY (t_c_id) REFERENCES commande_t (id)');
        $this->addSql('CREATE INDEX IDX_66AB212E2BA1F2A1 ON transport (t_c_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE transport DROP FOREIGN KEY FK_66AB212E2BA1F2A1');
        $this->addSql('DROP TABLE commande_t');
        $this->addSql('DROP INDEX IDX_66AB212E2BA1F2A1 ON transport');
        $this->addSql('ALTER TABLE transport DROP t_c_id');
    }
}
