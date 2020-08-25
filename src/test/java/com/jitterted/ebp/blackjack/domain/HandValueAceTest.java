package com.jitterted.ebp.blackjack.domain;

import com.jitterted.ebp.blackjack.Card;
import com.jitterted.ebp.blackjack.Game;
import com.jitterted.ebp.blackjack.Suit;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {
  private static final Suit DONT_CARE_ABOUT_SUIT = Suit.HEART;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Game game = new Game();
    List<Card> hand = new ArrayList<>();
    hand.add(new Card(DONT_CARE_ABOUT_SUIT, "A"));
    hand.add(new Card(DONT_CARE_ABOUT_SUIT, "5"));

    assertThat(game.handValueOf(hand))
        .isEqualTo(11 + 5);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Game game = new Game();
    List<Card> hand = new ArrayList<>();
    hand.add(new Card(DONT_CARE_ABOUT_SUIT, "A"));
    hand.add(new Card(DONT_CARE_ABOUT_SUIT, "8"));
    hand.add(new Card(DONT_CARE_ABOUT_SUIT, "3"));

    assertThat(game.handValueOf(hand))
        .isEqualTo(1 + 8 + 3);
  }

}
