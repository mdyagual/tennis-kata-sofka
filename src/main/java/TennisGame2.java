
public class TennisGame2 implements TennisGame
{
    public int p1Point = 0;
    public int p2Point = 0;
    
    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
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
            score=puntajes(p1Point).concat("-").concat(puntajes(p2Point));
        }
        return score;
    }

    public void wonPoint(String player) {
        if (player.equals(this.player1Name))
            p1Point++;
        else
            p2Point++;
    }

    //Messages
    private String ventajaEnPuntos(int puntos){
        return puntos == 1 ? "Advantage ".concat(player1Name) : "Advantage ".concat(player2Name);
    }

    private String ganadorPuntos(int puntos){
        return puntos >= 2 ? "Win for ".concat(player1Name) : "Win for ".concat(player2Name);
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
        switch (p1Point){
            case 0: return "Love-All";
            case 1: return "Fifteen-All";
            case 2: return "Thirty-All";
            default: return "Deuce";
        }
    }

    //Booleanos
    private boolean esEmpate(){
        return p1Point == p2Point;
    }

    private boolean esMayorA4(){
        return p1Point >= 4 || p2Point >=4;
    }

    private String puntajeMayor(){
        int puntos = p1Point-p2Point;
        switch (puntos){
            case 1: case -1: return ventajaEnPuntos(puntos);
            default: return ganadorPuntos(puntos);
        }
    }
}