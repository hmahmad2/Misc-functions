# I'm pretty sure I can do this by eliminating one of the
# for-loops, but right now, as a proof-of-concept, this is
# good, too. Just showing that I can do it, after so long

deck = []
suite = ["Spade", "Club", "Heart", "Diamond"]

for sort in suite
  (0..12).each do |i|
    card = sort
    if i == 0
      card += " Ace"
    elsif i > 0 && i < 10
      card += " " + (i + 1).to_s
    elsif i == 10
      card += " Jack"
    elsif i == 11
      card += " Queen"
    else
      card += " King"
    end
    deck.push(card)
  end
end

shuffle_deck = deck.shuffle
puts shuffle_deck.join("\n")
