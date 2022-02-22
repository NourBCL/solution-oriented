<?php

namespace App\Form;

use App\Entity\Transport;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class TransportType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('lieu_depart')
            ->add('lieu_arrivee')
            ->add('date_dep')
            ->add('date_arrivee')
            ->add('heure_arrivee')
            ->add('heure_depart')
            ->add('date_retour')
            ->add('heure_retour')
            ->add('nb_place')
            ->add('nb_bagage')
            ->add('prix_t')
            ->add('disponibilite')
            ->add('idCat_t')
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Transport::class,
        ]);
    }
}
