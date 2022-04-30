
public class TennisGame3 implements TennisGame {

    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private String player1Name;
    private String player2Name;


    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (esMenorQue4())
            return menorQue4();
        else if (esEmpate())
            return "Deuce";
        else{
            return mayorQue4();
        }
    }

    //Booleans
    private boolean esEmpate(){
        return scoreP1 == scoreP2;
    }

    private boolean esMenorQue4() {
        return ambosPuntosMayorQue4() && sumaDiferentDe6();
    }

    private boolean sumaDiferentDe6() {
        return scoreP1 + scoreP2 != 6;
    }

    private boolean ambosPuntosMayorQue4() {
        return scoreP1 < 4 && scoreP2 < 4;
    }

    private String nombreJugador() {
        return  scoreP1 > scoreP2 ? player1Name : player2Name;
    }

    private String mayorQue4() {
        return ventajaOGanador() ? "Advantage " + nombreJugador() : "Win for " + nombreJugador();
    }

    private boolean ventajaOGanador() {
        return (scoreP1 - scoreP2)*(scoreP1 - scoreP2) == 1;
    }

    //Switches
    private String menorQue4(){
        String punto;
        String [] puntos = {"Love", "Fifteen", "Thirty", "Forty"};
        punto = puntos[scoreP1];
        return (esEmpate() ? punto+"-All":punto+"-"+puntos[scoreP2]);
    }


    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            this.scoreP1+= 1;
        else
            this.scoreP2 += 1;
        
    }

}
