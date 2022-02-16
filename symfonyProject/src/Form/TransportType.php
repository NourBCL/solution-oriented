<?php

namespace App\Form;

use App\Entity\Transport;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;

class TransportType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('lieu_depart', null, ['label' => false])
            ->add('lieu_arrivee',null, ['label' => false])
            ->add('date_dep')
            ->add('date_arrivee')
            ->add('heure_arrivee')
            ->add('heure_depart')
            ->add('date_retour')
            ->add('heure_retour')
            ->add('nb_place',null, ['label' => false])
            ->add('nb_bagage')
            ->add('prix_t',null, ['label' => false])
            ->add('disponibilite',null, ['label' => false])
           // ->add('idCat_t',null, ['label' => false])
            //->add('save',SubmitType::class)

        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Transport::class,
        ]);
    }
}
