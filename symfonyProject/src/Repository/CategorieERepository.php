<?php

namespace App\Repository;

use App\Entity\CategorieE;
use Doctrine\Bundle\DoctrineBundle\Repository\ServiceEntityRepository;
use Doctrine\Persistence\ManagerRegistry;

/**
 * @method CategorieE|null find($id, $lockMode = null, $lockVersion = null)
 * @method CategorieE|null findOneBy(array $criteria, array $orderBy = null)
 * @method CategorieE[]    findAll()
 * @method CategorieE[]    findBy(array $criteria, array $orderBy = null, $limit = null, $offset = null)
 */
class CategorieERepository extends ServiceEntityRepository
{
    public function __construct(ManagerRegistry $registry)
    {
        parent::__construct($registry, CategorieE::class);
    }

    // /**
    //  * @return CategorieE[] Returns an array of CategorieE objects
    //  */
    /*
    public function findByExampleField($value)
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->orderBy('c.id', 'ASC')
            ->setMaxResults(10)
            ->getQuery()
            ->getResult()
        ;
    }
    */

    /*
    public function findOneBySomeField($value): ?CategorieE
    {
        return $this->createQueryBuilder('c')
            ->andWhere('c.exampleField = :val')
            ->setParameter('val', $value)
            ->getQuery()
            ->getOneOrNullResult()
        ;
    }
    */
}
