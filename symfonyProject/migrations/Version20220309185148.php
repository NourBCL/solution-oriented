<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220309185148 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681E9777D11E');
        $this->addSql('ALTER TABLE evenement ADD rating INT DEFAULT NULL, CHANGE category_id_id category_id_id INT NOT NULL');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681E9777D11E FOREIGN KEY (category_id_id) REFERENCES categorie_e (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE evenement DROP FOREIGN KEY FK_B26681E9777D11E');
        $this->addSql('ALTER TABLE evenement DROP rating, CHANGE category_id_id category_id_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE evenement ADD CONSTRAINT FK_B26681E9777D11E FOREIGN KEY (category_id_id) REFERENCES categorie_e (id) ON DELETE CASCADE');
    }
}
