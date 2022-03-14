<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220226111602 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commande ADD commande_e_c_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT FK_6EEAA67DE17FD84A FOREIGN KEY (commande_e_c_id) REFERENCES commande_e (id)');
        $this->addSql('CREATE INDEX IDX_6EEAA67DE17FD84A ON commande (commande_e_c_id)');
        $this->addSql('ALTER TABLE commande_e CHANGE address_destination address_destination VARCHAR(50) NOT NULL');
        $this->addSql('ALTER TABLE commande_m CHANGE address_destination address_destination VARCHAR(50) NOT NULL');
        $this->addSql('ALTER TABLE commande_t CHANGE address_destination address_destination VARCHAR(50) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY FK_6EEAA67DE17FD84A');
        $this->addSql('DROP INDEX IDX_6EEAA67DE17FD84A ON commande');
        $this->addSql('ALTER TABLE commande DROP commande_e_c_id');
        $this->addSql('ALTER TABLE commande_e CHANGE address_destination address_destination VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_unicode_ci`');
        $this->addSql('ALTER TABLE commande_m CHANGE address_destination address_destination VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_unicode_ci`');
        $this->addSql('ALTER TABLE commande_t CHANGE address_destination address_destination VARCHAR(255) CHARACTER SET utf8mb4 NOT NULL COLLATE `utf8mb4_unicode_ci`');
    }
}
