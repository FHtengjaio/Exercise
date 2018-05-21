package cn.com.PokerDemo;

import java.util.LinkedHashSet;

public class PlayPoker {
    public static void main(String[] args) {
        Poker poker = new Poker();
        Poker.Card[] cards = poker.shuffle();
        for(Poker.Card card: cards){
            System.out.print(card+" ");
        }
        System.out.println();
        LinkedHashSet<Poker.Card> player1 = new LinkedHashSet<>();
        LinkedHashSet<Poker.Card> player2 = new LinkedHashSet<>();
        LinkedHashSet<Poker.Card> player3 = new LinkedHashSet<>();
        for(int i=0; i<cards.length; i++){
            int remainder = i % 3;
            switch (remainder){
                case 0:
                    player1.add(cards[i]);
                    break;
                case 1:
                    player2.add(cards[i]);
                    break;
                case 2:
                    player3.add(cards[i]);
                    break;
                default:
                    throw new RuntimeException("发牌失败");
            }
        }
        System.out.println("玩家1的手牌是:");
        player1.forEach((card)-> System.out.print(card+" "));
        System.out.println();
        System.out.println("玩家2的手牌是:");
        player2.forEach((card)-> System.out.print(card+" "));
        System.out.println();
        System.out.println("玩家3的手牌是:");
        player3.forEach((card)-> System.out.print(card+" "));
    }
}
