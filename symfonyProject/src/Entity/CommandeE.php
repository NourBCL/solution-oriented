<?php

namespace App\Entity;

use App\Repository\CommandeERepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;

/**
 * @ORM\Entity(repositoryClass=CommandeERepository::class)
 */
class CommandeE
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
    private $date_creation;

    /**
     * @ORM\OneToMany(targetEntity=Evenement::class, mappedBy="e_c")
     */
    private $id_e;

    /**
     * @ORM\Column(type="string", length=50)
     * @Assert\NotBlank
     */
    private $address_destination;

    public function __construct()
    {
        $this->id_e = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDateCreation(): ?\DateTimeInterface
    {
        return $this->date_creation;
    }

    public function setDateCreation(\DateTimeInterface $date_creation): self
    {
        $this->date_creation = $date_creation;

        return $this;
    }

    /**
     * @return Collection|Evenement[]
     */
    public function getIdE(): Collection
    {
        return $this->id_e;
    }

    public function addIdE(Evenement $idE): self
    {
        if (!$this->id_e->contains($idE)) {
            $this->id_e[] = $idE;
            $idE->setEC($this);
        }

        return $this;
    }

    public function removeIdE(Evenement $idE): self
    {
        if ($this->id_e->removeElement($idE)) {
            // set the owning side to null (unless already changed)
            if ($idE->getEC() === $this) {
                $idE->setEC(null);
            }
        }

        return $this;
    }

    public function getAddressDestination(): ?string
    {
        return $this->address_destination;
    }

    public function setAddressDestination(string $address_destination): self
    {
        $this->address_destination = $address_destination;

        return $this;
    }
}
