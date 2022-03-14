<?php

namespace App\Entity;

use App\Repository\MaterielRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=MaterielRepository::class)
 */
class Materiel
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="float")
     */
    private $prix_m;

    /**
     * @ORM\Column(type="text")
     */
    private $description;

    /**
     * @ORM\Column(type="string", length=25)
     */
    private $etat;

    /**
     * @ORM\Column(type="string", length=25)
     */
    private $nom_materiel;

    /**
     * @ORM\Column(type="boolean")
     */
    private $dispo;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $image_m;

    /**
     * @ORM\ManyToOne(targetEntity=CategorieM::class, inversedBy="materiels")
     */
    private $idCat_m;

    /**
     * @ORM\ManyToOne(targetEntity=CommandeM::class, inversedBy="id_m")
     * @ORM\JoinColumn(nullable=false)
     */
    private $m_c;


    public function getId(): ?int
    {
        return $this->id;
    }

    public function getPrixM(): ?float
    {
        return $this->prix_m;
    }

    public function setPrixM(float $prix_m): self
    {
        $this->prix_m = $prix_m;

        return $this;
    }

    public function getDescription(): ?string
    {
        return $this->description;
    }

    public function setDescription(string $description): self
    {
        $this->description = $description;

        return $this;
    }

    public function getEtat(): ?string
    {
        return $this->etat;
    }

    public function setEtat(string $etat): self
    {
        $this->etat = $etat;

        return $this;
    }

    public function getNomMateriel(): ?string
    {
        return $this->nom_materiel;
    }

    public function setNomMateriel(string $nom_materiel): self
    {
        $this->nom_materiel = $nom_materiel;

        return $this;
    }

    public function getDispo(): ?bool
    {
        return $this->dispo;
    }

    public function setDispo(bool $dispo): self
    {
        $this->dispo = $dispo;

        return $this;
    }

    public function getImageM(): ?string
    {
        return $this->image_m;
    }

    public function setImageM(string $image_m): self
    {
        $this->image_m = $image_m;

        return $this;
    }

    public function getIdCatM(): ?CategorieM
    {
        return $this->idCat_m;
    }

    public function setIdCatM(?CategorieM $idCat_m): self
    {
        $this->idCat_m = $idCat_m;

        return $this;
    }

    public function getIdM(): ?CommandeM
    {
        return $this->id_m;
    }

    public function setIdM(?CommandeM $id_m): self
    {
        $this->id_m = $id_m;

        return $this;
    }

    public function getMC(): ?CommandeM
    {
        return $this->m_c;
    }

    public function setMC(?CommandeM $m_c): self
    {
        $this->m_c = $m_c;

        return $this;
    }
}
