<?php

namespace App\Entity;

use App\Repository\CategorieTRepository;
use Doctrine\Common\Collections\ArrayCollection;
use Doctrine\Common\Collections\Collection;
use Doctrine\ORM\Mapping as ORM;

/**
 * @ORM\Entity(repositoryClass=CategorieTRepository::class)
 */
class CategorieT
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
    private $type_transport;

    /**
     * @ORM\Column(type="string", length=255)
     */
    private $image_transport;

    /**
     * @ORM\OneToMany(targetEntity=Transport::class, mappedBy="idCat_t")
     */
    private $transports;

    public function __construct()
    {
        $this->transports = new ArrayCollection();
    }

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getTypeTransport(): ?string
    {
        return $this->type_transport;
    }

    public function setTypeTransport(string $type_transport): self
    {
        $this->type_transport = $type_transport;

        return $this;
    }

    public function getImageTransport(): ?string
    {
        return $this->image_transport;
    }

    public function setImageTransport(string $image_transport): self
    {
        $this->image_transport = $image_transport;

        return $this;
    }

    /**
     * @return Collection|Transport[]
     */
    public function getTransports(): Collection
    {
        return $this->transports;
    }

    public function addTransport(Transport $transport): self
    {
        if (!$this->transports->contains($transport)) {
            $this->transports[] = $transport;
            $transport->setIdCatT($this);
        }

        return $this;
    }

    public function removeTransport(Transport $transport): self
    {
        if ($this->transports->removeElement($transport)) {
            // set the owning side to null (unless already changed)
            if ($transport->getIdCatT() === $this) {
                $transport->setIdCatT(null);
            }
        }

        return $this;
    }
}
