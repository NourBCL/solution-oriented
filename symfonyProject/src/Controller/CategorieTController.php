<?php

namespace App\Controller;

use App\Entity\CategorieT;
use App\Form\CategorieTType;
use App\Repository\CategorieTRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/categorie/t")
 */
class CategorieTController extends AbstractController
{
    /**
     * @Route("/", name="categorie_t_index", methods={"GET"})
     */
    public function index(CategorieTRepository $categorieTRepository): Response
    {
        return $this->render('categorie_t/index.html.twig', [
            'categorie_ts' => $categorieTRepository->findAll(),
        ]);
    }

    /**
     * @Route("/new", name="categorie_t_new", methods={"GET", "POST"})
     */
    public function new(Request $request, EntityManagerInterface $entityManager): Response
    {
        $categorieT = new CategorieT();
        $form = $this->createForm(CategorieTType::class, $categorieT);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->persist($categorieT);
            $entityManager->flush();

            return $this->redirectToRoute('categorie_t_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('categorie_t/new.html.twig', [
            'categorie_t' => $categorieT,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="categorie_t_show", methods={"GET"})
     */
    public function show(CategorieT $categorieT): Response
    {
        return $this->render('categorie_t/show.html.twig', [
            'categorie_t' => $categorieT,
        ]);
    }

    /**
     * @Route("/{id}/edit", name="categorie_t_edit", methods={"GET", "POST"})
     */
    public function edit(Request $request, CategorieT $categorieT, EntityManagerInterface $entityManager): Response
    {
        $form = $this->createForm(CategorieTType::class, $categorieT);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();

            return $this->redirectToRoute('categorie_t_index', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('categorie_t/edit.html.twig', [
            'categorie_t' => $categorieT,
            'form' => $form->createView(),
        ]);
    }

    /**
     * @Route("/{id}", name="categorie_t_delete", methods={"POST"})
     */
    public function delete(Request $request, CategorieT $categorieT, EntityManagerInterface $entityManager): Response
    {
        if ($this->isCsrfTokenValid('delete'.$categorieT->getId(), $request->request->get('_token'))) {
            $entityManager->remove($categorieT);
            $entityManager->flush();
        }

        return $this->redirectToRoute('categorie_t_index', [], Response::HTTP_SEE_OTHER);
    }
}
