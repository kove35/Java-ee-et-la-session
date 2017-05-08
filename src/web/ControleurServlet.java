package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.MetierJeu;

//Test commint
//@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {

    private MetierJeu metier;
    private String    gagnant;

    @Override
    public void init() throws ServletException {
        metier = new MetierJeu();
        metier.genererSecret();
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {

        request.getRequestDispatcher( "vueJeu.jsp" ).forward( request, response );
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelJeu model;

        if ( session.getAttribute( "model" ) == null ) {
            model = new ModelJeu();
            session.setAttribute( "model", model );
        } else {
            model = (ModelJeu) session.getAttribute( "model" );
        }

        if ( request.getParameter( "action" ).equals( "Rejouer" ) ) {
            metier.genererSecret();
            metier.setFin( false );
            model.setNombre( 0 );
            model.getHistorique().clear();

        } else {

            int nombre = Integer.parseInt( request.getParameter( "nombreDevinez" ) );
            model.setNombre( nombre );
            String resultatMetier = metier.jouer( nombre );
            if ( resultatMetier.indexOf( "Bravo" ) >= 0 ) {
                gagnant = request.getRemoteAddr();
            }
            if ( resultatMetier.indexOf( "Le jeu est terminé" ) >= 0 ) {
                resultatMetier = resultatMetier + " ,le gagnant est :" + gagnant;
            }

            model.getHistorique().add( resultatMetier );
        }

        request.getRequestDispatcher( "vueJeu.jsp" ).forward( request, response );
    }

}
