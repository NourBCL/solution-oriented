<?php

namespace App\Form;

use App\Entity\Article;
use App\Entity\Commande;
use App\Entity\CommandeE;
use App\Entity\CommandeM;
use App\Entity\CommandeT;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\DateTimeType;
use Symfony\Component\Form\Extension\Core\Type\DateType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;
use Symfony\Bridge\Doctrine\Form\Type\EntityType;



class CommandeType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('date_commande', DateTimeType::class, ['widget'=>'single_text'] )
            ->add('adresse_destination')
            ->add('CommandeE_c',EntityType::class,[
                'class'=>CommandeE::class,'choice_label'=>'id'
            ])
            ->add('CommandeM_c',EntityType::class,[
                'class'=>CommandeM::class,'choice_label'=>'id'
            ])
            ->add('commmandeT_c',EntityType::class,[
                'class'=>CommandeT::class,'choice_label'=>'id'
            ])
        ;
    }

    public function configureOptions(OptionsResolver $resolver): void
    {
        $resolver->setDefaults([
            'data_class' => Commande::class,
        ]);
    }
}
