<?php

namespace App\Controller;

use App\Entity\Region;

use App\Form\RegionType;
use App\Form\RestaurantType;
use App\Repository\RegionRepository;
use Doctrine\ORM\EntityManagerInterface;





use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\File\Exception\FileException;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;


class RegionController extends AbstractController
{


    /**
     * @Route("/afficherRegionAdmin",name="afficherregion")
     */
    public function afficherRegions(RegionRepository $repository){
        $regions=$repository->findAll();
        return $this->render('region/afficherRegion.html.twig'
            ,['tableregions'=>$regions]);

    }
    /**
     * @Route("/afficheruserregion",name="afficherregionUser")
     */
    public function afficherRegionsUser(RegionRepository $repository){
        $regions=$repository->findAll();
        return $this->render('region/afficherregionsUser.html.twig'
            ,['tableregions'=>$regions]);

    }

    /**
     * @Route("/supprimer/{id}", name="supprimerregion")
     */
    public function delete($id, Request $req): Response
    {

        $entityManager = $this->getDoctrine()->getManager();
        $repo = $this->getDoctrine()->getRepository(Region::class);
        $region = $repo->find($id);
        $entityManager->remove($region);
        $entityManager->flush();

        return $this->redirectToRoute('afficherregion', [], Response::HTTP_SEE_OTHER);
    }


    /**
     * @Route("/ajouterregion", name="ajouterregion", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $region = new Region();
        $form = $this->createForm(RegionType::class, $region);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

                $new=$form->getData();
                $imageFile = $form->get('image')->getData();
                if ($imageFile) {
                    $originalFilename = pathinfo($imageFile->getClientOriginalName(), PATHINFO_FILENAME);
                    $newFilename = $originalFilename.'-'.uniqid().'.'.$imageFile->guessExtension();
                    try {
                        $imageFile->move(
                            'uploads\region',
                            $newFilename
                        );
                    } catch (FileException $e) {
                    }
                    $region->setImage($newFilename);
                }
            $entityManager->persist($region);
            $entityManager->flush();

            return $this->redirectToRoute('afficherregion');
        }

        return $this->render('region/ajouterregion.html.twig', [
            'region' => $region,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/region/{id}",name="get_restaurants")
     */

    public function getCategorieById (RegionRepository $repository, Request $request)
    {
        $id = $request->get('id');

        $region = $repository->findOneBy(['id' => $id]);




        return $this->render("region/listerestaurants.html.twig",['region' => $region]) ;

    }
    /**
     * @Route("/{id}/modifierregion", name="modifierregion", methods={"GET", "POST"})
     */
    public function modifierRegion(Request $request, Region $region, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(RegionType::class, $region);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {

            $imageFile = $form->get('image')->getData();
            if ($imageFile) {
                $originalFilename = pathinfo($imageFile->getClientOriginalName(), PATHINFO_FILENAME);
                $newFilename = $originalFilename.'-'.uniqid().'.'.$imageFile->guessExtension();
                try {
                    $imageFile->move(
                        'uploads\region',
                        $newFilename
                    );
                } catch (FileException $e) {
                }
                $region->setImage($newFilename);
            }
            $entityManager->flush();

            return $this->redirectToRoute('afficherregion', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('region/modifierRegion.html.twig', [
            'image' => $region->getImage(),
            'region' => $region,
            'form' => $form->createView(),

        ]);
    }




}
