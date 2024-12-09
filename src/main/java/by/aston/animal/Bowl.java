package by.aston.animal;

public class Bowl {

    private int size;
    private int amount;

    public Bowl(int size, int amountFood) {
        this.size = size;
        amount = size <= amountFood ? size : amountFood;
    }

    public void addFood(int amountFood) {
        if (amountFood > 0) {
            amount = size > amount + amountFood ? amount + amountFood : size;
        }
    }

    public int getFood(int amountFood) {
        if (amount >= amountFood) {
            amount -= amountFood;
            return amountFood;
        } else {
            return 0;
        }
    }

    public int getAmount() {
        return amount;
    }
}
