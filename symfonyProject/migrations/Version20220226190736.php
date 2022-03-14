<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220226190736 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commande ADD commande_m_c_id INT DEFAULT NULL, ADD commmande_t_c_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT FK_6EEAA67DD2C5A27 FOREIGN KEY (commande_m_c_id) REFERENCES commande_m (id)');
        $this->addSql('ALTER TABLE commande ADD CONSTRAINT FK_6EEAA67DA68F15FA FOREIGN KEY (commmande_t_c_id) REFERENCES commande_t (id)');
        $this->addSql('CREATE INDEX IDX_6EEAA67DD2C5A27 ON commande (commande_m_c_id)');
        $this->addSql('CREATE INDEX IDX_6EEAA67DA68F15FA ON commande (commmande_t_c_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY FK_6EEAA67DD2C5A27');
        $this->addSql('ALTER TABLE commande DROP FOREIGN KEY FK_6EEAA67DA68F15FA');
        $this->addSql('DROP INDEX IDX_6EEAA67DD2C5A27 ON commande');
        $this->addSql('DROP INDEX IDX_6EEAA67DA68F15FA ON commande');
        $this->addSql('ALTER TABLE commande DROP commande_m_c_id, DROP commmande_t_c_id');
    }
}
