<?php

namespace App\Controller;

use App\Entity\Transport;
use App\Form\TransportType;
use App\Repository\TransportRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Method;


class TransportController extends AbstractController
{
    /**
     * @Route("/transport", name="transport")
     */
    public function index(): Response
    {
        return $this->render('transport/index.html.twig', [
            'transports_name' => 'TransportRepository',
        ]);
    }
    /**
     *
     * @Route("/add", name="addTransport")
     */
    public function addTransport (Request $request)
    {
        $transport = new Transport();
        $form = $this->createForm(TransportType::class, $transport);
        $form->add('ajouter',SubmitType::class);
        $form->handleRequest($request);
        if($form->isSubmitted()&& $form->isValid())
        {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->persist($transport);
            $entityManager->flush();
            return $this->redirectToRoute('afficheS');
        }
        return $this->render('transport/_form.html.twig',['form' => $form->createView()]);
    }

    /**
     * @param TransportRepository $rep
     * @Route("/transport/edit/{id}", name="edittransport")

     */

    public function edit ($id,TransportRepository $rep, Request $request)
    {
        $transport = $rep->find($id);
        $form = $this->createForm(TransportType::class, $transport);
        $form->add('edit',SubmitType::class);
        $form->handleRequest($request);
        if($form->isSubmitted()&& $form->isValid())
        {
            $entityManager = $this->getDoctrine()->getManager();
            $entityManager->flush();
            $this->addFlash('success', 'transport a été updates');
            return $this->redirectToRoute('afficheS');
        }
        return $this->render('transport/edit.html.twig',['form' => $form->createView()]);
    }
    /**
     * @param TransportRepository $rep
     * @return Response
     * @Route("/transportshow", name="afficheS")
     */
    public function Afficher(TransportRepository $rep):Response
    {

        $transports= $this->getDoctrine()->getRepository(Transport::class)->findAll();
        return $this->render('transport/show.html.twig',[
            'transports'=>$transports
        ]);

    }

    /**
     * @Route("/transportd/{id}", name="transportd") * @Method({"DELETE"})
     */
    public function delete(Request $request, $id)
    {
        $transport = $this->getDoctrine()->getRepository(Transport::class)->findOneById($id);
        $entityManager = $this->getDoctrine()->getManager();
        $entityManager->remove($transport);
        $entityManager->flush();
        return $this->redirectToRoute('afficheS');
    }


}



