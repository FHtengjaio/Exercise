package cn.com.PokerDemo;


import java.util.Objects;
import java.util.Random;

public class Poker {
    private static final String[] SUITES = {"黑桃", "红桃", "草花", "方块"};
    private static final String[] FACES = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
    private Card[] cards;
    private Random random;

    public Poker(){
        this.random = new Random();
        cards = new Card[54];
        for (int i=0; i<SUITES.length; i++){
            for(int j=0;j<FACES.length;j++){
                cards[i*13+j] = new Card(SUITES[i],FACES[j]);
            }

        }
        cards[52] = new Card("小","王");
        cards[53] = new Card("大","王");
    }

    public Card[] shuffle(){
        int index;
        Card temp;
        for(int i=0; i<cards.length;i++){
            index = random.nextInt(cards.length);
            temp = cards[index];
            cards[index] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }

    public Card deal(int index){
        return cards[index];
    }

    public static class Card implements Comparable<Card>{
        private String suite;
        private String face;

        public Card(String suite, String face){
            this.suite = suite;
            this.face = face;
        }

        @Override
        public int compareTo(Card o) {
            int num = this.face.compareTo(o.face);
            if(num==0){
                return this.suite.compareTo(o.suite);
            }
            return num;
        }

        @Override
        public String toString() {
            return suite+face;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Card card = (Card) o;
            return Objects.equals(suite, card.suite) &&
                    Objects.equals(face, card.face);
        }

        @Override
        public int hashCode() {

            return Objects.hash(suite, face);
        }
    }
}
