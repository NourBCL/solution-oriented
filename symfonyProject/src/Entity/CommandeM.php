<?php

namespace App\Entity;

use App\Repository\CommandeMRepository;
use App\Repository\MaterielRepository;

use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * @ORM\Entity(repositoryClass=CommandeMRepository::class)
 */
class CommandeM
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")

     */
    private $id;

    /**
     * @ORM\Column(type="datetime")
     *
    */
    private $date_creation;

    /**
     * @ORM\Column(type="string", length=50)
     */
    private $address_destination;

    /**
     * @ORM\Column(type="float")
     * @Assert\Positive
     */
    private $total;

    /**
     * @ORM\Column(type="integer")
     * @Assert\GreaterThanOrEqual(0)
     * @Assert\Positive()
     */
    private $quantite;

    /**
     * @ORM\OneToMany(targetEntity=Materiel::class, mappedBy="m_c")
     */
    private $id_m;

    public function __construct()
    {
        $this->id_m = new ArrayCollection();
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

    public function getAddressDestination(): ?string
    {
        return $this->address_destination;
    }


    public function setAddressDestination(string $address_destination): self
    {
        $this->address_destination = $address_destination;

        return $this;
    }

    public function getTotal(): ?float
    {
        return $this->total;
    }

    public function setTotal(float $total): self
    {
        $this->total =$total;

        return $this;
    }

    public function getQuantite(): ?int
    {
        return $this->quantite;
    }

    public function setQuantite(int $quantite): self
    {
        $this->quantite = $quantite;

            return $this;

    }
    /**
     * @return Collection|Materiel[]
     */
    public function getIdM(): Collection
    {
        return $this->id_m;
    }

    public function addIdM(Materiel $idM): self
    {
        if (!$this->id_m->contains($idM)) {
            $this->id_m[] = $idM;
            $idM->setMC($this);
        }

        return $this;
    }

    public function removeIdM(Materiel $idM): self
    {
        if ($this->id_m->removeElement($idM)) {
            // set the owning side to null (unless already changed)
            if ($idM->getMC() === $this) {
                $idM->setMC(null);
            }
        }

        return $this;
    }
   /* public function get_price(MaterielRepository $mr)
    { $materiel =$mr ->findOneBy('id');

        return $this->$materiel.getPrixM() ;
    }*/
}
