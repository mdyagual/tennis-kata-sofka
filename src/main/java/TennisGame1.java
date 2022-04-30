
public class TennisGame1 implements TennisGame {
    
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            scoreP1 += 1;
        else
            scoreP2 += 1;
    }

    public String getScore() {
        String score = "";
        if (esEmpate())
        {
           score = puntajesIguales();
        }
        else if (esMayorA4())
        {
           score = puntajeMayor();
        }
        else
        {
            score=puntajes(scoreP1).concat("-").concat(puntajes(scoreP2));
        }
        return score;
    }

    //Booleanos
    private boolean esEmpate(){
        return scoreP1 == scoreP2;
    }

    private boolean esMayorA4(){
        return scoreP1 >= 4 || scoreP2 >=4;
    }

    //Switches
    private String puntajes(int puntaje){
        switch (puntaje){
            case 0: return "Love";
            case 1: return "Fifteen";
            case 2: return "Thirty";
            default: return "Forty";
        }
    }

    private String puntajesIguales(){
        switch (scoreP1){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    //Messages
    private String ventajaEnPuntos(int puntos){
        return puntos == 1 ? "Advantage ".concat(player1Name) : "Advantage ".concat(player2Name);
    }

    private String ganadorPuntos(int puntos){
        return puntos >= 2 ? "Win for ".concat(player1Name) : "Win for ".concat(player2Name);
    }

    private String puntajeMayor(){
        int puntos = scoreP1-scoreP2;
        switch (puntos){
            case 1: case -1: return ventajaEnPuntos(puntos);
            default: return ganadorPuntos(puntos);
        }
    }

    private String nombreJugador(){
        return  scoreP1> scoreP2 ? player1Name : player2Name;
    }

}
