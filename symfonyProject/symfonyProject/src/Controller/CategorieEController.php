<?php

namespace App\Controller;

use App\Entity\CategorieE;
use App\Form\CategorieEType;
use App\Repository\CategorieERepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/categorie/e")
 */
class CategorieEController extends AbstractController
{
    /**
     * @Route("/", name="categorie_e_index", methods={"GET"})
     */
    public function index(CategorieERepository $categorieERepository): Response
    {
        return $this->render('categorie_e/index.html.twig', [
            'categorie_es' => $categorieERepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="categorie_e_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $categorieE = new CategorieE();
        $form = $this->createForm(CategorieEType::class, $categorieE);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($categorieE);
            $entityManager->flush();

            return $this->redirectToRoute('categorie_e_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('categorie_e/new.html.twig', [
            'categorie_e' => $categorieE,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="categorie_e_show", methods={"GET"})
     */
    public function show(CategorieE $categorieE): Response
    {
        return $this->render('categorie_e/show.html.twig', [
            'categorie_e' => $categorieE,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="categorie_e_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, CategorieE $categorieE, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CategorieEType::class, $categorieE);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('categorie_e_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('categorie_e/edit.html.twig', [
            'categorie_e' => $categorieE,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="categorie_e_delete", methods={"POST"})
     */
    public function delete(Request $request, CategorieE $categorieE, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$categorieE->getId(), $request->request->get('_token'))) {
            $entityManager->remove($categorieE);
            $entityManager->flush();
        }

        return $this->redirectToRoute('categorie_e_index', [], Response::HTTP_SEE_OTHER);
    }
}
