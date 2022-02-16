<?php

namespace App\Controller;

use App\Entity\Commande;
use App\Form\CommandeType;
use App\Repository\CommandeRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

/**
 * @Route("/commande")
 */
class CommandeController extends AbstractController
{
    /**
     * @return Response
     * @Route("/list_commande",name="index_c")
     */

    public function index(CommandeRepository $commandeRepository): Response
    {$list_commande = $commandeRepository->findAll();
        return $this->render('commande/index.html.twig',[ 'commandes' => $list_commande,
        ]);

    }

    /**
     * @param Request $req
     * @param EntityManagerInterface $entityManager
     * @return Response
     * @Route ("/add_commande",name="add_c")
     */
    public function add_commande (Request $req): Response
{
    $command = new Commande();
    $form = $this->createForm(CommandeType::class, $command);
    $form->add('ajouter',SubmitType::class);
    $form->handleRequest($req);

    if ($form->isSubmitted() && $form->isValid()) {
        $entityManager= $this->getDoctrine()->getManager();
        $entityManager->persist($command);
        $entityManager->flush();
        $this->addFlash('success','commande à été crée');

        return $this->redirectToRoute('index_c', [], Response::HTTP_SEE_OTHER);
    }

    return $this->render('commande/new.html.twig', [
        'commandes' => $command,
        'form' => $form->createView(),
    ]);
}

    /**
     * @param Commande $commande
     * @return Response
     * @Route("/{id}", name="show_c", methods={"GET"})
     */
    public function show(Commande $commande): Response
    {
        return $this->render('commande/show.html.twig', [
            'commande' => $commande,
        ]);
    }

    /**
     * @param Request $request
     * @param EntityManagerInterface $entityManager
     * @return Response
     * @Route("/{id}/edit", name="edit_c", methods={"GET", "POST"})
     */


    public function edit(Request $request, Commande $commande, EntityManagerInterface $entityManager,CommandeRepository $rep): Response
    {
        $com=$rep->findBy($commande);
        $form = $this->createForm(CommandeType::class, $com);
        $form->add('edit',SubmitType::class);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $entityManager->flush();
            $this->addFlash('success', 'Commande été updates');

            return $this->redirectToRoute('index_c', [], Response::HTTP_SEE_OTHER);
        }

        return $this->render('commande/edit.html.twig', ['commande' => $com, 'form' => $form->createView(),]);
    }


}
