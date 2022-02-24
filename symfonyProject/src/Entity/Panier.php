<?php

namespace App\Entity;

use App\Repository\PanierRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=PanierRepository::class)
 */
class Panier
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="array")
     */
    private $list_article = [];

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getListArticle(): ?array
    {
        return $this->list_article;
    }

    public function setListArticle(array $list_article): self
    {
        $this->list_article = $list_article;

        return $this;
    }
}
