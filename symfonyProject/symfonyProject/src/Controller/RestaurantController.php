<?php

namespace App\Controller;

use App\Entity\Restaurant;
use App\Form\RestaurantType;
use App\Repository\RestaurantRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Validator\Constraints\File;
use Symfony\Component\Form\Extension\Core\Type\FileType;
use Symfony\Component\HttpFoundation\File\Exception\FileException;
use Dompdf\Dompdf;
use Dompdf\Options;

/**
 * @Route("/restaurant")
 */
class RestaurantController extends AbstractController
{
    /**
     * @Route("/", name="restaurant_index", methods={"GET"})
     */
    public function showBack(RestaurantRepository $restaurantRepository): Response
    {
        return $this->render('restaurant/show_back.html.twig', [
            'restaurants' => $restaurantRepository->findAll(),
        ]);
    }

    /**
     * @Route("/user", name="restaurant_index_front", methods={"GET"})
     */
    public function showFront(RestaurantRepository $restaurantRepository): Response
    {
        return $this->render('restaurant/show_front.html.twig', [
            'restaurants' => $restaurantRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="restaurant_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $restaurant = new Restaurant();
        $form = $this->createForm(RestaurantType::class, $restaurant);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $image = $form->get('image')->getData();

            if ($image) {
                $newFilename = uniqid().'.'.$image->guessExtension();

                try {
                    $image->move(
                        $this->getParameter('image_restaurant'),
                        $newFilename
                    );
                } catch (FileException $e) {
                }

                $restaurant->setImage($newFilename);
            }
            $entityManager->persist($restaurant);
            $entityManager->flush();

            return $this->redirectToRoute('restaurant_index');
        }

        return $this->render('restaurant/new.html.twig', [
            'restaurant' => $restaurant,
            'form' => $form->createView(),
        ]);
    }

    // /**
    //  * @Route("/{id}", name="restaurant_show", methods={"GET"})
    //  */
    // public function show(Restaurant $restaurant): Response
    // {
    //     return $this->render('restaurant/show.html.twig', [
    //         'restaurant' => $restaurant,
    //     ]);
    // }

    /**
     * @Route("/{id}/edit", name="restaurant_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, Restaurant $restaurant, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(RestaurantType::class, $restaurant)
        ->add('image', FileType::class, [
            'mapped' => false,

            'constraints' => [
                new File([
                    'mimeTypes' => [
                        'image/*',
                    ],
                    'mimeTypesMessage' => 'vérifier votre fichier',
                ])
            ],
        ]);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $image = $form->get('image')->getData();

            if ($image) {
                $newFilename = uniqid().'.'.$image->guessExtension();

                try {
                    $image->move(
                        $this->getParameter('image_restaurant'),
                        $newFilename
                    );
                } catch (FileException $e) {
                }

                $restaurant->setImage($newFilename);
            }
            $entityManager->flush();

            return $this->redirectToRoute('restaurant_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('restaurant/edit.html.twig', [
            'image' => $restaurant->getImage(),
            'restaurant' => $restaurant,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/delete/{id}", name="restaurant_delete")
     */
    public function delete($id, Request $req): Response
    {

        $entityManager = $this->getDoctrine()->getManager();
        $restaurantRepository = $this->getDoctrine()->getRepository(Restaurant::class);
        $restaurant = $restaurantRepository->find($id);
        $entityManager->remove($restaurant);
        $entityManager->flush();

        return $this->redirectToRoute('restaurant_index', [], Response::HTTP_SEE_OTHER);
    }
}
