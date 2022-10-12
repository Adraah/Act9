import java.util.ArrayList;
import java.util.Random;

public class CardsDeck {
    private ArrayList<Card> mCards;
    private ArrayList<Card> mPulledCards;
    private ArrayList<Card> mHandCards;
    private Random mRandom;

    public enum Suit {
        ESPADAS,
        CORAZONES,
        DIAMANTES,
        PICAS;
    }

    public enum Rank {
        DOS,
        TRES,
        CUATRO,
        CINCO,
        SEIS,
        SIETE,
        OCHO,
        NUEVE,
        DIEZ,
        JOTA,
        REINA,
        REY,
        AZ;
    }

    public CardsDeck() {
        mRandom = new Random();
        mPulledCards = new ArrayList<Card>();
        mHandCards = new ArrayList<Card>();
        mCards = new ArrayList<Card>(Suit.values().length * Rank.values().length);
        reset();
    }

    public void reset() {
        mPulledCards.clear();
        mHandCards.clear();
        mCards.clear();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                Card c = new Card(s, r);
                mCards.add(c);
            }
        }
    }


    public static class Card {

        private Suit mSuit;
        private Rank mRank;

        public Card(Suit suit, Rank rank) {
            this.mSuit = suit;
            this.mRank = rank;
        }

        public Suit getSuit() {
            return mSuit;
        }

        public Rank getRank() {
            return mRank;
        }

        public int getValue() {
            return mRank.ordinal() + 2;
        }

        @Override
        public boolean equals(Object o) {
            return (o != null && o instanceof Card && ((Card) o).mRank == mRank && ((Card) o).mSuit == mSuit);
        }

        @Override
        public String toString() {
            return ("Palo:"+this.getSuit() +
                    " Valor:"+ this.getRank());
        }
    }

    public String pullRandom() {
        if (mCards.isEmpty())
            return null;

        Card res = mCards.remove(randInt(0, mCards.size() - 1));
        if (res != null)
            mPulledCards.add(res);
        return res.toString();
    }

    public void cardsLeft(){
        System.out.println("Quedan "+mCards.size()+" cartas");
    }

    public ArrayList<Card> hand() {
        if (mCards.isEmpty())
            return null;

        for (int i=0;i<5;i++){
            Card res = mCards.remove(randInt(0, mCards.size() - 1));
            if (res != null)
                mHandCards.add(res);
        }
        return mHandCards;
    }

    public String getFirst() {
        if (mCards.isEmpty())
            return null;

        Card res = mCards.remove(0);
        if (res != null)
            mPulledCards.add(res);
        return res.toString();
    }

    public int randInt(int min, int max) {
        int randomNum = mRandom.nextInt((max - min) + 1) + min;
        return randomNum;
    }


    public boolean isEmpty(){
        return mCards.isEmpty();
    }
}