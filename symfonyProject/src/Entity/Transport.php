<?php

namespace App\Entity;

use App\Repository\TransportRepository;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=TransportRepository::class)
 */
class Transport
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
    private $lieu_depart;

    /**
     * @ORM\Column(type="string", length=25)
     */
    private $lieu_arrivee;

    /**
     * @ORM\Column(type="date")
     */
    private $date_dep;

    /**
     * @ORM\Column(type="date")
     */
    private $date_arrivee;

    /**
     * @ORM\Column(type="time")
     */
    private $heure_arrivee;

    /**
     * @ORM\Column(type="time")
     */
    private $heure_depart;

    /**
     * @ORM\Column(type="date")
     */
    private $date_retour;

    /**
     * @ORM\Column(type="time")
     */
    private $heure_retour;

    /**
     * @ORM\Column(type="integer")
     */
    private $nb_place;

    /**
     * @ORM\Column(type="integer")
     */
    private $nb_bagage;

    /**
     * @ORM\Column(type="float")
     */
    private $prix_t;

    /**
     * @ORM\Column(type="boolean")
     */
    private $disponibilite;

    /**
     * @ORM\ManyToOne(targetEntity=CategorieT::class, inversedBy="transports")
     */
    private $idCat_t;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getLieuDepart(): ?string
    {
        return $this->lieu_depart;
    }

    public function setLieuDepart(string $lieu_depart): self
    {
        $this->lieu_depart = $lieu_depart;

        return $this;
    }

    public function getLieuArrivee(): ?string
    {
        return $this->lieu_arrivee;
    }

    public function setLieuArrivee(string $lieu_arrivee): self
    {
        $this->lieu_arrivee = $lieu_arrivee;

        return $this;
    }

    public function getDateDep(): ?\DateTimeInterface
    {
        return $this->date_dep;
    }

    public function setDateDep(\DateTimeInterface $date_dep): self
    {
        $this->date_dep = $date_dep;

        return $this;
    }

    public function getDateArrivee(): ?\DateTimeInterface
    {
        return $this->date_arrivee;
    }

    public function setDateArrivee(\DateTimeInterface $date_arrivee): self
    {
        $this->date_arrivee = $date_arrivee;

        return $this;
    }

    public function getHeureArrivee(): ?\DateTimeInterface
    {
        return $this->heure_arrivee;
    }

    public function setHeureArrivee(\DateTimeInterface $heure_arrivee): self
    {
        $this->heure_arrivee = $heure_arrivee;

        return $this;
    }

    public function getHeureDepart(): ?\DateTimeInterface
    {
        return $this->heure_depart;
    }

    public function setHeureDepart(\DateTimeInterface $heure_depart): self
    {
        $this->heure_depart = $heure_depart;

        return $this;
    }

    public function getDateRetour(): ?\DateTimeInterface
    {
        return $this->date_retour;
    }

    public function setDateRetour(\DateTimeInterface $date_retour): self
    {
        $this->date_retour = $date_retour;

        return $this;
    }

    public function getHeureRetour(): ?\DateTimeInterface
    {
        return $this->heure_retour;
    }

    public function setHeureRetour(\DateTimeInterface $heure_retour): self
    {
        $this->heure_retour = $heure_retour;

        return $this;
    }

    public function getNbPlace(): ?int
    {
        return $this->nb_place;
    }

    public function setNbPlace(int $nb_place): self
    {
        $this->nb_place = $nb_place;

        return $this;
    }

    public function getNbBagage(): ?int
    {
        return $this->nb_bagage;
    }

    public function setNbBagage(int $nb_bagage): self
    {
        $this->nb_bagage = $nb_bagage;

        return $this;
    }

    public function getPrixT(): ?float
    {
        return $this->prix_t;
    }

    public function setPrixT(float $prix_t): self
    {
        $this->prix_t = $prix_t;

        return $this;
    }

    public function getDisponibilite(): ?bool
    {
        return $this->disponibilite;
    }

    public function setDisponibilite(bool $disponibilite): self
    {
        $this->disponibilite = $disponibilite;

        return $this;
    }

    public function getIdCatT(): ?CategorieT
    {
        return $this->idCat_t;
    }

    public function setIdCatT(?CategorieT $idCat_t): self
    {
        $this->idCat_t = $idCat_t;

        return $this;
    }
}
