<?php

namespace App\Entity;

use App\Repository\CommandeRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CommandeRepository::class)
 */
class Commande
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="datetime")
     */
    private $date_commande;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $adresse_destination;

    /**
     * @ORM\ManyToMany(targetEntity=Article::class, inversedBy="commandes")
     */
    private $idArticle;

    public function __construct()
    {
        $this->idArticle = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDateCommande(): ?\DateTimeInterface
    {
        return $this->date_commande;
    }

    public function setDateCommande(\DateTimeInterface $date_commande): self
    {
        $this->date_commande = $date_commande;

        return $this;
    }

    public function getAdresseDestination(): ?string
    {
        return $this->adresse_destination;
    }

    public function setAdresseDestination(string $adresse_destination): self
    {
        $this->adresse_destination = $adresse_destination;

        return $this;
    }

    /**
     * @return Collection|Article[]
     */
    public function getIdArticle(): Collection
    {
        return $this->idArticle;
    }

    public function addIdArticle(Article $idArticle): self
    {
        if (!$this->idArticle->contains($idArticle)) {
            $this->idArticle[] = $idArticle;
        }

        return $this;
    }

    public function removeIdArticle(Article $idArticle): self
    {
        $this->idArticle->removeElement($idArticle);

        return $this;
    }
}
