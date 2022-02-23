<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220219153451 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE transport DROP FOREIGN KEY FK_66AB212E2B3073A2');
        $this->addSql('DROP INDEX IDX_66AB212E2B3073A2 ON transport');
        $this->addSql('ALTER TABLE transport CHANGE id_cat_t_id categorie_t_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE transport ADD CONSTRAINT FK_66AB212E2B3073A2 FOREIGN KEY (categorie_t_id) REFERENCES categorie_t (id)');
        $this->addSql('CREATE INDEX IDX_66AB212E2B3073A2 ON transport (categorie_t_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE transport DROP FOREIGN KEY FK_66AB212E2B3073A2');
        $this->addSql('DROP INDEX IDX_66AB212E2B3073A2 ON transport');
        $this->addSql('ALTER TABLE transport CHANGE categorie_t_id id_cat_t_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE transport ADD CONSTRAINT FK_66AB212E2B3073A2 FOREIGN KEY (id_cat_t_id) REFERENCES categorie_t (id)');
        $this->addSql('CREATE INDEX IDX_66AB212E2B3073A2 ON transport (id_cat_t_id)');
    }
}
