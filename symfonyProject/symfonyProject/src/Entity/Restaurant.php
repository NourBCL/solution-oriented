<?php

namespace App\Entity;

use App\Repository\RestaurantRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=RestaurantRepository::class)
 */
class Restaurant
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=25)
     */
    private $nom_resto;

    /**
     * @ORM\Column(type="bigint")
     */
    private $numTel;

    /**
     * @ORM\Column(type="time")
     */
    private $horraire_ouverture;

    /**
     * @ORM\Column(type="time")
     */
    private $horraire_fermeture;

    /**
     * @ORM\ManyToOne(targetEntity=Region::class, inversedBy="restaurants")
     */
    private $idRegion;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomResto(): ?string
    {
        return $this->nom_resto;
    }

    public function setNomResto(string $nom_resto): self
    {
        $this->nom_resto = $nom_resto;

        return $this;
    }

    public function getNumTel(): ?string
    {
        return $this->numTel;
    }

    public function setNumTel(string $numTel): self
    {
        $this->numTel = $numTel;

        return $this;
    }

    public function getHorraireOuverture(): ?\DateTimeInterface
    {
        return $this->horraire_ouverture;
    }

    public function setHorraireOuverture(\DateTimeInterface $horraire_ouverture): self
    {
        $this->horraire_ouverture = $horraire_ouverture;

        return $this;
    }

    public function getHorraireFermeture(): ?\DateTimeInterface
    {
        return $this->horraire_fermeture;
    }

    public function setHorraireFermeture(\DateTimeInterface $horraire_fermeture): self
    {
        $this->horraire_fermeture = $horraire_fermeture;

        return $this;
    }

    public function getIdRegion(): ?Region
    {
        return $this->idRegion;
    }

    public function setIdRegion(?Region $idRegion): self
    {
        $this->idRegion = $idRegion;

        return $this;
    }
}
