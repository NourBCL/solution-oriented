<?php

namespace App\Entity;

use App\Repository\CategorieERepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CategorieERepository::class)
 */
class CategorieE
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="string", length=25)
     *
     */
    private $nomCat_e;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $image_e;

    /**
     * @ORM\Column(type="text")
     */
    private $description;

    /**
     * @ORM\OneToMany(targetEntity=Evenement::class, mappedBy="idCat_e")
     */
    private $evenements;

    public function __construct()
    {
        $this->evenements = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getNomCatE(): ?string
    {
        return $this->nomCat_e;
    }

    public function setNomCatE(string $nomCat_e): self
    {
        $this->nomCat_e = $nomCat_e;

        return $this;
    }

    public function getImageE(): ?string
    {
        return $this->image_e;
    }

    public function setImageE(string $image_e): self
    {
        $this->image_e = $image_e;

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

    /**
     * @return Collection|Evenement[]
     */
    public function getEvenements(): Collection
    {
        return $this->evenements;
    }

    public function addEvenement(Evenement $evenement): self
    {
        if (!$this->evenements->contains($evenement)) {
            $this->evenements[] = $evenement;
            $evenement->setIdCatE($this);
        }

        return $this;
    }

    public function removeEvenement(Evenement $evenement): self
    {
        if ($this->evenements->removeElement($evenement)) {
            // set the owning side to null (unless already changed)
            if ($evenement->getIdCatE() === $this) {
                $evenement->setIdCatE(null);
            }
        }

        return $this;
    }
}
